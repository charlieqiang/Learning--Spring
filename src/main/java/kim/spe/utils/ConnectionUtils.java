package kim.spe.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author charlie
 * @date 2020/4/16 - 10:53
 * @description
 */
public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * get connection
     * @return
     */
    public Connection getThreadConnection(){

        try {
            //1.get conn from ThreadLocal
            Connection connection = tl.get();
            //2.check has conn
            if(connection == null){
                //3.get link from source, store in tl
                connection = dataSource.getConnection();
                tl.set(connection);
            }
            //4.ret
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeConnection(){
        tl.remove();
    }
}
