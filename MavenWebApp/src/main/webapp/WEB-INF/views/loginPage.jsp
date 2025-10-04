<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login Page</title>

  <style>
    * {
      box-sizing: border-box;
      font-family: Arial, sans-serif;
    }

    body {
      background-color: #f2f2f2;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      margin: 0;
    }

    .login-container {
      background: #fff;
      padding: 30px 40px;
      border-radius: 12px;
      box-shadow: 0 4px 15px rgba(0,0,0,0.1);
      width: 320px;
    }

    .login-container h2 {
      text-align: center;
      margin-bottom: 25px;
      color: #333;
    }

    .input-group {
      margin-bottom: 20px;
    }

    label {
      display: block;
      margin-bottom: 6px;
      color: #555;
    }

    input {
      width: 100%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 6px;
      font-size: 14px;
    }

    button {
      width: 100%;
      padding: 10px;
      background-color: #0078d7;
      color: white;
      border: none;
      border-radius: 6px;
      font-size: 16px;
      cursor: pointer;
    }

    button:hover {
      background-color: #005fa3;
    }
  </style>
</head>

<body>
  <div class="login-container">
    <h2>Login</h2>
    <form action="handleLogin" method="POST">
      <div class="input-group">
        <label for="email">Email</label>
        <input type="email" id="email" name="email" placeholder="Enter your email" required>
      </div>

      <div class="input-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="Enter your password" required>
      </div>

      <button type="submit">Login</button>
    </form>
  </div>
</body>
</html>
