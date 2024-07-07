package com.zyh.MyCodeGenerator;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.zyh.utils.GetPropertiesValue;

import java.io.IOException;
import java.util.*;

/**
 * @author: zyh
 * @date:
 * @Version: 1.0
 * @Description:
 */
@SuppressWarnings("all")
public class MyCodeGenerator {
    public static void main(String[] args) throws IOException {
        GetPropertiesValue getPropertiesValue = new GetPropertiesValue();
        Map<String, String> properties = getPropertiesValue.getProperties();
        // 获取数据库连接信息
        String URL = properties.get("url");
        String DRIVER_NAME = properties.get("driverName");
        String USERNAME = properties.get("username");
        String PASSWORD = properties.get("password");

        if (!properties.containsKey("TABLE_SUFFIX")) {
            System.out.println("----->>>需要生成的表名为空");
            return;
        }
        //表拼接
        String[] tables;
        if (!properties.containsKey("TABLE_PREFIX")) {
            tables = properties.get("TABLE_SUFFIX").split(",");
        } else {
            List<String> tableList = Arrays.asList(properties.get("TABLE_SUFFIX").split(","));
            tables = tableList.stream().map(table -> table).toArray(String[]::new);
        }
        System.out.println("表：");
        Arrays.stream(tables).forEach(System.out::println);

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/" + properties.get("MODULE_NAME") + "/src/main/java");//设置代码生成路径

        gc.setFileOverride(true);//是否覆盖以前文件
        gc.setOpen(false);//是否打开生成目录
        gc.setAuthor(properties.get("AUTHOR_NAME"));//设置项目作者名称
        // gc.setIdType(IdType.AUTO);//设置主键策略
        gc.setIdType(IdType.ASSIGN_ID);//设置主键策略
        gc.setBaseResultMap(true);//生成基本ResultMap
        gc.setBaseColumnList(true);//生成基本ColumnList
        gc.setServiceName("%sService");//去掉服务默认前缀
        gc.setDateType(DateType.ONLY_DATE);//设置时间类型
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(URL);
        dsc.setDriverName(DRIVER_NAME);
        dsc.setUsername(USERNAME);
        dsc.setPassword(PASSWORD);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(properties.get("PARENT_PACKAGE"));
        pc.setMapper("mapper");
        //不生成实体类
        pc.setEntity("entity");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        //自定义配置，配置自定义属性注入
        InjectionConfig cfg = new InjectionConfig() {
            //在.ftl(或者是.vm)模板中，通过${cfg.abc}获取属性
            @Override
            public void initMap() {
                //自定义生成模板参数
                Map<String, Object> map = new HashMap<>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                //模板中获取值：${cfg.requestPathPrefix}
                map.put("requestPathPrefix", properties.get("REQUEST_PATH_PREFIX"));
                map.put("dtoPackage", properties.get("PARENT_DTO_PACKAGE"));
                map.put("voPackage", properties.get("PARENT_VO_PACKAGE"));
                map.put("queryDtoPackage", properties.get("PARENT_QUERY_DTO_PACKAGE"));
                map.put("dtoIgnoreFields", properties.get("DTO_IGNORE_FIELD"));
                this.setMap(map);
            }
        };

        // 如果模板引擎是 freemarker
        // String templatePath = "/templates/mapper.xml.vm.ftl";
        // 如果模板引擎是 velocity：
        // String templatePath = "/templates/mapper.xml.vm" ;
        //自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(properties.get("TEMPLATE_MAPPER_XML_PATH")) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/" + properties.get("MODULE_NAME") + properties.get("MAPPER_PATH") + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        //自定义生成类DTO/VO/QueryDOT
        focList.add(new FileOutConfig(properties.get("TEMPLATE_DTO_PATH")) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "\\" + properties.get("MODULE_NAME") + properties.get("PARENT_DTO_PATH") + tableInfo.getEntityName() + "DTO" + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig(properties.get("TEMPLATE_VO_PATH")) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "\\" + properties.get("MODULE_NAME") + properties.get("PARENT_VO_PATH") + tableInfo.getEntityName() + "VO" + StringPool.DOT_JAVA;
            }
        });
        focList.add(new FileOutConfig(properties.get("TEMPLATE_QUERY_DTO_PATH")) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "\\" + properties.get("MODULE_NAME") + properties.get("PARENT_QUERY_DTO_PATH") + tableInfo.getEntityName() + "QueryDTO" + StringPool.DOT_JAVA;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 自定义模板
        TemplateConfig templateConfig = new TemplateConfig();
        //控制:不生java下成xml
        templateConfig.setXml(null);
        templateConfig.setEntity(null);

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        templateConfig.setEntity(properties.get("TEMPLATE_ENTITY_PATH"));
        templateConfig.setController(properties.get("TEMPLATE_CONTROLLER_PATH"));
        templateConfig.setService(properties.get("TEMPLATE_SERVICE_PATH"));
        templateConfig.setServiceImpl(properties.get("TEMPLATE_SERVICEIMPL_PATH"));
        templateConfig.setMapper(properties.get("TEMPLATE_MAPPER_PATH"));
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig sc = new StrategyConfig();
        sc.setNaming(NamingStrategy.underline_to_camel);
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        sc.setEntityLombokModel(true);//自动lombok
        sc.setRestControllerStyle(true);
        sc.setControllerMappingHyphenStyle(true);
        sc.setLogicDeleteFieldName("deleted");//设置逻辑删除

        //设置自动填充配置
        TableFill gmt_create = new TableFill("create_time", FieldFill.INSERT);
        TableFill gmt_modified = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmt_create);
        tableFills.add(gmt_modified);
        sc.setTableFillList(tableFills);

        //乐观锁
        sc.setVersionFieldName("version");
        sc.setRestControllerStyle(true);//驼峰命名

        sc.setTablePrefix(properties.get("TABLE_PREFIX_ENTITY")); //设置表名前缀
        sc.setInclude(tables);//表名，多个英文逗号分割
        mpg.setStrategy(sc);

        // 生成代码
        mpg.execute();
    }

//    private static String apply(String t) {
//        return TABLE_PREFIX + t;
//    }
}