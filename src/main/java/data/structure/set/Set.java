package data.structure.set;

import java.util.ArrayList;
import java.util.List;

public class Set<T extends Comparable> {

    private List<T> items = new ArrayList<>();

    public Set() {
    }

    public Set(Iterable<T> items) {
        addRange(items);
    }

    /**
     * Добавляет элемент в коллекцию. Если такой элемент уже есть в коллекции,
     * выбрасывается исключение IllegalArgumentException
     *
     * @param item - добавляемый элемент
     */
    public void add(T item) {
        if (contains(item)) {
            throw new IllegalArgumentException("Item already exists in Set");
        } else {
            items.add(item);
        }
    }

    /**
     * Добавляет коллекцию элементов в коллекцию. Если в передаваемой коллекции есть элемент, который
     * содержится в исходной коллекции, то выбрасывается исключение IllegalArgumentException
     *
     * @param items - добавляемые элементы
     */
    public void addRange(Iterable<T> items) {
        for (T item : items) {
            add(item);
        }
    }

    /**
     * @param item - удаляемый элемент
     * @return - если элемент удален из коллекции возвращается true,
     * если такого элемента нет в коллекции возвращается false
     */
    public boolean remove(T item) {
        return items.remove(item);
    }


    /**
     * @param item - искомый элемент
     * @return если элемнт содержится в коллекции возвращается true, иначе false
     */
    public boolean contains(T item) {
        return items.contains(item);
    }

    /**
     * @return количество элементов в коллекции
     */
    public int size() {
        return items.size();
    }

    /**
     * Объединяет два множества
     *
     * @param other - множество с которым объединяется исходное
     * @return объединенное множество
     */
    public Set<T> union(Set<T> other) {
        Set<T> result = new Set<>(items);
        for (T item : other.items) {
            if (!contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Пересечение множеств
     *
     * @param other - множество с котором ищется пересечение
     * @return пересечение двух множеств
     */
    public Set<T> intersection(Set<T> other) {
        Set<T> result = new Set<>();
        for (T item : items) {
            if (other.items.contains(item)) {
                result.add(item);
            }
        }
        return result;
    }

    /**
     * Разница множеств
     *
     * @param other - множество с которым ищется разность
     * @return разность двух множеств
     */
    public Set<T> difference(Set<T> other) {
        Set<T> result = new Set<>(items);
        for (T item : other.items) {
            result.remove(item);
        }
        return result;
    }

    /**
     * Симметричная разность
     *
     * @param other - множество с которым ищется симметричная разность
     * @return симметричная разность межжду двумя множествами
     */
    public Set<T> symmetricDifference(Set<T> other) {
        Set union = union(other);
        Set intersection = intersection(other);

        return union.difference(intersection);
    }

    /**
     * Проверяет содержится ли полностью множество в другом множестве
     *
     * @param other - множество, с которым проверяется что текущее множетсво является его подмножеством
     * @return возвращает true если текущее множество является подмножеством множества other, иначе false
     */
    public boolean isSubset(Set<T> other) {
        Set<T> diff = difference(other);
        return diff.size() == 0;
    }
}
