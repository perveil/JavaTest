package xmlTest;
import javax.xml.bind.*;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.io.File;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class DateAdapter extends XmlAdapter<String, Date>{
    private static final DateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Date unmarshal(String v) throws Exception {
        return SDF.parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return SDF.format(v);
    }
}

public class JABXUtils {

    public static void convertToXml(Object obj, File file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            //格式化输出，即按标签自动换行，否则就是一行输出
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //设置编码（默认编码就是utf-8）
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            //是否省略xml头信息，默认不省略（false）
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
            marshaller.marshal(obj, file);
            //控制台输出
            marshaller.marshal(obj,System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    public static <T> T convertToJavaBean(Class<T> clz, File file) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clz);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            T t = (T) unmarshaller.unmarshal(file);
            return t;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void convertToXmlB(Object obj, File file) {
        JAXB.marshal(obj,file);
    }

    public static <T> T convertToJavaBeanB(Class<T> clz, File file) {
        return JAXB.unmarshal(file, clz);
    }
}
