package com.sitech.bds.mp.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 *  实体类
 * @author za
 * @date 2023-03-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="选课", description="")
@TableName("enrollments")
public class EnrollmentsEntity implements Serializable {

	private static final long serialVersionUID = 1L;


	@TableId
	@ApiModelProperty(value = "")
	private Integer id;

	@ApiModelProperty(value = "")
	private Integer studentId;

	@ApiModelProperty(value = "")
	private Integer courseId;

	@ApiModelProperty(value = "")
	private Date enrollDate;

}
