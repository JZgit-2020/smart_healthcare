package com.yincj.myBatis.controller;

import com.yincj.myBatis.entity.yincjTp;
import com.yincj.myBatis.service.TpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class tpController {
    @Autowired
    private TpService ts;
    public int insetTp(yincjTp yt){
        int i=ts.insertTp(yt);
        return i;
    }
}
