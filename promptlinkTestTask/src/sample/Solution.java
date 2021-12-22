package sample;

import java.util.*;

public class Solution<T> implements LimitedSet<T> {
    private final TreeSet<LimitedObject<T>> treeSet = new TreeSet<LimitedObject<T>>();

    @Override
    public void add(T o) {
        if (treeSet.size() <= 10) {
            treeSet.add(new LimitedObject<T>(o));
        } else {
            treeSet.remove(treeSet.stream()
                    .min(Comparator.comparing(LimitedObject::getNumberOfInvokes))
                    .orElseThrow(() -> new BaseException("No min found!")));

            treeSet.add(new LimitedObject<T>(o));
        }

    }

    @Override
    public boolean remove(T o) {
        Optional<LimitedObject<T>> first = treeSet.stream().filter(lo -> lo.object.equals(o)).findFirst();

        if (first.isEmpty()) {
            return false;
        } else {
            treeSet.remove(first.get());
            return true;
        }
    }

    @Override
    public boolean contains(T o) {
        Optional<LimitedObject<T>> first = treeSet.stream().filter(lo -> lo.object.equals(o)).findFirst();
        if (first.isEmpty()) {
            return false;
        }

        first.get().invoke();
        return true;
    }

    public static void main(String[] args) {
        Solution<Integer> solution = new Solution<Integer>();

        solution.add(1);
        solution.add(2);
        solution.add(3);
        solution.add(4);
        solution.add(5);
        solution.add(6);
        solution.add(7);
        solution.add(8);

        solution.add(9);
        solution.contains(9);

        solution.add(10);
        solution.add(11);
        solution.add(12);
        solution.add(13);

        solution.remove(13);
        solution.treeSet.remove(new LimitedObject<>(13));


        System.out.println(solution.treeSet);
    }


}
