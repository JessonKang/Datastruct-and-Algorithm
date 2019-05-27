package Heap;

public class HeapSort {
	
	//从最后一个非叶子结点开始从下往上进行堆化
	public static void buildHeap(int[] a,int n) {
		for(int i=n/2;i>=1;--i) {
			heapify(a,n,i);
		}
	}
	
	//堆排序
	public static void sort(int[] a,int n) {
		buildHeap(a,n);
		
		int k = n;
		while(k > 1) {
			swap(a,1,k);
			--k;
			heapify(a,k,1);
		}
	}
	
	//对元素个数为n的数组a，从第i个位置开始从上往下进行堆化
	public static  void heapify(int[] a,int n,int i) {
		while(true) {
			int maxPos = i; //当前待处理结点
			if(2*i <=n && a[i] < a[2*i] ) maxPos = 2*i;
			if(2*i+1 <= n && a[2*i] < a[2*i+1]) maxPos = 2*i +1;/////////////////////////////
			
			if(maxPos == i) break;
			
			swap(a,i,maxPos);
			i = maxPos;
		}
	}//end heapify
	
	
	public static void swap(int[] a,int i,int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	} // end swap
	
	public static void main(String[] args) {
		int[] a = {0,34,2,4,5,-10,32,66,9};
		sort(a,8); //注意这里的第二个参数是存储在数组中的堆中元素的最大下标，
		           //是需要能访问到a[8]的，所以一定要注意越界问题
		
		for(int item:a)
			System.out.print(" " + item);
		
	}
	
}
