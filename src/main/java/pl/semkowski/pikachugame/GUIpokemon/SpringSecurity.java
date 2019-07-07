package pl.semkowski.pikachugame.GUIpokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;



@Configuration
public class SpringSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource  dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder  authenticationManagerMgr ) throws  Exception{
      authenticationManagerMgr
              .jdbcAuthentication()
              .dataSource(dataSource)
              .passwordEncoder(new BCryptPasswordEncoder())
              .usersByUsernameQuery("SELECT username,password,enabled,pokemon_id,email FROM  users  WHERE username = ? ")
              .authoritiesByUsernameQuery("SELECT username,authority FROM authorities WHERE username = ?");

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .antMatchers("/home")
                .hasRole("PLAYER")
                .and()
               .formLogin()
                .usernameParameter("username")
                .defaultSuccessUrl("/home")
                .and()
                .logout();




    }





}
