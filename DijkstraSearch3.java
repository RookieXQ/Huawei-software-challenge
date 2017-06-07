package com.xiongqi.huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;


public class DijkstraSearch3 {
	
	
	private int[] distance;
    private double serverPrice;
    private	Graph3 graph3;
    private int V;
    private double[] dist;
    private int[]  minBandOfPath;   //it is used for recording the minimum  band of the path;

    private int[] priceOfPath;
    private Map<Integer, List<Integer>>  pathOfNetworkNode;
    private Map<Integer, LinkWithConsumer> consumerMessage;
    private Map<Integer, List<Integer>> endNetWorkIdOfPath;

    
    public DijkstraSearch3(GraphFromInput3 graphFromInput){
    	super();   	
    	this.graph3=graphFromInput.getGraph3();
    	this.consumerMessage=graphFromInput.getConsumerMessage();
    	this.V=graph3.getCapacity();
    	this.serverPrice= graphFromInput.getServerPrice();
    	this.distance=new int[V];
    	this.pathOfNetworkNode=new HashMap<Integer,List<Integer>>();
    	this.minBandOfPath=new int[V];
    	this.endNetWorkIdOfPath=new HashMap<Integer,List<Integer>>();
    	
    	for(int i=0; i<V; i++){
			pathOfNetworkNode.put(i, new LinkedList<>());
			minBandOfPath[i]=0;
			
		}
    }
    
	public DijkstraSearch3(Graph3 graph3){
    	this.graph3=graph3;
    	this.V=graph3.getCapacity();
    	this.distance=new int[V];
    	this.pathOfNetworkNode=new HashMap<Integer,List<Integer>>();
    	this.minBandOfPath=new int[V];
    	for(int i=0; i<V; i++){
			pathOfNetworkNode.put(i, new LinkedList<>());
			minBandOfPath[i]=0;
		}
    }
	
	 public Map<Integer, List<Integer>> getEndNetWorkIdOfPath() {
			return endNetWorkIdOfPath;
	 }
    
    public int[] getMinBandOfPath() {
		return minBandOfPath;
	}


	//find path with satisfy the serverPrice
    public Map<Integer, List<Integer>> pathOfConSumer(int consumerId){
    	dijkstra(consumerMessage.get(consumerId).getNetworkId());
    	endNetWorkIdOfPath.put(consumerId,new LinkedList<>());
    	for(int i=0; i<V;i++){
    		List<Integer> pathList=pathOfNetworkNode.get(i);
    		pathList.add(i);
    		
    		List<Integer> list=endNetWorkIdOfPath.get(consumerId);
    		list.add(i);
    		
    		boolean b=isSatisfyBandDemand(consumerId, i);
    		if(priceOfPath[i]<serverPrice||!b){
    			Set<Integer> set=pathOfNetworkNode.keySet();
                set.remove(i);                                  //retaining satisfy path;
               
                ListIterator<Integer> iterator3=list.listIterator();
                
                if(list.size()==0);
                else{
        	          while(iterator3.hasNext()){
                	   iterator3.next();
        	          }
        	          iterator3.remove();
                }
    		}
    		    		
    	}
    	return pathOfNetworkNode;
    		
    }
    
    
    public void printPath(int m) {
    	dijkstra(m);
    	for(int i=0; i<V; i++){
    		 List<Integer> pathList=pathOfNetworkNode.get(i);
    		 pathList.add(i);
             Iterator<Integer> ite=pathList.listIterator();
             while(ite.hasNext()){
            	 System.out.print("-> "+ite.next());
             }
             System.out.println("  the path minimum band is "+minBandOfPath[i]);
             System.out.println("The next node:");
        
    	}
    	
    }
	
    public boolean isSatisfyBandDemand(int consumerId, int i){
        int bandDemand=consumerMessage.get(consumerId).getConsumeDemand();
        if(bandDemand>minBandOfPath[i])
    	   return false;
    	
    	return true;
    }
    
    
    
    //find node path which satisfy price demand;
    
	public void dijkstra(int s){   
		int count=0;
	    boolean[] marked = new boolean[V];
	    dist = new double[V];
	    priceOfPath=new int[V]; 
	    
	    for(int i = 0; i<V; i++){ // initializing array
	        dist[i] = Double.POSITIVE_INFINITY;
	    }
	    
	    dist[s] = 0.0;

	    Queue<Integer> pqs = new PriorityQueue<Integer>();

	    pqs.add(s);
	    while(!pqs.isEmpty()){
	        int v = pqs.poll();
	        if(marked[v]) continue;
	        count++;
	        marked[v] = true;
	        	        
	        List<Edge3> list=graph3.getEdge(v);
	        Iterator<Edge3> iterator=list.iterator();
	        while(iterator.hasNext()){
	        	Edge3 e=iterator.next();
	        	//v = e.getV();
		        //int w = e.getW();
	        	int w = (v == e.getV()) ? e.getW() : e.getV();
  	
		        if(dist[w] > dist[v] + e.getBandWidthSize()){
		        	    
		                dist[w] = dist[v] + e.getBandWidthSize();
		                distance[w] = e.getV(); //all the distances will be stored in this array
		                pqs.add(w);
		                
		                if(minBandOfPath[v]==0){
		  	        	  minBandOfPath[w]=e.getBandWidthSize();
		  	        	  }
		                else if(minBandOfPath[v]<e.getBandWidthSize()&&minBandOfPath[v]!=0)
		                	  minBandOfPath[w]=minBandOfPath[v];
		                 else{
		                	 minBandOfPath[w]=e.getBandWidthSize();
		                 }
		                
		                //System.out.println("The minimum band of path " + v+" -> "+w +" is "+minBandOfPath[v]+" -> " + minBandOfPath[w]);
		                
		                List<Integer> pathListOfW=pathOfNetworkNode.get(w);
		                List<Integer> pathListOfV=pathOfNetworkNode.get(v);

		                ListIterator<Integer> iterator2=pathListOfW.listIterator();
                        		                
		                if(pathListOfW.size()==0);
		                else{
		        	          while(iterator2.hasNext()){
		                	   iterator2.next();
		                	   iterator2.remove();
		        	         }
		                }
		                pathListOfW.add(v);
		                		                
		                //combines with two list;
		                List<Integer> list2=new LinkedList<>();
		                list2.addAll(pathListOfV);
		                list2.addAll(pathListOfW);
		                Set<Integer> set=pathOfNetworkNode.keySet();
		                set.remove(w);
		                pathOfNetworkNode.put(w, list2);
		                		                
		                priceOfPath[w]=(e.getRentPrice())*(e.getBandWidthSize())+priceOfPath[v];
		                //System.out.println( v+" -> "+w+" execution with band sum "+dist[w]+" and price is "+priceOfPath[w]);
		        }
	        }   
	    }
	    //System.out.println("end with "+count);
	}
	

}
