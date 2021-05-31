package academy.java.glogic;

import java.util.Objects;

public class CharPosition implements Comparable<CharPosition> {

    private Character character;
    private Integer positionInWord;

    public CharPosition(Character character, Integer positionInWord) {
        this.character = character;
        this.positionInWord = positionInWord;
    }

    public Character getCharacter() {
        return character;
    }

    public Integer getPositionInWord() {
        return positionInWord;
    }

    @Override
    public int compareTo(CharPosition o) {
        return this.positionInWord - o.getPositionInWord();
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharPosition that = (CharPosition) o;
        return Objects.equals(character, that.character) && Objects.equals(positionInWord, that.positionInWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(character, positionInWord);
    }
}
