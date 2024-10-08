<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

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
    <c:forEach items="${a}" var="nv">
        <tr>
            <td></td>
            <td>${nv.ma}</td>
            <td>${nv.ten}</td>
            <td>${nv.gioiTinh}</td>
            <td>${nv.diaChi}</td>
            <td>

            </td>
        </tr>
    </c:forEach>
    </tbody>

    for(NhanVien nv: lists){
        sout(nv)
    }
</table>
</body>
</html>
