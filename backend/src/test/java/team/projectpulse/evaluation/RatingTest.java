package team.projectpulse.evaluation;

import team.projectpulse.rubric.Criterion;
import io.micrometer.core.annotation.TimedSet;
import jakarta.persistence.*;

import org.junit.jupiter.api.Test;
import team.projectpulse.rubric.Criterion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RatingTest {
    @Test
    public void testSetActualScore() {
        Criterion criterion = new Criterion();
        criterion.setMaxScore(10.0);
        Rating rating = new Rating(criterion, 5.0);

        // Test valid score
        rating.setActualScore(7.0);
        assertEquals(7.0, rating.getActualScore());

        // Test score greater than max
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            rating.setActualScore(11.0);
        });
        assertEquals("Actual score must be between 0 and 10.0", exception.getMessage());

        // Test negative score
        exception = assertThrows(IllegalArgumentException.class, () -> {
            rating.setActualScore(-1.0);
        });
        assertEquals("Actual score must be between 0 and 10.0", exception.getMessage());
    }

}
//AI helped me write the import at the top of the file.
