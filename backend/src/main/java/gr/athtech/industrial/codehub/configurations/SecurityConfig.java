//package gr.athtech.industrial.codehub.configurations;
//
//import gr.athtech.industrial.codehub.services.CodeHubUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
///**
// *
// * @author George Lalas
// */
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private CodeHubUserDetailsService codeHubUserDetailsService;
//
//
//        //TODO: REVIEW WHEN FRONT-END WILL BE ADDED
//        @Override
//        public void configure(WebSecurity web) throws Exception {
//            web.ignoring()
//                    .antMatchers("/css/**", "/js/**", "/img/**", "/fonts/**", "/api/**");
//        }
//
//    // This method is used for override HttpSecurity of the web Application.
//    // We can specify our authorization criteria inside this method.
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.cors().and()
////                // starts authorizing configurations
////                .authorizeRequests()
////                // ignoring the guest's urls "
////                .antMatchers("/api/userService/login","/api/userService/register","/logout").permitAll()
////                // authenticate all remaining URLS
////                .anyRequest().fullyAuthenticated().and()
////                /* "/logout" will log the user out by invalidating the HTTP Session,
////                 * cleaning up any {link rememberMe()} authentication that was configured, */
////                .logout()
////                .permitAll()
////                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
////                .and()
////                // enabling the basic authentication
////                .httpBasic().and()
////                // configuring the session on the server
////                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).and()
////                // disabling the CSRF - Cross Site Request Forgery
////                .csrf().disable();
////    }
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.csrf().disable().authorizeRequests()
////                .antMatchers("/").permitAll()
////                .antMatchers(HttpMethod.POST, "/login").permitAll()
////                .anyRequest().authenticated()
////                .and()
////                // We filter the api/login requests
////                .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
////                        UsernamePasswordAuthenticationFilter.class)
////                // And filter other requests to check the presence of JWT in header
////                .addFilterBefore(new JWTAuthenticationFilter(),
////                        UsernamePasswordAuthenticationFilter.class);
////    }
////
//        //TODO: REVIEW PATHS WHEN FRONT-END WILL BE ADDED
//        @Override
//        protected void configure(HttpSecurity httpSecurity) throws Exception {
//            httpSecurity
//                    .httpBasic()
//                    .and()
//                    .authorizeRequests()
//                    .antMatchers("/index.html", "/", "/home", "/login", "/api/userService/login","/api/userService/register","/logout").permitAll()
//                    .anyRequest().authenticated()
//                    .and()
//                    .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
////                    .anyRequest().permitAll();
//        }
//
//        protected void configure(AuthenticationManagerBuilder auth) {
//            auth.authenticationProvider(authenticationProvider());
//        }
//
//        @Bean
//        public PasswordEncoder passwordEncoder() {
//            return new BCryptPasswordEncoder();
//        }
//
//        @Bean
//        public DaoAuthenticationProvider authenticationProvider() {
//            DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//            daoAuthenticationProvider.setUserDetailsService(codeHubUserDetailsService);
//            daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//            return daoAuthenticationProvider;
//        }
//
//}
