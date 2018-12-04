package serializeTes;

import com.sun.javafx.util.TempState;

import java.io.*;

public class Tes1 implements Serializable {
    static final long serialVersionUID=3l; //serialVersionUID 指的是序列化版本ID，每修改一次代码就必须修改版本号
    private String username;
    private String password;
    private Integer age;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    Tes1(String username, String password,Integer age){
        this.password=password;
        this.username=username;
        this.age=age;
    }
    // 为需要序列化的类添加以下两个方法,实现自定义的序列化，从而区别默认序列化的物理表示法和逻辑数据的区别
    //默认的序列化方式在物理表示法不等于逻辑数据的情况下时不适用的
    private  void writeObject(ObjectOutputStream s)throws IOException {
        s.defaultWriteObject();
      //
    }
    private  void readObject(ObjectInputStream i)throws IOException{
      //
    }
    public static void main(String[] args) {
        try {
            Tes1 man = new Tes1("huhx", "123456",19);
            File file=new File("C:\\Users\\Administrator\\IdeaProjects\\JavaTest\\src\\main\\java\\serializeTes\\output.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(man);
//            ObjectInputStream  objectInputStream=new ObjectInputStream(new FileInputStream(file));
//            Tes1 newMan=(Tes1) objectInputStream.readObject();
//            System.out.println(newMan.password);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
