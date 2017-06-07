package com.xiongqi.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import javax.lang.model.type.IntersectionType;

import org.w3c.dom.css.ElementCSSInlineStyle;

public class deploy {
    
	
	
	 //find path with satisfy the serverPrice
    public static void printPathOfConsumer(){
    	GraphFromInput3 graphFromInput=new GraphFromInput3();
    	int V=graphFromInput.getGraph3().getCapacity();
	  //存储所有消费节点的满足要求的链路的终点信息；
    	Map<Integer, List<Integer>> consumerSumOfTerminal=new HashMap<Integer, List<Integer>>();
    	for(int i=0; i<graphFromInput.getConsumerNumber(); i++){
    		//System.out.println("The "+i +" consumer node traverse is start:");
    		int consumerId= graphFromInput.getConsumerMessage().get(i).getConsumerId();
    		DijkstraSearch3 dijkstraSearch3=new DijkstraSearch3(graphFromInput);
    		//获取从当前消费节点出发所有满足要求的直线路径的map集合
    		Map<Integer, List<Integer>>	currentConsumer=dijkstraSearch3.pathOfConSumer(consumerId); 
    		consumerSumOfTerminal.put(i,dijkstraSearch3.getEndNetWorkIdOfPath().get(i));
    		int[] minBandOfPath=dijkstraSearch3.getMinBandOfPath();
    	}

		Map<Integer, List<Integer>> intersectionOfConsumer=intersection(consumerSumOfTerminal);
		
	
		
		
		//输出信息
		System.out.println(graphFromInput.getConsumerNumber());
		System.out.println();
		
		
		
		
		List<Integer> consumerDisposed=new LinkedList<Integer>();
		for(int in:intersectionOfConsumer.keySet()){
			if(intersectionOfConsumer.get(in).size()==0){
				continue;
			}
			else if(intersectionOfConsumer.get(in).size()==1){
				int consumerId2=intersectionOfConsumer.get(in).get(0);
				consumerDisposed.add(consumerId2);
				System.out.println(graphFromInput.getConsumerMessage().get(consumerId2).getNetworkId()+" "+consumerId2);
			}
			else{
				List<Integer> list=intersectionOfConsumer.get(in);
				Iterator<Integer> iterator=list.iterator();
				while(iterator.hasNext()){
					int consumerId=iterator.next();
					consumerDisposed.add(consumerId);
					DijkstraSearch3 dijkstraSearch3=new DijkstraSearch3(graphFromInput);
					Map<Integer, List<Integer>>	currentConsumer=dijkstraSearch3.pathOfConSumer(consumerId);
					List<Integer> pathForPrint=currentConsumer.get(in);
					ListIterator<Integer> pathIterator= pathForPrint.listIterator();
					while(pathIterator.hasNext()){
						pathIterator.next();
						 
					}
					while(pathIterator.hasPrevious()){
						System.out.print(pathIterator.previous()+" ");
					}
					System.out.print(consumerId);    
					System.out.println();
				}
			}
			
		}
		List<Integer> consumerIdArray=new LinkedList<Integer>();
		for(int num=0; num<graphFromInput.getConsumerNumber(); num++){
			consumerIdArray.add(num);
		}
		Iterator<Integer> iteratorConsumerIdArray=consumerIdArray.iterator();
		while(iteratorConsumerIdArray.hasNext()){
			int temp=iteratorConsumerIdArray.next();
			if(consumerDisposed.contains(temp)){
				continue;
			}else{
				System.out.println(graphFromInput.getConsumerMessage().get(temp).getNetworkId()+" "+temp);
			}
		}
      
		
		
		
		
		
    		
    }
    
    
    
    
    
    public static Map<Integer, List<Integer>> intersection(Map<Integer,List<Integer>> consumerSumOfTerminal){
  	
    	//存储所有消费者节点可行链路的交集的网络节点，及消费者节点号；
    	Map<Integer, List<Integer>> intersectionMessage=new HashMap<Integer,List<Integer>>();
    	for(int i=0; i<consumerSumOfTerminal.size(); i++ ){
    	   List<Integer> list1=consumerSumOfTerminal.get(i);
    	   Iterator<Integer> iterator=list1.iterator();
    	   int[] temp1=new int[list1.size()];
    	   int j=0;
 			while(iterator.hasNext()){ 				
 			      temp1[j]=iterator.next();
 			      j++;
 		   }
 	       Arrays.sort(temp1);
 	      
    	   for(int k=i+1; k<consumerSumOfTerminal.size(); k++){
               List<Integer> list2=consumerSumOfTerminal.get(k);
               Iterator<Integer> iterator2=list2.iterator();
    	       int[] temp2=new int[list2.size()];
    		   int h=0;
    		   while(iterator2.hasNext()){
    			  temp2[h]=iterator2.next();	  
    			  if(Arrays.binarySearch(temp1, temp2[h])>=0){
    				  if(intersectionMessage.get(temp2[h])==null){
    					  intersectionMessage.put(temp2[h], new LinkedList<>());
    				  }
    				  if(intersectionMessage.get(temp2[h]).size()==0){
    					  intersectionMessage.get(temp2[h]).add(i);
    				  }
    				  if(intersectionMessage.get(temp2[h]).contains(k)){
    					  continue;
    				  }else{
    				      intersectionMessage.get(temp2[h]).add(k);
    				  }
    			  }
    			  h++;   			  
    		   }   
    		}
    		
    	}
    	
	
    	//判断是否包含相同元素 ，若包含则取大者；
    	
    	
    	
    	Set<Integer> set=intersectionMessage.keySet();

    	
	    
    	for(int in:intersectionMessage.keySet()){

    		List<Integer> previous=intersectionMessage.get(in); 
    		Iterator<Integer> ite2=set.iterator();
    	    while(ite2.hasNext()){
    				 List<Integer>  after=intersectionMessage.get(ite2.next());
		     	     Iterator<Integer> pIterator=previous.iterator();	
    				 if(previous==after){
    					 continue;
    				 }		     	     	       				 
    				 while(pIterator.hasNext()){
    					  int pTemp=pIterator.next();
    					  Iterator<Integer> aIterator=after.iterator();	
   		     	          while(aIterator.hasNext()){
   		     	    	        int aTemp=aIterator.next();
   		     	    	        if(previous.size()<=after.size()){
   		     	    		         if(pTemp==aTemp){
   		     	    	     	           pIterator.remove();
   		     	    	     	     }
   		     	    	        }else{
   		     	    		         if(pTemp==aTemp){
   		     	    		               aIterator.remove();
   		     	    		         }
   		     	    	        }
    			          }
    		        }
    	  }
    	}
    		
	
    	return intersectionMessage;
    }
    
    
  
    
    
    
    public static void main(String[] args){
    	printPathOfConsumer();
    	
    }
	
	
}
