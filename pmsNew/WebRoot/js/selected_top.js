/**
 * �ļ���: selected.js
 * ������: duym
 * ����ʱ��: 2005.12.13
 * 
 * �����б�:
 * 1. getFirstChild(container, nodeName), �����������ڵ�һ��ָ�����͵��Ӷ���
 * 2. getLastChild(container, nodeName), ���������������һ���Ӷ���
 * 3. getFirstNextSibling(offsetObj, nodeName), ��������������һ��ͬ������ĵ�һ������
 * 4. getLastNextSibling(offsetObj, nodeName), ��������������һ��ͬ����������һ������
 * 5. getFirstPreviousSibling(offsetObj, nodeName), ��������������һ��ͬ������ĵ�һ������
 * 6. getLastPreviousSibling(offsetObj, nodeName), ��������������һ��ͬ����������һ������
 */

var Util = {

	/* �����������ڵ�һ���Ӷ��� */
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
    
	/* ���������������һ���Ӷ��� */
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

    /* ��������������һ��ͬ������ĵ�һ������ */
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

    /* ��������������һ��ͬ����������һ������ */
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

    /* ��������������һ��ͬ������ĵ�һ������ */
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

    /* ��������������һ��ͬ����������һ������ */
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

//���ѡ������Ӧ�����ϵ���ɫ
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