/*
@author Marukha
created on 10.04.2024 inside

*/

import java.util.*;


/**
 *Класс является собственной реализацией ArrayList
 * принимающий любые типы данных
 */
public class ArrayListHome<E> implements List<E>{
    /**
     * Количество элементов в списке
     */
    private int size;
    /**
     * Дефолтный размер внутреннего массива
     */
    private final int DEFAULT_SIZE = 10;
    /**
     * Коэфицент увеличения массива при переполнении
     */
    private final double MAGNITION_FACTOR = 1.5;
    /**
     * Массив внутренней реализации
     */
    private E[] array;

    /**
     * Дефолтный конструктор без обьявления размера
     */
    public ArrayListHome(){
        this.array = (E[]) new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    /**
     * Конструктор с обьявлением размера внутренного массива
     * @param capacity размер массива
     */
    public ArrayListHome(int capacity){
        if(capacity <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }else{
            this.array =(E[]) new Object[capacity];
            this.size = 0;
        }

    }

    /**
     * Сортировка с компаратором
     * @param comparator the {@code Comparator} used to compare list elements.
     *          A {@code null} value indicates that the elements'
     *          {@linkplain Comparable natural ordering} should be used
     */
    public void sort(Comparator<? super E> comparator) {
        Arrays.sort(array, 0, size, comparator);
    }

    /**
     * Сортировка без компаратора
     */
    public void sort(){
        Arrays.sort(array,0,size);
    }

    /**
     *
     * @return количество элементов в листе
     */
    @Override
    public int size() {
        return size;
    }

    /**
     *
     * @return проверку пустой ли лист
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *Проверяет есть ли элемент о в списке
     * @param o элемент который проверяется на наличие в списке
     * @return true или false если найдет или не найдет o
     */
    @Override
    public boolean contains(Object o) {
        for(Object elem : array){
            if(o.equals(elem)) return true;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    /**
     * Возвращает массив
     * @return массив
     */
    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    /**
     * Добавляет элемент в конец листа
     * @param e элемент который добавляется в листа
     * @return true когда добавит элемент
     */
    @Override
    public boolean add(E e) {
        if(size == array.length) resize();
        array[size] = e;
        size ++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /**
     * очищает лист от всех элементов внутри
     */
    public void clear() {
        array =(E[]) new Object[DEFAULT_SIZE];
        size = 0;
    }

    /**
     * Возвращает элемент из списка по его индексу
     * @param index индекс элемента который нужно вернуть
     * @return элемент списка
     */
    public E get(int index) {
        if(index < 0 || index > size)throw new IndexOutOfBoundsException();
        return array[index];
    }

    /**
     * Возвращает элемент из листа который мы заменили, и заменяет новым
     * @param index индекс элемента, который заменяют
     * @param element новый элемент, который займет место старого
     * @return старый элемент
     */
    @Override
    public E set(int index, E element) {
        if(index < 0 || index > size)throw new IndexOutOfBoundsException();
        E oldValue = array[index];
        array[index] = element;
        return oldValue;
    }

    /**
     * Добавляет элемент в лист по индексу
     * @param index индекс куда ставится элемент
     * @param element элемент который вставляется
     */
    @Override
    public void add(int index, E element) {
        if(array.length == size) resize();
        if(index <0 || index > size){
            throw new IndexOutOfBoundsException("Индекс вышел за границы массива!");
        }
        E[] tempArray = Arrays.copyOf(array,array.length+1);
        tempArray[index] = element;
        size++;
        for(int i = index+1;i < tempArray.length;i++){
            tempArray[i] = array[i-1];
        }
        array = tempArray;
    }

    /**
     * Удаляет элимент из списка и возвращает его значение
     * @param index индекс элемента который удаляется
     * @return элемент который удалили
     */
    @Override
    public E remove(int index) {
        if(index <0 || index > size)throw new IndexOutOfBoundsException();
        E[] tempArray = Arrays.copyOf(array,array.length);
        E removedValue = array[index];
        for(int i = size; i<=index;i--){
            tempArray[i-1] = array[i];
        }
        size--;
        array = tempArray;
        return removedValue;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    /**
     * Изменяет размер внутреннего массива, его идет переполнение
     */
    private void resize(){
        array = Arrays.copyOf(array, (int) (array.length*MAGNITION_FACTOR+1));
    }



}
