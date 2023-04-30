/*package com.example.icare.security.config;

import com.example.icare.security.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


      @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/users").hasRole("ADMIN")
                .anyRequest().permitAll()
                .and()
                .httpBasic(); 
                }




                @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> {
            String password = new String(Base64.getDecoder().decode(username)).split(":")[1];
            String decodedUsername = new String(Base64.getDecoder().decode(username)).split(":")[0];
            if (userService.isAdminAuthenticated(decodedUsername, password)) {
                return new User(decodedUsername, password, new ArrayList<>());
            } else {
                throw new UsernameNotFoundException("Admin not found with username: " + decodedUsername);
            }
        });
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Other security configurations
}
*/