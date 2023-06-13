package com.hzlx.service;

import com.hzlx.entity.RoleInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 哈喽沃德
 * @version 1.0.0
 * @title RoleInfoService
 * @description <TODO description class purpose>
 * @createTime 2023/6/6 10:28
 **/
public interface RoleInfoService {
    /**
     * 根据rolename查询所以角色  支持模糊查询
     */
    void getRoleInfoAllByName(HttpServletRequest request);

    /**
     * 根据角色ID查询角色对象
     * @param request
     * @return
     */
    String getRoleInfoById(HttpServletRequest request);

    /**
     * 新增角色 和 修改角色 根据ID来判断  如果ID能取到值 则为修改  反正为 新增
     * @param request
     * @return
     */
    String editRole(HttpServletRequest request);

    /**
     * 根据角色ID删除角色
     * @param request
     * @return
     */
    String updateRoleStatus(HttpServletRequest request);

    /**
     * 批量启用
     * @param request
     * @return
     */
    String enableRoles(HttpServletRequest request);
}
