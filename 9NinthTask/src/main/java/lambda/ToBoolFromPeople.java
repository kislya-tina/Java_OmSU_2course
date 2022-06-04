package lambda;

@FunctionalInterface
public interface ToBoolFromPeople<H, I> {
    boolean function(H human1, H human2, H human3, I maxAge);
}
