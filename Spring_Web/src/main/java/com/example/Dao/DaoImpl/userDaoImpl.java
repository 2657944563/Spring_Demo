package com.example.Dao.DaoImpl;

import com.example.Dao.userDao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Repository("userDao")
public class userDaoImpl implements userDao {
    Connection connection;
    @Override
    public void save() {
        try {
            ApplicationContext app = new AnnotationConfigApplicationContext(com.example.SpringConfig.Configuration.class);
            DataSource druid = (DataSource) app.getBean("druid");
            connection = druid.getConnection();
            System.out.println("dao创建了一个Druid的连接池提供给Seriver层调度:" + connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}