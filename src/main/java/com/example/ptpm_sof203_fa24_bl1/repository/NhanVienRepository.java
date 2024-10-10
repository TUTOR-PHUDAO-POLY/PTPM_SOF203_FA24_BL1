package com.example.ptpm_sof203_fa24_bl1.repository;

import com.example.ptpm_sof203_fa24_bl1.entity.NhanVien;
import com.example.ptpm_sof203_fa24_bl1.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository {

    // FULL SOURCE CRUD(CREATE - READ - UPDATE - DELETE)
    // LAM VIEC TRUC TIEP VS CSDL
    // WEB => 404, 400, 500, 405...

    public List<NhanVien> getAll() {
        List<NhanVien> lists = new ArrayList<>();
        // CODE
        // B1: Tao cau lenh SQL
        String sql = "SELECT [ID]\n" +
                "      ,[Ma]\n" +
                "      ,[Ten]\n" +
                "      ,[TenDem]\n" +
                "      ,[Ho]\n" +
                "      ,[GioiTinh]\n" +
                "      ,[DiaChi]\n" +
                "      ,[Sdt]\n" +
                "      ,[MatKhau]\n" +
                "      ,[IdCV]\n" +
                "      ,[TrangThai]\n" +
                "  FROM [dbo].[NhanVien]";
        // B2: Mo cong ket noi
        try (
                Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            // Resultset => du lieu tra ra => table
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // B3: Tao 1 doi tuong
                NhanVien nv = NhanVien.builder()
                        .trangThai(rs.getInt(11))
                        .ma(rs.getString(2))
                        .ten(rs.getString(3))
                        .tenDem(rs.getString(4))
                        .ho(rs.getString(5))
                        .gioiTinh(rs.getString(6))
                        .diaChi(rs.getString(7))
                        .sdt(rs.getString(8))
                        .matKhau(rs.getString(9))
                        .idCV(rs.getInt(10))
                        .id(rs.getInt(1))
                        .build();
                // <=> contructor khong tham so
                // B4: add vao list
                lists.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Xay ra ngoai le
        }
        return lists;
    }

    // them,sua/xoa => 1 dong
    public boolean delete(Integer id) {
        int check = 0;
        // B1: Tao cau query
        String sql = "DELETE FROM FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041.dbo.NhanVien\n" +
                "WHERE Id=?";
        try (
                Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            // xet gia tri cho dau ?
            ps.setObject(1, id);
            check = ps.executeUpdate(); // Thuc hien cau truy van
        } catch (Exception e) {
            e.printStackTrace();
            // Xay ra ngoai le
        }
        return check > 0;
    }

    public boolean add(NhanVien nv) {
        int check = 0;
        // B1: Tao cau query
        String sql = "INSERT INTO FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041.dbo.NhanVien\n" +
                "( Ma, Ten,GioiTinh, DiaChi)\n" +
                "VALUES(?,?,?,?);";
        try (
                Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            // xet gia tri cho dau ?
            ps.setObject(1, nv.getMa());
            ps.setObject(2, nv.getTen());
            ps.setObject(3, nv.getGioiTinh());
            ps.setObject(4, nv.getDiaChi());
            check = ps.executeUpdate(); // Thuc hien cau truy van
        } catch (Exception e) {
            e.printStackTrace();
            // Xay ra ngoai le
        }
        return check > 0;
    }

    public NhanVien getOne(Integer id1) {
        // CODE
        // B1: Tao cau lenh SQL
        String sql = "SELECT [ID]\n" +
                "      ,[Ma]\n" +
                "      ,[Ten]\n" +
                "      ,[TenDem]\n" +
                "      ,[Ho]\n" +
                "      ,[GioiTinh]\n" +
                "      ,[DiaChi]\n" +
                "      ,[Sdt]\n" +
                "      ,[MatKhau]\n" +
                "      ,[IdCV]\n" +
                "      ,[TrangThai]\n" +
                "  FROM [dbo].[NhanVien] WHERE id = ?";
        // B2: Mo cong ket noi
        try (
                Connection con = DBConnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setObject(1, id1);
            // Resultset => du lieu tra ra => table
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // B3: Tao 1 doi tuong
                NhanVien nv = NhanVien.builder()
                        .trangThai(rs.getInt(11))
                        .ma(rs.getString(2))
                        .ten(rs.getString(3))
                        .tenDem(rs.getString(4))
                        .ho(rs.getString(5))
                        .gioiTinh(rs.getString(6))
                        .diaChi(rs.getString(7))
                        .sdt(rs.getString(8))
                        .matKhau(rs.getString(9))
                        .idCV(rs.getInt(10))
                        .id(rs.getInt(1))
                        .build();
                // <=> contructor khong tham so
                return nv;
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Xay ra ngoai le
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new NhanVienRepository().getAll());
    }
}
