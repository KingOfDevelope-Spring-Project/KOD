package com.spring.product;

import java.util.Arrays;

public class ProductDTO {
	private int productID;
	private int productCnt;
	private int productStock;
	private int productPrice;
	private String productName;
	private String productBrand;
	private String productCategory;
	private String productInfo;
	private String productImg;
	private String memberID;
	private int isWished;
	private int max;
	private int min;
	private String[] categoryList;

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getProductCnt() {
		return productCnt;
	}

	public void setProductCnt(int productCnt) {
		this.productCnt = productCnt;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public int getIsWished() {
		return isWished;
	}

	public void setIsWished(int isWished) {
		this.isWished = isWished;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public String[] getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(String[] categoryList) {
		this.categoryList = categoryList;
	}

	@Override
	public String toString() {
		return "ProductDTO [productID=" + productID + ", productCnt=" + productCnt + ", productStock=" + productStock
				+ ", productPrice=" + productPrice + ", productName=" + productName + ", productBrand=" + productBrand
				+ ", productCategory=" + productCategory + ", productInfo=" + productInfo + ", productImg=" + productImg
				+ ", memberID=" + memberID + ", isWished=" + isWished + ", max=" + max + ", min=" + min
				+ ", categoryList=" + Arrays.toString(categoryList) + "]";
	}

}
