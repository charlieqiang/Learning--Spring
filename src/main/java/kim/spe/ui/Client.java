package kim.spe.ui;

import kim.spe.dao.IAccountDao;
import kim.spe.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author charlie
 * @date 2020/4/14 - 21:27
 * @description
 */
public class Client {
    public static void main(String[] args) {
        //get xml
//        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //get bean
//        IAccountService as = (IAccountService) ac.getBean("accountService");
//        IAccountDao adao = (IAccountDao) ac.getBean("accountDao",IAccountDao.class);
//        System.out.println(as);
//        System.out.println(adao);
//        as.saveAccount();
//        ac.close();
    }
}
