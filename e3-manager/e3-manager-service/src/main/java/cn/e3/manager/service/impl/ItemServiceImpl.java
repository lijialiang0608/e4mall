package cn.e3.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3.manager.service.ItemService;
import cn.e3.mapper.TbItemMapper;
import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemExample;
import cn.e3.utils.PageResult;
@Service
public class ItemServiceImpl implements ItemService {

	//注入商品mapper接口代理对象
	@Autowired
	private TbItemMapper itemMapper;
	
	/**
	 * 需求:根据商品id查询商品数据
	 * 参数:Long itemId
	 * 返回值:TbItem
	 */
	public TbItem findItemById(Long itemId) {
		// 根据商品id查询商品数据
		TbItem item = itemMapper.selectByPrimaryKey(itemId);
		
		return item;
	}

	//分页查询商品列表
	public PageResult findItemListByPage(Integer page, Integer rows) {
		TbItemExample tbItemExample = new TbItemExample();
		
		//在执行查询之前我们设置分页参数即可
		PageHelper.startPage(page, rows);
		
		//下面查询将会被拦截器拦截查询
		
		//list集合数据会变化:page:(total,pages(总页码)),list分页集合
		List<TbItem> example = itemMapper.selectByExample(tbItemExample);
		
		//创建一个分页信息对象
		PageInfo<TbItem> pageInfo = new PageInfo<>(example);//用pageinfo对我们的那个集合进行解析
		
		//创建分页包装类对象
		PageResult result = new PageResult();
		
		result.setTotal(pageInfo.getTotal());
		result.setRows(example);
		
		
		return result;
	}

}
