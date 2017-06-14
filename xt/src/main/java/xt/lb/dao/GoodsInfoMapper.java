package xt.lb.dao;

import xt.lb.entity.GoodsInfo;

public interface GoodsInfoMapper {

  GoodsInfo	selectByPK(String goodsId);
  
  int addGoods(GoodsInfo goodsInfo);
  
  int delete(GoodsInfo goodsInfo);
  
  int update(GoodsInfo goodsInfo);
}
