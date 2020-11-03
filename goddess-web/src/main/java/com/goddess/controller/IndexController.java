package com.goddess.controller;

import com.goddess.entity.Book;
import com.goddess.entity.UserEntity;
import com.goddess.service.MongoDbService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author sgl
 * @Date 2018-05-08 10:47
 */
@Controller
public class IndexController {

	@Autowired
	private MongoDbService mongoDbService;

	/**
	 * 首页，并将登录用户的全名返回前台
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"/", "/index"})
	public String index(Model model) {
		UserEntity sysUser = (UserEntity) SecurityUtils.getSubject().getPrincipal();
		model.addAttribute("userName", sysUser.getFullName());
		return "index";
	}

	@PostMapping(value = "/mongdb/saveBook")
	public String saveBook() {
		Book book = new Book();
		book.setInfo("测试");
		mongoDbService.saveObj(book);
		return "";
	}
}
