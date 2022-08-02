<%@page import="com.javatpoint.dao.*,com.javatpoint.beans.*,java.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>W3Class</title>
		<!-- <link rel="stylesheet" href="./w3s.css"> -->
		<style>
			*,
			*:before,
			*:after {
			    box-sizing: inherit;ß
			}
			
			.white_atag {
			    color: white !important;
			    text-decoration: underline!important;
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
			    -webkit-touch-callout: none;
			    -webkit-user-select: none;
			    -khtml-user-select: none;
			    -moz-user-select: none;
			    -ms-user-select: none;
			    user-select: none;
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
			
			.w3-section,
			.w3-code {
			    margin-top: 16px!important;
			    margin-bottom: 16px!important;
			}
			
			.w3-padding-32 {
			    padding-top: 32px!important;
			    padding-bottom: 32px!important;
			}
			
			.w3-content,
			.w3-auto {
			    margin-left: auto;
			    margin-right: auto;
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
			    font-size: 15px !important;
			}
			
			.w3-code,
			.w3-codespan {
			    font-family: Consolas, Menlo, "courier new", monospace;
			    font-size: 16px;
			}
			
			.w3-center {
			    text-align: center!important;
			}
			
			.w3-padding-64 {
			    padding-top: 64px!important;
			    padding-bottom: 64px!important;
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
			
			.w3-padding-64 {
			    padding-top: 64px!important;
			    padding-bottom: 64px!important;
			}
			
			.w3-white,
			.w3-hover-white:hover {
			    color: #000!important;
			    background-color: #fff!important;
			}
			
			a.w3-hover-text-green:hover,
			a.w3-hover-text-green:active {
			    color: #04AA6D!important;
			}
			
			@media (min-width: 993px) {
			    .w3-hide-large {
			        display: none !important;
			    }
			}
			
			@media (max-width: 992px) {
			    .w3-hide-small {
			        display: none !important;
			    }
			}
			
			.w3-col,
			.w3-half,
			.w3-third,
			.w3-twothird,
			.w3-threequarter,
			.w3-quarter {
			    float: left;
			    width: 100%;
			}
			
			.w3-col.l6 {
			    width: 49.99999%;
			}
			
			.w3-btn,
			.w3-btn:link,
			.w3-btn:visited {
			    color: #FFFFFF;
			    background-color: #4CAF50;
			}
			
			.w3-margin-bottom {
			    margin-bottom: 16px!important;
			}
			
			.w3-round,
			.w3-round-medium {
			    border-radius: 5px;
			}
			
			.w3-content {
			    max-width: 980px;
			}
			
			.ws-green {
			    background-color: #04AA6D!important;
			    color: white!important;
			}
			
			.w3-panel {
			    margin-top: 16px;
			    margin-bottom: 16px;
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
			
			.tryit-button {
			    background-color: #04AA6D;
			    color: white;
			    border-radius: 25px;
			    font-size: 18px;
			    width: 200px;
			}
			
			a.hover_white:hover,
			a.hover_white:active {
			    color: white!important;
			}
			
			#loginactioncontainer {
			    margin-left: 50px;
			}
			
			#loginactioncontainer {
			    width: 80px;
			    height: 50px;
			}
			
			#w3loginbtn {
			    width: 130px;
			    background-color: #04AA6D;
			    color: white;
			    border-radius: 25px;
			    font-size: 18px;
			    line-height: 1.5;
			    display: none;
			}
			
			#mypagediv {
			    display: none;
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
			
			@media screen and (min-width: 861px) {
			    #myAccordion,
			    #navbtn_menu,
			    .hidesm {
			        display: none !important;
			    }
			}
			
			#myAccordion {
			    font-family: 'Source Sans Pro', sans-serif;
			    z-index: 1;
			    width: 100%;
			    position: absolute;
			    display: none;
			    background-color: #E7E9EB;
			}
			
			@media screen and (min-width: 860px) {
			    #myAccordion {
			        display: none !important;
			    }
			}
			
			@media screen and (max-width: 1160px) {
			    .ext_icon_container {
			        display: none;
			    }
			}
			
			body.darkpagetheme .ws-grey {
			    background-color: #38444d!important;
			    color: #ddd!important;
			}
			
			.fa {
			    display: inline-block;
			    font: normal normal normal 14px/1 fontawesome;
			    font-size: inherit;
			    text-rendering: auto;
			    -webkit-font-smoothing: antialiased;
			    -moz-osx-font-smoothing: grayscale;
			    transform: translate(0, 0);
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
			
			.navbar__logo {
			    margin: 0;
			    padding-left: 8px;
			}
			
			#nav_logo {
			    width: 50px;
			    height: 50px;
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
			
			.navbar__icons {
			    list-style: none;
			    display: flex;
			    margin: 0;
			    padding-left: 0;
			}
			
			.navbar__icons li {
			    padding: 8px 12px;
			    margin: 0;
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
			
			.hover_green:hover,
			.hover_green:active {
			    background-color: #029959!important;
			    color: white!important;
			}
			
			a.hover_yellow:hover,
			a.hover_yellow:active {
			    background-color: gold!important;
			}
			
			.search_subject {
			    text-align: center;
			}
			
			.learntocode_whereto {
			    color: white;
			}
			
			h4 a:hover {
			    color: #04AA6D;
			}
			
			a {
			    text-decoration: none!important;
			}
			
			h4 a {
			    text-decoration: underline!important;
			    text-align: center;
			    float: center;
			    margin-top: 10px;
			}
			
			.ref-button {
			    background-color: white;
			    font-size: 18px;
			    margin: auto;
			    display: block;
			    width: 200px;
			    border-radius: 25px;
			    color: #000;
			}
			
			input {
			    writing-mode: horizontal-tb !important;
			    text-rendering: auto;
			    color: -internal-light-dark(black, white);
			    letter-spacing: normal;
			    word-spacing: normal;
			    line-height: normal;
			    text-transform: none;
			    text-indent: 0px;
			    text-shadow: none;
			    display: inline-block;
			    text-align: start;
			    appearance: auto;
			    -webkit-rtl-ordering: logical;
			    cursor: text;
			    background-color: -internal-light-dark(rgb(255, 255, 255), rgb(59, 59, 59));
			    margin: 0em;
			    padding: 1px 2px;
			    border-width: 2px;
			    border-style: inset;
			    border-color: -internal-light-dark(rgb(118, 118, 118), rgb(133, 133, 133));
			    border-image: initial;
			}
			
			button,
			input {
			    overflow: visible;
			}
			
			#lineofsearchresults {
			    float: none;
			    display: none;
			    height: 20px;
			}
			
			form.example {
			    position: relative;
			    height: 47.5px;
			}
			
			form {
			    display: block;
			}
			
			form.example button {
			    border-radius: 25px;
			    float: left;
			    height: 47.5px;
			    width: 20%;
			    padding: 10px;
			    background: #04AA6D;
			    color: white;
			    font-size: 17px;
			    border: 1px solid #282A35;
			    border-left: none;
			    cursor: pointer;
			    border-top-left-radius: 0;
			    border-bottom-left-radius: 0;
			}
			
			form.example input[type=text] {
			    padding: 10px;
			    font-size: 17px;
			    border: 1px solid #282A35;
			    border-radius: 25px;
			    float: left;
			    width: 80%;
			    padding-left: 25px;
			    background: white;
			    border-top-right-radius: 0;
			    border-bottom-right-radius: 0;
			    border-right: 0;
			    border-right: 1px solid #04AA6D;
			    outline: 0;
			}
			
			.learntocodecontent {
			    padding-left: 90px;
			    padding-right: 90px;
			}
			
			.learntocodeh1 {
			    font-size: 70px;
			    font-weight: 700;
			}
			
			.learntocodeh3 {
			    color: #FFC0C7;
			    font-weight: 700;
			    margin-top: 30px!important;
			    font-size: 23px;
			}
			
			form.example {
			    position: relative;
			}
			
			form {
			    display: block;
			    margin-top: 0em;
			}
			
			.codeeditorbr-row {
			    padding: 10px;
			    background: #f1f1f1;
			    border-top-left-radius: 4px;
			    border-top-right-radius: 4px;
			}
			
			.codeeditorbr-column {
			    float: left;
			    padding-left: 0;
			    height: inherit;
			}
			
			.codeeditorbr-middle {
			    width: 80%;
			    text-align: left;
			    background-color: inherit;
			}
			
			.codeeditorbr-left {
			    width: 20%;
			    text-align: left;
			    background-color: inherit;
			}
			
			.codeeditorbr-input {
			    width: 80%;
			    border-radius: 3px;
			    border: none;
			    background-color: white;
			    margin-top: -8px;
			    height: 22px;
			    color: #666;
			    font-size: 14px;
			    padding: 5px;
			}
			
			.codeeditorbr-dot {
			    margin-top: 5px;
			    height: 15px;
			    width: 15px;
			    background-color: #bbb;
			    border-radius: 50%;
			    display: inline-block;
			    margin-left: 3px;
			}
			
			.codeeditorbr-container {
			    border-top-left-radius: 4px;
			    border-top-right-radius: 4px;
			}
			
			.codeeditorbr-input {
			    width: 80%;
			    border-radius: 3px;
			    border: none;
			    background-color: white;
			    margin-top: -8px;
			    height: 22px;
			    color: #666;
			    font-size: 14px;
			    padding: 5px;
			}
			
			a {
			    color: inherit;
			}
			
			a {
			    background-color: transparent;
			}
			
			.w3-container,
			.w3-panel {
			    padding: 0.01em 16px;
			}
			
			.w3-left {
			    float: left !important;
			}
			
			.w3-right {
			    float: right !important;
			}
			
			.w3-wide {
			    letter-spacing: 4px;
			}
			
			.button,
			input,
			select,
			textarea,
			optgroup {
			    font: inherit;
			    margin: 0px;
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
			
			.black-color {
			    background-color: #282A35;
			    color: white;
			}
			
			#black_button {
			    background-color: #282A35!important;
			    color: white;
			}
			
			.ws-turquoise {
			    background-color: #96D4D4!important;
			    color: black!important;
			}
			
			#bgcodeimg {
			    background: #282A35 url(https://www.w3schools.com/about/w3codes.png) no-repeat fixed center;
			}
			
			.exercise-button {
			    padding: 70px 50px;
			    font-size: 35px;
			    width: 87%;
			    opacity: 0.97;
			}
			
			#getdiploma {
			    position: relative;
			    padding: 60px 60px 50px 60px;
			    margin-bottom: 85px;
			    background-color: #282A35;
			    color: #FFC0C7;
			    font-family: 'Source Sans Pro', sans-serif;
			    text-align: left;
			}
			
			#getdiploma h2 {
			    font-size: 62px;
			    margin-top: 1em;
			    margin-bottom: 1em;
			    font-family: 'Source Sans Pro', sans-serif;
			}
			
			#getdiploma p {
			    font-size: 52px;
			    margin-top: 1em;
			    margin-bottom: 1em;
			    font-family: 'Source Sans Pro', sans-serif;
			}
			
			#getdiploma a {
			    border-radius: 50px;
			    font-size: 18px;
			    background-color: #04AA6D;
			    padding: 17px 55px;
			}
			
			#w3_cert_arrow {
			    position: absolute;
			    right: 240px;
			    width: 220px;
			    transform: rotate(10deg);
			    bottom: 0;
			    z-index: 1;
			}
			
			#w3_cert_badge {
			    position: absolute;
			    right: 5%;
			    width: 220px;
			    transform: rotate(10deg);
			    bottom: -15%;
			}
			
			.cls-1 {
			    fill: #04aa6b;
			}
			
			.cls-2,
			.cls-3 {
			    font-family: RobotoMono-Medium, Roboto Mono;
			    font-weight: 500;
			}
			
			.cls-2,
			.cls-3 {
			    font-family: RobotoMono-Medium, Roboto Mono;
			    font-weight: 500;
			}
			
			.cls-2 {
			    font-size: 23px;
			}
			
			#howto_padding {
			    padding: 48px 24px 100px 24px;
			}
			
			#howto_iframe {
			    width: 100%;
			    border: 6px solid #e3e6e8;
			    height: 400px;
			    border-bottom-left-radius: 4px;
			    border-bottom-right-radius: 4px;
			}
			
			.vl-howto {
			    border-left: 50px solid #282A35;
			    height: 80px;
			    position: absolute;
			    top: -6px;
			    left: 50%;
			    margin-left: -25px;
			}
			
			.vl-howtobtn {
			    width: 50%;ß
			    margin-top: 73px;
			}
		</style>

	</head>

	<body>  
		<h1 style="text-align: center;">W3Class</h1>  
		

	
	<!-- 	classroom & lecture Menu -->	
	 	
		<nav class="navbar" style="height: 70px; padding:0; margin:0;">
	        <div class="w3-bar w3-card-2 notranslate" style="width: 100%; height: inherit; padding-left:12px;padding-right:16px;overflow:visible; vertical-align: middle;">
            	<a class="w3-bar-item w3-button w3-hide-small barex bar-item-hover w3-padding-24 hover_green" 
            	href="#" onclick="nologin()" id="navbtn_tutorials" title="Tutorials" style="width:116px; ">Classroom</a> 
            	<a class="w3-bar-item w3-button w3-hide-small barex bar-item-hover w3-padding-24 hover_green" 
            	href="#" onclick="nologin()" id="navbtn_references" title="References" style="width:132px; ">Lecture</a> 

            	<a class="w3-bar-item w3-button w3-hide-small barex bar-item-hover w3-padding-24 hover_green" 
            	href="#" onclick="nologin()" id="navbtn_references" title="References" style="width:150px; float:right;">Create Lecture</a> 				
				<a class="w3-bar-item w3-button w3-hide-small barex bar-item-hover w3-padding-24 hover_green" 
				href="#" onclick="nologin()" id="navbtn_tutorials" title="Tutorials" style="width:150px;float:right;">Create Classroom</a> 

	            
	        </div>
    	</nav>


		<section class="center">
			<h1>Please log in</h1>
			<button type="button" onclick="location.href='loginform'"></button>
		</section>
		
		<script>
			function nologin(){
				alert('로그인이 필요합니다 !!')
			}
		</script>
	</body>
</html>

 
