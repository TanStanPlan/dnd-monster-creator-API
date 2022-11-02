package com.revature.dndmonstercreator.util.web;

import java.lang.annotation.*;

@Documented

@Target(ElementType.METHOD)

@Retention(RetentionPolicy.RUNTIME)
public @interface Secured {

    boolean isLoggedIn() default true;

}
