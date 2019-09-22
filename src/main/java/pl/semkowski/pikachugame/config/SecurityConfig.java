package pl.semkowski.pikachugame.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService(){
      UserDetails userDetails = User.withDefaultPasswordEncoder()
              .username("player")
              .password("user1")
              .roles("PLAYER")
              .build();
      return new InMemoryUserDetailsManager(userDetails);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        .antMatchers("/sign_in","/")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and().formLogin()
                .successForwardUrl("/home")
                .permitAll();
    }
}
