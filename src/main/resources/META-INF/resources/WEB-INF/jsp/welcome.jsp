<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="webjars\bootstrap\5.3.3\css\bootstrap.min.css" rel="stylesheet">
    <title>Welcome</title>
</head>
<body>
    <div class="container container-fluid">
        <%@ include file="common/navbar.jspf" %>
        <h1>Welcome to ToDo App Page</h1>
        <h3><a href="./list-todos">Manage</a> your ToDos</h3>
    </div>
    <script src="webjars\bootstrap\5.3.3\css\bootstrap.min.css" ></script>
    <script src="webjars\jquery\3.7.1\jquery.min.js" ></script>
</body>
</html>