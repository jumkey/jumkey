//���������ͣ�ѡ��ҵ����𣬻�ȡһ������ѡ��ֵ
var groups=document.form1.example.options.length
  var group=new Array(groups)
  for (i=0; i<groups; i++)
  group[i]=new Array()
group[0][0]=new Option("���ʳ�;�����豸","���ʳ�;�����豸")
  group[0][1]=new Option("���ų�;�����豸","���ų�;�����豸")
  group[0][2]=new Option("ʡ�ڳ�;�����豸","ʡ�ڳ�;�����豸")
group[1][0]=new Option("���ʻ�����","���ʻ�����")
  group[1][1]=new Option("ʡ������Ӧ��ϵͳ","ʡ������Ӧ��ϵͳ")
  group[1][2]=new Option("����ATM/FR����","����ATM/FR��m")
group[2][0]=new Option("��������ϵͳ","��������ϵͳ")
  group[2][1]=new Option("����SDH��","����SDH��")
  group[2][2]=new Option("ʡ��΢��ϵͳ","ʡ��΢��ϵͳ")
  group[2][3]=new Option("����ʡ�ڴ��乤��","����ʡ�ڴ��乤��")
var temp=document.form1.stage2
function redirect(x){
  for (m=temp.options.length-1;m>0;m--)
  temp.options[m]=null
  for (i=0;i<group[x].length;i++){
  temp.options[i]=new Option(group[x][i].text,group[x][i].value)
  }
  temp.options[0].selected=true
  }