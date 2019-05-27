
public class Test {
	public static int cutRod(int[] p,int n) {
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
	
	public static void main(String[] args) {
		int[] p = new int[] {1,5,8,9,10,17,17,20,24,30};
		int maxValue = cutRod(p,4);
		
		System.out.println("maxValue:"+maxValue);
	}
}
