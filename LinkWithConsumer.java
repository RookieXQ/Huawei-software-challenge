package com.xiongqi.huawei;

/*
 * 用于构造网络节点到消费节点信息， 格式为：消费节点ID 相连网络节点ID 视频带宽消耗需求
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
