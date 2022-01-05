package protsenko.hw2;


public class LinkedListTwo <E> implements MyList<E> {

    private static int counter;
    private Node head;


    public LinkedListTwo() {

    }

    private class Node {

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
    public boolean contains(E o) {
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
    public boolean add(E data) {

        if (head == null) {
            head = new Node(data);
        }

        Node Temp = new Node(data);
        Node Current = head;

        if (Current != null) {

            while (Current.getNext() != null) {
                Current = Current.getNext();
            }

            Current.setNext(Temp);
        }

        incrementCounter();
        return true;
    }



    @Override
    public boolean remove(E o) {
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
    public boolean addAll(MyList<E> list) {
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
    public E get(int index) {
        if (index < 0)
            return null;
        Node Current = null;
        if (head != null) {
            Current = head.getNext();
            for (int i = 0; i < index; i++) {
                if (Current.getNext() == null)
                    return null;

                Current = Current.getNext();
            }
            return (E) Current.getData();
        }
        return (E) Current;
    }

    @Override
    public Object set(int index, E o) {

        return false;
    }

    @Override
    public void add(int index, E data) {
        Node Temp = new Node(data);
        Node Current = head;


        if (Current != null) {

            for (int i = 0; i < index && Current.getNext() != null; i++) {
                Current = Current.getNext();
            }
        }

        Temp.setNext(Current.getNext());

        Current.setNext(Temp);

        incrementCounter();
    }


    @Override
    public int indexOf(E o) {
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
    public MyList<E> subList(int fromIndex) {
        return (MyList<E>) subList(fromIndex, counter);
    }

    @Override
    public MyList<E> subList(int fromIndex, int toIndex) {
        if (toIndex > size() || toIndex < fromIndex || toIndex < 0 || fromIndex < 0) {


            throw new IndexOutOfBoundsException("final index out of range");
        }
        MyList<E> result = (MyList<E>) new LinkedListTwo<E>();
        for (int i = fromIndex; i < toIndex; i++) {
            result.add((E) get(i));
        }
        return result;
    }
}
