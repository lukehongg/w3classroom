<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="UTF-8">
		<title>W3Class</title>
		<!-- <link rel="stylesheet" href="./w3s.css"> -->
		<style>
			#tableCSS {
				  font-family: Arial, Helvetica, sans-serif;
				  border-collapse: collapse;
				  width: 100%;
				}
				
				#tableCSS td, #tableCSS th {
				  border: 1px solid #ddd;
				  padding: 8px;
				}
				
				#tableCSS tr:nth-child(even){background-color: #f2f2f2;}
				
				/* #tableCSS tr:hover {background-color: #ddd;} */
				
				#tableCSS th {
				  padding-top: 12px;
				  padding-bottom: 12px;
				  background-color: #04AA6D;
				  color: white;
				}
				.center {
					margin: auto;
					/* padding: 10px; */
					padding-top: 10px;
					text-align: center;
				}
				
		
			
			p {
			    display: block;
			    margin-block-start: 1em;
			    margin-block-end: 1em;
			    margin-inline-start: 0px;
			    margin-inline-end: 0px;
			}
			.w3-bar .w3-button {
			    white-space: normal;
			}
			
			.w3-bar .w3-bar-item {
			    padding: 8px 16px;
			    float: left;
			    width: auto;
			    border: none;
			    display: block;
			    outline: 0;
			    font-weight: bold;
			    line-height: 100%;
			}
			
			.w-bar-item:hover,
			.w-bar-item:active {
			    background-color: #04AA6D !important;
			    color: white !important;
			}
			
			.w3-padding-64 {
			    padding-top: 64px!important;
			    padding-bottom: 64px!important;
			}
			
			.w3-padding-32 {
			    padding-top: 32px!important;
			    padding-bottom: 32px!important;
			}
			
			.w3-padding-24 {
			    padding-top: 24px!important;
			    padding-bottom: 30px!important;
			}
			
			.w3-padding-16 {
			    padding-top: 16px!important;
			    padding-bottom: 16px!important;
			}
			
			
			
			.w3-btn,
			.w3-button {
			    border: none;
			    display: inline-block;
			    padding: 8px 16px;
			    vertical-align: middle;
			    overflow: hidden;
			    text-decoration: none;
			    color: inherit;
			    background-color: inherit;
			    text-align: center;
			    cursor: pointer;
			    white-space: nowrap;
			}
			
			.tut-button {
			    background-color: #04AA6D;
			    color: white;
			    font-size: 18px;
			    margin: auto;
			    display: block;
			    width: 200px;
			    border-radius: 25px;
			}
			
			
			.w3-code {
			    width: auto;
			    background-color: #fff;
			    color: #000;
			    padding: 8px 12px;
			    border-left: 4px solid #4CAF50;
			    word-wrap: break-word;
			}
			
			.w3-code,
			w3-codeline {
			    font-size: 15px;
			}
			
			.w3-medium {
			    font-size: 13px !important;
			}
			
			.w3-code,
			.w3-codespan {
			    font-family: Consolas, Menlo, "courier new", monospace;
			    font-size: 16px;
			}
			
			.w3-center {
			    text-align: center!important;
			}
			
			
			
			.w3-card,
			.w3-card-2 {
			    box-shadow: 0 2px 5px 0 rgb(0 0 0 / 16%), 0 2px 10px 0 rgb(0 0 0 / 12%);
			}
			
			.w3-row-padding,
			.w3-row-padding>.w3-half,
			.w3-row-padding>.w3-third,
			.w3-row-padding>.w3-twothird,
			.w3-row-padding>.w3-threequarter,
			.w3-row-padding>.w3-quarter,
			.w3-row-padding>.w3-col {
			    padding: 0 8px;
			}
			
			.w3-white,
			.w3-hover-white:hover {
			    color: #000!important;
			    background-color: #fff!important;
			}
			
			
			
			.ws-green {
			    background-color: #04AA6D!important;
			    color: white!important;
			}
			
			.ws-btn {
			    font-size: 17px;
			    font-family: 'Source Sans Pro', sans-serif;
			    border: none;
			    border-radius: 5px;
			    display: inline-block;
			    padding: 6px 18px;
			    vertical-align: middle;
			    overflow: hidden;
			    color: inherit;
			    text-align: center;
			    cursor: pointer;
			    white-space: nowrap;
			    background-color: #04AA6D;
			    color: #ffffff;
			}
			
			.ws-black {
			    background-color: #282A35!important;
			    color: white!important;
			}
			
			.ws-yellow {
			    background-color: #FFF4A3!important;
			    color: black!important;
			}
			
			.ws-pink {
			    background-color: #FFC0C7!important;
			    color: black!important;
			}
			
			.ws-light-pink {
			    background-color: #F3ECEA!important;
			}
			
			.ws-light-green {
			    background-color: #D9EEE1!important;
			}
			
			.grey-color {
			    background-color: #E7E9EB;
			    color: #000;
			}
			
			.green-border {
			    border-left: 4px solid #04AA6D;
			}
			.white_atag {
			    color: white !important;
			    text-decoration: underline!important;
			}
			a.w3-hover-text-green:hover,
			a.w3-hover-text-green:active {
			    color: #04AA6D!important;
			}

			#nav_tutorials,
			#nav_references,
			#nav_exercises {
			    display: none;
			    padding-bottom: 40px;
			    position: absolute;
			    width: 100%;
			    z-index: 10 !important;
			}
	
			#nav_tutorials,
			#nav_references,
			#nav_exercises {
			    margin-top: 0;
			}
	
			#nav_tutorials,
			#nav_references,
			#nav_exercises,
			#nav_login {
			    display: none;
			    letter-spacing: 0;
			    margin-top: 44px;
			    position: absolute;
			    width: 100%;
			    background-color: #282A35;
			    color: white;
			    padding-bottom: 60px;
			}
			
			#nav_tutorials,
			#nav_references,
			#nav_exercises,
			#nav_login {
			    -webkit-overflow-scrolling: touch;
			    overflow: auto;
			}
			
			.navbar {
			    display: flex;
			    height: 200px;
			    justify-content: space-between;
			    align-items: center;
			    padding: 0px 12px;
			}
			
			.navbar__menu {
			    list-style: none;
			    display: flex;
			    margin: 0;
			    padding-left: 8px;
			    line-height: 50px;
			}
			
			.navbar__menu li {
			    list-style: none;
			    padding: 0px 0px;
			}
			
			.navbar__menu>li>ul {
			    float: left;
			}
			
			.navbar__greens {
			    list-style: none;
			    display: flex;
			    margin: 0;
			    padding-left: 0;
			}
			
			.navbar__greens li {
			    padding: 8px 12px;
			    margin: 0;
			}
			
			main section {
			    text-align: center;
			}
			
			a.hover_green:hover,
			a.hover_green:active {
			    background-color: #029959!important;
			    color: white!important;
			}			
			
			* {
  box-sizing: border-box;
}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
}

label {
  padding: 12px 12px 12px 0;
  display: inline-block;
}

input[type=submit] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: right;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}

.col-25 {
  float: left;
  width: 25%;
  margin-top: 6px;
}

.col-75 {
  float: left;
  width: 75%;
  margin-top: 6px;
}
/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - when the screen is less than 600px wide, make the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .col-25, .col-75, input[type=submit] {
    width: 100%;
    margin-top: 0;
  }
}
			a:link, a:visited {
    			color: mediumblue;
    		}	
		</style>
		<script>
			function returnBack(){
				window.history.back();
			}
		</script>
	</head>

<body>
				<h1 style="text-align: center;">W3Class</h1>  
	
	<!-- 	classroom & lecture Menu -->	
	 	
		<nav class="navbar" style="height: 70px; padding:0; margin:0;">
	        <div class="w3-bar w3-card-2 notranslate" style="width: 100%; height: inherit; padding-left:12px;padding-right:16px;overflow:visible; vertical-align: middle;">
            	<a class="w3-bar-item w3-button w3-hide-small barex bar-item-hover w3-padding-24 hover_green" 
            	href="viewclassroom" onclick="AllClassroom()" id="navbtn_tutorials" title="Tutorials" style="width:116px; color: black;">Classroom</a> 
            	<a class="w3-bar-item w3-button w3-hide-small barex bar-item-hover w3-padding-24 hover_green" 
            	href="viewlecture" onclick="AllLecture()" id="navbtn_references" title="References" style="width:132px; color: black;">Lecture</a> 

            	<a class="w3-bar-item w3-button w3-hide-small barex bar-item-hover w3-padding-24 hover_green" 
            	href="lectureform" id="navbtn_references" title="References" style="width:150px; float:right;color: black;">Create Lecture</a> 				
				<a class="w3-bar-item w3-button w3-hide-small barex bar-item-hover w3-padding-24 hover_green" 
				href="classroomform" id="navbtn_tutorials" title="Tutorials" style="width:170px;float:right; background-color:#029959;color: white;">Create Classroom</a> 

	            
	        </div>
    	</nav>

		
			<h1 class="center">Add New Classroom</h1>
	       <div class="container">
	       <form:form method="post" action="saveClassroom">  
			<div class="row">
			    <div class="col-25">
			      <label for="fname">Title :</label>
			    </div>
			    <div class="col-75">
				  <form:input type="text" path="classTITLE"  />
				</div>
			</div>
			<div class="row">
			    <div class="col-25">
			      <label for="fname">Content :</label>
			    </div>
			    <div class="col-75">
				  <form:input type="text" path="classCONTENT"  />
				</div>
			</div>
			<br>
			 <div class="row">
			    <button type="button" onclick="returnBack()">Cancel</button>
			    <input type="submit" value="Save">
			 </div>
	      	</form:form>
	      </div>
	       <%-- <form:form method="post" action="saveClassroom">  
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
	       </form:form>   --%>
		

	    <footer class="w3-container w3-center w3-padding-16 ws-black" style="position: fixed; bottom:0; left:0; padding: 12px">
	        <div class="w3-container w3-padding-16">
	            <nav class="w3-center w3-hide-large w3-margin-top w3-wide">
	                <a href="https://www.w3schools.com/forum/default.asp" target="_blank" class="w3-hover-text-green" style="color: white;text-decoration:none" title="Forum">FORUM</a> |
	                <a href="https://www.w3schools.com/about/default.asp" target="_top" class="w3-hover-text-green" style="color: white;text-decoration:none" title="About W3Schools">ABOUT</a>
	            </nav>
	        </div>
	        <div class="w3-center w3-medium" style="">
	        <p style="padding-top:16px;">
	            W3Schools is optimized for learning, testing, and training. Examples might be simplified to improve reading and basic understanding. Tutorials, references, and examples are constantly reviewed to avoid errors, but we cannot warrant full correctness of
	            all content. While using this site, you agree to have read and accepted our <a href="https://www.w3schools.com/about/about_copyright.asp" class="white_atag w3-hover-text-green">terms of use</a>, <a href="https://www.w3schools.com/about/about_privacy.asp"
	                class="white_atag w3-hover-text-green">cookie and privacy policy</a>.<br>
	            <a href="https://www.w3schools.com/about/about_copyright.asp" class="white_atag w3-hover-text-green">Copyright 1999-2022</a> by Refsnes Data. All Rights Reserved.<br><br>
	        </p>	        
	        </div>
		</footer>
</body>
</html>
		
