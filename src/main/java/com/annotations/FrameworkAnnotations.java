package com.annotations;

import static java.lang.annotation.ElementType.METHOD;


import java.lang.annotation.Retention;
import java.lang.annotation.Target;



@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({METHOD})
public @interface FrameworkAnnotations {
	
	String[] author() default "default author";
	String[] category() default "default category";
	
	
	

}
