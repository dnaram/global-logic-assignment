package academy.java.glogic;

import java.util.*;
import java.util.Map.Entry;

public class InputParser {

    private HashMap<Character, Integer> keyChars;

    private int totalCharOccurrence;
    private HashMap<CharacterWordLengthCombo, Integer> charWordLenCombos;

    public InputParser(char[] keyChars) {
        this.keyChars = new HashMap<>();
        int position = 0;
        for (var c : keyChars) {
            this.keyChars.put(Character.toLowerCase(c), position++);
        }
        totalCharOccurrence = 0;
        charWordLenCombos = new HashMap<>();
    }

    public void parseInput(String input) {
        input = input.replaceAll("\\s+", " ").trim().toLowerCase();
        for (String word : input.split(" ")) {
            analyzeWord(word);
        }

        List<Entry<CharacterWordLengthCombo, Integer>> sortedCharWordLenCombos = new LinkedList<>(charWordLenCombos.entrySet());
        sortedCharWordLenCombos.sort(Entry.comparingByValue());

        for (var cwlc : sortedCharWordLenCombos) {
            System.out.println(cwlc.getKey() + " = " + String.format("%.2f", (double) cwlc.getValue() / totalCharOccurrence) + " (" + cwlc.getValue() + "/" + totalCharOccurrence + ")");
        }

        int totalCount = input.replaceAll("\\s+", "").length();
        System.out.println("TOTAL Frequency: " + String.format("%.2f", (double) totalCharOccurrence / totalCount) + " (" + totalCharOccurrence + "/" + totalCount + ")");

    }

    private void analyzeWord(String word) {
        HashSet<Character> foundChars = new HashSet<>();
        int occurred = 0;
        for (char c : word.toCharArray()) {
            if (keyChars.containsKey(c)) {
                foundChars.add(c);
                occurred++;
            }
        }

        if (foundChars.isEmpty()) {
            return;
        }

        totalCharOccurrence += occurred;

        int wordLength = word.length();

        List<CharPosition> charPositions = new ArrayList<>();
        for (var fc : foundChars) {
            charPositions.add(new CharPosition(fc, keyChars.get(fc)));
        }

        CharacterWordLengthCombo cwlc = new CharacterWordLengthCombo(charPositions, wordLength);
        Integer oc = charWordLenCombos.get(cwlc);
        if (oc == null) {
            charWordLenCombos.put(cwlc, occurred);
        } else {
            charWordLenCombos.put(cwlc, oc+occurred);
        }
    }
}
