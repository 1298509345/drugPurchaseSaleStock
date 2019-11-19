package myPackage.DAL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class connectDataBase {

    private static String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";//数据库连接地址
    private static String dbUserName = "scott";//用户名
    private static String dbPassword = "syg199908";//密码
    private static String jdbcName = "oracle.jdbc.OracleDriver"; // 驱动名称

    public static Connection getLink() {
        try {
            Class.forName(jdbcName);
            return DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void Close(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public static void Close(Connection conn, CallableStatement call) {
        try {
            conn.close();
            call.close();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        String[] arg1 = {"1", "供应商A", "100-100-100"};
//        String[] arg2 = {"2", "供应商B", "200-200-200"};
//        String[] arg3 = {"3", "供应商C", "300-300-300"};
//        String[] arg4 = {"4", "供应商D", "400-400-400"};
//        String[] arg5 = {"5", "供应商E", "500-500-500"};
//        List<String[]>list=new ArrayList<>();
//        list.add(arg1);
//        list.add(arg2);
//        list.add(arg3);
//        list.add(arg4);
//        list.add(arg5);
//        for (int i = 0; i <list.size() ; i++) {
//            businessProcess.providerInfo(list.get(i));
//        }
        String columnName[]={"a","b","c"};
        String columnNames="";
        for (int i = 0; i <columnName.length ; i++) {
            if(i!=columnName.length-1)columnNames+=columnName[i]+",";
            else columnNames+=columnName[i];
        }
        System.out.println(columnNames);
    }


}
