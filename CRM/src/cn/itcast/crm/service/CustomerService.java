package cn.itcast.crm.service;

import java.util.List;

import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.QueryVo;

public interface CustomerService {
	/**
	 * չʾ����ѯ�ͻ��б�
	 * @author 41736
	 *
	 */
	public List<Customer> findCustomerListByQueryVo(QueryVo vo);
	/**
	 * ��ѯ������
	 * @param vo
	 * @return
	 */
	public int findCustomerCount(QueryVo vo);
	/**
	 * ����Id��ѯ�ͻ�
	 * @param id 
	 * @return
	 */
	public Customer findCustomerById(Long id);
	/**
	 * ���ݿͻ�Id�޸Ŀͻ���Ϣ
	 * @param customer
	 */
	public void updateCustomerById(Customer customer);
	/**
	 * ���ݿͻ�Idɾ���ͻ���Ϣ
	 * @param id
	 */
	public void deleteCustomerById(Long id);
}