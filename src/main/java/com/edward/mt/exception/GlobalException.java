package com.edward.mt.exception;

import com.edward.mt.vo.MtResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
public class GlobalException {
    Logger logger = LoggerFactory.getLogger(GlobalException.class);

    public GlobalException() {
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public MtResult error(Exception e) {
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException)e;
            List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
            FieldError error = fieldErrors.get(0);
            String msg = error.getDefaultMessage();
            return MtResult.error(msg);
        } else {
            System.out.println(e.getMessage());
            //logger.error(e.getMessage());
            return MtResult.error(e.getMessage());
        }
    }

    @ExceptionHandler({MtException.class})
    @ResponseBody
    public MtResult customError(Exception e) {
        //logger.error(e.getMessage());
        return MtResult.error(e.getMessage());
    }
}
