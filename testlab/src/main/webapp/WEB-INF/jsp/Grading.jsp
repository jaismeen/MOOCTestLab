<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>


<c:url value="/login" var="loginUrl"/>
<c:url value="/create" var="addUrl"/>
<c:url value="/update" var="editUrl"/>
<c:url value="/delete" var="deleteUrl"/>
<c:url value="/gradePractice" var="gradePracticeUrl"/>
<c:url value="/grading" var="gradingUrl"/>
<c:url value="/displayAll" var="displayAllUrl"/>
<c:url value="/StudentLogin" var="StudentLoginUrl"/>
<c:url value="/submitSolution" var="submitSolutionUrl"/>

<c:url value="/loadTestData" var="loadTestDataUrl"/>
<c:url value="/getTestData" var="getTestDataUrl"/>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.png">

    <title>Extended MOOC</title>
   <link href='<c:url value="/resources/css/bootstrap.css"/>' rel="stylesheet">
    <link href='<c:url value="/resources/css/flowchart.css"/>' rel="stylesheet">
    <link href='<c:url value="/resources/css/Main.css"/>' rel="stylesheet">

    <link href='<c:url value="/resources/css/carousel.css"/>' rel="stylesheet">
    <script type='text/javascript' src='<c:url value="/resources/js/jquery-1.6.4.min.js"/>'></script>
    <script src='<c:url value="/resources/js/tabs.js"/>'></script>
    <script src='<c:url value="/resources/js/raphael.js"/>'></script>
    <script src='<c:url value="/resources/js/flowchart-1.1.3.js"/>'></script>
      <script>
    $(function() {

      
    // init
    urlHolder.login = '${loginUrl}';
    urlHolder.add = '${addUrl}';
    urlHolder.edit = '${editUrl}';
    urlHolder.del = '${deleteUrl}';
    
    urlHolder.loadTestData = '${loadTestDataUrl}';
    urlHolder.getTestData = '${getTestDataUrl}';

    urlHolder.gradePractice = '${gradePracticeUrl}';
    urlHolder.grading = '${gradingUrl}';
    urlHolder.displayAll = '${displayAllUrl}';
    urlHolder.submitSolution = '${submitSolutionUrl}';
    
    });
        </script> 
       	
        </head>
<!-- NAVBAR
================================================== -->
  <body>
      <div class="navbar-wrapper">
      <div class="container">

        <div class="navbar navbar-inverse navbar-static-top">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">ONLINE TEST LABS</a>
            </div>
            <div class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="HomeProfessor">Home</a></li>
                <li><a href="SetupLab">Setup Lab</a></li>
                <li><a href="Grading">Grades</a></li>
                 <li><a href="ProfessorLogin">Logout</a></li>

               
              </ul>
            </div>
          </div>
        </div>

      </div>
    </div>

 <div id="myCarousel" class="carousel slide">
      <div class="carousel-inner">
        <div class="item active">
          <img src='<c:url value="/resources/pictures/Home.jpg"/>' alt="Jaismeen slide">
        </div>
             
      </div>
   <hr>
       
   <div id="grading_section">
   
   	<div id="startGrading">
   		<h4> <strong>Welcome Instructor, Click on the below button to start grading lab. </strong></h4>
   		<br>
       <button id="btn_start" class="btn btn-default" type="button" onclick="grading()">Start Grading</button><br><br>
   </div>
   
     <div id="displayGrades">  
     <h4> <strong>You can view student grades by clicking the below button.</strong></h4>
   		<br>            
    <button id="btn_display" class="btn btn-default" type="button" onclick="displayAll()">Display Grades</button><br><br>
         <div id="score_area">
         </div>
    </div>
  </div>
  
    



    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->

  </body>
</html>
