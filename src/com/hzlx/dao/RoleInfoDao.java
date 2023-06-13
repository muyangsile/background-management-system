package com.hzlx.dao;

import com.hzlx.entity.RoleInfo;

import java.util.List;

/**
 * @author 哈喽沃德
 * @version 1.0.0
 * @title RoleInfoDao
 * @description <TODO description class purpose>
 * @createTime 2023/6/6 10:35
 **/
public interface RoleInfoDao {
    /**
     * 根据角色名称 模糊查询角色列表
     * @param name 角色名字
     * @return 角色集合
     */
    List<RoleInfo> getRoleInfoAllByName(String name);

    /**
     * 根据角色ID查询角色对象
     * @param id 角色ID
     * @return
     */
    RoleInfo getRoleInfoById(Integer id);

    int addRoleInfo(String name);

    int updateRoleById(String name, String id);

    int updateRoleStatus(Integer id);

    int batchUpdateRoleStatus(String[] ids);
}
