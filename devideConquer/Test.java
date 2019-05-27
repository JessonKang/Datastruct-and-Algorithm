package devideConquer;

public class Test {
	private static int num=0;
	
	public static void mergeCounting(int[] arr,int n) {
		mergeSort(arr,0,n-1);
	}
	
	public static void mergeSort(int[] arr,int f,int r) {
		if(f>=r)
			return ;
		else {
			int p = (f+r)/2;
			mergeSort(arr, f, p);
			mergeSort(arr, p+1, r);
			merge(arr,f,p,r);
		}
	}
	
	public static void merge(int[] arr,int f,int p,int r) {
		int i=f,j=p+1;
		int[] tmp = new int[r-f+1];
		int k=0;
		while(i<=p && j<=r) {
			if(arr[i]<=arr[j])
				tmp[k++]=arr[i++];
			else {
				num+=p-i+1;
				tmp[k++]=arr[j++];
			}
		}//while
		
		while(i<=p) {
			tmp[k++] = arr[i++];
		}
		while(j<=r) {
			tmp[k++] = arr[j++];
		}
		
		//
		for(i=f,k=0;i<=r;i++,k++) {
			arr[i]=tmp[k];
		}
	}
	
	
	public static void main(String[] args) {
		int[] arr = new int[] {3,2,-10,11,28,9,8,4,3,5};
		mergeCounting(arr, arr.length);
		System.out.println("num: "+num);
		
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}
}












