//�㡰������Ӧ�̡���ť������һ��TR
function append() {
	var oTBody = oTable.childNodes[0];
	var oNewLine = oTBody.childNodes[1].cloneNode(true);
	oTBody.appendChild(oNewLine);
}
function remove(oTR) {
	var oTBody = oTable.childNodes[0];
	oTBody.deleteRow(oTR.sectionRowIndex);
}
