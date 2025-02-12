
<%
   String check=(String)session.getAttribute("adminlogin");
    if(check==null)
    {
    	response.sendRedirect("adminlogin.jsp");
    	return;
    }

%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Service</title>
    <style>
        /* General Styles */
        body {
            font-family: 'Poppins', sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: linear-gradient(135deg, #ff6f61, #ffcc00);
        }

        .container {
            width: 100%;
            max-width: 400px;
            background: rgba(255, 255, 255, 0.95);
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
            text-align: center;
        }

        h2 {
            color: #ff6f61;
            font-size: 24px;
            margin-bottom: 10px;
            text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2);
        }

        /* Form Styling */
        form {
            display: flex;
            flex-direction: column;
        }

        input {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 16px;
            background: #f9f9f9;
            transition: all 0.3s ease;
        }

        input:focus {
            border-color: #ff6f61;
            background: #fff;
            outline: none;
            box-shadow: 0 0 5px rgba(255, 111, 97, 0.5);
        }

        button {
            width: 100%;
            padding: 12px;
            background: #ff6f61;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 18px;
            font-weight: bold;
            cursor: pointer;
            transition: all 0.3s ease;
            box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.2);
        }

        button:hover {
            background: #e65a50;
            transform: scale(1.05);
        }

        /* Responsive Design */
        @media (max-width: 480px) {
            .container {
                width: 90%;
            }
        }
    </style>
</head>
<body>

    <div class="container">
    <a href="admin.jsp">
            <button class="btn btn-home">🏠 Home</button>
        </a>
        <h2>Add Service</h2>
        <%@include file="message.jsp" %>

        <form action="ServiceModuleServlet1" method="post">
            <input type="text" name="iconname" placeholder="Enter Icon Name" required>
            <input type="text" name="title" placeholder="Enter Title" required>
            <input type="text" name="description" placeholder="Enter Description" required>
            <button type="submit">Add Service</button>
        </form>
    </div>

</body>
</html>


    