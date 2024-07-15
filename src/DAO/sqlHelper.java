/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.ConnectionDataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sqlHelper {
    // Thông tin kết nối cơ sở dữ liệu
//    private static final String URL = "jdbc:sqlserver://localhost:52239;" + "databaseName=QL_BAN_GIAY_09; trustServerCertificate = true";
//    private static final String USER = "sa";
//    private static final String PASSWORD = "123";
    
//    // Hàm kết nối cơ sở dữ liệu
//    private static Connection connect() throws SQLException {
//        return DriverManager.getConnection(URL, USER, PASSWORD);
//    }
   static Connection con=ConnectionDataBase.conn;
    // Hàm thực hiện truy vấn
    public static ResultSet executeQuery(String query) throws SQLException {
        PreparedStatement stmt=con.prepareStatement(query);
        return stmt.executeQuery();
    }
    
    // Hàm thực hiện cập nhật, thêm, xóa
    public static int executeUpdate(String query) throws SQLException {
        PreparedStatement stmt = con.prepareStatement(query);
        return stmt.executeUpdate();
    }
    
    // Đóng kết nối, statement và resultset
    public static void close(Connection conn, PreparedStatement stmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}