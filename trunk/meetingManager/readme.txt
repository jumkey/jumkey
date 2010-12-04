Json插件主意事项：没用的属性别持久化 因为默认会加载所有的set lazy=false

权限控制：
struts 使用struts的拦截器
dwr 直接调用service struts2管理不到，因此使用spring的拦截器

2010 9.19 21:29 删除了dwr web端全由struts2处理，ajax使用jquery
----明天任务 写泛型dao

2010 9.26
普通用户登陆

询价添加 Action

获取session
%{#attr.account.address}

desc是mysql关键字




2010.9.30

所有ajax 设置都reload


2010.10.8

美化singlemeeting
费用管理

2010.10.9

添加 （宴请 活动 抽奖 费用） 合同 导出通知


2010.10.11

添加合同 同时添加会议 ongl size>0 有警告

会议 合同一起添加
有会议可以没合同（直接询价的时候就添加会员）

2010.10.12

收支统计| 添加宴请| 添加活动| 添加抽奖 导出通知单

报到 跟费用没相关 回执

宴请系统 抽奖系统 去掉新增

2010.10.13 sysaccount 对department加了lazy=false
报到 跟费用没相关 收支统计 导出通知单 单位和其单个管理 个人添加编辑 修改界面ajax代码

2010.10.14
报到等 跟费用没相关 收支管理编辑 //导出通知单 收支统计（比较粗劣，收入支出关系太复杂）

2010.10.15
报到等 跟费用没相关 //导出通知单
收支管理 单位 个人都要填(直接不让填)

2010.10.18
继续

2010.10.19
报到等 跟费用没相关
收支管理 单位 个人都要填(直接不让填)
询价 单位要填
// income 加了级联保存cascade="save-update"
//会议费项meetingid,feeitemid设置为不唯一


2010.10.28
时间控件有问题//把getYear()换成了getFullYear()
//setYear()换成了setFullYear()

2010.10.29
回执记录目前都记录在通知计划里//有待改善

2010.11.1
收入表加了money字段

2010.11.4
applet 权限
然后，进入到.\lib\security下，打开java.policy文件。在grant的括号中填写
permission java.io.FilePermission "<<ALL FILES>>", "read,write";

ALTER TABLE lottery AUTO_INCREMENT = 2001;