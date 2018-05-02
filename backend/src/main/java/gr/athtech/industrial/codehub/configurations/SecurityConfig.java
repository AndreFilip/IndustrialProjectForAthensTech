package gr.athtech.industrial.codehub.configurations;

import gr.athtech.industrial.codehub.services.CodeHubUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author George Lalas
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private CodeHubUserDetailsService codeHubUserDetailsService;

        //TODO: REVIEW WHEN FRONT-END WILL BE ADDED
        @Override
        public void configure(WebSecurity web) throws Exception {
            web.ignoring()
                    .antMatchers("/css/**", "/js/**", "/img/**", "/fonts/**", "/external/**");
        }

        //TODO: REVIEW PATHS WHEN FRONT-END WILL BE ADDED
        @Override
        protected void configure(HttpSecurity httpSecurity) throws Exception {
            httpSecurity
                    .httpBasic()
                    .and()
                    .authorizeRequests()
                    .antMatchers("/index.html", "/", "/home", "/login").permitAll()
                    .anyRequest().permitAll();
//            httpSecurity
//                    .authorizeRequests()
//                    .antMatchers("/register/**", "/forgotPassword").permitAll()
//                    .antMatchers("/views/admin.html").access("hasAuthority('admin')")
//                    .antMatchers("/views/opadmin.html").access("hasAuthority('opadmin')")
//                    .antMatchers("/views/dealer.html").access("hasAuthority('user')")
//                    .anyRequest().authenticated()
//                    .and()
//                    .formLogin()
//                    .loginPage("/index.html")
//                    .permitAll()
//                    //TODO SUCCESSHANDLER ?
//                    //.successHandler(customSuccessHandler)
//                    .failureUrl("/index.html?error")
//                    .and()
//                    .logout()
//                    .logoutSuccessUrl("/index.html?logout")
//                    .permitAll()
//                    .and()
//                    //TODO FAILURE HANDLERS?
//                    //.exceptionHandling().accessDeniedHandler(accessDeniedHandler)
//                    //.and() //TODO ADD CSRF PROTECTION
//                    .csrf().disable();
        }

        protected void configure(AuthenticationManagerBuilder auth) {
            auth.authenticationProvider(authenticationProvider());
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        public DaoAuthenticationProvider authenticationProvider() {
            DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
            daoAuthenticationProvider.setUserDetailsService(codeHubUserDetailsService);
            daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
            return daoAuthenticationProvider;
        }

}
