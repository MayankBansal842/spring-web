<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link href="webjars\bootstrap\5.3.3\css\bootstrap.min.css" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>ToDos</title>
    </head>
    <body>
        <div class="container">
            <%@ include file="common/navbar.jspf" %>
            <div>Hello ${name}, Welcome to dos list</div>
            <div>Your ToDos are:</div>
            <%--${todos}--%>
            <table class="table">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Username</th>
                        <th>Description</th>
                        <th>DueDate</th>
                        <th>Is Complete</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                        <tr>
                            <td>${todo.id}</td>
                            <td>${todo.username}</td>
                            <td>${todo.description}</td>
                            <td>${todo.targetDate}</td>
                            <td>${todo.done}</td>
                            <td><a class="btn btn-danger" href="delete-todo?id=${todo.id}">Delete</a></td>
                            <td><a class="btn btn-warning" href="edit-todo?id=${todo.id}">Edit</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="add-todo" class="btn btn-success">Add ToDo</a>
        </div>
    <script src="webjars\bootstrap\5.3.3\css\bootstrap.min.css" ></script>
    <script src="webjars\jquery\3.7.1\jquery.min.js" ></script>
    </body>
</html>