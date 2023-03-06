package com.zto.onecard.service.base.egroup.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;

import com.zto.onecard.common.utils.Result;
import com.zto.onecard.service.base.egroup.mapper.ClassesMapper;
import com.zto.onecard.service.base.egroup.entity.ClassesEntity;
import com.zto.onecard.service.base.egroup.service.ClassesService;

/**
 * 
 * @author run
 * @email 2940544565@qq.com
 * @date 2023-03-03 14:59:33
 */
@Service
@Slf4j
public class ClassesServiceImpl extends ServiceImpl<ClassesMapper, ClassesEntity> implements ClassesService {

    /**
     * 查询列表
     * @author run
     * @date 2023-03-03 14:59:33
     */
    @Override
    public Result queryForPage(Map<String, Object> params) {
        try{
            log.info("queryForPage start is params => {}",params);
            Integer current = (Integer) params.get("cuurent");
            Integer size = (Integer) params.get("size");
            Page<ClassesEntity> page = new Page<>(current,size);
            List<ClassesEntity> records = baseMapper.queryForPage(params,page);
            log.info("queryForPage database return => {}",records);
            page.setRecords(records);
            return Result.ok(page);
        }catch(Exception e){
            log.error("ClassesService queryForPage ERROR => {}" , e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 通过id返回结果
     * @author run
     * @date 2023-03-03 14:59:33
     */
    @Override
    public Result queryById(Long id) {
        try{
            log.info("queryById start is id => {}",id);
            ClassesEntity classes = baseMapper.queryById(id);
            return Result.ok(classes);
        }catch(Exception e){
            log.error("ClassesService queryById ERROR => {}" , e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 创建表单对象
     * @author run
     * @date 2023-03-03 14:59:33
     */
    @Override
    public Result insert(ClassesEntity classes) {
        try{
            log.info("ClassesService insert start form => {}",classes);
            baseMapper.insert(classes);
            // mybatis版 Boolean flag = baseMapper.create(classes);
            return Result.ok("添加成功");
        }catch(Exception e){
            log.error("ClassesService insert ERROR => {}" , e.getMessage());
            return Result.error(e.getMessage());
        }
    }


    /**
     * 修改表单对象
     * @author run
     * @date 2023-03-03 14:59:33
     */
    @Override
    public Result modifyById(ClassesEntity classes) {
        try{
            log.info("modifyById start form => {}",classes);
            Integer count = baseMapper.modifyById(classes);
            return Result.ok("修改成功");
        }catch(Exception e){
            log.error("ClassesService modifyById ERROR => {}" , e.getMessage());
            return Result.error(e.getMessage());
        }
    }


    /**
     * 通过id删除表单
     * @author run
     * @date 2023-03-03 14:59:33
     */
    @Override
    public Result del(Long id) {
        try{
            log.info("del start is id => {}",id);
            baseMapper.delById(id);
            return Result.ok("删除成功");
        }catch(Exception e){
            log.error("ClassesService del ERROR => {}" , e.getMessage());
            return Result.error(e.getMessage());
        }
    }




}