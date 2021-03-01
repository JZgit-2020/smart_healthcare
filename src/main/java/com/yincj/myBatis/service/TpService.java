package com.yincj.myBatis.service;

import com.yincj.myBatis.entity.yincjTp;
import com.yincj.myBatis.mapper.tpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TpService {
    @Autowired
    public tpMapper tm;
    public int insertTp(yincjTp yt){
        return tm.insertTp(yt);
    }

}
