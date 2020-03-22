package leetcode;

public class leetcode12_数字转罗马数字 {
    /*
    * 1-3999 转变至 罗马数字
    * */
    public String intToRoman(int num) {
        // 加法因子分解，使用romans 对应的nums 分解 num
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder stringBuilder = new StringBuilder();
        int index=0;
        while (index < 13) { //遍历nums数组
            // 特别注意：这里是等号
            while (num >= nums[index]) {
                // 注意：这里是等于号，表示尽量使用大的"面值"
                stringBuilder.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return stringBuilder.toString();

    }
}
