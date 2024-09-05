import org.example.Score;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScoreTest {

    @Test
    void whenInvalidInputShouldFail() {
        Score score = new Score();
        Throwable exception = assertThrows(RuntimeException.class, () -> score.updateScore("ABAC"));
        assertTrue(exception.getMessage().contains("is not participating in this match"));
    }
}
