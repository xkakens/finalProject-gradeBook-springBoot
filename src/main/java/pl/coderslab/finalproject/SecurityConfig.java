package pl.coderslab.finalproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/mainPage/**").authenticated()
                .antMatchers("/").authenticated()
                .antMatchers("/class/**").hasAuthority("ADMIN")
                .antMatchers("/student/delete/**").hasAuthority("ADMIN")
                .antMatchers("/student/add").hasAuthority("ADMIN")
                .antMatchers("/student/update/**").hasAuthority("ADMIN")
                .antMatchers("/student/users/**").hasAnyAuthority("ADMIN")
                .antMatchers("/user/**").hasAuthority("ADMIN")
                .antMatchers("/subject/**").hasAuthority("ADMIN")
                .antMatchers("/mark/**").hasAnyAuthority("ADMIN","teacher")
                .and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/").and().logout().logoutSuccessUrl("/")
                .permitAll()
                .and().exceptionHandling().accessDeniedPage("/403")
                .and().csrf().disable();
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}