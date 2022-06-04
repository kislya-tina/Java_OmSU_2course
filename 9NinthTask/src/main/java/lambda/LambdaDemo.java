package lambda;

import people.Human;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class LambdaDemo {
    public static final ToIntFunction<String> stringLen = String::length;
    public static final Function<String, Character> stringFirstChar = str -> (str == null) ? null : str.charAt(0);
    public static final Predicate<String> stringSpaces = str -> !str.contains(" ");
    public static final ToIntFunction<String> stringCountWords = str -> str.split(",").length;
    public static final ToIntFunction<Human> humanAge = Human::getAge;
    public static final BiPredicate<Human, Human> sameSurnames = (human, human1) ->
            human.getSurname().equals(human1.getSurname());
    public static final Function<Human, String> humanFullName = human ->
            human.getSurname() + " " + human.getName() + " " + human.getLastname();
    public static final Function<Human, Human> humanOlder = human ->
            new Human(human.getSurname(), human.getName(), human.getLastname(),
                    human.getAge() + 1, human.getGender());
    public static final ToBoolFromPeople<Human, Integer> humYoungerThan = (human1, human2, human3, maxAge) ->
            human1.getAge() < maxAge &&
                    human2.getAge() < maxAge &&
                    human3.getAge() < maxAge;
}