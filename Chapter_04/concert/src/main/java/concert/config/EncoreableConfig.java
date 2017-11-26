package concert.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import concert.Audience;
import concert.DramaPerformance;
import concert.EncoreableIntroducer;
import concert.Performance;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses = Audience.class)
public class EncoreableConfig {

	@Bean
	public Audience audience() {
		return new Audience();
	}

	@Bean
	public Performance performance() {
		return new DramaPerformance();
	}

	@Bean
	public EncoreableIntroducer encoreableIntroducer() {
		return new EncoreableIntroducer();
	}

}
