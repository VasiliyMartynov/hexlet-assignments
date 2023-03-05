package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;


class ReversedSequenceTest {

    @Test
    void reversedSequenceToString() {
        ReversedSequence s = new ReversedSequence("abcd");
        String actual = "dcba";
        assertThat(actual).isEqualTo(s.toString());
    }
    @Test
    void reversedSequenceCharAt() {
        ReversedSequence s = new ReversedSequence("abcd");
        char actual = 'c';
        assertThat(actual).isEqualTo(s.charAt(1));
    }
    @Test
    void reversedSequenceSubSequence() {
        ReversedSequence s = new ReversedSequence("abcd");
        String actual = "d";
        assertThat(actual).isEqualTo(s.subSequence(0,1));
    }
    @Test
    void reversedSequenceToStringNull() {
        ReversedSequence s = new ReversedSequence("");
        String actual = "";
        assertThat(actual).isEqualTo(s.toString());
    }
}
