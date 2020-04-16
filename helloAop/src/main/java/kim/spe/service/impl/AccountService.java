package kim.spe.service.impl;

import kim.spe.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * @author charlie
 * @date 2020/4/16 - 20:31
 * @description
 */
@Service("accountService")
public class AccountService implements IAccountService {
    @Override
    public void saveAccount() {
        System.out.println("saved!");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("updated "+i+" time(s)!");
    }

    @Override
    public int deleteAccount() {
        System.out.println("deleted!");
        return 1;
    }
}
