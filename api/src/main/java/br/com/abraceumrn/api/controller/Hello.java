package br.com.abraceumrn.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("")
    public String hello() {
        return "hello world";
    } 
}
