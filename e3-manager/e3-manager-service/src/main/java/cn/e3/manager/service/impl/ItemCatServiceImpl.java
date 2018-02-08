package cn.e3.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.e3.manager.service.ItemCatService;
import cn.e3.mapper.TbItemCatMapper;
import cn.e3.pojo.TbItemCat;
import cn.e3.pojo.TbItemCatExample;
import cn.e3.pojo.TbItemCatExample.Criteria;
import cn.e3.utils.TreeNode;

public class ItemCatServiceImpl implements ItemCatService {

	// 注入商品分类的mapper
	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public List<TreeNode> findItemCatTreeNodeList(Long parentId) {
		// 创建商品分类集合对象 ,封装树形节点值
		List<TreeNode> nodeList = new ArrayList<>();

		// 创建商品分类example对象
		TbItemCatExample example = new TbItemCatExample();
		// 设置查询参数
		Criteria criteria = example.createCriteria();

		criteria.andParentIdEqualTo(parentId);

		List<TbItemCat> list = itemCatMapper.selectByExample(example);

		for (TbItemCat tbItemCat : list) {
			TreeNode node = new TreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent() ? "closed" : "open");// 因为tbItemCat是boolean类型
			
			//把节点对象放入节点集合中即可
			nodeList.add(node);
		}
		//返回即可
		return nodeList;
	}

}
