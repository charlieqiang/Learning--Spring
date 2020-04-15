package kim.spe.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import javax.xml.ws.WebEndpoint;
import java.beans.PropertyVetoException;

/**
 * @author charlie
 * @date 2020/4/15 - 18:49
 * @description
 */
//@Configuration
@ComponentScan(basePackages = {"kim.spe"})
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
