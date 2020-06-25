package me.youzhilane.dojo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class App {
    int count=0;

    @RequestMapping("/hello")
    @ResponseBody
    String home() {
        ++count;
        return "Hello World!  "+count;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}
