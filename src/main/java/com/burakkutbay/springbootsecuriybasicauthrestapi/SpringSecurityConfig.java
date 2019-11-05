package com.burakkutbay.springbootsecuriybasicauthrestapi;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       getHttp().httpBasic().and().authorizeRequests()
               .antMatchers("/user").hasAnyRole("USER")
               .antMatchers("/admin").hasAnyRole("ADMIN")
               .and()
               .csrf().disable();
    }

    public void configureGlobal(Aut)


}
