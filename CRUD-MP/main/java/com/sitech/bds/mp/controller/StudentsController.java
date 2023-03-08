package com.sitech.bds.mp.controller;

import com.sitech.bds.mp.common.utils.Result;
import com.sitech.bds.mp.entity.StudentsEntity;
import com.sitech.bds.mp.service.StudentsService;
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
@RequestMapping("students")
@Api(tags = "管理" )
public class StudentsController {

    @Resource
    private StudentsService studentsService;

    @ApiOperation(value = "分页查询列表")
    @GetMapping("pagination")
    public Result pagination(Integer current, Integer size){
        return studentsService.pagination(current,size);
    }

    @ApiOperation(value = "保存表单")
    @PostMapping
    public Result saveStudents(@RequestBody StudentsEntity students){
        return studentsService.saveStudents(students);
    }

    @ApiOperation(value = "修改表单")
    @PutMapping
    public Result updateStudents(@RequestBody StudentsEntity students){
        return studentsService.updateStudents(students);
    }

    @ApiOperation(value = "通过指定id删除")
    @DeleteMapping("{id}")
    public Result deleteStudents(@PathVariable(value = "id") Long id){
        return studentsService.deleteStudents(id);
    }

}
