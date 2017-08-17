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
	 * չʾ����ѯ�ͻ��б�
	 */
	@Override
	public List<Customer> findCustomerListByQueryVo(QueryVo vo) {
		List<Customer> list = customerMapper.findCustomerListByQueryVo(vo);
		return list;
	}
	/**
	 * ��ѯ������
	 * @param vo
	 * @return
	 */
	@Override
	public int findCustomerCount(QueryVo vo) {
		int count = customerMapper.findCustomerCount(vo);
		return count;
	}
	/**
	 * ����Id��ѯ�ͻ�
	 * @param id 
	 * @return
	 */
	@Override
	public Customer findCustomerById(Long id) {
		Customer customer = customerMapper.findCustomerById(id);
		return customer;
	}
	/**
	 * ���ݿͻ�Id�޸Ŀͻ���Ϣ
	 * @param customer
	 */
	@Override
	public void updateCustomerById(Customer customer) {
		customerMapper.updateCustomerById(customer);
	}
	/**
	 * ���ݿͻ�Idɾ���ͻ���Ϣ
	 * @param id
	 */
	@Override
	public void deleteCustomerById(Long id) {
		customerMapper.deleteCustomerById(id);
	}
}
