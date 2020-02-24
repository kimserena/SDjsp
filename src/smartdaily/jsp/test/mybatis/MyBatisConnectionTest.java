package smartdaily.jsp.test.mybatis;

import org.apache.ibatis.session.SqlSession;

import smartdaily.jsp.dao.MybatisConnectionFactory;



public class MyBatisConnectionTest {
	
	public static void main(String[] args) {
		SqlSession sqlSession = MybatisConnectionFactory.getSqlSession();
		sqlSession.close();
	}

}
