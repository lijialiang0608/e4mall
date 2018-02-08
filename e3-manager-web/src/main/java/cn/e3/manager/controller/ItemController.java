package cn.e3.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.e3.manager.service.ItemService;
import cn.e3.pojo.TbItem;
import cn.e3.utils.PageResult;

@RestController
public class ItemController {
	
	//注入service服务对象
	@Autowired
	private ItemService itemService;
	
	
	/**
	 * 需求:根据商品id查询商品数据
	 * 请求:item/{itemId}
	 * 参数:Long itemId
	 * 返回值:TbItem
	 */
	@RequestMapping("item/{itemId}")
	public TbItem findItemById(@PathVariable Long itemId){
		//调用service服务方法
		TbItem item = itemService.findItemById(itemId);
		return item;
	}
	
	/**
	 * page :当前页
	 * rows :每页显示的大小
	 * 2018年2月6日
	 * 下午3:51:13
	 * @li
	 */
	@RequestMapping("item/list")
	public PageResult findItemListByPage(@RequestParam(defaultValue="1")Integer page,@RequestParam(defaultValue="20")Integer rows){
		
		return itemService.findItemListByPage(page, rows);
	}

}
