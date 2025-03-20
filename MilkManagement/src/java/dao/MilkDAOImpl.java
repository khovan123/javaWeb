package dao;

import connectDB.DBConnection;
import model.Milk;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MilkDAOImpl {

    public List<Milk> getAllMilks() {
        List<Milk> milks = new ArrayList<>();
        String sql = "SELECT m.*, c.CategoryName FROM Milk m JOIN Category c ON m.CategoryID = c.CategoryID";
        try (Connection conn = DBConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Milk milk = new Milk(
                        rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getString("Unit"),
                        rs.getInt("CategoryID"),
                        rs.getDouble("Price"),
                        rs.getString("Overview"),
                        rs.getString("Original"),
                        rs.getBoolean("HasSugar"),
                        rs.getString("CategoryName")
                );
                milks.add(milk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return milks;
    }

    public Milk getMilkById(int id) {
        String sql = "SELECT m.*, c.CategoryName FROM Milk m JOIN Category c ON m.CategoryID = c.CategoryID WHERE m.ID = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Milk(
                        rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getString("Unit"),
                        rs.getInt("CategoryID"),
                        rs.getDouble("Price"),
                        rs.getString("Overview"),
                        rs.getString("Original"),
                        rs.getBoolean("HasSugar"),
                        rs.getString("CategoryName")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addMilk(Milk milk) {
        String sql = "INSERT INTO Milk (Name, Unit, CategoryID, Price, Overview, Original, HasSugar) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, milk.getName());
            ps.setString(2, milk.getUnit());
            ps.setInt(3, milk.getCategoryId());
            ps.setDouble(4, milk.getPrice());
            ps.setString(5, milk.getOverview());
            ps.setString(6, milk.getOriginal());
            ps.setBoolean(7, milk.isHasSugar());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMilk(Milk milk) {
        String sql = "UPDATE Milk SET Name = ?, Unit = ?, CategoryID = ?, Price = ?, Overview = ?, Original = ?, HasSugar = ? WHERE ID = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, milk.getName());
            ps.setString(2, milk.getUnit());
            ps.setInt(3, milk.getCategoryId());
            ps.setDouble(4, milk.getPrice());
            ps.setString(5, milk.getOverview());
            ps.setString(6, milk.getOriginal());
            ps.setBoolean(7, milk.isHasSugar());
            ps.setInt(8, milk.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMilk(int id) {
        String sql = "DELETE FROM Milk WHERE ID = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
