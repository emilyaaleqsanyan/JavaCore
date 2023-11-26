package homework.fileAnalyzer;

import java.util.Comparator;
import java.util.Map;

public class MyComparator implements Comparator<Object> {
    Map<String,Integer> myMap;
    public MyComparator(Map<String,Integer> myMap){
        this.myMap = myMap;
    }


    @Override
    public int compare(Object o1, Object o2) {
        if(myMap.get(o2) == myMap.get(o1))
            return 1;
        else
        return ((Integer)myMap.get(o2)).compareTo((Integer)myMap.get(o1));
    }
}
