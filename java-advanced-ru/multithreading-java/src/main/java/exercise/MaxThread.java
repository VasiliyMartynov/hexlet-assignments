package exercise;

import java.util.*;

import static exercise.App.LOGGER;

// BEGIN
public class MaxThread extends Thread {

    int[] numbers;
    ArrayList<Integer> sortedNumbers = new ArrayList<Integer>();
    MaxThread(int[] input) {
        this.numbers = input;
    }
    @Override
    public void run() {
        LOGGER.info("start tread max");
        for (int i = 0; i < numbers.length; i++) {
            this.sortedNumbers.add(i, numbers[i]);
        }
        this.sortedNumbers.sort(Comparator.naturalOrder());
        System.out.println(this.sortedNumbers);
        LOGGER.info("finish tread max");
    }

    public int getMax() {
        return this.sortedNumbers.get(sortedNumbers.size() - 1);
    }
}
// END
