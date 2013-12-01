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
	<br><br><br><br><br><br>

    <div class="container marketing">

      <!-- Three columns of text below the carousel -->
      <div class="row">
        <div class="col-lg-4">
         <img class="img-circle" src='<c:url value="/resources/pictures/Instructor.jpg"/>' height="100" width="100"/>
          <h2>Professor</h2>
          <p>Special interface for Instructors to set Test Labs.</p>
          <p><a class="btn btn-default" href="ProfessorLogin" role="button">Login &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
          <img class="img-circle" src='<c:url value="/resources/pictures/Student.jpg"/>' height="100" width="100" alt="Generic placeholder image">
          <h2>Student</h2>
          <p>Platform for student to perform Labs online</p>
          <p><a class="btn btn-default" href="StudentLogin" role="button">Login &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
        <div class="col-lg-4">
        <img class="img-circle" src='<c:url value="/resources/pictures/About.jpg"/>' height="100" width="100" alt="Generic placeholder image">
          <h2>About Us</h2>
          <p>MOOC inspired software test labs</p>
          <p><a class="btn btn-default" href="#" role="button">Take a look &raquo;</a></p>
        </div><!-- /.col-lg-4 -->
      </div><!-- /.row -->



      <!-- FOOTER -->
      <footer>
      <br>
      <br>
      <br>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2013 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>

    </div><!-- /.container -->


  </body>
</html>
