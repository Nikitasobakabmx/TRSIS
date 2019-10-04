<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Авторизация в магазин игрушек</title>
    <link rel="stylesheet" href="css/reg_au_styles.css" type="text/css">
</head>
<body>
    <div class="login_box">
        <form class="login_form" action="change" method="post" name="contact_form">
            <%String name = (String)request.getAttribute("name"); %>
            <%String story = (String)request.getAttribute("story"); %>
            <input type="hidden" name="name" value=<%= name%> />
            <h2 >Здраствуйте <%= name%></h2>
            <input type="text" name="story" value=<%= story %>>
            <div>
                <button class="submit" type="submit">Добавить историю</button>
            </div>

        </form>
    </div>
</body>
</html>