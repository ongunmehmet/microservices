package microservicedeneme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class MicroserviceDenemeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceDenemeApplication.class, args);
    }

}
