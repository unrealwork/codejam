package com.unrealwork.codejam.problems.storecredit;


import com.unrealwork.codejam.common.Case;

import java.util.*;

public class StoreCreditCase implements Case<Pair<Integer>> {
    private List<Integer> items;
    private Integer credit;

    public StoreCreditCase(Integer credit, List<Integer> items) {
        this.credit = credit;
        this.items = items;
    }

    @Override
    public String toString() {
        return "StoreCreditCase{" +
                "items=" + items +
                ", credit=" + credit +
                '}';
    }

    @Override
    public Pair<Integer> solve() {
        Map<Integer, Set<Integer>> indexMap = new HashMap<>();
        int index = 0;
        for (Integer item : items) {
            if (item < credit) {
                if (indexMap.containsKey(item)) {
                    indexMap.get(item).add(index);
                } else {
                    indexMap.put(item, new HashSet<>(Arrays.asList(index)));
                }
            }
            index++;
        }
        for (Integer element : indexMap.keySet()) {
            int rest = credit - element;
            Set<Integer> elementIndexes = indexMap.get(element);
            if (rest == element) {
                if (elementIndexes.size() == 2) {
                    Integer[] indexes = new Integer[2];
                    elementIndexes.toArray(indexes);
                    return new Pair<>(indexes[0] + 1, indexes[1] + 1);
                }
            } else {
                if (indexMap.containsKey(rest)) {
                    Integer first = elementIndexes.iterator().next();
                    Integer second = indexMap.get(rest).iterator().next();
                    return new Pair<>(first + 1, second + 1);
                }
            }
        }
        return null;
    }
}
