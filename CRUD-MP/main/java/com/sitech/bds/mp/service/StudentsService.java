package com.sitech.bds.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sitech.bds.mp.entity.StudentsEntity;
import com.sitech.bds.mp.common.utils.Result;


/**
 * 
 * @author za
 * @date 2023-03-08
 */
public interface StudentsService extends IService<StudentsEntity> {

    public static final String BEAN_ID = "audio.studentsService";

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
     Result saveStudents(StudentsEntity students);


    /**
     * 修改表单对象
     * @author za
     * @date 2023-03-08
     */
     Result updateStudents(StudentsEntity students);

    /**
     * 删除指定ID的
     * @author za
     * @date 2023-03-08
     */
     Result deleteStudents(Long id);

}

