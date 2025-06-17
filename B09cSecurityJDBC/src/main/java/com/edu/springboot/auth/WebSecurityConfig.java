package com.edu.springboot.auth;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
public class WebSecurityConfig
{
	@Autowired
	public MyAuthFailureHandler myAuthFailureHandler;
	
	
	@Bean
  public SecurityFilterChain filterChain(HttpSecurity http) 
         throws Exception
   {
      http.csrf((csrf) -> csrf.disable())
         .cors((cors) -> cors.disable())
         .authorizeHttpRequests((request) -> request
               .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
               .requestMatchers("/").permitAll()
               .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
               .requestMatchers("/guest/**").permitAll()
               .requestMatchers("/member/**").hasAnyRole("USER", "ADMIN")
               .requestMatchers("/admin/**").hasRole("ADMIN")
               .anyRequest().authenticated()
               );
      
      http.formLogin((formLogin) -> formLogin
    		  .loginPage("/myLogin.do")
    		  .loginProcessingUrl("/myLoginAction.do")
//    		  .failureUrl("/myError.do")
    		  .failureHandler(myAuthFailureHandler)
    		  .usernameParameter("my_id")
    		  .passwordParameter("my_pass")
    		  .permitAll());
      http.logout((logout) -> logout
    		  .logoutUrl("/myLogout.do")
    		  .logoutSuccessUrl("/")
    		  .permitAll());
      http.exceptionHandling((expHandling) -> expHandling
    		  .accessDeniedPage("/denied.do"));
      
      return http.build();
   }
   
   @Autowired
   private DataSource dateSource;
   
   @Autowired
   protected void configure(AuthenticationManagerBuilder auth)
   			throws Exception {
	   auth.jdbcAuthentication()
	   		.dataSource(dateSource)
	   		.usersByUsernameQuery("SELECT user_id, user_pw, enabled "
	   				+ " FROM security_admin WHERE user_id = ?")
	   		.authoritiesByUsernameQuery("SELECT user_id, authority "
	   				+ " FROM security_admin WHERE user_id = ?")
	   		.passwordEncoder(new BCryptPasswordEncoder());
	   
   }
}
