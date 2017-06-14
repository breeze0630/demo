package xt.lb.entity;

public class GoodsInfo {

	//商品信息
	private String goodsId;
	
	private String goodsName;
	
	private String goodsPrice;
	
	private String goodsDesc;
	
	private String goodsPhotoPath;
	
	private int goodsSize;
	
	private int amount;
	
	private String hasPhoto;

	public GoodsInfo() {
	}

	public GoodsInfo(String goodsId, String goodsName, String goodsPrice, String goodsDesc, String goodsPhotoPath,
			String hasPhoto) {
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsDesc = goodsDesc;
		this.goodsPhotoPath = goodsPhotoPath;
		this.hasPhoto = hasPhoto;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsDesc() {
		return goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public String getGoodsPhotoPath() {
		return goodsPhotoPath;
	}

	public void setGoodsPhotoPath(String goodsPhotoPath) {
		this.goodsPhotoPath = goodsPhotoPath;
	}

	public String getHasPhoto() {
		return hasPhoto;
	}

	public void setHasPhoto(String hasPhoto) {
		this.hasPhoto = hasPhoto;
	}

	public int getGoodsSize() {
		return goodsSize;
	}

	public void setGoodsSize(int goodsSize) {
		this.goodsSize = goodsSize;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
