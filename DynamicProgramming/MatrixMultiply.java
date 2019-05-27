package DynamicProgramming;

public class MatrixMultiply {
	public static int[][] matmulti(int[][] A,int B[][]) {
		
		int[][] C = new int[A.length][B[0].length];
		
		if(A[0].length != B.length)
			return null; //�����Ͼ���ĳ˷�����
		else {
			for(int i=0;i<A.length;++i) { //����A�������
				for(int j=0;j<B[0].length;++j) { //����B�������
					C[i][j] = 0; //�¾����е�i�е�j�е���
					
					for(int k=0;k<A[0].length;++k) { //�þ���A�ĵ�i�е�ÿ��Ԫ��ȥ�˾���B�ĵ�j�е�ÿһ�е�Ԫ��
						C[i][j] += A[i][k]*B[k][j];
					}//for(int k...
				}//for(int j...
			}//for(int i...
		}
		return C;
	}
	
	public static void main(String[] args) {
		/*
		 * A(2x3)  * B(3x2)	= C(2x2)
		 * 1 2 1	 0 1	  7 6	
		 * 2 1 1 	 2 2	  5 5
		 * 			 3 1
		 * 
		 * */
		int[][] A = new int[][] {{1,2,1},{2,1,1}};
		int[][] B = new int[][] {{0,1},{2,2},{3,1}};
		int[][] C = matmulti(A,B);
		if(C!=null) {
			for(int i=0;i<C.length;++i) {
				for(int j=0;j<C[0].length;++j)
					System.out.print(C[i][j]+" ");
				System.out.println();
			}
		}
	}
	
}







