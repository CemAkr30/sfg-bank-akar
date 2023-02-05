package ca.springframework.sfgbankakar.jwt;

import ca.springframework.sfgbankakar.repositories.KullaniciGirisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {


    @Autowired
    private final KullaniciGirisRepository kullaniciGirisRepository;

    @Bean
    public UserDetailsService userDetailsService(){
//        return new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                return kullaniciGirisRepository.findByUsername(username);
//            }
//        }
        //filter tarafından bunu injection et diyoruz , loadUserByUsername yazıyoruz bi nevi
        return username -> kullaniciGirisRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        //-> lambda ile geldi
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
/*
* Authentication Manager bir interfacedir ve kimlik doğrulama metodu çalıştırılmaktadır.
* Authentication Manager bir interface olup, Authentication Provider'a gönderir. Kimlik doğrulama işlemlerinde
* hangi tipte bir doğrulama işleminin yapılacağını Authentication Provider'a bildirir.*/
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
