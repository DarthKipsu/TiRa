
package datastructures;

import java.util.Map;
import java.util.HashMap;

/**
 * Task: Implement a prefix tree (Trie) where you can add words and then autocomplete a prefix if
 * there is only one word that matches with it (returning the needed suffix).
 * @author kipsu
 */
public class Trie {
    private final TrieNode head;

    public Trie() {
        head = new TrieNode(null);
    }

    public void addWord(String word) {
        head.addWord(word);
    }

    public String autocomplete(String prefix) {
        return head.findSingleSuffix(prefix, head);
    }

    private class TrieNode {
        Character value;
        Map<Character, TrieNode> children;

        public TrieNode(Character c) {
            value = c;
            children = new HashMap<>();
        }

        public void addWord(String word) {
            addWord(word.toCharArray(), 0);
        }

        public void addWord(char[] word, int i) {
            if (!children.containsKey(word[i])) {
                children.put(word[i], new TrieNode(word[i]));
            }
            if (i + 1 < word.length) {
                children.get(word[i]).addWord(word, ++i);
            }
        }

        public String findSingleSuffix(String prefix, TrieNode node) {
            for (int i = 0; i < prefix.length(); i++) {
                char currentChar = prefix.charAt(i);
                if (node.hasChild(currentChar)) {
                    node = node.children.get(currentChar);
                } else {
                    return null;
                }
            }
            if (node.hasMoreThanOneChildren()) {
                return null;
            }
            return suffix(node);
        }

        private boolean hasChild(char c) {
            return children.containsKey(c);
        }

        private boolean hasChild() {
            return children.keySet().size() > 0;
        }

        private boolean hasMoreThanOneChildren() {
            return children.keySet().size() > 1;
        }

        private TrieNode onlyChild() {
            for (char c : children.keySet()) {
                return children.get(c);
            }
            return null;
        }
        
        private String suffix(TrieNode node) {
            String suffix = "";
            while (node.hasChild()) {
                node = node.onlyChild();
                suffix += node.value;
            }
            return suffix;
        }
    }
    
    // Test it
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addWord("kaunis");
        trie.addWord("karhu");
        trie.addWord("kauris");
        trie.addWord("kaniini");
        trie.addWord("gaselli");
        
        System.out.println(trie.autocomplete("kau"));
        System.out.println(trie.autocomplete("kan"));
        System.out.println(trie.autocomplete("g"));
        System.out.println(trie.autocomplete("h"));
    }
}
