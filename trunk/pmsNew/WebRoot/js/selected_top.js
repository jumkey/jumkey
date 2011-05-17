/**
 * 文件名: selected.js
 * 创建者: duym
 * 创建时间: 2005.12.13
 * 
 * 功能列表:
 * 1. getFirstChild(container, nodeName), 得容器对象内第一个指定类型的子对象。
 * 2. getLastChild(container, nodeName), 得容器对象内最后一个子对象。
 * 3. getFirstNextSibling(offsetObj, nodeName), 得容器对象内下一个同级对象的第一个对象。
 * 4. getLastNextSibling(offsetObj, nodeName), 得容器对象内下一个同级对象的最后一个对象。
 * 5. getFirstPreviousSibling(offsetObj, nodeName), 得容器对象内下一个同级对象的第一个对象。
 * 6. getLastPreviousSibling(offsetObj, nodeName), 得容器对象内下一个同级对象的最后一个对象。
 */

var Util = {

	/* 得容器对象内第一个子对象 */
    getFirstChild: function(container, nodeName) {
        var children = container.childNodes;
        var obj = null;
        if( typeof(children) != "undefined" ) {
            for( var i = 0; i < children.length; i++ ) {
                if( children[i].nodeName.toUpperCase() == nodeName.toUpperCase() ) {
                    obj = children[i];
                    break;
                }
            }
        }
        return obj;
    },
    
	/* 得容器对象内最后一个子对象 */
    getLastChild: function(container, nodeName) {
        var children = container.childNodes;
        var obj = null;
        if( typeof(children) != "undefined" ) {
            for( var i = 0; i < children.length; i++ ) {
                if( children[i].nodeName.toUpperCase() == nodeName.toUpperCase() ) {
                    obj = children[i];
                }
            }
        }
        return obj;
    },

    /* 得容器对象内下一个同级对象的第一个对象 */
    getFirstNextSibling: function(offsetObj, nodeName) {
        var obj = null;
        while( typeof(offsetObj.nextSibling) != "undefined" ) {
            offsetObj = offsetObj.nextSibling;
            if( offsetObj.nodeName.toUpperCase() == nodeName.toUpperCase() ) {
                obj = offsetObj;
                break;
            }
        }
        return obj;
    },

    /* 得容器对象内下一个同级对象的最后一个对象 */
    getLastNextSibling: function(offsetObj, nodeName) {
        var obj = null;
        while( typeof(offsetObj.nextSibling) != "undefined" ) {
            offsetObj = offsetObj.nextSibling;
            if( offsetObj.nodeName.toUpperCase() == nodeName.toUpperCase() ) {
                obj = offsetObj;
            }
        }
        return obj;
    },

    /* 得容器对象内上一个同级对象的第一个对象 */
    getFirstPreviousSibling: function(offsetObj, nodeName) {
        var obj = null;
        while( typeof(offsetObj.nextSibling) != "undefined" ) {
            offsetObj = offsetObj.nextSibling;
            if( offsetObj.nodeName.toUpperCase() == nodeName.toUpperCase() ) {
                obj = offsetObj;
                break;
            }
        }
        return obj;
    },

    /* 得容器对象内上一个同级对象的最后一个对象 */
    getLastPreviousSibling: function(offsetObj, nodeName) {
        var obj = null;
        while( typeof(offsetObj.previousSibling) != "undefined" ) {
            offsetObj = offsetObj.previousSibling;
            if( offsetObj.nodeName.toUpperCase() == nodeName.toUpperCase() ) {
                obj = offsetObj;
            }
        }
        return obj;
    }
		
}

//鼠标选定后相应链接上的颜色
var oTD = null;
var sOuterHTML = null;
var sURL = null;
function onSelected(obj, text) {
	if( oTD != null ) {
		var tmpTD = Util.getFirstChild(oTD, "span");
		tmpTD.outerHTML = sOuterHTML;
	}
	oTD = obj.parentNode;
	sOuterHTML = obj.outerHTML;
	obj.outerHTML = "<span class=top-title-local>" + text + "</span>";
}