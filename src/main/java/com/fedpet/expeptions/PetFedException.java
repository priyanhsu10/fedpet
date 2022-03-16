package com.fedpet.expeptions;

import java.util.HashMap;
import java.util.Map;

public class PetFedException extends  RuntimeException{
    public Map<String, String> getErrors() {
        return errors;
    }

    private Map<String ,String> errors;
//single error
    public PetFedException(String message) {
         errors= new HashMap<>();
        errors.put("error",message);
    }

    public PetFedException(Map<String, String> errors) {
        errors = errors;
    }
}
