package com.zoctan.api.service;

import com.zoctan.api.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zxw on 2018/8/6 0006.
 */
public class RoleServiceTest extends BaseTest{
    @Autowired
    RoleService roleService;
    @Test
    public void getAllRoleWithPermission() throws Exception {

        System.out.println(roleService.getAllRoleWithPermission().toString());
//        System.out.println(roleService.findAllRoleWithPermission().toString());

    }

}