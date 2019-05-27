package DynamicProgramming;


public class CutRod {
	//1���ݹ���������⣬���Ӷ�ΪO(2^n)
	public static int cutRod(int[] p,int n) {
		if(n==0)
			return 0;
		int q = Integer.MIN_VALUE;
		for(int i=1;i<=n;i++) {
			q = Math.max(q,p[i-1]+cutRod(p,n-i));
		}
		return q;
		
	}
	
	//DP1��top-down with memoization  ���ﲻ̫��������������������������,�������ʱ�����
	public static int memoCutRod(int[] p,int n) {
		int[] r = new int[n+1]; //���汸����Ϣ
		
		for(int i=0;i<=n;++i) {
			r[i] = Integer.MIN_VALUE;
		}
		
		return memoCutRodAux(p,n,r);
	}
	
	public static int memoCutRodAux(int []p,int n,int[] r) {
		int q;
		if(r[n]>=0)
			return r[n];
		
		if(n==0) //����Ϊ0��
			q = 0;
		else {
			q = Integer.MIN_VALUE;
			for(int i=1;i<=n;++i) {
				q = Math.max(q, p[i-1]+memoCutRodAux(p,n-i,r));
			}
		}
		r[n] = q;
		return 0;
	}
	
	//DP2:Bottom-up method
	public static int bottomUpCutRod(int[] p,int[] s,int n) {
		int[] r = new int[n+1]; //���泤�ȴ�0~n�ĸֹܵļ�ֵ
		r[0] = 0;//����Ϊ0�ĸֹܲ���Ҫ�и��ֵҲΪ0
		
		for(int j=1;j<=n;++j) { //����r[1...n]�ĸֹܵļ�ֵ���������и���и
			int q = Integer.MIN_VALUE;
			for(int i=1;i<=j;++i) { 
				/*����һ������Ϊj�ĸֹܽ����и������������������ҳ����ļ�ֵq,���·�����
				 *��j=3ʱ��i=1,2,3,��Ӧ���������
				 *	i=1, q = max(q,p[1]+r[2])
				 *  i=2, q = max(q,p[2]+r[1])
				 *  i=3, q = max(q,p[3]+r[0])
				 * 
				 * */
				q = Math.max(q, p[i-1]+r[j-i]);
			}
			r[j] = q;
		}//for(int j=1...
		return r[n];
	}
	
	public static void printCutRodSolution(int[] p,int n) {
		int[] s= new int[n+1];
		int r = bottomUpCutRod(p,s,n);
		System.out.println("the max value:"+r);
		System.out.print("the cut plan is: ");
		while(n>0) {
			System.out.print(s[n]+" ");
			n = n-s[n];
		}
	}
	
	public static void main(String[] args) {
		int[] p = new int[] {1,5,8,9,10,17,17,20,24,30};
		int q = cutRod(p,4);
		System.out.println("the max value from cutRod:"+q);
		
		q = memoCutRod(p,4);
		System.out.println("the max value from memoCutRodAux:"+q);
		
		printCutRodSolution(p,7);
		//q = bottomUpCutRod(p,4);
		//System.out.println("the max value from memoCutRodAux:"+q);
	}
}
