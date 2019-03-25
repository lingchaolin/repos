package model;
//业务流水表
public class BicycleDeal {
	private Integer dealId; //业务ID
	private String createTime; //发生时间
	private String dealName;//业务名称
	private String dealType; // 业务类型
	private Integer recordId; //关联的业务记录id
	private Integer cardId; // 业务卡id
	private String idFee; // 是否发生费用
	private Double chgMoney; // 费用金额
	private Integer feeType; // 费用收支类型
	private Integer bicycleId; // 车辆id
	private Integer pileId; // 车桩id
	private Integer userId; // 操作人
	public BicycleDeal(Integer dealId, String createTime, String dealName, String dealType, Integer recordId,
			Integer cardId, String idFee, Double chgMoney, Integer feeType, Integer bicycleId, Integer pileId,
			Integer userId) {
		super();
		this.dealId = dealId;
		this.createTime = createTime;
		this.dealName = dealName;
		this.dealType = dealType;
		this.recordId = recordId;
		this.cardId = cardId;
		this.idFee = idFee;
		this.chgMoney = chgMoney;
		this.feeType = feeType;
		this.bicycleId = bicycleId;
		this.pileId = pileId;
		this.userId = userId;
	}
	public BicycleDeal() {
		super();
	}
	public Integer getDealId() {
		return dealId;
	}
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getDealName() {
		return dealName;
	}
	public void setDealName(String dealName) {
		this.dealName = dealName;
	}
	public String getDealType() {
		return dealType;
	}
	public void setDealType(String dealType) {
		this.dealType = dealType;
	}
	public Integer getRecordId() {
		return recordId;
	}
	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}
	public Integer getCardId() {
		return cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	public String getIdFee() {
		return idFee;
	}
	public void setIdFee(String idFee) {
		this.idFee = idFee;
	}
	public Double getChgMoney() {
		return chgMoney;
	}
	public void setChgMoney(Double chgMoney) {
		this.chgMoney = chgMoney;
	}
	public Integer getFeeType() {
		return feeType;
	}
	public void setFeeType(Integer feeType) {
		this.feeType = feeType;
	}
	public Integer getBicycleId() {
		return bicycleId;
	}
	public void setBicycleId(Integer bicycleId) {
		this.bicycleId = bicycleId;
	}
	public Integer getPileId() {
		return pileId;
	}
	public void setPileId(Integer pileId) {
		this.pileId = pileId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
