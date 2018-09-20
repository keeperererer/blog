package com.cn.sxt;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 链接数据库用的工具类
 * 使用改工具类还需要在  webRoot/WEB-INF/lib下复制jar包
 * @author junliu
 * 
 * 打开cmd 输入下面 sc delete mysql 删除之前的mysql服务
 * 将解压出来的mysql包 放到一个没有中文和特殊字符的目录下
 * 打开bin目录下的  mysqld.exe
 * 使用navcat连接mysql数据库
 *
 */
public class DBUtil {
	
	//1. 定义变量
	private static String driver = "com.mysql.jdbc.Driver";
	/*blog数据库名称*/
	private static String url = "jdbc:mysql://localhost:3306/blog?characterEncoding=UTF-8";
	private static String user = "root";
	private static String password = "root";
	/**
	 * 获取 Connection对象
	 * @return
	 */
	public static Connection getConn(){
		Connection conn = null;
		try {
			//加载驱动
			Class.forName(driver);
			//获取连接对象
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 释放资源
	 * @param conn
	 * @param pst
	 * @param rs
	 */
	public static void free(Connection conn, PreparedStatement pst,ResultSet rs){
		try{
			if(rs!=null){
				rs.close();
			}
			if(pst!=null){
				pst.close();
			}
			if(conn!=null){
				conn.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 释放资源
	 * @param conn
	 * @param pst
	 * @param rs
	 */
	public static void free(Connection conn, PreparedStatement pst){
		free( conn,  pst,null);
	}
	
	/**
	 * 做增删改的工具类
	 * @return
	 */
	public static int update(String sql , Object[] args){
		//获取链接对象
		Connection conn = getConn();
		//创建PreparedStatement对象
		PreparedStatement pst = null;
		int num = 0;
		try {
			//
			pst = conn.prepareStatement(sql);
			//先将参数设置到  sql语句的占位符中
			if(args != null){
				for(int i = 0; i < args.length; i++){
					pst.setObject(i + 1, args[i]);
				}
			}
			
			//执行sql语句   并且返回受影响行数
			num = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//释放资源
			free(conn, pst);
		}
		return num;
	}
	
	/**
	 * 不带参数的增删改
	 * @param sql
	 * @return
	 */
	public static int update(String sql){
		return update(sql,null);
	}
	
	/**
	 * 不带参数的增删改
	 * @param sql
	 * @return
	 */
	public static int insert(String sql , Object[] args){
		return update(sql,args);
	}
	
	/**
	 * 不带参数的增删改
	 * @param sql
	 * @return
	 */
	public static int delete(String sql , Object[] args){
		return update(sql,args);
	}
	
	/**
	 * 不带参数的增删改
	 * @param sql
	 * @return
	 */
	public static int insert(String sql){
		return update(sql,null);
	}
	/**
	 * 不带参数的增删改
	 * @param sql
	 * @return
	 */
	public static int delete(String sql){
		return update(sql,null);
	}
	
	/**
	 * 查询某个数据是否存在
	 * @return  true存在  false 不存在
	 */
	public static boolean selectExist(String sql, Object[] args){
		Connection conn = getConn();
		//创建PreparedStatement对象
		PreparedStatement pst = null;
		//创建 ResultSet对象
		
		ResultSet rs = null;
		boolean flag = false;//存储查询的数据是否存在 默认值false
		try {
			//
			pst = conn.prepareStatement(sql);
			//先将参数设置到  sql语句的占位符中
			if(args != null){
				for(int i = 0; i < args.length; i++){
					pst.setObject(i + 1, args[i]);
				}
			}
			
			//执行sql语句   并且返回受影响行数
			rs = pst.executeQuery();
			//如果有下一个  说明有数据
			while(rs.next()){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//释放资源
			free(conn, pst);
		}
		return flag;
	}
	
	/**
	 * 查询单行数据  并且返回Map
	 * @return  true存在  false 不存在
	 */
	public static Map<String,Object> selectOne(String sql, Object[] args){
		Connection conn = getConn();
		//创建PreparedStatement对象
		PreparedStatement pst = null;
		//创建 ResultSet对象
		
		ResultSet rs = null;
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			//
			pst = conn.prepareStatement(sql);
			//先将参数设置到  sql语句的占位符中
			if(args != null){
				for(int i = 0; i < args.length; i++){
					pst.setObject(i + 1, args[i]);
				}
			}
			
			//执行sql语句   并且返回受影响行数
			rs = pst.executeQuery();
			//如果有下一个  说明有数据
			
			//获取表的相关信息
			ResultSetMetaData rsmd = pst.getMetaData();
			int colNum = rsmd.getColumnCount();//获取行的数量
			
			while(rs.next()){
				for(int i = 0 ; i < colNum; i++){
					String colName = rsmd.getColumnName(i + 1).toLowerCase();//获取表中每一列的名字
					map.put(colName, rs.getObject(colName));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//释放资源
			free(conn, pst);
		}
		return map;
	}
	
	/**
	 * 查询多行数据  并且返回Map
	 * @return  true存在  false 不存在
	 */
	public static List<Map<String,Object>> selectList(String sql, Object[] args){
		Connection conn = getConn();
		//创建PreparedStatement对象
		PreparedStatement pst = null;
		//创建 ResultSet对象
		
		ResultSet rs = null;
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();//list中的每一个map代表一行数据
		try {
			//
			pst = conn.prepareStatement(sql);
			//先将参数设置到  sql语句的占位符中
			if(args != null){
				for(int i = 0; i < args.length; i++){
					pst.setObject(i + 1, args[i]);
				}
			}
			
			//执行sql语句   并且返回受影响行数
			rs = pst.executeQuery();
			//如果有下一个  说明有数据
			
			//获取表的相关信息
			ResultSetMetaData rsmd = pst.getMetaData();
			int colNum = rsmd.getColumnCount();//获取行的数量
			
			while(rs.next()){
				HashMap<String,Object> map = new HashMap<String,Object>();
				for(int i = 0 ; i < colNum; i++){
					String colName = rsmd.getColumnName(i + 1);//获取表中每一列的名字
					map.put(colName, rs.getObject(colName));//每一列的数据都放到同一个map中
				}
				list.add(map);//每一行的数据都添加到list中
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//释放资源
			free(conn, pst);
		}
		return list;
	}
	
	/**
	 * 查询多行数据  并且返回Map
	 * @return  true存在  false 不存在
	 */
	public static List<Map<String,Object>> selectList(String sql){
		
		return selectList(sql,null);
	}
	
	/**
	 * 查询单行数据  并且返回的是用户指定的类型
	 * @param sql  查询用的sql语句
	 * @param args sql语句需要用到的参数数组
	 * @param clz 指定需要返回的参数类型
	 * @return
	 */
	public static <T> T selectOne(String sql, Object[] args, Class<T> clz){
		Connection conn = getConn();
		//创建PreparedStatement对象
		PreparedStatement pst = null;
		//创建 ResultSet对象
		
		ResultSet rs = null;
		T t = null;
		try {
			t = clz.newInstance();//通过反射创建  泛型所指定的  对象
			//
			pst = conn.prepareStatement(sql);
			//先将参数设置到  sql语句的占位符中
			if(args != null){
				for(int i = 0; i < args.length; i++){
					pst.setObject(i + 1, args[i]);
				}
			}
			
			//执行sql语句   并且返回受影响行数
			rs = pst.executeQuery();
			//如果有下一个  说明有数据
			
			//获取表的相关信息
			ResultSetMetaData rsmd = pst.getMetaData();
			int colNum = rsmd.getColumnCount();//获取行的数量
			
			while(rs.next()){
				for(int i = 0 ; i < colNum; i++){
					String colName = rsmd.getColumnName(i + 1).toLowerCase();//获取表中每一列的名字
					//通过反射将值set到对应的属性中去
					//获取某个列名对应指定字节码文件中的的属性
					Field f = clz.getDeclaredField(colName);
					//打开私有属性的读写权限
					f.setAccessible(true);
					//为属性设置值
					f.set(t, rs.getObject(colName));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//释放资源
			free(conn, pst);
		}
		return t;
	}
	
	/**
	 * 查询多行数据  并且返回的是用户指定的类型
	 * @param sql  查询用的sql语句
	 * @param args sql语句需要用到的参数数组
	 * @param clz 指定需要返回的参数类型
	 * @return
	 */
	public static <T> List<T> selectList(String sql, Object[] args, Class<T> clz){
		Connection conn = getConn();
		//创建PreparedStatement对象
		PreparedStatement pst = null;
		//创建 ResultSet对象
		
		ResultSet rs = null;
		
		//返回值是一个List
		List<T> list = new ArrayList<T>();
		try {
			pst = conn.prepareStatement(sql);
			//先将参数设置到  sql语句的占位符中
			if(args != null){
				for(int i = 0; i < args.length; i++){
					pst.setObject(i + 1, args[i]);
				}
			}
			
			//执行sql语句   并且返回受影响行数
			rs = pst.executeQuery();
			//如果有下一个  说明有数据
			
			//获取表的相关信息
			ResultSetMetaData rsmd = pst.getMetaData();
			int colNum = rsmd.getColumnCount();//获取行的数量
			
			while(rs.next()){
				T t = clz.newInstance();//通过反射创建  泛型所指定的  对象  没循环读到一行数据创建一个对象
				for(int i = 0 ; i < colNum; i++){
					String colName = rsmd.getColumnName(i + 1).toLowerCase();//获取表中每一列的名字
					//通过反射将值set到对应的属性中去
					//获取某个列名对应指定字节码文件中的的属性
					Field f = clz.getDeclaredField(colName);
					//打开私有属性的读写权限
					f.setAccessible(true);
					//为属性设置值
					f.set(t, rs.getObject(colName));
				}
				//每一行拿到的 对象 添加到list中
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//释放资源
			free(conn, pst);
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		/*测试*/
		//判断用户名密码是否存在
//		boolean flag = selectExist("select count(*) from userinfo where username = ? and password = ?", new Object[]{"刘俊","1234"});
////		System.out.println(flag);
//		
//		
//		int num = insert("insert into userinfo(username,password) values(?,?)",new Object[]{"大黑","hhhhhh"});
//		System.out.println(num);
//		
		/*查询所有用户信息*/
		List<Map<String,Object>> list = 
			selectList("select * from userinfo");
		System.out.println(list);
		
	}

}
