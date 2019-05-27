package backAlgorithm;

/*
 * �û���ʵ��������ʽ��
 * ����������ʽ��ֻ������*����ƥ���������ַ����͡�������ƥ�������һ���ַ������ж�
 * һ�������ı����ܷ��������������ʽƥ�䣿
 * 
 * */
public class Pattern {
	private boolean matched = false;
	private char[] pattern; //������ʽ
	private int plen; //������ʽ���� 
	
	public Pattern(char[] pattern,int plen) {
		this.pattern = pattern;
		this.plen = plen;
	}
	
	public boolean match(char[] text,int tlen) {//�ı���������
		matched = false;
		rmatch(0,0,text,tlen);
		return matched;
	}
	
	/*
	 * ��������ǰ
	 * 
	 * */
	private void rmatch(int ti,int pj,char[] text,int tlen) {
		if(matched) return; //����Ѿ�ƥ���ˣ��Ͳ�Ҫ�����ݹ���
		if(pj == plen) { //������ʽ�Ѿ�����β��
			if(ti == tlen)
				matched = true; //�ı���Ҳ����β��
			return;
		}//if(pj == plen)
		
		if(pattern[pj] == '*') {//* ƥ���������ַ�
			for(int k=0;k<=tlen-ti;++k)
				rmatch(ti+k, pj+1, text, tlen);
		}else if(pattern[pj] == '?') { //��ƥ��0����1���ַ�
			rmatch(ti, pj+1, text, tlen);
			rmatch(ti+1, pj+1, text, tlen);
		}else if(ti<tlen && pattern[pj] == text[ti]) { //���ַ�ƥ�����
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
