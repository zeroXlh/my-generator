package com.hoper.jjs.mapper.logs;

import com.hoper.jjs.model.logs.JjsOperateLog;

public interface JjsOperateLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JjsOperateLog record);

    int insertSelective(JjsOperateLog record);

    JjsOperateLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JjsOperateLog record);

    int updateByPrimaryKey(JjsOperateLog record);
}