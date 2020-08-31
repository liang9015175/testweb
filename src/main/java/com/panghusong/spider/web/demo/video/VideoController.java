package com.panghusong.spider.web.demo.video;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author panghusong
 * @date 2020/8/31
 * @description
 */
@RestController
@RequestMapping("api/spider/videos/")
public class VideoController {

    @GetMapping("/list")
    public ResponseEntity<List<JSONObject>> videos(@RequestParam(value = "curPage",required = false,defaultValue = "1") Integer curPage, @RequestParam(name = "pageSize",required = false,defaultValue = "12") Integer pageSize){
        List<JSONObject> objects = Lists.newArrayList();
        for (int i=0;i<12;i++){
            objects.add(new JSONObject().fluentPut("id",i).fluentPut("name","panghu_"+i).fluentPut("url","/static/res/img/panghu.jpg").fluentPut("duration",curPage+" mins"));
        }
        return ResponseEntity.ok(objects);
    }
}
