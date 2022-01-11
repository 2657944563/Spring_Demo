package com.example.Dao.DaoImpl;

import com.example.Dao.userDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Repository("userDao")
public class userDaoImpl implements userDao {
    @Override
    public void save() {
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(com.example.SpringConfig.Configuration.class);
        DataSource druid = (DataSource)app.getBean("druid");
        Connection connection = null;
        try {
            connection = druid.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("dao创建了一个Druid的连接池提供给Seriver层调度:" + connection);
        app.close();
    }
}
