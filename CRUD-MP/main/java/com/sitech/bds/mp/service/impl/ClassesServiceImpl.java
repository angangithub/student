package com.sitech.bds.mp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sitech.bds.mp.entity.ClassesEntity;
import com.sitech.bds.mp.mapper.ClassesMapper;
import com.sitech.bds.mp.service.ClassesService;
import com.sitech.bds.mp.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;



/**
 * 
 * @author za
 * @date 2023-03-08
 */
@Service
@Slf4j
public class ClassesServiceImpl extends ServiceImpl<ClassesMapper, ClassesEntity> implements ClassesService {

    /**
     * 查询列表
     * @author za
     * @date 2023-03-08
     */
    @Override
    public Result pagination(Integer current,Integer size) {
        try{
            Assert.notNull(current,"参数异常");
            Assert.notNull(size,"参数异常");
            Page<ClassesEntity> page = new Page<>(current,size);
            QueryWrapper<ClassesEntity> wrapper = new QueryWrapper<>();
            wrapper.orderByDesc("create_time");
            baseMapper.selectPage(page,wrapper);
            return Result.ok(page);
        }catch(Exception e){
            log.error("ClassesService queryForPage ERROR => {}" , e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 创建表单对象
     * @author za
     * @date 2023-03-08
     */
    @Override
    public Result saveClasses(ClassesEntity classes) {
        try{
            Assert.notNull(classes,"参数异常");
            boolean flag = this.save(classes);
            if (flag) return Result.ok("添加成功");
            throw new Exception("添加失败");
        }catch(Exception e){
            log.error("ClassesService saveClasses ERROR => {}" , e.getMessage());
            return Result.error(e.getMessage());
        }
    }


    /**
     * 修改表单对象
     * @author za
     * @date 2023-03-08
     */
    @Override
    public Result updateClasses(ClassesEntity classes) {
        try{
            Assert.notNull(classes,"参数异常");
            boolean flag = this.updateById(classes);
            if (flag) return Result.ok("修改成功");
            throw new Exception("修改失败");
        }catch(Exception e){
            log.error("ClassesService updateClasses ERROR => {}" , e.getMessage());
            return Result.error(e.getMessage());
        }
    }


    /**
     * 通过id删除表单
     * @author za
     * @date 2023-03-08
     */
    @Override
    public Result deleteClasses(Long id) {
        try{
            Assert.notNull(id,"参数异常");
            boolean flag = this.removeById(id);
            if (flag) return Result.ok("删除成功");
            throw new Exception("删除失败");
        }catch(Exception e){
            log.error("ClassesService deleteClasses ERROR => {}" , e.getMessage());
            return Result.error(e.getMessage());
        }
    }




}