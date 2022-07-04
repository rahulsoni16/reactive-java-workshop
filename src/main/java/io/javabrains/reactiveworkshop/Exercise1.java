package io.javabrains.reactiveworkshop;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        System.out.println("#1. Print all numbers in the intNumbersStream stream");
        StreamSources.intNumbersStream().forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        System.out.println("#2. Print numbers from intNumbersStream that are less than 5");
        StreamSources.intNumbersStream()
                .filter(integer -> integer < 5)
                .forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        System.out.println("#3. Print the second and third numbers in intNumbersStream that's greater than 5");
        StreamSources.intNumbersStream()
                .filter(integer -> integer > 1 && integer < 4)
                .forEach(System.out::println);

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        System.out.println("#4. Print the first number in intNumbersStream that's greater than 5.");
        StreamSources.intNumbersStream()
                .filter(integer -> integer > 5)
                .findFirst().ifPresent(integer -> System.out.println(integer));

        // Print first names of all users in userStream
        System.out.println("#5. Print first names of all users in userStream");
        StreamSources.userStream()
                .forEach(user -> System.out.println(user.getFirstName()));

        // Print first names in userStream for users that have IDs from number stream
        System.out.println("#6. Print first names in userStream for users that have IDs from number stream");
        StreamSources.intNumbersStream()
                .forEach(integer -> {
                    StreamSources.userStream()
                            .filter(user -> user.getId() == integer)
                            .forEach(user -> System.out.println(user.getFirstName() + " " + user.getLastName()));
                });
    }

}
