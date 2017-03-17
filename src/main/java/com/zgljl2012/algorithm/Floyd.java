package com.zgljl2012.algorithm;

/**
 * Floyd - 多源最短路径算法
 * 时间复杂度 O(n^3)
 * 空间复杂度O(n^2)
 * @author zgljl2012
 *
 */
public class Floyd {
	
	public static void main(String[] args) {
		/**
		 * 假设有A、B、C、D四个点，路径矩阵如下（没有路则为∞）
		 * 	 A	 B	 C	 D
		 * A 0   1   5   2
		 * B 2   0   2   5
		 * C ∞   ∞   0   2
		 * D ∞   1   ∞   0
		 */
		int[][] path = new int[][]{
			{0,1,5,2},
			{2,0,2,5},
			{Integer.MAX_VALUE,Integer.MAX_VALUE,0,2},
			{Integer.MAX_VALUE,1,Integer.MAX_VALUE,0}
		};
		floyd(path);
		for(int i=0;i<path.length;i++) {
			for(int j=0;j<path[0].length;j++) {
				System.out.print((path[i][j]==Integer.MAX_VALUE?"∞":path[i][j])+" ");
			}
			System.out.println();
		}
	}
	
	public static void floyd(int[][] path) {
		int n = path.length;
		for(int k=0;k<n;k++) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(path[i][k]<Integer.MAX_VALUE&& path[k][j]<Integer.MAX_VALUE
									&&path[i][j] > path[i][k]+path[k][j]) {
						path[i][j] = path[i][k]+path[k][j];
					}
				}
			}
		}
	}
	
}
