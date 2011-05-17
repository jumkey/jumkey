//由login页面登录成功后打开主界面窗口
function mainwin(){
var targeturl="mainframe.htm";
newwin=window.open("","","toolbar=no,location=no,status=yes,menubar=no,scrollbars=no,resizable=yes");
if (document.all){
newwin.moveTo(0,0);
newwin.resizeTo(screen.width,screen.Height);
}
newwin.location=targeturl;
window.opener=null;
window.close();
}

//选择人员
function selectman(){
window.showModalDialog('../../public/select.person.htm','','dialogHeight:350px;dialogWidth:585px;scroll:no;help:no; status:no;');
}

//选择单位/部门
function selectunit(){
window.showModalDialog('../../public/select.department.htm','','dialogHeight:350px;dialogWidth:585px;scroll:no;help:no; status:no;');
}

//选择业务类别（两级联动）
function select2sort(){
window.showModalDialog('../../public/select.operation.2sort.htm','','dialogHeight:270px;dialogWidth:450px;scroll:no;help:no; status:no;');
}

//点“新增供应商”按钮后新增一行TR
function append() {
	var oTBody = oTable.childNodes[0];
	var oNewLine = oTBody.childNodes[1].cloneNode(true);
	oTBody.appendChild(oNewLine);
}

//选择仓库
function selstorage(){
window.showModalDialog('../../public/select.storage.htm','','dialogHeight:350px;dialogWidth:585px;scroll:no;help:no; status:no;');
}

//选择供应商
function selsupplier(){
window.showModalDialog('../../public/select.supplier.htm','','dialogHeight:350px;dialogWidth:585px;scroll:no;help:no; status:no;');
}

//选择物资
function selmaterial(){
window.showModalDialog('../../public/select.material.htm','','dialogHeight:450px;dialogWidth:585px;scroll:no;help:no; status:no;');
}

//选择项目
function selproject(){
window.showModalDialog('../../public/select.proname.htm','','dialogHeight:350px;dialogWidth:585px;scroll:no;help:no; status:no;');
}

//查看项目（申请）详细信息
function preproinfo(){
window.showModalDialog('../../project/based.proinfo.preview.htm','','dialogHeight:500px;dialogWidth:780px;scroll:yes;help:no; status:no;');
}

//文档管理
function fileupload(){
window.showModalDialog('../../public/file.upload.htm','','dialogHeight:400px;dialogWidth:585px;scroll:no;help:no; status:no;');
}

//选择到货通知单号
function selectaog(){
window.showModalDialog('../../public/select.aognum.htm','','dialogHeight:350px;dialogWidth:585px;scroll:no;help:no; status:no;');
}

//现有资源状态及需求预测
function applyother1(){
window.showModalDialog('../../public/apply.other1.htm','','dialogHeight:250px;dialogWidth:585px;scroll:no;help:no; status:no;');
}

//本次工程主要建设内容及规模
function applyother2(){
window.showModalDialog('../../public/apply.other2.htm','','dialogHeight:310px;dialogWidth:585px;scroll:no;help:no; status:no;');
}

//投资明细及总投资
function applyother3(){
window.showModalDialog('../../public/apply.other3.htm','','dialogHeight:280px;dialogWidth:585px;scroll:no;help:no; status:no;');
}

//删除信息提示
function delinfo() {
	if(confirm('删除该信息后将无法恢复，您确认要删除吗？'));
	}

// 条件满足时显示需要显示的部份
function showtr(id)
{
	if(document.getElementById(id).style.display == "none")
	   document.getElementById(id).style.display = "block"; 
}
// 某中条件不满足时隐藏不该显示的部份
function hidetr(id)
{
	if(document.getElementById(id).style.display == "block")
	   document.getElementById(id).style.display = "none"; 	
}

// 某中条件满足时显示该显示部分,同时隐藏不该显示的部份
function showhidetr(id)
{
	if(document.getElementById(id).style.display == "block")
	   document.getElementById(id).style.display = "none";
	else
	   document.getElementById(id).style.display = "block"; 
}

//选择仓库
function cyclecost(){
window.showModalDialog('project.actulize.cyclecost.modify.win.htm','','dialogHeight:300px;dialogWidth:535px;scroll:no;help:no; status:no;');
}