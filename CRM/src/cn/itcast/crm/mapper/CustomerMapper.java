package cn.itcast.crm.mapper;

import java.util.List;

import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.QueryVo;

public interface CustomerMapper {
	/**
	 * 展示所查詢客戶列表
	 * @param vo
	 * @return
	 */
	public List<Customer> findCustomerListByQueryVo(QueryVo vo);
	/**
	 * 查询总条数
	 * @param vo
	 * @return
	 */
	public int findCustomerCount(QueryVo vo);
	/**
	 * 根据Id查询客户
	 * @param id 
	 * @return
	 */
	public Customer findCustomerById(Long id);
	/**
	 * 根据客户Id修改客户信息
	 * @param customer
	 */
	public void updateCustomerById(Customer customer);
	/**
	 * 根据客户Id删除客户信息
	 * @param id
	 */
	public void deleteCustomerById(Long id);
}
