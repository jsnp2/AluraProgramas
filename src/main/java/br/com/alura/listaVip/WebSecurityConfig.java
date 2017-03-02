package br.com.alura.listaVip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.alura.listaVip.model.ConvidadoDAO;

@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private ConvidadoDAO convidadoDAO;

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").permitAll().and().logout().permitAll();

	}

	// public void configureGlobal(AuthenticationManagerBuilder auth) throws
	// Exception{
	// auth.inMemoryAuthentication().withUser("user").password("pass").roles("USER");
	// }
	//
	protected void configure(HttpSecurity http, WebSecurity web) throws Exception {
		http.authorizeRequests().antMatchers("/**").permitAll().antMatchers("/resources/**").hasAuthority("ADMIN")
				.anyRequest().authenticated().and().csrf().disable().formLogin().loginPage("/login")
				.failureUrl("/login?error=true").usernameParameter("user").passwordParameter("pass")
				.defaultSuccessUrl("/").and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/").and().exceptionHandling().accessDeniedPage("/access-denied");

		web.ignoring().antMatchers("/resources/** ,");

	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(convidadoDAO);

	}
}
