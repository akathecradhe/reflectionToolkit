package com.nsa.group6.config;

import com.nsa.group6.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Worked on by Clive, Tom
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/css/*.css", "/images/*.jpg" ,"/static.js/*.js","/logout","/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login")
                .permitAll();

//        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.headers().contentSecurityPolicy("script-src 'self' https://code.jquery.com/jquery-3.5.1.slim.min.js " +
                "https://kit.fontawesome.com/9b9fc493c6.js https://code.jquery.com/jquery-3.3.1.min.js " +
                "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js " +
                "https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js " +
                "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js " +
                "https://cdn.jsdelivr.net/npm/chart.js@2.8.0 " +
                "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js " +
                "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js; ");
        http
                .headers()
                .httpStrictTransportSecurity()
                .includeSubDomains(true)
                .maxAgeInSeconds(31536000);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

