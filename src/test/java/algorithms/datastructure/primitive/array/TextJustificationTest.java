package algorithms.datastructure.primitive.array;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextJustificationTest {

    @Test
    void fullJustifyReturnsCorrectList() {
        TextJustification textJustification = new TextJustification();
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};

        List<String> strings = textJustification.fullJustify(words, 16);

        String actual = String.join("|", strings);
        String expected = "This    is    an|example  of text|justification.  ";
        assertEquals(expected, actual);
    }

    @Test
    void fullJustifyReturnsCorrectList2() {
        TextJustification textJustification = new TextJustification();
        String[] words = new String[]{"What", "must", "be", "acknowledgment", "shall", "be"};

        List<String> strings = textJustification.fullJustify(words, 16);

        String actual = String.join("|", strings);
        String expected = "What   must   be|acknowledgment  |shall be        ";
        assertEquals(expected, actual);
    }

    @Test
    void fullJustifyReturnsCorrectList3() {
        TextJustification textJustification = new TextJustification();
        String[] words = new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};

        List<String> strings = textJustification.fullJustify(words, 20);

        String actual = String.join("|", strings);
        String expected = "Science  is  what we|understand well     |enough to explain to|a  computer.  Art is|everything  else  we|do                  ";
        assertEquals(expected, actual);
    }
}
