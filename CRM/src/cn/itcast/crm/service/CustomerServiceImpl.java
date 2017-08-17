package cn.itcast.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.crm.mapper.CustomerMapper;
import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.QueryVo;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerMapper customerMapper;
	
	/**
	 * 展示所查询客户列表
	 */
	@Override
	public List<Customer> findCustomerListByQueryVo(QueryVo vo) {
		List<Customer> list = customerMapper.findCustomerListByQueryVo(vo);
		return list;
	}
	/**
	 * 查询总条数
	 * @param vo
	 * @return
	 */
	@Override
	public int findCustomerCount(QueryVo vo) {
		int count = customerMapper.findCustomerCount(vo);
		return count;
	}
	/**
	 * 根据Id查询客户
	 * @param id 
	 * @return
	 */
	@Override
	public Customer findCustomerById(Long id) {
		Customer customer = customerMapper.findCustomerById(id);
		return customer;
	}
	/**
	 * 根据客户Id修改客户信息
	 * @param customer
	 */
	@Override
	public void updateCustomerById(Customer customer) {
		customerMapper.updateCustomerById(customer);
	}
	/**
	 * 根据客户Id删除客户信息
	 * @param id
	 */
	@Override
	public void deleteCustomerById(Long id) {
		customerMapper.deleteCustomerById(id);
	}
}
