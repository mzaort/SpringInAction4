package soundsystem;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TrackCounter {

	private Map<Integer, Integer> trackCounters = new HashMap<>();

	@Pointcut("execution(** soundsystem.CompactDisc.playTrack(int)) && args(trackNumber)")
	public void playTrack(int trackNumber) {}

	@Before("playTrack(trackNumber)")
	public void countTrack(int trackNumber) {
		int currentCount = trackCounters.containsKey(trackNumber) ? trackCounters.get(trackNumber) : 0;
		trackCounters.put(trackNumber, currentCount + 1);
	}

	@Override
	public String toString() {
		return trackCounters.toString();
	}
}
