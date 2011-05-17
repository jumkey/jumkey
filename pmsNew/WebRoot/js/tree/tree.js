
var menuNO="assets_management";
function showmenu(){
	locatefold(title);
	outlookbar.show();
}
function showitem(id,name,other,titleID,itemID)
{

	var itemInfo;
	var nm;	
	itemInfo="<tr align='left' ><td class='tree1_false' onclick='javascript:isShowSmallItem(sItem"+titleID+""+itemID+")'>";
	if (id=="non-link")
	{	
		itemInfo+="&nbsp;&nbsp;<img src='../images/tree2_1.gif' align='absbottom'>"+name;
	}
	else 
	{					
		itemInfo+="&nbsp;&nbsp;<img src='../images/tree2_1.gif' align='absbottom'><a target='rightFrame' onclick=onSelected(this,'"+name+"') href='"+id+"' "+other+">"+name+"</a>";
	}
	itemInfo+="</td></tr>";
	itemInfo+="<tr><td id='sItem"+titleID+""+itemID+"' style='display:none;line-height:30px;'>";

	if (outlookbar.itemlist[titleID][itemID].smallItemList.length>0)
	{
		for (nm=0;nm<outlookbar.itemlist[titleID][itemID].smallItemList.length;nm++)
		{
			itemInfo+="&nbsp;&nbsp;&nbsp;<img src='../images/tree3_1.jpg' align='absbottom'><a target='rightFrame' onclick=onSelected(this,'"+name+"') href='"+outlookbar.itemlist[titleID][itemID].smallItemList[0].key+"' class='tree2'>"+outlookbar.itemlist[titleID][itemID].smallItemList[nm].title+"</a></br>"
		}
	}
	itemInfo+="</td></tr>";
	return itemInfo;
}

function isShowSmallItem(obj)
{
	if (obj.style.display=="none"){
		obj.style.display="";
	}else{
		obj.style.display="none";
	}
}

function switchoutlookBar(number)
{
	var i = outlookbar.opentitle;
	outlookbar.opentitle=number;
	var id1,id2,id1b,id2b
	if (number!=i && outlooksmoothstat==0){        
	if (number!=-1)                               
		{
			if (i==-1)
				{
				id2="blankdiv";
				id2b="blankdiv";
				}
			else{
				id2="outlookdiv"+i;
				id2b="outlookdivin"+i;
				document.all("outlooktitle"+i).style.border="1px none navy";
				document.all("outlooktitle"+i).style.color="#000000";
				document.all("outlooktitle"+i).style.textalign="left";
				}
			id1="outlookdiv"+number
			id1b="outlookdivin"+number
			document.all("outlooktitle"+number).style.border="1px none white";
			document.all("outlooktitle"+number).style.color="#000000";
			document.all("outlooktitle"+number).style.textalign="left";
			smoothout(id1,id2,id1b,id2b,0);
		}
	else
		{
			document.all("blankdiv").style.display="";
			document.all("blankdiv").sryle.height="100%";
			document.all("outlookdiv"+i).style.display="none";
			document.all("outlookdiv"+i).style.height="0%";
			document.all("outlooktitle"+i).style.border="1px none navy";
			document.all("outlooktitle"+i).style.color="#000000";
			document.all("outlooktitle"+i).style.textalign="left";
		}
	}
			
}

function smoothout(id1,id2,id1b,id2b,stat)
{
	if(stat==0){
		tempinnertext1=document.all(id1b).innerHTML;
		tempinnertext2=document.all(id2b).innerHTML;
		document.all(id1b).innerHTML="";
		document.all(id2b).innerHTML="";
		outlooksmoothstat=1;
		document.all(id1b).style.overflow="hidden";
		document.all(id2b).style.overflow="hidden";
		document.all(id1).style.height="0%";
		document.all(id1).style.display="";
		setTimeout("smoothout('"+id1+"','"+id2+"','"+id1b+"','"+id2b+"',"+outlookbar.inc+")",outlookbar.timedalay);
	}
	else
	{
		stat+=outlookbar.inc;
		if (stat>100)
			stat=100;
		document.all(id1).style.height=stat+"%";
		document.all(id2).style.height=(100-stat)+"%";
		if (stat<100) 
			setTimeout("smoothout('"+id1+"','"+id2+"','"+id1b+"','"+id2b+"',"+stat+")",outlookbar.timedalay);
		else
			{
			document.all(id1b).innerHTML=tempinnertext1;
			document.all(id2b).innerHTML=tempinnertext2;
			outlooksmoothstat=0;
			document.all(id1b).style.overflow="auto";
			document.all(id2).style.display="none";
			}
	}
}

function getOutLine()
{      
	outline="<table "+outlookbar.otherclass+">";
	for (i=0;i<(outlookbar.titlelist.length);i++)
		{
			outline+="<tr><td name=outlooktitle"+i+" id=outlooktitle"+i+" ";		
			if (i!=outlookbar.opentitle)               
				outline+=" nowrap background='../images/tree_bg.gif' align=left class='tree1_false'";
			else                                    
				outline+=" nowrap background='../images/tree_bg.gif' align=left class='tree1_true'";
			outline+=outlookbar.titlelist[i].otherclass
			outline+=" onclick='switchoutlookBar("+i+")'>";
			
			if (outlookbar.titlelist[i].title.indexOf("images")>=0)
			{
				outline+="<INPUT TYPE=image src="+outlookbar.titlelist[i].title+" border=0>";
			}
			else 
			{
				outline+="<span>&nbsp;<img src=../images/tree1_1.gif align=absbottom><b>"+outlookbar.titlelist[i].title+"</b></span>";
			}
			outline +="</td></tr>";
			outline+="<tr><td name=outlookdiv"+i+" valign=top align=left id=outlookdiv"+i+" style='width:100%;background-color:#Ffffff;"
			if (i!=outlookbar.opentitle) 
				outline+=";display:none;height:0%;";
			else
				outline+=";display:;height:100%;";
			outline+="'><div name=outlookdivin"+i+" id=outlookdivin"+i+" style='overflow:auto;width:100%;height:100%;'>";
			outline+="<table border='0' cellspacing='0' cellpadding='0' style='overflow:auto;width:100%' valign='top' align='center'>"
			for (j=0;j<outlookbar.itemlist[i].length;j++)
			{
				outline+=showitem(outlookbar.itemlist[i][j].key,outlookbar.itemlist[i][j].title,outlookbar.itemlist[i][j].other,i,j);
			}
			outline+="</table>"
			outline+="</div></td></tr>"
		}
	
	outline+="</table>"
	return outline

}

function show()
{
	var outline;
	outline="<div id=outLookBarDiv name=outLookBarDiv style='width=100%;height:100%'>"
	outline+=outlookbar.getOutLine();
	outline+="</div>"
	document.write(outline);
}

function theitem(intitle,instate,inkey,other)
{
	this.smallItemList = new Array();
	this.state=instate;
	this.otherclass=" nowrap ";
	this.key=inkey;
	this.title=intitle;
	this.other=other;

}
function theSmallItem(intitle,instate,inkey,other)
{
	this.state=instate;
	this.otherclass=" nowrap ";
	this.key=inkey;
	this.title=intitle;
	this.other=other;
}

function addtitle(intitle)
{
	outlookbar.itemlist[outlookbar.titlelist.length]=new Array();
	outlookbar.titlelist[outlookbar.titlelist.length]=new theitem(intitle,1,0);
	return(outlookbar.titlelist.length-1);
}

function additem(intitle,parentid,inkey,other)
{
	if (parentid>=0 && parentid<=outlookbar.titlelist.length)
	{
		outlookbar.itemlist[parentid][outlookbar.itemlist[parentid].length]=new theitem(intitle,2,inkey,other);
		outlookbar.itemlist[parentid][outlookbar.itemlist[parentid].length-1].smallItemList = new Array();

		outlookbar.itemlist[parentid][outlookbar.itemlist[parentid].length-1].otherclass=" nowrap align=left style='height:5' ";
		return(outlookbar.itemlist[parentid].length-1);
	}
	else
	{
		additem=-1;
	}
}

function outlook()
{
	this.titlelist=new Array();
	this.itemlist=new Array();



	this.divstyle="style='height:100%;width:100%;overflow:auto' align=center";
	this.otherclass="border=0 cellspacing='0' cellpadding='0' style='height:100%;width:100%'valign=middle align=center ";
	this.addtitle=addtitle;
	this.additem=additem;

	this.starttitle=-1;
	this.show=show;
	this.getOutLine=getOutLine;
	this.opentitle=this.starttitle;
	this.reflesh=outreflesh;
	this.timedelay=50;
	this.inc=10;
	
}

function outreflesh()
{
	document.all("outLookBarDiv").innerHTML=outlookbar.getOutLine();
}

function locatefold(foldname)
{
	for (var i=0;i<outlookbar.titlelist.length;i++)
		if(foldname==outlookbar.titlelist[i].title)
			{
				 outlookbar.starttitle=i;
				 outlookbar.opentitle=i;
			}
	
}

var outlookbar=new outlook();
var tempinnertext1,tempinnertext2,outlooksmoothstat
outlooksmoothstat = 0;