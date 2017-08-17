package cn.itcast.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.crm.mapper.BaseDictMapper;
import cn.itcast.crm.pojo.BaseDict;
@Service 
public class BaseDictServiceImpl implements BaseDictService {
	@Autowired
	private BaseDictMapper baseDictMapper;
	@Override
	public List<BaseDict> fandBaseDictByDictTypeCode(String dicttypecode) {
		List<BaseDict> list = baseDictMapper.fandBaseDictByDictTypeCode(dicttypecode);
		return list;
	}

}
