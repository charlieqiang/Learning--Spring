package kim.spe.service.impl;

import kim.spe.dao.IAccountDao;
import kim.spe.dao.impl.AccountDaoImpl;
import kim.spe.domain.Account;
import kim.spe.service.IAccountService;
import kim.spe.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.*;

/**
 * @author charlie
 * @date 2020/4/15 - 8:51
 * @description
 */
@Service(value = "accountService")
//@Scope("prototype")
public class AccountServiceImpl implements IAccountService {
//    @Autowired
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {

        return accountDao.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {

        accountDao.saveAccount(account);

    }

    @Override
    public void updateAccount(Account account) {

        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer accountId) {

        accountDao.deleteAccount(accountId);

    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {

        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targetName);
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);
        accountDao.updateAccount(source);
        accountDao.updateAccount(target);

    }

//    @Override
//    public void saveAccount02() {
//        System.out.println("saved!");
//    }
//
//    @Override
//    public void updateAccount02(int i) {
//        System.out.println("update "+i+" times");
//    }
//
//    @Override
//    public int deleteAccount02() {
//        System.out.println("delete!");
//        return 0;
//    }

    /**
    //property
//    private String name;
//    private Integer age;
//    private Date birthday;
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }


    private String[] myStrs;
    private List<String> myList;
    private Set<String> mySet;
    private Map<String, String> myMap;
    private Properties myProps;

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }



//    public AccountServiceImpl(String name, Integer age, Date birthday){
//        this.name = name;
//        this.age = age;
//        this.birthday = birthday;
//    }

//    public IAccountDao accountDao = new AccountDaoImpl();
//    @Autowired
//    @Qualifier("accountDao01")
    @Resource(name = "accountDao01")
    private IAccountDao accountDao = null;
//    public AccountServiceImpl(String name){
//        System.out.println(name+" is created!");
//    }
//
    public AccountServiceImpl() {
        System.out.println("obj is created!");
    }

    @Override
    public void saveAccount() {

        accountDao.saveAccount();
//        System.out.println("saved!");
//        System.out.println("service help you saved msg:"+name+","+age+","+birthday+".");
//        System.out.println(Arrays.toString(myStrs));
//        System.out.println(myList);
//        System.out.println(mySet);
//        System.out.println(myMap);
//        System.out.println(myProps);

    }

    @PostConstruct
    public void init() {
        System.out.println("obj is init!");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("obj is destory!");
    }
     **/
}
