package sample;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class HashMapSolution<T> implements LimitedSet<T> {
    public TreeSet<T> treeSet = new TreeSet<T>();
    public Map<T, Integer> invokeTracker  = new HashMap<T, Integer>();

    @Override
    public void add(T t) {
        if (treeSet.size() < 10) {
            treeSet.add(t);
            invokeTracker.put(t, 0);
        }

    }

    @Override
    public boolean remove(T t) {
        if (treeSet.remove(t)) {
            invokeTracker.remove(t);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(T t) {
        if (treeSet.contains(t)) {
            invokeTracker.put(t, invokeTracker.get(t) + 1);
            return true;
        } else {
            return false;
        }
    }

    public TreeSet<T> getTreeSet() {
        return treeSet;
    }

    public Map<T, Integer> getInvokeTracker() {
        return invokeTracker;
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
        solution.add(10);
        solution.add(11);



        System.out.println(solution);
    }
}
