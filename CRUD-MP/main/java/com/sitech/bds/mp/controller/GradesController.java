package com.sitech.bds.mp.controller;

import com.sitech.bds.mp.common.utils.Result;
import com.sitech.bds.mp.entity.GradesEntity;
import com.sitech.bds.mp.service.GradesService;
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
@RequestMapping("grades")
@Api(tags = "成绩" )
public class GradesController {

    @Resource
    private GradesService gradesService;

    @ApiOperation(value = "分页查询列表")
    @GetMapping("pagination")
    public Result pagination(Integer current, Integer size){
        return gradesService.pagination(current,size);
    }

    @ApiOperation(value = "保存表单")
    @PostMapping
    public Result saveGrades(@RequestBody GradesEntity grades){
        return gradesService.saveGrades(grades);
    }

    @ApiOperation(value = "修改表单")
    @PutMapping
    public Result updateGrades(@RequestBody GradesEntity grades){
        return gradesService.updateGrades(grades);
    }

    @ApiOperation(value = "通过指定id删除")
    @DeleteMapping("{id}")
    public Result deleteGrades(@PathVariable(value = "id") Long id){
        return gradesService.deleteGrades(id);
    }

}
