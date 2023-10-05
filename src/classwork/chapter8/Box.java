package classwork.chapter8;

public class Box {
    double widht;
    double height;
    double depth;

    Box(classwork.chapter8.Box ob) {
        widht = ob.widht;
        height = ob.height;
        depth = ob.depth;
    }

    Box() {
        widht = -1;
        height = -1;
        depth = -1;

    }

    Box(double len) {
        widht = height = depth = len;
    }

    double volume() {
        return widht * height * depth;
    }
}

class BoxWeight extends classwork.chapter8.Box {
    double weight;

    BoxWeight(double w, double h, double d, double m) {
        widht = w;
        height = h;
        depth = d;
        weight = m;
    }
}

class ColorBox extends classwork.chapter8.Box {
    int color;

    ColorBox(double w, double h, double d, int c) {
        widht = w;
        height = h;
        depth = d;
        color = c;
    }
}

