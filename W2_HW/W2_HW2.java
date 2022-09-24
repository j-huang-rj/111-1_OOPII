import java.util.*;

public class W2_HW2 {
    public static void main(String[] args) throws Exception {

        HashMap<Integer, String> hMap = new HashMap<>();
        hMap.put(1, "January");
        hMap.put(2, "Febuary");
        hMap.put(3, "March");
        hMap.put(4, "April");
        hMap.put(5, "May");
        hMap.put(6, "June");
        hMap.put(7, "July");
        hMap.put(8, "August");
        hMap.put(9, "September");
        hMap.put(10, "October");
        hMap.put(11, "November");
        hMap.put(12, "December");
        Scanner sc = new Scanner(System.in);
        int input;

        System.out.print("請輸入 1 ~ 12 ？ ");
        input = sc.nextInt();

        // handle invalid input
        while (input < 1 || input > 12) {
            System.out.println("範圍錯誤！");
            System.out.print("請輸入 1 ~ 12 ？ ");
            input = sc.nextInt();
        }

        sc.close();
        System.out.printf("第 %d 月的英文單字為 %s", input, hMap.get(input));
    }
}
