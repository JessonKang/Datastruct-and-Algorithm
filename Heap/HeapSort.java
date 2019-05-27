package Heap;

public class HeapSort {
	
	//�����һ����Ҷ�ӽ�㿪ʼ�������Ͻ��жѻ�
	public static void buildHeap(int[] a,int n) {
		for(int i=n/2;i>=1;--i) {
			heapify(a,n,i);
		}
	}
	
	//������
	public static void sort(int[] a,int n) {
		buildHeap(a,n);
		
		int k = n;
		while(k > 1) {
			swap(a,1,k);
			--k;
			heapify(a,k,1);
		}
	}
	
	//��Ԫ�ظ���Ϊn������a���ӵ�i��λ�ÿ�ʼ�������½��жѻ�
	public static  void heapify(int[] a,int n,int i) {
		while(true) {
			int maxPos = i; //��ǰ��������
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
		sort(a,8); //ע������ĵڶ��������Ǵ洢�������еĶ���Ԫ�ص�����±꣬
		           //����Ҫ�ܷ��ʵ�a[8]�ģ�����һ��Ҫע��Խ������
		
		for(int item:a)
			System.out.print(" " + item);
		
	}
	
}
