//Start:������ƶ������б��ĳһ���ϵ�ʱ�����б�ɫ
var theTable;
function changetr(){
	theTable=document.getElementById("datalist");
	allTd=theTable.getElementsByTagName("TD");
	for(i=0;i<allTd.length;i++){
		allTd[i].attachEvent("onmouseover",over);
		allTd[i].attachEvent("onmouseout",out);
	}
}
function over(){
	theTd=window.event.srcElement;
	if (theTd.tagName!='TD'){
		if (theTd.parentElement!=null&&theTd.parentElement.tagName=='TD')theTd=theTd.parentElement;
		else return;
	}
	xIndex=theTd.cellIndex;
	yIndex=theTd.parentNode.rowIndex;
  	theTable.rows[yIndex].runtimeStyle.backgroundColor="#FFffee";
	theTable.rows[yIndex].runtimeStyle.cursor="hand";
	theTable.rows[yIndex].title="������������Դ���Ϣ�༭ҳ��";
}
function out(){
	theTd=window.event.srcElement;
	if (theTd.tagName!='TD'){
		if (theTd.parentElement!=null&&theTd.parentElement.tagName=='TD')theTd=theTd.parentElement;
		else return;
	}
	xIndex=theTd.cellIndex;
	yIndex=theTd.parentNode.rowIndex;
	theTable.rows[yIndex].runtimeStyle.backgroundColor="";
}
if (document.all){
  window.attachEvent('onload',changetr);
}
//End:������ƶ������б��ĳһ���ϵ�ʱ�����б�ɫ