package backAlgorithm;

/*
 * 用回溯实现正则表达式：
 * 假设正则表达式中只包含“*”（匹配任意多个字符）和“？”（匹配另个或一个字符），判断
 * 一个给定文本，能否跟给定的正则表达式匹配？
 * 
 * */
public class Pattern {
	private boolean matched = false;
	private char[] pattern; //正则表达式
	private int plen; //正则表达式长度 
	
	public Pattern(char[] pattern,int plen) {
		this.pattern = pattern;
		this.plen = plen;
	}
	
	public boolean match(char[] text,int tlen) {//文本串及长度
		matched = false;
		rmatch(0,0,text,tlen);
		return matched;
	}
	
	/*
	 * 参数：当前
	 * 
	 * */
	private void rmatch(int ti,int pj,char[] text,int tlen) {
		if(matched) return; //如果已经匹配了，就不要继续递归了
		if(pj == plen) { //正则表达式已经到结尾了
			if(ti == tlen)
				matched = true; //文本串也到结尾了
			return;
		}//if(pj == plen)
		
		if(pattern[pj] == '*') {//* 匹配任意多个字符
			for(int k=0;k<=tlen-ti;++k)
				rmatch(ti+k, pj+1, text, tlen);
		}else if(pattern[pj] == '?') { //？匹配0个或1个字符
			rmatch(ti, pj+1, text, tlen);
			rmatch(ti+1, pj+1, text, tlen);
		}else if(ti<tlen && pattern[pj] == text[ti]) { //纯字符匹配才行
			rmatch(ti+1, pj+1, text, tlen);
		}
	}
	
	public static void main(String[] args) {
		String pattern = "a*c?";
		String str1 = "ad";
		String str2 = "asdfsf";
		
		Pattern pat = new Pattern(pattern.toCharArray(), pattern.length());

		System.out.println("str1 with pattern match well ? "+pat.match(str1.toCharArray(), str1.length()));
		System.out.println("str2 with pattern match well ? "+pat.match(str2.toCharArray(), str2.length()));
	}
	
}
