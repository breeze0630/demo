package xt.lb.service.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xt.lb.dao.UserGoodsMapper;
import xt.lb.dto.WebDto;
import xt.lb.entity.UserGoods;

@Service("evaluteServiceImpl")
public class EvaluteServiceImpl {
	@Autowired
	UserGoodsMapper userGoodsMapper;
	public WebDto createEvalute(WebDto inDto) {
		WebDto out = new WebDto();
		UserGoods goods = new UserGoods();
		goods.setUserId(inDto.getUserId());
		goods.setGoodsId(inDto.getGoodsId());
		goods.setGoodsAmount(inDto.getGoodsAmount());
		goods.setShopId(inDto.getShopId());
		goods.setEvaluteType(inDto.getEvaluteType());
		goods.setEvalute(inDto.getEvalute());
		goods.setAddEvaStatus("1");
		goods.setTradeTime(new Timestamp(System.currentTimeMillis()));
		int intRet = userGoodsMapper.insert(goods);
		if(intRet == 1){
			out.setStatus("0");
			out.setLoggerMessage("评价成功");
		}else{
			out.setStatus("1");
			out.setLoggerMessage("评论提交失败");
		}
		return out;
	}
	
	public WebDto addEva(WebDto inDto){
		WebDto out = new WebDto();
		if("".equals(inDto.getAddEva()) || inDto.getAddEva() == null){
			out.setStatus("2");
			out.setLoggerMessage("没有输入追加评价内容");
		}else{
			
			UserGoods goods = new UserGoods();
			goods.setUserId(inDto.getUserId());
			goods.setGoodsId(inDto.getGoodsId());
			goods.setShopId(inDto.getShopId());
			goods.setAddEva(inDto.getAddEva());
			goods.setAddEvaStatus("0");
			goods.setAddEvaTime(new Timestamp(System.currentTimeMillis()));
			int intRet = userGoodsMapper.update(goods);
			if(intRet == 1 ){
				out.setStatus("0");
				out.setLoggerMessage("追加评价成功");
			}else{
				out.setStatus("1");
				out.setLoggerMessage("追加评价失败");
			}
	
		}
		
		
		return out;
	}

}
