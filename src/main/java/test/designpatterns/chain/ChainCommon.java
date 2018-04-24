package test.designpatterns.chain;


import java.util.ArrayList;
import java.util.List;

public class ChainCommon {
    public static List<BaseChainHandler> list = new ArrayList<BaseChainHandler>();
    private static BaseChainHandler baseChainHandler1;
    private static BaseChainHandler baseChainHandler2 ;
    static {
        baseChainHandler1 = new Hander1();
        baseChainHandler2 = new Hander2();
        baseChainHandler1.setNextHandler(baseChainHandler2);
        list.add(baseChainHandler1);
        list.add(baseChainHandler2);
    }


}
