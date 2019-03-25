package com.aowin.model;

public class Appraise {
//	  `appraise_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '评价id',
//	  `order_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单号',
//	  `obj_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '被评价对象id',-- 某某套餐
//	  `is_have_pic` int(11) NULL DEFAULT NULL COMMENT '是否有图 0无图 1有图',
//	  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价用户id',
//	  `star_class` decimal(3, 1) NULL DEFAULT NULL COMMENT '星级',
//	  `is_reply` int(11) NOT NULL COMMENT '0未回复 1已回复',
	  private int appraiseId;

	  private String orderNo;
	  
	  private String objId;
	  
	  private int isHavePic;
	  
	  private String userId;
	  
	  private double starClass;
	  
	  private int isReply;

	/**
	 * @return the appraiseId
	 */
	public int getAppraiseId() {
		return appraiseId;
	}

	/**
	 * @param appraiseId the appraiseId to set
	 */
	public void setAppraiseId(int appraiseId) {
		this.appraiseId = appraiseId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Appraise [appraiseId=" + appraiseId + ", orderNo=" + orderNo + ", objId=" + objId + ", isHavePic="
				+ isHavePic + ", userId=" + userId + ", starClass=" + starClass + ", isReply=" + isReply + "]";
	}

	/**
	 * @return the orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * @return the objId
	 */
	public String getObjId() {
		return objId;
	}

	/**
	 * @param objId the objId to set
	 */
	public void setObjId(String objId) {
		this.objId = objId;
	}

	/**
	 * @return the is_havePic
	 */
	public int getIsHavePic() {
		return isHavePic;
	}

	/**
	 * @param is_havePic the is_havePic to set
	 */
	public void setIsHavePic(int isHavePic) {
		this.isHavePic = isHavePic;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the starClass
	 */
	public double getStarClass() {
		return starClass;
	}

	/**
	 * @param starClass the starClass to set
	 */
	public void setStarClass(double starClass) {
		this.starClass = starClass;
	}

	/**
	 * @return the isReply
	 */
	public int getIsReply() {
		return isReply;
	}

	/**
	 * @param isReply the isReply to set
	 */
	public void setIsReply(int isReply) {
		this.isReply = isReply;
	}
	  
}
