package com.sitech.bds.mp.controller;

import com.sitech.bds.mp.common.utils.Result;
import com.sitech.bds.mp.entity.CoursesEntity;
import com.sitech.bds.mp.service.CoursesService;
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
@RequestMapping("courses")
@Api(tags = "管理" )
public class CoursesController {

    @Resource
    private CoursesService coursesService;

    @ApiOperation(value = "分页查询列表")
    @GetMapping("pagination")
    public Result pagination(Integer current, Integer size){
        return coursesService.pagination(current,size);
    }

    @ApiOperation(value = "保存表单")
    @PostMapping
    public Result saveCourses(@RequestBody CoursesEntity courses){
        return coursesService.saveCourses(courses);
    }

    @ApiOperation(value = "修改表单")
    @PutMapping
    public Result updateCourses(@RequestBody CoursesEntity courses){
        return coursesService.updateCourses(courses);
    }

    @ApiOperation(value = "通过指定id删除")
    @DeleteMapping("{id}")
    public Result deleteCourses(@PathVariable(value = "id") Long id){
        return coursesService.deleteCourses(id);
    }

}
