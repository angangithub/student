package com.sitech.bds.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sitech.bds.mp.common.utils.Result;
import com.sitech.bds.mp.entity.EnrollmentsEntity;


/**
 * 
 * @author za
 * @date 2023-03-08
 */
public interface EnrollmentsService extends IService<EnrollmentsEntity> {

    public static final String BEAN_ID = "audio.enrollmentsService";

    /**
     * 分页查询列表
     * @author za
     * @date 2023-03-08
     */
     Result pagination(Integer current, Integer size);


    /**
     * 创建表单对象
     * @author za
     * @date 2023-03-08
     */
     Result saveEnrollments(EnrollmentsEntity enrollments);


    /**
     * 修改表单对象
     * @author za
     * @date 2023-03-08
     */
     Result updateEnrollments(EnrollmentsEntity enrollments);

    /**
     * 删除指定ID的
     * @author za
     * @date 2023-03-08
     */
     Result deleteEnrollments(Long id);

}

