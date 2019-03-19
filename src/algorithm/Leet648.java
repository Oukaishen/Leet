package algorithm;

import java.util.HashMap;
import java.util.List;

public class Leet648 {
    public static void main(String [] args){
        Leet648 test = new Leet648();

    }

    public String replaceWords(List<String> dict, String sentence) {
        simpleTrie tree = new simpleTrie();
        for(String root : dict){
            tree.insert(root);
        }
        StringBuilder sb = new StringBuilder();
        for(String word: sentence.split(" ")){
            simpleTrieNode node = tree.root;
            simpleTrieNode nextNode = null;
            for (char c : word.toCharArray()){
               nextNode = node.links[c - 'a'];
               if(nextNode == null || nextNode.word != null) break;
               node = nextNode;
            }
            if( nextNode != null &&  nextNode.word != null){
                sb.append(nextNode.word + " ");
            }
            else{
                sb.append(word + " ");
            }
        }
        return sb.substring(0,sb.length() -1);
    }

    class simpleTrieNode{
        simpleTrieNode [] links;
        String word;

        simpleTrieNode(){
            links = new simpleTrieNode[26];
        }
    }

    class simpleTrie{
        simpleTrieNode root;
        simpleTrie(){
            root = new simpleTrieNode();
        }

        public void insert(String word){
            simpleTrieNode node = root;
            for(char c : word.toCharArray()){
                simpleTrieNode nextNode = node.links[c - 'a'];
                if(nextNode == null){
                    nextNode = new simpleTrieNode();
                    node.links[c - 'a'] = nextNode;
                }
                node = nextNode;
            }
            node.word = word;
        }

    }

}
