<%--
  Created by IntelliJ IDEA.
  User: Tatiana
  Date: 02.05.2015
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Enter new items</title>
    <link href="jsp/accessories/resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/files/enternewitems/styles.css" type="text/css" rel="stylesheet"/>
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
    <script src="jsp/accessories/files/enternewitems/data.js"></script>
    <script src="jsp/accessories/resources/scripts/axure/legacy.js"></script>
    <script src="jsp/accessories//scripts/axure/viewer.js"></script>
    <script type="text/javascript">
        $axure.utils.getTransparentGifPath = function () {
            return 'jsp/accessories/resources/images/transparent.gif';
        };
        $axure.utils.getOtherPath = function () {
            return 'jsp/accessories/resources/Other.html';
        };
        $axure.utils.getReloadPath = function () {
            return 'jsp/accessories/resources/reload.html';
        };
    </script>
    <script type="text/javascript">

        jQuery(function($) {

            $.mask.definitions['~']='[+-]';

            $('#u23_input').mask('99.99.9999');
        });</script>

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
                <p><a href="index.jsp"><span>Система учёта автозапчастей</span></a></p>

                <p><a href="index.jsp"><span>на складе</span></a></p>
            </div>
        </a>
    </div>
</a>

<div id="u4" class="ax_h2">
    <img id="u4_img" class="img " src="jsp/accessories/images/onthepicture/u4.png"/>

    <div id="u5" class="text">
        <p><span>Ввод новых деталей в базу</span></p>
    </div>
</div>

<form method="post" action="Controller">
    <input type="hidden" name="command" value="ENTER_NEW_ITEMS"/>
    <input type="hidden" name="typeOfEnterNewAutoParts" value="ENTER_BY_FILE"/>

    <div id="u6" class="ax_shape">
        <img id="u6_img" class="img " src="jsp/accessories/images/enternewitems/u6.png"/>

        <div id="u7" class="text">
            <p><span></span></p>
        </div>
    </div>

    <div id="u8" class="ax_shape">
        <img id="u8_img" class="img " src="jsp/accessories/images/enternewitems/u8.png"/>

        <div id="u9" class="text">
            <p><span></span></p>
        </div>
    </div>

    <div id="u10" class="ax_h2">
        <img id="u10_img" class="img " src="jsp/accessories/images/enternewitems/u10.png"/>

        <div id="u11" class="text">
            <p><span>Ведите данные о накладной:</span></p>
        </div>
    </div>

    <div id="u12" class="ax_h2">
        <img id="u12_img" class="img " src="jsp/accessories/images/enternewitems/u12.png"/>

        <div id="u13" class="text">
            <p><span><c:out value='${message1}'>Через файл</c:out></span></p>
        </div>
    </div>


    <div id="u14" class="ax_paragraph">
        <img id="u14_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

        <div id="u15" class="text">
            <p><span>Абсолютное имя файла:</span></p>
        </div>
    </div>

    <div id="u16" class="ax_text_field">
        <input name="nameOfFile" id="u16_input" type="text" value=""/>
    </div>

    <div id="u17" class="ax_html_button">
        <input id="u17_input" type="submit" value="Ввести"/>
    </div>
</form>


<form method="post" action="Controller">
    <input type="hidden" name="command" value="ENTER_NEW_ITEMS"/>
    <input type="hidden" name="typeOfEnterNewAutoParts" value="NEW_AUTOPART"/>

    <div id="u27" class="ax_shape">
        <img id="u27_img" class="img " src="jsp/accessories/images/enternewitems/u27.png"/>

        <div id="u28" class="text">
            <p><span></span></p>
        </div>
    </div>

    <div id="u29" class="ax_h2">
        <img id="u29_img" class="img " src="jsp/accessories/images/enternewitems/u29.png"/>

        <div id="u30" class="text">
            <p><span>Добавить новую</span></p>

            <p><span> запчасть:</span></p>
        </div>
    </div>

    <div id="u31" class="ax_paragraph">
        <img id="u31_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

        <div id="u32" class="text">
            <p><span><c:out value='${message3}'>Имя автозапчасти</c:out></span></p>
        </div>
    </div>

    <div id="u33" class="ax_text_field">
        <input name="nameOfAutopart" id="u33_input" type="text" value=""/>
    </div>

    <div id="u34" class="ax_html_button">
        <input id="u34_input" type="submit" value="Добавить"/>
    </div>
</form>


<form method="post" action="Controller" >
    <input type="hidden" name="command" value="ENTER_NEW_ITEMS"/>
    <input type="hidden" name="typeOfEnterNewAutoParts" value="ENTER_INVOICE_BY_KEYBOARD"/>

    <div id="u18" class="ax_paragraph">
        <img id="u18_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

        <div id="u19" class="text">
            <p><span>Количество наименований</span></p>

            <p><span>автозапчастей в накладной</span></p>
        </div>
    </div>

    <div id="u20" class="ax_text_field">
        <input name="numberOfAutoPartsItems" id="u20_input" type="text" value=""/>
    </div>

    <div id="u21" class="ax_paragraph">
        <img id="u21_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

        <div id="u22" class="text">
            <p><span>Дата:</span></p>
        </div>
    </div>

    <div id="u23" class="ax_text_field">
        <input name="dateOfInvoice" id="u23_input" type="text" value=""/>
    </div>

    <div id="u24" class="ax_paragraph">
        <img id="u24_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

        <div id="u25" class="text">

            <p><span>Номер</span><span>&nbsp;</span><span>контрагента:</span></p>
        </div>
    </div>


    <div id="u35" class="ax_droplist">
        <select name="idOfAgent" id="u35_input">
            <c:forEach items="${allAgent}" var="allAgent">
                <option value="${allAgent.agentId}"><c:out
                        value="${allAgent.agentId} (${allAgent.nameOfAgent})"/></option>
            </c:forEach>
        </select>
    </div>

    <div id="u26" class="ax_html_button">
        <input id="u26_input" type="submit" value="Добавить"/>

    </div>


</form>



<form method="post" action="Controller" id="container" >
    <input type="hidden" name="command" value="ENTER_NEW_ITEMS"/>
    <input type="hidden" name="typeOfEnterNewAutoParts" value="ENTER_DETAILS_BY_KEYBOARD"/>

    <div id="u36" class="ax_shape">
        <img id="u36_img" class="img " src="jsp/accessories/images/enternewitems/u36.png"/>

        <div id="u37" class="text">
            <p><span></span></p>
        </div>
    </div>

    <div id="u38" class="ax_paragraph">
        <img id="u38_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

        <div id="u39" class="text">

            <p><span>Номер</span><span>&nbsp;</span><span>автозапчасти:</span></p>
        </div>
    </div>
    <div id="u60" class="ax_droplist">

        <select name="idOfAutoPart" id="u60_input">
            <c:forEach items="${allAutoParts}" var="allAutoParts">
                <option value="${allAutoParts.autoPartId}"><c:out
                        value="${allAutoParts.autoPartId} (${allAutoParts.name})"/></option>
            </c:forEach>
        </select>

    </div>
    <div id="u40" class="ax_paragraph">
        <img id="u40_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

        <div id="u41" class="text">
            <p><span>Цена:</span></p>
        </div>
    </div>

    <div id="u42" class="ax_text_field">
        <input name="priceOfAutoPart" id="u42_input" type="text" value="" />
    </div>

    <div id="u43" class="ax_paragraph">
        <img id="u43_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

        <div id="u44" class="text">
            <p><span>Количество:</span></p>
        </div>
    </div>

    <div id="u45" class="ax_text_field">
        <input name="numberOfAutoPart" id="u45_input" type="text" value="" />
    </div>

    <div id="u46" class="ax_paragraph">
        <img id="u46_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

        <div id="u47" class="text">
            <p><span>Валюта:</span></p>
        </div>
    </div>

    <div id="u48" class="ax_text_field">
        <select name="typeOfCurrency" id="u48_input">
            <c:forEach items="${allCurrency}" var="allCurrency">
                <option  value="${allCurrency}"><c:out value="${allCurrency}" /></option>
            </c:forEach>
        </select>
    </div>

    <div id="u49" class="ax_html_button">
        <input id="u49_input" type="submit" value="Добавить"/>
    </div>

    <div id="u50" class="ax_paragraph">
        <img id="u50_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

        <div id="u51" class="text">
            <p><span><c:out value='${message2}'></c:out></span></p>
        </div>
    </div>

</form>



<form method="post" action="Controller">
    <input type="hidden" name="command" value="ENTER_NEW_ITEMS"/>
    <input type="hidden" name="typeOfEnterNewAutoParts" value="ENTER_BRANDS_BY_FILE"/>

    <div id="u53" class="ax_shape">
        <img id="u53_img" class="img " src="jsp/accessories/images/enternewitems/u53.png"/>

        <div id="u54" class="text">
            <p><span></span></p>
        </div>
    </div>

    <div id="u59" class="ax_html_button">
        <input id="u59_input" type="submit" value="Ввести"/>
    </div>

    <div id="u62" class="ax_list_box">
        <p><span><c:out value='${message4}'>В файле содержится соответствие определённой автозапчасти определённым брендам и их моделям</c:out></span></p>
    </div>

    <div id="u55" class="ax_h2">
        <div id="u56" class="text">
            <p><span>Имя файла</span></p>
        </div>
    </div>

    <div id="u61" class="ax_text_field">
        <input name="nameOfFile" id="u61_input" type="text" value=""/>
    </div>

</form>

</div>
</body>
</html>

