<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
 <head>
  <meta charset="utf-8">
  <title>Survey Result</title>
 </head>
 <body>
  <table border="1">
   <caption>Survey Result:</caption>
   <tr>
    <th>Language</th>
    <th>Qty</th>
    <th>%</th>
   </tr>
   <tr>
    <td>Java</td>
    <td><c:out value="${applicationScope.javaCounter}"></c:out></td>
    <td><c:out value="${applicationScope.javaPercent}"></c:out></td></tr>
   <tr>
    <td>Ruby</td>
    <td><c:out value="${applicationScope.rubyCounter}"></c:out></td>
    <td><c:out value="${applicationScope.rubyPercent}"></c:out></td>
   </tr>
   <tr>
    <td>C#</td>
    <td><c:out value="${applicationScope.cSharpCounter}"></c:out></td>
    <td><c:out value="${applicationScope.cSharpPercent}"></c:out></td>
   </tr>
   <tr>
    <td>C++</td>
    <td><c:out value="${applicationScope.cppCounter}"></c:out></td>
    <td><c:out value="${applicationScope.cppPercent}"></c:out></td>
   </tr>
   <tr>
    <td>Python</td>
    <td><c:out value="${applicationScope.pythonCounter}"></c:out></td>
    <td><c:out value="${applicationScope.pythonPercent}"></c:out></td>
   </tr>
  </table>
  <br>average age <b><c:out value="${applicationScope.averageAge}"></c:out></b>
 </body>
</html>