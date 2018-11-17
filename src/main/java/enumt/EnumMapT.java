package enumt;

import java.util.EnumMap;
import java.util.Map;

/*

* */
enum Phase{
    SOLID,
    GAS,
    LIQUID;
    enum Transition{
        Melt;
    }
}
public class EnumMapT {
    public static void main(String[] args) {
        /*
        EnumMap 采用键类型的构造器，是一个泛型的类型令牌
        * */
        EnumMap<Phase,Map<Phase, Phase.Transition>> phaseMapEnumMap=new EnumMap<Phase, Map<Phase, Phase.Transition>>(Phase.class);
    }

}
