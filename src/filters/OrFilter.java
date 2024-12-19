package filters;

import java.util.List;

public class OrFilter<T> implements Specification<T> {
    private List<Specification<T>> filters;

    public OrFilter(List<Specification<T>> filters) {
        this.filters = filters;
    }

    @Override
    public boolean isSatisfiedBy(T item) {
        return filters.stream().anyMatch(filter -> filter.isSatisfiedBy(item));
    }
}