<%--
  Created by IntelliJ IDEA.
  User: sarah
  Date: 2022-06-17
  Time: 05:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Students Managment</title>
<%--    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />--%>
<%--    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css"> </link>--%>
<%--    <script language="JavaScript" type="text/JavaScript"--%>
<%--            src="../js/hello.js"></script>--%>
</head>
<body>
<center>
    <h1>Students Management</h1>
    <h2>
        <a href="/new">Add New Student</a>
        &nbsp;&nbsp;&nbsp;
        <a href="/list">List All Students</a>
    </h2>
</center>
<div align="center">
    <c:if test="${student != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${student == null}">
        <form action="insert" method="post" onSubmit="return sayHelloToThisPerson();">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${student != null}">
                            Edit Student
                        </c:if>
                        <c:if test="${student == null}">
                            Add Student
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${student != null}">
                    <input type="hidden" name="id" value="<c:out value='${student.id}' />" />
                </c:if>
                <tr>
                    <th>First Name: </th>
                    <td>
                        <input type="text" name="firstName" size="45"
                               value="<c:out value='${student.firstName}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Last Name: </th>
                    <td>
                        <input type="text" name="lastName" size="45"
                               value="<c:out value='${student.lastName}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>gender: </th>
                    <td>
                        <input type="text" name="gender" size="5"
                               value="<c:out value='${student.gender}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                        <input type="reset" value="clear" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>
