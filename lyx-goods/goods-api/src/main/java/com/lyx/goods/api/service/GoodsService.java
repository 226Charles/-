package com.lyx.goods.api.service;

import com.lyx.goods.api.entity.GoodsInfo;

import java.util.List;

public interface GoodsService {
    String test (String name);

    List<GoodsInfo> findList(GoodsInfo goodsInfo) throws Exception;

    GoodsInfo findGoodsInfoByPrimary(long goodsId) throws Exception;
}
