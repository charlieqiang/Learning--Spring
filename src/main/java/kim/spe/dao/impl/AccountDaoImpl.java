package kim.spe.dao.impl;

import kim.spe.dao.IAccountDao;
import kim.spe.domain.Account;
import kim.spe.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author charlie
 * @date 2020/4/15 - 8:51
 * @description
 */
//@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {


    //    @Autowired
    private QueryRunner runner;
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }
        public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public List<Account> findAllAccount() {

        try {
            return runner.query(connectionUtils.getThreadConnection(),"select * from tbl_employee", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            return runner.query(connectionUtils.getThreadConnection(),"select * from tbl_employee where id = ?", new BeanHandler<Account>(Account.class), accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(),"insert into tbl_employee (last_name, money) values (?, ?)", account.getLast_name(), account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(),"update tbl_employee set last_name=?, money=? where id = ?", account.getLast_name(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            runner.update(connectionUtils.getThreadConnection(),"delete from tbl_employee where id = ?", accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountByName(String accountName) {
        try {
            List<Account> accounts = runner.query(connectionUtils.getThreadConnection(),"select * from tbl_employee where last_name = ?", new BeanListHandler<Account>(Account.class), accountName);
            if (accounts == null || accounts.size() == 0){
                return null;
            }
            if (accounts.size() > 1){
                throw new RuntimeException("resultSet not alone!");
            }
            return accounts.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
//    @Override
//    public void saveAccount() {
//        System.out.println("Dao01 help you saved account!");
//    }
}
