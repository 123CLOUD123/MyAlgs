package MyDataStructure;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 图的数据结构
 * @author Cloud
 *
 */
public class Graph {

	//顶点数
	private final int points;
	
	//边数
	private int edges;
	
	private List<Integer>[] adj;
	
	Graph(int n) {
		this.points = n;
		adj = new List[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	//获取边数
	public int getEdges() {
		return this.edges;
	}
	
	//获取顶点数
	public int getPoints() {
		return this.points;
	}
	
	//增加边
	public void addEdge(int i, int j) {
		adj[i].add(j);
		adj[j].add(i);
		this.edges++;
	}
	
	public static void main(String[] args) {
		Graph g = new Graph(10);
		g.addEdge(0, 1);
		g.addEdge(0,  2);
		System.out.println((g.adj[0]));
		System.out.println(g.getEdges());
	}
	
}
