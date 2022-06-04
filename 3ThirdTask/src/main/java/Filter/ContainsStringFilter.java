package Filter;

public class ContainsStringFilter implements IFilter{
    private String pattern;

    public ContainsStringFilter(String pattern) {
        if (pattern == null || pattern.isEmpty()) {
            throw new NullPointerException("Пустой патерн");
        }
        this.pattern = pattern;
    }


    @Override
    public boolean apply(String s) {
        return s.contains(pattern);
    }
}
