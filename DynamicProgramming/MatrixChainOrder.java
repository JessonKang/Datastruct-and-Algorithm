package DynamicProgramming;

public class MatrixChainOrder {
	/*����p=[30,35,15,5,10,20,25]��ʾ6�������ľ�����ˣ���������ʷֱ�Ϊ30x35,35x15,..,10x20,20x25.
	*ע���±꣬�������ϵ�α�������
	*/
	public static void matrixChainOrder(int[] p) {
		int n = p.length-1; //����ĸ���
		int[][] m = new int[n+1][n+1]; //�������m[i][j] 
		int[][] s = new int[n+1][n+1]; //�����Ӧ�ķָ�� k
		
		for(int i=1;i<=n;++i)
			m[i][i] = 0;
		
		for(int l = 2;l<=n;++l) { // l�����ĳ���
			for(int i=1;i<=n-l+1;++i) { //���㳤��Ϊl=2��������С�������
				/*
				 * ��l=2ʱ;
				 *      i=0,1,2,...,(n-1)
				 * 		j=1,2,3,...,i+1(��j=i+1������ʿ)
				 * 		����ǣ�m[0,1],m[1,2],...,m[n-1,n]
				 * 
				 * */
				int j = i+l-1; 
				m[i][j] = Integer.MAX_VALUE;
				for(int k=i;k<=j-1;k++) { //k��ʾ��m[i,j]�Ļ���λ�ã���m[i...k,k+1...j] 
					int q = m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
					if(q < m[i][j]) {
						m[i][j] = q;
						s[i][j] = k;
					}
					
				}//for(int k...
			}//for(int i...
		}//for(int l...
		
		//�������
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













