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
 * ���ڵõ������е����ݣ������д洢
 * 
 */
public class InputStreamDispose {

   private  String filePath;
   private int networkNodeNumber; //����ڵ�����
   private int networkLinkNumber;  //������·����
   private int consumerNumber;     //���ѽڵ�����
   
   private double serverPrice;  //����������
   
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
    * readTxtFile�����ļ��ж�ȡ���ݣ������д洢��
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
			
			   linTxt=bufferedReader.readLine();   //��������...
			  
			   linTxt=bufferedReader.readLine();
			   temp=returnInteger(linTxt);
			   serverPrice=temp[0];
			  // System.out.println("serverPrice= "+serverPrice);
			   
			   linTxt=bufferedReader.readLine();   //��������...
			   
			   //��ȡ����ڵ���·
			  linkWithNetworkNode=new LinkedList<LinkWithNetworkNode>();
			   linTxt=bufferedReader.readLine();
			   while(testEmptyString(linTxt)){
				   
				   temp=returnInteger(linTxt);
				   LinkWithNetworkNode lwnn=new LinkWithNetworkNode(temp[0],temp[1],temp[2],temp[3]);
				   linkWithNetworkNode.add(lwnn);
				   linTxt=bufferedReader.readLine(); 
				   
			   }
			   
			   //��ȡ����ڵ�������߽ڵ���Ϣ
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
			   System.out.println("�Ҳ���ָ�����ļ�");
		   }
	   }
	   
	   catch(Exception e){
		   System.out.println("��ȡ���ݳ���");
		   e.printStackTrace();
	   }
	 }
   
   /*
    * returnInteger:��һ���ַ�������ȡ�����������character���鵱�У�
    * private: ���Լ��⣬�����κ��඼���ܷ��ʸó�Ա��
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
     * testEmptySring�����ڲ���һ���ַ����Ƿ��ǿյģ�
     */
    public boolean testEmptyString(String line){
 		
        String ss=line.trim();
      
    		if(ss==null||ss.isEmpty())
    			return false;
    		else
    			return true;
    	}

       
}
