package cn.e3.utils;

import java.io.Serializable;
import java.util.List;
/**
 * 分页结果对象
 * @author @li
 * 2018年2月6日
 * 下午3:36:47
 *
 */

public class PageResult implements Serializable{

	private Long total;
	
	private List<?> rows;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	
}
