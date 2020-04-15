package kim.spe.factory;

import kim.spe.service.impl.AccountServiceImpl;

/**
 * @author charlie
 * @date 2020/4/15 - 10:08
 * @description
 */
public class StaticFactory {
    public static AccountServiceImpl getAccountService(){

//        return new AccountServiceImpl();
        return null;
    }
}
