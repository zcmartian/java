package java8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterTest {

    @Data
    @AllArgsConstructor
    private static class User {
        private String name;
        private String email;
    }
    public static void main(String[] args) {
        List<User> persons = Arrays.asList(
                new User("Jack", "jack234@gmail.com"),
                new User("Peter", "pete2@post.com"),
                new User("Lucy", "lucy17@gmail.com"),
                new User("Robert", "bob56@post.com"),
                new User("Martin", "mato4@imail.com")
        );

        List<User> result = persons.stream()
                .filter(person -> person.getEmail().matches(".*post\\.com"))
                .collect(Collectors.toList());

        result.forEach(item -> item.setEmail("modified"));

        System.out.println("filter result:");
        result.forEach(p -> System.out.println(p.getEmail()));

        System.out.println("original list:");
        persons.forEach(p -> System.out.println(p.getEmail()));
    }
}
