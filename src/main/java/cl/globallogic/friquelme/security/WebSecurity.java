package cl.globallogic.friquelme.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	public WebSecurity(UserDetailServiceImpl userDetailsService, PasswordEncoder passwordEncoder) {
//		this.userDetailsService = userDetailsService;
//		this.passwordEncoder = passwordEncoder;
//	}
//	
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable().authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/register/user").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
//                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    }
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//    }
//
//	 @Bean
//	 CorsConfigurationSource corsConfigurationSource() {
//	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	    source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//	    return source;
//	 }
	

 
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//		    .csrf().disable()
//		    .authorizeRequests()
//		    .antMatchers(HttpMethod.POST, "/register/user").permitAll()
//		    .anyRequest().authenticated()
//		    .and()
//		     // make sure we use stateless session; session won't be used to store user's state.
//		    .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager()))	
//	      //  .and()
//	            // handle an authorized attempts 
//	       //     .exceptionHandling().authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
//	        
//	        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		    // Add a filter to validate user credentials and add token in the response header
//			
//		    // What's the authenticationManager()? 
//		    // An object provided by WebSecurityConfigurerAdapter, used to authenticate the user passing user's credentials
//		    // The filter needs this auth manager to authenticate the user.
//		    
//		
//		    // allow all POST requests 
//		    
//		    // any other requests must be authenticated
//		    
//	}
	
//	  @Override
//	  protected void configure(HttpSecurity http) throws Exception {
//	    http.csrf().disable().authorizeRequests()
//	        .antMatchers("/").permitAll()
//	        .antMatchers(HttpMethod.POST, "/login").permitAll()
//	        .anyRequest().authenticated()
//	        .and()
//	        // We filter the api/login requests
//	        .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
//	                UsernamePasswordAuthenticationFilter.class)
//	        // And filter other requests to check the presence of JWT in header
//	        .addFilterBefore(new JWTAuthFilter(),
//	                UsernamePasswordAuthenticationFilter.class);
//	  }
//	  
//	  @Override
//	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	    // Create a default account
//	    auth.inMemoryAuthentication()
//	        .withUser("admin")
//	        .password("password")
//	        .roles("ADMIN");
//	  }
	
	// Spring has UserDetailsService interface, which can be overriden to provide our implementation for fetching user from database (or any other source).
	// The UserDetailsService object is used by the auth manager to load the user from database.
	// In addition, we need to define the password encoder also. So, auth manager can compare and verify passwords.
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
//	}
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }
}
