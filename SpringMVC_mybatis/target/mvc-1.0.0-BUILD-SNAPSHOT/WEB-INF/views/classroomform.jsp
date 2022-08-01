<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Classroom</h1>
       <form:form method="post" action="saveClassroom">  
      	<table >  
         <tr>  
          <td>Title : </td> 
          <td><form:input path="title"  /></td>
         </tr>  
         <tr>  
          <td>Content :</td>  
          <td><form:input path="content" /></td>
         </tr> 
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
