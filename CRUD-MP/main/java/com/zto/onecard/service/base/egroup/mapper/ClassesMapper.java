package com.zto.onecard.service.base.egroup.mapper;

import com.zto.onecard.service.base.egroup.entity.ClassesEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.Map;
/**
 * 
 * @author run
 * @email 2940544565@qq.com
 * @date 2023-03-03 14:59:33
 */
@Mapper
public interface ClassesMapper extends BaseMapper<ClassesEntity> {

    /**
     * 分页查询列表
     * @author run
     * @date 2023-03-03 14:59:33
     */
    List<ClassesEntity> queryForPage(@Param("params") Map<String, Object> params,Page<ClassesEntity> page);

    /**
     * 添加实体入库
     * @return {@link Boolean}
     */
    Boolean create(ClassesEntity classes);


    /**
     * 修改实体
     * @return {@link Integer}
     */
    Integer modifyById(ClassesEntity classes);

    /**
     * 查询通过id
     * @param id id
     */
      ClassesEntity queryById(@Param("id") Long id);

    /**
     * 查询统计
     * @return {@link Integer}
     */
    Integer queryCount();

    /**
     * 通过id删除
     * @param id id
     */
    void delById(@Param("id") Long id);

    /**
     * 删除ids
     * @param ids id
     */
    void delByIds(@Param("ids") List<Long> ids);

}
