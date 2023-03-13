package com.sitech.bds.mp.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 *  实体类
 * @author za
 * @date 2023-03-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="班级", description="")
@TableName("classes")
public class ClassesEntity implements Serializable {

	private static final long serialVersionUID = 1L;


	@TableId
	@ApiModelProperty(value = "")
	private Integer id;

	@ApiModelProperty(value = "")
	private String name;

	@ApiModelProperty(value = "")
	private Integer grade;

	@ApiModelProperty(value = "")
	private Integer teacherId;

}
