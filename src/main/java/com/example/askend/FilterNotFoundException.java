package com.example.askend;

public class FilterNotFoundException extends RuntimeException  {
    public FilterNotFoundException(Long id) {
        super("Could not find filter " + id);
    }
}
