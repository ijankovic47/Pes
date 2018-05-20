package konami.pes.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.poi.util.SystemOutLogger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="konami.pes")
@EnableTransactionManagement
public class HibernateConfiguration {

//	@Bean(name="dataSource")
//	public DataSource getDataSource(){
//		BasicDataSource dataSource = new BasicDataSource();
//		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
//		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
//		dataSource.setUsername("proevolutionsoccer");
//		dataSource.setPassword("konami");
//		return dataSource;		
//	}
	@Bean(name="dataSource")
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://192.168.1.21:3306/proevolutionsoccerstage?user=ivan&password=12101993&useUnicode=true&characterEncoding=UTF-8");
		dataSource.setUsername("ivan");
		dataSource.setPassword("12101993");
		return dataSource;		
	}
	

//   CREATE SEQUENCE  "BEOHIVE"."HIBERNATE_SEQUENCE"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;
	 	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder sessionFactory = new LocalSessionFactoryBuilder(dataSource);
	//	sessionFactory.addAnnotatedClass(Partner.class).addAnnotatedClass(Operater.class).addAnnotatedClass(ModelUr.class);
		//sessionFactory.scanPackages("konami.pes.domain");
		sessionFactory.addProperties(getHibernateProperties());
		SessionFactory sf=sessionFactory.buildSessionFactory();
		System.out.println(sf.isClosed()+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		return sf;
	}
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		System.out.println(sessionFactory.isClosed()+ "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		HibernateTransactionManager txManager = new HibernateTransactionManager(sessionFactory);
		return txManager;
	}
	
//	@Autowired
//	@Bean(name="userDaoImpl")
//	public UserDao getUserDao(SessionFactory sessionFactory){
//		UserDaoImpl userDao = new UserDaoImpl(sessionFactory);
//		return userDao;
//	}	
	
	private Properties getHibernateProperties(){
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		//hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create");
		return hibernateProperties;	
	}
}
