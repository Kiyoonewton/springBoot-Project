package Kiyoonewton.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello(){
        return "<h1 style=\"color:red; font-size: 40px\">Hello World! Welcome</h1>";
    }

    @PostMapping("/hello")
    public String hellopost(@RequestBody String Name){
        return "Hello   " + Name + "!";
    }
}