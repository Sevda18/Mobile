package filters;

import java.util.List;

public class NofMFilter<T> implements Specification<T> {
    private int n;
    private List<Specification<T>> filters;

    public NofMFilter(int n, List<Specification<T>> filters) {
        this.n = n;
        this.filters = filters;
    }

    @Override
    public boolean isSatisfiedBy(T item) {
        long satisfiedCount = filters.stream().filter(filter -> filter.isSatisfiedBy(item)).count();
        return satisfiedCount >= n;
    }
}
