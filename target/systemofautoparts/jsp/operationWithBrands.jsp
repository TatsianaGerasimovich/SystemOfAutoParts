<%--
  Created by IntelliJ IDEA.
  User: Tatiana
  Date: 28.04.2015
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Operations with brands</title>
    <link href="jsp/accessories/resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/files/operationwithbrands/styles.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div id="base" class="">

<a href="index.jsp">
<div id="u6" class="ax_shape">
    <img id="u6_img" class="img " src="jsp/accessories/images/index/u0.png"/>

    <div id="u7" class="text">
        <p><a href="index.jsp"><span>Логотип</span></a></p>
    </div>
</div>
</a>
<a href="index.jsp">

<div id="u8" class="ax_h1">
    <img id="u8_img" class="img " src="jsp/accessories/images/index/u2.png"/>

    <div id="u9" class="text">
        <p><a href="index.jsp"><span>Система учёта автозапчастей</span></a></p><p><a href="index.jsp"><span>на складе</span></a></p>
    </div>
</div>
</a>

<div id="u10" class="ax_h2">
    <img id="u10_img" class="img " src="jsp/accessories/images/onthepicture/u4.png"/>

    <div id="u11" class="text">
        <p><span>Операции с марками автомобилей</span></p>
    </div>
</div>

<div id="u12" class="ax_table">
    <table border=1>
        <thead>
        <tr>
            <th>Номер марки</th>
            <th>Название марки</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${all1}" var="all">
            <tr>
                <td><c:out value="${all.carBrandId}" /></td>
                <td><c:out value="${all.nameBrand}" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>


<form method="post" action="Controller">
    <input type="hidden" name="command" value="OPERATION_WITH_BRANDS" />
    <input type="hidden" name="typeOfOperationWithBrand" value="CREATE_BRAND" />

<div id="u73" class="ax_shape">
    <img id="u73_img" class="img " src="jsp/accessories/images/operationwithbrands/u73.png"/>

    <div id="u74" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u75" class="ax_h2">
    <img id="u75_img" class="img " src="jsp/accessories/images/operationwithbrands/u75.png"/>

    <div id="u76" class="text">
        <p><span>Добавить новую марку:</span></p>
    </div>
</div>

<div id="u77" class="ax_paragraph">
    <img id="u77_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u78" class="text">
        <p><span>Название марки:</span></p>
    </div>
</div>

<div id="u79" class="ax_text_field">
    <input id="u79_input" type="text" name="nameOfCarBrand"  value="" required/>
</div>

<div id="u80" class="ax_html_button">
    <input id="u80_input" type="submit" value="Добавить"/>
</div>
</form>


<form method="post" action="Controller">
    <input type="hidden" name="command" value="OPERATION_WITH_BRANDS" />
    <input type="hidden" name="typeOfOperationWithBrand" value="UPDATE_BRAND" />

<div id="u81" class="ax_shape">
    <img id="u81_img" class="img " src="jsp/accessories/images/operationwithbrands/u81.png"/>

    <div id="u82" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u83" class="ax_h2">
    <img id="u83_img" class="img " src="jsp/accessories/images/operationwithbrands/u83.png"/>

    <div id="u84" class="text">
        <p><span>Изменить имеющуюся марку:</span></p>
    </div>
</div>

<div id="u85" class="ax_paragraph">
    <img id="u85_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u86" class="text">
        <p><span>Название марки:</span></p>
    </div>
</div>

<div id="u87" class="ax_text_field">
    <input id="u87_input" type="text" name="nameOfCarBrand" value="" required/>
</div>

<div id="u88" class="ax_html_button">
    <input id="u88_input" type="submit" value="Изменить"/>
</div>

<div id="u89" class="ax_paragraph">
    <img id="u89_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u90" class="text">
        <p><span>Номер</span></p><p><span> марки</span><span>:</span></p>
    </div>
</div>

<div id="u91" class="ax_text_field">
    <select name="idOfCarBrand" id="u91_input">
        <c:forEach items="${allBrand}" var="allBrand">
            <option  value="${allBrand.carBrandId}"><c:out value="${allBrand.carBrandId} (${allBrand.nameBrand})" /></option>
        </c:forEach>
    </select>
</div>
</form>


<form method="post" action="Controller">
    <input type="hidden" name="command" value="OPERATION_WITH_BRANDS" />
    <input type="hidden" name="typeOfOperationWithBrand" value="DELETE_BRAND" />

<div id="u92" class="ax_shape">
    <img id="u92_img" class="img " src="jsp/accessories/images/operationwithbrands/u73.png"/>

    <div id="u93" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u94" class="ax_h2">
    <img id="u94_img" class="img " src="jsp/accessories/images/operationwithbrands/u94.png"/>

    <div id="u95" class="text">
        <p><span>Удалить имеющуюся марку:</span></p>
    </div>
</div>

<div id="u96" class="ax_paragraph">
    <img id="u96_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u97" class="text">
        <p><span>Номер</span></p><p><span> марки</span><span>:</span></p>
    </div>
</div>

<div id="u98" class="ax_text_field">
    <select name="idOfCarBrand" id="u98_input">
        <c:forEach items="${allBrand}" var="allBrand">
            <option  value="${allBrand.carBrandId}"><c:out value="${allBrand.carBrandId} (${allBrand.nameBrand})" /></option>
        </c:forEach>
    </select>
</div>

<div id="u99" class="ax_html_button">
    <input id="u99_input" type="submit" value="Удалить"/>
</div>
    </form>
</div>
</body>
</html>

