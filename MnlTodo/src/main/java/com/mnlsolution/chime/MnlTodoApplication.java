package com.mnlsolution.chime;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.mnlsolution.chime.model.Useraccount;
import com.mnlsolution.chime.repository.UserAccountRepository;

//@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
@PropertySource("config.properties")
public class MnlTodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MnlTodoApplication.class, args);
    }
    
    
    // 초기 데이터 입력 처리 
    @Autowired
    UserAccountRepository userAccountRepository;
    
//    @Autowired
//    PasswordEncoder passwordEncoder;
    
    @Bean
    InitializingBean insertFixtureUsers(){
        return ()->{
            Useraccount user = new Useraccount();
            user.setLoginId("chime");
            user.setPassWd("1234");
            user.setUserName("곽채화");
            user.seteMail("nchime@gmail.com");
            
            Date date = new Date(); 
            user.setRegDate(new Timestamp(date.getTime()));
            
            userAccountRepository.save(user);
        };
    }
    
    
}
