package cn.e3.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.e3.manager.service.ItemCatService;
import cn.e3.utils.TreeNode;

@RestController
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
	/**
	 * 需求:根据parent_id查询此节点的子节点
	 * 请求:/item/cat/list
	 * 参数:Long parentId 因为前台传递过来的是id  那么我们只有通过起别名来绑定 第一次没有传递参数
	 * 需要返回的是List<TreeNode> json格式
	 */
	@RequestMapping("item/cat/list")
	public List<TreeNode> findItemCatTreeNodeList(@RequestParam(value="id",defaultValue="0")Long parentId) {
		return itemCatService.findItemCatTreeNodeList(parentId);
	}
}
