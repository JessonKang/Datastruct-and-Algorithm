package Heap;

public class Heap {
	public int[] a;//���飬���±�1��ʼ�洢����
	private int n; //�ѿ��Դ洢��������ݸ���
	private int count; //�����Ѿ��洢�����ݸ���
	
	//��ʼ����
	public Heap(int capacity) {
		a = new int[capacity+1];
		n = capacity;
		count = 0;
	}
	
	//�����в������ݣ����¶��϶ѻ�
	public void insert(int data) {
		if(count >= n)
			return ; //����
		++count;
		a[count] = data;
		int i = count; //��ǰ��������
		while(i/2>0 && a[i]>a[i/2]) { //���¶��Ͻ��жѻ�,�󶥶�
			swap(a,i,i/2);
			i = i/2; //��������
		}	
		
	}
	
	public void removeMax() {
		if(count == 0) return ; //����û������
		a[1] = a[count]; //
		--count;
		heapify(a,count,1); //���±�Ϊ1��ʼ���жѻ�
	}
	
	//�Ա���������a�У�Ԫ�ظ���Ϊn�Ķ����������±�Ϊi��Ԫ�ؿ�ʼ ���϶��½��жѻ�
	private void heapify(int[] a,int n,int i) {
		while(true) {
			int maxPos = i; //���浱ǰ��㼰�������ӽڵ���ֵ�������±�
			
			if(2*i<=n && a[i]<a[2*i])
				maxPos = 2*i; //i���������ӽڵ㣬��ֵС�����ӽڵ�
			if(2*i+1 <= n && a[maxPos] < a[2*i+1])
				maxPos = 2*i+1; //i���������ӽ�㣬�����ӽ���ֵ�������ӽڵ�
			
			if(maxPos == i)
				break;
			swap(a,i,maxPos);
			i = maxPos; //�������¶ѻ�
		}
		
	}
	
//---------------------------������------------------------------------------	
	/*
	 ���ѣ���n/2 -- 1�����������Ͻ��жѻ���һֱ��i=1Ϊֹ��
	 */
	private void buildHeap(int[] a,int n) {
		for(int i=n/2;i>=1;--i) { //n/2Ϊ�ѵ����һ����Ҷ�ӽ��
			heapify(a,n,i);
		}
	}
	
	//n ��ʾ���ݵĸ���������a�е����ݴ��±�1 �� n ��λ�á�
	public void sort(int[] a,int n) {
		buildHeap(a,n);
		int k=n; 
		while(k>1) {
			swap(a,1,k); //���±�Ϊk��Ԫ�����һ�����н������򽻻����k��Ԫ��Ϊ��ǰ��������ֵ����Сֵ
			--k; //���д������Ԫ�ؼ� 1
			heapify(a,k,1); //��ʱ1������ǽ������Ԫ�أ������ƻ��˶ѵĽṹ����Ҫ���жѻ�
		}
	}
	
	
	//���������е�����Ԫ��
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
