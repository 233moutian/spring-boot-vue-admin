package com.zoctan.api.controller.admin;

import com.github.pagehelper.PageInfo;
import com.zoctan.api.core.response.Result;
import com.zoctan.api.core.response.ResultGenerator;
import com.zoctan.api.model.Role;
import com.zoctan.api.service.RoleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Zoctan
 * @date 2018/06/09
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleService roleService;

    @PreAuthorize("hasAuthority('role:add')")
    @PostMapping
    public Result add(@RequestBody final Role role) {
        this.roleService.save(role);
        return ResultGenerator.genOkResult();
    }

    @PreAuthorize("hasAuthority('role:delete')")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable final Long id) {
        this.roleService.deleteById(id);
        return ResultGenerator.genOkResult();
    }

    @PreAuthorize("hasAuthority('role:update')")
    @PutMapping
    public Result update(@RequestBody final Role role) {
        this.roleService.update(role);
        return ResultGenerator.genOkResult();
    }

    @PreAuthorize("hasAuthority('role:list')")
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") final Integer page,
                       @RequestParam(defaultValue = "0") final Integer size) {
//        PageHelper.startPage(page, size);
//        偷鸡处理法,一个系统不会有太多的数量,干脆就不分页了,无论传过来什么分页参数我都不分页查询.一个系统要是真有15中角色,那我改还不行吗
        final List<com.zoctan.api.model.Resource> list = this.roleService.findAllRoleWithPermission();
        final PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genOkResult(pageInfo);
    }
}
