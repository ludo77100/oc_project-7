package org.ludo.clientui.security;

import org.ludo.clientui.service.impl.UtilisateurDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsService userDetailsService;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UtilisateurDetailsImpl();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws
            Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder);
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/","/login" ,"/index", "/css/**", "/cssLogin/**", "/fonts/**", "/fontsLogin/**", "/img/**", "/iconsLogin/**", "/js/**,","/jsLogin/**","/vendorLogin/**").permitAll()
                .antMatchers("/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login").defaultSuccessUrl("/")
                .loginProcessingUrl("/login")
                .failureUrl("/login")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/index")
                .invalidateHttpSession(true).deleteCookies("JSESSIONID");

    }

}