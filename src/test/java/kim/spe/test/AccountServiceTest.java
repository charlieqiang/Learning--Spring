package kim.spe.test;

import kim.spe.config.SpringConfiguration;
import kim.spe.domain.Account;
import kim.spe.service.IAccountService;
import kim.spe.service.impl.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author charlie
 * @date 2020/4/15 - 16:41
 * @description
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)

public class AccountServiceTest {

//    private ApplicationContext ac;
    @Autowired
    private IAccountService as = null;
//    @Before
//    public void init(){
//        ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        as = ac.getBean("accountService", IAccountService.class);
//
//    }
    @Test
    public void testFindAll() {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        IAccountService as = ac.getBean("accountService", IAccountService.class);
        Account account = as.findAccountById(5);
        System.out.println(account);
    }

    @Test
    public void testSave() {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        IAccountService as = ac.getBean("accountService", IAccountService.class);
        Account account = new Account();
        account.setLast_name("spring");
        account.setMoney(5678f);
        as.saveAccount(account);
//        System.out.println(account);
    }

    @Test
    public void testUpdate() {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        IAccountService as = ac.getBean("accountService", IAccountService.class);
        Account account = as.findAccountById(5);
        account.setMoney(23456f);
        as.updateAccount(account);

    }

    @Test
    public void testDelete() {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        IAccountService as = ac.getBean("accountService", IAccountService.class);
        as.deleteAccount(5);
//        System.out.println(account);
    }
}
