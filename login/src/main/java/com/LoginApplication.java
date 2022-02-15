package com;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.jacks.login")
@MapperScan(basePackages = "com.jacks.login.mapper")
public class LoginApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(LoginApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
