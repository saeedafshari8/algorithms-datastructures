package algorithms.datastructure.primitive.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromeTest {

    @ParameterizedTest
    @CsvSource({
            "\"sss\", true",
            "\"ssss\", true",
            "\"carrac\", true",
            "\"scarrac\", true",
            "\"scarract\", false"
    })
    void isPalindromeByRemovingAtMostOneChar(String input, boolean expected) {
        boolean actual = new Palindrome().isPalindromeByRemovingAtMostOneChar(input);

        assertEquals(expected, actual);
    }
}
