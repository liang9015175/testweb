//package com.panghusong.spider.web.demo;
//
//import com.alibaba.fastjson.JSON;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * @author panghusong
// * @date 2020/8/27
// * @description
// */
//@Slf4j
//@WebFilter(urlPatterns = "/api/spider/**/.*", filterName = "spiderAuthCheckFilter")
//@Component
//public class SpiderAuthCheckFilter extends OncePerRequestFilter {
//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "token,Origin, X-Requested-With, Content-Type, Accept");
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json;charset=utf-8");
//
//        //获取head里面的token
//        String token = request.getHeader("x-spider-auth");
//        ResponseEntity responseEntity = null;
//        String uri = request.getRequestURI();
//        if (uri.contains("/auth")) {
//            if (StringUtils.isEmpty(token)) {
//                log.error("没有token:{}", request.getRequestURI());
//                responseEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
//            } else {
//                String redisToken = redisTemplate.opsForValue().get(token);
//                if (StringUtils.isEmpty(redisToken)) {
//                    responseEntity = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
//                } else {
//                    responseEntity = ResponseEntity.ok(JSON.parseObject(redisToken, SpiderUser.class));
//                }
//            }
//            if (responseEntity.getStatusCode() == HttpStatus.UNAUTHORIZED) {
//                response.getWriter().write(JSON.toJSONString(responseEntity));
//                response.getWriter().flush();
//                response.getWriter().close();
//            }
//        } else {
//            doFilter(request, response, filterChain);
//        }
//    }
//}
