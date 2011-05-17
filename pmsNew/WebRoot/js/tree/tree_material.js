var title="物资管理";
var t,itemid;
t=outlookbar.addtitle('物资管理')
itemid=outlookbar.additem('入库单',t,'store/material.store.procedure.htm','')
itemid=outlookbar.additem('出库单',t,'obtain/material.obtain.procedure.htm','')
itemid=outlookbar.additem('请领单',t,'obtain/material.obtain.applylist.htm','')
itemid=outlookbar.additem('缴料单',t,'rollback/material.rollback.applylist.htm','')
itemid=outlookbar.additem('调拨单',t,'redeploy/material.redeploy.procedure.htm','')
itemid=outlookbar.additem('盘点表',t,'liquidate/material.liquidate.procedure.htm','')
itemid=outlookbar.additem('库存统计表',t,'reportform/material.reportform.storage.htm','')
itemid=outlookbar.additem('收支存报表',t,'reportform/material.reportform.income.htm','')
itemid=outlookbar.additem('物资使用报表',t,'reportform/material.reportform.usereport.htm','')
itemid=outlookbar.additem('供应商物资供应表',t,'reportform/material.reportform.usereport.htm','')
itemid=outlookbar.additem('物资流水账',t,'reportform/material.reportform.usereport.htm','')


/*
var title="物资入库";
var t,itemid;
t=outlookbar.addtitle('物资入库')
itemid=outlookbar.additem('办理物资入库手续',t,'store/material.store.procedure.htm','')

t=outlookbar.addtitle('物资领用')
itemid=outlookbar.additem('物资领用申请记录',t,'obtain/material.obtain.applylist.htm','')
itemid=outlookbar.additem('办理物资出库手续',t,'obtain/material.obtain.procedure.htm','')

t=outlookbar.addtitle('物资回退')
itemid=outlookbar.additem('物资回退申请记录',t,'rollback/material.rollback.applylist.htm','')
//itemid=outlookbar.additem('办理(负)出库手续',t,'plan/investment.plan.invest.htm','')
//itemid=outlookbar.additem('建立物资(负)出库帐',t,'plan/investment.plan.examine.htm','')

t=outlookbar.addtitle('物资调拨')
itemid=outlookbar.additem('办理物资调拨手续',t,'redeploy/material.redeploy.procedure.htm','')
//itemid=outlookbar.additem('办理调出出库手续',t,'plan/investment.plan.examine.htm','')
//itemid=outlookbar.additem('办理调入入库手续',t,'plan/investment.plan.invest.htm','')
//itemid=outlookbar.additem('调出物资(负)入库帐',t,'plan/investment.plan.examine.htm','')
//itemid=outlookbar.additem('办理调入物资入库帐',t,'plan/investment.plan.invest.htm','')

//t=outlookbar.addtitle('一入一出')
//itemid=outlookbar.additem('一入一出手续办理',t,'plan/investment.plan.examine.htm','')

//t=outlookbar.addtitle('假退料假领料')
//itemid=outlookbar.additem('假退料假领料手续',t,'plan/investment.plan.invest.htm','')

t=outlookbar.addtitle('物资盘点')
itemid=outlookbar.additem('物资盘点记录',t,'liquidate/material.liquidate.procedure.htm','')

t=outlookbar.addtitle('物资报废')
itemid=outlookbar.additem('物资报废记录',t,'scrap/material.scrap.procedure.htm','')

t=outlookbar.addtitle('统计报表')
itemid=outlookbar.additem('库存统计表',t,'reportform/material.reportform.storage.htm','')
itemid=outlookbar.additem('收支存报表',t,'reportform/material.reportform.income.htm','')
itemid=outlookbar.additem('物资使用报表',t,'reportform/material.reportform.usereport.htm','')
*/