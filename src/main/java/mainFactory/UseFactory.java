package mainFactory;/*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         ���汣��       ����BUG
         Create by Caesar,2016/6/7
*/

import dto.User;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class UseFactory {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        SqlSession sqlSession=null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession=sqlSessionFactory.openSession();

            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            User user =userMapper.selectOne();
            System.out.println(user);

            User user1=sqlSession.selectOne("mapper.UserMapper.selectOne");
            System.out.println(user1);

            User user2=userMapper.findOne();
            System.out.println(user2);



//            SqlSessionFactoryBuilder
//
//            �������Ա�ʵ������ʹ�úͶ�����һ�������� SqlSessionFactory���Ͳ�����Ҫ���ˡ���� SqlSessionFactoryBuilder ʵ������ѷ�Χ�Ƿ�����Χ��Ҳ���Ǿֲ���������������������� SqlSessionFactoryBuilder ��������� SqlSessionFactory ʵ����������û��ǲ�Ҫ����һֱ�����Ա�֤���е� XML ������Դ���Ÿ�����Ҫ�����顣
//
//            SqlSessionFactory
//
//            SqlSessionFactory һ����������Ӧ����Ӧ�õ������ڼ�һֱ���ڣ�û���κ����ɶ�������������ؽ���ʹ�� SqlSessionFactory �����ʵ������Ӧ�������ڼ䲻Ҫ�ظ�������Σ�����ؽ� SqlSessionFactory ����Ϊһ�ִ��롰��ζ����bad smell��������� SqlSessionFactory ����ѷ�Χ��Ӧ�÷�Χ���кܶ෽��������������򵥵ľ���ʹ�õ���ģʽ���߾�̬����ģʽ��
//
//            SqlSession
//
//            ÿ���̶߳�Ӧ�������Լ��� SqlSession ʵ����SqlSession ��ʵ�������̰߳�ȫ�ģ�����ǲ��ܱ�����ģ�����������ѵķ�Χ������򷽷���Χ�����Բ��ܽ� SqlSession ʵ�������÷���һ����ľ�̬������һ�����ʵ������Ҳ���С�Ҳ�����ܽ� SqlSession ʵ�������÷����κ����͵Ĺ���Χ�У����� Serlvet �ܹ��е� HttpSession���������������ʹ��һ�� Web ��ܣ�Ҫ���� SqlSession ����һ���� HTTP ����������Ƶķ�Χ�С����仰˵��ÿ���յ��� HTTP ���󣬾Ϳ��Դ�һ�� SqlSession������һ����Ӧ���͹ر���������رղ����Ǻ���Ҫ�ģ���Ӧ�ð�����رղ����ŵ� finally ������ȷ��ÿ�ζ���ִ�йرա������ʾ������һ��ȷ�� SqlSession �رյı�׼ģʽ��

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }

    }
}
