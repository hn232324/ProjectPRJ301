/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Diary;

/**
 *
 *
 */
public class DAO extends DBContext {

    public void add(Diary d) {
        try {

            String sql = "INSERT INTO [dbo].[Diary]\n"
                    + "           ([Title]\n"
                    + "           ,[Note]\n"
                    + "           ,[crday]\n"
                    + "           ,[uday]\n"
                    + "           ,[aid])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, d.getTitle());
            st.setString(2, d.getNote());
            st.setString(3, d.getCrday());
            st.setString(4, d.getUday());
            st.setInt(5, d.getAid());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void update(Diary d) {
        try {

            String sql = "UPDATE Diary\n"
                    + "SET Title = ?, Note = ?,uday = ?, aid = ?\n"
                    + "WHERE id=?;";

            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, d.getTitle());
            st.setString(2, d.getNote());
            st.setString(3, d.getUday());
            st.setInt(4, d.getAid());
            st.setInt(5, d.getId());

            st.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void delete(String id) {
        String sql = "delete from Diary "
                + "where id = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
        }
    }

//    public void addFavorite(String sid) {
//        String sql = "UPDATE Diary SET fid = 1 WHERE id = ?";
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setString(1, sid);
//            st.executeUpdate();
//
//        } catch (SQLException e) {
//        }
//    }

}
