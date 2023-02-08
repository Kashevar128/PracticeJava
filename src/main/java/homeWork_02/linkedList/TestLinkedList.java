package homeWork_02.linkedList;

public class TestLinkedList {
    public static void main(String[] args) {
        MyLinkedList<String> mll = new MyLinkedList<>();

        //Вставка первого элемента.
        mll.addFirst("one");
        mll.addFirst("two");
        mll.addFirst("three");
        mll.addFirst("four");
        System.out.println(mll);

        //Удаление первого элемента.
        mll.removeFirst();
        System.out.println(mll);

        //Вставка последнего элемента.
        mll.addLast("five");
        System.out.println(mll);

        //Удаление последнего элемента.
        mll.removeLast();
        System.out.println(mll);

        //Добавление элемента по индексу.
        mll.add(1, "six");
        System.out.println(mll);

        //Удаление указанного объекта.
        mll.remove("three");
        System.out.println(mll);

        //Узнать размер листа.
        System.out.println(mll.size());

        //Узнать пустой ли лист.
        System.out.println(mll.isEmpty());

        //Узнать есть ли такой элемент.
        System.out.println(mll.contains("one"));
        System.out.println(mll.contains("seven"));

    }
}
