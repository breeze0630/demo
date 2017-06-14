package xt.lb.service.impl;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import xt.lb.dao.GoodsInfoMapper;
import xt.lb.dao.ShopGoodsMapper;
import xt.lb.dto.WebDto;
import xt.lb.entity.GoodsInfo;
import xt.lb.entity.ShopGoods;
import xt.lb.service.BaseService;
import xt.lb.util.CreateID;

@Service("goodsInfoServiceImpl")
public class GoodsInfoServiceImpl implements BaseService{

	GoodsInfoMapper goodsInfoMapper;
	ShopGoodsMapper shopGoodsMapper;
	/**
	 * 添加商品
	 * */
	public WebDto addGoods(WebDto inDto) {
		WebDto out = new WebDto();
		GoodsInfo info = new GoodsInfo();
		if(inDto.getGoodsPrice() !=null && Pattern.matches("[0-9]", inDto.getGoodsPrice())){
			
			info.setGoodsId(CreateID.createUserId());
			info.setGoodsName(inDto.getGoodsName());
			info.setGoodsPrice(inDto.getGoodsPrice());
			info.setGoodsPhotoPath(inDto.getGoodsPhotoPath());
			//此商品有上传图片
			if("0".equals(inDto.getHasGoodsPhoto())){
				info.setGoodsPhotoPath(inDto.getGoodsPhotoPath());
			}
			info.setGoodsDesc(inDto.getGoodsDesc());
		 int ret = goodsInfoMapper.addGoods(info);
		 ShopGoods shopGoods = new ShopGoods();
		 
		 if(ret == 1){
			 shopGoods.setGoodsId(info.getGoodsId());
			 shopGoods.setName(info.getGoodsName());
			 shopGoods.setShopId(inDto.getShopId());
			 if(Integer.parseInt(inDto.getAmount())!=0){
				 shopGoods.setAmount(inDto.getGoodsAmount());
			 }else{
				 shopGoods.setAmount(0);
			 }
			int res = shopGoodsMapper.insert(shopGoods);
			 if(res == 1){
				 out.setStatus("0");
				 out.setLoggerMessage("添加商品成功！");
				 return out;
			 }else{
				 //如果向shopgoods表中添加信息失败时，需要将之前添加的商品信息清楚
				 goodsInfoMapper.delete(info);
			 }
		 } 
			
		}
		//默认为失败状态，当添加成功时才会置为1
		out.setStatus("1");
		out.setLoggerMessage("添加商品失败！");
		return out;
		
		
	}
	/**
	 * 删除商品Method
	 * @param inDto 输入数据
	 * @return outDto 输出数据
	 * */
	public WebDto delGoods(WebDto inDto){
		WebDto outDto = new WebDto();
		GoodsInfo info = new GoodsInfo();
		info.setGoodsId(inDto.getGoodsId());
		int ret = goodsInfoMapper.delete(info);
		if(ret == 0 ){
			outDto.setStatus("1");
			outDto.setLoggerMessage("该商品删除失败");
			return outDto;
		}else{
			outDto.setStatus("0");
			outDto.setLoggerMessage("该商品删除成功");
			return outDto;
		}
	}
	/**
	 * 商品信息修改
	 * @param inDto 输入数据
	 * @return out 输出数据
	 * */
	public WebDto updGoods(WebDto inDto){
		WebDto out = new WebDto();
		GoodsInfo info = new GoodsInfo();
		info.setGoodsId(inDto.getGoodsId());
		info.setGoodsName(inDto.getGoodsName());
		info.setGoodsDesc(inDto.getGoodsDesc());
		info.setGoodsPhotoPath(inDto.getGoodsPhotoPath());
		info.setGoodsPrice(inDto.getGoodsPrice());
		info.setGoodsSize(inDto.getGoodsAmount());
		
		goodsInfoMapper.update(info);
		
		return out;
	}

	
	
}
