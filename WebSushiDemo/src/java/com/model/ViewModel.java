/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.connect.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Ly Quynh Tran
 */
public class ViewModel {

    private final DBContext db;

    public ViewModel() {
        db = new DBContext();
    }

    public int getView() throws Exception {
        int rows = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "select * from [view]";

        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                rows = rs.getInt(1);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.close(conn, ps, rs);
        }
        return rows;
    }

    public void updateView() throws Exception {
       
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "Update [view] set viewed = viewed +1";

        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            db.close(conn, ps, rs);
        }
    
    }
}
