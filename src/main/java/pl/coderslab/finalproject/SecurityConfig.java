package pl.coderslab.finalproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/mainPage/**").authenticated()
                .antMatchers("/").authenticated()
                .antMatchers("/class/**").authenticated()
                .antMatchers("/teacher/**").authenticated()
                .antMatchers("/student/**").authenticated()
                .antMatchers("/subject/**").authenticated()
                .and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/").and().logout().logoutSuccessUrl("/")
                .permitAll().and().
                csrf().disable();
        return http.build();
    }
}