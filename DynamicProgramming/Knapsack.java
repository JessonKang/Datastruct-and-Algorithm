package DynamicProgramming;

public class Knapsack {
	/*
	 * weight:物品重量，n：物品个数，w：背包客承载重量
	 * states[i][j+weight[i]]=true：表示第i个物品决策后
	 * */
	public static int knapsack(int[] weight,int n,int w) {
		boolean[][] states = new boolean[n][w+1]; //默认值为false
		
		////初始化,第i(从0开始)个物品装与不装的两种状态
		states[0][0] = true; 
		states[0][weight[0]] = true;
		
		for(int i=1;i<n;++i) {//动态规划状态转移
			for(int j=0;j<=w;++j) {//不把第i个物品放入背包
				if(states[i-1][j]==true)
					states[i][j]=states[i-1][j];
			}
			
			//这里j的判断条件还不是很清楚
			for(int j=0;j<=w-weight[i];++j) {//把第i个物品放入背包
				if(states[i-1][j]==true)
					states[i][j+weight[i]] = true;
			}
		}//for(int i=1...
		for(int i=w;i>=0;--i) {//输出结果
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





