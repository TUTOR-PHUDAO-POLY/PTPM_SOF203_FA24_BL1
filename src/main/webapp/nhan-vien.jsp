<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/nhan-vien/add" method="POST">
    Ma: <input type="text" name="ma" value="${nv1.ma}"/> <br/>
    Ten: <input type="text" name="ten" value="${nv1.ten}"/> <br/>
    Gioi tinh:
    <input type="radio" value="Nam" name="gioiTinh" ${nv1.gioiTinh == "Nam" ?"checked":""}/> Nam
    <input type="radio" value="Nữ" name="gioiTinh" ${nv1.gioiTinh == "Nữ" ?"checked":""}/> Nữ
    <br/>
    Dia chi: <input type="text" name="diaChi" value="${nv1.diaChi}"/> <br/>
    <button type="submit">Add</button>
</form>
<table>
    <thead>
    <tr>
        <th>#</th>
        <th>Ma</th>
        <th>Ten</th>
        <th>Gioi tinh</th>
        <th>Dia chi</th>
        <th>Hanh dong</th>
    </tr>
    </thead>
    <tbody>
    <%--   for..each     --%>
    <%--varStatus: index => vi tri cua mang: Bat dau 0    --%>
    <c:forEach items="${a}" var="nv" varStatus="i">
        <tr>
            <td>${i.index}</td>
            <td>${nv.ma}</td>
            <td>${nv.ten}</td>
            <td>${nv.gioiTinh}</td>
            <td>${nv.diaChi}</td>
            <td>
                    <%-- Khong co khoang cach ?id= --%>
                <a href="/nhan-vien/delete?a=${nv.id}">Delete</a>
                <a href="/nhan-vien/detail?id1=${nv.id}">Detail</a>
                <a>Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>

    <%--    for(NhanVien nv: lists){--%>
    <%--        sout(nv)--%>
    <%--    }--%>
</table>
</body>
</html>
