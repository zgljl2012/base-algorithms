package com.zgljl2012.algorithm;

/**
 * Bellman-Ford算法
 * 单源最短路径算法，并可解决负权值
 */
public class BellmanFord {
	
	public static void main(String[] args) {
		/**
		 * 假设有A、B、C、D四个点，路径矩阵如下（没有路则为∞）
		 * 	 A	 B	 C	 D
		 * A 0   1   5   2
		 * B 2   0   2   5
		 * C ∞   ∞   0   2
		 * D ∞   1   ∞   0
		 * 
		 * 多源最短路径矩阵：
		 * 0 1 3 2 
		 * 2 0 2 4 
		 * 5 3 0 2 
		 * 3 1 3 0 
		 */
		int[][] c = new int[][]{
			{0, 1, 5, 2},
			{2, 0, 2, 5},
			{Integer.MAX_VALUE,Integer.MAX_VALUE,0,2},
			{Integer.MAX_VALUE,1,Integer.MAX_VALUE,0}
		};
		int[] dist = new int[c.length];
		int source = 0;
		System.out.println("没有负回路："+bellmanFord(c, dist, source));
		
		println(dist);
		System.out.println();
	}
	
	public static void println(int[] dist) {
		for(int i=0;i<dist.length;i++) {
			System.out.print(dist[i]+ " ");
		}
		System.out.println();
	}
	
	public static class Edge {
		public int u; // 起点
		public int v; // 终点
		public int weight; // 权重
	}
	
	/**
	 * 松弛计算
	 * @param dist 到u的距离
	 * @param u 起点
	 * @param v 终点
	 * @param weight 权重
	 */
	public static void relax(int[] dist, int u, int v, int weight) {
		if(dist[u]<Integer.MAX_VALUE && weight < Integer.MAX_VALUE && dist[v] > dist[u] + weight) {
			dist[v] = dist[u] + weight;
		}
	}
	
	public static boolean bellmanFord(int[][] graph, int[] dist, int source) {
		for(int i=0;i<dist.length;i++) {
			dist[i] = graph[source][i];
		}
		dist[source] = 0;
		for(int k = 0; k < graph.length - 1; k++) {
			for(int i = 0; i < graph.length; i++) {
				for(int j = 0; j < graph.length; j++) {
					relax(dist, i, j, graph[i][j]);
				}
			}
		}
		// 判断是否没有负回路
		for(int i=0;i<graph.length;i++) {
			for(int j=0;j<graph.length;j++) {
				if(dist[i] < Integer.MAX_VALUE && 
						graph[i][j] < Integer.MAX_VALUE && 
						dist[j] > dist[i] + graph[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
}
