package com.sitech.bds.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sitech.bds.mp.common.utils.Result;
import com.sitech.bds.mp.entity.CoursesEntity;


/**
 * 
 * @author za
 * @date 2023-03-08
 */
public interface CoursesService extends IService<CoursesEntity> {

    public static final String BEAN_ID = "audio.coursesService";

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
     Result saveCourses(CoursesEntity courses);


    /**
     * 修改表单对象
     * @author za
     * @date 2023-03-08
     */
     Result updateCourses(CoursesEntity courses);

    /**
     * 删除指定ID的
     * @author za
     * @date 2023-03-08
     */
     Result deleteCourses(Long id);

}

