function keepitInIE(theName,theWantTop,theWantLeft) {
theRealTop=parseInt(document.body.scrollTop)
theTrueTop=theWantTop+theRealTop
document.all[theName].style.top=theTrueTop
theRealLeft=parseInt(document.body.scrollLeft)
theTrueLeft=theWantLeft+theRealLeft
document.all[theName].style.left=theTrueLeft
}
function keepitInNN(theName,theWantX,theWantY) {
theRealLay=document.layers[theName]
theBadX=self.pageYOffset
theBadY=self.pageXOffset
theRealX=theBadX+theWantX
theRealY=theBadY+theWantY
theRealLay.moveTo(theRealY,theRealX)
}
IE5=(document.all)?1:0
NN4=(document.layers)?1:0
if (IE5)
setInterval('keepitInIE("proname_list",0,8)',1)
if (NN4)
setInterval('keepitInNN("proname_list",0,8)',1)

function keepitInIE(theName,theWantTop,theWantLeft) {
theRealTop=parseInt(document.body.scrollTop)
theTrueTop=theWantTop+theRealTop
document.all[theName].style.top=theTrueTop
theRealLeft=parseInt(document.body.scrollLeft)
theTrueLeft=theWantLeft+theRealLeft
document.all[theName].style.left=theTrueLeft
}
function keepitInNN(theName,theWantX,theWantY) {
theRealLay=document.layers[theName]
theBadX=self.pageYOffset
theBadY=self.pageXOffset
theRealX=theBadX+theWantX
theRealY=theBadY+theWantY
theRealLay.moveTo(theRealY,theRealX)
}
IE5=(document.all)?1:0
NN4=(document.layers)?1:0
if (IE5)
setInterval('keepitInIE("proname",36,8)',1)
if (NN4)
setInterval('keepitInNN("proname",36,8)',1)

function keeptopInIE(theName,theWantTop,theWantLeft) {
theRealTop=parseInt(document.body.scrollTop)
theTrueTop=theWantTop+theRealTop
document.all[theName].style.top=theTrueTop
}
function keeptopInNN(theName,theWantX,theWantY) {
theRealLay=document.layers[theName]
theBadX=self.pageYOffset
theBadY=self.pageXOffset
theRealX=theBadX+theWantX
theRealY=theBadY+theWantY
theRealLay.moveTo(theRealY,theRealX)
}
IE5=(document.all)?1:0
NN4=(document.layers)?1:0
if (IE5)
setInterval('keeptopInIE("topdiv",36,8)',1)
if (NN4)
setInterval('keeptopInNN("topdiv",36,8)',1)

function keepleftInIE(theName,theWantTop,theWantLeft) {
theRealLeft=parseInt(document.body.scrollLeft)
theTrueLeft=theWantLeft+theRealLeft
document.all[theName].style.left=theTrueLeft
}
function keepleftInNN(theName,theWantX,theWantY) {
theRealLay=document.layers[theName]
theBadX=self.pageYOffset
theBadY=self.pageXOffset
theRealX=theBadX+theWantX
theRealY=theBadY+theWantY
theRealLay.moveTo(theRealY,theRealX)
}
IE5=(document.all)?1:0
NN4=(document.layers)?1:0
if (IE5)
setInterval('keepleftInIE("leftdiv",51,8)',1)
if (NN4)
setInterval('keepleftInNN("leftdiv",51,8)',1)
