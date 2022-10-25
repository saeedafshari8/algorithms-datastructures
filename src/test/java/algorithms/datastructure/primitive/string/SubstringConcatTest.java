package algorithms.datastructure.primitive.string;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubstringConcatTest {

    @Test
    void findSubstringReturnsCorrectList() {
        var substringConcat = new SubstringConcat();

        List<Integer> actual = substringConcat.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"});

        String actualStr = actual.stream().map(String::valueOf).collect(Collectors.joining(","));
        assertEquals("12,9,6", actualStr);
    }

    @Test
    void findSubstringReturnsCorrectList2() {
        var substringConcat = new SubstringConcat();

        List<Integer> actual = substringConcat.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"});

        String actualStr = actual.stream().map(String::valueOf).collect(Collectors.joining(","));
        assertEquals("", actualStr);
    }
}
