package homeWork_02.arrayList;

public class TestArrayList {

    public static void main(String[] args) {
        //Добавление элементов и увеличение массива в связи с этим.
        MyArrayList<String> myArrayList = new MyArrayList<>();
        myArrayList.add("One");
        myArrayList.add("Two");
        myArrayList.add("Three");
        myArrayList.add("Four");
        myArrayList.add("Five");
        myArrayList.add("Six");
        myArrayList.add("Seven");
        myArrayList.add("Eight");
        myArrayList.add("Nine");
        myArrayList.add("Ten");
        System.out.println(myArrayList);
        //Получение количиства элементов в массиве.
        System.out.println(myArrayList.size());
        //Получение объектов массива по индексу.
        System.out.println(myArrayList.get(3));
        System.out.println(myArrayList.get(7));

        //Удаление элемента и сжатие массива.
        myArrayList.remove(2);
        myArrayList.remove(2);
        myArrayList.remove(2);
        myArrayList.remove(2);
        myArrayList.remove(2);
        myArrayList.remove("Ten");
        myArrayList.remove("Eight");
        System.out.println(myArrayList);
        System.out.println(myArrayList.size());

    }
}
