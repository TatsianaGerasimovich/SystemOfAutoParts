<%--
  Created by IntelliJ IDEA.
  User: Tatiana
  Date: 29.04.2015
  Time: 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Operations with models</title>
    <link href="jsp/accessories/resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/files/operationwithmodels/styles.css" type="text/css" rel="stylesheet"/>
    <script src="jsp/accessories/resources/scripts/jquery-1.7.1.min.js"></script>
    <script src="jsp/accessories/resources/scripts/jquery-ui-1.8.10.custom.min.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/axQuery.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/globals.js"></script>
    <script src="jsp/accessories/resources/scripts/axutils.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/annotation.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/axQuery.std.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/doc.js"></script>
    <script src="jsp/accessories/data/document.js"></script>
    <script src="jsp/accessories/resources/scripts/messagecenter.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/events.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/action.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/expr.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/geometry.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/flyout.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/ie.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/model.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/repeater.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/sto.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/utils.temp.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/variables.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/drag.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/move.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/visibility.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/style.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/adaptive.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/tree.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/init.temp.js"></script>
    <script src="jsp/accessories/files/operationwithmodels/data.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/legacy.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/viewer.js"></script>
    <script type="text/javascript">
        $axure.utils.getTransparentGifPath = function() { return 'jsp/accessories/resources/images/transparent.gif'; };
        $axure.utils.getOtherPath = function() { return 'jsp/accessories/resources/Other.html'; };
        $axure.utils.getReloadPath = function() { return 'jsp/accessories/resources/reload.html'; };
    </script>
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
        <p><span>Операции с моделями автомобилей</span></p>
    </div>
</div>

<div id="u12" class="ax_table">

    <table border=1>
        <thead>
        <tr>
            <th>Identification number</th>
            <th>Identification number of car brand</th>
            <th>Name of model</th>
            <th>Year of release</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${all1}" var="all">
            <tr>
                <td><c:out value="${all.carModelId}" /></td>
                <td><c:out value="${all.carBrandId}" /></td>
                <td><c:out value="${all.nameModel}" /></td>
                <td><c:out value="${all.yearOfRelease}" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

<div id="u103" class="ax_shape">
    <img id="u103_img" class="img " src="jsp/accessories/images/operationwithmodels/u103.png"/>

    <div id="u104" class="text">
        <p><span></span></p>
    </div>
</div>


<form method="post" action="Controller">
    <input type="hidden" name="command" value="OPERATION_WITH_MODEL" />
    <input type="hidden" name="typeOfOperationWithModel" value="CREATE_MODEL" />

<div id="u105" class="ax_h2">
    <img id="u105_img" class="img " src="jsp/accessories/images/operationwithmodels/u105.png"/>

    <div id="u106" class="text">
        <p><span>Добавить новую модель:</span></p>
    </div>
</div>

<div id="u107" class="ax_paragraph">
    <img id="u107_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u108" class="text">
        <p><span>Identification</span></p><p><span>number of brand</span><span>:</span></p>
    </div>
</div>

<div id="u141" class="ax_droplist">
    <select name="idOfCarBrand" id="u141_input">
        <c:forEach items="${allBrand}" var="allBrand">
           <option  value="${allBrand.carBrandId}(${allBrand.nameBrand})"><c:out value="${allBrand.carBrandId} (${allBrand.nameBrand})" /></option>
        </c:forEach>
    </select>
</div>

<div id="u109" class="ax_html_button">
    <input id="u109_input" type="submit" value="Добавить"/>
</div>

<div id="u110" class="ax_paragraph">
    <img id="u110_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u111" class="text">
        <p><span>Name of model</span><span>:</span></p>
    </div>
</div>

<div id="u112" class="ax_text_field">
    <input id="u112_input" type="text"  name="nameOfCarModel" value=""/>
</div>

<div id="u113" class="ax_paragraph">
    <img id="u113_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u114" class="text">
        <p><span>Year of release</span><span>:</span></p>
    </div>
</div>

<div id="u115" class="ax_text_field">
    <select name="releaseYearOfModel" id="u115_input">
        <c:forEach items="${allYears}" var="allYears">
            <option  value="${allYears}"><c:out value="${allYears}" /></option>
        </c:forEach>
    </select>
</div>
</form>

<div id="u116" class="ax_shape">
    <img id="u116_img" class="img " src="jsp/accessories/images/operationwithmodels/u116.png"/>

    <div id="u117" class="text">
        <p><span></span></p>
    </div>
</div>



<form method="post" action="Controller">
    <input type="hidden" name="command" value="OPERATION_WITH_MODEL" />
    <input type="hidden" name="typeOfOperationWithModel" value="UPDATE_MODEL" />

<div id="u118" class="ax_h2">
    <img id="u118_img" class="img " src="jsp/accessories/images/operationwithmodels/u118.png"/>

    <div id="u119" class="text">
        <p><span>Изменить модель:</span></p>
    </div>
</div>

<div id="u123" class="ax_html_button">
    <input id="u123_input" type="submit" value="Изменить"/>
</div>

<div id="u124" class="ax_paragraph">
    <img id="u124_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u125" class="text">
        <p><span>Name of model</span><span>:</span></p>
    </div>
</div>

<div id="u126" class="ax_text_field">
    <input id="u126_input" type="text" name="nameOfCarModel" value=""/>
</div>

<div id="u127" class="ax_paragraph">
    <img id="u127_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u128" class="text">
        <p><span>Year of release</span><span>:</span></p>
    </div>
</div>

<div id="u129" class="ax_text_field">
    <select name="releaseYearOfModel" id="u129_input">
        <c:forEach items="${allYears}" var="allYears">
            <option  value="${allYears}"><c:out value="${allYears}" /></option>
        </c:forEach>
    </select>
</div>

<div id="u130" class="ax_paragraph">
    <img id="u130_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u131" class="text">
        <p><span>Identification</span></p><p><span>number</span><span>:</span></p>
    </div>
</div>

<div id="u132" class="ax_text_field">
    <select name="idOfCarModel" id="u132_input">
        <c:set value="${allBrandByModel}" var="allBrandByModel"></c:set>
        <c:forEach items="${allModel}" var="allModel" varStatus="status">
            <option  value="${allModel.carModelId}-${allBrandByModel[status.index].carBrandId}"><c:out value="${allModel.carModelId} (${allModel.nameModel}) -  ${allBrandByModel[status.index].nameBrand}" /></option>
        </c:forEach>
    </select>
</div>

<div id="u133" class="ax_shape">
    <img id="u133_img" class="img " src="jsp/accessories/images/operationwithmodels/u133.png"/>

    <div id="u134" class="text">
        <p><span></span></p>
    </div>
</div>
</form>



<form method="post" action="Controller">
    <input type="hidden" name="command" value="OPERATION_WITH_MODEL" />
    <input type="hidden" name="typeOfOperationWithModel" value="DELETE_MODEL" />
<div id="u135" class="ax_h2">
    <img id="u135_img" class="img " src="jsp/accessories/images/operationwithmodels/u135.png"/>

    <div id="u136" class="text">
        <p><span>Удалить модель:</span></p>
    </div>
</div>


<div id="u137" class="ax_paragraph">
    <img id="u137_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u138" class="text">
        <p><span>Identification </span><span>number</span><span>:</span></p>
    </div>
</div>


<div id="u139" class="ax_text_field">
    <select name="idOfCarModel" id="u139_input">
        <c:set value="${allBrandByModel}" var="allBrandByModel"></c:set>
        <c:forEach items="${allModel}" var="allModel" varStatus="status">
            <option  value="${allModel.carModelId}-${allBrandByModel[status.index].carBrandId}"><c:out value="${allModel.carModelId} (${allModel.nameModel}) -  ${allBrandByModel[status.index].nameBrand}" /></option>
        </c:forEach>
    </select>
</div>


<div id="u140" class="ax_html_button">
    <input id="u140_input" type="submit" value="Удалить"/>
</div>
</form>
</div>
</body>
</html>

