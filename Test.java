
public class Test {
	public static int cutRod(int[] p,int n) {
		int[] r = new int[n+1]; //保存长度从0~n的钢管的价值
		r[0] = 0;//长度为0的钢管不需要切割，价值也为0
		
		for(int j=1;j<=n;++j) { //计算r[1...n]的钢管的价值（不管它切割或不切割）
			int q = Integer.MIN_VALUE;
			for(int i=1;i<=j;++i) { 
				/*计算一根长度为j的钢管进行切割的所有情况，在其中找出最大的价值q,如下分析：
				 *如j=3时，i=1,2,3,对应如下情况：
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
