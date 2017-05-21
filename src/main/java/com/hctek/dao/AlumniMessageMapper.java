package com.hctek.dao;

import com.hctek.model.AlumniMessage;
import com.hctek.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlumniMessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AlumniMessage record);

    int insertSelective(AlumniMessage record);

    AlumniMessage selectByPrimaryKey(Integer id);

    AlumniMessage selectByPrimaryKeyCode(Integer id, String code);

    int updateByPrimaryKeySelective(AlumniMessage record);

    int updateByPrimaryKeyWithBLOBs(AlumniMessage record);

    int updateByPrimaryKey(AlumniMessage record);

    List<AlumniMessage> getAllAlumniMessage();
}