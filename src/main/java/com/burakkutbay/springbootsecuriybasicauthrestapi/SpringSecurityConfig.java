package com.burakkutbay.springbootsecuriybasicauthrestapi;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public void configureAuthGlobal(AuthenticationManagerBuilder auth){
        try {
            auth.inMemoryAuthentication()
                    .withUser("user").password("password").roles("USER")
                    .and()
                    .withUser("admin").password("password").roles("USER","ADMIN");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
