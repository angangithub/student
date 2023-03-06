package com.zto.onecard.service.base.egroup.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;

import com.zto.onecard.common.utils.Result;
import com.zto.onecard.service.base.egroup.mapper.EnrollmentsMapper;
import com.zto.onecard.service.base.egroup.entity.EnrollmentsEntity;
import com.zto.onecard.service.base.egroup.service.EnrollmentsService;

/**
 * 
 * @author run
 * @email 2940544565@qq.com
 * @date 2023-03-03 14:59:33
 */
@Service
@Slf4j
public class EnrollmentsServiceImpl extends ServiceImpl<EnrollmentsMapper, EnrollmentsEntity> implements EnrollmentsService {

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
            Page<EnrollmentsEntity> page = new Page<>(current,size);
            List<EnrollmentsEntity> records = baseMapper.queryForPage(params,page);
            log.info("queryForPage database return => {}",records);
            page.setRecords(records);
            return Result.ok(page);
        }catch(Exception e){
            log.error("EnrollmentsService queryForPage ERROR => {}" , e.getMessage());
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
            EnrollmentsEntity enrollments = baseMapper.queryById(id);
            return Result.ok(enrollments);
        }catch(Exception e){
            log.error("EnrollmentsService queryById ERROR => {}" , e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 创建表单对象
     * @author run
     * @date 2023-03-03 14:59:33
     */
    @Override
    public Result insert(EnrollmentsEntity enrollments) {
        try{
            log.info("EnrollmentsService insert start form => {}",enrollments);
            baseMapper.insert(enrollments);
            // mybatis版 Boolean flag = baseMapper.create(enrollments);
            return Result.ok("添加成功");
        }catch(Exception e){
            log.error("EnrollmentsService insert ERROR => {}" , e.getMessage());
            return Result.error(e.getMessage());
        }
    }


    /**
     * 修改表单对象
     * @author run
     * @date 2023-03-03 14:59:33
     */
    @Override
    public Result modifyById(EnrollmentsEntity enrollments) {
        try{
            log.info("modifyById start form => {}",enrollments);
            Integer count = baseMapper.modifyById(enrollments);
            return Result.ok("修改成功");
        }catch(Exception e){
            log.error("EnrollmentsService modifyById ERROR => {}" , e.getMessage());
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
            log.error("EnrollmentsService del ERROR => {}" , e.getMessage());
            return Result.error(e.getMessage());
        }
    }




}