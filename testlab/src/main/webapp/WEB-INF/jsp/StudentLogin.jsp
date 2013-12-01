
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>


<c:url value="/login" var="loginUrl"/>
<c:url value="/create" var="addUrl"/>
<c:url value="/update" var="editUrl"/>
<c:url value="/delete" var="deleteUrl"/>
<c:url value="/gradePractice" var="gradePracticeUrl"/>
<c:url value="/grading" var="gradingUrl"/>
<c:url value="/displayAll" var="displayAllUrl"/>
<c:url value="/StudentLogin" var="StudentLoginUrl"/>

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

    <!-- Bootstrap core CSS -->
    <link href='<c:url value="/resources/css/bootstrap.css"/>' rel="stylesheet">
            <link href='<c:url value="/resources/css/flowchart.css"/>' rel="stylesheet">
<link href='<c:url value="/resources/css/Main.css"/>' rel="stylesheet">


    <!-- Custom styles for this template -->
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
             <div class="movingText"> 
			<marquee  behavior="scroll" direction="right">WELCOME TO ONLINE SOFTWARE TEST LABS!!</marquee>
			</div>
            </div>         
          </div>
        </div>
      </div>
    </div>


    <!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide"> 
      <div class="carousel-inner">
        <div class="item active">
          <img src='<c:url value="/resources/pictures/Home.jpg"/>' alt="Jaismeen slide">
        </div>
             
      </div>
      <hr>

    <div id="login_wrapper">
        <div id="login">
            <br>
            <label class="col-lg-4 control-label">Username</label>
                <div class="col-lg-6">
                  <input type="text" class="form-control" id = "username" name="username"><br>
                <br>
                </div>
               
                <label class="col-lg-4 control-label">Password</label>
                <div class="col-lg-6">
                    <input type="password" class="form-control" id = "password" name="password"><br>
                </div>
                
                     <button id="btn_login" class="btn btn-default" type="button" onclick="login('1')">Login</button><br><br>
               
        </div>
    </div>
    



    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->

  </body>
</html>
