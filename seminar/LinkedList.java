package seminar;


public class LinkedList<T> {
    private Node<T> head; // Головной узел списка

    private static class Node<T> {
        private T data; // Данные узла
        private Node<T> next; // Ссылка на следующий узел

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Добавление элемента в конец списка
    public void add(T element) {
        Node<T> newNode = new Node<>(element);

        if (head == null) {
            // Если список пустой, новый узел становится головным
            head = newNode;
        } else {
            // Ищем последний узел и добавляем новый узел в конец
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Вывод содержимого списка
    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Создание и использование списка
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Добавление элементов в список
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);

        // Вывод содержимого списка
        linkedList.display();
    }
}
