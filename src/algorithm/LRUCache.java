package algorithm;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	class DLinkedNode{
		int key;
		int value;
		DLinkedNode pre;
		DLinkedNode post;
	}
	
	//field
	private DLinkedNode head;
	private DLinkedNode tail;
	private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
	private int capacity;
	private int size;
	
	// conctructor
public LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.post = tail;
        tail.pre = head;
    }
    
// methods
private void addNode(DLinkedNode node){
	node.pre = head;
	node.post = head.post;
	
	head.post.pre = node;
	head.post = node;   // draw a graph can see this clearly
}

private void removeNode(DLinkedNode node){
	DLinkedNode pre = node.pre;
	DLinkedNode post = node.post;
	
	pre.post = post;
	post.pre = pre;
}

private void moveToHead(DLinkedNode node){
	removeNode(node);
	addNode(node);
}

private DLinkedNode popFromTail(){
	DLinkedNode node = tail.pre;
	removeNode(node);
	return node;
}
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        
        if(node == null){
        		// there does not exist
        		return -1;
        }
        else{
        		moveToHead(node);
        		return node.value;
        }
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        
        if(node == null){
        		// this is a new node
        		DLinkedNode newNode = new DLinkedNode();
        		newNode.key = key;
        		newNode.value = value;
        		
        		if(size < capacity){
        			addNode(newNode);
        			cache.put(key, newNode);
        			size++;
        		}
        		else{
        			
        			DLinkedNode lastItem = popFromTail();
        			cache.remove(lastItem.key);
        			addNode(newNode);
        			cache.put(key, newNode);
        		}
        }
        else{
        		DLinkedNode update = cache.get(key);
        		update.value = value;
        		moveToHead(update);
        }
    }
}
