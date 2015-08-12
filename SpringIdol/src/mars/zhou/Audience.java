package mars.zhou;

import org.aspectj.lang.ProceedingJoinPoint;

public class Audience {
	public void takeSeats() {
		System.out.println("The audience is taking seats.");
	}
	
	public void turnOffCellphones() {
		System.out.println("The audience is turning off cellphones.");
	}
	
	public void applaud() {
		System.out.println("The audience is applauding.");
	}
	
	public void demandRefund() {
		System.out.println("Boo!");
	}
	
	public void watchPerformance(ProceedingJoinPoint joinPoint){
		try{
			System.out.println("2The audience is taking their seats");
			System.out.println("2The audience is turning off cellphones.");
			
			long start = System.currentTimeMillis();
			joinPoint.proceed();
			long end = System.currentTimeMillis();
			System.out.println("2The audience is applauding.");
			System.out.println("The performance took " + (end - start) + " milliseconds.");
		} catch (Throwable e) {
			System.out.println("2Boo!");
		}
	}
}
 