package ExceptionTes;

public class throwTes {
    public void A() throws Exception { // 被调用函数 如果不对异常进行处理，则向调用者函数抛出
        throw new Exception("s");
    }
    public  void B() {
        //如果被调用函数不处理异常，则调用函数必须处理异常，如果处理不了继续抛出，让上一级函数继续处理
        try{
            A();
        }catch (Exception e){

        }
    }
}
