import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T>{

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }
    private class MyLinkedListIterator implements Iterator<T> {

        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    private class Node{
        T item;
        Node next;
        Node previous;

        public Node(Node previous, T item, Node next){
            this.previous = previous;
            this.item = item;
            this.next = next;
        }
    }

    private Node first = null;
    private Node last = null;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void checkListEmpty(){
        if(isEmpty()){
            throw new NoSuchElementException("List is empty");
        }
    }

    public T getFirst() {
        checkListEmpty();
        return first.item;
    }

    public void addFirst(T item){
        Node oldFirst = first;
        first = new Node(null, item, oldFirst);
        if(isEmpty()){
            last = first;
        } else {
            oldFirst.previous = first;
        }
        size++;
    }

    public T removeFirst(){
        checkListEmpty();
        Node second = first.next;
        T item = first.item;
        first.item = null;
        first.next = null;
        first = second;
        size--;
        if(isEmpty()){
            last = null;
        } else {
            second.previous = null;
        }
        return item;
    }

    public T getLast() {
        checkListEmpty();
        return last.item;
    }

    public void addLast(T item){
        Node oldLast = last;
        last = new Node(oldLast, item, null);
        if (isEmpty()){
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public T removeLast(){
        checkListEmpty();
        T item = last.item;
        Node previous = last.previous;
        last.previous = null;
        last.item = null;
        last = previous;
        size--;
        if(isEmpty()){
            first = null;
        } else {
            last.next = null;
        }
        return item;
    }

    public T get(int index){
        if(index < 0 || index > size-1){
            throw new IndexOutOfBoundsException();
        }
        int currentIndex = 0;
        Node current = first;
        while(currentIndex < index){
            current = current.next;
            currentIndex++;
        }
        return current.item;
    }

    public void set(int index, T item){
        if(index < 0 || index > size-1){
            throw new IndexOutOfBoundsException();
        }
        int currentIndex = 0;
        Node current = first;
        while (currentIndex < index) {
            current = current.next;
            currentIndex++;
        }
        current.item = item;
    }

    public int indexOf(T item){
        Node current = first;
        int currentIndex = 0;
        while(current != null && !current.item.equals(item)){
            current = current.next;
            currentIndex++;
        }
        return current != null ? currentIndex : -1;
    }

    public boolean contains(T item){
        return indexOf(item) > -1;
    }

    public T remove(T item){
        Node current = first;

        while (current != null && !current.item.equals(item)){
            current = current.next;
        }
        if(current == null){
            return null;
        }
        if(current == first){
            return removeFirst();
        }
        if(current == last){
            removeLast();
        }
        Node next = current.next;
        Node previous = current.previous;
        previous.next = next;
        next.previous = previous;
        size--;
        current.previous = null;
        current.next = null;
        return current.item;
    }

    public void add(int index, T item){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            addFirst(item);
            return;
        } else if(index == size){
            addLast(item);
            return;
        }
        int currentIndex = 0;
        Node current = first;
        while(currentIndex < index){
            current = current.next;
            currentIndex++;
        }
        Node newNode = new Node(current.previous, item, current);
        Node previous = current.previous;
        previous.next = newNode;
        current.previous = newNode;
        size++;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        Node current = first;
        while(current != null){
            s.append(current.item.toString());
            s.append(", ");
            current = current.next;
        }
        return s.toString();
    }
}