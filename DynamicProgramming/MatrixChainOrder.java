package DynamicProgramming;

public class MatrixChainOrder {
	/*参数p=[30,35,15,5,10,20,25]表示6个连续的矩阵相乘，矩阵的性质分别为30x35,35x15,..,10x20,20x25.
	*注意下标，按照书上的伪代码操作
	*/
	public static void matrixChainOrder(int[] p) {
		int n = p.length-1; //矩阵的个数
		int[][] m = new int[n+1][n+1]; //保存代价m[i][j] 
		int[][] s = new int[n+1][n+1]; //保存对应的分割点 k
		
		for(int i=1;i<=n;++i)
			m[i][i] = 0;
		
		for(int l = 2;l<=n;++l) { // l是链的长度
			for(int i=1;i<=n-l+1;++i) { //计算长度为l=2的链的最小计算代价
				/*
				 * 当l=2时;
				 *      i=0,1,2,...,(n-1)
				 * 		j=1,2,3,...,i+1(即j=i+1，见下士)
				 * 		求的是：m[0,1],m[1,2],...,m[n-1,n]
				 * 
				 * */
				int j = i+l-1; 
				m[i][j] = Integer.MAX_VALUE;
				for(int k=i;k<=j-1;k++) { //k表示在m[i,j]的划分位置，即m[i...k,k+1...j] 
					int q = m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
					if(q < m[i][j]) {
						m[i][j] = q;
						s[i][j] = k;
					}
					
				}//for(int k...
			}//for(int i...
		}//for(int l...
		
		//输出部分
		System.out.println("minCalNum: "+m[1][n]);
		printParens(s,1,n);
	}
	
	public static void printParens(int[][] s,int i,int j) {
		if(i==j)
			System.out.print("A"+i);
		else {
			System.out.print("(");
			printParens(s,i,s[i][j]);
			printParens(s,s[i][j]+1,j);
			System.out.print(")");
		}
	}
	
	public static void main(String[] args) {
		int[] p = new int[] {30,35,15,5,10,20,25};
		matrixChainOrder(p);
		
	}
	
}













