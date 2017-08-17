package cn.itcast.crm.mapper;

import java.util.List;

import cn.itcast.crm.pojo.BaseDict;

public interface BaseDictMapper {

	List<BaseDict> fandBaseDictByDictTypeCode(String dicttypecode);
}
