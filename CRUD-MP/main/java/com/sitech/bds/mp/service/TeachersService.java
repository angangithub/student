package com.sitech.bds.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sitech.bds.mp.common.utils.Result;
import com.sitech.bds.mp.entity.TeachersEntity;


/**
 * 
 * @author za
 * @date 2023-03-08
 */
public interface TeachersService extends IService<TeachersEntity> {

    public static final String BEAN_ID = "audio.teachersService";

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
     Result saveTeachers(TeachersEntity teachers);


    /**
     * 修改表单对象
     * @author za
     * @date 2023-03-08
     */
     Result updateTeachers(TeachersEntity teachers);

    /**
     * 删除指定ID的
     * @author za
     * @date 2023-03-08
     */
     Result deleteTeachers(Long id);

}

