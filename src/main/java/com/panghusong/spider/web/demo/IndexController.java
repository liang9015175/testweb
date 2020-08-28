package com.panghusong.spider.web.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author panghusong
 * @date 2020/8/28
 * @description
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/indexPage",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
