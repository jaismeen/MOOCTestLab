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
       // var nn=document.getElementById("nodename");
        //nodeCount++;
        //nn.value="G" + (nodeCount+1);

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
                
                //nodeList[nodeCount]= nameNode.value;
                //nodeCount=nodeCount +1;
                
                 
                
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
                     //del_snode[del_snode.length]= new Option(nameNode.value + "-" + contentNode.value, nameNode.value);
                     //del_dnode[del_dnode.length]= new Option(nameNode.value + "-" + contentNode.value, nameNode.value);
                    //delnode[delnode.length]= new Option(nameNode.value + "-" + contentNode.value, nameNode.value) 
                    //delNode[delNode.length] = new Option(nameNode.value+ "(yes)" + "-" + contentNode.value, nameNode.value + "(yes)");
                    //delNode[delNode.length] = new Option(nameNode.value+ "(no)" + "-" + contentNode.value, nameNode.value + "(no)");                 //nodeCount=nodeCount +3;

                }
                elementArray[num_elements]=tempString;
                num_elements++;

                    
                delnode[delnode.length]= new Option(nameNode.value + "-" + contentNode.value, nameNode.value);
                     dn[dn.length]=new Option(nameNode.value + "-" + contentNode.value, nameNode.value);
                     sn[sn.length]=new Option(nameNode.value + "-" + contentNode.value, nameNode.value);

                nodeString[num_nodes]= tempString + "\n";
                //alert (nodeString[num_nodes]);  
                //nodeString=nodeString.replace(',','');
                
                nodeList[count]=nameNode.value + "::" + contentNode.value;
                count++;
                nodeCount++; 
                num_nodes++;

                //alert(nodeString);
                //console.log(num_elements + "  " + elementArray[0]);

            }
            
            function addLink()
            {
                var snode=ddl_SourceNode.options[ddl_SourceNode.selectedIndex].value;
                var dnode=ddl_DestinationNode.options[ddl_DestinationNode.selectedIndex].value;
                var tempString= snode + "->" + dnode;
                
                
                linkString[num_links]=tempString + "\n";
                num_links++;
                alert(linkString);

                codeString="";
                for(var counter=0;counter<num_nodes;counter++)    
                    codeString= codeString + nodeString[counter];

                for(var counter=0;counter<num_links;counter++)    
                    codeString= codeString + linkString[counter];
                     
                elementArray[num_elements]=tempString;
                num_elements++;

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
                alert(delValue);
                var nodeName= delValue.substr(0,2);
                var found=0;


                for (var counter=0; counter<num_nodes;counter++)
                {
                    if (nodeString[counter].search(nodeName)!=-1)
                    {
                        //alert (elementArray[counter])
                        found=counter;
                        break;
                    }
                }
                        //alert("found at" + found);

                        //while (nodeString[found]!=null)
                        for (var counter=found; counter<num_nodes-1;counter++)
                        {

                            nodeString[found]=nodeString[found+1];
                        }

                        num_nodes--;

                        alert("nodeString" + nodeString);

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
                    alert ("linkString" + linkString);
                    codeString="";
                for(var counter=0;counter<num_nodes;counter++)    
                    codeString= codeString + nodeString[counter];

                for(var counter=0;counter<num_links;counter++)    
                    codeString= codeString + linkString[counter];

                alert("codeString" + codeString);

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
                                
                $.post (urlHolder.add, { codestr: codeString },
                        function(response) {
                        	
                        	
                        	alert(response);
                        	
                        	
                           if (response!=null)
                           {
                                alert ("Homework submitted succesfully");
                           }
                            else
                            {
                                alert ("Error: Please try submitting again");
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