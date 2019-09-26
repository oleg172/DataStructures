package data.structure.arrayList;

public class ArrayList<T extends Comparable> {

    private Object[] items;
    private int size;

    /**
     * Инициализация коллекции
     */
    public ArrayList() {
        items = new Object[0];
    }

    /**
     * Инциализация коллекции размером size.
     * Если передоваемый параметр size < 0, выбрасывается исключение IllegalArgumentException
     *
     * @param size - размер коллекции
     */
    public ArrayList(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size of array should be more then 0");
        }
        items = new Object[size];
    }

    /**
     * Создает новый массива по формуле (size * 3) / 2 + 1
     * и копирует значения из старого массива в новый
     */
    private void growArray() {
        int newLength = (items.length * 3) / 2 + 1;
        Object[] newArray = new Object[newLength];
        System.arraycopy(items, 0, newArray, 0, items.length);
        items = newArray;
    }

    /**
     * Вставляет значение на заданную позицию в коллекции,
     * сдвигая элементы находящиеся правее вправо.
     * Если index больше размера массива, выбрасывается исключение IllegalArgumentException.
     *
     * @param index - позиция на которую будет вставлен новый элемент
     * @param item  - добавляемый элемент
     */
    public void insert(int index, T item) {
        if (index > items.length) {
            throw new IllegalArgumentException("Index should be less than array size. " +
                    "Array size = " + items.length + "; index = " + index);
        }
        if (items.length == size) {
            growArray();
        }
        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = item;
        size++;
    }

    /**
     * Вставляет элемент в конец списка.
     * Если размер массива равен количеству элементов в нем, то увеличиваем размер массива.
     *
     * @param item - добавляемый элемент
     */
    public void add(T item) {
        if (items.length == size) {
            growArray();
        }
        items[size] = item;

        size++;
    }

    /**
     * Элемент на позиции index удаляется из массива, сдвигая элменеты находящиеся правее него влево
     *
     * @param index - позиция с которой будет удален элемент
     */
    public void removeAt(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int shiftStart = index + 1;
        if (shiftStart < size) {
            System.arraycopy(items, shiftStart, items, index, size - shiftStart);
        }
        size--;
    }

    /**
     * Удаляет первое вхождение элемента item из коллекции
     *
     * @param item - удаляемый элемент
     * @return true если объект был удален, иначе false
     */
    public boolean remove(T item) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Возвращает позицию первого вхождения элемента item в коллекции
     *
     * @param item - искомый элемент
     * @return первую позицию на которой встерчается элемент item.
     * Если такого элемента нет, то возвращается -1
     */
    public int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Возвращает элемент из коллекции на позиции index
     *
     * @param index - позиция элемента в массиве
     * @return элемент на позиции index,
     * если index больше количества элементов в массиве выбрасывается исключение IllegalArgumentException
     */
    public T getElement(int index) {
        if (index < size) {
            return (T) items[index];
        }
        throw new IllegalArgumentException("Index should be less than array size. " +
                "Array size = " + size + "; index = " + index);
    }

    /**
     * Проверяет наличие элемента item в коллекции
     *
     * @param item - искомый элемент
     * @return возвращает true если элемент находится в массиве, иначе false
     */
    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    /**
     * Удаляет все элементы из коллекции
     */
    public void clear() {
        items = new Object[0];
        size = 0;
    }

    /**
     * Копирует элементы из ArrayList в заданный массив
     *
     * @param array - массив в который копируются элементы ArrayList
     * @param index - позиция с которой необходимо начать вставлять элементы в коллекцию array
     */
    public void copyTo(T[] array, int index) {
        System.arraycopy(items, 0, array, index, size);
    }

    /**
     * @return количество элементов в  коллекции
     */
    public int getSize() {
        return size;
    }

    /**
     * @return возвращает массив элементов коллекции
     */
    public Object[] toArray() {
        return items;
    }
}
