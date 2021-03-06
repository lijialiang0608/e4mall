package cn.e3.manager.service;

import java.util.List;

import cn.e3.utils.TreeNode;

public interface ItemCatService {
	/**
	 * 需求:根据parent_id查询此节点的子节点
	 * 参数:Long parentId
	 * 返回值:List<TreeNode>
	 */
	public List<TreeNode> findItemCatTreeNodeList(Long parentId);
	
}
