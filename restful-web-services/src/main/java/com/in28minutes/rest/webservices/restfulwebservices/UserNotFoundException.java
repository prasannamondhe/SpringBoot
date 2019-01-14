package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Prasanna.Mondhe on 12/26/2018.
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException (String msg){
        super(msg);
    }
}
