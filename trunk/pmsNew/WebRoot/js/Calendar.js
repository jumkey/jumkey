//������ʾʱ��ĸ�ʽ
//1. ��-��-�� �磺2002-3-6
//2. ��/��/�� �磺3/6/2002

var showType=1;//Ĭ��Ϊ1;2002-3-6

 //�����·�,�������ʾӢ���·ݣ��޸������ע��
 /*var months = new Array("January?, "February?, "March",
    "April", "May", "June", "July", "August", "September",
    "October", "November", "December");*/
 var months = new Array("һ��", "����", "����",
    "����", "����", "����", "����", "����", "����",
    "ʮ��", "ʮһ��", "ʮ����");
 var daysInMonth = new Array(31, 28, 31, 30, 31, 30, 31, 31,
    30, 31, 30, 31);
  //������  �������ʾ Ӣ�ĵģ��޸������ע��
 /*var days = new Array("Sunday", "Monday", "Tuesday",
    "Wednesday", "Thursday", "Friday", "Saturday");*/
 var days = new Array("��","һ", "��", "��",
    "��", "��", "��");
 var getObject,oldObject;//ȡ�õ�ǰ����
 function getDays(month, year) {
    //�������δ������жϵ�ǰ�Ƿ��������
    if (1 == month)
       return ((0 == year % 4) && (0 != (year % 100))) ||
          (0 == year % 400) ? 29 : 28;
    else
       return daysInMonth[month];
 }

 function getToday() {
    //�õ��������,��,��
    this.now = new Date();
    this.year = this.now.getFullYear();
    this.month = this.now.getMonth();
    this.day = this.now.getDate();
 }

 today = new getToday();

 function newCalendar() { 
    today = new getToday();
    var parseYear = parseInt(document.all.year
       [document.all.year.selectedIndex].text);
    var newCal = new Date(parseYear,
       document.all.month.selectedIndex, 1);
    var day = -1;
    var startDay = newCal.getDay();
    var daily = 0;
    if ((today.year == newCal.getFullYear()) &&(today.month == newCal.getMonth()))
       day = today.day;
    var tableCal = document.all.calendar.tBodies.dayList;
    var intDaysInMonth =getDays(newCal.getMonth(), newCal.getFullYear());
    for (var intWeek = 0; intWeek < tableCal.rows.length;intWeek++)
         for (var intDay = 0;intDay < tableCal.rows[intWeek].cells.length;intDay++)
         {
          var cell = tableCal.rows[intWeek].cells[intDay];
	  if ((intDay == startDay) && (0 == daily))
             daily = 1;
          if(day==daily)
              //���죬���ý����Class
              cell.className = "today";
          else if(intDay==6)
              //����
              cell.className = "sunday";
          else if (intDay==0)
              //����
              cell.className ="satday";
          else
              //ƽ��
              cell.className="normal";        
          if ((daily > 0) && (daily <= intDaysInMonth))
             { 
               cell.innerText = daily;
               daily++;
             }
          else
              cell.innerText = "";
       }
 }

 function getDate() {
    var sDate;
    //��δ��봦������������
    if ("TD" == event.srcElement.tagName)
       if ("" != event.srcElement.innerText)
	 {//��������Ը���ʾ���ڵĸ�ʽ
	    if(showType==1)
	       sDate = document.all.year.value + "-" + document.all.month.value + "-" + event.srcElement.innerText + "";
		else if(showType==2)
           sDate =  document.all.month.value + "/" + event.srcElement.innerText +"/"+ document.all.year.value;
		else
			sDate = document.all.year.value + "-" + document.all.month.value + "-" + event.srcElement.innerText + "";
	  			getObject.value=sDate;
			//	setUpdateFlag(getObject);//�����¼�����������
				HideLayer();

	 	 }
 }

function HideLayer() {
	Layer.style.visibility = "hidden";
}

function LayerShow(){
	Layer.style.visibility = "visible";
}

function ShowLayer(t,l) {

	if(oldObject==null)oldObject=getObject;//��ֵ
		if(Layer.style.visibility != "visible" && oldObject==getObject){//�ж��Ƿ����ͬһ���
				//if(l>480)l=l-131;
				Layer.style.top = t+document.body.scrollTop;
				Layer.style.left = l+document.body.scrollLeft;
				Layer.style.visibility = "visible";
				oldObject=getObject;
								}
	else if(oldObject==getObject){
		HideLayer();
	}
	else{
				//if(l>480)l=l-131;
				Layer.style.top = t+document.body.scrollTop;
				Layer.style.left = l+document.body.scrollLeft;
				Layer.style.visibility = "visible";
				oldObject=getObject;
	}
}
function selectDate(x){
window.event.cancelBubble = true;//ð�ݣ�ʹ����ҳ���¼�ʧЧ
getObject=x;
var xx=event.clientX;//ȡ��x����;
var yy=event.clientY;//ȡ��y����;
newCalendar();
ShowLayer(yy,xx);//��ʾ��div
}
function show(){//ð�ݣ������ʧЧ
window.event.cancelBubble = true;
}
//�����ƶ�
var Obj=''
document.onmouseup=MUp
document.onmousemove=MMove

function MDown(Object){
Obj=Object.id
document.all(Obj).setCapture();
pX=event.x-document.all(Obj).style.pixelLeft;
pY=event.y-document.all(Obj).style.pixelTop;
}

function MMove(){
if(Obj!=''){
	document.all(Obj).style.left=event.x-pX;
	document.all(Obj).style.top=event.y-pY;
	}
}

function MUp(){
if(Obj!=''){
	document.all(Obj).releaseCapture();
	Obj='';
	}
}


//����div��ʾ����;
function getLayer(){

	document.write("<div id=\"Layer\"  onclick=show() style=\"position:absolute; width:175; z-index:2; border:1px solid #0064AF; background-color: #B3D9FF; layer-background-color: #B3D9FF; visibility: hidden; height: 38; left:58; top:137;\"><input type=\"hidden\" name=\"ret\">");
	document.write("<table bgcolor=#63B2ED width=100% style=\"cursor:move\"><tr align=center><td style=color:#ffffff;padding-top:4px; onmousedown=MDown(Layer)>��ס�������Ƶ�����λ��</td></tr></table>");
	document.write("<table id=\"calendar\" cellpadding=\"0\" cellspacing=\"1\" bgcolor=\"#809DC7\" align=\"center\"><thead><tr><td colspan=7 align=CENTER>");

	document.write("<select id=\"year\" onChange=\"newCalendar()\" name=\"select\" class=\"smallSel\">");
	 for (var intLoop = today.year-10; intLoop < (today.year + 5);                          intLoop++)
	 document.write("<OPTION VALUE= " + intLoop + " " +
	 (today.year == intLoop ?  "Selected" : "") + ">" + intLoop);
	document.write("</select>");

	document.write("<select id=\"month\" onChange=\"newCalendar()\" name=\"select\" class=\"smallSel\">");
	 for (var intLoop = 0; intLoop < months.length;  intLoop++)
	 document.write("<OPTION VALUE= " + (intLoop + 1) + " " + (today.month == intLoop ? "Selected" : "") + ">" + months[intLoop]);
	document.write("</select>");

	document.write("</td></tr><tr height=20 class=\"days\">");
	document.write("<TD class=satday align=center width=25>" + days[0] + "</TD>");

	for (var intLoop = 1; intLoop < days.length-1;intLoop++)
	document.write("<TD width=25 align=center bgcolor=#AABFDE>" + days[intLoop] + "</TD>");
	document.write("<TD class=sunday width=25 align=center>" + days[intLoop] + "</TD>");
	document.write("      </tr>      </thead> <tbody border=1 cellspacing=\"0\" cellpadding=\"0\" id=\"dayList\" align=CENTER ONCLICK='getDate()'>");

	for (var intWeeks = 0; intWeeks < 6; intWeeks++) {
	document.write("<TR style='cursor:hand'>");
	for (var intDays = 0; intDays < days.length;intDays++)
	document.write("<TD></TD>");
	document.write("</TR>");
	 }
	document.write("</tbody></table></div>");


	document.body.onclick=HideLayer;//�������ҳ���¼����رմ���
	document.oncontextmenu=HideLayer;//�������ҳ���Ҽ����رմ���
}
//��ʾcss
document.write("<style>TABLE	{font-family:����,MS SONG,SimSun,tahoma,sans-serif; font-size:9pt;border:0px}.drpdwn	{font-family:����,MS SONG,SimSun,tahoma,sans-serif;font-size:9pt;color:#000066;background-color:#FFffff} SELECT.smallSel{    BACKGROUND-COLOR: #ffffff; width:85px;    COLOR: #000080;    FONT-SIZE: 9pt} .normal{BACKGROUND: #ffffff} .today {font-weight:bold;BACKGROUND: #BEDDFD} .satday{color:green;background-color:#C1D4F0} .sunday{color:red;background-color:#C1D4F0} .days {font-weight:bold} .Arraw {color:#0000BB; cursor:hand; font-family:Webdings; font-size:9pt}</style>");

getLayer();//��ʾdiv


