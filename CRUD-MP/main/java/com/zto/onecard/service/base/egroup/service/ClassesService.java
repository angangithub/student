package com.zto.onecard.service.base.egroup.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import com.zto.onecard.common.utils.Result;
import com.zto.onecard.service.base.egroup.entity.ClassesEntity;

import java.util.Map;

/**
 * 
 * @author run
 * @email 2940544565@qq.com
 * @date 2023-03-03 14:59:33
 */
public interface ClassesService extends IService<ClassesEntity> {

    /**
     * 分页查询列表
     * @author run
     * @date 2023-03-03 14:59:33
     */
     Result queryForPage(Map<String, Object> params);

    /**
     * 通过id返回结果
     * @author run
     * @date 2023-03-03 14:59:33
     */
     Result queryById(Long id);


    /**
     * 创建表单对象
     * @author run
     * @date 2023-03-03 14:59:33
     */
     Result insert(ClassesEntity classes);


    /**
     * 修改表单对象
     * @author run
     * @date 2023-03-03 14:59:33
     */
     Result modifyById(ClassesEntity classes);

    /**
     * 删除指定ID
     * @author run
     * @date 2023-03-03 14:59:33
     */
     Result del(Long id);

}

