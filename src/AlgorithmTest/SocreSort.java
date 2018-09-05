package AlgorithmTest;

import java.util.*;

/*
 *题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
 * */
public class SocreSort {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int num = Integer.parseInt(reader.nextLine()); //拿到要输入的行数
        int Selected = Integer.parseInt(reader.nextLine()); //升序还是降序
        Map<String, Integer> Students = new HashMap<>();
        for (int i = 0; i < num; i++) {
            String a = reader.nextLine();
            String[] result = a.split(" ");
            Students.put(result[0], Integer.parseInt(result[1]));
        }
        //  Map==>List
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(Students.entrySet());
        switch (Selected) {
            case 1: //正序
                Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o1.getValue() - o2.getValue();
                    }
                });
                break;
            case 0: //反序
                Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o2.getValue() - o1.getValue();
                    }
                });

                break;
            default:
                break;
        }
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
