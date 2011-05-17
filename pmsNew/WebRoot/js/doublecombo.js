//两级联动型，选择业务类别，获取一个最终选择值
var groups=document.form1.example.options.length
  var group=new Array(groups)
  for (i=0; i<groups; i++)
  group[i]=new Array()
group[0][0]=new Option("国际长途交换设备","国际长途交换设备")
  group[0][1]=new Option("集团长途交换设备","集团长途交换设备")
  group[0][2]=new Option("省内长途交换设备","省内长途交换设备")
group[1][0]=new Option("国际互联网","国际互联网")
  group[1][1]=new Option("省内数据应用系统","省内数据应用系统")
  group[1][2]=new Option("本地ATM/FR网本","本地ATM/FR网m")
group[2][0]=new Option("集团卫星系统","集团卫星系统")
  group[2][1]=new Option("国际SDH网","国际SDH网")
  group[2][2]=new Option("省内微波系统","省内微波系统")
  group[2][3]=new Option("其他省内传输工程","其他省内传输工程")
var temp=document.form1.stage2
function redirect(x){
  for (m=temp.options.length-1;m>0;m--)
  temp.options[m]=null
  for (i=0;i<group[x].length;i++){
  temp.options[i]=new Option(group[x][i].text,group[x][i].value)
  }
  temp.options[0].selected=true
  }