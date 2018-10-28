package com.gvt.ika.conf;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Map;
import java.util.Properties;

@Configuration
@EntityScan(basePackages={"com.gvt.ika.app.entity.bo"})
public class DatabaseConfiguration {


    final private static Logger LOGGER			= Logger.getLogger(DatabaseConfiguration.class);

    @Value("${spring.jdbc.driverClass}")
    public String				driverClass;

    @Value("${spring.jdbc.url}")
    public String				jdbcUrl;

    @Value("${spring.jdbc.user}")
    public String				user;

    @Value("${spring.jdbc.password}")
    public String				password;

    @Value("${preferredTestQuery}")
    public String				preferredTestQuery;

    @Value("${spring.jdbc.schema}")
    public String				schema;

    @Value("${generateHbm2ddl}")
    public Boolean				generateHbm2ddl;

    @Value("${generateHbm2ddlAuto}")
    public String				generateHbm2ddlAuto;

    @Value("${showDdl}")
    public Boolean				showDdl;

    public String[]				packagesToScan	= new String[]
            { "com.gvt.ika.app.entity.bo" };

    @Bean
    public DataSource dataSource()
    {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try
        {
            dataSource.setDriverClass(driverClass);
        }
        catch (PropertyVetoException e)
        {
            e.printStackTrace();
        }
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(jdbcUrl + "/" + schema + "?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true");
        dataSource.setInitialPoolSize(3);
        dataSource.setMinPoolSize(3);
        dataSource.setMaxPoolSize(20);
        dataSource.setAcquireIncrement(3);
        dataSource.setMaxIdleTime(1800);
        dataSource.setMaxIdleTimeExcessConnections(600);
        dataSource.setPreferredTestQuery(preferredTestQuery);
        dataSource.setIdleConnectionTestPeriod(180);
        //dataSource.setTestConnectionOnCheckin(true);
        //dataSource.setTestConnectionOnCheckout(true);
        return dataSource;
    }

    @Bean(name = "entityManager")
    public EntityManager entityManager()
    {
        return entityManagerFactory().createEntityManager();
    }

    @Bean(name = "entityManagerFactory")
    public EntityManagerFactory entityManagerFactory()
    {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(generateHbm2ddl);
        vendorAdapter.setShowSql(showDdl);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan(packagesToScan);
        factory.setDataSource(dataSource());
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.hbm2ddl.auto", generateHbm2ddlAuto);
        jpaProperties.put("hibernate.show_sql", showDdl);
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        // jpaProperties.put("hibernate.default_schema", schema);
        jpaProperties.put("hibernate.connection.autocommit", false);
        factory.setJpaProperties(jpaProperties);
        Map<String, Object> jpaPropertyMap = factory.getJpaPropertyMap();
        factory.setJpaPropertyMap(jpaPropertyMap);
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager()
    {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
        return jpaTransactionManager;
    }

}
