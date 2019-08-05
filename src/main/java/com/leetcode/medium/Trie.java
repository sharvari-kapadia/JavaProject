package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by skapadia on 10/6/2016.
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class Trie {

    class TrieNode {

        Map<Character, TrieNode> childrenMap;
        boolean endOfWord;
        public TrieNode() {
            this.childrenMap = new HashMap<>();
            this.endOfWord = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {

        TrieNode current = root;
        TrieNode node;
        Map<Character, TrieNode> map;
        Character c;

        for(int i = 0; i < word.length(); i++) {

            c = word.charAt(i);
            map = current.childrenMap;
            if(!map.containsKey(c)) {
                node = new TrieNode();
                map.put(c, node);
            } else {
                node = map.get(c);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    public void insertRecursive(String word) {

        _insertRecursive(word, root, 0);
    }

    private void _insertRecursive(String word, TrieNode current, int index) {

        if(index == word.length()) {
            current.endOfWord = true;
            return;
        }

        Character c = word.charAt(index);
        Map<Character, TrieNode> map = current.childrenMap;
        TrieNode node;

        if(!map.containsKey(c)) {
            node = new TrieNode();
            map.put(c, node);
        } else {
            node = map.get(c);
        }
        current = node;
        _insertRecursive(word, current, index+1);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {

        Character c;
        TrieNode current = root;
        Map<Character, TrieNode> map;

        for(int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            map = current.childrenMap;
            if(!map.containsKey(c)) {
                return false;
            }
            current = map.get(c);
        }
        return current.endOfWord;
    }

    public boolean searchRecursive(String word) {
        return _searchRecursive(word, root, 0);
    }

    private boolean _searchRecursive(String word, TrieNode current, int index) {

        if(index == word.length()) {
            return current.endOfWord;
        }

        Character c = word.charAt(index);
        Map<Character, TrieNode> map = current.childrenMap;

        if(!map.containsKey(c)) {
            return false;
        }
        current = map.get(c);
        return _searchRecursive(word, current, index+1);

    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {

        Character c;
        TrieNode current = root;
        Map<Character, TrieNode> map;
        for(int i = 0; i < prefix.length(); i++) {
            c = prefix.charAt(i);
            map = current.childrenMap;
            if(!map.containsKey(c)) {
                return false;
            }
            current = map.get(c);
        }
        return true;
    }

    public void printWordsThatStartsWith(String prefix) {

        Character c;
        TrieNode current = root;
        Map<Character, TrieNode> map;
        for(int i = 0; i < prefix.length(); i++) {
            c = prefix.charAt(i);
            map = current.childrenMap;
            if(!map.containsKey(c)) {
                return;
            }
            current = map.get(c);
        }
        _printWordsThatStartWith(current, new StringBuilder(prefix));
    }

    private void _printWordsThatStartWith(TrieNode current, StringBuilder sb) {

        if(current.endOfWord) {
            System.out.println(sb);
        }
        Map<Character, TrieNode> map = current.childrenMap;
        for(Character c : map.keySet()) {
            sb.append(c);
            current = map.get(c);
            _printWordsThatStartWith(current, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abcd");
        trie.insert("abc");
        trie.insert("abcde");
        trie.insert("abgl");
        trie.insert("cdf");
        trie.insert("lmn");

        assert trie.search("lmn");
        assert !trie.search("ab");
        assert trie.search("cdf");
        assert !trie.search("ghi");

        assert trie.startsWith("ab");
        assert !trie.startsWith("lo");
        assert trie.startsWith("cd");
        assert trie.startsWith("lm");

        trie.printWordsThatStartsWith("ab");
        trie.printWordsThatStartsWith("cd");
    }
}
