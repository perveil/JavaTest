package AlgorithmTest;

public class Steptest {
    public static void main(String[] args) {
        System.out.println(Step(15));
    }

    public static int Step(int AllStep) {
        if (AllStep <= 3) return 1; //小于3的时候就剩下一步就解决
        return Step(AllStep - 1) + Step(AllStep - 2) + Step(AllStep - 3);
    }

}
