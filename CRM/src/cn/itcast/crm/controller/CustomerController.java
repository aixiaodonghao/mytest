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
	// 客户来源
	@Value("${CUSTOMER_FROM_TYPE}")
	private String CUSTOMER_FROM_TYPE;
	// 客户行业
	@Value("${CUSTOMER_INDUSTRY_TYPE}")
	private String CUSTOMER_INDUSTRY_TYPE;
	// 客户级别
	@Value("${CUSTOMER_LEVEL_TYPE}")
	private String CUSTOMER_LEVEL_TYPE;
	
	@Autowired
	private BaseDictService baseDictService;
	
	@Autowired
	private CustomerService customerService;
	/**
	 * 显示客户列表
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("list")
	public String list(QueryVo vo,Model model) throws Exception{
		//解决客户名称乱码问题
		if(vo.getCustName()!=null){
			vo.setCustName(new String(vo.getCustName().getBytes("iso-8859-1"),"utf-8"));
		}
		//查詢高級搜素的下拉框列表
		//客户来源
		List<BaseDict> sourceList = baseDictService.fandBaseDictByDictTypeCode(CUSTOMER_FROM_TYPE);
		//客户所属行业
		List<BaseDict> industryList = baseDictService.fandBaseDictByDictTypeCode(CUSTOMER_INDUSTRY_TYPE);
		//客户级别
		List<BaseDict> LevelList = baseDictService.fandBaseDictByDictTypeCode(CUSTOMER_LEVEL_TYPE);
		
		//注意：：：：：：：：：
		//在分页前要设置从哪一个标号开始查询
		if(vo.getStart() == null){
			vo.setStart((vo.getPage() - 1) * vo.getSize());
		}
				
		//获取客户列表信息
		List<Customer> customerList = customerService.findCustomerListByQueryVo(vo);
		//查询总条数
		int count = customerService.findCustomerCount(vo);
		//构造Page对象
		Page<Customer> page = new Page<Customer>(); 
		//总条数
		page.setTotal(count);
		//当前页面
		page.setPage(vo.getPage());
		//每页显示的条数
		page.setSize(vo.getSize());
		//查询的集合数据
		page.setRows(customerList);
		//返回页面客户列表数据
		model.addAttribute("page", page); 
				
		//返回下拉框数据
		model.addAttribute("fromType",sourceList);
		model.addAttribute("industryType",industryList);
		model.addAttribute("levelType",LevelList);
		//回显下拉框数据
		model.addAttribute("custSource",vo.getCustSource());
		model.addAttribute("custIndustry",vo.getCustIndustry());
		model.addAttribute("custLevel",vo.getCustLevel());
		model.addAttribute("custName",vo.getCustName());
		
		return "customer";
	}
	/**
	 * 修改页面信息回显
	 * @param id
	 * @return
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Customer edit(Long id){
		//根据Id查询客户信息
		Customer customer =customerService.findCustomerById(id);
		return customer;
	}
	/**
	 * 修改客户信息
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
	 * 删除客户信息
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
