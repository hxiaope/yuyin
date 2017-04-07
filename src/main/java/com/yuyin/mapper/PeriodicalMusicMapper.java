package com.yuyin.mapper;

import com.yuyin.pojo.PeriodicalMusic;
import com.yuyin.pojo.PeriodicalMusicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PeriodicalMusicMapper {
    int countByExample(PeriodicalMusicExample example);

    int deleteByExample(PeriodicalMusicExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PeriodicalMusic record);

    int insertSelective(PeriodicalMusic record);

    List<PeriodicalMusic> selectByExample(PeriodicalMusicExample example);

    PeriodicalMusic selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PeriodicalMusic record, @Param("example") PeriodicalMusicExample example);

    int updateByExample(@Param("record") PeriodicalMusic record, @Param("example") PeriodicalMusicExample example);

    int updateByPrimaryKeySelective(PeriodicalMusic record);

    int updateByPrimaryKey(PeriodicalMusic record);
}