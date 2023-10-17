package com.lyx.goods.service.mapper;

import com.lyx.goods.api.entity.GoodsSpecs;
import com.lyx.goods.api.entity.GoodsSpecsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsSpecsMapper {
    long countByExample(GoodsSpecsExample example);

    int deleteByExample(GoodsSpecsExample example);

    int deleteByPrimaryKey(Integer specsId);

    int insert(GoodsSpecs record);

    int insertSelective(GoodsSpecs record);

    List<GoodsSpecs> selectByExample(GoodsSpecsExample example);

    GoodsSpecs selectByPrimaryKey(Integer specsId);

    int updateByExampleSelective(@Param("record") GoodsSpecs record, @Param("example") GoodsSpecsExample example);

    int updateByExample(@Param("record") GoodsSpecs record, @Param("example") GoodsSpecsExample example);

    int updateByPrimaryKeySelective(GoodsSpecs record);

    int updateByPrimaryKey(GoodsSpecs record);
}