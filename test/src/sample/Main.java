package sample;

import java.util.*;

public class Main<T> implements LimitedSet<T> {
    private final HashMap<T, Integer> map = new HashMap<T, Integer>();
    private final double LIMIT_BOUNDARY = 10;



    public static void main(String[] args) {
        Main<Integer> main = new Main<Integer>();

        main.add(1);
        main.add(2);
        main.add(3);
        main.add(4);
        main.add(5);
        main.add(6);
        main.add(7);
        main.add(8);
        main.add(9);
        main.add(10);

        main.contains(1);
        main.contains(2);
        main.contains(3);
        main.contains(4);
        main.contains(5);
        main.contains(6);
        main.contains(7);
        main.contains(8);
        main.contains(9);
        main.contains(10);

        main.contains(1);
        main.contains(2);
        main.contains(3);
        main.contains(4);
        main.contains(5);
        main.contains(6);
        main.contains(7);
        main.contains(8);
        main.contains(9);
        main.contains(10);


        main.add(10);
        main.remove(11);


        System.out.println(main.map);

    }

    @Override
    public void add(T t) {
        if (map.size() >= LIMIT_BOUNDARY) {
            Integer min = Collections.min(map.values());
            T keyForRemove = null;

            for (Map.Entry<T, Integer> entry : map.entrySet() ) {
                if (entry.getValue().equals(min)) {
                    keyForRemove = entry.getKey();
                }
            }


            map.remove(keyForRemove);
        }

        map.put(t, 0);
    }

    @Override
    public boolean remove(T t) {
        return map.remove(t, map.get(t));
    }

    @Override
    public boolean contains(T t) {
        if (map.containsKey(t)) {
            map.put(t, map.get(t) + 1);

            return true;
        }
        return false;
    }
}
