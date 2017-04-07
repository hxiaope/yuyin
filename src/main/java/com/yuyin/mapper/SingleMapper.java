package com.yuyin.mapper;

import com.yuyin.pojo.Single;
import com.yuyin.pojo.SingleExample;
import com.yuyin.pojo.SingleVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SingleMapper {
    int countByExample(SingleExample example);

    int deleteByExample(SingleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Single record);

    int insertSelective(Single record);

    List<Single> selectByExampleWithBLOBs(SingleExample example);

    List<Single> selectByExample(SingleExample example);

    Single selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Single record, @Param("example") SingleExample example);

    int updateByExampleWithBLOBs(@Param("record") Single record, @Param("example") SingleExample example);

    int updateByExample(@Param("record") Single record, @Param("example") SingleExample example);

    int updateByPrimaryKeySelective(Single record);

    int updateByPrimaryKeyWithBLOBs(Single record);

    int updateByPrimaryKey(Single record);
    
    int deleteSingleByIds(@Param("list")Long[] ids);
    
    List<SingleVo> queryList(@Param("record")SingleVo record);
}