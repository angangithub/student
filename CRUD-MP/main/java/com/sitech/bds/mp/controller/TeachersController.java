package com.sitech.bds.mp.controller;

import com.sitech.bds.mp.common.utils.Result;
import com.sitech.bds.mp.entity.TeachersEntity;
import com.sitech.bds.mp.service.TeachersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 
 * @author za
 * @date 2023-03-08
 */
@RestController
@RequestMapping("teachers")
@Api(tags = "管理" )
public class TeachersController {

    @Resource
    private TeachersService teachersService;

    @ApiOperation(value = "分页查询列表")
    @GetMapping("pagination")
    public Result pagination(Integer current, Integer size){
        return teachersService.pagination(current,size);
    }

    @ApiOperation(value = "保存表单")
    @PostMapping
    public Result saveTeachers(@RequestBody TeachersEntity teachers){
        return teachersService.saveTeachers(teachers);
    }

    @ApiOperation(value = "修改表单")
    @PutMapping
    public Result updateTeachers(@RequestBody TeachersEntity teachers){
        return teachersService.updateTeachers(teachers);
    }

    @ApiOperation(value = "通过指定id删除")
    @DeleteMapping("{id}")
    public Result deleteTeachers(@PathVariable(value = "id") Long id){
        return teachersService.deleteTeachers(id);
    }

}
