package backAlgorithm;

public class Test {
	private static int[] result = new int[8]; //下标表示行，值表示皇后放在哪一列
	private static int numAns = 0; //统计摆放的方案数
	
	public static void cal8queens(int row) { //调用方式：cal8queens(0);
		if(row == 8) { //8个棋子都放置好了，打印结果
			printQueens(result);
			numAns++;
			return; //
		}
		
		for(int column=0;column<8;++column) { //为当前行的皇后寻找摆放位置
			if(isOk(row,column)) { //第row的皇后放在第column是否合适
				result[row]=column; //
				cal8queens(row+1); //row行的皇后放好之后，放第row+1行的皇后
			}
		}//for	
	}//cal8queens
	
	/*
	 * 判断row行的皇后放在row的column列是否合适；
	 * 则需要考察：整个矩阵中column列的上方部分是否已经放了皇后，column所在的两条斜线的上方部分（皇后从上往下放）
	 * 是否已经放了皇后
	 * 
	 * */
	private static boolean isOk(int row,int column) {
		int leftup = column-1,rightup=column+1;
		for(int i=row-1;i>=0;--i) {
			if(result[i]==column)
				return false;
			if(leftup >=0) {
				if(result[i] == leftup)
					return false;
			}
			if(result[i]<8) {
				if(result[i] == rightup)
					return false;
			}
			--leftup;++rightup;
		}//for
		return true;
	}
	
	private static void printQueens(int[] result) {
		for(int i=0;i<result.length;++i) {
			for(int j=0;j<result.length;++j) {
				if(result[i]==j)
					System.out.print("Q ");
				else {
					System.out.print("* ");
				}
			}//for(int j=0...
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		cal8queens(0);
		System.out.println("num: "+numAns);
	}
}



























