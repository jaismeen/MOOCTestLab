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
   <link href='<c:url value="/resources/css/bootstrap.css"/>' rel="stylesheet">
    <link href='<c:url value="/resources/css/flowchart.css"/>' rel="stylesheet">

    <link href='<c:url value="/resources/css/carousel.css"/>' rel="stylesheet">
    <link href='<c:url value="/resources/css/Main.css"/>' rel="stylesheet">
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
                <li class="active"><a href="HomeStudent">Home</a></li>
                <li><a href="FlowChart">Take a Lab</a></li>
                <li><a href="PracticeList">Practice Sessions</a></li>
                 <li><a href="StudentLogin">Logout</a></li>
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
	<br>
    <div id="PracList">
    <p><strong>Welcome student, In order to understand the software testing concepts,<br> please practice the below sessions.These session will help you analyze your mistakes.<br> We provide grading of Practice Sessions as well!!</strong></p> 
    <br>
    <a id="P1" href="Practice" onclick="set_practiceID('P1')">Practice Session 1</a><br>
    <a id="P2" href="Practice" onclick="set_practiceID('P2')">Practice Session 2</a><br>
    <a id="P3" href="Practice" onclick="set_practiceID('P3')">Practice Session 3</a><br>
    <a id="P4" href="Practice" onclick="set_practiceID('P4')">Practice Session 4</a><br>
    </div>



    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->

  </body>
</html>
