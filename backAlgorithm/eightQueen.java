package backAlgorithm;

/*
 * 回溯算法实现8皇后问题，求出所有的摆放情况
 * 注意：回溯问题一般使用递归来实现，既然是递归，那么久一定有终止条件，所以确定递归的终止条件是关键。
 * 
 * */
public class eightQueen {
	private static int[] result = new int[8]; //下标表示行，值表示queen存储在哪一列
	private static int numAns = 0; //统计解的个数
	
	public static void cal8queens(int row) { //调用方式：cal8queens(0);
		if(row==8) {// 8个棋子都放置好了，打印结果
			printQueens(result);
			numAns++;
			return ; //8个棋子都放置好了,没法再往下递归了，return
		}
		
		for(int column = 0;column <8;++column) {//每一行的皇后都有8中放法
			if(isOk(row,column)) {//有些方法不满足要求
				result[row] = column; //第row行的皇后放到了column列
				cal8queens(row+1); //考察下一行
			}
		}//for
	}
	
	/*
	 * 判断row行的皇后放在row的column列是否合适；
	 * 则需要考察：整个矩阵中column列的上方部分是否已经放了皇后，column所在的两条斜线的上方部分（皇后从上往下放）
	 * 是否已经放了皇后
	 * 
	 * */
	private static boolean isOk(int row,int column) {
		int leftup = column-1,rightup=column+1;
		for(int i=row-1;i>=0;--i) { //逐行往上考察每一行
			if(result[i] == column) //第i行的column列有棋子吗？
				return false; ;
			if(leftup >=0) { //考察左上对角线：
				if(result[i] == leftup) //第i行leftup列有棋子吗？
					return false;
			}
			if(result[i] < 8) {//考察右上对角线：
				if(result[i] == rightup) //第i行rightup列有棋子吗？
					return false;
			}
			--leftup;++rightup;
		}//for
		return true;
	}
	
	private static void printQueens(int[] result) {//打印出一个二维矩阵
		for(int row=0;row<8;++row) {
			for(int column=0;column<8;++column) {
				if(result[row] == column)
					System.out.print("Q ");
				else {
					System.out.print("* ");
				}
			}//for(int column...
			System.out.println();
		}//for(int row...
		System.out.println();
	}
	
	public static void main(String[] args) {
		cal8queens(0);
		System.out.println("The number of answers: "+numAns);
	}
	
}











