package com.yuyin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuyin.pojo.Periodical;
import com.yuyin.pojo.PeriodicalCustom;
import com.yuyin.pojo.PeriodicalExample;

public interface PeriodicalMapper {
    int countByExample(PeriodicalExample example);

    int deleteByExample(PeriodicalExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Periodical record);

    int insertSelective(Periodical record);

    List<Periodical> selectByExampleWithBLOBs(PeriodicalExample example);

    List<Periodical> selectByExample(PeriodicalExample example);

    Periodical selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Periodical record, @Param("example") PeriodicalExample example);

    int updateByExampleWithBLOBs(@Param("record") Periodical record, @Param("example") PeriodicalExample example);

    int updateByExample(@Param("record") Periodical record, @Param("example") PeriodicalExample example);

    int updateByPrimaryKeySelective(Periodical record);

    int updateByPrimaryKeyWithBLOBs(Periodical record);

    int updateByPrimaryKey(Periodical record);
    
    int deletePeriodical(@Param("list")Long[] ids);
    
    List<PeriodicalCustom> queryPeriodicalList(@Param("record") Periodical record);
    
    List<PeriodicalCustom> queryPerOneTable();
    
    PeriodicalCustom queryPeriodicalID(@Param("id") Long id);
}