package classwork.chapter6;

public class Box1 {
    double width;
    double height;
    double depth;

    Box1() {
        System.out.println("Конструирование объекта Box1");
        width = 10;
        height = 10;
        depth = 10;
    }

    double volume() {
        return width * height * depth;
    }
}
