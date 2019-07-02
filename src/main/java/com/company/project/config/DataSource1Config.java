package com.company.project.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.Properties;

import static com.company.project.core.ProjectConstant.MODEL_PACKAGE;

@Configuration
@MapperScan(basePackages = "com.company.project.dao.db1", sqlSessionTemplateRef = "db1SqlSessionTemplate")
public class DataSource1Config {
    @Bean(name = "db1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.db1")
    @Primary
    public DruidDataSource db1DataSource() {
        return DruidDataSourceBuilder.create().build();
    }

    @SuppressWarnings("Duplicates")
    @Bean(name = "db1SqlSessionFactory")
    @Primary
    public static SqlSessionFactory db1sqlSessionFactory(@Qualifier("db1DataSource") DruidDataSource druidDataSource) throws Exception {
        // SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        // bean.setDataSource(druidDataSource);
        // bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        // return bean.getObject();

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(druidDataSource);
        bean.setTypeAliasesPackage(MODEL_PACKAGE);

        // 配置分页插件，详情请查阅官方文档
        // PageHelper pageHelper = new PageHelper(); // 5.x版本以下使用
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();

        // 分页尺寸为 0 时查询所有纪录不再执行分页
        properties.setProperty("pageSizeZero", "true");

        // 页码<=0 查询第一页，页码>=总页数查询最后一页
        properties.setProperty("reasonable", "true");

        // 支持通过 Mapper 接口参数来传递分页参数
        properties.setProperty("supportMethodsArguments", "true");

        pageInterceptor.setProperties(properties);

        // 添加插件
        bean.setPlugins(new Interceptor[]{pageInterceptor});

        // 添加 xml 目录
        // bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "db1TransactionManager")
    @Primary
    public static DataSourceTransactionManager db1TransactionManager(@Qualifier("db1DataSource") DruidDataSource druidDataSource) {
        return new DataSourceTransactionManager(druidDataSource);
    }

    @Bean(name = "db1SqlSessionTemplate")
    @Primary
    public static SqlSessionTemplate db1SqlSessionTemplate(@Qualifier("db1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
