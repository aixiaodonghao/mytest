package cn.itcast.crm.service;

import java.util.List;

import cn.itcast.crm.pojo.BaseDict;

public interface BaseDictService {
	 /**
	  * �����������ѯ
	  * @param dicttypecode
	  * @return
	  */
	 List<BaseDict> fandBaseDictByDictTypeCode(String dicttypecode);
	 
}
 