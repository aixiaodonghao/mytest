package cn.itcast.crm.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.crm.pojo.BaseDict;
import cn.itcast.crm.pojo.Customer;
import cn.itcast.crm.pojo.QueryVo;
import cn.itcast.crm.service.BaseDictService;
import cn.itcast.crm.service.CustomerService;
import cn.itcast.utils.Page;

@Controller
@RequestMapping("customer")
public class CustomerController {
	// �ͻ���Դ
	@Value("${CUSTOMER_FROM_TYPE}")
	private String CUSTOMER_FROM_TYPE;
	// �ͻ���ҵ
	@Value("${CUSTOMER_INDUSTRY_TYPE}")
	private String CUSTOMER_INDUSTRY_TYPE;
	// �ͻ�����
	@Value("${CUSTOMER_LEVEL_TYPE}")
	private String CUSTOMER_LEVEL_TYPE;
	
	@Autowired
	private BaseDictService baseDictService;
	
	@Autowired
	private CustomerService customerService;
	/**
	 * ��ʾ�ͻ��б�
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("list")
	public String list(QueryVo vo,Model model) throws Exception{
		//����ͻ�������������
		if(vo.getCustName()!=null){
			vo.setCustName(new String(vo.getCustName().getBytes("iso-8859-1"),"utf-8"));
		}
		//��ԃ�߼����ص��������б�
		//�ͻ���Դ
		List<BaseDict> sourceList = baseDictService.fandBaseDictByDictTypeCode(CUSTOMER_FROM_TYPE);
		//�ͻ�������ҵ
		List<BaseDict> industryList = baseDictService.fandBaseDictByDictTypeCode(CUSTOMER_INDUSTRY_TYPE);
		//�ͻ�����
		List<BaseDict> LevelList = baseDictService.fandBaseDictByDictTypeCode(CUSTOMER_LEVEL_TYPE);
		
		//ע�⣺����������������
		//�ڷ�ҳǰҪ���ô���һ����ſ�ʼ��ѯ
		if(vo.getStart() == null){
			vo.setStart((vo.getPage() - 1) * vo.getSize());
		}
				
		//��ȡ�ͻ��б���Ϣ
		List<Customer> customerList = customerService.findCustomerListByQueryVo(vo);
		//��ѯ������
		int count = customerService.findCustomerCount(vo);
		//����Page����
		Page<Customer> page = new Page<Customer>(); 
		//������
		page.setTotal(count);
		//��ǰҳ��
		page.setPage(vo.getPage());
		//ÿҳ��ʾ������
		page.setSize(vo.getSize());
		//��ѯ�ļ�������
		page.setRows(customerList);
		//����ҳ��ͻ��б�����
		model.addAttribute("page", page); 
				
		//��������������
		model.addAttribute("fromType",sourceList);
		model.addAttribute("industryType",industryList);
		model.addAttribute("levelType",LevelList);
		//��������������
		model.addAttribute("custSource",vo.getCustSource());
		model.addAttribute("custIndustry",vo.getCustIndustry());
		model.addAttribute("custLevel",vo.getCustLevel());
		model.addAttribute("custName",vo.getCustName());
		
		return "customer";
	}
	/**
	 * �޸�ҳ����Ϣ����
	 * @param id
	 * @return
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Customer edit(Long id){
		//����Id��ѯ�ͻ���Ϣ
		Customer customer =customerService.findCustomerById(id);
		return customer;
	}
	/**
	 * �޸Ŀͻ���Ϣ
	 * @param customer
	 * @return
	 */
	@RequestMapping("update")
	@ResponseBody
	public String update(Customer customer){
		customerService.updateCustomerById(customer);
		return "OK";
	}
	/**
	 * ɾ���ͻ���Ϣ
	 * @param id
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public String delete(Long id){
		customerService.deleteCustomerById(id);
		return "OK";
	}
}
