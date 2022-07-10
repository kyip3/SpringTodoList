<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="dev.codes.util.AttributeNames"%>

<html>
<head>
    <title>Add Item</title>
</head>
<body>
    <div align = "center">
        <form:form method="POST" modelAttribute="${AttributeNames.TODO_ITEM}">
            <table>
                <tr>
                    <td>
                        <label>id</label>
                    </td>
                    <td>
                        <form:input path="id" disabled="true"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Title</label>
                    </td>
                    <td>
                        <form:input path="title"></form:input>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Deadline</label>
                    </td>
                    <td>
                        <form:input path="deadline"></form:input>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Details</label>
                    </td>
                    <td>
                        <form:textarea path="details"></form:textarea>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Submit"/>
                    </td>
                    <td>

                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>
