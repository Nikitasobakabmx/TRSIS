<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Регистрация в магазине игрушек</title>
    <link rel="stylesheet" href="css/reg_au_styles.css" type="text/css">
</head>
<body>
    <div class="login_box">
        <form class="login_form" action="" method="post" name="contact_form">
            <h2>Зарегестрируйтесь</h2>
            <div>
                <pre for="name">Имя*:                  </pre>
                <input type="text" name="name" />
            </div>
            <div>
                <pre for="surname">Фамилия:              </pre>
                <input type="text" name="surname" />
            </div>
            <div>
                <pre for="email">Email*:                </pre>
                <input type="text" name="email" />
            </div>
            <div>
                <pre for="password">Пароль*:               </pre>
                <input type="text" name="password" />
            </div>
            <div>
                <pre for="confirm_password">Подтвердите пароль*:   </pre>
                <input type="text" name="confirm_password" />
            </div>
            <div>
                <button class="submit" type="submit">Зарегестрироваться</button>
            </div>
        </form>
    </div>
</body>
</html>