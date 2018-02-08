package cn.e3.utils;

import java.io.Serializable;

public class TreeNode implements Serializable {
	/**
	 * 我们需要将tree需要的返回值进行封装
	 */
	// 树形节点的id
	private Long id;

	// 树形节点的名称
	private String text;

	// 树形节点的状态
	// is_parent=1,表示有节点,state="closed",表示可以打开 反之即可
	private String state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
