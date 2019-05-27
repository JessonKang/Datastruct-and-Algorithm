package devideConquer;

/*
 * ���ù鲢˼�������������е������
 * 
 * */

public class CountAdversePair {
	private static int num = 0; //ȫ�ֱ������߳�Ա����
	
	//ʹ�ù鲢�����˼����������
	public static int count(int[] a,int n) {
		num = 0;
		mergeSortCounting(a,0,n-1);
		return num;
	}
	
	private static void mergeSortCounting(int[] a,int p,int r) {
		if(p>=r)
			return;
		int q = (p+r)/2;
		mergeSortCounting(a, p, q);
		mergeSortCounting(a, q+1, r);
		merge(a,p,q,r);
	}
	
	private static void merge(int[] a,int p,int q,int r) {
		int i = p, j = q+1, k = 0;
		int[] tmp = new int[r-p+1]; //��űȽϽ������ʱ����
		while(i<=q && j<=r) {
			if(a[i] <= a[j]) {
				tmp[k++] = a[i++];
			}else {
				num += (q-i+1); //ͳ�� p-q ֮�䣬��a[j]���Ԫ�ظ���
				/*
				 * ��   a[p.....q] = 2,3,5,8,10
				 *	a[q+1...r] = 4,4,5,6,9,11
				 *
				 *i��ʼΪp����iָ��5ʱ��if(a[i]<=a[j])�ж�Ϊfalse����ʱjָ��4����ת��else���
				 *���������ֵ�����������ģ���֪a[i]>a[j],��a[i]��i(����5,8,10)����ģ�q-i+1��������ֵ������a[j](4)
				 *���ɣ�������е�һ��������ԡ�
				 * */

				tmp[k++] = a[j++];
			}
		}//while
		
		while(i<=q) {// ����ʣ�µ�
			tmp[k++] = a[i++];
		}
		while(j<=r) {
			tmp[k++] = a[j++];
		}
		
		for(i=0;i<=r-p;++i) { //��tmp������a
			a[p+i] = tmp[i];
		}
	
	}//merge
	
	public static void main(String[] args) {
		int[] nums = new int[] {5,3,1,2,10,2,8,7,9};
		int adverseNum = count(nums, nums.length);
		System.out.println("The number of adverse pair are: "+adverseNum);
	}
}
















