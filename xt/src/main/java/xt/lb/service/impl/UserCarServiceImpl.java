package xt.lb.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xt.lb.dao.UserCarMapper;
import xt.lb.dao.UserShopMapper;
import xt.lb.dto.GoodsList;
import xt.lb.dto.WebDto;
import xt.lb.entity.UserCar;
@Service("userCarService")
public class UserCarServiceImpl {

	@Autowired
	UserCarMapper userCarMapper;
	@Autowired
	UserShopMapper userShopMapper;
	/**
	 * 向购物车中添加一件商品
	 * */
	public WebDto addShop(WebDto inDto) {
		UserCar car = new UserCar();
		WebDto out = new WebDto();
		if(inDto.getUserId() == null || inDto.getGoodsId() == null || inDto.getShopId() ==null){
			//添加时，条件必须有用户id，商品id，商店id，当需要的信息不足时，设置 status = "3"，不进行添加操作。
			out.setStatus("3");
			out.setLoggerMessage("添加失败，数据不足：用户名、商品名或者商店名不存在");
		}else{
				
			car.setUserId(inDto.getUserId());
			car.setGoodsId(inDto.getGoodsId());
			car.setShopId(inDto.getShopId());
			car.setAmount(Integer.parseInt(inDto.getAmount()));
			try{
				
				if(userCarMapper.insert(car) == 1){
					//insert的返回值为1时，表示添加成功，设置 status = "0"
					out.setStatus("0");
					out.setLoggerMessage("添加成功");
				}else{
					//insert的返回值不为1时，表示数据添加失败，设置 status = "1"
					out.setStatus("1");
					out.setLoggerMessage("添加失败");
				}
			}catch(Exception e){
				//当数据库异常时，向前台打印，数据库异常，设置 status = "2"
				out.setStatus("2");
				out.setLoggerMessage("数据库异常，添加失败");
			}
		}
		return out;
	}
	/**
	 * 删除购物车中某件商品信息
	 * */
	public WebDto delShop(WebDto inDto){
		WebDto out = new WebDto();
		UserCar car = new UserCar();
		if(inDto.getUserId() == null || inDto.getGoodsId() == null || inDto.getShopId() == null){
			//删除时，条件必须有用户id，商品id，商店id，当需要的信息不足时，设置 status = "3"，不进行删除操作。
			out.setStatus("3");
			out.setLoggerMessage("删除信息不足，用户名、商品名或者商店名不存在");
		}else{
			car.setUserId(inDto.getUserId());
			car.setGoodsId(inDto.getGoodsId());
			car.setShopId(inDto.getShopId());
			try{
				
				if(userCarMapper.delete(car) == 1){
					//insert的返回值为1时，表示删除成功，设置 status = "0"
					out.setStatus("0");
					out.setLoggerMessage("删除成功");
				}else{
					//insert的返回值不为1时，表示数据删除失败，设置 status = "1"
					out.setStatus("1");
					out.setLoggerMessage("删除失败");
				}
			}catch(Exception e){
				//当数据库异常时，向前台打印，数据库异常，设置 status = "2"
				out.setStatus("2");
				out.setLoggerMessage("数据库异常，添加失败");
			}
		}
		return out;
	}

	/**
	 * 查询用户的购物车信息
	 * 一般在用户主动更新购物车信息和用户打开购物车页面时，初始化调用
	 * */
	public WebDto query(WebDto inDto){
		WebDto out = new WebDto();
		UserCar car = new UserCar();
		car.setUserId(inDto.getUserId());
		try{
			ArrayList<UserCar> list = userCarMapper.selectAllByUserId(car);
			ArrayList<GoodsList> goodsList = new ArrayList<GoodsList>();
			for(UserCar c:list){
				GoodsList l = new GoodsList();
				l.setCarName(userShopMapper.selectShopNameByShopId(c.getShopId()));
				l.setList(userCarMapper.selectByUserShop(c));
				goodsList.add(l);
			}
			out.setStatus("0");
			out.setCarList(goodsList);	
		}catch(Exception e){
			//当数据库异常时，向前台打印，数据库异常，设置 status = "2"
			out.setStatus("2");
			out.setLoggerMessage("数据库查询失败，购物车信息更新失败");
			return out;
		}
		return out;
	}
}
