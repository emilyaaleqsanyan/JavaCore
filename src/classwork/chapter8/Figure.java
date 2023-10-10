package classwork.chapter8;

public class Figure {
    double dim1;
    double dim2;

    Figure(double a, double b) {
        dim1 = a;
        dim2 = b;
    }

    double area() {
        System.out.println("Плоадь фигуры не определена.");
        return dim1 * dim2;
    }
}

class Rectangle extends Figure{
    Rectangle(double a, double b){
        super(a,b);
    }
    double area(){
        System.out.println("В области четырехугольника.");
        return dim1 * dim2;
    }

}

class Triangle extends Figure{
    Triangle(double a, double b){
        super(a,b);
    }

    double area(){
        System.out.println("В области треугольника.");
        return dim1 * dim2 / 2;
    }
}
