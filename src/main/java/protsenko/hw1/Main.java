package protsenko.hw1;


public class Main {

    public static void main(String[] args) {
        MyListDemo<Object> listDemo = new MyListDemo<>();

        listDemo.add(new Object());
        listDemo.add(new Object());
        listDemo.add(new Object());
        listDemo.add(new Object());

        System.out.println(listDemo.size());
        System.out.println(listDemo.remove(2));
        System.out.println(listDemo.size());


    }


}
