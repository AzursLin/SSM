package com.hctek.dao;

import com.hctek.model.AlumniMessage;
import com.hctek.model.AnniversaryAnnouncement;

import java.util.List;

public interface AnniversaryAnnouncementMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AnniversaryAnnouncement record);

    int insertSelective(AnniversaryAnnouncement record);

    AnniversaryAnnouncement selectByPrimaryKey(Integer id);

    AnniversaryAnnouncement selectByPrimaryKeyCode(Integer id, String code);

    int updateByPrimaryKeySelective(AnniversaryAnnouncement record);

    int updateByPrimaryKeyWithBLOBs(AnniversaryAnnouncement record);

    int updateByPrimaryKey(AnniversaryAnnouncement record);

    List<AnniversaryAnnouncement> getAllAnniversaryAnnouncement();
}