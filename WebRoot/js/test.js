         var sum = document.getElementById('zc');
         var patt = /^[a-zA-Z0-9]{6,11}$/;
   function check_name()
   {
         if(!patt.test(sum.username.value))
         {  
            document.getElementById('name_tip').innerHTML = ' 请输入正确的用户名！';
            return false;
         }
         else 
         {
            document.getElementById('name_tip').innerHTML = '用户名格式正确';
            return true;
         }
   }
   
      function check_email()
     {
        var atpos =sum.email.value.indexOf("@");
        var dotpos = sum.email.value.lastIndexOf(".");
        if (atpos<1 || dotpos<atpos+2 || dotpos+2>=sum.email.value.length)
        {
           document.getElementById('email_tip').innerHTML = ' 请输入正确的邮箱！';
          return false;
        }
        else 
        {
             document.getElementById('email_tip').innerHTML = '邮箱格式正确';
              return true;
        }
     }
     function check_psw()
     {
             if (!patt.test(sum.psw.value))
               {
                  document.getElementById('psw_tip').innerHTML = ' 请输入正确的密码！';
                  return false;
               } 
                 else
                  {
                    document.getElementById('psw_tip').innerHTML = '密码格式正确';
              return true;
           }
     }
     function check_psw1()
     {
                if((sum.psw.value)!=(sum.psw2.value))
               {
                 document.getElementById('psw2_tip').innerHTML = '密码不一致,请重新输入！';
                 return false;
               }
                 else {
                  document.getElementById('psw2_tip').innerHTML = '密码一致';
              return true;
           }
      }
   function check()
   {
    check_name();
    check_email();
    check_psw();
    check_psw1();
      if(check_name()&&check_email()&&check_psw()&&check_psw1())
         return true;
      else
         return false;
   }