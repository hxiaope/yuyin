package com.yuyin.mapper;

import com.yuyin.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectMapper {
    int countByExample(CollectExample example);

    int deleteByExample(CollectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Collect record);

    int insertSelective(Collect record);

    List<Collect> selectByExample(CollectExample example);

    Collect selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByExample(@Param("record") Collect record, @Param("example") CollectExample example);

    int updateByPrimaryKeySelective(Collect record);

    int updateByPrimaryKey(Collect record);

    public List<CollectPeriodicalVo> queryPeriodicalCollect(@Param("userId")Long userId);

    public List<CollectSingleVo> querySingleCollect(@Param("userId")Long userId);

    public List<CollectEssayVo> queryEssayCollect(@Param("userId")Long userId);

    Collect selectByPeriodicalId(@Param("userId")Long userId,@Param("pId")Long pId);

    Collect selectBySingleId(@Param("userId")Long userId,@Param("sId")Long sId);

    Collect selectByEssayId(@Param("userId")Long userId,@Param("eId")Long eId);

    int deleteCollect(@Param("userId")Long userId,@Param("pId")Long pId,@Param("sId")Long sId,@Param("eId")Long eId);
}