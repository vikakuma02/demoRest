package com.vikas.spring.demoRest.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);

    //GET Call
    //URI
    //method
    @RequestMapping(method = RequestMethod.GET, path="hello")
    public String helloWorld(){
        return "I am Anvika Singh";
    }

    @RequestMapping(method = RequestMethod.GET, path="helloVikas")
    public HelloWorldBean helloWorldbean1(){
        LOG.info("Vikas is called");
        LOG.debug("Debug : Vikas is called");
        return new HelloWorldBean("I am Vikas");
    }

    @RequestMapping(method = RequestMethod.GET, path="helloAnjali")
    public HelloWorldBean helloWorldbean(){
        LOG.info("ANJALI IS CALLED");
        LOG.debug("Debug : Anjali is called");
        return new HelloWorldBean("I am Anjali");

    }

    //hello/path-variable/{name}
    @RequestMapping(method = RequestMethod.GET, path="hello/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        LOG.info("Path Variable Example is called");
        return new HelloWorldBean(String.format("Hello World,%s",name.toUpperCase()));

    }
}
