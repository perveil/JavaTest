package keywordTest;

/*
代码执行顺序：

* */
public class CodeOrderTest {
    public static void main(String[] args) {
        System.out.println(new B().getValue());
    }
}

class A {
    protected int value;

    public A(int v) {
        setValue(v);
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        try {
            value++;
            return value;
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            this.setValue(value);
            System.out.println(value);
        }
        return value;
    }
}

class B extends A {
    public B() {
        super(5);
        setValue(getValue() - 3);
    }

    public void setValue(int value) {
        super.setValue(2 * value);
    }
}
