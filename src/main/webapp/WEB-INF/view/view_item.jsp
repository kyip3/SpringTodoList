<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="dev.codes.util.Mappings"%>

<html>
<head>
    <title>View Item</title>
</head>
<body>
    <div align = "center">
        <table>
            <tr>
                <td>
                    <label>id</label>
                </td>
                <td>
                    <c:out value="${todoItem.id}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Title</label>
                </td>
                <td>
                    <c:out value="${todoItem.title}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Deadline</label>
                </td>
                <td>
                    <c:out value="${todoItem.deadline}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label>Details</label>
                </td>
                <td>
                    <c:out value="${todoItem.details}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <c:url var="tableUrl" value="${Mappings.ITEMS}"/>
                    <a href="${tableUrl}">Show Table</a>
                </td>
                <td>

                </td>
            </tr>
        </table>
    </div>
</body>
</html>