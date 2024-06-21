package bg.softuni.mobilele.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.record.RecordModule;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper().registerModule(new RecordModule());
    }
    @Bean
    public PasswordEncoder passwordEncoder () {
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }
}
