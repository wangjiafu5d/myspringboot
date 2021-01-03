package com.chuan.myspringboot.dao;

import com.chuan.myspringboot.bean.ManageRcord;
import com.chuan.myspringboot.bean.ManageRcordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface ManageRcordMapper {
    long countByExample(ManageRcordExample example);

    int deleteByExample(ManageRcordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ManageRcord record);

    int insertSelective(ManageRcord record);

    List<ManageRcord> selectByExample(ManageRcordExample example);

    ManageRcord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ManageRcord record, @Param("example") ManageRcordExample example);

    int updateByExample(@Param("record") ManageRcord record, @Param("example") ManageRcordExample example);

    int updateByPrimaryKeySelective(ManageRcord record);

    int updateByPrimaryKey(ManageRcord record);
}