package com.sitech.bds.mp.controller;

import com.sitech.bds.mp.common.utils.Result;
import com.sitech.bds.mp.entity.ScoreManagementEntity;
import com.sitech.bds.mp.service.ScoreManagementService;
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
@RequestMapping("scoremanagement")
@Api(tags = "管理" )
public class ScoreManagementController {

    @Resource
    private ScoreManagementService scoreManagementService;

    @ApiOperation(value = "分页查询列表")
    @GetMapping("pagination")
    public Result pagination(Integer current, Integer size){
        return scoreManagementService.pagination(current,size);
    }

    @ApiOperation(value = "保存表单")
    @PostMapping
    public Result saveScoreManagement(@RequestBody ScoreManagementEntity scoreManagement){
        return scoreManagementService.saveScoreManagement(scoreManagement);
    }

    @ApiOperation(value = "修改表单")
    @PutMapping
    public Result updateScoreManagement(@RequestBody ScoreManagementEntity scoreManagement){
        return scoreManagementService.updateScoreManagement(scoreManagement);
    }

    @ApiOperation(value = "通过指定id删除")
    @DeleteMapping("{id}")
    public Result deleteScoreManagement(@PathVariable(value = "id") Long id){
        return scoreManagementService.deleteScoreManagement(id);
    }

}
