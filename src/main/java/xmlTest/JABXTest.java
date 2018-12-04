package xmlTest;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.File;
import java.io.Serializable;
import java.util.Date;

//JavaBean代码

@XmlType(propOrder = {"role","userName","birthDay"})
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
class User implements Serializable {

    private String userName;
    private int age;
    private String role;
    private String bibi;
    private Date birthDay;

    public User() {
    }

    public User(String userName, int age, String role, String bibi,Date date) {
        this.userName = userName;
        this.age = age;
        this.role = role;
        this.bibi = bibi;
        this.birthDay=date;
    }
    @XmlJavaTypeAdapter(DateAdapter.class)
    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @XmlAttribute
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @XmlElement
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @XmlTransient
    public String getBibi() {
        return bibi;
    }

    public void setBibi(String bibi) {
        this.bibi = bibi;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", role='" + role + '\'' +
                ", bibi='" + bibi + '\'' +
                '}';
    }
}

//测试
public class JABXTest {
    public static void saveXmlTest() {
        User user = new User("陈本布衣", 2018, "超级管理员","瞎哔哔",new Date());
        File file = new File("D:\\java\\xml\\user.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            //格式化输出，即按标签自动换行，否则就是一行输出
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //设置编码（默认编码就是utf-8）
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            //是否省略xml头信息，默认不省略（false）
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
            marshaller.marshal(user, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        saveXmlTest();
//        getUserTest();
        User user = new User("陈本布衣", 2018, "超级管理员","瞎哔哔",new Date());
        JABXUtils.convertToXmlB(user,new File("D:\\java\\xml\\user.xml"));
    }


    public static void getUserTest() {
        File file = new File("D:\\java\\xml\\user.xml");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            User user = (User) unmarshaller.unmarshal(file);
            System.out.println(user.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}