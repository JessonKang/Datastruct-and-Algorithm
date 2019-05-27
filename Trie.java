class TrieNode{
	public char data;
	public TrieNode[] children = new TrieNode[26];
	public boolean isEndingChar = false;
	public TrieNode(char data) {
		this.data = data;
	}
}

public class Trie {
	private static TrieNode root = new TrieNode('/'); //�洢���ڵ㣬�������ַ�
	
	//��Trie���в���һ���ַ���
	public static void insert(String Stext) {
		char[] text = Stext.toCharArray();
		TrieNode p = root;
		for(int i=0;i<text.length;++i) {
			int index = text[i]-'a';
			if(p.children[index] == null) { //���ַ���������
				TrieNode newNode = new TrieNode(text[i]);
				p.children[index] = newNode; //���ýڵ���Ϊp���ӽڵ�
			}
			p = p.children[index];
		}
		p.isEndingChar = true; //text������ߵ�Ҷ�ӽ�㣨�洢���ˣ���
	}
	
	//��Trie���ϲ���һ���ַ���
	public static boolean find(String Spattern) {
		char[] pattern = Spattern.toCharArray();
		TrieNode p = root; //��pָ���ֵ����ĸ��ڵ�
		for(int i=0;i<pattern.length;++i) {
			int index = pattern[i] - 'a';
			if(p.children[index] == null) {
				return false; //������pattern
			}
			p = p.children[index];
		}
		if(p.isEndingChar == false)
			return false; //������ȫƥ�䣬pattern���ֵ����еĴ���˵ֻ��һ��ǰ׺
		else
			return true; //�ҵ���pattern
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
	
	//main����������
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



