package com.buy.utils;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.Connection;
import java.sql.SQLException;

//数据库操作辅助类
public class DataSourceUtil {
    private static final String Driver="com.mysql.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/easybuy";
    private static final String userName="root";
    private static final String pwd="1234";
    //创建druid数据源对象
    private static DruidDataSource druidDataSource=null;
    //静态代码块 运行 init方法
    static {
        try {
            init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 配置阿里巴巴数据源
     */


    public static void init() throws SQLException {
        //实例化DruiDataSource 对象
        druidDataSource=new DruidDataSource();
        //设置属性的值
        druidDataSource.setDriverClassName(Driver);
        druidDataSource.setUrl(url);
        //设置连接池相关属性
        druidDataSource.setInitialSize(5);//初始化连接池数量
        druidDataSource.setMaxActive(100);//最大连接数
        druidDataSource.setMinIdle(1);//最大空闲连接数
        druidDataSource.setMaxWait(1000);//连接等待时长，单位：毫秒
        druidDataSource.setFilters("stat");//设置监控
    }

    /**
     * 链接数据源的方法
     * @return 链接对象
     */
    public static Connection getConn(){
        Connection conn=null;
        //加载mysql驱动（开启服务）
        try {
            Class.forName(Driver);
            //如果数据库处于没有链接状态，则创建一个链接
            if (conn == null) {
                conn=druidDataSource.getConnection(userName,pwd);
                System.out.println("数据库链接成功");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeConnection(Connection conn){
        if (conn != null) {
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }

        }
    }
}