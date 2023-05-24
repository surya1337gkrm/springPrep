<html>
    <head>
        <title>
            Login Page
        </title>
        <style>
            *{
               border:10px;
               margin:10px;
              }
              input{
                border: 1px solid black;
              }
        </style>
    </head>
    <body>
        <h1>
            Login Page
        </h1>
        <pre>${errorMessage}</pre>
        <form method="post">
            <label>Username : <input type="text" required  name="name"/></label><br/>
            <label>Password : <input type="password" required  name="password"/></label>
            <br/>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>