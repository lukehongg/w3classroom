    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

	<h1> View Lectures in Classroom ${classID} </h1>
    <table border="2" width="70%" cellpadding="2" class="all-class-table">  
					<tr><th>No.</th><th>Category</th><th>Title</th><th>Content</th><th>Link</th></tr>  
					<c:forEach var="u" items="${lec_by_class}">  
						<tr>
							<td>${u.id}</td><td>${u.category}</td><td>${u.title}</td>
							<td>${u.content}</td><td>${u.link}</td>
						</tr>  
					</c:forEach>  
				</table>
    <br/>
    <br/>
    <a href="/mvc/viewclassroom">Return</a>