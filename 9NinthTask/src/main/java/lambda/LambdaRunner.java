package lambda;

import java.util.function.*;

public class LambdaRunner {
    public static <T> int run(T t, ToIntFunction<? super T> func) {
        return func.applyAsInt(t);
    }

    public static <T> boolean run(T t, Predicate<? super T> pred) {
        return pred.test(t);
    }

    public static <T, F> boolean run(T t, F f, BiPredicate<? super T, ? super F> pred) {
        return pred.test(t, f);
    }

    public static <T, F> F run(T t, Function<? super T, ? super F> func) {
        return (F) func.apply(t);
    }

    public static <T, F> boolean run(T t1, T t2, T t3, F f, ToBoolFromPeople<? super T, ? super F> pred) {
        return pred.function(t1, t2, t3, f);
    }
}
