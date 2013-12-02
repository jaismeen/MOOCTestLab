var appndBtn;
            var nodeString= new Array ();
            var linkString= new Array ();
            var piece, chart;
            var nodeList=new Array();
            var nodeCount=0;
            var ddl_SourceNode;
            var ddl_DestinationNode;
            var codeString="";
            var count=0;
            var elementArray = new Array();
            var num_elements=0, num_nodes=0, num_links=0;
            var ddlNode, delnode;
            var dn,sn;

            var urlHolder = new Object();
            
window.onload=function() {


    var btn = document.getElementById("run"),
                cd = document.getElementById("code");
                appndBtn=document.getElementById("append");
                piece=document.getElementById("samplecode");
                ddl_SourceNode= document.getElementById("sourceNode");
                ddl_DestinationNode=document.getElementById("destinationNode");
                ddlNode = document.getElementById("nodetype");
                delnode= document.getElementById("delNode");
                 dn=document.getElementById("ddn");
                sn= document.getElementById("dds");
                document.getElementById("nodeelements").style.display= 'block';
                document.getElementById("linkelements").style.display= 'none';
                document.getElementById("del_nodeelements").style.display= 'block';
                document.getElementById("del_linkelements").style.display= 'none';    
                                
                ddl_SourceNode[ddl_SourceNode.length] = new Option("start", "start");
               // ddl_SourceNode[ddl_SourceNode.length] = new Option("end", "end");
                //ddl_DestinationNode[ddl_DestinationNode.length] = new Option("start", "start");
                ddl_DestinationNode[ddl_DestinationNode.length] = new Option("end", "end")
                
                nodeString[num_nodes]= "start=>start: Start \n";
                num_nodes++;
                nodeString[num_nodes]= "end=>end: End \n"; 
                num_nodes++;
    
    // get tab container
    var container = document.getElementById("side_panel");

    // set current tab
    var navitem = container.querySelector(".tabs ul li");
    //store which tab we are on
    var ident = navitem.id.split("_")[1];
    navitem.parentNode.setAttribute("data-current",ident);
    //set current tab with class of activetabheader
    navitem.setAttribute("class","tabActiveHeader");
    
    //hide two tab contents we don't need
    var pages = container.querySelectorAll(".tabpage");
    for (var i = 1; i < pages.length; i++) {
        pages[i].style.display="none";
    }
    
    //this adds click event to tabs
    var tabs = container.querySelectorAll(".tabs ul li");
    for (var i = 0; i < tabs.length; i++) {
        tabs[i].onclick=displayPage;
    }
}

function set_cookie(key,value1)
{


    //alert('inside set cookie');
    window.sessionStorage.setItem("username", value1);

}

//Function to get the username from the cookies set
function get_cookie(key)
{

    var stringValue = window.sessionStorage.getItem("username");
 //  alert(stringValue);
    return stringValue;

}

function set_practiceID(practice_id)
{
    window.sessionStorage.setItem("LatestPractice", practice_id);
}

function get_practiceID()
{
    var practice_id=window.sessionStorage.getItem("LatestPractice");
    return practice_id;
}
function createUI()
{

    var selElement;
    var selection=document.getElementsByName("element");
    if (selection[0].checked==true)
    {
        selElement="Node"; 
        var nn=document.getElementById("nodename");
        //nodeCount++;
        nn.value="G" + (nodeCount+1);

         document.getElementById("nodeelements").style.display='block'; 
         document.getElementById("linkelements").style.display= 'none';

    }
    else
    {
        selElement="Link";
        document.getElementById("nodeelements").style.display='none';
        document.getElementById("linkelements").style.display= 'block';
    } 
  
   
}

function deleteUI()
{

    var selElement;
    var selection=document.getElementsByName("radioelement");
    if (selection[0].checked==true)
    {
        selElement="Node"; 


         document.getElementById("del_nodeelements").style.display='block'; 
         document.getElementById("del_linkelements").style.display= 'none';

    }
    else
    {
        selElement="Link";
        document.getElementById("del_nodeelements").style.display='none';
        document.getElementById("del_linkelements").style.display= 'block';
    } 
  
   
}
function setNodeName()
{
    var nn=document.getElementById("nodename");
    var type=document.getElementById("nodetype");
    if (nodetype.value=="cnode")
    {
                    //nodeCount++;
                    nn.value="C" + (nodeCount+1);
                }

}


function addNode()
            {

                
                var nameNode=document.getElementById("nodename");
                var contentNode=document.getElementById("content");
                var ddlNode = document.getElementById("nodetype");
                var delnode= document.getElementById("delNode");
               
                var ntype = ddlNode.options[ddlNode.selectedIndex].value;
        
                if (ntype== "gnode")
                {
                    var tempString= nameNode.value + "=>operation: " + contentNode.value;
                     ddl_SourceNode[ddl_SourceNode.length] = new Option(nameNode.value + "-" + contentNode.value, nameNode.value);
                     ddl_DestinationNode[ddl_DestinationNode.length] = new Option(nameNode.value + "-" + contentNode.value, nameNode.value);


                    //nodeCount++;
                }
                else
                {
                    
   
                    var tempString= nameNode.value + "=>condition: " + contentNode.value;
                    ddl_SourceNode[ddl_SourceNode.length] = new Option(nameNode.value + "-" + contentNode.value, nameNode.value);
                    ddl_SourceNode[ddl_SourceNode.length] = new Option(nameNode.value+ "(yes)" + "-" + contentNode.value, nameNode.value + "(yes)");
                    ddl_SourceNode[ddl_SourceNode.length] = new Option(nameNode.value+ "(no)", nameNode.value + "(no)");
                    
                    ddl_DestinationNode[ddl_DestinationNode.length] = new Option(nameNode.value + "-" + contentNode.value, nameNode.value);
                    ddl_DestinationNode[ddl_DestinationNode.length] = new Option(nameNode.value+ "(yes)" + "-" + contentNode.value, nameNode.value + "(yes)");
                    ddl_DestinationNode[ddl_DestinationNode.length] = new Option(nameNode.value+ "(no)" + "-" + contentNode.value, nameNode.value + "(no)");
                      
                      delnode[delnode.length]= new Option(nameNode.value + "-" + contentNode.value, nameNode.value);
              

                }
                elementArray[num_elements]=tempString;
                num_elements++;

                    
                delnode[delnode.length]= new Option(nameNode.value + "-" + contentNode.value, nameNode.value);
                     dn[dn.length]=new Option(nameNode.value + "-" + contentNode.value, nameNode.value);
                     sn[sn.length]=new Option(nameNode.value + "-" + contentNode.value, nameNode.value);

                nodeString[num_nodes]= tempString + "\n";
              
                
                nodeList[count]=nameNode.value + "::" + contentNode.value;
                count++;
                nodeCount++; 
                num_nodes++;
                alert("Node added");

            }
            
            function addLink()
            {
                var snode=ddl_SourceNode.options[ddl_SourceNode.selectedIndex].value;
                var dnode=ddl_DestinationNode.options[ddl_DestinationNode.selectedIndex].value;
                var tempString= snode + "->" + dnode;
                
                
                linkString[num_links]=tempString + "\n";
                num_links++;
                //alert(linkString);

                codeString="";
                for(var counter=0;counter<num_nodes;counter++)    
                    codeString= codeString + nodeString[counter];

                for(var counter=0;counter<num_links;counter++)    
                    codeString= codeString + linkString[counter];
                     
                elementArray[num_elements]=tempString;
                num_elements++;

                alert("Link added");
                if (chart) {
                    chart.clean();
                }


                
                chart = flowchart.parse(codeString);
                chart.drawSVG('canvas', {
                              'line-width': 3,
                              'line-length': 50,
                              'text-margin': 10,
                              'font-size': 14,
                              'font-color': 'black',
                              'line-color': 'black',
                              'element-color': 'black',
                              'fill': 'white',
                              'yes-text': 'yes',
                              'no-text': 'no'
                              });

            }

            function delNode ()
            {
                
                var delIndex=delnode.selectedIndex;
                var delValue=delnode.options[delnode.selectedIndex].value;
                alert (delIndex);
                delnode.remove(delnode.selectedIndex);
                ddl_SourceNode.remove(delIndex+1);
                ddl_DestinationNode.remove(delIndex+1);
                dn.remove(delIndex);
                sn.remove(delIndex);
                alert("Node " + delValue + "deleted");
                var nodeName= delValue.substr(0,2);
                var found=0;


                for (var counter=0; counter<num_nodes;counter++)
                {
                    if (nodeString[counter].search(nodeName)!=-1)
                    {
                        found=counter;
                        break;
                    }
                }
                        for (var counter=found; counter<num_nodes-1;counter++)
                        {

                            nodeString[found]=nodeString[found+1];
                        }

                        num_nodes--;

                        //alert("nodeString" + nodeString);

                for (var counter=0; counter<num_links;counter++)
                {
                    if (linkString[counter].search(nodeName)!=-1)
                    {
                        //alert (elementArray[counter])
                        found=counter;
                        //alert("found at" + found);

                        while (found<num_links)
                        {

                            linkString[found]=linkString[found+1];
                            found++;
                            //alert(elementArray[found]);                
                        }
                        
                           num_links--; 
                           counter--;
                    }
                        
                        
                }
                    //alert ("linkString" + linkString);
                    codeString="";
                for(var counter=0;counter<num_nodes;counter++)    
                    codeString= codeString + nodeString[counter];

                for(var counter=0;counter<num_links;counter++)    
                    codeString= codeString + linkString[counter];

                //alert("codeString" + codeString);

                 if (chart) {
                    chart.clean();
                }


                
                chart = flowchart.parse(codeString);
                chart.drawSVG('canvas', {
                              'line-width': 3,
                              'line-length': 50,
                              'text-margin': 10,
                              'font-size': 14,
                              'font-color': 'black',
                              'line-color': 'black',
                              'element-color': 'black',
                              'fill': 'white',
                              'yes-text': 'yes',
                              'no-text': 'no'
                              });

            }


//Login function
function login(var_login)
{
    var username=document.getElementById("username");
    var password=document.getElementById("password");
   // alert(username + password + var_login);
        $.post (urlHolder.login, {
                    username: $('#username').val(),
                    password: $('#password').val(),
                    type: var_login 
                },
                 function(response) {
                   if (response!="")
                   {
                        alert (response);
                        location.reload();
                   }
                    
                    else
                    {
                        set_cookie("username",username.value);
                        if(var_login==1)
                        window.location.href="HomeStudent";
                        else
                        window.location.href="HomeProfessor";
                        
                    }                       
                }
                );
}

function gradePractice()
{
    var practice_id=get_practiceID();
    var cyclomaticNumber=document.getElementById("ccNumber");
	 cyclomaticNumber=cyclomaticNumber.value;

  $.post (urlHolder.gradePractice, {
        assignmentName: practice_id,
        codestr: codeString,
            cyclomaticNumber: cyclomaticNumber
        },
            function(response) {
                    alert("Score is::" + response);        
                //The response is the score of the practice.
            });
}

function grading()
{//It will grade all the assignments

   $.post (urlHolder.grading, {},
            function(response) {
                            
                if (response == "") {
                    alert("Grading Done!");
                } else {
                    alert(response);
                }

            });
}

function displayAll()
{//right now, this function shows all the grades for all the assignments.

    $.post (urlHolder.displayAll, {},
            function(response) {       
                var student_scores=new Array();
                student_scores=response.split(";");
                
                

                                            // get handle on div
                            var container = document.getElementById('score_area');
                            // create table element
                            var table = document.createElement('table');
                            var tbody = document.createElement('tbody');
                          
                            // loop array
                            //Giving headings to the table
                            
                            var row = document.createElement('tr');
                            
                            var cell = document.createElement('td');
                            cell.textContent = " First Name ";
                            row.appendChild(cell);
                            
                            var cell = document.createElement('td');
                            cell.textContent = " Last Name ";
                            row.appendChild(cell);
                            
                            var cell = document.createElement('td');
                            cell.textContent = " Scores ";
                            row.appendChild(cell);
                            
                            tbody.appendChild(row);
                            for (i = 1; i < student_scores.length; i++) {
                                
                                 row = document.createElement('tr');
                                for (var b = i; b < (i+3); b++) {
                                    // create td element
                                     cell = document.createElement('td');
                                    // set text
                                    cell.textContent = student_scores[b];
                                    // append td to tr
                                    row.appendChild(cell);
                                }
                               
                                //append tr to tbody
                                tbody.appendChild(row);
                                i=b;
                            }
                            // append tbody to table
                            table.appendChild(tbody);
                            // append table to container
                            container.appendChild(table);
                            table.setAttribute("border", "2");

                    //Assignment Number;firstname;lastname;score;
           });
}


function submitSolution(var_login)
{
	
	var username=get_cookie("username");
	
	 var practice_id='P1';
	 var cyclomaticNumber=document.getElementById("ccNumber");
	 cyclomaticNumber=cyclomaticNumber.value;
	 
   $.post (urlHolder.submitSolution, {
    	username: username,
    	type: var_login,
    	assignmentName: practice_id,
        codeStrings: codeString,
        cyclomaticNumber: cyclomaticNumber
    },
            function(response) {
            	          	
    			if (response == "") {
    				alert("Solution Submitted Successfully");
    			} else {
    				alert(response);
    			}

            });
}
    

// on click of one of tabs
function displayPage() {
    var current = this.parentNode.getAttribute("data-current");
    //remove class of activetabheader and hide old contents
    document.getElementById("tabHeader_" + current).removeAttribute("class");
    document.getElementById("tabpage_" + current).style.display="none";
    
    var ident = this.id.split("_")[1];
    //add class of activetabheader to new active tab and show contents
    this.setAttribute("class","tabActiveHeader");
    document.getElementById("tabpage_" + ident).style.display="block";
    this.parentNode.setAttribute("data-current",ident);
}

function loadTestData()
{
                    
	alert("load test data");
	var type='0';
    $.post (urlHolder.loadTestData, {
    	type: type
    	},
            function(response) {
            	          	
            	alert(response);
                    
            });
}

function getTestData()
{
                    
	alert("get test data");
	
    $.post (urlHolder.getTestData, {
    	type: $('#type option:selected').val()
    	},
            function(response) {
            	          	
            	alert(response);
                    
            });
}