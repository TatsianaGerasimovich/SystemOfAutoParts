<%--
  Created by IntelliJ IDEA.
  User: Tatiana
  Date: 30.04.2015
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Generation of report</title>
    <link href="jsp/accessories/resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/files/report/styles.css" type="text/css" rel="stylesheet"/>
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
    <script src="jsp/accessories/files/report/data.js"></script>
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
    <div id="u0" class="ax_shape">
        <a href="index.jsp"><img id="u0_img" class="img " src="jsp/accessories/images/index/u0.png"/></a>
        <a href="index.jsp">
        <div id="u1" class="text">
            <p><a href="index.jsp"><span>Логотип</span></a></p>
        </div>
            </a>
    </div>
</a>
    <a href="index.jsp">
    <div id="u2" class="ax_h1">
        <a href="index.jsp"> <img id="u2_img" class="img " src="jsp/accessories/images/index/u2.png"/></a>
        <a href="index.jsp">
        <div id="u3" class="text">
            <p><a href="index.jsp"><span>Система учёта автозапчастей</span></a></p><p><a href="index.jsp"><span>на складе</span></a></p>
        </div>
            </a>
    </div>
        </a>

    <div id="u4" class="ax_h2">
        <img id="u4_img" class="img " src="jsp/accessories/images/report/u4.png"/>

        <div id="u5" class="text">
            <p><span>Генерация отчётов:</span></p>
        </div>
    </div>

    <div id="u6" class="ax_shape">
        <img id="u6_img" class="img " src="jsp/accessories/images/report/u6.png"/>

        <div id="u7" class="text">
            <p><span></span></p>
        </div>
    </div>

    <a href="Controller?command=GENERATION_REPORT&typeOfReport=reportOfAll">
    <div id="u8" class="ax_shape">
        <a href="Controller?command=GENERATION_REPORT&typeOfReport=reportOfAll">
            <img id="u8_img" class="img " src="jsp/accessories/images/index/u270.png"/>
            </a>
        <a href="Controller?command=GENERATION_REPORT&typeOfReport=reportOfAll">
        <div id="u9" class="text">
            <p><a href="Controller?command=GENERATION_REPORT&typeOfReport=reportOfAll"><span><c:out value='${reportAll1}'>Оформить отчёт о количестве всех видов запчастей</c:out></span></a></p>
        </div>
            </a>
    </div>
        </a>

    <a href="Controller?command=GENERATION_REPORT&typeOfReport=reportAboutScarce">
    <div id="u10" class="ax_shape">
        <a href="Controller?command=GENERATION_REPORT&typeOfReport=reportAboutScarce">
        <img id="u10_img" class="img " src="jsp/accessories/images/index/u270.png"/>
</a>
        <a href="Controller?command=GENERATION_REPORT&typeOfReport=reportAboutScarce"><div id="u11" class="text">
            <p><a href="Controller?command=GENERATION_REPORT&typeOfReport=reportAboutScarce"><span><c:out value='${reportAll2}'>Оформить отчёт о дефицитных запчастях</c:out></span></a></p>
        </div></a>
    </div>
</a>
    <div id="u12" class="ax_shape">
        <img id="u12_img" class="img " src="jsp/accessories/images/report/u12.png"/>

        <div id="u13" class="text">
            <p><span></span></p>
        </div>
    </div>

    <form method="post" action="Controller">
        <input type="hidden" name="command" value="GENERATION_REPORT" />
        <input type="hidden" name="typeOfReport" value="reportAboutResiduesInStock" />

    <div id="u14" class="ax_paragraph">
        <img id="u14_img" class="img " src="jsp/accessories/images/report/u14.png"/>

        <div id="u15" class="text">
            <p><span>Identification</span></p><p><span> number of autopart:</span></p>
        </div>
    </div>

    <div id="u16" class="ax_text_field">
        <select name="idOfAutoPart" id="u16_input">
            <c:forEach items="${allAutoParts}" var="allAutoParts">
                <option  value="${allAutoParts.autoPartId}"><c:out value="${allAutoParts.autoPartId} (${allAutoParts.name})" /></option>
            </c:forEach>
        </select>
    </div>

        <div id="u17" class="ax_shape">

              <img id="u17_img" class="img " src="jsp/accessories/images/report/u17.png"/>
              <input id="u18" type="submit" value=" <c:out value='${reportAll3}'>Оформить отчёт об остатках на складе выбранной запчасти</c:out>"/>

        </div>


        </form>
</div>
</body>
</html>

