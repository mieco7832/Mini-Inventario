package com.miec.utils;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
public class Configs {
	
	// !Datasource conexión a la base de datos
	@Bean
	public DataSource getData() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/inventario?useSSL=false");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	// !Propiedades de hibernate SessionFactory
	private Properties getPro() {
		Properties p = new Properties();
		p.setProperty("hibernet.dialect","org.hibernate.dialect.MySQLDialect");
		return p;
	}
	// !Construcción de la variabe SF
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sF = new LocalSessionFactoryBean();
		sF.setDataSource(getData());
		sF.setHibernateProperties(getPro());
		sF.setPackagesToScan("com.miec.entity");
		return sF;
	}
	
	// Activar Trasacciones
	@Bean
	public PlatformTransactionManager getTrans() {
		HibernateTransactionManager  hib = new HibernateTransactionManager();
		hib.setSessionFactory(sessionFactory().getObject());
		return hib;
	}
	
}
