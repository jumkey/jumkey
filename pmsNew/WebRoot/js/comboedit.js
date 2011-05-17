function Body_Init(oSelect,oText)
{
 var iLeft= oSelect.offsetLeft;
 var iTop = oSelect.offsetTop;
 var iWidth=oSelect.clientWidth;
 var iHeight=oSelect.clientHeight;
 oSelect.style.clip='rect(0,'+iWidth+','+iHeight+','+(iWidth-18)+')';
 
 oText.style.width=iWidth;
 oText.style.height=iHeight;
 oText.style.top =iTop;
 oText.style.left=iLeft;

}
function Combo_Select(oSelect,oText)
{
 oText.value=oSelect.options[oSelect.selectedIndex].text;
 alert(oText.value);
}
function Text_ChkKey(oSelect,oText)
{
 if(event.keyCode==13)
 {
  var nIndex=HasTheValue(oText.value,oSelect);
  if(nIndex !=-1 && nIndex !=oSelect.selectedIndex)
  {
   oSelect.selectedIndex=nIndex;
  }
 }
}
function HasTheValue(name,oSelect)
{
 if(oSelect.options.length<1)
  return -1;
 var i=0;
 for(i=0;i<oSelect.options.length;i++)
 {
  if(oSelect.options[i].text==name)
   return i;
 }
 return -1;
}