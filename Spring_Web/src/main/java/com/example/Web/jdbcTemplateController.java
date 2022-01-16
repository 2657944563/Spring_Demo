package com.example.Web;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.Utils.webServletUtil;
import com.example.doMain.user;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.sql.SQLException;

@Controller
public class jdbcTemplateController {

    @RequestMapping(value = "/jdbc1",method = RequestMethod.GET)
    @ResponseBody
    public String jdbc1(HttpServletRequest httpServletRequest) throws SQLException {
        ServletContext servletContext = httpServletRequest.getServletContext();
//        DataSource dataSource = (DataSource) webServletUtil.getApplicationContext(servletContext).getBean("druid");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) new ClassPathXmlApplicationContext("spring-mvc.xml").getBean("jdbcTemplate");
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("select id,name,age from work3.user  where id = ?", "1");
        int id;
        String name;
        int age;
        while (sqlRowSet.next()) {
            id = sqlRowSet.getInt("id");
            name = sqlRowSet.getString("name");
            age = sqlRowSet.getInt("age");
            System.out.println("id:  " + id + " name: " + name + " age: " + age);
        }
        return "123";
    }
}
