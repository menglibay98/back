package io.menglibay.realestateproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder) {
        UserDetails user = User
                .withUsername("user")
                .password(passwordEncoder.encode("almaty_2050"))
                .roles("USER")
                .build();

        UserDetails admin = User
                .withUsername("admin")
                .password(passwordEncoder.encode("kyzylorda_2050"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/user", "/request", "/room").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/user/byName/{name}", "/user/bySurname/{surname}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/user/byRole/{role}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/user/{id}", "/user/byRating/{rating}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/user/create", "/request/create").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/room/create").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/user/{id}", "/request/{id}", "/room/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/user/{id}", "/request/{id}", "/room/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/request/{id}", "/room/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/booking-history/{roomId}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/booking-history/book/{roomId}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/booking-history/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/booking-history/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/api/booking-history/{roomId}/setFree").hasRole("ADMIN")
        );


        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

}
