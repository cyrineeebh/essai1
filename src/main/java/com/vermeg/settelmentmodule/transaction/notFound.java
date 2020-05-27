package com.vermeg.settelmentmodule.transaction;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class notFound extends Exception{

	private static final long serialVersionUID = 1L;

	public notFound(String message){
    	super(message);
    }

}
