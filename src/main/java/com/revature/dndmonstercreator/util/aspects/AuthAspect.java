package com.revature.dndmonstercreator.util.aspects;


import com.revature.dndmonstercreator.util.exceptions.UnauthorizedException;
import com.revature.dndmonstercreator.util.web.Secured;
import com.revature.dndmonstercreator.util.web.jwtutils.TokenManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Method;

@CrossOrigin(exposedHeaders = "Authorization")
@Aspect
@Component
public class AuthAspect {

    private final TokenManager tokenManager;

    @Autowired
    public AuthAspect(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    @Order(1)

    @Around("@annotation(com.revature.dndmonstercreator.util.web.Secured)")
    public Object securedEndpoint(ProceedingJoinPoint pjp) throws Throwable {

        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        Secured annotation = method.getAnnotation(Secured.class);

        String token = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getHeader("Authorization");
        if(!tokenManager.validateJwtToken(token)) throw new UnauthorizedException("No session token found");

        return pjp.proceed();
    }
}
