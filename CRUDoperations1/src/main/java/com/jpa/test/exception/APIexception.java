package com.jpa.test.exception;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.ControllerAdvice;
@ControllerAdvice
public class APIexception extends NoSuchElementException(){
	
}
