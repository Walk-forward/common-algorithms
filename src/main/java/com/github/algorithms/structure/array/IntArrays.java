package com.github.algorithms.structure.array;

public class IntArrays {

    public static IntArray selectSort(IntArray intArray) {
        IntArray sort = new IntArray(intArray.size());
        int size = intArray.size();
        for (int i = 0; i < size; i++) {
            int index = minIndex(intArray);
            sort.add(intArray.get(index));
            intArray.remove(index);
        }
        return sort;
    }

    public static int minIndex(IntArray intArray) {
        int minIndex = 0;
        for (int i = 1; i < intArray.size(); i++) {
            if (intArray.get(minIndex) > intArray.get(i)) {
                minIndex = i;
            }
        }
        return minIndex;
    }

}
