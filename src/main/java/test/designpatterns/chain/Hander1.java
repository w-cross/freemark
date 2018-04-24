package test.designpatterns.chain;

public class Hander1 extends BaseChainHandler {

    @Override
    void handle(int i) {
        if (i<4){
            System.out.println("不需要经过责任链");
        } else {
            getBaseChainHandler().handle(i);
        }
    }
}
