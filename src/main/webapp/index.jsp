<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Welcom to system</title>
    <link href="jsp/accessories/resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="jsp/accessories/files/index/styles.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript">
        function submitForm(formId) {
            document.getElementById(formId).submit();
        }
    </script>
</head>
<body>
<div id="base" class="">

<div id="u0" class="ax_shape">
    <img id="u0_img" class="img " src="jsp/accessories/images/index/u0.png"/>

    <div id="u1" class="text">
        <p><span>Логотип</span></p>
    </div>
</div>

<div id="u2" class="ax_h1">
    <img id="u2_img" class="img " src="jsp/accessories/images/index/u2.png"/>

    <div id="u3" class="text">
        <p><span>Система учёта автозапчастей</span></p><p><span>на складе</span></p>
    </div>
</div>

<div id="u4" class="ax_shape">
    <img id="u4_img" class="img " src="jsp/accessories/images/index/u4.png"/>

    <div id="u5" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u6" class="ax_shape" onclick="submitForm('SORT')">
    <form action="Controller" id="SORT" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_WITH_SORT">
        <input type="hidden" name="sortType" value="AutoParts.AutoPartId">
    </form>
    <img onclick="submitForm('SORT')" id="u6_img" class="img " src="jsp/accessories/images/index/u6.png"/>

    <div id="u7" class="text" onclick="submitForm('SORT')">
        <p ><span>Перечень имеющихся автозапчастей</span></p>
    </div>
</div>


<div id="u8" class="ax_shape" onclick="submitForm('Search')">
    <form action="Controller" id="Search" method="post">
        <input type="hidden" name="command" value="DO_SEARCH">
        <input type="hidden" name="whereSearch" value="notSearch">
        <input type="hidden" name="whatSearch" value="null">
    </form>
    <img id="u8_img" class="img " src="jsp/accessories/images/index/u6.png"/>

    <div id="u9" class="text" onclick="submitForm('Search')">
        <p><span>П</span><span>оиск</span></p>
    </div>
</div>


<div id="u10" class="ax_shape" onclick="submitForm('REPORT')">
    <form action="Controller" id="REPORT" method="post">
        <input type="hidden" name="command" value="GENERATION_REPORT">
        <input type="hidden" name="typeOfReport" value="nothing">
    </form>
   <img id="u10_img" class="img " src="jsp/accessories/images/index/u6.png"/>

    <div id="u11" class="text">
        <p><span>Г</span><span>енерация Отчёта</span></p>
    </div>

</div>


<div id="u12" class="ax_shape" onclick="submitForm('ENTER')">
    <form action="Controller" id="ENTER" method="post">
        <input type="hidden" name="command" value="ENTER_NEW_ITEMS">
        <input type="hidden" name="typeOfEnterNewAutoParts" value="nothing">
    </form>
     <img id="u12_img" class="img " src="jsp/accessories/images/index/u6.png"/>

    <div id="u13" class="text">
        <p><span>В</span><span>вод принятых автозапчастей</span></p>
    </div>
</div>



<div id="u14" class="ax_shape" onclick="submitForm('REMOVE')">
    <form action="Controller" id="REMOVE" method="post">
        <input type="hidden" name="command" value="REMOVE_ITEMS">
        <input type="hidden" name="typeOfRemoveItems" value="nothing">
    </form>
  <img id="u14_img" class="img " src="jsp/accessories/images/index/u6.png"/>

    <div id="u15" class="text">
        <p><span>Вывод из системы отгруженных запчастей</span></p>
    </div>
</div>


<div id="u16" class="ax_shape">
    <img id="u16_img" class="img " src="jsp/accessories/images/index/u16.png"/>

    <div id="u17" class="text">
        <p><span></span></p>
    </div>
</div>


<div id="u18" class="ax_image" onclick="submitForm('ALFA ROMEO')">
    <form action="Controller" id="ALFA ROMEO" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="ALFA ROMEO">
    </form>
    <img id="u18_img" class="img " src="jsp/accessories/images/index/u18.png"/>

    <div id="u19" class="text">
        <p><span></span></p>
    </div>
</div>


<div id="u20" class="ax_h2">
    <img id="u20_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u21" class="text">
        <p><span>Е</span><span>вропа</span></p>
    </div>
</div>

<div id="u22" class="ax_paragraph" onclick="submitForm('ALFA ROMEO')">
    <img id="u22_img" class="img " src="jsp/accessories/images/index/u22.png"/>
    <div id="u23" class="text">
        <p><span>ALFA ROMEO</span></p>
    </div>
</div>

<div id="u24" class="ax_image" onclick="submitForm('AUDI')">
    <form action="Controller" id="AUDI" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="AUDI">
    </form>
     <img id="u24_img" class="img " src="jsp/accessories/images/index/u24.png"/>

    <div id="u25" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u26" class="ax_paragraph" onclick="submitForm('AUDI')">
    <img id="u26_img" class="img " src="jsp/accessories/images/index/u26.png"/>

    <div id="u27" class="text">
        <p><span>AUDI</span></p>
    </div>
</div>


<div id="u28" class="ax_image" onclick="submitForm('BENTLEY')">
    <form action="Controller" id="BENTLEY" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="BENTLEY">
    </form>
   <img id="u28_img" class="img " src="jsp/accessories/images/index/u28.png"/>

    <div id="u29" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u30" class="ax_paragraph" onclick="submitForm('BENTLEY')">
   <img id="u30_img" class="img " src="jsp/accessories/images/index/u30.png"/>
    <div id="u31" class="text">
        <p><span>BENTLEY</span></p>
    </div>
</div>

<div id="u32" class="ax_image" onclick="submitForm('BMW')">
    <form action="Controller" id="BMW" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="BMW">
    </form>
    <img id="u32_img" class="img " src="jsp/accessories/images/index/u32.png"/>
    <div id="u33" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u34" class="ax_paragraph" onclick="submitForm('BMW')">
    <img id="u34_img" class="img " src="jsp/accessories/images/index/u34.png"/>
    <div id="u35" class="text">
        <p><span>BMW</span></p>
    </div>
</div>

<div id="u36" class="ax_image" onclick="submitForm('CITROEN')">
    <form action="Controller" id="CITROEN" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="CITROEN">
    </form>
   <img id="u36_img" class="img " src="jsp/accessories/images/index/u36.png"/>
    <div id="u37" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u38" class="ax_paragraph" onclick="submitForm('CITROEN')">
   <img id="u38_img" class="img " src="jsp/accessories/images/index/u38.png"/>

    <div id="u39" class="text">
        <p><span>CITROEN</span></p>
    </div>
</div>

<div id="u40" class="ax_image" onclick="submitForm('DACIA')">
    <form action="Controller" id="DACIA" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="DACIA">
    </form>
   <img id="u40_img" class="img " src="jsp/accessories/images/index/u40.png"/>

    <div id="u41" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u42" class="ax_paragraph" onclick="submitForm('DACIA')">
    <img id="u42_img" class="img " src="jsp/accessories/images/index/u42.png"/>
    <div id="u43" class="text">
        <p><span>DACIA</span></p>
    </div>
</div>

<div id="u44" class="ax_image" onclick="submitForm('DAF')">
    <form action="Controller" id="DAF" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="DAF">
    </form>
    <img id="u44_img" class="img " src="jsp/accessories/images/index/u44.png"/>

    <div id="u45" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u46" class="ax_paragraph" onclick="submitForm('DAF')">
   <img id="u46_img" class="img " src="jsp/accessories/images/index/u46.png"/>
    <div id="u47" class="text">
        <p><span>DAF</span></p>
    </div>
</div>

<div id="u48" class="ax_image" onclick="submitForm('FERRARI')">
    <form action="Controller" id="FERRARI" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="FERRARI">
    </form>
   <img id="u48_img" class="img " src="jsp/accessories/images/index/u48.png"/>

    <div id="u49" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u50" class="ax_paragraph" onclick="submitForm('FERRARI')">
    <img id="u50_img" class="img " src="jsp/accessories/images/index/u38.png"/>

    <div id="u51" class="text">
        <p><span>FERRARI</span></p>
    </div>
</div>

<div id="u52" class="ax_image" onclick="submitForm('FIAT')">
    <form action="Controller" id="FIAT" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="FIAT">
    </form>
    <img id="u52_img" class="img " src="jsp/accessories/images/index/u52.png"/>
    <div id="u53" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u54" class="ax_paragraph" onclick="submitForm('FIAT')">
    <img id="u54_img" class="img " src="jsp/accessories/images/index/u46.png"/>
    <div id="u55" class="text">
        <p><span>FIAT</span></p>
    </div>
</div>

<div id="u56" class="ax_image" onclick="submitForm('FORD')">
    <form action="Controller" id="FORD" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="FORD">
    </form>
    <img id="u56_img" class="img " src="jsp/accessories/images/index/u56.png"/>
    <div id="u57" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u58" class="ax_paragraph" onclick="submitForm('FORD')">
   <img id="u58_img" class="img " src="jsp/accessories/images/index/u58.png"/>

    <div id="u59" class="text">
        <p><span>FORD</span></p>
    </div>
</div>

<div id="u60" class="ax_image" onclick="submitForm('IVECO')">
    <form action="Controller" id="IVECO" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="IVECO">
    </form>
    <img id="u60_img" class="img " src="jsp/accessories/images/index/u60.png"/>
    <div id="u61" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u62" class="ax_paragraph" onclick="submitForm('IVECO')">
   <img id="u62_img" class="img " src="jsp/accessories/images/index/u62.png"/>
    <div id="u63" class="text">
        <p><span>IVECO</span></p>
    </div>
</div>

<div id="u64" class="ax_image" onclick="submitForm('JAGUAR')">
    <form action="Controller" id="JAGUAR" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="JAGUAR">
    </form>
    <img id="u64_img" class="img " src="jsp/accessories/images/index/u64.png"/>
    <div id="u65" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u66" class="ax_paragraph" onclick="submitForm('JAGUAR')">
    <img id="u66_img" class="img " src="jsp/accessories/images/index/u66.png"/>
    <div id="u67" class="text">
        <p><span>JAGUAR</span></p>
    </div>
</div>

<div id="u68" class="ax_image" onclick="submitForm('LADA')">
    <form action="Controller" id="LADA" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="LADA">
    </form>
    <img id="u68_img" class="img " src="jsp/accessories/images/index/u68.png"/>
    <div id="u69" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u70" class="ax_paragraph" onclick="submitForm('LADA')">
    <img id="u70_img" class="img " src="jsp/accessories/images/index/u70.png"/>
    <div id="u71" class="text">
        <p><span>LADA</span></p>
    </div>
</div>

<div id="u72" class="ax_image" onclick="submitForm('LANCIA')">
    <form action="Controller" id="LANCIA" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="LANCIA">
    </form>
    <img id="u72_img" class="img " src="jsp/accessories/images/index/u72.png"/>

    <div id="u73" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u74" class="ax_paragraph" onclick="submitForm('LANCIA')">
   <img id="u74_img" class="img " src="jsp/accessories/images/index/u74.png"/>
    <div id="u75" class="text">
        <p><span>LANCIA</span></p>
    </div>
</div>

<div id="u76" class="ax_image" onclick="submitForm('LAND ROVER')">
    <form action="Controller" id="LAND ROVER" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="LAND ROVER">
    </form>
     <img id="u76_img" class="img " src="jsp/accessories/images/index/u76.png"/>

    <div id="u77" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u78" class="ax_paragraph" onclick="submitForm('LAND ROVER')">
    <img id="u78_img" class="img " src="jsp/accessories/images/index/u22.png"/>
    <div id="u79" class="text">
        <p><span>LAND ROVER</span></p>
    </div>
</div>

<div id="u80" class="ax_image" onclick="submitForm('MAN')">
    <form action="Controller" id="MAN" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="MAN">
    </form>
    <img id="u80_img" class="img " src="jsp/accessories/images/index/u80.png"/>
    <div id="u81" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u82" class="ax_paragraph" onclick="submitForm('MAN')">
    <img id="u82_img" class="img " src="jsp/accessories/images/index/u82.png"/>
    <div id="u83" class="text">
        <p><span>MAN</span></p>
    </div>
</div>

<div id="u84" class="ax_image" onclick="submitForm('MASERATI')">
    <form action="Controller" id="MASERATI" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="MASERATI">
    </form>
    <img id="u84_img" class="img " src="jsp/accessories/images/index/u84.png"/>
    <div id="u85" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u86" class="ax_paragraph" onclick="submitForm('MASERATI')">
    <img id="u86_img" class="img " src="jsp/accessories/images/index/u86.png"/>
    <div id="u87" class="text">
        <p><span>MASERATI</span></p>
    </div>
</div>

<div id="u88" class="ax_image" onclick="submitForm('MAZ-MAN')">
    <form action="Controller" id="MAZ-MAN" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="MAZ-MAN">
    </form>
     <img id="u88_img" class="img " src="jsp/accessories/images/index/u88.png"/>
    <div id="u89" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u90" class="ax_paragraph" onclick="submitForm('MAZ-MAN')">
    <img id="u90_img" class="img " src="jsp/accessories/images/index/u90.png"/>
    <div id="u91" class="text">
        <p><span>MAZ-MAN</span></p>
    </div>
</div>

<div id="u92" class="ax_image" onclick="submitForm('MERCEDES-BENZ')">
    <form action="Controller" id="MERCEDES-BENZ" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="MERCEDES-BENZ">
    </form>
   <img id="u92_img" class="img " src="jsp/accessories/images/index/u92.png"/>
    <div id="u93" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u94" class="ax_paragraph" onclick="submitForm('MERCEDES-BENZ')">
    <img id="u94_img" class="img " src="jsp/accessories/images/index/u94.png"/>
    <div id="u95" class="text">
        <p><span>MERCEDES-BENZ</span></p>
    </div>
</div>

<div id="u96" class="ax_image" onclick="submitForm('MG')">
    <form action="Controller" id="MG" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="MG">
    </form>
    <img id="u96_img" class="img " src="jsp/accessories/images/index/u96.png"/>
    <div id="u97" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u98" class="ax_paragraph" onclick="submitForm('MG')">
   <img id="u98_img" class="img " src="jsp/accessories/images/index/u98.png"/>
    <div id="u99" class="text">
        <p><span>MG</span></p>
    </div>
</div>

<div id="u100" class="ax_image" onclick="submitForm('MINI')">
    <form action="Controller" id="MINI" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="MINI">
    </form>
    <img id="u100_img" class="img " src="jsp/accessories/images/index/u100.png"/>
    <div id="u101" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u102" class="ax_paragraph" onclick="submitForm('MINI')">
    <img id="u102_img" class="img " src="jsp/accessories/images/index/u46.png"/>
    <div id="u103" class="text">
        <p><span>MINI</span></p>
    </div>
</div>

<div id="u104" class="ax_image" onclick="submitForm('NEOPLAN')">
    <form action="Controller" id="NEOPLAN" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="NEOPLAN">
    </form>
   <img id="u104_img" class="img " src="jsp/accessories/images/index/u104.png"/>
    <div id="u105" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u106" class="ax_paragraph" onclick="submitForm('NEOPLAN')">
    <img id="u106_img" class="img " src="jsp/accessories/images/index/u106.png"/>
    <div id="u107" class="text">
        <p><span>NEOPLAN</span></p>
    </div>
</div>

<div id="u108" class="ax_image" onclick="submitForm('OLDSMOBILE')">
    <form action="Controller" id="OLDSMOBILE" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="OLDSMOBILE">
    </form>
   <img id="u108_img" class="img " src="jsp/accessories/images/index/u108.png"/>
    <div id="u109" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u110" class="ax_paragraph" onclick="submitForm('OLDSMOBILE')">
    <img id="u110_img" class="img " src="jsp/accessories/images/index/u22.png"/>
    <div id="u111" class="text">
        <p><span>OLDSMOBILE</span></p>
    </div>
</div>

<div id="u112" class="ax_image" onclick="submitForm('OPEL')">
    <form action="Controller" id="OPEL" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="OPEL">
    </form>
    <img id="u112_img" class="img " src="jsp/accessories/images/index/u112.png"/>
    <div id="u113" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u114" class="ax_paragraph" onclick="submitForm('OPEL')">
        <img id="u114_img" class="img " src="jsp/accessories/images/index/u114.png"/>
    <div id="u115" class="text">
        <p><span>OPEL</span></p>
    </div>
</div>

<div id="u116" class="ax_image" onclick="submitForm('PEGEOT')">
    <form action="Controller" id="PEGEOT" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="PEGEOT">
    </form>
   <img id="u116_img" class="img " src="jsp/accessories/images/index/u116.png"/>
    <div id="u117" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u118" class="ax_paragraph" onclick="submitForm('PEGEOT')">
   <img id="u118_img" class="img " src="jsp/accessories/images/index/u118.png"/>
    <div id="u119" class="text">
        <p><span>PEGEOT</span></p>
    </div>
</div>

<div id="u120" class="ax_image" onclick="submitForm('PORSCHE')">
    <form action="Controller" id="PORSCHE" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="PORSCHE">
    </form>
    <img id="u120_img" class="img " src="jsp/accessories/images/index/u120.png"/>
    <div id="u121" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u122" class="ax_paragraph" onclick="submitForm('PORSCHE')">
    <img id="u122_img" class="img " src="jsp/accessories/images/index/u122.png"/>
    <div id="u123" class="text">
        <p><span>PORSCHE</span></p>
    </div>
</div>

<div id="u124" class="ax_image" onclick="submitForm('RENAULT')">
    <form action="Controller" id="RENAULT" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="RENAULT">
    </form>
    <img id="u124_img" class="img " src="jsp/accessories/images/index/u124.png"/>
    <div id="u125" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u126" class="ax_paragraph" onclick="submitForm('RENAULT')">
    <img id="u126_img" class="img " src="jsp/accessories/images/index/u126.png"/>
    <div id="u127" class="text">
        <p><span>RENAULT</span></p>
    </div>
</div>

<div id="u128" class="ax_image" onclick="submitForm('ROVER')">
    <form action="Controller" id="ROVER" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="ROVER">
    </form>
    <img id="u128_img" class="img " src="jsp/accessories/images/index/u128.png"/>
    <div id="u129" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u130" class="ax_paragraph"  onclick="submitForm('ROVER')">
   <img id="u130_img" class="img " src="jsp/accessories/images/index/u74.png"/>
    <div id="u131" class="text">
        <p><span>ROVER</span></p>
    </div>
</div>

<div id="u132" class="ax_image" onclick="submitForm('SAAB')">
    <form action="Controller" id="SAAB" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="SAAB">
    </form>
    <img id="u132_img" class="img " src="jsp/accessories/images/index/u132.png"/>
    <div id="u133" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u134" class="ax_paragraph" onclick="submitForm('SAAB')">
   <img id="u134_img" class="img " src="jsp/accessories/images/index/u58.png"/>
    <div id="u135" class="text">
        <p><span>SAAB</span></p>
    </div>
</div>

<div id="u136" class="ax_image" onclick="submitForm('SCANIA')">
    <form action="Controller" id="SCANIA" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="SCANIA">
    </form>
   <img id="u136_img" class="img " src="jsp/accessories/images/index/u136.png"/>
    <div id="u137" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u138" class="ax_paragraph" onclick="submitForm('SCANIA')">
    <img id="u138_img" class="img " src="jsp/accessories/images/index/u138.png"/>
    <div id="u139" class="text">
        <p><span>SCANIA</span></p>
    </div>
</div>

<div id="u140" class="ax_image" onclick="submitForm('SEAT')">
    <form action="Controller" id="SEAT" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="SEAT">
    </form>
  <img id="u140_img" class="img " src="jsp/accessories/images/index/u140.png"/>
    <div id="u141" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u142" class="ax_paragraph" onclick="submitForm('SEAT')">
  <img id="u142_img" class="img " src="jsp/accessories/images/index/u34.png"/>

    <div id="u143" class="text">
        <p><span>SEAT</span></p>
    </div>
</div>

<div id="u144" class="ax_image" onclick="submitForm('SKODA')">
    <form action="Controller" id="SKODA" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="SKODA">
    </form>
    <img id="u144_img" class="img " src="jsp/accessories/images/index/u144.png"/>
    <div id="u145" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u146" class="ax_paragraph" onclick="submitForm('SKODA')">
   <img id="u146_img" class="img " src="jsp/accessories/images/index/u74.png"/>
    <div id="u147" class="text">
        <p><span>SKODA</span></p>
    </div>
</div>

<div id="u148" class="ax_image" onclick="submitForm('SMART')">
    <form action="Controller" id="SMART" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="SMART">
    </form>
   <img id="u148_img" class="img " src="jsp/accessories/images/index/u148.png"/>
    <div id="u149" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u150" class="ax_paragraph" onclick="submitForm('SMART')">
    <img id="u150_img" class="img " src="jsp/accessories/images/index/u150.png"/>
    <div id="u151" class="text">
        <p><span>SMART</span></p>
    </div>
</div>

<div id="u152" class="ax_image" onclick="submitForm('VOLVO')">
    <form action="Controller" id="VOLVO" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="VOLVO">
    </form>
    <img id="u152_img" class="img " src="jsp/accessories/images/index/u152.png"/>
    <div id="u153" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u154" class="ax_paragraph" onclick="submitForm('VOLVO')">
   <img id="u154_img" class="img " src="jsp/accessories/images/index/u154.png"/>
    <div id="u155" class="text">
        <p><span>VOLVO</span></p>
    </div>
</div>

<div id="u156" class="ax_image" onclick="submitForm('VW')">
    <form action="Controller" id="VW" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="VW">
    </form>
    <img id="u156_img" class="img " src="jsp/accessories/images/index/u156.png"/>
    <div id="u157" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u158" class="ax_paragraph" onclick="submitForm('VW')">
  <img id="u158_img" class="img " src="jsp/accessories/images/index/u158.png"/>
    <div id="u159" class="text">
        <p><span>VW</span></p>
    </div>
</div>

<div id="u160" class="ax_shape">
    <img id="u160_img" class="img " src="jsp/accessories/images/index/u160.png"/>

    <div id="u161" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u162" class="ax_image" onclick="submitForm('ACURA')">
    <form action="Controller" id="ACURA" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="ACURA">
    </form>
    <img id="u162_img" class="img " src="jsp/accessories/images/index/u162.png"/>
    <div id="u163" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u164" class="ax_h2">
    <img id="u164_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u165" class="text">
        <p><span>Азия</span></p>
    </div>
</div>

<div id="u166" class="ax_paragraph" onclick="submitForm('ACURA')">
    <img id="u166_img" class="img " src="jsp/accessories/images/index/u150.png"/>
    <div id="u167" class="text">
        <p><span>ACURA</span></p>
    </div>
</div>

<div id="u168" class="ax_image" onclick="submitForm('CHERY')">
    <form action="Controller" id="CHERY" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="CHERY">
    </form>
   <img id="u168_img" class="img " src="jsp/accessories/images/index/u168.png"/>
    <div id="u169" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u170" class="ax_paragraph" onclick="submitForm('CHERY')">
   <img id="u170_img" class="img " src="jsp/accessories/images/index/u150.png"/>
    <div id="u171" class="text">
        <p><span>CHERY</span></p>
    </div>
</div>

<div id="u172" class="ax_image" onclick="submitForm('DAEWOOD')">
    <form action="Controller" id="DAEWOOD" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="DAEWOOD">
    </form>
    <img id="u172_img" class="img " src="jsp/accessories/images/index/u172.png"/>
    <div id="u173" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u174" class="ax_paragraph" onclick="submitForm('DAEWOOD')">
    <img id="u174_img" class="img " src="jsp/accessories/images/index/u174.png"/>
    <div id="u175" class="text">
        <p><span>DAEWOOD</span></p>
    </div>
</div>

<div id="u176" class="ax_image" onclick="submitForm('GEELY')">
    <form action="Controller" id="GEELY" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="GEELY">
    </form>
 <img id="u176_img" class="img " src="jsp/accessories/images/index/u176.png"/>
    <div id="u177" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u178" class="ax_paragraph" onclick="submitForm('GEELY')">
    <img id="u178_img" class="img " src="jsp/accessories/images/index/u178.png"/>
    <div id="u179" class="text">
        <p><span>GEELY</span></p>
    </div>
</div>

<div id="u180" class="ax_image" onclick="submitForm('HONDA')">
    <form action="Controller" id="HONDA" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="HONDA">
    </form>
    <img id="u180_img" class="img " src="jsp/accessories/images/index/u180.png"/>
    <div id="u181" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u182" class="ax_paragraph" onclick="submitForm('HONDA')">
    <img id="u182_img" class="img " src="jsp/accessories/images/index/u74.png"/>
    <div id="u183" class="text">
        <p><span>HONDA</span></p>
    </div>
</div>

<div id="u184" class="ax_image" onclick="submitForm('HYUNDAI')">
    <form action="Controller" id="HYUNDAI" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="HYUNDAI">
    </form>
  <img id="u184_img" class="img " src="jsp/accessories/images/index/u184.png"/>
    <div id="u185" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u186" class="ax_paragraph" onclick="submitForm('HYUNDAI')">
   <img id="u186_img" class="img " src="jsp/accessories/images/index/u186.png"/>
    <div id="u187" class="text">
        <p><span>HYUNDAI</span></p>
    </div>
</div>

<div id="u188" class="ax_image" onclick="submitForm('INFINITI')">
    <form action="Controller" id="INFINITI" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="INFINITI">
    </form>
    <img id="u188_img" class="img " src="jsp/accessories/images/index/u188.png"/>
    <div id="u189" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u190" class="ax_paragraph" onclick="submitForm('INFINITI')">
    <img id="u190_img" class="img " src="jsp/accessories/images/index/u150.png"/>
    <div id="u191" class="text">
        <p><span>INFINITI</span></p>
    </div>
</div>

<div id="u192" class="ax_image" onclick="submitForm('KIA')">
    <form action="Controller" id="KIA" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="KIA">
    </form>
    <img id="u192_img" class="img " src="jsp/accessories/images/index/u192.png"/>
    <div id="u193" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u194" class="ax_paragraph" onclick="submitForm('KIA')">
    <img id="u194_img" class="img " src="jsp/accessories/images/index/u98.png"/>
    <div id="u195" class="text">
        <p><span>KIA</span></p>
    </div>
</div>

<div id="u196" class="ax_image" onclick="submitForm('LEXUS')">
    <form action="Controller" id="LEXUS" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="LEXUS">
    </form>
    <img id="u196_img" class="img " src="jsp/accessories/images/index/u196.png"/>
    <div id="u197" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u198" class="ax_paragraph" onclick="submitForm('LEXUS')">
   <img id="u198_img" class="img " src="jsp/accessories/images/index/u198.png"/>
    <div id="u199" class="text">
        <p><span>LEXUS</span></p>
    </div>
</div>

<div id="u200" class="ax_image" onclick="submitForm('MAZDA')">
    <form action="Controller" id="MAZDA" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="MAZDA">
    </form>
    <img id="u200_img" class="img " src="jsp/accessories/images/index/u200.png"/>
    <div id="u201" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u202" class="ax_paragraph" onclick="submitForm('MAZDA')">
    <img id="u202_img" class="img " src="jsp/accessories/images/index/u150.png"/>
    <div id="u203" class="text">
        <p><span>MAZDA</span></p>
    </div>
</div>

<div id="u204" class="ax_image" onclick="submitForm('MITSUBISHI')">
    <form action="Controller" id="MITSUBISHI" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="MITSUBISHI">
    </form>
    <img id="u204_img" class="img " src="jsp/accessories/images/index/u204.png"/>
    <div id="u205" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u206" class="ax_paragraph" onclick="submitForm('MITSUBISHI')">
  <img id="u206_img" class="img " src="jsp/accessories/images/index/u206.png"/>
    <div id="u207" class="text">
        <p><span>MITSUBISHI</span></p>
    </div>
</div>

<div id="u208" class="ax_image" onclick="submitForm('NISSAN')">
    <form action="Controller" id="NISSAN" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="NISSAN">
    </form>
    <img id="u208_img" class="img " src="jsp/accessories/images/index/u208.png"/>
    <div id="u209" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u210" class="ax_paragraph" onclick="submitForm('NISSAN')">
    <img id="u210_img" class="img " src="jsp/accessories/images/index/u138.png"/>
    <div id="u211" class="text">
        <p><span>NISSAN</span></p>
    </div>
</div>

<div id="u212" class="ax_image" onclick="submitForm('SUBARU')">
    <form action="Controller" id="SUBARU" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="SUBARU">
    </form>
 <img id="u212_img" class="img " src="jsp/accessories/images/index/u212.png"/>
    <div id="u213" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u214" class="ax_paragraph" onclick="submitForm('SUBARU')">
    <img id="u214_img" class="img " src="jsp/accessories/images/index/u118.png"/>
    <div id="u215" class="text">
        <p><span>SUBARU</span></p>
    </div>
</div>

<div id="u216" class="ax_image" onclick="submitForm('SUZUKI')">
    <form action="Controller" id="SUZUKI" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="SUZUKI">
    </form>
    <img id="u216_img" class="img " src="jsp/accessories/images/index/u216.png"/>
    <div id="u217" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u218" class="ax_paragraph" onclick="submitForm('SUZUKI')">
   <img id="u218_img" class="img " src="jsp/accessories/images/index/u74.png"/>
    <div id="u219" class="text">
        <p><span>SUZUKI</span></p>
    </div>
</div>

<div id="u220" class="ax_image" onclick="submitForm('TOYOTA')">
    <form action="Controller" id="TOYOTA" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="TOYOTA">
    </form>
    <img id="u220_img" class="img " src="jsp/accessories/images/index/u220.png"/>
    <div id="u221" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u222" class="ax_paragraph" onclick="submitForm('TOYOTA')">
    <img id="u222_img" class="img " src="jsp/accessories/images/index/u222.png"/>
    <div id="u223" class="text">
        <p><span>TOYOTA</span></p>
    </div>
</div>

<div id="u224" class="ax_shape">
    <img id="u224_img" class="img " src="jsp/accessories/images/index/u224.png"/>

    <div id="u225" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u226" class="ax_image" onclick="submitForm('BUICK')">
    <form action="Controller" id="BUICK" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="BUICK">
    </form>
   <img id="u226_img" class="img " src="jsp/accessories/images/index/u226.png"/>
    <div id="u227" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u228" class="ax_h2">
    <img id="u228_img" class="img " src="jsp/accessories/resources/images/transparent.gif"/>

    <div id="u229" class="text">
        <p><span>Америка</span></p>
    </div>
</div>

<div id="u230" class="ax_paragraph" onclick="submitForm('BUICK')">
    <img id="u230_img" class="img " src="jsp/accessories/images/index/u42.png"/>
    <div id="u231" class="text">
        <p><span>BUICK</span></p>
    </div>
</div>

<div id="u232" class="ax_image" onclick="submitForm('CADILLAC')">
    <form action="Controller" id="CADILLAC" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="CADILLAC">
    </form>
    <img id="u232_img" class="img " src="jsp/accessories/images/index/u232.png"/>
    <div id="u233" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u234" class="ax_paragraph" onclick="submitForm('CADILLAC')">
    <img id="u234_img" class="img " src="jsp/accessories/images/index/u106.png"/>
    <div id="u235" class="text">
        <p><span>CADILLAC</span></p>
    </div>
</div>

<div id="u236" class="ax_image" onclick="submitForm('CHEVROLET')">
    <form action="Controller" id="CHEVROLET" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="CHEVROLET">
    </form>
   <img id="u236_img" class="img " src="jsp/accessories/images/index/u236.png"/>
    <div id="u237" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u238" class="ax_paragraph" onclick="submitForm('CHEVROLET')">
    <img id="u238_img" class="img " src="jsp/accessories/images/index/u238.png"/>
    <div id="u239" class="text">
        <p><span>CHEVROLET</span></p>
    </div>
</div>

<div id="u240" class="ax_image" onclick="submitForm('CHRYSLER')">
    <form action="Controller" id="CHRYSLER" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="CHRYSLER">
    </form>
    <img id="u240_img" class="img " src="jsp/accessories/images/index/u240.png"/>
    <div id="u241" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u242" class="ax_paragraph" onclick="submitForm('CHRYSLER')">
   <img id="u242_img" class="img " src="jsp/accessories/images/index/u242.png"/>
    <div id="u243" class="text">
        <p><span>CHRYSLER</span></p>
    </div>
</div>

<div id="u244" class="ax_image" onclick="submitForm('DODGE')">
    <form action="Controller" id="DODGE" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="DODGE">
    </form>
    <img id="u244_img" class="img " src="jsp/accessories/images/index/u244.png"/>
    <div id="u245" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u246" class="ax_paragraph" onclick="submitForm('DODGE')">
    <img id="u246_img" class="img " src="jsp/accessories/images/index/u246.png"/>
    <div id="u247" class="text">
        <p><span>DODGE</span></p>
    </div>
</div>

<div id="u248" class="ax_image" onclick="submitForm('HUMMER')">
    <form action="Controller" id="HUMMER" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="HUMMER">
    </form>
    <img id="u248_img" class="img " src="jsp/accessories/images/index/u248.png"/>
    <div id="u249" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u250" class="ax_paragraph" onclick="submitForm('HUMMER')">
 <img id="u250_img" class="img " src="jsp/accessories/images/index/u126.png"/>
    <div id="u251" class="text">
        <p><span>HUMMER</span></p>
    </div>
</div>

<div id="u252" class="ax_image" onclick="submitForm('JEEP')">
    <form action="Controller" id="JEEP" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="JEEP">
    </form>
   <img id="u252_img" class="img " src="jsp/accessories/images/index/u252.png"/>
    <div id="u253" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u254" class="ax_paragraph" onclick="submitForm('JEEP')">
    <img id="u254_img" class="img " src="jsp/accessories/images/index/u34.png"/>
    <div id="u255" class="text">
        <p><span>JEEP</span></p>
    </div>
</div>

<div id="u256" class="ax_image" onclick="submitForm('GMC')">
    <form action="Controller" id="GMC" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="GMC">
    </form>
   <img id="u256_img" class="img " src="jsp/accessories/images/index/u256.png"/>
    <div id="u257" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u258" class="ax_paragraph" onclick="submitForm('GMC')">
    <img id="u258_img" class="img " src="jsp/accessories/images/index/u26.png"/>
    <div id="u259" class="text">
        <p><span>GMC</span></p>
    </div>
</div>

<div id="u260" class="ax_image" onclick="submitForm('PONTIAC')">
    <form action="Controller" id="PONTIAC" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="PONTIAC">
    </form>
   <img id="u260_img" class="img " src="jsp/accessories/images/index/u260.png"/>
    <div id="u261" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u262" class="ax_paragraph" onclick="submitForm('PONTIAC')">
    <img id="u262_img" class="img " src="jsp/accessories/images/index/u38.png"/>
    <div id="u263" class="text">
        <p><span>PONTIAC</span></p>
    </div>
</div>

<div id="u264" class="ax_image" onclick="submitForm('LINCOLN')">
    <form action="Controller" id="LINCOLN" method="post">
        <input type="hidden" name="command" value="DO_LIST_OF_ALL_FILTER">
        <input type="hidden" name="filterType" value="LINCOLN">
    </form>
  <img id="u264_img" class="img " src="jsp/accessories/images/index/u264.png"/>
    <div id="u265" class="text">
        <p><span></span></p>
    </div>
</div>

<div id="u266" class="ax_paragraph" onclick="submitForm('LINCOLN')">
   <img id="u266_img" class="img " src="jsp/accessories/images/index/u118.png"/>
    <div id="u267" class="text">
        <p><span>LINCOLN</span></p>
    </div>
</div>

<div id="u268" class="ax_shape">
    <img id="u268_img" class="img " src="jsp/accessories/images/index/u4.png"/>

    <div id="u269" class="text">
        <p><span></span></p>
    </div>
</div>


<div id="u270" class="ax_shape" onclick="submitForm('BRANDS')">
    <form action="Controller" id="BRANDS" method="post">
        <input type="hidden" name="command" value="OPERATION_WITH_BRANDS">
        <input type="hidden" name="typeOfOperationWithBrand" value="list">
    </form>
    <img id="u270_img" class="img " src="jsp/accessories/images/index/u270.png"/>

    <div id="u271" class="text">
        <p><span>Операции с автомобильными марками</span></p>
    </div>
</div>


<div id="u272" class="ax_shape" onclick="submitForm('MODEL')">
    <form action="Controller" id="MODEL" method="post">
        <input type="hidden" name="command" value="OPERATION_WITH_MODEL">
        <input type="hidden" name="typeOfOperationWithModel" value="list">
    </form>
    <img id="u272_img" class="img " src="jsp/accessories/images/index/u270.png"/>

    <div id="u273" class="text">
        <p><span>Операции с автомобильными моделями</span></p>
    </div>
</div>


<div id="u274" class="ax_shape" onclick="submitForm('AGENT')">
    <form action="Controller" id="AGENT" method="post">
        <input type="hidden" name="command" value="OPERATION_WITH_AGENT">
        <input type="hidden" name="typeOfOperationWithAgent" value="list">
    </form>
    <img id="u274_img" class="img " src="jsp/accessories/images/index/u270.png"/>
    <div id="u275" class="text">
        <p><span>Операции с агентами</span></p>
    </div>

</div>
</div>
</body>
</html>
