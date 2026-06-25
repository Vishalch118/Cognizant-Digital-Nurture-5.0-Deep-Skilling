package com.library.aspect;

public class LoggingAspect {

    public void beforeMethod() {
        System.out.println("[LOG] Method execution started...");
    }

    public void afterMethod() {
        System.out.println("[LOG] Method execution completed.");
    }
}