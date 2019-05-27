package stringMatch;

public class kmp_search_all_pattern_in_text {
	public static void KMP(String text,String pattern) {
		char[] T = text.toCharArray();
		char[] P = pattern.toCharArray();
		
		int[] next = getNexts(pattern);
		for(int i=0;i<next.length;++i)
			System.out.print(next[i]+" ");
		
		int m = P.length; //模式串的长度
		
		int i=0,j=0;
		while(i<T.length) {
			if(j==m-1 && P[j]==T[i]) {
				System.out.println("Found pattern at :" + (i-j));
				j = next[j];
			}
			
			if(j==-1 || T[i] == P[j]) { //因为主串中可能存在多个和模式串匹配的子串，所以上面if中的j=next[j]可能会使得j=-1，所以这里要添加j==-1的情况
				i++;
				j++;
			}else {
				j = next[j];
			}
			
		}
		return ;
	}
	
	public static int[] getNexts(String pattern) {
		char[] p = pattern.toCharArray();
		int[] next = new int[p.length];
		
		next[0]=-1;
		int k=-1;
		int j=0;
		
		while(j<p.length-1) {
			if(k==-1 || p[j] == p[k]) {
				if(p[++j]==p[++k]) {
					next[j]=next[k];
				}else	
					next[j]=k;
			}else {
				k = next[k];
			}
		}
		return next;
		
	}
	public static void main(String[] args) {
		String text = "abababcddefabcddabc";
		String pattern = "abc";
		
		System.out.println(text);
		System.out.println(pattern);
		KMP(text,pattern);
	}
	
}























