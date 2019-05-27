package backAlgorithm;

public class Test {
	private static int[] result = new int[8]; //�±��ʾ�У�ֵ��ʾ�ʺ������һ��
	private static int numAns = 0; //ͳ�ưڷŵķ�����
	
	public static void cal8queens(int row) { //���÷�ʽ��cal8queens(0);
		if(row == 8) { //8�����Ӷ����ú��ˣ���ӡ���
			printQueens(result);
			numAns++;
			return; //
		}
		
		for(int column=0;column<8;++column) { //Ϊ��ǰ�еĻʺ�Ѱ�Ұڷ�λ��
			if(isOk(row,column)) { //��row�Ļʺ���ڵ�column�Ƿ����
				result[row]=column; //
				cal8queens(row+1); //row�еĻʺ�ź�֮�󣬷ŵ�row+1�еĻʺ�
			}
		}//for	
	}//cal8queens
	
	/*
	 * �ж�row�еĻʺ����row��column���Ƿ���ʣ�
	 * ����Ҫ���죺����������column�е��Ϸ������Ƿ��Ѿ����˻ʺ�column���ڵ�����б�ߵ��Ϸ����֣��ʺ�������·ţ�
	 * �Ƿ��Ѿ����˻ʺ�
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



























