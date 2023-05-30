package seminar;

public class L3 {
    public static void main(String[] args) {

//        OneWayList<Integer> integerOneWayList = new OneWayList<>();

        TwoWayList<Integer> integerOneWayList = new TwoWayList<>();
        integerOneWayList.add(55);
        integerOneWayList.add(26);
        integerOneWayList.add(13);
        integerOneWayList.add(98);
//        integerOneWayList.add(122, 2);
        integerOneWayList.addLast(156);

//        System.out.println(integerOneWayList.size());
//        System.out.println(integerOneWayList.get(integerOneWayList.size() - 1));
        System.out.println();
    }
    
    /*
    public class OneWayList {
        private Node head;
        private Node tail;

        class Node {
            private int value;
            private Node nextNode;

            public Node findNode(int value) {
                Node node = head;
                while (node.nextNode != null){
                    node = node.nextNode;
                    if(node.value == value){
                        return node;
                    }
                }
                return null;
            }

            public void put (Node node)
        }

        public OneWayList randomNode(int len, int range){

        }

    }


*/
}