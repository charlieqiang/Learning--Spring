package kim.spe.proxy;

/**
 * @author charlie
 * @date 2020/4/16 - 14:19
 * @description
 */
public interface IProducer {
    /**
     *
     * @param money
     */
    public void saleProduct(float money);

    /**
     *
     * @param money
     */
    public void afterService(float money);
}
