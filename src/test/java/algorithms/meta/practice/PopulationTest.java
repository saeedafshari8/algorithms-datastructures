package algorithms.meta.practice;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PopulationTest {

    @Test
    void returnsMinusOneWhenTheInputIsEmpty() {
        List<Population.Person> people = Collections.emptyList();

        int actual = new Population().getTheYearWithHighestPopulation(people);

        assertEquals(-1, actual);
    }

    @Test
    void returnsTheCorrectYear() {
        List<Population.Person> people = List.of(
                new Population.Person(1980, 2050),
                new Population.Person(1990, 1991),
                new Population.Person(1970, 2010),
                new Population.Person(1970, 2040),
                new Population.Person(1970, 2025)
        );

        int actual = new Population().getTheYearWithHighestPopulation(people);

        assertEquals(1990, actual);
    }
}
