package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.domain.Category;
import com.niit.domain.Product;
import com.niit.domain.Supplier;
import com.niit.domain.User;

@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:mysql.properties", "classpath:oracle.properties" })

public class ApplicationContextConfiguration {

	@Value("${mysql.dc}")
	private String driverClass;

	@Value("${mysql.url}")
	private String url;

	@Value("${mysql.un}")
	private String username;

	@Value("${mysql.pw}")
	private String password;

	/*
	 * @Profile("qa")
	 * 
	 * @Bean(name = "dataSource") public DataSource getDataSource1() {
	 * 
	 * BasicDataSource datasource = new BasicDataSource();
	 * dataSource.setDriverClassName(driverClass); dataSource.setUrl(url);
	 * dataSource.setUsername(username); dataSource.setPassword(password);
	 * dataSource.setInitialSize(5); dataSource.setMaxActive(10); return
	 * dataSource; }
	 */

	
	 @Profile("production")
	 @Bean(name = "prddataSource") 
	 public DataSource getproductionDataSource() {
	
	 JndiObjectFactoryBean jndiObjectFactoryBean=new JndiObjectFactoryBean();
	 jndiObjectFactoryBean.setJndiName("java:comp/env/jdbc/ecommerceDS");
	 jndiObjectFactoryBean.setResourceRef(true);
	 jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
	 System.out.println("Production Datasource  with JNDI LookUp is ready!!");
	 return (DataSource)jndiObjectFactoryBean.getObject();
	 
	 }
	 
/*	@Profile("production")
	@Bean(name = "dataSource")
	public DataSource getproductionDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
*/
	/*@Profile("development")
	@Bean(name = "devdataSource")
	public DataSource getDataSource3() {

		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("classpath:schema.sql")
				.addScript("classpath:test-data.sql").build();

	}
*/
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("connection.datasource", "");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(@Qualifier("prddataSource") DataSource datasource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(datasource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.scanPackages("com.niit.*");
		sessionBuilder.addAnnotatedClasses(User.class, Product.class, Category.class, Supplier.class);

		return sessionBuilder.buildSessionFactory();

	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

	// externalizing Properties
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	// mail
	@Bean
	public JavaMailSender javaMailSender() {

		JavaMailSenderImpl mailsender = new JavaMailSenderImpl();
		mailsender.setHost("smtp.gmail.com");
		mailsender.setPort(465);
		// set emailId
		mailsender.setUsername("dipendra.eng@gmail.com");
		// set emailPassword
		mailsender.setPassword("");

		Properties prop = mailsender.getJavaMailProperties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.startsssl.enable", "true");

		// prop.put("mail.debug", "true");

		return mailsender;

	}

}
