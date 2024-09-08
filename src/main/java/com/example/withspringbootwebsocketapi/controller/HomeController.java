package com.example.withspringbootwebsocketapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.withspringbootwebsocketapi.model.Student;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class HomeController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(){
        return "home Page";
    }

    @GetMapping("/home")
    public String homeAgain() {
        return "Welcome to home Page";
    }

    @GetMapping("/req1")
    public String m1(String name) {
        if (name==null) {
            return "Hello Sir/mamdam please insert your name in URL so that you can See it on Website add ?name=YOUR_NAME this.";
        }else{
            
        return "Hello "+name;
        }
    }
    /* URL: localhost:9090/req1?name=YOUR_NAME
     * URI: localhost:9090/req2/YOUR_NAME     //This one is better than other
    */

    @GetMapping(value = "/req2/{a}")
    public String m2(@PathVariable("a")String param) {
        return "Your's "+param;
    }

    /*passing only int return int */
    @GetMapping(value = "/req3")
    public int m3(int a,int b,int c){
        return a+b+c;
    }
    
    @GetMapping("/req4")
    public int[] m4(@RequestParam int[] a) {
        return a;
    }

    /*to get from body: row-json */
    @GetMapping("/req5")
    public int[] m5(@RequestBody int[] a) {
        return a;
    }
    

    /*passing int returning string */
    @GetMapping("/req6/{a}/{b}/{c}")
    public String req6(@PathVariable("a") int a,@PathVariable("b") int b, @PathVariable("c") int c,int d[]) {
        return a+"+"+b+"+"+c+" = "+(a+b+c)+" and Your Array is: "+Arrays.toString(d);
    }
    
    @GetMapping("/req7")
    public Student m7(@RequestBody Student s1) {
        return s1;
    }
    
    
}
