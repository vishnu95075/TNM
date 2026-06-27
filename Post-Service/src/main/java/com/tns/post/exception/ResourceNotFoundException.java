package com.tns.post.exception;


public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s not found with input data %s : %s",resourceName,fieldName,fieldValue));
    }
}
