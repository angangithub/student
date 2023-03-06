package com.zto.onecard.service.base.egroup.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.*;
import com.zto.onecard.common.utils.Result;
import com.zto.onecard.service.base.egroup.entity.ClassesEntity;
import com.zto.onecard.service.base.egroup.service.ClassesService;
import javax.annotation.Resource;

/**
 * 
 * @author run
 * @email 2940544565@qq.com
 * @date 2023-03-03 14:59:33
 */
@RestController
@RequestMapping("classes")
public class ClassesController {

    @Resource
    private ClassesService classesService;

    /**
     * 分页查询列表
     * @author run
     * @email 2940544565@qq.com
     * @date 2023-03-03 14:59:33
     */
    @GetMapping("queryForPage")
    public Result queryForPage(@RequestParam Map<String, Object> params){
        return classesService.queryForPage(params);
    }


    /**
     * 查询指定id信息
     * @author run
     * @email 2940544565@qq.com
     * @date 2023-03-03 14:59:33
     */
    @GetMapping("info")
    public Result info(@RequestParam(value = "id") Long id){
        return classesService.queryById(id);
    }

    /**
     * 保存
     * @author run
     * @email 2940544565@qq.com
     * @date 2023-03-03 14:59:33
     */
    @PostMapping("save")
    public Result insert(@RequestBody ClassesEntity classes){
        return classesService.insert(classes);
    }

    /**
     * 修改
     * @author run
     * @email 2940544565@qq.com
     * @date 2023-03-03 14:59:33
     */
    @PutMapping("modify")
    public Result modify(@RequestBody ClassesEntity classes){
        return classesService.modifyById(classes);
    }

    /**
     * 删除
     * @author run
     * @email 2940544565@qq.com
     * @date 2023-03-03 14:59:33
     */
    @DeleteMapping("del")
    public Result del(Long id){
        return classesService.del(id);
    }

}
