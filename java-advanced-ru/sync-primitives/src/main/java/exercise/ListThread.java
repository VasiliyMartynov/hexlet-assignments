package exercise;

import static java.lang.Thread.sleep;

// BEGIN
public class ListThread extends Thread{
    private SafetyList safetyList;
    ListThread (SafetyList list) {
        this.safetyList = list;


    }
    @Override
    public void run() {
        for(int i = 1; i <= 1000; i++) {
            try {
                sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            safetyList.add(i);
            System.out.println(safetyList.get(i));
        }
    }
}
// END
