<%--
  Created by IntelliJ IDEA.
  User: Tatiana
  Date: 29.04.2015
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Operations with agents</title>
    <link href="jsp/accessories/resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/files/operationwithagents/styles.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div id="base" class="">

<a href="index.jsp">
<div id="u6" class="ax_shape">
    <a href="index.jsp"><img id="u6_img" class="img " src="jsp/accessories/images/index/u0.png"/></a>
    <a href="index.jsp">
    <div id="u7" class="text">
        <p><a href="index.jsp"><span>Логотип</span></a></p>
    </div>
        </a>
</div>
</a>

<a href="index.jsp">
<div id="u8" class="ax_h1">
    <a href="index.jsp"><img id="u8_img" class="img " src="jsp/accessories/images/index/u2.png"/></a>
    <a href="index.jsp">
    <div id="u9" class="text">
        <p><a href="index.jsp"><span>Система учёта автозапчастей</span></a></p><p><a href="index.jsp"><span>на складе</span></a></p>
    </div>
        </a>
</div>
</a>

<div id="u10" class="ax_h2">
    <img id="u10_img" class="img " src="jsp/accessories/images/onthepicture/u4.png"/>

    <div id="u11" class="text">
        <p><span>Операции с контрагентами:</span></p>
    </div>
</div>

<div id="u12" class="ax_table">
    <table border=1>
        <thead>
        <tr>
            <th>Номер агента</th>
            <th>Имя агента</th>
            <th>Адрес</th>
            <th>Телефон</th>
            <th>Тип агента</th>
            <th>Рейтинг</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${all1}" var="all">
            <tr>
                <td><c:out value="${all.agentId}" /></td>
                <td><c:out value="${all.nameOfAgent}" /></td>
                <td><c:out value="${all.address}" /></td>
                <td><c:out value="${all.phone}" /></td>
                <td><c:out value="${all.typeOfAgent}" /></td>
                <td><c:out value="${all.rating}" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>



<div id="u139" class="ax_shape">
    <img id="u139_img" class="img " src="jsp/accessories/images/operationwithagents/u139.png"/>

    <div id="u140" class="text">
        <p><span></span></p>
    </div>
</div>


<form method="post" action="Controller">
    <input type="hidden" name="command" value="OPERATION_WITH_AGENT" />
    <input type="hidden" name="typeOfOperationWithAgent" value="CREATE_AGENT" />
<div id="u141" class="ax_h2">
    <img id="u141_img" class="img " src="jsp/accessories/images/operationwithagents/u141.png"/>

    <div id="u142" class="text">
        <p><span>Добавить нового агента:</span></p>
    </div>
</div>

<div id="u143" class="ax_paragraph">
    <img id="u143_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u144" class="text">
        <p><span>Имя агента:</span></p>
    </div>
</div>

<div id="u145" class="ax_text_field">
    <input name="nameOfAgent" id="u145_input" type="text" value=""/>
</div>

<div id="u146" class="ax_html_button">
    <input id="u146_input" type="submit" value="Добавить"/>
</div>

<div id="u147" class="ax_paragraph">
    <img id="u147_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u148" class="text">
        <p><span>Адрес:</span></p>
    </div>
</div>

<div id="u149" class="ax_text_field">
    <input id="u149_input" type="text" name="addressOfAgent" value=""/>
</div>

<div id="u150" class="ax_paragraph">
    <img id="u150_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u151" class="text">
        <p><span>Телефон:</span></p>
    </div>
</div>

<div id="u152" class="ax_text_field">
    <input id="u152_input" pattern="[0-9]+" type="text" name="phoneOfAgent" value=""/>
</div>
<div id="u169" class="ax_paragraph">
    <img id="u169_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u170" class="text">
        <p><span>Тип агента:</span></p>
    </div>
</div>

<div id="u171" class="ax_text_field">
    <select name="typeOfAgent" id="u171_input">
        <c:forEach items="${allTypeOfAgent}" var="allTypeOfAgent">
            <option  value="${allTypeOfAgent}"><c:out value="${allTypeOfAgent}" /></option>
        </c:forEach>
    </select>
</div>

<div id="u172" class="ax_paragraph">
    <img id="u172_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u173" class="text">
        <p><span>Рейтинг:</span></p>
    </div>
</div>

<div id="u174" class="ax_text_field">
    <select name="ratingOfAgent" id="u174_input">
        <c:forEach items="${allRating}" var="allRating">
            <option  value="${allRating}"><c:out value="${allRating}" /></option>
        </c:forEach>
    </select>
</div>
</form>


<form method="post" action="Controller">
    <input type="hidden" name="command" value="OPERATION_WITH_AGENT" />
    <input type="hidden" name="typeOfOperationWithAgent" value="UPDATE_AGENT" />
<div id="u153" class="ax_shape">
    <img id="u153_img" class="img " src="jsp/accessories/images/operationwithagents/u153.png"/>

    <div id="u154" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u155" class="ax_h2">
    <img id="u155_img" class="img " src="jsp/accessories/images/operationwithagents/u155.png"/>

    <div id="u156" class="text">
        <p><span>Изменить контрагента:</span></p>
    </div>
</div>

<div id="u157" class="ax_html_button">
    <input id="u157_input" type="submit" value="Изменить"/>
</div>

<div id="u158" class="ax_paragraph">
    <img id="u158_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u159" class="text">
        <p><span>Номер</span></p><p><span>агента</span><span>:</span></p>
    </div>
</div>

<div id="u160" class="ax_text_field">
    <select name="idOfAgent" id="u160_input">
        <c:forEach items="${all1}" var="all">
            <option  value="${all.agentId}"><c:out value="${all.agentId} (${all.nameOfAgent})" /></option>
        </c:forEach>
    </select>
</div>

<div id="u161" class="ax_shape">
    <img id="u161_img" class="img " src="jsp/accessories/images/operationwithmodels/u133.png"/>

    <div id="u162" class="text">
        <p><span></span></p>
    </div>
</div>
    <div id="u175" class="ax_paragraph">
        <img id="u175_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

        <div id="u176" class="text">
            <p><span>Имя агента:</span></p>
        </div>
    </div>

    <div id="u177" class="ax_text_field">
        <input id="u177_input" name="nameOfAgent" type="text" value=""/>
    </div>

    <div id="u178" class="ax_paragraph">
        <img id="u178_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

        <div id="u179" class="text">
            <p><span>Address:</span></p>
        </div>
    </div>

    <div id="u180" class="ax_text_field">
        <input id="u180_input" type="text" name="addressOfAgent" value=""/>
    </div>

    <div id="u181" class="ax_paragraph">
        <img id="u181_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

        <div id="u182" class="text">
            <p><span>Телефон:</span></p>
        </div>
    </div>

    <div id="u183" class="ax_text_field">
        <input id="u183_input"  pattern="[0-9]+" type="text" name="phoneOfAgent" value=""/>
    </div>

    <div id="u184" class="ax_paragraph">
        <img id="u184_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

        <div id="u185" class="text">
            <p><span>Тип агента:</span></p>
        </div>
    </div>

    <div id="u186" class="ax_text_field">
        <select name="typeOfAgent" id="u186_input">
            <c:forEach items="${allTypeOfAgent}" var="allTypeOfAgent">
                <option  value="${allTypeOfAgent}"><c:out value="${allTypeOfAgent}" /></option>
            </c:forEach>
        </select>
    </div>

    <div id="u187" class="ax_paragraph">
        <img id="u187_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

        <div id="u188" class="text">
            <p><span>Rating:</span></p>
        </div>
    </div>

    <div id="u189" class="ax_text_field">
        <select name="ratingOfAgent" id="u189_input">
            <c:forEach items="${allRating}" var="allRating">
                <option  value="${allRating}"><c:out value="${allRating}" /></option>
            </c:forEach>
        </select>
    </div>
    </form>


<form method="post" action="Controller">
    <input type="hidden" name="command" value="OPERATION_WITH_AGENT" />
    <input type="hidden" name="typeOfOperationWithAgent" value="DELETE_AGENT" />

<div id="u163" class="ax_h2">
    <img id="u163_img" class="img " src="jsp/accessories/images/operationwithagents/u163.png"/>

    <div id="u164" class="text">
        <p><span>Удалить контрагента:</span></p>
    </div>
</div>

<div id="u165" class="ax_paragraph">
    <img id="u165_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u166" class="text">
        <p><span>Номер </span><span>агента</span><span>:</span></p>
    </div>
</div>

<div id="u167" class="ax_text_field">
    <select name="idOfAgent" id="u167_input">
        <c:forEach items="${all1}" var="all">
            <option  value="${all.agentId}"><c:out value="${all.agentId} (${all.nameOfAgent})" /></option>
        </c:forEach>
    </select>
</div>

<div id="u168" class="ax_html_button">
    <input id="u168_input" type="submit" value="Удалить"/>

</div>
    </form>
</div>
</body>
</html>
