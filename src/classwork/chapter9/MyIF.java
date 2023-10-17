package classwork.chapter9;

public interface MyIF {
    int getNumber();

    default String getString(){
        return "Обект типа String по умолчанию";
    }
}
