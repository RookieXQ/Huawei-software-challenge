package com.xiongqi.huawei;

/*
 * ���ڹ�������ڵ㵽���ѽڵ���Ϣ�� ��ʽΪ�����ѽڵ�ID ��������ڵ�ID ��Ƶ������������
 */
public class LinkWithConsumer {
	
	private int consumerId;
	private int networkId;
	private int consumerDemand;
	public LinkWithConsumer(int consumerId, int networkId, int consumeDemand) {
		super();
		this.consumerId = consumerId;
		this.networkId = networkId;
		this.consumerDemand = consumeDemand;
	}
	
	public LinkWithConsumer(){
		
	}
	
	public int getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}
	public int getNetworkId() {
		return networkId;
	}
	public void setNetworkId(int networkId) {
		this.networkId = networkId;
	}
	public int getConsumeDemand() {
		return consumerDemand;
	}
	public void setConsumeDemand(int consumeDemand) {
		this.consumerDemand = consumeDemand;
	}
	
	
	
	

}
