package DynamicProgramming;

public class MatrixChainOrderFromUpToDown {
	public static int memoMatChain(int[] p) {
		int n = p.length-1;
		int[][] m = new int[n+1][n+1];
		for(int i=1;i<=n;++i) { //�����±�ȷ����1��ʼ��
			for(int j=1;j<=n;j++)
				m[i][j] = Integer.MAX_VALUE;
		}
		return lookupChain(m,p,1,n); //����m[1][n]�ļ�ֵ
	}
	
	public static int lookupChain(int[][] m ,int[] p ,int i,int j) {
		if(m[i][j] < Integer.MAX_VALUE)
			return m[i][j];
		if(i==j)
			m[i][j]=0;
		else {
			/*��i...j,����ÿһ���������k��ÿһ������ȡ��λ��
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




