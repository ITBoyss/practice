package data_structure.tree;

import data_structure.tree.trie.Trie;
import org.junit.Test;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ProjectName: algorithm
 * @Description: trie测试
 * @Author: WeiLingYun
 * @CreateDate: 2018/12/27 10:10
 * @Version: 1.0.0
 */
public class TrieTest {

    @Test
    public void test1() {
        char[] chars = new char[26];
        int j = 0;
        for (int i = 97; i <= 122; i++) {
            chars[j++] = (char) i;
        }
        Set<String> set = new TreeSet<String>();
        for (int d = 0; d < 10000000; d++) {
            StringBuilder sb = new StringBuilder();
            int bound = new Random().nextInt(26);
            for (int i = 0; i < bound; i++) {
                sb.append(chars[new Random().nextInt(26)]);
            }
            if (sb.toString() != null) {
                set.add(sb.toString());
            }
        }
        System.out.println(set.size());
        long start = System.nanoTime();
        Trie trie = new Trie();
        for (String word : set) {
            trie.add(word);
        }
        for (String word : set) {
            trie.contains(word);
        }
        long end = System.nanoTime();
        System.out.println((end - start) / 1000000000.0);
    }
}
