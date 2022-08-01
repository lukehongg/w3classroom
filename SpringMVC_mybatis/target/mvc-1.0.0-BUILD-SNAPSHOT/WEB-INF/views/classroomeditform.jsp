<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
			<title>W3Class</title>
			<!-- <link rel="stylesheet" href="./w3s.css"> -->
			<style>
				#tableCSS {
				  font-family: Arial, Helvetica, sans-serif;
				  border-collapse: collapse;
				  width: 48%;
				}
				
				#tableCSS td, #tableCSS th {
				  border: 1px solid #ddd;
				  padding: 8px;
				}
				
				#tableCSS tr:nth-child(even){background-color: #f2f2f2;}
				
				#tableCSS tr:hover {background-color: #ddd;}
				
				#tableCSS th {
				  padding-top: 12px;
				  padding-bottom: 12px;
				  text-align: left;
				  background-color: #04AA6D;
				  color: white;
				}
			</style>
			<script type="text/javascript">
				function selectcate(){
					document.getElementById("ALL").style.display = "none";
					document.getElementById("HTML").style.display= "none";
					document.getElementById("CSS").style.display= "none";
					document.getElementById("JavaScript").style.display= "none";
					var x = document.getElementById("cate").value; 
					document.getElementById(x).style.display = "block";	  	
				}
				function returnBack(){
					window.history.back();
				}
			</script>
	</head>

	<body>
		<h1>Edit Classroom ${classID} </h1>
       <form:form method="post" action="editsave">  
      	<table >  
      	<tr>
      	<td></td>  
         <td><form:hidden  path="id" /></td>
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
          <td> </td>  
          <td>
          <button type="button" onclick="returnBack()">Cancel</button>
          <input type="submit" value="Edit Save" />
          </td>  
          
         </tr>  
        </table>  
        <br><br>
  
        
       </form:form>  
       <div>
       <section style="float: left;">
       		<h2>Current CURRICULUM</h2>
			<table border="1" id="tableCSS">  
				<tr><th>No.</th><th>Category</th><th>Title</th><th>Content</th><th>Link</th><th>Delete</th></tr>  
					<c:forEach var="u" items="${lec_by_class}">  
						<tr>
							<td>${u.id}</td><td>${u.category}</td><td>${u.title}</td>
							<td>${u.content}</td><td>${u.link}</td>
							<td><a href="deleteLecInCurri/${classID}/${u.id}">Delete</a></td>
						</tr>  
					</c:forEach>  
			</table>
		</section>
		
		<section style="float: right;">
			<h2>Lectures</h2>
			<select name="cate" id="cate" onchange='selectcate();'>
					<option value="ALL"> ALL </option>		
					<option value="HTML"> HTML </option>
					<option value="CSS"> CSS </option>
					<option value="JavaScript"> JavaScript </option>
			</select>
			<br>
			<div class="main-div" id="ALL" style="display: block">
				<table border="1" class="all-lecture-table" id="tableCSS">  
				<tr><th>No.</th><th>Category</th><th>Title</th><th>Content</th><th>Link</th><th>Add</th></tr>  
					<c:forEach var="u" items="${ALL_list}">  
						<tr>
							<td>${u.id}</td><td>${u.category}</td><td>${u.title}</td>
							<td>${u.content}</td><td>${u.link}</td>
							<td><a href="addLecInCurri/${classID}/${u.id}">Add</a></td>
						</tr>  
					</c:forEach>  
				</table>
			</div>
			
			<div class="main-div" id="HTML" style="display: none;">
				<table border="1"class="all-lecture-table" id="tableCSS">  
					<tr><th>No.</th><th>Category</th><th>Title</th><th>Content</th><th>link</th><th>Add</th></tr>  
					<c:forEach items="${HTML_list}" var="u">  
						<tr>
							<td>${u.id}</td><td>${u.category}</td><td>${u.title}</td>
							<td>${u.content}</td><td>${u.link}</td>
							<td><a href="addLecInCurri/${classID}/${u.id}">Add</a></td>
						</tr>  
					</c:forEach>  
				</table>
			</div>
			<div class="main-div" id="CSS" style="display: none;">
				<table border="1"class="all-lecture-table" id="tableCSS">  
					<tr><th>No.</th><th>Category</th><th>Title</th><th>Content</th><th>link</th><th>Add</th></tr>  
					<c:forEach items="${CSS_list}" var="u">  
						<tr>
							<td>${u.id}</td><td>${u.category}</td><td>${u.title}</td>
							<td>${u.content}</td><td>${u.link}</td>
							<td><a href="addLecInCurri/${classID}/${u.id}">Add</a></td>
						</tr>  
					</c:forEach>  
				</table>
			</div>
			<div class="main-div" id="JavaScript" style="display: none;">
				<table border="1"class="all-lecture-table" id="tableCSS">  
					<tr><th>No.</th><th>Category</th><th>Title</th><th>Content</th><th>link</th><th>Add</th></tr>  
					<c:forEach items="${JS_list}" var="u">  
						<tr>
							<td>${u.id}</td><td>${u.category}</td><td>${u.title}</td>
							<td>${u.content}</td><td>${u.link}</td>
							<td><a href="addLecInCurri/${classID}/${u.id}">Add</a></td>
						</tr>  
					</c:forEach>  
				</table>
			</div>
		</section>
       </div>
	</body>
</html>

		