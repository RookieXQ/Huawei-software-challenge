package com.xiongqi.huawei;
/*
 * 用于构造网络节点链路信息 格式为：起始节点ID 终止节点ID 总带宽大小(_Gbps) 网络租赁费用（_k/Gbps）
 */
public class LinkWithNetworkNode {

	private int netWorkStartId;
	private int netWorkTerminalId;
    private int bandWidthSize;
	private int rentPrice;
			
	public LinkWithNetworkNode(int netWorkStartId, int netWorkTerminalId, int bandWidthSize, int rentPrice) {
		super();
		this.netWorkStartId = netWorkStartId;
		this.netWorkTerminalId = netWorkTerminalId;
		this.bandWidthSize = bandWidthSize;
		this.rentPrice = rentPrice;
	}
	
	public int getNetWorkStartId() {
		return netWorkStartId;
	}
	
	public void setNetWorkStartId(int netWorkStartId) {
		this.netWorkStartId = netWorkStartId;
	}
	
	public int getNetWorkTerminalId() {
		return netWorkTerminalId;
	}
	
	public void setNetWorkTerminalId(int netWorkTerminalId) {
		this.netWorkTerminalId = netWorkTerminalId;
	}
	
	public int getBandWidthSize() {
		return bandWidthSize;
	}
	
	public void setBandWidthSize(int bandWidthSize) {
		this.bandWidthSize = bandWidthSize;
	}
	
	public int getRentPrice() {
		return rentPrice;
	}
	
	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}

          
	
	
	
	
	
	
}
