package com.sitech.bds.mp.controller;

import com.sitech.bds.mp.common.utils.Result;
import com.sitech.bds.mp.entity.ClassesEntity;
import com.sitech.bds.mp.service.ClassesService;
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
@RequestMapping("classes")
@Api(tags = "班级管理" )
public class ClassesController {

    @Resource
    private ClassesService classesService;

    @ApiOperation(value = "分页查询列表")
    @GetMapping("pagination")
    public Result pagination(Integer current, Integer size){
        return classesService.pagination(current,size);
    }

    @ApiOperation(value = "保存表单")
    @PostMapping
    public Result saveClasses(@RequestBody ClassesEntity classes){
        return classesService.saveClasses(classes);
    }

    @ApiOperation(value = "修改表单")
    @PutMapping
    public Result updateClasses(@RequestBody ClassesEntity classes){
        return classesService.updateClasses(classes);
    }

    @ApiOperation(value = "通过指定id删除")
    @DeleteMapping("{id}")
    public Result deleteClasses(@PathVariable(value = "id") Long id){
        return classesService.deleteClasses(id);
    }

}
