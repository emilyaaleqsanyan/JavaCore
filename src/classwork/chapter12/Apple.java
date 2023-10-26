package classwork.chapter12;

public enum Apple {
    JONATHAN(10), GOLDEN_DEL(9), RED_DEL(12), WINESAP(15), CORTLAND(8);
    private int price;

    Apple(int p){
        price = p;
    }

    int getPrice(){
        return price;
    }
}
