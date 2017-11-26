package soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import soundsystem.CompactDisc;
import soundsystem.TrackCounter;
import soundsystem.config.SoundSystemConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SoundSystemConfig.class)
public class SoundSystemAnnotationConfigTest {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private CompactDisc disc;

	@Autowired
	private TrackCounter counter;

	@Test
	public void testPerformance() {
		disc.playTrack(0);
		System.out.println(counter);
		disc.playTrack(1);
		System.out.println(counter);
		disc.playTrack(2);
		System.out.println(counter);
		disc.playTrack(0);
		System.out.println(counter);
	}

}
