<%--
  Created by IntelliJ IDEA.
  User: Tatiana
  Date: 02.05.2015
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Remove Items</title>
    <link href="jsp/accessories/resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/files/removeitems/styles.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div id="base" class="">
<a href="index.jsp">
<div id="u0" class="ax_shape">
    <a href="index.jsp"> <img id="u0_img" class="img " src="jsp/accessories/images/index/u0.png"/></a>
    <a href="index.jsp">
    <div id="u1" class="text">
        <p><a href="index.jsp"><span>Логотип</span></a></p>
    </div>
        </a>
</div>
</a>
<a href="index.jsp">
<div id="u2" class="ax_h1">
    <a href="index.jsp"><img id="u2_img" class="img " src="jsp/accessories/images/index/u2.png"/></a>
    <a href="index.jsp">
    <div id="u3" class="text">
        <p><a href="index.jsp"><span>Система учёта автозапчастей</span></a></p><p><a href="index.jsp"><span>на складе</span></a></p>
    </div>
        </a>
</div>
    </a>

<div id="u4" class="ax_h2">
    <img id="u4_img" class="img " src="jsp/accessories/images/onthepicture/u4.png"/>

    <div id="u5" class="text">
        <p><span>Выведение запчастей из базы</span></p>
    </div>
</div>


<form method="post" action="Controller">
    <input type="hidden" name="command" value="REMOVE_ITEMS" />
    <input type="hidden" name="typeOfRemoveItems" value="REMOVE_BY_FILE" />
<div id="u6" class="ax_shape">
    <img id="u6_img" class="img " src="jsp/accessories/images/removeitems/u6.png"/>

    <div id="u7" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u8" class="ax_h2">
    <img id="u8_img" class="img " src="jsp/accessories/images/enternewitems/u12.png"/>

    <div id="u9" class="text">
        <p><span><c:out value='${message2}'>Через файл</c:out></span></p>
    </div>
</div>

<div id="u10" class="ax_paragraph">
    <img id="u10_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u11" class="text">
        <p><span>Имя файла:</span></p>
    </div>
</div>

<div id="u12" class="ax_text_field">
    <input name="nameOfFile" id="u12_input" type="text" value=""/>
</div>

<div id="u13" class="ax_html_button">
    <input id="u13_input" type="submit" value="Выполнить"/>
</div>
</form>

<form method="post" action="Controller">
    <input type="hidden" name="command" value="REMOVE_ITEMS" />
    <input type="hidden" name="typeOfRemoveItems" value="REMOVE_AUTOPART" />
<div id="u14" class="ax_shape">
    <img id="u14_img" class="img " src="jsp/accessories/images/removeitems/u14.png"/>

    <div id="u15" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u16" class="ax_h2">
    <img id="u16_img" class="img " src="jsp/accessories/images/removeitems/u16.png"/>

    <div id="u17" class="text">
        <p><span>Удалить</span></p><p><span></span><span>атозапчасть:</span></p>
    </div>
</div>

<div id="u18" class="ax_paragraph">
    <img id="u18_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u19" class="text">
        <p><span><c:out value='${message1}'>Номер автозапчасти</c:out>:</span></p>
    </div>
</div>

    <div id="u50" class="ax_droplist">
        <select name="idOfAutoPart"  id="u50_input" >
            <c:forEach items="${allAutoParts}" var="allAutoParts">
                <option  value="${allAutoParts.autoPartId}"><c:out value="${allAutoParts.autoPartId} (${allAutoParts.name})" /></option>
            </c:forEach>
        </select>
    </div>

<div id="u20" class="ax_html_button">
    <input id="u20_input" type="submit" value="Удалить"/>
</div>
</form>



<form method="post" action="Controller">
    <input type="hidden" name="command" value="REMOVE_ITEMS" />
    <input type="hidden" name="typeOfRemoveItems" value="REMOVE_INVOICE_BY_KEYBOARD" />
<div id="u21" class="ax_shape">
    <img id="u21_img" class="img " src="jsp/accessories/images/enternewitems/u6.png"/>

    <div id="u22" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u23" class="ax_h2">
    <img id="u23_img" class="img " src="jsp/accessories/images/removeitems/u23.png"/>

    <div id="u24" class="text">
        <p><span>Отгрузка автозапчастей:</span></p>
    </div>
</div>

<div id="u25" class="ax_paragraph">
    <img id="u25_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u26" class="text">
       <p><span>Количество наименований</span></p>

        <p><span>автозапчастей в накладной</span></p>
    </div>
</div>

<div id="u27" class="ax_text_field">
    <input name="numberOfAutoPartsItems"  pattern="[0-9]+" id="u27_input" type="text" value=""/>
</div>

<div id="u28" class="ax_paragraph">
    <img id="u28_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u29" class="text">
        <p><span>Дата:</span></p>
    </div>
</div>

<div id="u30" class="ax_text_field">
    <input name="dateOfInvoice" id="u30_input" type="date" value=""/>
</div>

<div id="u31" class="ax_paragraph">
    <img id="u31_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u32" class="text">
        <br/>  <p><span>Номер</span><span>&nbsp;</span><span>контрагента:</span></p>
    </div>
</div>

<div id="u34" class="ax_droplist">
    <select name="idOfAgent"  id="u34_input">
        <c:forEach items="${allAgent}" var="allAgent">
            <option  value="${allAgent.agentId}"><c:out value="${allAgent.agentId} (${allAgent.nameOfAgent})" /></option>
        </c:forEach>
    </select>
</div>

<div id="u33" class="ax_html_button">
    <input id="u33_input" type="submit" value="Добавить"/>
</div>
</form>


<form method="post" action="Controller" id="container" >
    <input type="hidden" name="command" value="REMOVE_ITEMS"/>
    <input type="hidden" name="typeOfRemoveItems" value="REMOVE_DETAILS_BY_KEYBOARD"/>
<div id="u35" class="ax_shape">
    <img id="u35_img" class="img " src="jsp/accessories/images/removeitems/u35.png"/>

    <div id="u36" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u37" class="ax_paragraph">
    <img id="u37_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u38" class="text">
        <p><span>Номер</span><span>&nbsp;</span><span>автозапчасти:</span></p>
    </div>
</div>

<div id="u49" class="ax_droplist">
    <select name="idOfAutoPart"  id="u49_input" >
        <c:forEach items="${allAutoParts}" var="allAutoParts">
            <option  value="${allAutoParts.autoPartId}"><c:out value="${allAutoParts.autoPartId} (${allAutoParts.name})" /></option>
        </c:forEach>
    </select>
</div>

<div id="u39" class="ax_paragraph">
    <img id="u39_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u40" class="text">
        <p><span>Цена:</span></p>
    </div>
</div>

<div id="u41" class="ax_text_field">
    <input name="priceOfAutoPart"  pattern="[0-9]+" id="u41_input" type="text" value="" />
</div>

<div id="u42" class="ax_paragraph">
    <img id="u42_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u43" class="text">
        <p><span>Количество:</span></p>
    </div>
</div>

<div id="u44" class="ax_text_field">
    <input name="numberOfAutoPart"  pattern="[0-9]+" id="u44_input" type="text" value="" />
</div>

<div id="u45" class="ax_paragraph">
    <img id="u45_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u46" class="text">
        <p><span>Валюта:</span></p>  <div id="u51" class="text"><br/>
        <p><span><c:out value='${message3}'></c:out></span></p>
    </div>
    </div>
</div>

<div id="u47" class="ax_text_field">
    <select name="typeOfCurrency" id="u47_input">
        <c:forEach items="${allCurrency}" var="allCurrency">
            <option  value="${allCurrency}"><c:out value="${allCurrency}" /></option>
        </c:forEach>
    </select>
</div>

<div id="u48" class="ax_html_button">
    <input id="u48_input" type="submit" value="Добавить"/>
</div>


</form>
    </form>
</div>
</body>
</html>

