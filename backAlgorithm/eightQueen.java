package backAlgorithm;

/*
 * �����㷨ʵ��8�ʺ����⣬������еİڷ����
 * ע�⣺��������һ��ʹ�õݹ���ʵ�֣���Ȼ�ǵݹ飬��ô��һ������ֹ����������ȷ���ݹ����ֹ�����ǹؼ���
 * 
 * */
public class eightQueen {
	private static int[] result = new int[8]; //�±��ʾ�У�ֵ��ʾqueen�洢����һ��
	private static int numAns = 0; //ͳ�ƽ�ĸ���
	
	public static void cal8queens(int row) { //���÷�ʽ��cal8queens(0);
		if(row==8) {// 8�����Ӷ����ú��ˣ���ӡ���
			printQueens(result);
			numAns++;
			return ; //8�����Ӷ����ú���,û�������µݹ��ˣ�return
		}
		
		for(int column = 0;column <8;++column) {//ÿһ�еĻʺ���8�зŷ�
			if(isOk(row,column)) {//��Щ����������Ҫ��
				result[row] = column; //��row�еĻʺ�ŵ���column��
				cal8queens(row+1); //������һ��
			}
		}//for
	}
	
	/*
	 * �ж�row�еĻʺ����row��column���Ƿ���ʣ�
	 * ����Ҫ���죺����������column�е��Ϸ������Ƿ��Ѿ����˻ʺ�column���ڵ�����б�ߵ��Ϸ����֣��ʺ�������·ţ�
	 * �Ƿ��Ѿ����˻ʺ�
	 * 
	 * */
	private static boolean isOk(int row,int column) {
		int leftup = column-1,rightup=column+1;
		for(int i=row-1;i>=0;--i) { //�������Ͽ���ÿһ��
			if(result[i] == column) //��i�е�column����������
				return false; ;
			if(leftup >=0) { //�������϶Խ��ߣ�
				if(result[i] == leftup) //��i��leftup����������
					return false;
			}
			if(result[i] < 8) {//�������϶Խ��ߣ�
				if(result[i] == rightup) //��i��rightup����������
					return false;
			}
			--leftup;++rightup;
		}//for
		return true;
	}
	
	private static void printQueens(int[] result) {//��ӡ��һ����ά����
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











