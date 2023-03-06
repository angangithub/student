package com.zto.onecard.service.base.egroup.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.*;
import com.zto.onecard.common.utils.Result;
import com.zto.onecard.service.base.egroup.entity.CoursesEntity;
import com.zto.onecard.service.base.egroup.service.CoursesService;
import javax.annotation.Resource;

/**
 * 
 * @author run
 * @email 2940544565@qq.com
 * @date 2023-03-03 14:59:33
 */
@RestController
@RequestMapping("courses")
public class CoursesController {

    @Resource
    private CoursesService coursesService;

    /**
     * 分页查询列表
     * @author run
     * @email 2940544565@qq.com
     * @date 2023-03-03 14:59:33
     */
    @GetMapping("queryForPage")
    public Result queryForPage(@RequestParam Map<String, Object> params){
        return coursesService.queryForPage(params);
    }


    /**
     * 查询指定id信息
     * @author run
     * @email 2940544565@qq.com
     * @date 2023-03-03 14:59:33
     */
    @GetMapping("info")
    public Result info(@RequestParam(value = "id") Long id){
        return coursesService.queryById(id);
    }

    /**
     * 保存
     * @author run
     * @email 2940544565@qq.com
     * @date 2023-03-03 14:59:33
     */
    @PostMapping("save")
    public Result insert(@RequestBody CoursesEntity courses){
        return coursesService.insert(courses);
    }

    /**
     * 修改
     * @author run
     * @email 2940544565@qq.com
     * @date 2023-03-03 14:59:33
     */
    @PutMapping("modify")
    public Result modify(@RequestBody CoursesEntity courses){
        return coursesService.modifyById(courses);
    }

    /**
     * 删除
     * @author run
     * @email 2940544565@qq.com
     * @date 2023-03-03 14:59:33
     */
    @DeleteMapping("del")
    public Result del(Long id){
        return coursesService.del(id);
    }

}
