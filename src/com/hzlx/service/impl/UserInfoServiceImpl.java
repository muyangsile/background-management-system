package com.hzlx.service.impl;

import com.hzlx.component.BgmsConfig;
import com.hzlx.dao.UserInfoDao;
import com.hzlx.dao.impl.UserInfoDaoImpl;
import com.hzlx.entity.UserInfo;
import com.hzlx.service.UserInfoService;
import com.hzlx.utils.BaseResult;
import com.hzlx.utils.MD5Utils;
import com.mysql.cj.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class UserInfoServiceImpl implements UserInfoService {

    //引入dao层，用户查询数据库
    private UserInfoDao userInfoDao= new UserInfoDaoImpl();

    @Override
    public String login(HttpServletRequest request) {
        //从请求中获取用户名和密码
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        //用户名和密码做非空校验
        if (StringUtils.isNullOrEmpty(userName)|| StringUtils.isNullOrEmpty(password)){
            return BaseResult.error(10001,"用户名或者密码不能为空");
        }
        //给密码加密
        String encryptPwd =  MD5Utils.encryptMD5(password,userName);
        //拿加密后的密码和用户名去数据库里查询用户信息;
        UserInfo userInfo = userInfoDao.getUserInfoByUserNameAndPassword(userName, encryptPwd);
        //如果查询到的 userInfo 为空，则说明用户名和密码不存在，判定为账号或密码错误;
        if (userInfo==null) {
            return BaseResult.error(10002, "账号或密码错误");
        }
        //用户名登录成功之后，把用户名信息存储下来放到 session作用域中，用户名后续使用
        request.getSession().setAttribute(BgmsConfig.SESSION_USER_KEY,userInfo);
        return BaseResult.success();
    }
}
