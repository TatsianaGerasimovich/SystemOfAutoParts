<%--
  Created by IntelliJ IDEA.
  User: Tatiana
  Date: 26.04.2015
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Show All AutoParts</title>
    <link href="jsp/accessories/resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/files/onthepicture/styles.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div id="base" class="">

<a href="index.jsp">
<div id="u0" class="ax_shape">
    <a href="index.jsp"><img id="u0_img" class="img " src="jsp/accessories/images/index/u0.png"/></a>

    <div id="u1" class="text">
        <p><a href="index.jsp"><span>����Ԭ��ڬ�</span></a></p>
    </div>
</div>
</a>

<div id="u2" class="ax_h1">
    <img id="u2_img" class="img " src="jsp/accessories/images/index/u2.png"/>

    <div id="u3" class="text">
        <p><a href="index.jsp"><span>���ڬ��֬ެ� ���׬�� �ѬӬ��٬Ѭ��Ѭ��֬�</span></a></p><p><a href="index.jsp"><span>�߬� ��ܬݬѬլ�</span></a></p>
    </div>
</div>

<div id="u4" class="ax_h2">
    <img id="u4_img" class="img " src="jsp/accessories/images/onthepicture/u4.png"/>

    <div id="u5" class="text">
        <p><span>���֬�֬�֬߬� �ѬӬ��٬Ѭ��Ѭ��֬�</span></p>
    </div>
</div>

<div id="u6" class="ax_table">
    <table border=1>
        <thead>
        <tr>
            <th>����ެ֬� �ѬӬ��٬Ѭ��Ѭ���</th>
            <th>���Ѭ٬ӬѬ߬ڬ� �ѬӬ��٬Ѭ��Ѭ���</th>
            <th>���Ѭ٬ӬѬ߬ڬ� �ެѬ�ܬ�</th>
            <th>���Ѭ٬ӬѬ߬ڬ� �ެ�լ֬ݬ�</th>
            <th>����� �Ӭ����ܬ�</th>
            <th>���ެ� �ܬ�߬��ѬԬ֬߬��</th>
            <th>���֬߬�</th>
            <th>����ݬڬ�֬��Ӭ�</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${all1}" var="all">
            <tr>
                <td><c:out value="${all.autoPartId}" /></td>
                <td><c:out value="${all.name}" /></td>
                <td><c:out value="${all.nameBrand}" /></td>
                <td><c:out value="${all.nameModel}" /></td>
                <td><c:out value="${all.yearOfRelease}" /></td>
                <td><c:out value="${all.nameOfAgent}" /></td>
                <td><c:out value="${all.price}" /></td>
                <td><c:out value="${all.number}" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>
</body>
</html>


