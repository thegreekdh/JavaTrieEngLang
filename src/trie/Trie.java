package trie;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Trie {
	
	private Node head;
	
	class Node {
		private char val;
		private HashMap<Character, Node> children;
		
		private Node(char val) {
			this.val = val;
			children = new HashMap<Character, Node>();
		}
		
		private void addChild(char val) {
			children.put(val, new Node(val));
		}
		
		private boolean hasChild(char val) {
			return children.containsKey(val);
		}
		
		private Node getChild(char val) {
			return children.get(val);
		}

	}
	
	
	// Use an iterator to be able to load from multiple sources
	public Trie(Iterator<String> it) {
		head = new Node('@');
		Node currNode = head;
		
		String temp;
		char c;
		
		while (it.hasNext()) {
			temp = it.next();
			
			for (int i = 0; i < temp.length(); i++) {
				c = temp.charAt(i);
				
				if (!currNode.hasChild(c))
					currNode.addChild(c);
				
				currNode = currNode.getChild(c);
			}
			
			currNode.addChild('*');
			currNode = head;
		}
		
	}
	
	private void findSubSets(Node n, String currWord, Set<String> mySet) {
		
		n.children.forEach((k, v) -> {
			if (k == '*') 
				mySet.add(currWord);
			else
				findSubSets(v, currWord + k, mySet);
		});
		
	}
	
	public Set<String> findAll(String prefix) {
		Set<String> mySet = new HashSet<String>();
		
		Node currNode = head;
		char c;
		
		// Traverse to final character of prefix
		for (int i = 0; i < prefix.length(); i++) {
			c = prefix.charAt(i);
			
			if (!currNode.hasChild(c))
				return Collections.emptySet();
			
			currNode = currNode.getChild(c);
		}
		
		findSubSets(currNode, prefix, mySet);
		
		return mySet;
		
	}
	
	public boolean existsWord(String word) {
		Node currNode = head;
		char c;
		
		for (int i = 0; i < word.length(); i++) {
			c = word.charAt(i);
			if (!currNode.hasChild(c))
				return false;
			
			currNode = currNode.getChild(c);
		}
			
		return currNode.hasChild('*');
	}
	
}
