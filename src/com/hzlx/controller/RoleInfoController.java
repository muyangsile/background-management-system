package com.hzlx.controller;

import com.hzlx.annotation.Controller;
import com.hzlx.annotation.RequestMapping;
import com.hzlx.annotation.ResponseBody;
import com.hzlx.service.RoleInfoService;
import com.hzlx.service.impl.RoleInfoServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 哈喽沃德
 * @version 1.0.0
 * @title RoleInfoController
 * @description <TODO description class purpose>
 * @createTime 2023/6/6 10:04
 **/
@Controller
@RequestMapping("/api/role")
public class RoleInfoController {

    private RoleInfoService roleInfoService=new RoleInfoServiceImpl();
    @RequestMapping("/roleList")
    public String roleList(HttpServletRequest request, HttpServletResponse response) {
        roleInfoService.getRoleInfoAllByName(request);
        return "pages/role_list";
    }


    @RequestMapping("/getRole")
    @ResponseBody
    public String getRoleById(HttpServletRequest request,HttpServletResponse response){
       return roleInfoService.getRoleInfoById(request);
    }

    @RequestMapping("/editRole")
    @ResponseBody
    public String editRole(HttpServletRequest request,HttpServletResponse response){
        return roleInfoService.editRole(request);
    }

    @RequestMapping("/updateRoleStatus")
    @ResponseBody
    public String updateRoleStatus(HttpServletRequest request,HttpServletResponse response){
       return roleInfoService.updateRoleStatus(request);
    }

    @RequestMapping("/enableRoles")
    @ResponseBody
    public String enableRoles(HttpServletRequest request,HttpServletResponse response){
        return roleInfoService.enableRoles(request);
    }

}
