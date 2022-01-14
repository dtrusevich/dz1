package protsenko.hw2;


public class LinkedListTwo implements MyList<Object> {

    private static int counter;
    private Node head;


    public LinkedListTwo() {

    }

    private static class Node {

        Node next;
        Object E;


        public Node(Object dataValue) {
            next = null;
            E = dataValue;
        }

        @SuppressWarnings("unused")
        public Node(Object dataValue, Node nextValue) {
            next = nextValue;
            E = dataValue;
        }


        public Object getData() {
            return E;
        }

        @SuppressWarnings("unused")
        public void setData(Object dataValue) {
            E = dataValue;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node nextValue) {
            next = nextValue;
        }

    }

    private static int getCounter() {
        return counter;
    }

    private static void incrementCounter() {
        counter++;
    }

    private void decrementCounter() {
        counter--;
    }


    @Override
    public int size() {
        return getCounter();
    }

    @Override
    public boolean isEmpty() {
        return counter == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node t = head;
        while (t != null) {
            if (t.getData() == o) {
                return true;
            }
            t = t.next;
        }
        return false;
    }

    @Override
    public boolean add(Object data) {

        if (head == null) {
            head = new Node(data);
        }

        Node Temp = new Node(data);
        Node Current = head;

        while (Current.getNext() != null) {
            Current = Current.getNext();
        }

        Current.setNext(Temp);

        incrementCounter();
        return true;
    }



    @Override
    public boolean remove(Object o) {
    return false;
    }

    @Override
    public boolean remove(int index) {

        if (index < 1 || index > size())
            return false;

        Node Current = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (Current.getNext() == null)
                    return true;

                Current = Current.getNext();
            }
            Current.setNext(Current.getNext().getNext());


            decrementCounter();
            return true;

        }
        return false;
    }

    @Override
    public boolean addAll(MyList<Object> list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        counter = 0;
    }

    @Override
    public Object get(int index) {
        if (index < 0)
            return null;
        Node Current;
        if (head != null) {
            Current = head.getNext();
            for (int i = 0; i < index; i++) {
                if (Current.getNext() == null)
                    return null;

                Current = Current.getNext();
            }
            return Current.getData();
        }
        return null;
    }

    @Override
    public Object set(int index, Object o) {

        return false;
    }

    @Override
    public void add(int index, Object data) {
        Node Temp = new Node(data);
        Node Current = head;


        if (Current != null) {

            for (int i = 0; i < index && Current.getNext() != null; i++) {
                Current = Current.getNext();
            }
        }

        assert Current != null;
        Temp.setNext(Current.getNext());

        Current.setNext(Temp);

        incrementCounter();
    }


    @Override
    public int indexOf(Object o) {
        Node pointerNode = head;
        int index = 0;
        while (pointerNode != null && pointerNode.getData() != null) {
            if (pointerNode.getData().equals(o)) {
                return index;
            } else {
                pointerNode = pointerNode.getNext();
                index++;
            }
        }
        return -1;
    }

    @Override
    public MyList<Object> subList(int fromIndex) {
        return subList(fromIndex, counter);
    }

    @Override
    public MyList<Object> subList(int fromIndex, int toIndex) {
        if (toIndex > size() || toIndex < fromIndex || toIndex < 0 || fromIndex < 0) {


            throw new IndexOutOfBoundsException("final index out of range");
        }
        MyList<Object> result = new LinkedListTwo();
        for (int i = fromIndex; i < toIndex; i++) {
            result.add(get(i));
        }
        return result;
    }
}
