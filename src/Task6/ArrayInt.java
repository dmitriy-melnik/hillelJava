package Task6;

import java.util.Arrays;

public class ArrayInt {

    private int[] array = new int[0];

    public ArrayInt() {
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public void add(int number) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = number;
    }

    public int get(int index) {
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                return array[i];
            }
        }
        // здесь недочет, так как значение по индексу может быть равно нулю
        return 0;
    }

    public boolean contains(int number) {
        for (int i : array) {
            if (i == number) {
                return true;
            }
        }
        return false;
    }

    public void addAll(int[] newArray) {
        for (int i : newArray) {
            add(i);
        }
    }

    public boolean equals(int[] newArray) {
        boolean check = true;
        if (array.length != newArray.length) {
            check = false;
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != newArray[i]) {
                    check = false;
                }
            }
        }
        return check;
    }

    public void clear() {
        array = new int[0];
    }

    public int indexOf(int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                return i;
            }
        }
        return -1;
    }

    public int getSize() {
        return array.length;
    }

    // быстрая сортировка
    public void quickSort() {
        int startIndex = 0;
        int endIndex = array.length - 1;
        doSort(startIndex, endIndex);
    }

    private void doSort(int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (array[i] <= array[cur])) {
                i++;
            }
            while (j > cur && (array[cur] <= array[j])) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(start, cur);
        doSort(cur + 1, end);
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

}
