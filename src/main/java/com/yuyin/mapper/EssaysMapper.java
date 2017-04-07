package com.yuyin.mapper;

import com.yuyin.pojo.EssayVo;
import com.yuyin.pojo.Essays;
import com.yuyin.pojo.EssaysExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EssaysMapper {
    int countByExample(EssaysExample example);

    int deleteByExample(EssaysExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Essays record);

    int insertSelective(Essays record);

    List<Essays> selectByExampleWithBLOBs(EssaysExample example);

    List<Essays> selectByExample(EssaysExample example);

    Essays selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Essays record, @Param("example") EssaysExample example);

    int updateByExampleWithBLOBs(@Param("record") Essays record, @Param("example") EssaysExample example);

    int updateByExample(@Param("record") Essays record, @Param("example") EssaysExample example);

    int updateByPrimaryKeySelective(Essays record);

    int updateByPrimaryKeyWithBLOBs(Essays record);

    int updateByPrimaryKey(Essays record);
    
    List<EssayVo> queryEssayList(@Param("record")EssayVo record);
    
    int deleteEssay(@Param("list") Long[] ids);

    EssayVo getEssayAndMusic(@Param("id") Long id);
}