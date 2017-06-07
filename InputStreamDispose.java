package com.xiongqi.huawei;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/*
 * 用于得到本文中的数据，并进行存储
 * 
 */
public class InputStreamDispose {

   private  String filePath;
   private int networkNodeNumber; //网络节点数量
   private int networkLinkNumber;  //网络链路数量
   private int consumerNumber;     //消费节点数量
   
   private double serverPrice;  //服务器费用
   
   private int[] temp;
   
   public List<LinkWithNetworkNode> linkWithNetworkNode;
   
   public List<LinkWithConsumer> linkWithConsumer;
   
   
   

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

  public  InputStreamDispose(String filePath) {
	super();
	this.filePath = filePath;
   }
   
   /*
    * readTxtFile：从文件中读取数据，并进行存储；
    */
   public  void readTxtFile(){
	   try{
		   String encoding="GBK";
		   File file=new File(filePath);
		   
		   if(file.isFile()&&file.exists()){
			   InputStreamReader read=new InputStreamReader(new FileInputStream(file),encoding);
			   BufferedReader bufferedReader=new BufferedReader(read);
			   String linTxt=null;
			   
			   linTxt=bufferedReader.readLine();
			   temp=returnInteger(linTxt);
			   networkNodeNumber=temp[0];
			  // System.out.println("networkNodeNumber= "+networkNodeNumber);
			   networkLinkNumber=temp[1];
			  // System.out.println("networkLinkNumber= "+networkLinkNumber);
			   consumerNumber=temp[2];
			   // System.out.println("consumerNumber= "+consumerNumber);
			
			   linTxt=bufferedReader.readLine();   //跳过空行...
			  
			   linTxt=bufferedReader.readLine();
			   temp=returnInteger(linTxt);
			   serverPrice=temp[0];
			  // System.out.println("serverPrice= "+serverPrice);
			   
			   linTxt=bufferedReader.readLine();   //跳过空行...
			   
			   //获取网络节点链路
			  linkWithNetworkNode=new LinkedList<LinkWithNetworkNode>();
			   linTxt=bufferedReader.readLine();
			   while(testEmptyString(linTxt)){
				   
				   temp=returnInteger(linTxt);
				   LinkWithNetworkNode lwnn=new LinkWithNetworkNode(temp[0],temp[1],temp[2],temp[3]);
				   linkWithNetworkNode.add(lwnn);
				   linTxt=bufferedReader.readLine(); 
				   
			   }
			   
			   //获取网络节点和消费者节点信息
			   linkWithConsumer=new LinkedList<LinkWithConsumer>();
			   linTxt=bufferedReader.readLine();
			   while(testEmptyString(linTxt)){
				   
				   temp=returnInteger(linTxt);
				   LinkWithConsumer lwc=new LinkWithConsumer(temp[0],temp[1],temp[2]);
				   linkWithConsumer.add(lwc);
				   if(( linTxt=bufferedReader.readLine())==null)
					   break;
				  
			   }
			   
			  
		     read.close();
		   }
		   else{
			   System.out.println("找不到指定的文件");
		   }
	   }
	   
	   catch(Exception e){
		   System.out.println("读取内容出错");
		   e.printStackTrace();
	   }
	 }
   
   /*
    * returnInteger:将一行字符串数据取出，并存放于character数组当中；
    * private: 除自己外，其它任何类都不能访问该成员；
    */
    public int[] returnInteger(String line){
    	line.trim();
    	String[] ss=line.split(" ");
    	int[] character=new int[ss.length]; 
    	for(int i=0;i<ss.length;i++)
    		character[i]=Integer.parseInt(ss[i]);
    	return character;
    	
    }
    
    /*
     * testEmptySring：用于测试一行字符串是否是空的；
     */
    public boolean testEmptyString(String line){
 		
        String ss=line.trim();
      
    		if(ss==null||ss.isEmpty())
    			return false;
    		else
    			return true;
    	}

       
}
