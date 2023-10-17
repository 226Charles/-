package com.lyx.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lyx.goods.api.entity.GoodsInfo;
import com.lyx.goods.api.entity.GoodsInfoExample;
import com.lyx.goods.api.service.GoodsService;
import com.lyx.goods.service.mapper.GoodsInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Service(version = "1.0.0",timeout = 10000,interfaceClass = GoodsService.class)
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsInfoMapper goodsInfoMapper;

    @Override
    public String test(String name) {
        return "Hello,"+name+",this is a messgae from the goods module";
    }

    @Override
    public List<GoodsInfo> findList(GoodsInfo goodsInfo) throws Exception {
        GoodsInfoExample example = new GoodsInfoExample();
        GoodsInfoExample.Criteria criteria = example.createCriteria();
        if (goodsInfo != null && goodsInfo.getGoodsName() != null){
            criteria.andGoodsNameLike(goodsInfo.getGoodsName()+"%");
        }
        return goodsInfoMapper.selectByExample(example);
    }

    @Override
    public GoodsInfo findGoodsInfoByPrimary(long goodsId) throws Exception {
        return goodsInfoMapper.selectByPrimaryKey(goodsId);
    }

}
