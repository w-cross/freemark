package test.designpatterns.chain;


import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<BaseChainHandler> list = ChainCommon.list;
        for (BaseChainHandler data : list){
            //设置一个
            data.handle(5);
        }
    }
}
