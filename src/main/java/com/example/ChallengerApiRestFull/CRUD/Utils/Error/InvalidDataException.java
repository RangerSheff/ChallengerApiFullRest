package com.example.ChallengerApiRestFull.CRUD.Utils.Error;

import lombok.Getter;
import org.springframework.validation.BindingResult;

import java.io.Serial;

@Getter
public class InvalidDataException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    private final transient BindingResult result;

    public InvalidDataException(BindingResult result) {
        super();
        this.result = result;
    }

    public InvalidDataException(String message, BindingResult result) {
        super(message);
        this.result = result;
    }

}
