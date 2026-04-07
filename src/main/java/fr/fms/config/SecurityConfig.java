package fr.fms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity // Enables method-level annotations like @PreAuthorize
public class SecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService(PasswordEncoder encoder) {

        // Regular user with USER role only
        UserDetails user = User.withUsername("Ejaz")
                .password(encoder.encode("123"))   // password: 123
                .roles("USER")                     // Roles assigned
                .build();

        // InMemoryUserDetailsManager stores the users
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF for simplicity (REST API scenario)
                .csrf(csrf -> csrf.disable())

                // Authorization rules
                .authorizeHttpRequests(auth -> auth
                		.antMatchers(HttpMethod.GET, "/index", "/contacts", "/logout").permitAll()
                        .antMatchers(HttpMethod.POST, "/index", "/contacts", "/logout").permitAll()
                        .anyRequest().authenticated())

                // Form login configuration
                .formLogin(form -> form
                        .defaultSuccessUrl("/index", true) // Redirect after login
                    )
                .logout(logout -> logout.logoutSuccessUrl("/index?logout"))

                // Enable HTTP Basic authentication as well
                .httpBasic();

        return http.build();
    }
}