package com.sitech.bds.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sitech.bds.mp.common.utils.Result;
import com.sitech.bds.mp.entity.ClassesEntity;


/**
 * 
 * @author za
 * @date 2023-03-08
 */
public interface ClassesService extends IService<ClassesEntity> {

    public static final String BEAN_ID = "audio.classesService";

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
     Result saveClasses(ClassesEntity classes);


    /**
     * 修改表单对象
     * @author za
     * @date 2023-03-08
     */
     Result updateClasses(ClassesEntity classes);

    /**
     * 删除指定ID的
     * @author za
     * @date 2023-03-08
     */
     Result deleteClasses(Long id);

}

