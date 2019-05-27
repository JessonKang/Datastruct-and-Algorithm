package stringMatch;

public class Kmp {
	//kmp主算法
	public static int KMP(String ts,String ps) {
		char[] t= ts.toCharArray();
		char[] p = ps.toCharArray();
		
		int i=0; //主串的位置
		int j= 0; //模式串的位置
		
		int[] next = getNext(ps);
		while(i<t.length && j<p.length) {
			if(j==-1 || t[i] == p[j]) {//当j为-1时，要移动i，j也要归0
				i++;
				j++;
			}else {
				//i不需要回溯
				j = next[j]; //j回到指定位置
			}
		}
		
		if(j == p.length)
			return i-j;
		else
			return -1;
	}
	
	public static int[] getNext(String ps) {
		char[] p = ps.toCharArray();
		int[] next = new int[ps.length()];
		
		next[0] = -1;//
		int j=0;
		int k=-1;
		/*
		 *  next[j]=k 表示当下标为i的数据不匹配时，j应该指向的下一个位置是k,当k=-1时要特殊处理；
		 *  当j指向k时，应该注意此时p[0 ~ k-1]这个子串是和主串相匹配的，因此此时是拿p[k]这个字符去比较
		 * */
		
		while(j<p.length-1) { //注意语句中有p[j++],即j循环的范围在 [0 ~ m-1]
			if(k==-1 || p[j]==p[k]) {
				/*注意此时的j和k是相对应的
				*（1）k==-1,此时是边界条件(且此时的j=0)，所以让j++,k++，得到j=1,k=0,表示如果p[1]失配，那么j则指向k，即下一次拿来比较的就是下标为0的字符
				*（2）p[j]==p[k]，主要如果不成立的时候，j要指向k，即 p[0 ~ k-1] 是 p[0 ~ j-1] 的最长公共前后缀子串，而此时p[j]==p[k]，
				*即 p[0 ~ k] 是 p[0 ~ j] 的最长公共前后缀子串，所以next[j+1] = next[j](即k)+1;
				*/
				
				j++;
				k++;
				if(p[j] == p[k])
					next[j] = next[k];
				else
					next[j] = k;
				//上面的if判断是对：next[j] = k 语句的优化，
				/*注意此时的j是j++以后的j
				原因，见博客：https://www.cnblogs.com/yjiyjige/p/3263858.html 
				*/			
			}else {
				/*(3)当p[j] != p[k],同样，由next[j]=k 知 p[0 ~ k-1]  是 p[0 ~ j-1] 的最长公共前后缀子串，但是此时 p[j] != p[k],则此时 p[0 ~ k] 不可能是 p[0 ~ j]的
				 * 最长公共前后缀子串，因为p[j] != p[k]。但是此时需要为p[j+1]找最长公共前后缀子串，所以这个时候就需要回溯k,即 k = next[k],
				 * 
				 * */
				k = next[k];
			}
		}
		
		/*while(j<p.length - 1) {
			if(k==-1 || p[j] == p[k]) {
				if(p[++j] == p[++k]) { //当两个字符相等时要跳过
					next[j] = next[k];
				}else {
					next[j] = k;
				}
			}else {
				k = next[k];
			}
		}*/
		return next;
	}
	public static void main(String[] args) {
		String ts = "abcabceabcdef";
		String ps = "abcd";
		
		int index = KMP(ts,ps);
		System.out.println(ts);
		System.out.println(ps);
		System.out.println("start index:"+index);
	}
	
}






















