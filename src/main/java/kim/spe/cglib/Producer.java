package kim.spe.cglib;

import kim.spe.proxy.IProducer;

/**
 * @author charlie
 * @date 2020/4/16 - 14:18
 * @description
 */
public class Producer{

    public void saleProduct(float money) {
        System.out.println("sell and get "+money);
    }

    public void afterService(float money) {
        System.out.println("slove and get "+money);
    }
}
