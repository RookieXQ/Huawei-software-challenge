package com.xiongqi.huawei;

import java.util.List;

public class ClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GraphFromInput3 graphFromInput=new GraphFromInput3();
        System.out.println(graphFromInput.toString());
        Graph3 graph3=graphFromInput.getGraph3();
		 System.out.println ("the given Adjacency List for the graph \n");
	        for (int i = 0 ; i <graphFromInput.getNetworkNodeNumber() ; i++)
	        {
	            System.out.print(i+"->");
	            List<Edge3> edgeList = graph3.getEdge(i);
	            for (int j = 1 ; ; j++ )
	            {
	                if (j != edgeList.size())
	                {
	                    System.out.print(edgeList.get(j - 1 ).getW()+","+edgeList.get(j-1).getBandWidthSize()+
	                    		","+edgeList.get(j-1).getRentPrice()+"->");
	                }else
	                {
	                	System.out.print(edgeList.get(j - 1 ).getW()+","+edgeList.get(j-1).getBandWidthSize()+
	                    		","+edgeList.get(j-1).getRentPrice()+"->");
	                    break;
	                }						 
	            }
	            System.out.println();					
	         }
		
		DijkstraSearch3 dijkstraSearch3=new DijkstraSearch3(graphFromInput);

	    dijkstraSearch3.printPath(0);

	}
	
	
}
