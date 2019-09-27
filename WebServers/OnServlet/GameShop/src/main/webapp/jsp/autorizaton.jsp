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
        <form class="login_form" action="" method="post" name="contact_form">
            <h2>Авторизируйтесь</h2>
            <div>
                <pre for="email">Email:                </pre>
                <input type="text" name="email" />
            </div>
            <div>
                <pre for="password">Пароль:               </pre>
                <input type="text" name="password" />
            </div>

            <div>
                <button class="submit" type="submit">Войти</button>
                <!-- <button class="submit"  method="GET" href="/GameShop/reg">Регистрация</button> -->
            </div>
            <div class="submit" >
                <a href="/GameShop/reg">
                    <h6 >Регистрация</h6>
                </a>
            </div>
        </form>
    </div>
</body>
</html>