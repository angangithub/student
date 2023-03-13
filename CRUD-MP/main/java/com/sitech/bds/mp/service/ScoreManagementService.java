package com.sitech.bds.mp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sitech.bds.mp.entity.ScoreManagementEntity;
import com.sitech.bds.mp.common.utils.Result;


/**
 * 
 * @author za
 * @date 2023-03-08
 */
public interface ScoreManagementService extends IService<ScoreManagementEntity> {

    public static final String BEAN_ID = "audio.scoreManagementService";

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
     Result saveScoreManagement(ScoreManagementEntity scoreManagement);


    /**
     * 修改表单对象
     * @author za
     * @date 2023-03-08
     */
     Result updateScoreManagement(ScoreManagementEntity scoreManagement);

    /**
     * 删除指定ID的
     * @author za
     * @date 2023-03-08
     */
     Result deleteScoreManagement(Long id);

}

