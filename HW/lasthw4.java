package HW;

/*
Реализовать класс работающий по принципу HashMap. Включая внутренний массив узлов с индексацией по хешу и описание узла. Добавить в класс методы:
Object put(Integer key , Integer value) добавить элемент
Object get(Integer key) получить значение соответствующее ключу
Object remove(Integer key) удалить элемент с соответствующем ключём
Object replays(Integer key, Integer v) заменить значение
int size() количество элементов
boolean containsKey(Integer key) проверка наличия ключа и значения
boolean containsValue(Integer v)
 */

public class lasthw4 {
    private static final int DEFAULT_CAPACITY = 16;
    private Node[] table;
    private int size;

    public lasthw4() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public Object put(Integer key, Integer value) {
        int index = getIndex(key);
        Node newNode = new Node(key, value);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node currentNode = table[index];
            while (currentNode.next != null) {
                if (currentNode.key.equals(key)) {
                    Object oldValue = currentNode.value;
                    currentNode.value = value;
                    return oldValue;
                }
                currentNode = currentNode.next;
            }
            if (currentNode.key.equals(key)) {
                Object oldValue = currentNode.value;
                currentNode.value = value;
                return oldValue;
            }
            currentNode.next = newNode;
        }

        size++;
        return null;
    }

    public Object get(Integer key) {
        int index = getIndex(key);
        Node currentNode = table[index];

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }

        return null;
    }

    public Object remove(Integer key) {
        int index = getIndex(key);
        Node currentNode = table[index];
        Node previousNode = null;

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                if (previousNode == null) {
                    table[index] = currentNode.next;
                } else {
                    previousNode.next = currentNode.next;
                }
                size--;
                return currentNode.value;
            }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        return null;
    }

    public Object replace(Integer key, Integer value) {
        int index = getIndex(key);
        Node currentNode = table[index];

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                Object oldValue = currentNode.value;
                currentNode.value = value;
                return oldValue;
            }
            currentNode = currentNode.next;
        }

        return null;
    }

    public int size() {
        return size;
    }

    public boolean containsKey(Integer key) {
        int index = getIndex(key);
        Node currentNode = table[index];

        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    public boolean containsValue(Integer value) {
        for (Node node : table) {
            Node currentNode = node;
            while (currentNode != null) {
                if (currentNode.value.equals(value)) {
                    return true;
                }
                currentNode = currentNode.next;
            }
        }

        return false;
    }

    private int getIndex(Integer key) {
        return key.hashCode() % table.length;
    }

    private static class Node {
        private Integer key;
        private Integer value;
        private Node next;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        lasthw4 hashMap = new lasthw4();
        hashMap.put(1, 150);
        hashMap.put(2, 260);
        hashMap.put(3, 370);

        System.out.println(hashMap.get(1));
        System.out.println(hashMap.containsKey(2));
        System.out.println(hashMap.containsValue(130));

        hashMap.replace(3, 35);
        System.out.println(hashMap.get(3));

        System.out.println(hashMap.remove(2));
        System.out.println(hashMap.size());
    }
}