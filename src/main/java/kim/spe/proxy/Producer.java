package kim.spe.proxy;

/**
 * @author charlie
 * @date 2020/4/16 - 14:18
 * @description
 */
public class Producer implements IProducer{

    @Override
    public void saleProduct(float money) {
        System.out.println("sell and get "+money);
    }

    @Override
    public void afterService(float money) {
        System.out.println("slove and get "+money);
    }
}
