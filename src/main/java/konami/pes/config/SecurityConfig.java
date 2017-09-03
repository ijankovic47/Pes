package konami.pes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import konami.pes.servicesImpl.OperatorServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailsService operatorServiceImpl;
	
	//default, zato se pojavljuje predefinisana strana za logovanje
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
//		.antMatchers("/match").access("hasRole('SUPERADMIN')")
		.anyRequest().authenticated()
//		.and()
//		.requiresChannel()
//		.antMatchers("/player/saveOrUpdatePlayer").requiresSecure()      prebacivanje na https (ne radi)
		.and()
		.formLogin().loginPage("/login")
		.defaultSuccessUrl("/")
		.failureUrl("/login?error")
		.usernameParameter("username").passwordParameter("password").permitAll()
		.and()
		.logout().logoutSuccessUrl("/login")
//		.and()
//		.rememberMe()
//		.tokenValiditySeconds(2419200)
//		.key("pesKey")
		.and()
		.httpBasic();
		http.csrf().disable();
		}
	
	//Inmemory primer
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		auth
//		.inMemoryAuthentication()
//		.withUser("igor").password("password").roles("USER").and()
//		.withUser("ivan").password("password").roles("USER", "ADMIN");
//	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(operatorServiceImpl);
		auth.authenticationProvider(authenticationProvider());
	}
	@Bean
	public DaoAuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(operatorServiceImpl);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	@Bean
	public Md5PasswordEncoder passwordEncoder(){
		Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		return passwordEncoder;
	}
}
