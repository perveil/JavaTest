package AlgorithmTest;

import java.util.Scanner;

/*
 * 输入n个整数,依次输出每个数的约数的个数
 * */
public class submultipleTest {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int num = Integer.parseInt(reader.nextLine()); //拿到要输入字的个数
        String[] AimStr = reader.nextLine().split(" ");
        int[] AimArray = new int[AimStr.length]; //初始化数组
        for (int i = 0; i < AimStr.length; i++) {
            AimArray[i] = Integer.parseInt(AimStr[i]);
            int result = 2;
            for (int j = 2; j < Math.sqrt(AimArray[i]); j++) {
                if (AimArray[i] % j == 0) {
                    result++;
                    if (AimArray[i] / j != j) {
                        result++;
                    }
                }
            }
            System.out.println(result);


        }
    }
}
