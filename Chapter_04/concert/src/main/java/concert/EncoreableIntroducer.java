package concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EncoreableIntroducer {

	@DeclareParents(value = "concert.Performance+", defaultImpl = DefaultEncoralbe.class)
	public static Encoreable encoreable;
}
