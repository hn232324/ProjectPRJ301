/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Diary;

/**
 *
 * @author
 */
public class DAOAccount extends DBContext {

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String sql = "select * from Accounts";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account p = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Diary> getAll() {
        List<Diary> list = new ArrayList<>();
        String sql = "select * from Debit";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Diary d = new Diary(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6));
                list.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Account check(String user, String pass) {

        String sql = " select * from Accounts"
                + " WHERE [usename] = ? and password = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3),
                         rs.getString(4), "", "",
                         "", rs.getInt(5));

            }
        } catch (SQLException e) {
            System.out.println(e);

        }
        return null;
    }

    public int check(String usename) {
        String sql = "select * from Accounts where usename = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, usename);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int a = rs.getInt("id");
                return a;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return 0;
    }

    public Account checkExist(String user) {

        String sql = " select * from Accounts"
                + " WHERE [usename] = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {

                return new Account(rs.getInt("id"),
                        rs.getString("usename"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("fullname"),
                        rs.getString("phone_num"),
                        rs.getString("description"),
                        rs.getInt("role"));

            }
        } catch (SQLException e) {

        }
        return null;
    }

    public void checkSignup(String user, String pass, String email) {

        String sql = " INSERT INTO [dbo].[Accounts] ([usename],[password],[email],role) VALUES(?,?,?,2);";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            st.setString(3, email);
            st.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public Account checku(String usename) {
        String sql = "select * from Accounts where usename = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, usename);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                Account a = new Account(rs.getInt("id"),
                        rs.getString("usename"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("fullname"),
                        rs.getString("phone_num"),
                        rs.getString("description"),
                        rs.getInt("role"));
                return a;

            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public void insert(String user, String pass) {
        String sql = "INSERT INTO [dbo].[Accounts] VALUES(?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, user);
            st.setString(2, pass);
            st.setInt(3, 2);

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Account getAccountById(int id) {
        String sql = "select * from Accounts where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                Account a = new Account(rs.getInt("id"),
                        rs.getString("usename"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("fullname"),
                        rs.getString("phone_num"),
                        rs.getString("description"),
                        rs.getInt("role"));

                return a;
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }

    public boolean checkMailExist(String email) {
        String sql = "select * from Accounts where email = ? ";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, email);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {

                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Account checkmail(String usename, String email) {
        String sql = "select * from Accounts where usename =? and email =?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, usename);
            pre.setString(2, email);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                DAOAccount da = new DAOAccount();
                Account u = new Account(rs.getInt("id"),
                        rs.getString("usename"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("fullname"),
                        rs.getString("phone_num"),
                        rs.getString("description"),
                        rs.getInt("role"));
                return u;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Account getAccount(int id) {
        String sql = "select * from Accounts  where id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {

                Account a = new Account(rs.getInt("id"),
                        rs.getString("usename"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("fullname"),
                        rs.getString("phone_num"),
                        rs.getString("description"),
                        rs.getInt("role"));
                return a;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public void updateActive(Account a) {
        String sql = "update Accounts set active = 1 where id = ? ";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, a.getId());
            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void updateinfom(Account a) {
        String sql = "update Accounts set fullname=? , phone_num=? , description = ? where id = ? ";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, a.getId());
            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void UpdatePassAndRole(Account a) {
        String sql = "update Accounts set password= ?, role= ? where id = ? ";

        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, a.getPassword());
            pre.setInt(2, a.getRole());
            pre.setInt(3, a.getId());

            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean checkPhoneExist(String phone_num) {
        String sql = "select * from Accounts where phone_num = ? ";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, phone_num);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {

                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public void UpdateInfor(int id, String fullname, String phone_num, String description) {
        String sql = "update Accounts set fullname= ? , phone_num = ?, description= ? where id = ? ";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);

            pre.setString(1, fullname);
            pre.setString(2, phone_num);
            pre.setString(3, description);
            pre.setInt(4, id);
            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Account> getAccountbyid(int id) {
        List<Account> list = new ArrayList<>();
        String sql = "select * from Accounts where id =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Account p = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Diary> getDiarybyaid(int id) {
        List<Diary> list = new ArrayList<>();
        String sql = " select * from Diary WHERE aid= ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Diary d = new Diary(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6));
                list.add(d);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;

    }

    public static void main(String[] args) {
        DAOAccount p = new DAOAccount();
        p.UpdateInfor(2, "Manh ga", "0222223", "test");

    }

}
