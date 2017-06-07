package com.xiongqi.huawei;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;




public class Graph3 {
    
	private int ID;
    private int capacity;
	private Map<Integer, List<Edge3>> adjacentList;
	
	public Graph3(int numberOfVertices){
		adjacentList = new HashMap<Integer,List<Edge3>>();
		this.capacity=numberOfVertices;
		this.ID=0;
		for(int i=0; i<numberOfVertices; i++){
			adjacentList.put(i, new LinkedList<>());
		}
	}
	
	public int getCapacity() {
		return capacity;
	}

	

	public void setEdge(int source, int destination, int bandWidthSize, int rentPrice){
		if (source > adjacentList.size() || destination > adjacentList.size())
	       {
	           System.out.println("the vertex entered in not present ");
	           return;
	       }
		 Edge3 sEdge=new Edge3(ID,source,destination, bandWidthSize, rentPrice);
		 Edge3 dEdge=new Edge3(ID, destination,source, bandWidthSize, rentPrice);
		 ID++;
		 List<Edge3> sList=adjacentList.get(source);
		 sList.add(sEdge);
		 List<Edge3> dList=adjacentList.get(destination);
		 dList.add(dEdge);	
	}
	
	public List<Edge3> getEdge(int source){
		if (source > adjacentList.size())
        {
            System.out.println("the vertex entered is not present");
            return null;
        }
        return adjacentList.get(source);
	}
	
	
    public static void main(String...arg)
    {
    	
    	/*      实例图：    边的中间为权重
    	 *             1 *****5***** 3 ****3****** 5
    	 *           *   *          *  *          *
    	 *          6      2      3      2      5
    	 *         *         *   *         *  *
    	 *        0 ****3***** 2 *****4*****4
    	 *          
    	 * */   
    	
        Graph3 graph3=new Graph3(9);
        graph3.setEdge(0, 1, 6, 6);
        graph3.setEdge(0, 2, 3, 9);
        graph3.setEdge(1, 3, 5, 6);
        graph3.setEdge(1, 2, 2, 9);
        graph3.setEdge(2, 3, 3, 6);
        graph3.setEdge(2, 4, 1, 7);
        graph3.setEdge(3, 4, 2, 7);
        graph3.setEdge(3, 5, 3, 7);
        graph3.setEdge(4, 5, 5, 3);
        graph3.setEdge(5, 6, 2, 8);
        graph3.setEdge(4, 6, 2, 1);
        
        graph3.setEdge(7, 8, 1, 3);
        
        
        System.out.println ("the given Adjacency List for the graph \n");
        for (int i = 0 ; i <9 ; i++)
        {
            System.out.print(i+"->");
            List<Edge3> edgeList = graph3.getEdge(i);
            for (int j = 1 ; ; j++ )
            {
                if (j != edgeList.size())
                {
                    System.out.print(edgeList.get(j - 1 ).getW()+"->");
                }else
                {
                    System.out.print(edgeList.get(j - 1 ).getW());
                    break;
                }						 
            }
            System.out.println();					
         }
        DijkstraSearch3 dijkstraSearch3=new DijkstraSearch3(graph3);
        //dijkstraSearch3.dijkstra(5);
        dijkstraSearch3.printPath(0);
    }
    
}
