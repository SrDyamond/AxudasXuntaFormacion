 <%@ page pageEncoding="UTF-8" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
 <fmt:setLocale value="${language}" />
 <fmt:setBundle basename="text" />
 <!DOCTYPE html>
 <html lang="${language}">
     <head>
         <title>Xunta Galicia Axudas</title>
     </head>
            <form>
             <select id="language" name="language" onchange="submit()">
                 <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                 <option value="nl" ${language == 'nl' ? 'selected' : ''}>Nederlands</option>
                 <option value="es" ${language == 'es' ? 'selected' : ''}>Español</option>
                 <option value="gl" ${language == 'gl' ? 'selected' : ''}>Galego</option>
                 
             </select>
         </form>
     <body style="background-color:DodgerBlue">
     <h1 style="text-align:center;">XUNTA DE GALICIA AXUDAS</h1>
    <div align="center">
        <img src="descarga.png" align="center"
            title="Bandera de Galicia">
    </div>
     </body>
      <hr>
      <body>
      	<p align="left">
      		<br>
            <h3><fmt:message key="texto" /></h3>
            <br>
           	<form action="GetDatos" method="get">
           	<button name="button" onclick=submit ><fmt:message key="obtenerDatos" /></button>
           	<table border="1" cellpadding="2" cellspacing="2" border-color="white">
		<tr>
			<th>DNI</th>
			<th>Nombre</th>
			<th>Fecha Nacimiento</th>
			<th>Renta Anual</th>
			<th>Miembros Familiares</th>
		</tr>
        <c:forEach var="dato" items="${datos }">
			<tr>
				<td>${dato.dni }</td>
				<td>${dato.nombre }</td>
				<td>${dato.fecha_nacimiento }</td>
				<td>${dato.renta_anual }</td>
				<td>${dato.numero_miembros_familiares}</td>
			</tr>
		</c:forEach>
			</table>
           	</form>
        
       
         <!-- 
         <form method="post">
             <label for="username"><fmt:message key="login.label.username" />:</label>
             <input type="text" id="username" name="username">
             <br>
             <label for="password"><fmt:message key="login.label.password" />:</label>
             <input type="password" id="password" name="password">
             <br>
             <fmt:message key="login.button.submit" var="buttonValue" />
             <input type="submit" name="submit" value="${buttonValue}">
         </form>
         -->
     </body>
 </html>