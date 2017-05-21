package com.hctek.dao;

import com.hctek.model.AlumniMessage;
import com.hctek.model.AnniversaryAnnouncement;
import com.hctek.model.AnniversaryDynamic;

import java.util.List;

public interface AnniversaryDynamicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AnniversaryDynamic record);

    int insertSelective(AnniversaryDynamic record);

    AnniversaryDynamic selectByPrimaryKey(Integer id);

    AnniversaryDynamic selectByPrimaryKeyCode(Integer id, String code);

    int updateByPrimaryKeySelective(AnniversaryDynamic record);

    int updateByPrimaryKeyWithBLOBs(AnniversaryDynamic record);

    int updateByPrimaryKey(AnniversaryDynamic record);

    List<AnniversaryDynamic> getAllAnniversaryDynamic();
}