package filters;

import java.util.List;

public class AndFilter<T> implements Specification<T> {
    private List<Specification<T>> filters;

    public AndFilter(List<Specification<T>> filters) {
        this.filters = filters;
    }

    @Override
    public boolean isSatisfiedBy(T item) {
        return filters.stream().allMatch(filter -> filter.isSatisfiedBy(item));
    }
}