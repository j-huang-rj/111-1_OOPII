import java.util.*;

public class W2_HW1 {
    public static void main(String[] args) throws Exception {

        // const
        final int LBOUND = 1;
        final int RBOUND = 100;
        final int LSUBBOUND = 30;
        final int RSUBBOUND = 70;
        final int LENGTH = 10;

        TreeSet<Integer> tSet = new TreeSet<>();
        int[] arr = new int[LENGTH];
        Random rand = new Random();
        int count = 0;
        int temp;

        // get 10 random numbers between 1 ~ 100
        while (count < LENGTH) {
            temp = rand.nextInt(RBOUND);
            while (temp < LBOUND) {
                temp = rand.nextInt(RBOUND);
            }
            arr[count] = temp;
            count++;
        }

        // for-each loop for tSet
        for (int i : arr) {
            tSet.add(i);
        }

        // check for dublicates
        while (tSet.size() < LENGTH) {
            temp = rand.nextInt(RBOUND);
            while (temp < LBOUND) {
                temp = rand.nextInt(RBOUND);
            }
            tSet.add(temp);
        }

        count = 0;
        System.out.printf("電腦從 %d ~ %d 的整數中，亂數取出 %d 個不重複的號碼....\n", LBOUND, RBOUND, LENGTH);
        while (count < LENGTH) {
            System.out.printf("第 %d 個號碼：%d\n", count + 1, arr[count]);
            count++;
        }
        System.out.printf("物件內元素個數為：%d\n", tSet.size());
        System.out.printf("物件內元素的內容：%s\n", tSet);
        System.out.printf("第一個元素內容為：%d\n", tSet.first());
        System.out.printf("最後一個元素內容：%d\n", tSet.last());
        System.out.printf("內容介於 %d ~ %d 者：%s\n", LSUBBOUND, RSUBBOUND, tSet.subSet(LSUBBOUND, RSUBBOUND));
    }
}
