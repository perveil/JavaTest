package niuKE;

import java.util.Scanner;

public class niuke {
    public static void Scanner(){
        Scanner scanner = new Scanner(System.in);
        int line = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < line; i++) {
            System.out.println(scanner.nextLine().replaceAll("(.)\\1+","$1$1").replaceAll("(.)\\1(.)\\2","$1$1$2"));
        }
    }
    /*
    * 有一头母牛，每年生一头母牛，生下来的小母牛三年之后就继续能生母牛
    * n 年有多少头母牛;
    * */


    public static void main(String[] args) {

    }
}
