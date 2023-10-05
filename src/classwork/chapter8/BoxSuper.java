package classwork.chapter8;

public class BoxSuper {
    private double widht;
    private double height;
    private double depth;

    BoxSuper(BoxSuper ob) {
        widht = ob.widht;
        height = ob.height;
        depth = ob.depth;
    }
    BoxSuper(double w, double h, double d ) {
        widht = w;
        height = h;
        depth = d;
    }


    BoxSuper() {
        widht = -1;
        height = -1;
        depth = -1;

    }

    BoxSuper(double len) {
        widht = height = depth = len;
    }

    double volume() {
        return widht * height * depth;
    }
}

class BoxSuperWeight extends BoxSuper {
    double weight;

    BoxSuperWeight(BoxSuperWeight ob) {
        super(ob);
        weight = ob.weight;
    }
    BoxSuperWeight(double w, double h, double d, double m){
        super(w, h, d);
        weight = m;
    }

    BoxSuperWeight(){
        super();
        weight = -1;
    }

    BoxSuperWeight(double len, double m){
        super(len);
        weight = m;
    }
}

