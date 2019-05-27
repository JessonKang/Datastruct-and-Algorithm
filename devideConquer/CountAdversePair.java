package devideConquer;

/*
 * 利用归并思想来计算数组中的逆序对
 * 
 * */

public class CountAdversePair {
	private static int num = 0; //全局变量或者成员变量
	
	//使用归并排序的思想计算逆序对
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
		int[] tmp = new int[r-p+1]; //存放比较结果的临时数组
		while(i<=q && j<=r) {
			if(a[i] <= a[j]) {
				tmp[k++] = a[i++];
			}else {
				num += (q-i+1); //统计 p-q 之间，比a[j]大的元素个数
				/*
				 * 如   a[p.....q] = 2,3,5,8,10
				 *	a[q+1...r] = 4,4,5,6,9,11
				 *
				 *i初始为p，当i指向5时，if(a[i]<=a[j])判断为false，此时j指向4，跳转到else这里，
				 *由于两部分的数都是有序的，已知a[i]>a[j],则a[i]及i(即：5,8,10)后面的（q-i+1）个数的值都大于a[j](4)
				 *即可，算的其中的一部分逆序对。
				 * */

				tmp[k++] = a[j++];
			}
		}//while
		
		while(i<=q) {// 处理剩下的
			tmp[k++] = a[i++];
		}
		while(j<=r) {
			tmp[k++] = a[j++];
		}
		
		for(i=0;i<=r-p;++i) { //从tmp拷贝回a
			a[p+i] = tmp[i];
		}
	
	}//merge
	
	public static void main(String[] args) {
		int[] nums = new int[] {5,3,1,2,10,2,8,7,9};
		int adverseNum = count(nums, nums.length);
		System.out.println("The number of adverse pair are: "+adverseNum);
	}
}
















