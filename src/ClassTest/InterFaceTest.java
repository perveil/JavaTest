package ClassTest;

/*
 *接口中的方法默认是 public abstract 不能，是static或者final
 * 不能是static是因为类方法必须加载完全，接口是抽象的，不经过类加载
 * 不能是final  接口的本质作用是子类重写接口中的方法，如果可以是final，前后矛盾
 *
 * 接口中的变量 默认是 public final static
 * 实现此接口的类可以引用此变量
 *
 * */
public interface InterFaceTest {
    public abstract void Inherit();

    final static int k = 10;  // public、abstract

    static void StaticMethod() {
    } //java.1.8可以对接口的方法声明为static：only public, abstract, default, static and strictfp are permitted
//    protected void protectedmethod(); protected 标识符是针对继承而言的，而接口注重实现而不是继承
}

class In implements InterFaceTest {

    @Override
    public void Inherit() {  //实现接口时，实现的方法必须是public的

    }

    public static void main(String[] args) {
        In test = new In();
        int i = test.k;
        System.out.println(i);
    }
}


