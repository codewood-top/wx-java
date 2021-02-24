package boostrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "top.codewood")
public class WxJavaSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxJavaSpringBootApplication.class, args);
    }

}
