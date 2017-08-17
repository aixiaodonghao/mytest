package cn.itcast.crm.mapper;

import java.util.List;

import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.QueryVo;

public interface CustomerMapper {
	/**
	 * չʾ����ԃ�͑��б�
	 * @param vo
	 * @return
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
