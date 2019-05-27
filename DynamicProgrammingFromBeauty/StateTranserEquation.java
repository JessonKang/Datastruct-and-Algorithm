package DynamicProgrammingFromBeauty;

public class StateTranserEquation {
	
	private int[][] matrix = {{1,3,5,9},{2,1,3,4},{5,2,6,7},{6,8,4,3}};
	private int n=4;
	private int[][] mem = new int[4][4]; //备忘子问题
	
	public int minDist(int i,int j) { //调用minDis(n-1,n-1)
		if(i==0 && j==0)
			return matrix[0][0];
		if(mem[i][j]>0) //mem中元素的值默认为0，大于0说明已经之前已经被计算过了
			return mem[i][j];
		
		int minLeft = Integer.MAX_VALUE;
		if(j-1>=0) { //计算到达matrix[i][j]位置的左边位置即matrix[i][j-1]的最小路径，即求解子问题
			minLeft = minDist(i,j-1);
		}
		int minUp = Integer.MAX_VALUE;
		if(i-1>=0) {
			minUp = minDist(i-1,j);
		}
		
		int currMinDist = matrix[i][j] + Math.min(minLeft, minUp);
		mem[i][j] = currMinDist;
		return currMinDist;
		
	}
	
	public static void main(String[] args) {
		StateTranserEquation st = new StateTranserEquation();
		int minDist = st.minDist(3, 3);
		System.out.println("minDist:"+minDist);
	}
}
