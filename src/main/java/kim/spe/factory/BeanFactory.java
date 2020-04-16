package kim.spe.factory;

import kim.spe.domain.Account;
import kim.spe.service.IAccountService;
import kim.spe.utils.TransactionManager;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * @author charlie
 * @date 2020/4/16 - 15:12
 * @description
 */
public class BeanFactory {

    private IAccountService accountService;
    private TransactionManager txManager;

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public final void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    /**
     * get proxy
     * @return
     */
    public IAccountService getAccountService(){
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                Object rtValue = null;

                try {
                    //begin
                    txManager.beginTransaction();
                    //run
                    rtValue = method.invoke(accountService, objects);
                    //commit
                    txManager.commit();
                    //return
                    return rtValue;
                } catch (Exception e) {
                    //rollback
                    txManager.rollback();
                    e.printStackTrace();
                    throw new RuntimeException();
                } finally {
                    //close
                    txManager.release();
                }
            }
        });
    }
}
