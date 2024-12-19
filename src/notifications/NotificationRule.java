package notifications;

import filters.Specification;

public class NotificationRule<T> {
    private Specification<T> filter;

    public NotificationRule(Specification<T> filter) {
        this.filter = filter;
    }

    public boolean shouldNotify(T item) {
        return filter.isSatisfiedBy(item);
    }

    public void setFilter(Specification<T> newFilter) {
        this.filter = newFilter;
    }
}