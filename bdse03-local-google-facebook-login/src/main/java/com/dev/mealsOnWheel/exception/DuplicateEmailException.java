package com.dev.mealsOnWheel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dev.mealsOnWheel.payload.IssueHandling;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateEmailException extends BadRequestException {

    public DuplicateEmailException(String message) {
        super(message);
    }

    public IssueHandling getErrorResponse() {
        return new IssueHandling(HttpStatus.BAD_REQUEST.value(), getMessage());
    }
}

