package com.zto.onecard.service.base.egroup.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.zto.onecard.common.utils.Result;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;

import com.zto.onecard.service.base.egroup.mapper.ScoreManagementMapper;
import com.zto.onecard.service.base.egroup.entity.ScoreManagementEntity;
import com.zto.onecard.service.base.egroup.service.ScoreManagementService;

/**
 * 
 * @author run
 * @email 2940544565@qq.com
 * @date 2023-03-03 14:59:33
 */
@Service
@Slf4j
public class ScoreManagementServiceImpl extends ServiceImpl<ScoreManagementMapper, ScoreManagementEntity> implements ScoreManagementService {

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
            Page<ScoreManagementEntity> page = new Page<>(current,size);
            List<ScoreManagementEntity> records = baseMapper.queryForPage(params,page);
            log.info("queryForPage database return => {}",records);
            page.setRecords(records);
            return Result.ok(page);
        }catch(Exception e){
            log.error("ScoreManagementService queryForPage ERROR => {}" , e.getMessage());
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
            ScoreManagementEntity scoreManagement = baseMapper.queryById(id);
            return Result.ok(scoreManagement);
        }catch(Exception e){
            log.error("ScoreManagementService queryById ERROR => {}" , e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 创建表单对象
     * @author run
     * @date 2023-03-03 14:59:33
     */
    @Override
    public Result insert(ScoreManagementEntity scoreManagement) {
        try{
            log.info("ScoreManagementService insert start form => {}",scoreManagement);
            baseMapper.insert(scoreManagement);
            // mybatis版 Boolean flag = baseMapper.create(scoreManagement);
            return Result.ok("添加成功");
        }catch(Exception e){
            log.error("ScoreManagementService insert ERROR => {}" , e.getMessage());
            return Result.error(e.getMessage());
        }
    }


    /**
     * 修改表单对象
     * @author run
     * @date 2023-03-03 14:59:33
     */
    @Override
    public Result modifyById(ScoreManagementEntity scoreManagement) {
        try{
            log.info("modifyById start form => {}",scoreManagement);
            Integer count = baseMapper.modifyById(scoreManagement);
            return Result.ok("修改成功");
        }catch(Exception e){
            log.error("ScoreManagementService modifyById ERROR => {}" , e.getMessage());
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
            log.error("ScoreManagementService del ERROR => {}" , e.getMessage());
            return Result.error(e.getMessage());
        }
    }




}