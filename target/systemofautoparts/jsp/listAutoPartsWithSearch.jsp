<%--
  Created by IntelliJ IDEA.
  User: Tatiana
  Date: 27.04.2015
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Search</title>
    <link href="jsp/accessories/resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/files/search/styles.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript">
        function submitForm(formId) {
            var what=document.getElementById("u304_input").value;

            var sel=document.getElementById("u302_input").value;
            if (sel=='Documents_has_AutoParts.Number'||sel=='Documents_has_AutoParts.Number') {
                var regCP = /[\d]/;
                var result = what.match(regCP);
                if (!result) {
                    alert('Поле должно содержать только число');
                    return false;
                }
                //alert(sel);
            }

            document.getElementById(formId).submit();
        }
    </script>
</head>
<body>
<div id="base" class="">

<a href="index.jsp">
<div id="u0" class="ax_shape">
    <img id="u0_img" class="img " src="jsp/accessories/images/index/u0.png"/>

    <div id="u1" class="text">
        <p><a href="index.jsp"><span>Логотип</span></a></p>
    </div>
</div>
</a>

<div id="u2" class="ax_h1">
    <img id="u2_img" class="img " src="jsp/accessories/images/index/u2.png"/>

    <div id="u3" class="text">
        <p><a href="index.jsp"><span>Система учёта автозапчастей</span></a></p><p><a href="index.jsp"><span>на складе</span></a></p>
    </div>
</div>

<div id="u4" class="ax_h2">
    <img id="u4_img" class="img " src="jsp/accessories/images/onthepicture/u4.png"/>

    <div id="u5" class="text">
        <p><span>Перечень имеющихся автозапчастей на складе</span></p>
    </div>
</div>

<div id="u6" class="ax_table">
    <table border=1>
        <thead>
        <tr>
            <th>Номер автозапчасти</th>
            <th>Название автозапчасти</th>
            <th>Название марки</th>
            <th>Название модели</th>
            <th>Год выпуска</th>
            <th>Имя контрагента</th>
            <th>Цена</th>
            <th>Количество</th>
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
    <form method="post" action="Controller" id="SEARCH">
        <input type="hidden" name="command" value="DO_SEARCH" />

<div id="u302" class="ax_droplist">
    <select name="whereSearch" id="u302_input">
        <option selected value="AutoParts.Name">по названию детали</option>
        <option value="CarBrands.NameBrand">по названию марки авто</option>
        <option value="CarModels.NameModel">по названию модели авто</option>
        <option value="Contractors.NameOfAgent">по имени агента</option>
        <option value="Documents_has_AutoParts.Price">по цене </option>
        <option value="Documents_has_AutoParts.Number">по количеству</option>
        <option value="notSearch">отменить поиск</option>
    </select>
</div>

<div id="u303" class="ax_html_button">
    <input id="u303_input" type="button" value="Поиск" onclick="submitForm('SEARCH')"/>
</div>

<div id="u304" class="ax_text_field">
    <input id="u304_input" type="text" name="whatSearch" value="" />
</div>
</form>
</div>
</body>
</html>

