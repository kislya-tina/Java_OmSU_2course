package Filter;

public class BeginStringFilter implements IFilter {
    private String pattern;

    public BeginStringFilter(String pattern) {
        if (pattern == null || pattern.isEmpty()) {
            throw new NullPointerException("Пустой патерн");
        }
        this.pattern = pattern;
    }


    @Override
    public boolean apply(String s) {
        return s.startsWith(pattern);
    }
}
