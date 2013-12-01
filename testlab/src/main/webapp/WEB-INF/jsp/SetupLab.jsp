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
    <div id="main_body">
        <div id="side_panel">
            <div class="tabs">
                    <ul>
                        <li id="tabHeader_1">Create Element</li>
                        <li id="tabHeader_2">Delete Element</li>
                    </ul>
            </div>
            <div class="tabscontent">
                <div class="tabpage" id="tabpage_1">
                    <br>
                    &nbsp
                    &nbsp
                    
                    <input type="radio" name="element" onclick="createUI()" value="node">  Node
                    &nbsp
                    &nbsp
                    <input type="radio" name="element" onclick="createUI()" value="link">  Link
                    <br>
                    <br>
                     <div id="fg_elements">
                     </div>
                       <div id="nodeelements">
                   <!-- <<label for="createnode">Create Node</label><br>-->
                    <label class="col-lg-4 control-label">Name</label>
                    <div class="col-lg-6">
                    <input type="text" class="form-control" readonly="readonly" id = "nodename" name="nodename">
                    <br>
                </div>
                
                <label class="col-lg-4 control-label">Content</label>
                    <div class="col-lg-6">
                    <input type="text" class="form-control" id = "content" name="nodecontent"><br>
                </div>
                <br>
                         
                            <label class="col-lg-4 control-label">Type</label>
                            <div class="col-lg-6">
                            <select id="nodetype" class="form-control" onchange="setNodeName()">
                                <option value="gnode">General Node</option>
                                <option value="cnode" >Condition Node</option>
                            </select>
                        </div>                            <br>
                            <br>
                            <button id="createNode" class="btn btn-default" type="button" onclick="addNode()">Create Node</button><br><br>
                            </div>
                            
                            <div id="linkelements">

                            <label class="col-lg-5 control-label" for="lb_sourcenode">Source Node</label>
                            
                             <div class="col-lg-6">
                                <select class="form-control" id="sourceNode">
                            </select>
                        </div>
                        <br>
                        <br>
                        <br>
                            <label class="col-lg-5 control-label" for="lb_destinationnode">Destination Node</label>
                             <div class="col-lg-6">
                                <select class="form-control" id="destinationNode">
                            </select><br>
                            </div>
                            <button id="createLink" class="btn btn-default" type="button" onclick="addLink()">Create Link</button><br>
                        </div>

                </div>
                <div class="tabpage" id="tabpage_2">
                         <br>
                    &nbsp
                    &nbsp
                    
                   <input type="radio" name="radioelement" onclick="deleteUI()" value="node" checked="checked">  Node
                    &nbsp
                    &nbsp
                    <input type="radio" name="radioelement" onclick="deleteUI()" value="link">  Link
                    <br>
                    <br>
                    
                       <div id="del_nodeelements">
                     <label class="col-lg-5 control-label" for="lb_node">Node</label>
                            
                             <div class="col-lg-6">
                                <select class="form-control" id="delNode">
                            </select>
                        </div>                    
                            <button id="delNode" class="btn btn-default" type="button" onclick="delNode()">Delete Node</button><br><br>
                            </div>
                            

                            <div id="del_linkelements">

                                <label class="col-lg-5 control-label" for="dellb_sourcenode">Source Node</label>
                        
                                <div class="col-lg-6">
                                    <select class="form-control" id="dds">
                                    </select>
                                </div>
                                <br>
                                <br>
                                <br>
                                <label class="col-lg-5 control-label" for="dellb_destinationnode">Destination Node</label>
                                    <div class="col-lg-6">
                                        <select class="form-control" id="ddn">
                                        </select><br>
                                    </div>
                                    <button id="delLink" class="btn btn-default" type="button" onclick="delLink()">Delete Link</button><br>
                            </div>

                </div>
            </div>
            <br>

            <div class="code_area">
                <iframe class="codeframe" style="background: #F0F0F0; width: 100%; height: 230px" src='<c:url value="/resources/samplecode/P1.c"/>' ></iframe>
                <br>
                <br>
                <button id="submit" style=" align: right" class="btn btn-default" type="button" onclick="submitSolution('0')">Submit</button>
            </div>
        
        </div>

        <div id="canvas">
             <h1>Drawing Area</h1>
        </div>
        
    </div>
   
   
  
	

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->

  </body>
</html>
