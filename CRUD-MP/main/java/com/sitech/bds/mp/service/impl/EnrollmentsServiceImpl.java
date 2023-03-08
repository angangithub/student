package com.sitech.bds.mp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sitech.bds.mp.common.utils.Result;
import com.sitech.bds.mp.entity.EnrollmentsEntity;
import com.sitech.bds.mp.mapper.EnrollmentsMapper;
import com.sitech.bds.mp.service.EnrollmentsService;
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
public class EnrollmentsServiceImpl extends ServiceImpl<EnrollmentsMapper, EnrollmentsEntity> implements EnrollmentsService {

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
            Page<EnrollmentsEntity> page = new Page<>(current,size);
            QueryWrapper<EnrollmentsEntity> wrapper = new QueryWrapper<>();
            wrapper.orderByDesc("create_time");
            baseMapper.selectPage(page,wrapper);
            return Result.ok(page);
        }catch(Exception e){
            log.error("EnrollmentsService queryForPage ERROR => {}" , e.getMessage());
            return Result.error(e.getMessage());
        }
    }

    /**
     * 创建表单对象
     * @author za
     * @date 2023-03-08
     */
    @Override
    public Result saveEnrollments(EnrollmentsEntity enrollments) {
        try{
            Assert.notNull(enrollments,"参数异常");
            boolean flag = this.save(enrollments);
            if (flag) return Result.ok("添加成功");
            throw new Exception("添加失败");
        }catch(Exception e){
            log.error("EnrollmentsService saveEnrollments ERROR => {}" , e.getMessage());
            return Result.error(e.getMessage());
        }
    }


    /**
     * 修改表单对象
     * @author za
     * @date 2023-03-08
     */
    @Override
    public Result updateEnrollments(EnrollmentsEntity enrollments) {
        try{
            Assert.notNull(enrollments,"参数异常");
            boolean flag = this.updateById(enrollments);
            if (flag) return Result.ok("修改成功");
            throw new Exception("修改失败");
        }catch(Exception e){
            log.error("EnrollmentsService updateEnrollments ERROR => {}" , e.getMessage());
            return Result.error(e.getMessage());
        }
    }


    /**
     * 通过id删除表单
     * @author za
     * @date 2023-03-08
     */
    @Override
    public Result deleteEnrollments(Long id) {
        try{
            Assert.notNull(id,"参数异常");
            boolean flag = this.removeById(id);
            if (flag) return Result.ok("删除成功");
            throw new Exception("删除失败");
        }catch(Exception e){
            log.error("EnrollmentsService deleteEnrollments ERROR => {}" , e.getMessage());
            return Result.error(e.getMessage());
        }
    }




}