package concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {

	@Before("execution(** concert.Performance.perform(..))")
	public void silenceCellPhones() {
		System.out.println("Silencing cell phones");
	}

	@Before("execution(** concert.Performance.perform(..))")
	public void takeSeats() {
		System.out.println("Taking seats");
	}

	@AfterReturning("execution(** concert.Performance.perform(..))")
	public void applause() {
		System.out.println("CLAP CLAP CLAP!!!");
	}

	@AfterThrowing("execution(** concert.Performance.perform(..))")
	public void demandRefund() {
		System.out.println("Demand a refund");
	}

	@Pointcut("execution(** concert.Performance.perform(..))")
	public void performance() {}

	// @Around("performance()")
	public void watchPerformance(ProceedingJoinPoint jp) {
		try {
			silenceCellPhones();
			takeSeats();
			jp.proceed();
			applause();
		} catch (Throwable e) {
			demandRefund();
		}
	}
}
