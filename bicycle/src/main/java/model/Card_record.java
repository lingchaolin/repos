package model;

public class Card_record {
	private Integer recordId;
	private Integer cardId;
	private Integer feeType;
	private Double chgMonthlyMoney;
	private Double chgWalletMoney;
	private Double chgFrozenMoney;
	private String createTime;
	private Integer userId;
	private String remark;
	private Integer zxbj;
	private String turn;
	
	

	public String getTurn() {
		return turn;
	}

	public void setTurn(String turn) {
		this.turn = turn;
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

	public Integer getFeeType() {
		return feeType;
	}

	public void setFeeType(Integer feeType) {
		this.feeType = feeType;
	}

	public Double getChgMonthlyMoney() {
		return chgMonthlyMoney;
	}

	public void setChgMonthlyMoney(Double chgMonthlyMoney) {
		this.chgMonthlyMoney = chgMonthlyMoney;
	}

	public Double getChgWalletMoney() {
		return chgWalletMoney;
	}

	public void setChgWalletMoney(Double chgWalletMoney) {
		this.chgWalletMoney = chgWalletMoney;
	}

	public Double getChgFrozenMoney() {
		return chgFrozenMoney;
	}

	public void setChgFrozenMoney(Double chgFrozenMoney) {
		this.chgFrozenMoney = chgFrozenMoney;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getZxbj() {
		return zxbj;
	}

	public void setZxbj(Integer zxbj) {
		this.zxbj = zxbj;
	}

	public Card_record() {
		super();
	}

	public Card_record(Integer recordId, Integer cardId, Integer feeType, Double chgMonthlyMoney, Double chgWalletMoney,
			Double chgFrozenMoney, String createTime, Integer userId, String remark, Integer zxbj) {
		super();
		this.recordId = recordId;
		this.cardId = cardId;
		this.feeType = feeType;
		this.chgMonthlyMoney = chgMonthlyMoney;
		this.chgWalletMoney = chgWalletMoney;
		this.chgFrozenMoney = chgFrozenMoney;
		this.createTime = createTime;
		this.userId = userId;
		this.remark = remark;
		this.zxbj = zxbj;
	}

}
