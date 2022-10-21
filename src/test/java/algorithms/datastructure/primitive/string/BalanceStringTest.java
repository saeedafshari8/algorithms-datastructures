package algorithms.datastructure.primitive.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BalanceStringTest {

    @ParameterizedTest
    @CsvSource({
            "\"()()(\", \"()()\"",
            "\"((((((\", \"\"",
            "\"))))))\", \"\"",
            "\"\", \"\""
    })
    void getBalancedString(String source, String expected) {
        String actual = new BalanceString().getBalancedString(source);

        assertEquals(expected, actual);
    }
}
