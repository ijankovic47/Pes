package konami.pes.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PesLogging {

	private static final Logger LOG = Logger.getLogger(PesLogging.class);
	
	@Before("execution(* konami.pes.*.*.*(..))")
	public void tryOut(JoinPoint point){
		Object[] args=point.getArgs();
		String a="";
		for(Object o:args){
			a+=o+", ";
		}
		LOG.info(point.getSignature()+"    args     "+a);
	}
}
