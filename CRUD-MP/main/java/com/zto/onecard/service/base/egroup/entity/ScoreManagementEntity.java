package com.zto.onecard.service.base.egroup.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 *  实体类
 * @author run
 * @email 2940544565@qq.com
 * @date 2023-03-03 14:59:33
 */
@Data
@TableName("score_management")
public class ScoreManagementEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer studentId;
	/**
	 * 
	 */
	private Integer courseId;
	/**
	 * 
	 */
	private Integer score;
	/**
	 * 
	 */
	private String remark;

}
