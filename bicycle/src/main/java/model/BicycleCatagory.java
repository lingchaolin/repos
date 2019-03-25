package model;
//车辆_车辆类型
public class BicycleCatagory {
	private Integer catagoryId; //类型编号
	private String catagoryName;//类型名称
	private String frameType; // 车架类型
	private String tireType; // 车胎类型
	private Double weight; // 车重
	private Double height;// 车高
	private Double length;//  车长
	private String ringType; // 铃铛类型
	private String basket; // 前篮
	private String backseat; // 后座
	private String bicycleSeat; // 车座
	private String handBrake;// 手刹
	private String remark; // 备注
	private Integer userId; // 操作人
	private String operatorTime; // 操作日期
	public BicycleCatagory(Integer catagoryId, String catagoryName, String frameType, String tireType, Double weight,
			Double height, Double length, String ringType, String basket, String backseat, String bicycleSeat,
			String handBrake, String remark, Integer userId, String operatorTime) {
		super();
		this.catagoryId = catagoryId;
		this.catagoryName = catagoryName;
		this.frameType = frameType;
		this.tireType = tireType;
		this.weight = weight;
		this.height = height;
		this.length = length;
		this.ringType = ringType;
		this.basket = basket;
		this.backseat = backseat;
		this.bicycleSeat = bicycleSeat;
		this.handBrake = handBrake;
		this.remark = remark;
		this.userId = userId;
		this.operatorTime = operatorTime;
	}
	public BicycleCatagory() {
		super();
	}
	public Integer getCatagoryId() {
		return catagoryId;
	}
	public void setCatagoryId(Integer catagoryId) {
		this.catagoryId = catagoryId;
	}
	public String getCatagoryName() {
		return catagoryName;
	}
	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}
	public String getFrameType() {
		return frameType;
	}
	public void setFrameType(String frameType) {
		this.frameType = frameType;
	}
	public String getTireType() {
		return tireType;
	}
	public void setTireType(String tireType) {
		this.tireType = tireType;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public String getRingType() {
		return ringType;
	}
	public void setRingType(String ringType) {
		this.ringType = ringType;
	}
	public String getBasket() {
		return basket;
	}
	public void setBasket(String basket) {
		this.basket = basket;
	}
	public String getBackseat() {
		return backseat;
	}
	public void setBackseat(String backseat) {
		this.backseat = backseat;
	}
	public String getBicycleSeat() {
		return bicycleSeat;
	}
	public void setBicycleSeat(String bicycleSeat) {
		this.bicycleSeat = bicycleSeat;
	}
	public String getHandBrake() {
		return handBrake;
	}
	public void setHandBrake(String handBrake) {
		this.handBrake = handBrake;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getOperatorTime() {
		return operatorTime;
	}
	public void setOperatorTime(String operatorTime) {
		this.operatorTime = operatorTime;
	}
	
}
