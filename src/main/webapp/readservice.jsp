<%@page import="tech.nk.model.ServiceModulePojo"%>
<%
   String check=(String)session.getAttribute("adminlogin");
    if(check==null)
    {
    	response.sendRedirect("adminlogin.jsp");
    	return;
    }

%>

<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Read Service</title>
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
	font-size: 30px;
	font-weight: 700;
	color: #ff6f61;
}

/* Navigation */
nav {
	background: rgba(255, 255, 255, 0.9);
	padding: 10px;
	display: flex;
	justify-content: center;
	gap: 20px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

nav a {
	text-decoration: none;
	color: #333;
	font-size: 16px;
	font-weight: 600;
	padding: 10px 20px;
	border-radius: 5px;
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
	font-size: 28px;
	font-weight: 700;
	margin-bottom: 20px;
	text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.2);
}

main p {
	color: #444;
	font-size: 18px;
	line-height: 1.8;
	max-width: 700px;
	margin: auto;
}

/* Table Styling */
table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
	background: #fff;
	border-radius: 10px;
	overflow: hidden;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}

th, td {
	padding: 12px 15px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

th {
	background: #ff6f61;
	color: white;
	font-size: 18px;
}

tr:hover {
	background: rgba(255, 111, 97, 0.1);
}

button {
	background: #ff4d4d;
	color: white;
	border: none;
	padding: 8px 12px;
	border-radius: 5px;
	cursor: pointer;
	font-size: 14px;
	transition: background 0.3s ease-in-out;
}

button:hover {
	background: #cc0000;
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
@media ( max-width : 768px) {
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
	table {
		font-size: 14px;
	}
}
</style>
</head>
<body>
	<!-- Header -->
	<header>
		<h1>Read Services</h1>
	</header>

	<!-- Navigation -->
	<nav>
		<a href="admin.jsp">🏠 Home</a> 
		<a href="ReadServiceDeleteUpdateModule">🔄Refresh</a>
		<a href="#">🚪 Logout</a>
	</nav>

	<!-- Main Content -->
	<main>
		<h2><%@include file="message.jsp"%></h2>
		<p>Below is the list of messages received through the contact
			form.</p>

		<table>
			<tr>
				<th>ID</th>
				<th>ICONNAME</th>
				<th>TITLE</th>
				<th>DESCRIPTION</th>
				<th>DATE & TIME</th>
				<th>Action</th>
			</tr>
			<%
			
	          ArrayList<ServiceModulePojo> arrayList=(ArrayList<ServiceModulePojo>)session.getAttribute("servicedata");
                if (arrayList != null && !arrayList.isEmpty()) {
                    for (ServiceModulePojo cp : arrayList) {
            %>
			<tr>
				<td><%= cp.getSn() %></td>
				<td><%= cp.getIconname() %></td>
				<td><%= cp.getTitle() %></td>
				<td><%= cp.getDescription() %></td>
				<td><%= cp.getDatetime() %></td>
				<td>
					<form action="DeleteServiceModuleServlet" method="post">
						<input type="hidden" name="sn" value="<%= cp.getSn() %>">
						<button type="submit">Delete</button>
					</form>
				</td>
			</tr>
			<%
                    }
                } 
            %>
			
		</table>
	</main>

	<!-- Footer -->
	<footer>
		<p>&copy; 2025 Restaurant Admin Panel. All rights reserved.</p>
	</footer>
</body>
</html>