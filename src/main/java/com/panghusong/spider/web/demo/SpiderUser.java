package com.panghusong.spider.web.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author panghusong
 * @date 2020/8/27
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpiderUser {
    private Long id;

    private String username;

    private String password;

}
