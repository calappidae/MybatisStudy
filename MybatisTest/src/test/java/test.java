import com.pan.mapper.UserDao;
import com.pan.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

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
}
