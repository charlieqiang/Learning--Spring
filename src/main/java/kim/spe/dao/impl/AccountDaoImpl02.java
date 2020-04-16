package kim.spe.dao.impl;

import kim.spe.dao.IAccountDao;
import kim.spe.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author charlie
 * @date 2020/4/15 - 14:46
 * @description
 */
//@Repository("accountDao02")
public class AccountDaoImpl02 implements IAccountDao {
    @Override
    public List<Account> findAllAccount() {
        return null;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return null;
    }

    @Override
    public void saveAccount(Account account) {

    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public void deleteAccount(Integer accountId) {

    }

    @Override
    public Account findAccountByName(String accountName) {
        return null;
    }
//    @Override
//    public void saveAccount() {
//        System.out.println("Dao02 help you saved account!");
//    }
}
