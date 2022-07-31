<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit Lecture</title>
	<script>
		function returnBack(){
			window.history.back();
		}
	</script>
</head>
<body>
	<h1>Edit Lecture ${lid} </h1>
       <form:form method="post" action="lectureeditsave">  
      	<table >  
      	 <tr> 
         	<td><form:hidden  path="id" /></td>
         </tr> 
         
         <tr>  
          	<td>Category : </td> 
          	<td><form:input path="category"  /></td>
         </tr>  
         
         <tr>  
          	<td>Title : </td> 
          	<td><form:input path="title"  /></td>
         </tr>  
          
         <tr>  
          	<td>Content :</td>  
          	<td><form:input path="content" /></td>
         </tr> 
     	 <tr>  
          	<td>Link : </td> 
          	<td><form:input path="link"  /></td>
         </tr> 
	     <tr>    
	        <td>
	        <button type="button" onclick="returnBack()">Cancel</button>
	        <input type="submit" value="Edit Save" />
	        </td>  
         </tr>
        </table>
        </form:form>
	</body>
</html>