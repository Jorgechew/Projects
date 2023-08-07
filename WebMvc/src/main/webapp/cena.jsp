<html>
<head>
    <title>WebUser</title>
    <script src="https://code.jquery.com/jquery-latest.js"></script>


    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
    </script>
    <link href="./style.css" rel="stylesheet">
</head>
<body>


<div style="display: flex; justify-content:center;">

    <div class="row">
        <div class="col-6 col-md-6">
    <div class="card text-white bg-primary mb-3 d-flex justify-content-center " style="max-width: 18rem;">

        <div class="card-header text-center">Users</div>

        <div class="/card-body">

            <h4 class="name">Welcome ${user.name}</h4>
            <p class="password">Password: ********* </p>
            <p class="email">Email: ${user.email}</p>
            <p class="number">Number: ${user.number}</p>

        </div>
            </div>
        </div>
        <div class="col-6 col-md-6">
            <img src="https://lagoas.cm-pontedelima.pt/cmpontedelima/uploads/poi/image/174/Lacertalepida.png" alt="Sardão" width="250" height="250">


    </div>
    </div>

</div>

<div class="container">
    <div class="row">
        <div class="col-6 col-md-4"><h1>CATARINA</h1></div>
        <div class="col-6 col-md-4"><h1>SO OUVE</h1></div>
        <div class="col-6 col-md-4"><h1>POP</h1></div>

    </div>
</div>
</div>

<div style="display: flex; justify-content:center;">
    <form method="POST">
    <label for="UserName">UserName</label>
    <input type="text" id="UserName" name="Name"/>

    <label for="Password">Password</label>
    <input  id="Password" name="Password" type="password"/>

    <label for="Email">Email</label>
    <input  id="Email" name="Email" type="email"/>

        <label for="Number">Number</label>
        <input  id="Number" name="Number"type="number"/>

    <input type="submit" value="submit">
    </form>

</div>
</div>
</div>
</body>
</html>
