package com.sitech.bds.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sitech.bds.mp.common.utils.Result;
import com.sitech.bds.mp.entity.GradesEntity;


/**
 * 
 * @author za
 * @date 2023-03-08
 */
public interface GradesService extends IService<GradesEntity> {

    public static final String BEAN_ID = "audio.gradesService";

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
     Result saveGrades(GradesEntity grades);


    /**
     * 修改表单对象
     * @author za
     * @date 2023-03-08
     */
     Result updateGrades(GradesEntity grades);

    /**
     * 删除指定ID的
     * @author za
     * @date 2023-03-08
     */
     Result deleteGrades(Long id);

}

