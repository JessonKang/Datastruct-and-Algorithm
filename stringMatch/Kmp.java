package stringMatch;

public class Kmp {
	//kmp���㷨
	public static int KMP(String ts,String ps) {
		char[] t= ts.toCharArray();
		char[] p = ps.toCharArray();
		
		int i=0; //������λ��
		int j= 0; //ģʽ����λ��
		
		int[] next = getNext(ps);
		while(i<t.length && j<p.length) {
			if(j==-1 || t[i] == p[j]) {//��jΪ-1ʱ��Ҫ�ƶ�i��jҲҪ��0
				i++;
				j++;
			}else {
				//i����Ҫ����
				j = next[j]; //j�ص�ָ��λ��
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
		 *  next[j]=k ��ʾ���±�Ϊi�����ݲ�ƥ��ʱ��jӦ��ָ�����һ��λ����k,��k=-1ʱҪ���⴦��
		 *  ��jָ��kʱ��Ӧ��ע���ʱp[0 ~ k-1]����Ӵ��Ǻ�������ƥ��ģ���˴�ʱ����p[k]����ַ�ȥ�Ƚ�
		 * */
		
		while(j<p.length-1) { //ע���������p[j++],��jѭ���ķ�Χ�� [0 ~ m-1]
			if(k==-1 || p[j]==p[k]) {
				/*ע���ʱ��j��k�����Ӧ��
				*��1��k==-1,��ʱ�Ǳ߽�����(�Ҵ�ʱ��j=0)��������j++,k++���õ�j=1,k=0,��ʾ���p[1]ʧ�䣬��ôj��ָ��k������һ�������Ƚϵľ����±�Ϊ0���ַ�
				*��2��p[j]==p[k]����Ҫ�����������ʱ��jҪָ��k���� p[0 ~ k-1] �� p[0 ~ j-1] �������ǰ��׺�Ӵ�������ʱp[j]==p[k]��
				*�� p[0 ~ k] �� p[0 ~ j] �������ǰ��׺�Ӵ�������next[j+1] = next[j](��k)+1;
				*/
				
				j++;
				k++;
				if(p[j] == p[k])
					next[j] = next[k];
				else
					next[j] = k;
				//�����if�ж��Ƕԣ�next[j] = k �����Ż���
				/*ע���ʱ��j��j++�Ժ��j
				ԭ�򣬼����ͣ�https://www.cnblogs.com/yjiyjige/p/3263858.html 
				*/			
			}else {
				/*(3)��p[j] != p[k],ͬ������next[j]=k ֪ p[0 ~ k-1]  �� p[0 ~ j-1] �������ǰ��׺�Ӵ������Ǵ�ʱ p[j] != p[k],���ʱ p[0 ~ k] �������� p[0 ~ j]��
				 * �����ǰ��׺�Ӵ�����Ϊp[j] != p[k]�����Ǵ�ʱ��ҪΪp[j+1]�������ǰ��׺�Ӵ����������ʱ�����Ҫ����k,�� k = next[k],
				 * 
				 * */
				k = next[k];
			}
		}
		
		/*while(j<p.length - 1) {
			if(k==-1 || p[j] == p[k]) {
				if(p[++j] == p[++k]) { //�������ַ����ʱҪ����
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






















