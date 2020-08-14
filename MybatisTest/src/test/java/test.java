import com.pan.mapper.UserDao;
import com.pan.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class test {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private String resources;

    @Before
    public void init(){
        resources="SqlMapperConfig.xml";
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resources));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void destroy(){
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void insertUserOne(){
        sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        User user = new User();
        user.setUsername("panjianhao");
        user.setPassword("123456");
        user.setSex("male");
        user.setAddress("beijing");

        try {
            mapper.insertUserOne(user);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }
    }

    @Test
    public void updateUser(){
        sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        User user = new User();
        user.setId(2);
        user.setUsername("panjianhao");
        user.setPassword("123456");
        user.setSex("female");
        user.setAddress("beijing");

        try {
            mapper.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }
    }

    @Test
    public void deleteUser(){
        sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        try {
            mapper.deleteUser(4);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }
    }

    @Test
    public void findUserAll(){
        sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = null;
        try {
            userList = mapper.findAll();
            System.out.println(userList);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }
    }
    @Test
    public void findUserAllTest(){
       
    }
}
