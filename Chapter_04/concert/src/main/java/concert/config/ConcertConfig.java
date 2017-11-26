package concert.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import concert.Audience;
import concert.DramaPerformance;
import concert.Performance;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses = Audience.class)
public class ConcertConfig {

	@Bean
	public Audience audience() {
		return new Audience();
	}

	@Bean
	public Performance performance() {
		return new DramaPerformance();
	}

}
