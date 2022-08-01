    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1>Employees List</h1>
	<%-- <table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="emp" items="${list}"> 
    <tr>
    <td>${emp.id}</td>
    <td>${emp.name}</td>
    <td>${emp.salary}</td>
    <td>${emp.designation}</td>
    <td><a href="editemp/${emp.id}">Edit</a></td>
    <td><a href="deleteemp/${emp.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table> --%>
    <table border="2" width="70%" cellpadding="2" class="all-class-table">  
					<tr><th>No.</th><th>Title</th><th>Content</th><th>Edit</th><th>Delete</th></tr>  
					<c:forEach var="u" items="${list}">  
						<tr>
							<td>${u.id}</td><td>${u.title}</td><td>${u.content}</td>
							<td><a href="editform.jsp?id=${u.id}">Edit</a></td>  
							<td><a href="deleteuser.jsp?id=${u.id}">Delete</a></td>
						</tr>  
					</c:forEach>  
				</table>
    <br/>
    <a href="empform">Add New Employee</a>