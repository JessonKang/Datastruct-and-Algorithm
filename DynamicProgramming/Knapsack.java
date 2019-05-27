package DynamicProgramming;

public class Knapsack {
	/*
	 * weight:��Ʒ������n����Ʒ������w�������ͳ�������
	 * states[i][j+weight[i]]=true����ʾ��i����Ʒ���ߺ�
	 * */
	public static int knapsack(int[] weight,int n,int w) {
		boolean[][] states = new boolean[n][w+1]; //Ĭ��ֵΪfalse
		
		////��ʼ��,��i(��0��ʼ)����Ʒװ�벻װ������״̬
		states[0][0] = true; 
		states[0][weight[0]] = true;
		
		for(int i=1;i<n;++i) {//��̬�滮״̬ת��
			for(int j=0;j<=w;++j) {//���ѵ�i����Ʒ���뱳��
				if(states[i-1][j]==true)
					states[i][j]=states[i-1][j];
			}
			
			//����j���ж����������Ǻ����
			for(int j=0;j<=w-weight[i];++j) {//�ѵ�i����Ʒ���뱳��
				if(states[i-1][j]==true)
					states[i][j+weight[i]] = true;
			}
		}//for(int i=1...
		for(int i=w;i>=0;--i) {//������
			if(states[n-1][i]==true)
				return i;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int[] weight = new int[] {2,2,4,6,3};
		int w = 9;
		int n = 5;
		
		int maxWeight = knapsack(weight,n,w);
		System.out.println("maxWeight:"+maxWeight);
	}
	
	
}





