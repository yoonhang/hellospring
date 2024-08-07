package com.example.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","hello");
        return "hello";
    }

    @GetMapping("hellomvc")
        // public String helloMvc(@RequestParam(value = "name", required = false) String name, Model model) {
        public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hellomvc";
    }

    @GetMapping("hellobody")
    @ResponseBody
        public String helloMvc(@RequestParam("name") String name) {
        return "hellobody" + name;

    }


    @GetMapping("helloapi")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;            //외부에서 못부르니까 게터 세터는 자동완성, 자바빈즈 양식

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }    

}
