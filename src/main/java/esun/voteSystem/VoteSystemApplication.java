package esun.voteSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages= {"esun.voteSystem.repository"})
@ComponentScan(value= {"esun.voteSystem.*", "esun.voteSystem.model"})
@SpringBootApplication
@EntityScan("esun.voteSystem.model")
public class VoteSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoteSystemApplication.class, args);
	}

}
