package kim.spe.test;

import kim.spe.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author charlie
 * @date 2020/4/16 - 20:42
 * @description
 */
public class AOPTest {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("Bean.xml");
        IAccountService as = (IAccountService) ac.getBean("accountService");
        as.saveAccount();
//        as.updateAccount(1);
//        as.deleteAccount();
    }
}
