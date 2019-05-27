package Heap;

public class Heap {
	public int[] a;//数组，从下标1开始存储数据
	private int n; //堆可以存储的最大数据个数
	private int count; //堆中已经存储的数据个数
	
	//初始化堆
	public Heap(int capacity) {
		a = new int[capacity+1];
		n = capacity;
		count = 0;
	}
	
	//往堆中插入数据，自下而上堆化
	public void insert(int data) {
		if(count >= n)
			return ; //满了
		++count;
		a[count] = data;
		int i = count; //当前待处理结点
		while(i/2>0 && a[i]>a[i/2]) { //自下而上进行堆化,大顶堆
			swap(a,i,i/2);
			i = i/2; //待处理结点
		}	
		
	}
	
	public void removeMax() {
		if(count == 0) return ; //堆中没有数据
		a[1] = a[count]; //
		--count;
		heapify(a,count,1); //从下标为1开始进行堆化
	}
	
	//对保存在数组a中，元素个数为n的二叉树，从下标为i的元素开始 自上而下进行堆化
	private void heapify(int[] a,int n,int i) {
		while(true) {
			int maxPos = i; //保存当前结点及其左右子节点中值最大结点的下标
			
			if(2*i<=n && a[i]<a[2*i])
				maxPos = 2*i; //i结点存在左子节点，且值小于左子节点
			if(2*i+1 <= n && a[maxPos] < a[2*i+1])
				maxPos = 2*i+1; //i结点存在右子结点，且右子结点的值大于左子节点
			
			if(maxPos == i)
				break;
			swap(a,i,maxPos);
			i = maxPos; //继续向下堆化
		}
		
	}
	
//---------------------------堆排序------------------------------------------	
	/*
	 建堆，从n/2 -- 1，即从下往上进行堆化，一直到i=1为止。
	 */
	private void buildHeap(int[] a,int n) {
		for(int i=n/2;i>=1;--i) { //n/2为堆的最后一个非叶子结点
			heapify(a,n,i);
		}
	}
	
	//n 表示数据的个数，数组a中的数据从下标1 到 n 的位置。
	public void sort(int[] a,int n) {
		buildHeap(a,n);
		int k=n; 
		while(k>1) {
			swap(a,1,k); //把下标为k的元素与第一个进行交换，则交换后第k个元素为当前堆里的最大值或最小值
			--k; //堆中待排序的元素减 1
			heapify(a,k,1); //此时1保存的是交换后的元素，可能破坏了堆的结构，需要进行堆化
		}
	}
	
	
	//交换数组中的两个元素
	public void swap(int[] arr,int i,int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	public static void main(String[] args) {
		/*Heap he = new Heap(10);
		for(int i=0;i<10;++i) {
			he.insert(i+1);
		}
		
		for(int item:he.a) {
			System.out.print(" "+item);
		}
		
		System.out.println();

		int[] arr1 = {3,1,0,-11,10,34,2,9,10,0};
		Heap he = new Heap(11);
		
		he.sort(arr1, 11);
		for(int item:arr1) {
			System.out.print(" "+item);
		}		*/
	}
}
