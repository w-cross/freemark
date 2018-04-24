package test.designpatterns.chain;

/**
 * 责任链模式
 * 1.每个责任者都可以处理请求
 * 2.不知道前提是哪个处理请求
 */
public abstract class BaseChainHandler {

    private BaseChainHandler baseChainHandler;
    public void setNextHandler(BaseChainHandler baseChainHandler){
        this.baseChainHandler = baseChainHandler;
    }

    /**
     * Getter method for property <tt>baseChainHandler</tt>.
     *
     * @return property value of baseChainHandler
     */
    public BaseChainHandler getBaseChainHandler() {
        return baseChainHandler;
    }

    abstract void handle(int i);
}
