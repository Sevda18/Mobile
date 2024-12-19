package filters;

public interface Specification<T> {
    boolean isSatisfiedBy(T item);
}
