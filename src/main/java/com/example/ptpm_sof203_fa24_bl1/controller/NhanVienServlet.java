package com.example.ptpm_sof203_fa24_bl1.controller;

import com.example.ptpm_sof203_fa24_bl1.entity.NhanVien;
import com.example.ptpm_sof203_fa24_bl1.repository.NhanVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhan-vien/hien-thi", // GET
        "/nhan-vien/add", // POST
        "/nhan-vien/detail", // GET
        "/nhan-vien/update", // POST
        "/nhan-vien/delete" // GET
})
public class NhanVienServlet extends HttpServlet {

    private NhanVienRepository repository = new NhanVienRepository();

    // http://localhost:8080/nhan-vien/get-all => URL
    // nhan-vien/hien-thi => URI
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // vut code : get-all, detail, delete => do get
        String uri = request.getRequestURI();  // /nhan-vien/hien-thi
//        System.out.println(uri);
        // KIEM TRA CHUA
        if (uri.contains("hien-thi")) {
            // hien thi du lieu len table
            this.hienThiDuLieu(request, response);
        } else if (uri.contains("detail")) {
            // detail
            this.detailNhanVien(request, response);
        } else {
            // delete
            this.deleteNhanVien(request, response);
        }
    }

    private void deleteNhanVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // B1: Lay gia tri tren duong dan => getParamater
        String id = request.getParameter("a");
        repository.delete(Integer.valueOf(id));
        // B2: Quay lai trang ban dau
        response.sendRedirect("/nhan-vien/hien-thi");
    }

    private void detailNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay ra gia tri tren duong dan
        String id = request.getParameter("id1");
        // B2: Day gia tri sang jsp
        request.setAttribute("nv1", repository.getOne(Integer.valueOf(id)));
        request.setAttribute("a", repository.getAll());
        // B3: Chuyen trang
        request.getRequestDispatcher("/nhan-vien.jsp").forward(request, response);
    }

    private void hienThiDuLieu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // viet code getAll
        // day 1 gia tri => jsp => setAttribute
        request.setAttribute("a", repository.getAll());
        // Day du lieu => jsp
        request.getRequestDispatcher("/nhan-vien.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // add & update => do post
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            //add
            this.addNhanVien(request, response);
        } else {
            // update
            this.update(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    @SneakyThrows
    private void addNhanVien(HttpServletRequest request, HttpServletResponse response) throws IOException {
        NhanVien nv = new NhanVien();
        BeanUtils.populate(nv, request.getParameterMap());
        // BeanUtils.populate => tu dong map toan bo du lieu vao doi tuong nv
        repository.add(nv);
        response.sendRedirect("/nhan-vien/hien-thi");
    }
}
