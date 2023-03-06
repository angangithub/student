package com.zto.onecard.service.base.egroup.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zto.onecard.service.base.egroup.entity.Grades;
import com.zto.onecard.service.base.egroup.service.GradesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Grades)表控制层
 *
 * @author makejava
 * @since 2023-03-06 15:04:19
 */
@RestController
@RequestMapping("grades")
public class GradesController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private GradesService gradesService;

    /**
     * 分页查询所有数据
     *
     * @param page   分页对象
     * @param grades 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Grades> page, Grades grades) {
        return success(this.gradesService.page(page, new QueryWrapper<>(grades)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.gradesService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param grades 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Grades grades) {
        return success(this.gradesService.save(grades));
    }

    /**
     * 修改数据
     *
     * @param grades 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Grades grades) {
        return success(this.gradesService.updateById(grades));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.gradesService.removeByIds(idList));
    }
}

