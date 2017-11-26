package soundsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import soundsystem.CompactDisc;
import soundsystem.SgtPeppers;
import soundsystem.TrackCounter;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackageClasses = CompactDisc.class)
public class SoundSystemConfig {

	@Bean
	public TrackCounter trackCounter() {
		return new TrackCounter();
	}

	@Bean
	public CompactDisc sgtPeppers() {
		return new SgtPeppers();
	}

}
