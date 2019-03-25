package model;
 //车辆调配明细
public class BicycleDeploy {
	private Integer deployId; //明细id
	private Integer bicycleId; //车辆id
	private Integer fromPileId; // 调出车桩
	private Integer toPileId; // 调入车桩
	private Integer fromCardId; //调出人卡id
	private String fromTime; //调出时间
	private Integer toCardId; //调入人卡id
	private String toTime; //调入时间
	private String toReason; //调入原因
	private String fromReason; // 调出原因
	private String remark; //备注
	private String status; //状态
	public BicycleDeploy(Integer deployId, Integer bicycleId, Integer fromPileId, Integer toPileId, Integer fromCardId,
			String fromTime, Integer toCardId, String toTime, String toReason, String fromReason, String remark,
			String status) {
		super();
		this.deployId = deployId;
		this.bicycleId = bicycleId;
		this.fromPileId = fromPileId;
		this.toPileId = toPileId;
		this.fromCardId = fromCardId;
		this.fromTime = fromTime;
		this.toCardId = toCardId;
		this.toTime = toTime;
		this.toReason = toReason;
		this.fromReason = fromReason;
		this.remark = remark;
		this.status = status;
	}
	public BicycleDeploy() {
		super();
	}
	public Integer getDeployId() {
		return deployId;
	}
	public void setDeployId(Integer deployId) {
		this.deployId = deployId;
	}
	public Integer getBicycleId() {
		return bicycleId;
	}
	public void setBicycleId(Integer bicycleId) {
		this.bicycleId = bicycleId;
	}
	public Integer getFromPileId() {
		return fromPileId;
	}
	public void setFromPileId(Integer fromPileId) {
		this.fromPileId = fromPileId;
	}
	public Integer getToPileId() {
		return toPileId;
	}
	public void setToPileId(Integer toPileId) {
		this.toPileId = toPileId;
	}
	public Integer getFromCardId() {
		return fromCardId;
	}
	public void setFromCardId(Integer fromCardId) {
		this.fromCardId = fromCardId;
	}
	public String getFromTime() {
		return fromTime;
	}
	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}
	public Integer getToCardId() {
		return toCardId;
	}
	public void setToCardId(Integer toCardId) {
		this.toCardId = toCardId;
	}
	public String getToTime() {
		return toTime;
	}
	public void setToTime(String toTime) {
		this.toTime = toTime;
	}
	public String getToReason() {
		return toReason;
	}
	public void setToReason(String toReason) {
		this.toReason = toReason;
	}
	public String getFromReason() {
		return fromReason;
	}
	public void setFromReason(String fromReason) {
		this.fromReason = fromReason;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
