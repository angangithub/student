package com.sitech.bds.mp.controller;

import com.sitech.bds.mp.common.utils.Result;
import com.sitech.bds.mp.entity.EnrollmentsEntity;
import com.sitech.bds.mp.service.EnrollmentsService;
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
@RequestMapping("enrollments")
@Api(tags = "选课管理" )
public class EnrollmentsController {

    @Resource
    private EnrollmentsService enrollmentsService;

    @ApiOperation(value = "分页查询列表")
    @GetMapping("pagination")
    public Result pagination(Integer current, Integer size){
        return enrollmentsService.pagination(current,size);
    }

    @ApiOperation(value = "保存表单")
    @PostMapping
    public Result saveEnrollments(@RequestBody EnrollmentsEntity enrollments){
        return enrollmentsService.saveEnrollments(enrollments);
    }

    @ApiOperation(value = "修改表单")
    @PutMapping
    public Result updateEnrollments(@RequestBody EnrollmentsEntity enrollments){
        return enrollmentsService.updateEnrollments(enrollments);
    }

    @ApiOperation(value = "通过指定id删除")
    @DeleteMapping("{id}")
    public Result deleteEnrollments(@PathVariable(value = "id") Long id){
        return enrollmentsService.deleteEnrollments(id);
    }

}
