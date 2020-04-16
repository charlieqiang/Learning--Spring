package kim.spe.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author charlie
 * @date 2020/4/16 - 14:23
 * @description
 */
public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();
//        producer.saleProduct(1000f);
        IProducer proxyProducer = (IProducer)Proxy.newProxyInstance(producer.getClass().getClassLoader(), producer.getClass().getInterfaces(), new InvocationHandler() {
            /**
             *
             * @param proxy
             * @param method
             * @param args
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Float money = (Float)args[0];
                Object returnValue = null;
                if ("saleProduct".equals(method.getName())){
                    returnValue = method.invoke(producer, money*0.8f);
                }
                return returnValue;
            }
        });
        proxyProducer.saleProduct(10000f);
    }
}
