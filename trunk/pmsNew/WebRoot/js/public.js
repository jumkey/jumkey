//��loginҳ���¼�ɹ���������洰��
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

//ѡ����Ա
function selectman(){
window.showModalDialog('../../public/select.person.htm','','dialogHeight:350px;dialogWidth:585px;scroll:no;help:no; status:no;');
}

//ѡ��λ/����
function selectunit(){
window.showModalDialog('../../public/select.department.htm','','dialogHeight:350px;dialogWidth:585px;scroll:no;help:no; status:no;');
}

//ѡ��ҵ���������������
function select2sort(){
window.showModalDialog('../../public/select.operation.2sort.htm','','dialogHeight:270px;dialogWidth:450px;scroll:no;help:no; status:no;');
}

//�㡰������Ӧ�̡���ť������һ��TR
function append() {
	var oTBody = oTable.childNodes[0];
	var oNewLine = oTBody.childNodes[1].cloneNode(true);
	oTBody.appendChild(oNewLine);
}

//ѡ��ֿ�
function selstorage(){
window.showModalDialog('../../public/select.storage.htm','','dialogHeight:350px;dialogWidth:585px;scroll:no;help:no; status:no;');
}

//ѡ��Ӧ��
function selsupplier(){
window.showModalDialog('../../public/select.supplier.htm','','dialogHeight:350px;dialogWidth:585px;scroll:no;help:no; status:no;');
}

//ѡ������
function selmaterial(){
window.showModalDialog('../../public/select.material.htm','','dialogHeight:450px;dialogWidth:585px;scroll:no;help:no; status:no;');
}

//ѡ����Ŀ
function selproject(){
window.showModalDialog('../../public/select.proname.htm','','dialogHeight:350px;dialogWidth:585px;scroll:no;help:no; status:no;');
}

//�鿴��Ŀ�����룩��ϸ��Ϣ
function preproinfo(){
window.showModalDialog('../../project/based.proinfo.preview.htm','','dialogHeight:500px;dialogWidth:780px;scroll:yes;help:no; status:no;');
}

//�ĵ�����
function fileupload(){
window.showModalDialog('../../public/file.upload.htm','','dialogHeight:400px;dialogWidth:585px;scroll:no;help:no; status:no;');
}

//ѡ�񵽻�֪ͨ����
function selectaog(){
window.showModalDialog('../../public/select.aognum.htm','','dialogHeight:350px;dialogWidth:585px;scroll:no;help:no; status:no;');
}

//������Դ״̬������Ԥ��
function applyother1(){
window.showModalDialog('../../public/apply.other1.htm','','dialogHeight:250px;dialogWidth:585px;scroll:no;help:no; status:no;');
}

//���ι�����Ҫ�������ݼ���ģ
function applyother2(){
window.showModalDialog('../../public/apply.other2.htm','','dialogHeight:310px;dialogWidth:585px;scroll:no;help:no; status:no;');
}

//Ͷ����ϸ����Ͷ��
function applyother3(){
window.showModalDialog('../../public/apply.other3.htm','','dialogHeight:280px;dialogWidth:585px;scroll:no;help:no; status:no;');
}

//ɾ����Ϣ��ʾ
function delinfo() {
	if(confirm('ɾ������Ϣ���޷��ָ�����ȷ��Ҫɾ����'));
	}

// ��������ʱ��ʾ��Ҫ��ʾ�Ĳ���
function showtr(id)
{
	if(document.getElementById(id).style.display == "none")
	   document.getElementById(id).style.display = "block"; 
}
// ĳ������������ʱ���ز�����ʾ�Ĳ���
function hidetr(id)
{
	if(document.getElementById(id).style.display == "block")
	   document.getElementById(id).style.display = "none"; 	
}

// ĳ����������ʱ��ʾ����ʾ����,ͬʱ���ز�����ʾ�Ĳ���
function showhidetr(id)
{
	if(document.getElementById(id).style.display == "block")
	   document.getElementById(id).style.display = "none";
	else
	   document.getElementById(id).style.display = "block"; 
}

//ѡ��ֿ�
function cyclecost(){
window.showModalDialog('project.actulize.cyclecost.modify.win.htm','','dialogHeight:300px;dialogWidth:535px;scroll:no;help:no; status:no;');
}