package com.company.project.config;

/**
 * Mybatis & Mapper & PageHelper 配置
 * 单数据源有效
 */
// @Configuration
// public class MybatisConfigurer {
//
//     @Bean
//     public static SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
//         SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
//         factory.setDataSource(dataSource);
//         factory.setTypeAliasesPackage(MODEL_PACKAGE);
//
//         // 配置分页插件，详情请查阅官方文档
//         // PageHelper pageHelper = new PageHelper(); // 5.x版本以下使用
//         PageInterceptor pageInterceptor = new PageInterceptor();
//         Properties properties = new Properties();
//
//         // 分页尺寸为 0 时查询所有纪录不再执行分页
//         properties.setProperty("pageSizeZero", "true");
//
//         // 页码<=0 查询第一页，页码>=总页数查询最后一页
//         properties.setProperty("reasonable", "true");
//
//         // 支持通过 Mapper 接口参数来传递分页参数
//         properties.setProperty("supportMethodsArguments", "true");
//
//         pageInterceptor.setProperties(properties);
//
//         // 添加插件
//         factory.setPlugins(new Interceptor[]{pageInterceptor});
//
//         // 添加XML目录
//         ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//         factory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
//         return factory.getObject();
//     }
//
//     @Bean
//     public static MapperScannerConfigurer mapperScannerConfigurer() {
//         MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//         mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
//         mapperScannerConfigurer.setBasePackage(MAPPER_PACKAGE);
//
//         // 配置通用Mapper，详情请查阅官方文档
//         Properties properties = new Properties();
//         properties.setProperty("mappers", MAPPER_INTERFACE_REFERENCE);
//
//         // insert、update是否判断字符串类型!='' 即 test="str != null"表达式内是否追加 and str != ''
//         properties.setProperty("notEmpty", "false");
//         properties.setProperty("IDENTITY", "MYSQL");
//         mapperScannerConfigurer.setProperties(properties);
//
//         return mapperScannerConfigurer;
//     }
// }

