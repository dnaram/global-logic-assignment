package academy.java.glogic;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CharacterWordLengthCombo implements Comparable<CharacterWordLengthCombo> {

    private List<CharPosition> characters;
    private int wordLength;
    private int frequency;

    public CharacterWordLengthCombo(List<CharPosition> characters, int wordLength) {
        this.characters = characters;
        this.wordLength = wordLength;
    }

    public List<CharPosition> getCharacters() {
        return characters;
    }

    public int getWordLength() {
        return wordLength;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append("{ (");
       Collections.sort(characters);
       for (var c : characters) {
           sb.append(c + (characters.indexOf(c) == characters.size()-1 ? ")" : ", "));
       }
       sb.append(", " + wordLength + "}");

       return sb.toString();
    }

    @Override
    public int compareTo(CharacterWordLengthCombo o) {
        return this.frequency - o.getFrequency();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterWordLengthCombo that = (CharacterWordLengthCombo) o;
        return wordLength == that.wordLength && Objects.equals(characters, that.characters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(characters, wordLength);
    }
}
