class TrieNode{
	public char data;
	public TrieNode[] children = new TrieNode[26];
	public boolean isEndingChar = false;
	public TrieNode(char data) {
		this.data = data;
	}
}

public class Trie {
	private static TrieNode root = new TrieNode('/'); //存储根节点，无意义字符
	
	//往Trie树中插入一个字符串
	public static void insert(String Stext) {
		char[] text = Stext.toCharArray();
		TrieNode p = root;
		for(int i=0;i<text.length;++i) {
			int index = text[i]-'a';
			if(p.children[index] == null) { //该字符还不存在
				TrieNode newNode = new TrieNode(text[i]);
				p.children[index] = newNode; //将该节点作为p的子节点
			}
			p = p.children[index];
		}
		p.isEndingChar = true; //text这个串走到叶子结点（存储完了）。
	}
	
	//在Trie树上查找一个字符串
	public static boolean find(String Spattern) {
		char[] pattern = Spattern.toCharArray();
		TrieNode p = root; //让p指向字典树的根节点
		for(int i=0;i<pattern.length;++i) {
			int index = pattern[i] - 'a';
			if(p.children[index] == null) {
				return false; //不存在pattern
			}
			p = p.children[index];
		}
		if(p.isEndingChar == false)
			return false; //不能完全匹配，pattern对字典树中的串来说只是一个前缀
		else
			return true; //找到了pattern
	}
	
	public static boolean isPrefix(String Sprefix) {
		char[] prefix = Sprefix.toCharArray();
		TrieNode p = root;
		for(int i=0;i<Sprefix.length();i++) {
			int index = prefix[i] - 'a';
			if(p.children[index] == null)
				return false;
			else
				p = p.children[index];
		}
		if(p.isEndingChar == true)
			return false;
		else
			return true;
		
	}
	
	//main函数，测试
	public static void main(String[] args) {
		insert("hello");
		insert("how");
		
		
		System.out.println("\"hello\" is here?  "+find("hello"));
		System.out.println("\"how\" is here?  "+find("how"));
		System.out.println("\"happy\" is here?  "+find("happy"));
		System.out.println("\"ha\" is a prefix?  "+isPrefix("ha"));
		System.out.println("\"he\" is a prefix?  "+isPrefix("he"));
	}
}



