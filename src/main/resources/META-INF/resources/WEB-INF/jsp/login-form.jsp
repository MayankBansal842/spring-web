<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Document</title>
</head>
<body>
<%--    Without using method="post" all the data from the form will be sent using get and it will be sent in the url which is not secure--%>
    <form method="post">
        <label>Name:</label>
        <input type="text" name="name" />
        <label>Password</label>
        <input type="password" name="password"/>
        <input type="submit" />
    </form>

</body>
</html>