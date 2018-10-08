package desginModel;
interface Target{
    public void sampleOperation1();
    public void sampleOperation2();
}
class Adaptee{
    public void sampleOperation1(){

    }
}
class Apaptee2 extends Adaptee{


}


public class Adapter extends Adaptee implements Target {
    Apaptee2 apaptee2=new Apaptee2();


    @Override
    public void sampleOperation2() {

    }
}
