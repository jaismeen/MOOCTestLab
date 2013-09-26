var appndBtn;
            var nodeString="", linkString="";
            var piece, chart;
            var nodeList=new Array();
            var nodeCount=0;
            var ddl_SourceNode;
            var ddl_DestinationNode;
            var codeString="";
        
            var urlHolder = new Object();
            
window.onload=function() {


    var btn = document.getElementById("run"),
                cd = document.getElementById("code");
                appndBtn=document.getElementById("append");
                piece=document.getElementById("samplecode");
                ddl_SourceNode= document.getElementById("sourceNode");
                ddl_DestinationNode=document.getElementById("destinationNode");
                document.getElementById("nodeelements").style.display= 'block';
                document.getElementById("linkelements").style.display= 'none';

                
                ddl_SourceNode[ddl_SourceNode.length] = new Option("start", "start");
                ddl_SourceNode[ddl_SourceNode.length] = new Option("end", "end");
                ddl_DestinationNode[ddl_DestinationNode.length] = new Option("start", "start");
                ddl_DestinationNode[ddl_DestinationNode.length] = new Option("end", "end")
                nodeCount=nodeCount+2;
                
                nodeString= "start=>start: Start \nend=>end: End \n"; 
    
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


function addNode()
            {

	alert("in addNode()");
	
                var element;
    
        element=document.createElement("label");
        element.setAttribute("type", "label");
    element.setAttribute("value", "createnode");
    element.setAttribute("name", "createnode");
   
                var nameNode=document.getElementById("nodename");
                var contentNode=document.getElementById("content");
                var ddlNode = document.getElementById("nodetype");
                var ntype = ddlNode.options[ddlNode.selectedIndex].value;
                //nodeList[nodeCount]= nameNode.value;
                //nodeCount=nodeCount +1;
                
                 alert("addNode2");
                
                if (ntype== "gnode")
                {
                    var tempString= nameNode.value + "=>operation: " + contentNode.value;
                     ddl_SourceNode[ddl_SourceNode.length] = new Option(nameNode.value, nameNode.value);
                    ddl_DestinationNode[ddl_DestinationNode.length] = new Option(nameNode.value, nameNode.value);
                    nodeCount++;
                    
                    alert("addNode in gnode");
                }
                else
                {
                    var tempString= nameNode.value + "=>condition: " + contentNode.value;
                    ddl_SourceNode[ddl_SourceNode.length] = new Option(nameNode.value, nameNode.value);
                    ddl_SourceNode[ddl_SourceNode.length] = new Option(nameNode.value+ "(yes)", nameNode.value + "(yes)");
                    ddl_SourceNode[ddl_SourceNode.length] = new Option(nameNode.value+ "(no)", nameNode.value + "(no)");
                    
                    ddl_DestinationNode[ddl_DestinationNode.length] = new Option(nameNode.value, nameNode.value);
                    ddl_DestinationNode[ddl_DestinationNode.length] = new Option(nameNode.value+ "(yes)", nameNode.value + "(yes)");
                    ddl_DestinationNode[ddl_DestinationNode.length] = new Option(nameNode.value+ "(no)", nameNode.value + "(no)");
                                        nodeCount=nodeCount +3;

                                        
                    alert("addNode not in gnode");
                                        
                }
                
                nodeString= nodeString + tempString + "\n";   

                alert(nodeString);
                
            }
            
            function addLink()
            {
                var snode=ddl_SourceNode.options[ddl_SourceNode.selectedIndex].value;
                var dnode=ddl_DestinationNode.options[ddl_DestinationNode.selectedIndex].value;
                var tempString= snode + "->" + dnode;
                
                
                linkString= linkString + tempString + "\n";
                alert(linkString);
                codeString= nodeString + linkString;
                
                alert(codeString);
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

            function submitHW()
            {
            	
            	alert("in submitHW()");
            	alert(codeString);
            	/*
                $.post (urlHolder.add, {
                    codeString: codeString
                },
                function(response) {
                   if (response!=null)
                   {
                        alert ("Homework submitted succesfully");
                   }
                    else
                    {
                        alert ("Error: Please try submitting again");
                    }
                        
                }*/
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