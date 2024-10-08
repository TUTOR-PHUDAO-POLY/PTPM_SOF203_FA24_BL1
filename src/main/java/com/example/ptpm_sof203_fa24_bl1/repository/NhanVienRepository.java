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
            while (rs.next()){
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

    public static void main(String[] args) {
        System.out.println(new NhanVienRepository().getAll());
    }
}
