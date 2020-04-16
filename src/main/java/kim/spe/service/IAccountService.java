package kim.spe.service;

import kim.spe.domain.Account;

import java.util.List;

/**
 * @author charlie
 * @date 2020/4/14 - 21:16
 * @description
 */
public interface IAccountService {
    /**
     * query all
     * @return
     */
    List<Account> findAllAccount();

    /**
     * query by id
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * add
     * @param account
     */
    void saveAccount(Account account);

    /**
     * update
     * @param account
     */
    void updateAccount(Account account);

    /**
     * delete
     * @param accountId
     */
    void deleteAccount(Integer accountId);

    /**
     *
     * @param sourceName
     * @param targetName
     * @param money
     */
    void transfer(String sourceName, String targetName, Float money);


}
