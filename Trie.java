package com.company;

//Description: find the longest common prefix
import java.util.HashMap;

public class Trie {
    private Node root = new Node(' ');

    private class Node {
        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
        private boolean isEndOfWord;

        private Node(char value) {
            this.value = value;
        }

        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

    }

    public void insert(String word) {
        Node current = root;
        for (char ch : word.toCharArray()) {
            if (!current.hasChild(ch)) {
                current.addChild(ch);
            }
            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public static String longestCommonPrefix(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        StringBuffer prefix = new StringBuffer();
        Node current = trie.root;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                if (!current.isEndOfWord && current.hasChild(c) && current.children.size() == 1) {
                    prefix.append(c);
                    current = current.getChild(c);
                }
                else {
                    return prefix.toString();
                }
            }
        }
        return String.valueOf(trie);
    }

    public static void main(String[] args) {
        String[] array = {"cat", "car", "cape"};
        System.out.println(longestCommonPrefix(array));
        String[] array1 = {"piano", "pianist"};
        System.out.println(longestCommonPrefix(array1));
        String[] array2 = {"tread", "treadmill"};
        System.out.println(longestCommonPrefix(array2));
        String[] array3 = {"cat", "horse"};
        System.out.println(longestCommonPrefix(array3));
    }
}
