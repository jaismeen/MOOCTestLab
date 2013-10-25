
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
                  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </button>
                  <a class="navbar-brand" href="#">ONLINE TEST LABS</a>
                </div>
              </div>
            </div>
          </div>
    </div>

<div id="myCarousel" class="carousel slide">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner">
        <div class="item active">
          <img src="pictures/pic1.JPG" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Online Test Based Labs: MOOC</h1>
              <p>Welcome to the Online test labs for SJSU Students.</p>
             <!--   <p><a class="btn btn-lg btn-primary" href="#" onclick="loadTestData()" role="button">Go to Test Lab</a></p>-->
            </div>
          </div>
        </div>
        <div class="item">
          <img src="pictures/pic2.jpg" data-src="holder.js/900x500/auto/#666:#6a6a6a/text:Second slide" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>Another example headline.</h1>
              <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img src="data:image/png;base64," data-src="holder.js/900x500/auto/#555:#5a5a5a/text:Third slide" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
              <h1>One more for good measure.</h1>
              <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
              <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
            </div>
          </div>
        </div>
      </div>
     <!--  <a class="left carousel-control" href="#myCarousel" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
      <a class="right carousel-control" href="#myCarousel" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>-->
    </div><!-- /.carousel -->


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
                
                     <button id="btn_login" class="btn btn-default" type="button" onclick="login('0')">Login</button><br><br>
               
        </div>
    </div>
    



    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->

  </body>
</html>
