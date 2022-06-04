package Filter;

public class EndStringFilter implements IFilter {
    private String pattern;

    public EndStringFilter(String pattern) {
        if (pattern == null || pattern.isEmpty()) {
            throw new NullPointerException("Пустой патерн");
        }
        this.pattern = pattern;
    }


    @Override
    public boolean apply(String s) {
        return s.endsWith(pattern);
    }
}
