var title="采购计划管理";
var t,itemid;

t=outlookbar.addtitle('采购计划管理')
itemid=outlookbar.additem('月度采购计划',t,'plan/stock.plan.monthly.htm','')
itemid=outlookbar.additem('一类采购申请',t,'plan/stock.plan.apply.htm','')
itemid=outlookbar.additem('紧急采购申请',t,'plan/stock.plan.jjapply.htm','')
itemid=outlookbar.additem('异常采购申请',t,'plan/stock.plan.ycapply.htm','')
itemid=outlookbar.additem('服务采购申请',t,'plan/stock.plan.fwapply.htm','')
itemid=outlookbar.additem('采购申请确认',t,'plan/stock.plan.confirm.htm','')
itemid=outlookbar.additem('采购申请审核',t,'plan/stock.plan.audit.htm','')
itemid=outlookbar.additem('采购计划审核',t,'plan/stock.plan.monthlycollect.htm','') 
//itemid=outlookbar.additem('采购计划汇总',t,'plan/stock.plan.collect.htm','')

t=outlookbar.addtitle('订货管理')
itemid=outlookbar.additem('订货计划',t,'goods/stock.goods.goodsplan.htm','')
itemid=outlookbar.additem('供货汇总',t,'order/stock.order.ordercollect.htm','')
itemid=outlookbar.additem('一类采购生成订单',t,'goods/stock.plan.apply.order.htm','')
itemid=outlookbar.additem('紧急采购生成订单',t,'goods/stock.plan.jjapply.order.htm','')
itemid=outlookbar.additem('订单管理',t,'order/stock.order.order.htm','')

t=outlookbar.addtitle('合同管理')
itemid=outlookbar.additem('合同记录',t,'bargain/stock.bargain.bargain.htm','')
itemid=outlookbar.additem('合同统计',t,'bargain/stock.bargain.statbargain.htm','')
itemid=outlookbar.additem('合同到货记录',t,'bargain/stock.bargain.goods.htm','')
itemid=outlookbar.additem('合同到货汇总',t,'bargain/stock.bargain.collectgoods.htm','')
itemid=outlookbar.additem('合同付款记录',t,'bargain/stock.bargain.payment.htm','')
itemid=outlookbar.additem('计划/实际采购对比',t,'bargain/stock.bargain.planfactbargain.htm','')
itemid=outlookbar.additem('供货统计',t,'bargain/stock.bargain.providegoods.htm','')

t=outlookbar.addtitle('供应商管理')
itemid=outlookbar.additem('供应商记录',t,'supplier/stock.supplier.supplier.htm','')
