package com.qfedu.dcy.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class MySecondAspectj {

    Logger logger = LogManager.getLogger(MySecondAspectj.class);



    //前置增强(前置通知)
    public void beforeUserService(JoinPoint joinPoint) {
        logger.info("==========UserService Begin=========="+joinPoint.getTarget()+":"+
                joinPoint.getSignature().getName());
    }
    //后置增强(后置通知)
    public void afterUserService(JoinPoint joinPoint) {

        logger.info("==========UserService End=========="+joinPoint.getTarget()+":"+
                joinPoint.getSignature().getName());
    }
    //错误日志增强
    public void errorMsg(JoinPoint joinPoint,Exception ex) {
        logger.info("出现错误地方:"+joinPoint.getTarget()+":"+
                joinPoint.getSignature().getName());
        logger.error(ex);
    }

    //环绕通知
    //@Around("prdService()" )
    public Object aroundService(ProceedingJoinPoint joinPoint) {
        logger.info("==========UserService Begin=========="+joinPoint.getTarget()+":"+
                joinPoint.getSignature().getName());
        Object obj = null;
        try {
            obj = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        logger.info("==========UserService End=========="+joinPoint.getTarget()+":"+
                joinPoint.getSignature().getName()+" 返回结果是:"+obj);
        return obj;
    }

}
