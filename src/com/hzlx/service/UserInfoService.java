package com.hzlx.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserInfoService {
    /**
     * 用户登录的请求
     * @param request http 请求，用于获取用户提交的数据
     * @return json 字符串
     */
    String login(HttpServletRequest request);
}
