//点“新增供应商”按钮后新增一行TR
function append() {
	var oTBody = oTable.childNodes[0];
	var oNewLine = oTBody.childNodes[1].cloneNode(true);
	oTBody.appendChild(oNewLine);
}
function remove(oTR) {
	var oTBody = oTable.childNodes[0];
	oTBody.deleteRow(oTR.sectionRowIndex);
}
