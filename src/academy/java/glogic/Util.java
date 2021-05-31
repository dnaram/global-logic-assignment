package academy.java.glogic;

public class Util {

    private static final String SPECIAL_CHARS_REGEX = "[\\\\!\"#$%&'()*+,\\-./:;<=>?@\\[\\]^_`{|}~]+";

    private Util() {}

    public static String removeSpecialChars(String input) {
       return input.replaceAll(SPECIAL_CHARS_REGEX, "");
    }
}
