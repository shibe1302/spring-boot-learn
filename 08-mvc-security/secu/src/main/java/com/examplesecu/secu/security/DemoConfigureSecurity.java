package com.examplesecu.secu.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoConfigureSecurity {


    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
       JdbcUserDetailsManager jdbcUserDetailsManager=new JdbcUserDetailsManager(dataSource);
       jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT * FROM employee_directory.members where user_id=?");
       jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT * FROM employee_directory.roles where user_id=?");
       return jdbcUserDetailsManager;
    }
    

    // @Bean
    // public InMemoryUserDetailsManager userDetailsManager(){
    //     UserDetails john =User.builder().username("john").password("{noop}123456").roles("EMPLOYEE").build();
    //     UserDetails marry =User.builder().username("marry").password("{noop}123456").roles("EMPLOYEE","MANAGE").build();
    //     UserDetails susan =User.builder().username("susan")
    //     .password("{noop}123456")
    //     .roles("EMPLOYEE","MANAGE","ADMIN")
    //     .build();
    //     return new InMemoryUserDetailsManager(john,marry,susan);
    // }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(a->a
        .requestMatchers("/").hasRole("EMPLOYEE")
        .requestMatchers("/leader/**").hasRole("MANAGE")
        .requestMatchers("/systems/**").hasRole("ADMIN")
        .anyRequest().authenticated())
        .formLogin(form->form
        .loginPage("/showMyLoginPage")
        .loginProcessingUrl("/authenticateTheUser")
        .permitAll())
        .logout(lg->lg.permitAll())
        .exceptionHandling(a->a.accessDeniedPage("/access-denied"));
        return httpSecurity.build();
    }
}
