package com.xiongqi.huawei;
/*
 * ���ڹ�������ڵ���·��Ϣ ��ʽΪ����ʼ�ڵ�ID ��ֹ�ڵ�ID �ܴ����С(_Gbps) �������޷��ã�_k/Gbps��
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
