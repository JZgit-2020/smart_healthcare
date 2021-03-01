package com.example.demo;

import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    /*@ResponseBody
    @RequestMapping("/hello")*/
    public String he (){
        return "尹昌金最帅！";
    }
}
