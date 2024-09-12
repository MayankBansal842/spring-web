<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%--<!doctype html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <link href="webjars\bootstrap\5.3.3\css\bootstrap.min.css" rel="stylesheet">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1">--%>
<%--    <title>New To Do</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container">--%>
<%--    <h1>Enter To Do Details</h1>--%>
<%--    <form method="post" class="flex-column">--%>
<%--        <div>--%>
<%--            <label>Description</label>--%>
<%--            <input type="text" name="description" />--%>
<%--        </div>--%>
<%--        <div>--%>
<%--            <label>Due Date</label>--%>
<%--            <input type="date" name="dueDate" />--%>
<%--        </div>--%>
<%--        <div>--%>
<%--            <label>Is Complete</label>--%>
<%--            <select name="completed">--%>
<%--                <option value="false" selected>Pending</option>--%>
<%--                <option value="true">Complete</option>--%>
<%--            </select>--%>
<%--        </div>--%>
<%--        <input type="submit" class="btn btn-success">--%>
<%--    </form>--%>
<%--</div>--%>
<%--<script src="webjars\bootstrap\5.3.3\css\bootstrap.min.css" ></script>--%>
<%--<script src="webjars\jquery\3.7.1\jquery.min.js" ></script>--%>
<%--</body>--%>
<%--</html>--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="webjars\bootstrap\5.3.3\css\bootstrap.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>New To Do</title>
</head>
<body>
<div class="container">
    <h1>Enter To Do Details</h1>
<%--    the toDo should match with the controller functions parameter--%>
    <form:form method="post" modelAttribute="toDo">
        <div>
            <label>Description</label>
            <form:input type="text" path="description"/>
        </div>
        <div>
            <form:input path="id" type="hidden" />
        </div>
        <div>
            <form:input type="hidden" path="dueDate"/>
        </div>
        <div>
            <form:input path="complete" type="hidden"/>
        </div>
        <input type="submit" class="btn btn-success">
    </form:form>
</div>
<script src="webjars\bootstrap\5.3.3\css\bootstrap.min.css" ></script>
<script src="webjars\jquery\3.7.1\jquery.min.js" ></script>
</body>
</html>