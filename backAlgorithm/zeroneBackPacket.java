package backAlgorithm;

/*
 * 0-1背包问题，有一个背包的总承重是w kg,现在有n个物品，每个物品重量不等，不可分割。
 * 现在期望选择几件物品，装载到背包中，在不超过背包所能装载重量的前提下，如何让背包中物品
 * 的总重量最大？
 * 
 * */
public class zeroneBackPacket {
	private static int maxW = Integer.MIN_VALUE; //保存能放入的最大重量
	
	/*cw 表示当前已经装进去的物品的重量和；i 表示考察到了哪个物品了；
	 * w 背包重量；items 表示每个物品的重量； n 表示物品个数
	 * 假设背包可承受重量100，物品个数 10，物品重量存储在数组 a 中，那可以这样调用函数：
	 * f(0,0,a,10,100)
	 * 
	 *
	 *注意用回溯算法处理背包问题实则是考虑了所有的2^n种情况：
	 * 	把物品一次排列，整个问题就分解为了n个阶段，每个阶段对应一个物品怎么选择，先对第一个物品进行处理，
	 * 选择装进去或不装进去，然后再递归地处理剩下的物品。
	 * 
	 * 流程：
	 * 第1个不放，2个不放，...，第n-1个不放，第n个不放。
	 * 第1个不放，2个不放，...，第n-1个不放，第n个放。
	 * 第1个不放，2个不放，...，第n-1个放，第n个不放。
	 * ...
	 * 依此类推
	 * 
	 * */
	public static void f(int i,int cw,int[] items,int n,int w) {
		if(cw == w || i==n) { //cw==w 表示装满了；i==n 表示已经考察完所有的物品，因为下标从i=0开始
			if(cw > maxW)
				maxW = cw;
			return ;
		}
		
		/*
		 * 下面是对第i个物品的两种处理情况：不放入背包，和放入背包
		 * */
		f(i+1, cw, items, n, w); //第i个物品不放入背包，直接处理第i+1个物品
		if(cw+items[i]<=w) { //在加上第i物品后不超过背包总承重的前提下，放入物品i
			f(i+1, cw+items[i], items, n, w);//处理第i+1个物品
		}
	}
	
	public static void main(String[] args) {
		int[] items = new int[] {1,9,5,90,3,4,8,25,8,6};
		f(0, 0, items, 10, 100);
		System.out.println(maxW);
	}
	
}
