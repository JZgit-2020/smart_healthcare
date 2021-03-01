package com.example.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class BasicTool {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BasicTool.class);
    @Scheduled(fixedRate = 1000*60*10)
    public void dealTask(){
        Date d = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        log.info(sf.format(d));
        //获取操作系统
        String osName =System.getProperty("os.name");
        log.info(osName);
        long totalMe= Runtime.getRuntime().totalMemory();
        long freeMe=Runtime.getRuntime().freeMemory();
        long maxMe=Runtime.getRuntime().maxMemory();
        log.info("当前运行内存为："+totalMe+";可用内存为："+freeMe+";总内存为："+maxMe);
    }
/*
    @Scheduled()
    public void dealTask2(){

    }*/

}
