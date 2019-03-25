package model;

public class Bicycle_pile {
	private Integer pileId;
	private Integer stationId;
	private Integer venderId;
	private String pileCode;
	private Integer status;
	private String installTime;
	private String disassemblyTime;
	private Integer userId;
	private String operatorTime;
	private Integer bicycleId;
	private String remark;
	
	private String turn;
	
	
	

	public String getTurn() {
		return turn;
	}

	public void setTurn(String turn) {
		this.turn = turn;
	}

	public Bicycle_pile(Integer pileId, Integer stationId, Integer venderId, String pileCode, Integer status,
			String installTime, String disassemblyTime, Integer userId, String operatorTime, Integer bicycleId,
			String remark) {
		super();
		this.pileId = pileId;
		this.stationId = stationId;
		this.venderId = venderId;
		this.pileCode = pileCode;
		this.status = status;
		this.installTime = installTime;
		this.disassemblyTime = disassemblyTime;
		this.userId = userId;
		this.operatorTime = operatorTime;
		this.bicycleId = bicycleId;
		this.remark = remark;
	}

	public Bicycle_pile() {
		super();
	}

	public Integer getPileId() {
		return pileId;
	}

	public void setPileId(Integer pileId) {
		this.pileId = pileId;
	}

	public Integer getStationId() {
		return stationId;
	}

	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}

	public Integer getVenderId() {
		return venderId;
	}

	public void setVenderId(Integer venderId) {
		this.venderId = venderId;
	}

	public String getPileCode() {
		return pileCode;
	}

	public void setPileCode(String pileCode) {
		this.pileCode = pileCode;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getInstallTime() {
		return installTime;
	}

	public void setInstallTime(String installTime) {
		this.installTime = installTime;
	}

	public String getDisassemblyTime() {
		return disassemblyTime;
	}

	public void setDisassemblyTime(String disassemblyTime) {
		this.disassemblyTime = disassemblyTime;
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

	public Integer getBicycleId() {
		return bicycleId;
	}

	public void setBicycleId(Integer bicycleId) {
		this.bicycleId = bicycleId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
