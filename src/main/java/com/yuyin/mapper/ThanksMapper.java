package com.yuyin.mapper;

import com.yuyin.pojo.Thanks;
import com.yuyin.pojo.ThanksExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ThanksMapper {
    int countByExample(ThanksExample example);

    int deleteByExample(ThanksExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Thanks record);

    int insertSelective(Thanks record);

    List<Thanks> selectByExample(ThanksExample example);

    Thanks selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Thanks record, @Param("example") ThanksExample example);

    int updateByExample(@Param("record") Thanks record, @Param("example") ThanksExample example);

    int updateByPrimaryKeySelective(Thanks record);

    int updateByPrimaryKey(Thanks record);
}