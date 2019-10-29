package Structures;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeHashMapDifferent {

    public static void main(String[] args) {
        HashMap<Integer,String> hashMap = new HashMap();
        TreeMap<Integer,String> treeMap = new TreeMap();
        long start;
        long end;
        long hashTime;
        long treeTime;

        for(int i=0; i<1000000; i++){
            hashMap.put(new Integer((int)Math.random()*1000000),genRandString((int)Math.round(Math.random()*36)).toString());
            treeMap.put(new Integer((int)Math.random()*1000000),genRandString((int)Math.round(Math.random()*36)).toString());
        }
        time(hashMap);

        time(treeMap);

    }

    private static void time(Map<Integer, String> hashMap) {
        long start;
        long end;
        long hashTime;
        start=System.currentTimeMillis();
        for(int i=0;i<10000000;i++){
            String s =hashMap.get(new Integer((int)Math.random()*1000000));
        }
        end=System.currentTimeMillis();
        hashTime=end-start;
        System.out.println("Затраченное время на перебор hashMap (ms): "+hashTime + " " + hashMap.getClass());
    }

    static StringBuilder genRandString(int lenght){
        String symbols = "qwertyuiopasdfghjklzxcvbnm1234567890";
        StringBuilder randString = new StringBuilder();
        for(int i=0;i<lenght;i++)
            randString.append(symbols.charAt((int)(Math.random()*symbols.length())));
        return randString;

    }
}
