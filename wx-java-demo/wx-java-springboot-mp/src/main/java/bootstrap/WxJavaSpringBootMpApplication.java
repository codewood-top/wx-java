package bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "top.codewood")
public class WxJavaSpringBootMpApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxJavaSpringBootMpApplication.class, args);
    }

}
