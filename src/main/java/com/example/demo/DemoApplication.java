package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@RestController
@EnableScheduling
public class DemoApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(DemoApplication.class, args);
        /*MyBasic mb = new MyBasic();
        mb.hello();*/
        //获取操作系统
        String osName =System.getProperty("os.name");
        System.out.println(osName);
        long totalMe= Runtime.getRuntime().totalMemory();
        long freeMe=Runtime.getRuntime().freeMemory();
        long maxMe=Runtime.getRuntime().maxMemory();
        System.out.println("当前运行内存为："+totalMe+";可用内存为："+freeMe+";总内存为："+maxMe);
        double t=Math.round(totalMe/1048576000);
        double f=Math.round(freeMe/1048576000);
        double m=Math.round(maxMe/1048576000);
        //System.out.println("当前运行内存为："+t+";可用内存为："+f+";总内存为："+m);


    }/*
@RequestMapping(value="/hello")
    public String hallo(){
        return "yincj第一个springboot";
    }*/


}
