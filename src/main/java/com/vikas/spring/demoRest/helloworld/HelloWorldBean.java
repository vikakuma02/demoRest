package com.vikas.spring.demoRest.helloworld;

public class HelloWorldBean {

    private String message;


    public HelloWorldBean(String message) {
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage (String mess){
        this.message=message;

    }
    @Override
    public String toString() {

        return String.format("HelloWorldBean [message=%s]", message);
    }
}
