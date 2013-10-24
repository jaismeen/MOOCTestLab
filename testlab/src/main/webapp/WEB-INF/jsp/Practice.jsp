
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../assets/ico/favicon.png">

    <title>Carousel Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet">
            <link href="css/flowchart.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->

    <!-- Custom styles for this template -->
    <link href="css/carousel.css" rel="stylesheet">
    <script src="js/tabs.js"></script>
    <script src="http://raphaeljs.com/raphael.js"></script>
    <script src="js/flowchart-1.1.3.js"></script>

            



        
       	
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
              <a class="navbar-brand" href="#">Online Test Labs</a>
            </div>
            <div class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">Lab</a></li>
                <li><a href="#contact">Practice Sessions</a></li>
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

                <iframe id="cf" class="codeframe" style="background: #F0F0F0; width: 100%; height: 230px"></iframe>
                <script>
                  var practiceID=get_practiceID();
                  var URL="<c:url value=/resources/samplecode/"+ practiceID + ".c/>";
                  var code_frame=document.getElementById('cf');
                  code_frame.src=URL;

                </script>
                <br>
                <br>
                <button id="submit" stype=" align: right" class="btn btn-default" type="button" onclick="submitHW()">Submit</button>
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
