package com.goddess.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * 功能描述：使用
 *
 * @Author: 曹锋年
 * @Date: 2020/10/23 15:03
 */
@Getter
@Setter
public class Book {
	@Id
	private String id;
	//价格
	private Integer price;
	//书名
	private String name;
	//简介
	private String info;
	//出版社
	private String publish;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;
}
