package algorithms.meta.practice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// https://vimeo.com/580342398
public class Population {

    static class Person {
        private final int born;
        private final int death;

        Person(int born, int death) {
            this.born = born;
            this.death = death;
        }
    }

    public int getTheYearWithHighestPopulation(List<Person> people) {
        if (people.isEmpty()) return -1;
        Map<Integer, List<Person>> bornGroup = people.stream().collect(Collectors.groupingBy(it -> it.born));
        Map<Integer, List<Person>> deathGroup = people.stream().collect(Collectors.groupingBy(it -> it.death));
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Person person : people) {
            min = Integer.min(min, person.born);
            max = Integer.max(max, person.born);
        }
        int maxYear = 0;
        int answer = min;
        int balance = 0;
        for (int year = min; year <= max; year++) {
            if (!bornGroup.containsKey(year) && !deathGroup.containsKey(year)) {
                continue;
            }
            int currentYearBorn = 0;
            int currentYearDeath = 0;
            if (bornGroup.containsKey(year)) {
                currentYearBorn = bornGroup.get(year).size();
            }
            if (deathGroup.containsKey(year)) {
                currentYearDeath = deathGroup.get(year).size();
            }
            balance += (currentYearBorn - currentYearDeath);
            if (balance > maxYear) {
                maxYear = balance;
                answer = year;
            }
        }
        return answer;
    }
}
