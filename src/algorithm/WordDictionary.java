package algorithm;

class WordNode{
	public WordNode[] children  = new WordNode[26];
	public String item = "";
}


public class WordDictionary {
	
	private WordNode root ;
	
	/** Initialize your data structure here. */
    public WordDictionary() {
        root =  new WordNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        WordNode node = root;
        for(int i = 0; i< word.length();i++){
        		char c = word.charAt(i);
        		if(node.children[c-'a'] == null){
        			node.children[c-'a'] = new WordNode();
        		}
        		node = node.children[c-'a'];
        }
        node.item = word;
    }
    
    private boolean searchPrefix(char[] chs, int k, WordNode node){
    		if(k == chs.length ) return !node.item.equals("");
    		if(chs[k] != '.'){
    			return node.children[chs[k]-'a'] != null && searchPrefix(chs, k+1, node.children[chs[k]-'a']);
    		}
    		else{
    			for(int i = 0; i< node.children.length; i++){
    				if(node.children[i] != null){
    					if(searchPrefix(chs,k+1,node.children[i]))
    						return true;
    				}
    			}
    			return false;
    		}
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchPrefix(word.toCharArray(), 0, root);
    }
}
