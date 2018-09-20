<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>管理员登录</title>
   <link rel="stylesheet" href="css/reset.css">
  <link rel="stylesheet" href="css/admin_sign.css"> 
    <script typet="text/javascript" src="js/jquery.min.js"></script>
    <script>
    $(function(){
      $('.btn').click(function(){
      if ($("input[name='admin']").val()=="admin"&& $("input[name='pwd']").val()=="123456"){

        $('#al').html('登录成功～<a href="#">进入后台管理系统</a>');
      }
})
    })

</script>
</head>
<body>
  <div id="sign">

    <form>
      <table>
        <tr>
                <th colspan="2">管理员登录</th>
            </tr>
        <tr>
          <td>用户名</td>
          <td><input type="text" name="admin" ></td>
        </tr>
        <tr>
          <td>密码</td>
          <td><input type="password" name="pwd" ></td>
        </tr>
        <tr>
                <td>
                  <input type="submit" value="登录" class="button btn">
                </td>
                <td>
                    <input type="reset" value="重置" class="button">
                </td>
            </tr>
            <div id="al">
              
            </div>
      </table>
    </form>
  </div>
</body>
</html>



</body>
</html>
