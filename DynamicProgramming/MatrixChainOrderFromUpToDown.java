package DynamicProgramming;

public class MatrixChainOrderFromUpToDown {
	public static int memoMatChain(int[] p) {
		int n = p.length-1;
		int[][] m = new int[n+1][n+1];
		for(int i=1;i<=n;++i) { //这里下标确定从1开始？
			for(int j=1;j<=n;j++)
				m[i][j] = Integer.MAX_VALUE;
		}
		return lookupChain(m,p,1,n); //计算m[1][n]的价值
	}
	
	public static int lookupChain(int[][] m ,int[] p ,int i,int j) {
		if(m[i][j] < Integer.MAX_VALUE)
			return m[i][j];
		if(i==j)
			m[i][j]=0;
		else {
			/*从i...j,计算每一种情况，即k的每一个可能取的位置
			 * */
			for(int k=i;k<=j-1;++k) {
				int q = lookupChain(m,p,i,k)+lookupChain(m,p,k+1,j)+p[i-1]*p[k]*p[j];
				if(q<m[i][j])
					m[i][j]=q;
			}//for
		}//else
		return m[i][j];
	}
	
	public static void main(String[] args) {
		int[] p = new int[] {30,35,15,5,10,20,25};
		int maxCalNum = memoMatChain(p);
		System.out.println("maxCalNum:"+maxCalNum);
	}
}




