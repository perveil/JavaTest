package enumt;

public class enumT {
    public static void main(String[] args) {
        for (Opreation o: Opreation.values()) {
            System.out.println(o);
        }
        /*
        * enum 一共有两个方法，values、valueOf  valueOf 是根据 常量名获取的，但是如果你重写了toString方法，说明你有更好的一种表示方法，
        * 必须配套的实现一个Map，和一个formString方法。
        * */
        Opreation.formString("/");
//        Opreation.valueOf("PLUS");
//        Opreation.valueOf("/");
        System.out.println(Opreation.formString("/"));
        System.out.println(Opreation.PLUS.getNumber());

    }
}
