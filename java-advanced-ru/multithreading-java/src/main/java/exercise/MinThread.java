package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static exercise.App.LOGGER;

// BEGIN
public class MinThread extends Thread {
    int[] numbers;
    ArrayList<Integer> sortedNumbers = new ArrayList<Integer>();
    MinThread(int[] input) {
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

    public int getMin() {
        return this.sortedNumbers.get(0);
    }
}
// END
