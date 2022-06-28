package com.common.utils.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
        super("No resource found using the provided search params!");
    }
}
