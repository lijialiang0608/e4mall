package cn.e3.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	/**
	 * 需求:页面跳转
	 * localhost:8082/index
	 * localhost:8082/item-list
	 * localhost:8082/item-add
	 * 请求名称其实等于页面的名称
	 */
	
	@RequestMapping("{page}")
	public String showPage(@PathVariable String page){
		return  page;
	}
}
