
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
<title>Admin Panel</title>
<style>
/* General Styles */
body {
	font-family: 'Poppins', sans-serif;
	margin: 0;
	padding: 0;
	display: flex;
	flex-direction: column;
	min-height: 100vh;
	background: linear-gradient(135deg, #ff6f61, #ffcc00);
	color: #333;
}

/* Header */
header {
	background: rgba(255, 255, 255, 0.9);
	padding: 20px;
	text-align: center;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

header h1 {
	margin: 0;
	font-size: 28px;
	font-weight: 600;
	color: #ff6f61;
}

/* Navigation */
nav {
	background: rgba(255, 255, 255, 0.9);
	padding: 10px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
	display: flex;
	justify-content: center;
	gap: 15px;
}

nav a {
	text-decoration: none;
	color: #333;
	font-size: 16px;
	font-weight: 500;
	padding: 10px 25px;
	border-radius: 8px;
	background: #f8f8f8;
	transition: all 0.3s ease;
	box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.1);
}

nav a:hover {
	background: #ff6f61;
	color: white;
	transform: scale(1.05);
}

/* Main Content */
main {
	flex: 1;
	padding: 30px;
	background: rgba(255, 255, 255, 0.9);
	margin: 20px;
	border-radius: 10px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
	text-align: center;
}

main h2 {
	color: #ff6f61;
	font-size: 26px;
	font-weight: 700;
	margin-bottom: 15px;
	text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2);
}

main p {
	color: #444;
	font-size: 18px;
	line-height: 1.8;
	max-width: 600px;
	margin: auto;
}



.btn:hover {
	background: #cc4c4c;
	transform: scale(1.05);
}

.btn {
	display: inline-block;
	padding: 10px 20px;
	margin: 10px;
	text-decoration: none;
	color: white;
	background: #ff6f61;
	border-radius: 5px;
	font-weight: bold;
	transition: 0.3s;
}

/* Footer */
footer {
	background: rgba(255, 255, 255, 0.9);
	color: #333;
	text-align: center;
	padding: 15px;
	margin-top: auto;
	box-shadow: 0 -4px 10px rgba(0, 0, 0, 0.1);
}

footer p {
	margin: 0;
	font-size: 14px;
}

/* Responsive Design */
@media ( max-width : 600px) {
	nav {
		flex-direction: column;
		align-items: center;
	}
	nav a {
		width: 90%;
		text-align: center;
	}
	main p {
		font-size: 16px;
	}
}
</style>
</head>
<body>
	<!-- Header -->
	<header>
		<h1>Admin Panel</h1>
		<h2><%@include file="message.jsp"%></h2>
	</header>

	<!-- Navigation -->
	<nav>
		<a href="admin.jsp">🏠 Home</a> 
		<a href="ReadMessageServlet">📩Read Messages</a> 
		<a href="addservice.jsp">🛠 Add Services</a>
		<a href="ReadServiceDeleteUpdateModule">Read Services</a>
		<a href="#">Booking Info</a>
		<a href="#">Set Menu</a>
		 <a href="#">🔑 Change Password</a>
		  <a href="#">🚪 Logout</a>
	</nav>

	<!-- Main Content -->
	<main>
		<h2>Admin Dashboard</h2>
		<p>Welcome to the admin panel! Manage restaurant operations, check
			messages, update credentials, and ensure a smooth workflow with ease.
		</p>
	</main>

	<!-- Footer -->
	<footer>
		<p>&copy; 2025 Restaurant Admin Panel. All rights reserved.</p>
	</footer>
</body>
</html>
