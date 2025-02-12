
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Message</title>
</head>
<body>
    <% 
      String message=(String)session.getAttribute("msg");
      if(message!=null)
       {
            if(message.contains("SUCCESSFULLY"))
            {
     %>
     <span style="color:blue"><%= message %></span>
     
     
         <%  } 
            else
            {
            	
            
           %>
          <span style="color:red"><%= message %></span>
     <%
            }
        }
        session.removeAttribute("msg");
     %>
</body>
</html>