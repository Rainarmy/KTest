import java.util.TreeMap;
import java.util.TreeSet;

public class MethodATest {
    public static void main(String[] args) {
        int[] a = {2,34,76,3,94,6,35,86,34,11,24,56,78,43,1,56,7,87,34,78};
        TreeSet<Integer> set = new TreeSet<>();
//        TreeMap map = new TreeMap();
        for(int i : a){

            if(set.size() > 4){
                if(set.contains(i)){
                    continue;
                }
                int min = set.first();
                if( i > min){
                    set.remove(min);
                    set.add(i);
                }

            }else{
                set.add(i);
            }
//            if(map.size() > 4){
//                int min = (int) map.;
//
//                if(i > min){
//                    map.remove(min);
//                    map.put(i,null);
//                }
//            }else{
//                map.put(i,null);
//            }
        }
        System.out.println(set);
//        System.out.println(map);
    }
}
