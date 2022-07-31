<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

		<h1>Add New Lecture</h1>
       <form:form method="post" action="saveLecture">  
      	<table >  
         <tr>  
          <td>category : </td> 
          <td><form:input path="category"  /></td>
         </tr>  
         <tr>  
          <td>Title :</td>  
          <td><form:input path="title" /></td>
         </tr> 
         <tr> 
         <tr>  
          <td>Content :</td>  
          <td><form:input path="content" /></td>
         </tr> 
         <tr>  
         <tr>  
          <td>Link :</td>  
          <td><form:input path="link" /></td>
         </tr> 
         <tr> 
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
