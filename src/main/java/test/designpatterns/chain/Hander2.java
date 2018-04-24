package test.designpatterns.chain;

public class Hander2 extends BaseChainHandler {

    @Override
    void handle(int i) {
        if (i>4){
            System.out.println("handle2进行了处理！");
        } else {
            getBaseChainHandler().handle(i);
        }
    }
}
