package com.mycompany.springapp.productapp.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.naming.AuthenticationException;

@ControllerAdvice
public class CommonExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonExceptionHandler.class);

    @ExceptionHandler(BusinessException.class)//this will enable handling any BE exception thrown
    public ResponseEntity<?> handleBusinessException(BusinessException be){
        LOGGER.info("Entering method handleBusinessException");
        ResponseEntity<?> res = new ResponseEntity<>(be.getMessage(), HttpStatus.CONFLICT);
        LOGGER.error(be.getMessage());
        LOGGER.info("Exiting method handleBusinessException");
        return res;
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> handleAuthenticationException(AuthenticationException ae){
        ResponseEntity<?> res = new ResponseEntity<>(ae.getMessage(), HttpStatus.UNAUTHORIZED);
        return res;
    }

    @ExceptionHandler(CreateNewProductException.class)
    public ResponseEntity<?> handleCreateNewProductException(CreateNewProductException cpe){
        ResponseEntity<?> res = new ResponseEntity<>(cpe.getMessage(),HttpStatus.CONFLICT);
        return res;
    }


}
