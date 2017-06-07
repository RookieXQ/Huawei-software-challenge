package com.xiongqi.huawei;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class GraphFromInput3 {

	 private Graph3 graph3;
	 private int networkNodeNumber; //网络节点数量
	 private int networkLinkNumber;  //网络链路数量
	 private int consumerNumber;     //消费节点数量
	 private double serverPrice;  //服务器费用
	 private Map<Integer, LinkWithConsumer> consumerMessage;
	 
	public Map<Integer, LinkWithConsumer> getConsumerMessage() {
		return consumerMessage;
	}

	

	public GraphFromInput3() {
		super();
		consumerMessage=new HashMap<Integer,LinkWithConsumer>();
		createGraph();
	}

	public Graph3 getGraph3() {
		return graph3;
	}

	public void setGraph3(Graph3 graph3) {
		this.graph3 = graph3;
	}

	public int getNetworkNodeNumber() {
		return networkNodeNumber;
	}

	public void setNetworkNodeNumber(int networkNodeNumber) {
		this.networkNodeNumber = networkNodeNumber;
	}

	public int getNetworkLinkNumber() {
		return networkLinkNumber;
	}

	public void setNetworkLinkNumber(int networkLinkNumber) {
		this.networkLinkNumber = networkLinkNumber;
	}

	public int getConsumerNumber() {
		return consumerNumber;
	}

	public void setConsumerNumber(int consumerNumber) {
		this.consumerNumber = consumerNumber;
	}

	public double getServerPrice() {
		return serverPrice;
	}

	public void setServerPrice(double serverPrice) {
		this.serverPrice = serverPrice;
	}


	
	public void createGraph(){
		String filePath="D:\\SHU\\practice\\HUAWEI\\case_example\\第二批练习用例\\2 高级\\case3.txt";
	    InputStreamDispose inputStreamDispose=new InputStreamDispose(filePath);
	    inputStreamDispose.readTxtFile();
	     
	    networkNodeNumber=inputStreamDispose.getNetworkNodeNumber();
	    networkLinkNumber=inputStreamDispose.getNetworkLinkNumber();
	    consumerNumber=inputStreamDispose.getConsumerNumber();
	    serverPrice=inputStreamDispose.getServerPrice();
	    graph3=new Graph3(networkNodeNumber);
	    
	    
	    
	    ListIterator<LinkWithNetworkNode> iter1 =inputStreamDispose.linkWithNetworkNode.listIterator();
	       
	   	while(iter1.hasNext()){
	   	  LinkWithNetworkNode lwnn=iter1.next();
	   	  int netWorkStartId=lwnn.getNetWorkStartId();
	   	  int netWorkTerminalId=lwnn.getNetWorkTerminalId();
	   	  int bandWidthSize=lwnn.getBandWidthSize();
	      int rentPrice=lwnn.getRentPrice();
	      graph3.setEdge(netWorkStartId, netWorkTerminalId, bandWidthSize, rentPrice);
	   	
	   	}
	   	
	   	ListIterator<LinkWithConsumer> iter2 =inputStreamDispose.linkWithConsumer.listIterator();

	   	
	   	while(iter2.hasNext()){
	   		
	 		LinkWithConsumer lwc=iter2.next();
	 		//System.out.println(lwc==null);
	 		consumerMessage.put(lwc.getConsumerId(), lwc);
	 	   }
	   	
	}


}
