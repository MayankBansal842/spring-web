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
            <%@ include file="common/navbar.jspf" %>
            <h1>Enter Todo Details</h1>
            <form:form method="post" modelAttribute="todo">
                Description:<form:input type="text" path="description" required="required"/>
                <form:errors path="description" cssClass="text-warning"/>
                <form:input path="username" type="hidden" />
                <form:input type="hidden" path="id"/>
                <form:input type="hidden" path="targetDate" />
                <form:input type="hidden" path="done"/>
                <input type="submit" class="btn btn-success"/>
            </form:form>
        </div>
        <script src="webjars\bootstrap\5.3.3\css\bootstrap.min.css" ></script>
        <script src="webjars\jquery\3.7.1\jquery.min.js" ></script>
    </body>
</html>