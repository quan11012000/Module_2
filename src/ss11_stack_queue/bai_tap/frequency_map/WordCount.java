package ss11_stack_queue.bai_tap.frequency_map;
import common.StringMethod;
import java.util.TreeMap;
public class WordCount {
    public static void main(String[] args) {
        String input =  StringMethod.inputString();
        TreeMap<String, Integer> wordMap = new TreeMap<>();
        String[] words = input.trim().toLowerCase().split("\\s+");
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }
        System.out.println("\nSố lần xuất hiện của mỗi từ:");
        wordMap.forEach((word, count)-> {
            System.out.println(word + ": " + count);
        });
    }
}



