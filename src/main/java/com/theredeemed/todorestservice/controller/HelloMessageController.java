package com.theredeemed.todorestservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloMessageController {

    @GetMapping(path = "/hello")
    public String getHelloMessage() {
        return "Hello Message";
    }

    @GetMapping(path = "/helloBean")
    public HelloBean helloBean() {
        return new HelloBean("Hello Bean");
    }

    @GetMapping(path = "/helloBeanPathVar/{name}")
    public HelloBean helloBeanPathVar(@PathVariable String name) {
        return new HelloBean(String.format("Hello Bean, %s", name));
    }

    private class HelloBean {

        String helloBean;

        public HelloBean(String hello_bean) {
            this.helloBean = hello_bean;
        }

        public String getHelloBean() {
            return helloBean;
        }

        public void setHelloBean(String helloBean) {
            this.helloBean = helloBean;
        }

        @Override
        public String toString() {
            return "HelloBean{" +
                    "helloBean='" + helloBean + '\'' +
                    '}';
        }
    }
}
