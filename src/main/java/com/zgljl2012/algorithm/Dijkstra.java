package com.zgljl2012.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dijkstra {
	
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
			{0,1,5,2},
			{2,0,2,5},
			{Integer.MAX_VALUE,Integer.MAX_VALUE,0,2},
			{Integer.MAX_VALUE,1,Integer.MAX_VALUE,0}
		};
		int[] dist = new int[c.length];
		int[] prev = new int[c.length];
		int source = 1;
		dijkstra(c, dist, prev, source);
		
		for(int i=0;i<dist.length;i++) {
			System.out.print(prev[i]+ " ");
		}
		System.out.println();
		printPath(prev, source, 3);
	}
	
	public static void printPath(int[] prev, int source, int target) {
		List<Integer> list = new ArrayList<>();
		list.add(target);
		int cur = target;
		while(true) {
			int p = prev[cur];
			list.add(p);
			cur = p;
			if(p == source||p==-1) {
				break;
			}
		}
		Collections.reverse(list);
		for(int i=0;i<list.size()-1;i++) {
			System.out.println(list.get(i)+"->"+list.get(i+1));
		}
	}
	
	/**
	 * Dijkstra算法
	 * @param c 邻接矩阵
	 * @param dist 从源点到其他点的最短路径数组
	 * @param prev 上一个节点数组
	 * @param source 源点
	 */
	public static void dijkstra(int[][] c, int[] dist, int[] prev, int source) {
		boolean[] s = new boolean[c.length]; // S集合，即顶点集合
		for(int i=0;i<c.length;i++) {
			dist[i] = c[source][i]; // dist数组初始化
			s[i] = false;
			// 上一个节点初始化
			prev[i] = dist[i]<Integer.MAX_VALUE?source:-1;
		}
		s[source] = true;
		dist[source] = 0;
		
		for(int i=0;i<c.length;i++) {
			int u = 0;
			int tmp = Integer.MAX_VALUE;
			// 找出dist中最小的数，即找出一个最短路径
			for(int j=1;j<c.length;j++) {
				if(!s[j]&&dist[j]<tmp) {
					u = j;
					tmp = dist[j];
				}
			}
			s[u] = true;
			// 更新dist
			for(int j=0;j<c.length;j++) {
				if(!s[j]&&c[u][j] < Integer.MAX_VALUE) {
					if(dist[j] > dist[u] + c[u][j]) {
						dist[j] = dist[u] + c[u][j];
						prev[j] = u;
					}
				}
			}
		}
	}
	
}
