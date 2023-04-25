package infinityworks.com.iwtechtest.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("infinityworks.com.iwtechtest")
public class IwTechTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(IwTechTestApplication.class, args);
	}
	@Bean
	public RestTemplate getRestTemplateBean(){
		return new RestTemplate();
	}


}
