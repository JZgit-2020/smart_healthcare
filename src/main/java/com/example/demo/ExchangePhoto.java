package com.example.demo;

import com.yincj.myBatis.controller.tpController;
import com.yincj.myBatis.entity.yincjTp;
import com.yincj.myBatis.service.TpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

@Controller
@RestController
public class ExchangePhoto {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ExchangePhoto.class);

    /**
     * 测试springboot 整合springMVC
     * @param id
     * @param tp
     * @return
     */
    @RequestMapping("/basic")
    @ResponseBody
    public String dealPhoto(String id,String tp){
        log.info("当前接口到的id:"+id+",tp为："+tp);
        String res;
        if(checkNull(tp)){
            res="传入图片为空！";
        }else {
            log.info("尹昌金真棒！");
            res="尹昌金真棒！";
        }
        return res;
    }

    /**
     * 测试数据源
     */
    @Autowired
    JdbcTemplate jdbcTemplate;
    @RequestMapping(value="/testJdbc",method = RequestMethod.GET)
    public String index(String id){
        log.info("接口到请求交易"+id);
        String sql="SELECT TP_NAME FROM YINCJ_TP WHERE APPL_CDE="+id;
        //String sql="SELECT MOBILE FROM USER WHERE ID=?";
        log.info(sql);
        String moblie = (String)jdbcTemplate.queryForObject(sql,new Object[]{1},String.class);
        return moblie;
    }


    @PostMapping(value = "/tpPost")
    @ResponseBody
    public String dealTp(@RequestParam(value="tp",required=true) MultipartFile tp,String id){
        String res="0";
        log.info("当前业务ID:"+id);
        if(tp.isEmpty()){
            log.info("图片为空！");
            return res;
        }else{
            log.info(String.valueOf(tp));
            String tpName="";
            long tpSize=0L;
            byte[] tpBytes=null;
            tpName=tp.getName();
            tpSize=tp.getSize();
            log.info("图片名为："+tpName+";图片大小为："+tpSize);
            try {
                tpBytes=tp.getBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //开始插入表
            String insertRes="";
            insertRes=insertTableByMyBatis(id,tpBytes,tpName);//通过myBatis
            log.info("插表结果："+insertRes);
            insertRes=insertTableByJpa(id,tpBytes);//通过jpa
            log.info("插表结果："+insertRes);
            if(insertRes=="suc"){
                res="1";
            }
        }
        return res;
    }

    /**
     *
     * @param id:业务主键
     * @param tpBytes：图片字节码
     * @return
     */
    public String insertTableByMyBatis(String id,byte[] tpBytes,String tpName){
        String res="fail";
        String uuid = UUID.randomUUID().toString();
        log.info("生成UUID为："+uuid);
        HashMap hm = new HashMap();
        hm.put("pkId",uuid);
        hm.put("applCde",id);
        hm.put("tpName",tpName);
        hm.put("mTp",tpBytes);
        yincjTp yt = new yincjTp();
        yt.setPkId(uuid);
        yt.setApplCde(id);
        yt.setTpName(tpName);
        yt.setmTp(String.valueOf(tpBytes));
        tpController tc = new tpController();
        tc.insetTp(yt);
        //insertTp(yt);
        return res;
    }

    /**
     *
     * @param id:业务主键
     * @param tpBytes：图片字节码
     * @return
     */
    public String insertTableByJpa(String id,byte[] tpBytes){
        String res="fail";
        String uuid = UUID.randomUUID().toString();
        log.info("生成UUID为："+uuid);
        return res;
    }

    /**
     *
     * @param str:字符串
     * @return 是否为空
     */
    public boolean checkNull(String str){
        if(str==null || str.length()==0){
            return true;
        }else{
            return false;
        }
    }

}
