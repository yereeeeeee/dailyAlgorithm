import java.io.*;
import java.util.*;

public class Main {
    private Trie dict = new Trie();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Main program = new Main();

        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            String[] wordList = new String[n];
            program.dict = new Trie(); // 새 Trie 생성

            for (int i = 0; i < n; i++) {
                String word = br.readLine();
                program.dict.insert(word);
                wordList[i] = word;
            }

            double res = 0;
            for (String word : wordList) {
                res += program.dict.calc(word);
            }
            System.out.println(String.format("%.2f", res / n));
        }
    }

    private static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                node = node.children.computeIfAbsent(word.charAt(i), c -> new TrieNode());
            }
            node.isEnd = true;
        }

        public int calc(String word) {
            TrieNode node = root;
            int cnt = 1;
            node = node.children.get(word.charAt(0));

            for (int i = 1; i < word.length(); i++) {
                if (node.children.size() >= 2) {
                    cnt++;
                } else if (node.children.size() == 1 && node.isEnd) {
                    cnt++;
                }
                node = node.children.get(word.charAt(i));
            }

            return cnt;
        }

        private static class TrieNode {
            Map<Character, TrieNode> children = new HashMap<>();
            boolean isEnd = false;
        }
    }
}
