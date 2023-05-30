package seminar;

public class TwoWayList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public void add(E value) {
        Node<E> newNode = new Node<>();
        newNode.value = value;
        if (head != null) {
            head.previousNode = newNode;
            newNode.nextNode = head;
        }
        if (size == 1) {
            tail = head;
        }
        head = newNode;
        size++;
    }

    public int size() {
           return size;
    }

    public E get(int index) {
        Node<E> currentNode = head;
        int counter = 0;
        while (counter < index) {
            counter++;
            if (currentNode.nextNode == null) throw new ArrayIndexOutOfBoundsException();
            currentNode = currentNode.nextNode;
        }
        return currentNode.value;
    }

    public boolean contains(E value) {
        Node<E> currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return true;
            }
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    public int indexOf(E value) {
        int counter = 0;
        Node<E> currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return counter;
            }
            counter++;
            currentNode = currentNode.nextNode;
        }
        return -1;
    }

    // add by index
    public void add(E value, int index) {
        if (index > size() || index < 0) throw new ArrayIndexOutOfBoundsException();
        if (index != 0) {
            Node<E> currentNode = head;
            while (index > 1) {

                index--;
                currentNode = currentNode.nextNode;
            }
            Node<E> newNode = new Node<>();
            newNode.value = value;
            currentNode.nextNode = newNode;
            Node<E> tmp = currentNode.nextNode;
            newNode.nextNode = tmp;
            size++;
        } else add(value);
    }

    public void addLast(E value){
        Node<E> newNode = new Node<>();
        newNode.value = value;
        newNode.previousNode = tail;
        tail.nextNode = newNode;
        tail = newNode;
        size++;
    }

}