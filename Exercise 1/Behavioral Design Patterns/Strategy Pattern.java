// StrategyPattern.java
import java.util.Arrays;

interface SortStrategy {
    void sort(int[] array);
}

class BubbleSort implements SortStrategy {
    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}

class QuickSort implements SortStrategy {
    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}

class Context {
    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(int[] array) {
        strategy.sort(array);
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        Context context = new Context();

        int[] array = {5, 2, 8, 6, 3};

        context.setStrategy(new BubbleSort());
        context.executeStrategy(array);
        System.out.println("Bubble Sorted: " + Arrays.toString(array));

        array = new int[]{5, 2, 8, 6, 3};

        context.setStrategy(new QuickSort());
        context.executeStrategy(array);
        System.out.println("Quick Sorted: " + Arrays.toString(array));
    }
}
