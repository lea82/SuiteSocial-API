(window.webpackJsonp=window.webpackJsonp||[]).push([[34],{aH1m:function(t,e,n){t.exports=function(){"use strict";var t,e,n,l,o,i,r,a,s,u,c,d,p="function"==typeof Symbol&&"symbol"==typeof Symbol.iterator?function(t){return typeof t}:function(t){return t&&"function"==typeof Symbol&&t.constructor===Symbol&&t!==Symbol.prototype?"symbol":typeof t},f="bubble_default",h=window.Sizzle||null,m="undefined",g=!1,v=("undefined"==typeof jQuery?"undefined":p(jQuery))!==m,b=!1,x=!1,w=/^[a-zA-Z]+[a-zA-Z0-9_-]*$/,y={left:"right",right:"left"};try{p(window.sessionStorage)!==m&&(b=!0,sessionStorage.setItem("hopscotch.test.storage","ok"),sessionStorage.removeItem("hopscotch.test.storage"),x=!0)}catch(S){}return c={smoothScroll:!0,scrollDuration:1e3,scrollTopMargin:200,showCloseButton:!0,showPrevButton:!1,showNextButton:!0,bubbleWidth:280,bubblePadding:15,arrowWidth:20,skipIfNoElement:!0,isRtl:!1,cookieName:"hopscotch.tour.state"},Array.isArray||(Array.isArray=function(t){return"[object Array]"===Object.prototype.toString.call(t)}),(a={addClass:function(t,e){var n,l,o,i;if(t.className){for(l=e.split(/\s+/),n=" "+t.className+" ",o=0,i=l.length;i>o;++o)n.indexOf(" "+l[o]+" ")<0&&(n+=l[o]+" ");t.className=n.replace(/^\s+|\s+$/g,"")}else t.className=e},removeClass:function(t,e){var n,l,o,i;for(l=e.split(/\s+/),n=" "+t.className+" ",o=0,i=l.length;i>o;++o)n=n.replace(" "+l[o]+" "," ");t.className=n.replace(/^\s+|\s+$/g,"")},hasClass:function(t,e){return!!t.className&&-1!==(" "+t.className+" ").indexOf(" "+e+" ")},getPixelValue:function(t){var e=void 0===t?"undefined":p(t);return"number"===e?t:"string"===e?parseInt(t,10):0},valOrDefault:function(t,e){return(void 0===t?"undefined":p(t))!==m?t:e},invokeCallbackArrayHelper:function(t){var e;return Array.isArray(t)&&"function"==typeof(e=u[t[0]])?e.apply(this,t.slice(1)):void 0},invokeCallbackArray:function(t){var e,n;if(Array.isArray(t)){if("string"==typeof t[0])return a.invokeCallbackArrayHelper(t);for(e=0,n=t.length;n>e;++e)a.invokeCallback(t[e])}},invokeCallback:function(t){return"function"==typeof t?t():"string"==typeof t&&u[t]?u[t]():a.invokeCallbackArray(t)},invokeEventCallbacks:function(t,e){var n,l,o=s[t];if(e)return this.invokeCallback(e);for(n=0,l=o.length;l>n;++n)this.invokeCallback(o[n].cb)},getScrollTop:function(){return p(window.pageYOffset)!==m?window.pageYOffset:document.documentElement.scrollTop},getScrollLeft:function(){return p(window.pageXOffset)!==m?window.pageXOffset:document.documentElement.scrollLeft},getWindowHeight:function(){return window.innerHeight||document.documentElement.clientHeight},addEvtListener:function(t,e,n){return t?t.addEventListener?t.addEventListener(e,n,!1):t.attachEvent("on"+e,n):void 0},removeEvtListener:function(t,e,n){return t?t.removeEventListener?t.removeEventListener(e,n,!1):t.detachEvent("on"+e,n):void 0},documentIsReady:function(){return"complete"===document.readyState},evtPreventDefault:function(t){t.preventDefault?t.preventDefault():event&&(event.returnValue=!1)},extend:function(t,e){var n;for(n in e)e.hasOwnProperty(n)&&(t[n]=e[n])},getStepTargetHelper:function(t){var e=document.getElementById(t);if(e)return e;if(v)return(e=jQuery(t)).length?e[0]:null;if(h)return(e=new h(t)).length?e[0]:null;if(document.querySelector)try{return document.querySelector(t)}catch(n){}return/^#[a-zA-Z][\w-_:.]*$/.test(t)?document.getElementById(t.substring(1)):null},getStepTarget:function(t){var e;if(!t||!t.target)return null;if("string"==typeof t.target)return a.getStepTargetHelper(t.target);if(Array.isArray(t.target)){var n,l;for(n=0,l=t.target.length;l>n;n++)if("string"==typeof t.target[n]&&(e=a.getStepTargetHelper(t.target[n])))return e;return null}return t.target},getI18NString:function(t){return o[t]||l[t]},setState:function(t,e,n){var l,o="";if(b&&x)try{sessionStorage.setItem(t,e)}catch(i){x=!1,this.setState(t,e,n)}else b&&sessionStorage.removeItem(t),n&&((l=new Date).setTime(l.getTime()+24*n*60*60*1e3),o="; expires="+l.toGMTString()),document.cookie=t+"="+e+o+"; path=/"},getState:function(t){var e,n,l,o=t+"=",i=document.cookie.split(";");if(b&&(l=sessionStorage.getItem(t)))return l;for(e=0;e<i.length;e++){for(n=i[e];" "===n.charAt(0);)n=n.substring(1,n.length);if(0===n.indexOf(o)){l=n.substring(o.length,n.length);break}}return l},clearState:function(t){b?sessionStorage.removeItem(t):this.setState(t,"",-1)},normalizePlacement:function(t){!t.placement&&t.orientation&&(t.placement=t.orientation)},flipPlacement:function(t){if(t.isRtl&&!t._isFlipped){var e,n,l=["orientation","placement"];for(n in t.xOffset&&(t.xOffset=-1*this.getPixelValue(t.xOffset)),l)t.hasOwnProperty(e=l[n])&&y.hasOwnProperty(t[e])&&(t[e]=y[t[e]]);t._isFlipped=!0}}}).addEvtListener(window,"load",function(){g&&d.startTour()}),s={next:[],prev:[],start:[],end:[],show:[],error:[],close:[]},u={},l={stepNums:null,nextBtn:"Next",prevBtn:"Back",doneBtn:"Done",skipBtn:"Skip",closeTooltip:"Close"},o={},(e=function(t){this.init(t)}).prototype={isShowing:!1,currStep:void 0,setPosition:function(t){var e,n,l,o,i,r,s,u=a.getStepTarget(t),c=this.element,d=this.arrowEl,p=t.isRtl?"right":"left";if(a.flipPlacement(t),a.normalizePlacement(t),n=c.offsetWidth,e=c.offsetHeight,a.removeClass(c,"fade-in-down fade-in-up fade-in-left fade-in-right"),l=u.getBoundingClientRect(),s=t.isRtl?l.right-n:l.left,"top"===t.placement)o=l.top-e-this.opt.arrowWidth,i=s;else if("bottom"===t.placement)o=l.bottom+this.opt.arrowWidth,i=s;else if("left"===t.placement)o=l.top,i=l.left-n-this.opt.arrowWidth;else{if("right"!==t.placement)throw new Error("Bubble placement failed because step.placement is invalid or undefined!");o=l.top,i=l.right+this.opt.arrowWidth}(r="center"!==t.arrowOffset?a.getPixelValue(t.arrowOffset):t.arrowOffset)?"top"===t.placement||"bottom"===t.placement?(d.style.top="",d.style[p]="center"===r?Math.floor(n/2-d.offsetWidth/2)+"px":r+"px"):("left"===t.placement||"right"===t.placement)&&(d.style[p]="",d.style.top="center"===r?Math.floor(e/2-d.offsetHeight/2)+"px":r+"px"):(d.style.top="",d.style[p]=""),"center"===t.xOffset?i=l.left+u.offsetWidth/2-n/2:i+=a.getPixelValue(t.xOffset),"center"===t.yOffset?o=l.top+u.offsetHeight/2-e/2:o+=a.getPixelValue(t.yOffset),t.fixedElement||(o+=a.getScrollTop(),i+=a.getScrollLeft()),c.style.position=t.fixedElement?"fixed":"absolute",c.style.top=o+"px",c.style.left=i+"px"},render:function(t,e,n){var l,o,r,s,u,c,p,h,m,g,v=this.element;if(t?this.currStep=t:this.currStep&&(t=this.currStep),this.opt.isTourBubble?(s=d.getCurrTour())&&(o=s.customData,l=s.customRenderer,t.isRtl=t.hasOwnProperty("isRtl")?t.isRtl:s.hasOwnProperty("isRtl")?s.isRtl:this.opt.isRtl,r=s.unsafe,Array.isArray(s.steps)&&(c=this._getStepI18nNum(this._getStepNum((u=s.steps.length)-1)),h=this._getStepNum(e)===this._getStepNum(u-1))):(o=t.customData,l=t.customRenderer,r=t.unsafe,t.isRtl=t.hasOwnProperty("isRtl")?t.isRtl:this.opt.isRtl),p=a.getI18NString(h?"doneBtn":t.showSkip?"skipBtn":"nextBtn"),a.flipPlacement(t),a.normalizePlacement(t),this.placement=t.placement,g={i18n:{prevBtn:a.getI18NString("prevBtn"),nextBtn:p,closeTooltip:a.getI18NString("closeTooltip"),stepNum:this._getStepI18nNum(this._getStepNum(e)),numSteps:c},buttons:{showPrev:a.valOrDefault(t.showPrevButton,this.opt.showPrevButton)&&this._getStepNum(e)>0,showNext:a.valOrDefault(t.showNextButton,this.opt.showNextButton),showCTA:a.valOrDefault(t.showCTAButton&&t.ctaLabel,!1),ctaLabel:t.ctaLabel,showClose:a.valOrDefault(this.opt.showCloseButton,!0)},step:{num:e,isLast:a.valOrDefault(h,!1),title:t.title||"",content:t.content||"",isRtl:t.isRtl,placement:t.placement,padding:a.valOrDefault(t.padding,this.opt.bubblePadding),width:a.getPixelValue(t.width)||this.opt.bubbleWidth,customData:t.customData||{}},tour:{isTour:this.opt.isTourBubble,numSteps:u,unsafe:a.valOrDefault(r,!1),customData:o||{}}},"function"==typeof l)v.innerHTML=l(g);else if("string"==typeof l){if(!d.templates||"function"!=typeof d.templates[l])throw new Error('Bubble rendering failed - template "'+l+'" is not a function.');v.innerHTML=d.templates[l](g)}else if(i)v.innerHTML=i(g);else{if(!d.templates||"function"!=typeof d.templates[f])throw new Error('Bubble rendering failed - template "'+f+'" is not a function.');v.innerHTML=d.templates[f](g)}var b,x=v.children,w=x.length;for(m=0;w>m;m++)a.hasClass(b=x[m],"hopscotch-arrow")&&(this.arrowEl=b);return v.style.zIndex="number"==typeof t.zindex?t.zindex:"",this._setArrow(t.placement),this.hide(!1),this.setPosition(t),n&&n(!t.fixedElement),this},_getStepNum:function(t){var e,n=0,l=d.getSkippedStepsIndexes(),o=l.length;for(e=0;o>e;e++)t>l[e]&&n++;return t-n},_getStepI18nNum:function(t){var e=a.getI18NString("stepNums");return e&&t<e.length?t=e[t]:t+=1,t},_setArrow:function(t){a.removeClass(this.arrowEl,"down up right left"),"top"===t?a.addClass(this.arrowEl,"down"):"bottom"===t?a.addClass(this.arrowEl,"up"):"left"===t?a.addClass(this.arrowEl,"right"):"right"===t&&a.addClass(this.arrowEl,"left")},_getArrowDirection:function(){return"top"===this.placement?"down":"bottom"===this.placement?"up":"left"===this.placement?"right":"right"===this.placement?"left":void 0},show:function(){var t=this,e="fade-in-"+this._getArrowDirection();return a.removeClass(this.element,"hide"),a.addClass(this.element,e),setTimeout(function(){a.removeClass(t.element,"invisible")},50),setTimeout(function(){a.removeClass(t.element,e)},1e3),this.isShowing=!0,this},hide:function(t){var e=this.element;return t=a.valOrDefault(t,!0),e.style.top="",e.style.left="",t?(a.addClass(e,"hide"),a.removeClass(e,"invisible")):(a.removeClass(e,"hide"),a.addClass(e,"invisible")),a.removeClass(e,"animate fade-in-up fade-in-down fade-in-right fade-in-left"),this.isShowing=!1,this},destroy:function(){var t=this.element;t&&t.parentNode.removeChild(t),a.removeEvtListener(t,"click",this.clickCb)},_handleBubbleClick:function(t){var e;if("cta"===(e=function e(n){return n===t.currentTarget?null:a.hasClass(n,"hopscotch-cta")?"cta":a.hasClass(n,"hopscotch-next")?"next":a.hasClass(n,"hopscotch-prev")?"prev":a.hasClass(n,"hopscotch-close")?"close":e(n.parentElement)}((t=t||window.event).target||t.srcElement)))this.opt.isTourBubble||d.getCalloutManager().removeCallout(this.currStep.id),this.currStep.onCTA&&a.invokeCallback(this.currStep.onCTA);else if("next"===e)d.nextStep(!0);else if("prev"===e)d.prevStep(!0);else if("close"===e){if(this.opt.isTourBubble){var n=d.getCurrStepNum()===d.getCurrTour().steps.length-1;a.invokeEventCallbacks("close"),d.endTour(!0,n)}else this.opt.onClose&&a.invokeCallback(this.opt.onClose),this.opt.id&&!this.opt.isTourBubble?d.getCalloutManager().removeCallout(this.opt.id):this.destroy();a.evtPreventDefault(t)}},init:function(t){var e,n,l,o=document.createElement("div"),i=this,r=!1;this.element=o,l={showPrevButton:c.showPrevButton,showNextButton:c.showNextButton,bubbleWidth:c.bubbleWidth,bubblePadding:c.bubblePadding,arrowWidth:c.arrowWidth,isRtl:c.isRtl,showNumber:!0,isTourBubble:!0},t=(void 0===t?"undefined":p(t))===m?{}:t,a.extend(l,t),this.opt=l,o.className="hopscotch-bubble animated",l.isTourBubble?(n=d.getCurrTour())&&a.addClass(o,"tour-"+n.id):a.addClass(o,"hopscotch-callout no-number"),a.addEvtListener(window,"resize",function(){!r&&i.isShowing&&(r=!0,setTimeout(function(){i.setPosition(i.currStep),r=!1},100))}),this.clickCb=function(t){i._handleBubbleClick(t)},a.addEvtListener(o,"click",this.clickCb),this.hide(),a.documentIsReady()?document.body.appendChild(o):(document.addEventListener?(e=function(){document.removeEventListener("DOMContentLoaded",e),window.removeEventListener("load",e),document.body.appendChild(o)},document.addEventListener("DOMContentLoaded",e,!1)):(e=function(){"complete"===document.readyState&&(document.detachEvent("onreadystatechange",e),window.detachEvent("onload",e),document.body.appendChild(o))},document.attachEvent("onreadystatechange",e)),a.addEvtListener(window,"load",e))}},n=function(){var t={},n={};this.createCallout=function(l){var o;if(!l.id)throw new Error("Must specify a callout id.");if(!w.test(l.id))throw new Error("Callout ID is using an invalid format. Use alphanumeric, underscores, and/or hyphens only. First character must be a letter.");if(t[l.id])throw new Error("Callout by that id already exists. Please choose a unique id.");if(!a.getStepTarget(l))throw new Error("Must specify existing target element via 'target' option.");return l.showNextButton=l.showPrevButton=!1,l.isTourBubble=!1,o=new e(l),t[l.id]=o,n[l.id]=l,o.render(l,null,function(){o.show(),l.onShow&&a.invokeCallback(l.onShow)}),o},this.getCallout=function(e){return t[e]},this.removeAllCallouts=function(){var e;for(e in t)t.hasOwnProperty(e)&&this.removeCallout(e)},this.removeCallout=function(e){var l=t[e];t[e]=null,n[e]=null,l&&l.destroy()},this.refreshCalloutPositions=function(){var e,l,o;for(e in t)t.hasOwnProperty(e)&&n.hasOwnProperty(e)&&(o=n[e],(l=t[e])&&o&&l.setPosition(o))}},t=function(t){var l,h,b,x,y,S,C,T,k=this,O={},E=[],N=function(t){return l&&l.element&&l.element.parentNode||(l=new e(b)),t&&a.extend(l.opt,{bubblePadding:B("bubblePadding"),bubbleWidth:B("bubbleWidth"),showNextButton:B("showNextButton"),showPrevButton:B("showPrevButton"),showCloseButton:B("showCloseButton"),arrowWidth:B("arrowWidth"),isRtl:B("isRtl")}),l},P=function(){l&&(l.destroy(),l=null)},B=function(t){return void 0===b?c[t]:a.valOrDefault(b[t],c[t])},A=function(){return!x||0>y||y>=x.steps.length?null:x.steps[y]},D=function(){k.nextStep()},L=function t(e,n){var l,o;y+e>=0&&y+e<x.steps.length?(y+=e,o=function(){a.getStepTarget(l)?(O[y]&&delete O[y],n(y)):(O[y]=!0,a.invokeEventCallbacks("error"),t(e,n))},(l=A()).delay?setTimeout(o,l.delay):o()):n(-1)},R=function(t,e){var n,l,o,i,r=N(),s=this;if(r.hide(),t=a.valOrDefault(t,!0),(n=A()).nextOnTargetClick&&a.removeEvtListener(a.getStepTarget(n),"click",D),l=n,i=function(n){var i;if(-1===n)return this.endTour(!0);if(t&&(i=e>0?a.invokeEventCallbacks("next",l.onNext):a.invokeEventCallbacks("prev",l.onPrev)),n===y){if(o)return void I();(i=a.valOrDefault(i,!0))?this.showStep(n):this.endTour(!1)}},!(o=e>0?l.multipage:y>0&&x.steps[y-1].multipage)&&B("skipIfNoElement"))L(e,function(t){i.call(s,t)});else if(y+e>=0&&y+e<x.steps.length){if(y+=e,n=A(),!a.getStepTarget(n)&&!o)return a.invokeEventCallbacks("error"),this.endTour(!0,!1);i.call(this,y)}else if(y+e===x.steps.length)return this.endTour();return this},F=function(t){function e(){l.show(),a.invokeEventCallbacks("show",n.onShow)}var n=x.steps[t],l=N(),o=a.getStepTarget(n);y!==t&&A().nextOnTargetClick&&a.removeEvtListener(a.getStepTarget(A()),"click",D),y=t,l.hide(!1),l.render(n,t,function(t){t?function(t){var e,n,l,o,i,r,s=N().element,u=a.getPixelValue(s.style.top),c=u+a.getPixelValue(s.offsetHeight),d=a.getStepTarget(A()).getBoundingClientRect(),f=d.top+a.getScrollTop(),h=d.bottom+a.getScrollTop(),g=f>u?u:f,b=c>h?c:h,x=a.getScrollTop(),w=x+a.getWindowHeight(),y=g-B("scrollTopMargin");g>=x&&(g<=x+B("scrollTopMargin")||w>=b)?t&&t():B("smoothScroll")?("undefined"==typeof YAHOO?"undefined":p(YAHOO))!==m&&p(YAHOO.env)!==m&&p(YAHOO.env.ua)!==m&&p(YAHOO.util)!==m&&p(YAHOO.util.Scroll)!==m?(e=YAHOO.env.ua.webkit?document.body:document.documentElement,l=YAHOO.util.Easing?YAHOO.util.Easing.easeOut:void 0,(n=new YAHOO.util.Scroll(e,{scroll:{to:[0,y]}},B("scrollDuration")/1e3,l)).onComplete.subscribe(t),n.animate()):v?jQuery("body, html").animate({scrollTop:y},B("scrollDuration"),t):(0>y&&(y=0),o=x>g?-1:1,i=Math.abs(x-y)/(B("scrollDuration")/10),(r=function(){var e=a.getScrollTop(),n=e+o*i;return o>0&&n>=y||0>o&&y>=n?(n=y,t&&t(),void window.scrollTo(0,n)):(window.scrollTo(0,n),a.getScrollTop()===e?void(t&&t()):void setTimeout(r,10))})()):(window.scrollTo(0,y),t&&t())}(e):e(),n.nextOnTargetClick&&a.addEvtListener(o,"click",D)}),I()},I=function(){var t=x.id+":"+y,e=d.getSkippedStepsIndexes();e&&e.length>0&&(t+=":"+e.join(",")),a.setState(B("cookieName"),t,1)};this.getCalloutManager=function(){return(void 0===h?"undefined":p(h))===m&&(h=new n),h},this.startTour=function(t,e){var n,l={},o=this;if(!x){if(!t)throw new Error("Tour data is required for startTour.");if(!t.id||!w.test(t.id))throw new Error("Tour ID is using an invalid format. Use alphanumeric, underscores, and/or hyphens only. First character must be a letter.");x=t,(function(t){var e,n,l,o={};for(e in t)t.hasOwnProperty(e)&&"id"!==e&&"steps"!==e&&(o[e]=t[e]);return T.call(this,o,!0),(n=a.getState(B("cookieName")))&&(l=n.split(":"),S=l[0],C=l[1],l.length>2&&(E=l[2].split(",")),C=parseInt(C,10)),this}).call(this,t)}if((void 0===e?"undefined":p(e))!==m){if(e>=x.steps.length)throw new Error("Specified step number out of bounds.");n=e}if(!a.documentIsReady())return g=!0,this;if(void 0===n&&x.id===S&&(void 0===C?"undefined":p(C))!==m){if(n=C,E.length>0)for(var i=0,r=E.length;r>i;i++)l[E[i]]=!0}else n||(n=0);return function(t,e,n){var l,o;if(y=t||0,O=e||{},l=A(),o=a.getStepTarget(l))n(y);else if(!o){if(a.invokeEventCallbacks("error"),O[y]=!0,B("skipIfNoElement"))return void L(1,n);n(y=-1)}}(n,l,function(t){return-1!==t&&a.getStepTarget(x.steps[t])?(a.invokeEventCallbacks("start"),N().hide(!1),o.isActive=!0,void(a.getStepTarget(A())?o.showStep(t):(a.invokeEventCallbacks("error"),B("skipIfNoElement")&&o.nextStep(!1)))):void o.endTour(!1,!1)}),this},this.showStep=function(t){var e=x.steps[t],n=y;return a.getStepTarget(e)?(e.delay?setTimeout(function(){F(t)},e.delay):F(t),this):(y=t,a.invokeEventCallbacks("error"),void(y=n))},this.prevStep=function(t){return R.call(this,t,-1),this},this.nextStep=function(t){return R.call(this,t,1),this},this.endTour=function(t,e){var n,l=N();return t=a.valOrDefault(t,!0),e=a.valOrDefault(e,!0),x&&(n=A())&&n.nextOnTargetClick&&a.removeEvtListener(a.getStepTarget(n),"click",D),y=0,C=void 0,l.hide(),t&&a.clearState(B("cookieName")),this.isActive&&(this.isActive=!1,x&&e&&a.invokeEventCallbacks("end")),this.removeCallbacks(null,!0),this.resetDefaultOptions(),P(),x=null,this},this.getCurrTour=function(){return x},this.getCurrTarget=function(){return a.getStepTarget(A())},this.getCurrStepNum=function(){return y},this.getSkippedStepsIndexes=function(){var t,e=[];for(t in O)e.push(t);return e},this.refreshBubblePosition=function(){var t=A();return t&&N().setPosition(t),this.getCalloutManager().refreshCalloutPositions(),this},this.listen=function(t,e,n){return t&&s[t].push({cb:e,fromTour:n}),this},this.unlisten=function(t,e){var n,l,o=s[t];for(n=0,l=o.length;l>n;++n)o[n].cb===e&&o.splice(n,1);return this},this.removeCallbacks=function(t,e){var n,l,o,i;for(i in s)if(!t||t===i)if(e)for(l=0,o=(n=s[i]).length;o>l;++l)n[l].fromTour&&(n.splice(l--,1),--o);else s[i]=[];return this},this.registerHelper=function(t,e){"string"==typeof t&&"function"==typeof e&&(u[t]=e)},this.unregisterHelper=function(t){u[t]=null},this.invokeHelper=function(t){var e,n,l=[];for(e=1,n=arguments.length;n>e;++e)l.push(arguments[e]);u[t]&&u[t].call(null,l)},this.setCookieName=function(t){return b.cookieName=t,this},this.resetDefaultOptions=function(){return b={},this},this.resetDefaultI18N=function(){return o={},this},this.getState=function(){return a.getState(B("cookieName"))},T=function(t,e){var n,l,i,r=["next","prev","start","end","show","error","close"];for(b||this.resetDefaultOptions(),a.extend(b,t),t&&a.extend(o,t.i18n),l=0,i=r.length;i>l;++l)t[n="on"+r[l].charAt(0).toUpperCase()+r[l].substring(1)]&&this.listen(r[l],t[n],e);return N(!0),this},this.configure=function(t){return T.call(this,t,!1)},this.setRenderer=function(t){var e=void 0===t?"undefined":p(t);return"string"===e?(f=t,i=void 0):"function"===e&&(i=t),this},this.setEscaper=function(t){return"function"==typeof t&&(r=t),this},(function(t){t&&this.configure(t)}).call(this,t)},d=new t,(function(){var t={escape:function(t){return r?r(t):null==t?"":(""+t).replace(new RegExp("[&<>\"']","g"),function(t){return"&"==t?"&amp;":"<"==t?"&lt;":">"==t?"&gt;":'"'==t?"&quot;":"'"==t?"&#x27;":void 0})}};this.templates=this.templates||{},this.templates.bubble_default=function(e){function n(e,n){return n?t.escape(e):e}var l,o="";Array,o+="\n";var i=e.i18n,r=e.buttons,a=e.step,s=e.tour;return o+='\n<div class="hopscotch-bubble-container" style="width: '+(null==(l=a.width)?"":l)+"px; padding: "+(null==(l=a.padding)?"":l)+'px;">\n  ',s.isTour&&(o+='<span class="hopscotch-bubble-number">'+(null==(l=i.stepNum)?"":l)+"</span>"),o+='\n  <div class="hopscotch-bubble-content">\n    ',""!==a.title&&(o+='<h3 class="hopscotch-title">'+(null==(l=n(a.title,s.unsafe))?"":l)+"</h3>"),o+="\n    ",""!==a.content&&(o+='<div class="hopscotch-content">'+(null==(l=n(a.content,s.unsafe))?"":l)+"</div>"),o+='\n  </div>\n  <div class="hopscotch-actions">\n    ',r.showPrev&&(o+='<button class="hopscotch-nav-button prev hopscotch-prev">'+(null==(l=i.prevBtn)?"":l)+"</button>"),o+="\n    ",r.showCTA&&(o+='<button class="hopscotch-nav-button next hopscotch-cta">'+(null==(l=r.ctaLabel)?"":l)+"</button>"),o+="\n    ",r.showNext&&(o+='<button class="hopscotch-nav-button next hopscotch-next">'+(null==(l=i.nextBtn)?"":l)+"</button>"),o+="\n  </div>\n  ",r.showClose&&(o+='<button class="hopscotch-bubble-close hopscotch-close">'+(null==(l=i.closeTooltip)?"":l)+"</button>"),o+'\n</div>\n<div class="hopscotch-bubble-arrow-container hopscotch-arrow">\n  <div class="hopscotch-bubble-arrow-border"></div>\n  <div class="hopscotch-bubble-arrow"></div>\n</div>\n'}}).call(d),d}()},gqjU:function(t,e,n){"use strict";n.r(e);var l=n("CcnG"),o=function(){return function(){}}(),i=n("pMnS"),r=n("21Lb"),a=n("OzfB"),s=n("lzlj"),u=n("FVSy"),c=n("bujt"),d=n("UodH"),p=n("lLAP"),f=n("wFw1"),h=n("Ip0R"),m=n("aH1m"),g=function(){function t(t){this.snackBar=t}return t.prototype.ngOnInit=function(){},t.prototype.ngOnDestroy=function(){m.endTour(!0)},t.prototype.tourSteps=function(){var t=this;return{id:"demo-tour",showPrevButton:!0,onEnd:function(){t.snackBar.open("User tour ended!","close",{duration:3e3})},onClose:function(){t.snackBar.open("You just closed User Tour!","close",{duration:3e3})},steps:[{title:"Step one",content:"This is step description.",target:"areaOne",placement:"left",xOffset:10},{title:"Define your steps",content:"This is step description.",target:document.querySelector("#areaOne code"),placement:"left",xOffset:0,yOffset:-10},{title:"Invoke startTour function",content:"This is step description.",target:document.querySelector("#areaTwo code"),placement:"left",xOffset:15,yOffset:-10}]}},t.prototype.startTour=function(){m.endTour(!0),m.startTour(this.tourSteps())},t}(),v=n("vARd"),b=l["\u0275crt"]({encapsulation:0,styles:[[""]],data:{}});function x(t){return l["\u0275vid"](0,[(t()(),l["\u0275eld"](0,0,null,null,46,"div",[["fxLayout","row wrap"]],null,null,null,null,null)),l["\u0275did"](1,671744,null,0,r.d,[l.ElementRef,a.j,[2,r.m],a.f],{fxLayout:[0,"fxLayout"]},null),(t()(),l["\u0275eld"](2,0,null,null,14,"div",[["fxFlex","100"],["fxFlex.gt-sm","33"],["fxFlex.sm","50"]],null,null,null,null,null)),l["\u0275did"](3,671744,null,0,r.b,[l.ElementRef,a.j,a.e,r.j,a.f],{fxFlex:[0,"fxFlex"],"fxFlex.sm":[1,"fxFlex.sm"],"fxFlex.gt-sm":[2,"fxFlex.gt-sm"]},null),(t()(),l["\u0275eld"](4,0,null,null,12,"mat-card",[["class","default mat-card"]],null,null,null,s.d,s.a)),l["\u0275did"](5,49152,null,0,u.a,[],null,null),(t()(),l["\u0275eld"](6,0,null,0,2,"mat-card-title",[["class","mat-card-title"]],null,null,null,null,null)),l["\u0275did"](7,16384,null,0,u.i,[],null,null),(t()(),l["\u0275ted"](-1,null,["Example User Tour"])),(t()(),l["\u0275eld"](9,0,null,0,2,"mat-card-subtitle",[["class","mat-card-subtitle"]],null,null,null,null,null)),l["\u0275did"](10,16384,null,0,u.h,[],null,null),(t()(),l["\u0275ted"](-1,null,["Click this button to start a demo Tour."])),(t()(),l["\u0275eld"](12,0,null,0,4,"mat-card-content",[["class","mat-card-content"]],null,null,null,null,null)),l["\u0275did"](13,16384,null,0,u.d,[],null,null),(t()(),l["\u0275eld"](14,0,null,null,2,"button",[["color","primary"],["mat-raised-button",""]],[[1,"disabled",0],[2,"_mat-animation-noopable",null]],[[null,"click"]],function(t,e,n){var l=!0;return"click"===e&&(l=!1!==t.component.startTour()&&l),l},c.d,c.b)),l["\u0275did"](15,180224,null,0,d.b,[l.ElementRef,p.h,[2,f.a]],{color:[0,"color"]},null),(t()(),l["\u0275ted"](-1,0,["Start Tour"])),(t()(),l["\u0275eld"](17,0,null,null,18,"div",[["fxFlex","100"],["fxFlex.gt-sm","33"],["fxFlex.sm","50"]],null,null,null,null,null)),l["\u0275did"](18,671744,null,0,r.b,[l.ElementRef,a.j,a.e,r.j,a.f],{fxFlex:[0,"fxFlex"],"fxFlex.sm":[1,"fxFlex.sm"],"fxFlex.gt-sm":[2,"fxFlex.gt-sm"]},null),(t()(),l["\u0275eld"](19,0,null,null,16,"mat-card",[["class","default mat-card"],["id","areaOne"]],null,null,null,s.d,s.a)),l["\u0275did"](20,49152,null,0,u.a,[],null,null),(t()(),l["\u0275eld"](21,0,null,0,2,"mat-card-title",[["class","m-0 mat-card-title"]],null,null,null,null,null)),l["\u0275did"](22,16384,null,0,u.i,[],null,null),(t()(),l["\u0275ted"](-1,null,["Define your steps"])),(t()(),l["\u0275eld"](24,0,null,0,11,"mat-card-content",[["class","mat-card-content"]],null,null,null,null,null)),l["\u0275did"](25,16384,null,0,u.d,[],null,null),(t()(),l["\u0275eld"](26,0,null,null,9,"pre",[],null,null,null,null,null)),(t()(),l["\u0275ted"](-1,null,["        "])),(t()(),l["\u0275eld"](28,0,null,null,6,"code",[],[[4,"display",null]],null,null,null,null)),(t()(),l["\u0275ted"](29,null,["steps = ","\n        "])),l["\u0275pod"](30,{title:0,content:1,target:2,placement:3,xOffset:4}),l["\u0275pod"](31,{title:0,content:1,target:2,placement:3,xOffset:4}),l["\u0275pad"](32,2),l["\u0275pod"](33,{id:0,showPrevButton:1,steps:2}),l["\u0275pid"](0,h.JsonPipe,[]),(t()(),l["\u0275ted"](-1,null,["\n        "])),(t()(),l["\u0275eld"](36,0,null,null,10,"div",[["fxFlex","100"],["fxFlex.gt-sm","33"],["fxFlex.sm","50"]],null,null,null,null,null)),l["\u0275did"](37,671744,null,0,r.b,[l.ElementRef,a.j,a.e,r.j,a.f],{fxFlex:[0,"fxFlex"],"fxFlex.sm":[1,"fxFlex.sm"],"fxFlex.gt-sm":[2,"fxFlex.gt-sm"]},null),(t()(),l["\u0275eld"](38,0,null,null,8,"mat-card",[["class","default mat-card"],["id","areaTwo"]],null,null,null,s.d,s.a)),l["\u0275did"](39,49152,null,0,u.a,[],null,null),(t()(),l["\u0275eld"](40,0,null,0,2,"mat-card-title",[["class","mat-card-title"]],null,null,null,null,null)),l["\u0275did"](41,16384,null,0,u.i,[],null,null),(t()(),l["\u0275ted"](-1,null,["Initialize tour"])),(t()(),l["\u0275eld"](43,0,null,0,3,"mat-card-content",[["class","mat-card-content"]],null,null,null,null,null)),l["\u0275did"](44,16384,null,0,u.d,[],null,null),(t()(),l["\u0275eld"](45,0,null,null,1,"code",[],[[4,"display",null]],null,null,null,null)),(t()(),l["\u0275ted"](-1,null,[" hopscotch.startTour(this.steps) "]))],function(t,e){t(e,1,0,"row wrap"),t(e,3,0,"100","50","33"),t(e,15,0,"primary"),t(e,18,0,"100","50","33"),t(e,37,0,"100","50","33")},function(t,e){t(e,14,0,l["\u0275nov"](e,15).disabled||null,"NoopAnimations"===l["\u0275nov"](e,15)._animationMode),t(e,28,0,"block");var n=l["\u0275unv"](e,29,0,l["\u0275nov"](e,34).transform(t(e,33,0,"demo-tour",!0,t(e,32,0,t(e,30,0,"Step one","This is step description.","areaOne","left",10),t(e,31,0,"Step Two","This is step description.","areaTwo","left",15)))));t(e,29,0,n),t(e,45,0,"block")})}function w(t){return l["\u0275vid"](0,[(t()(),l["\u0275eld"](0,0,null,null,1,"app-app-tour",[],null,null,null,x,b)),l["\u0275did"](1,245760,null,0,g,[v.b],null,null)],function(t,e){t(e,1,0)},null)}var y=l["\u0275ccf"]("app-app-tour",g,w,{},{},[]),S=n("Fzqc"),C=n("Wf4p"),T=n("ZYjt"),k=n("dWZg"),O=n("hUWP"),E=n("3pJQ"),N=n("V9q+"),P=n("ZYCi"),B={title:"User Tour"};n.d(e,"AppTourModuleNgFactory",function(){return A});var A=l["\u0275cmf"](o,[],function(t){return l["\u0275mod"]([l["\u0275mpd"](512,l.ComponentFactoryResolver,l["\u0275CodegenComponentFactoryResolver"],[[8,[i.a,y]],[3,l.ComponentFactoryResolver],l.NgModuleRef]),l["\u0275mpd"](4608,h.NgLocalization,h.NgLocaleLocalization,[l.LOCALE_ID,[2,h["\u0275angular_packages_common_common_a"]]]),l["\u0275mpd"](5120,l.APP_BOOTSTRAP_LISTENER,function(t,e){return[a.k(t,e)]},[h.DOCUMENT,l.PLATFORM_ID]),l["\u0275mpd"](1073742336,h.CommonModule,h.CommonModule,[]),l["\u0275mpd"](1073742336,S.a,S.a,[]),l["\u0275mpd"](1073742336,C.n,C.n,[[2,C.f],[2,T.f]]),l["\u0275mpd"](1073742336,u.g,u.g,[]),l["\u0275mpd"](1073742336,k.b,k.b,[]),l["\u0275mpd"](1073742336,C.y,C.y,[]),l["\u0275mpd"](1073742336,d.c,d.c,[]),l["\u0275mpd"](1073742336,a.c,a.c,[]),l["\u0275mpd"](1073742336,r.i,r.i,[]),l["\u0275mpd"](1073742336,O.d,O.d,[]),l["\u0275mpd"](1073742336,E.a,E.a,[]),l["\u0275mpd"](1073742336,N.a,N.a,[[2,a.h],l.PLATFORM_ID]),l["\u0275mpd"](1073742336,P.t,P.t,[[2,P.y],[2,P.p]]),l["\u0275mpd"](1073742336,o,o,[]),l["\u0275mpd"](1024,P.j,function(){return[[{path:"",component:g,data:B}]]},[])])})},lzlj:function(t,e,n){"use strict";n.d(e,"a",function(){return o}),n.d(e,"d",function(){return i}),n.d(e,"b",function(){return r}),n.d(e,"c",function(){return a});var l=n("CcnG"),o=(n("FVSy"),n("Fzqc"),n("Wf4p"),n("ZYjt"),l["\u0275crt"]({encapsulation:2,styles:[".mat-card{transition:box-shadow 280ms cubic-bezier(.4,0,.2,1);display:block;position:relative;padding:16px;border-radius:4px}.mat-card .mat-divider-horizontal{position:absolute;left:0;width:100%}[dir=rtl] .mat-card .mat-divider-horizontal{left:auto;right:0}.mat-card .mat-divider-horizontal.mat-divider-inset{position:static;margin:0}[dir=rtl] .mat-card .mat-divider-horizontal.mat-divider-inset{margin-right:0}@media (-ms-high-contrast:active){.mat-card{outline:solid 1px}}.mat-card-actions,.mat-card-content,.mat-card-subtitle{display:block;margin-bottom:16px}.mat-card-title{display:block;margin-bottom:8px}.mat-card-actions{margin-left:-8px;margin-right:-8px;padding:8px 0}.mat-card-actions-align-end{display:flex;justify-content:flex-end}.mat-card-image{width:calc(100% + 32px);margin:0 -16px 16px -16px}.mat-card-footer{display:block;margin:0 -16px -16px -16px}.mat-card-actions .mat-button,.mat-card-actions .mat-raised-button{margin:0 8px}.mat-card-header{display:flex;flex-direction:row}.mat-card-header .mat-card-title{margin-bottom:12px}.mat-card-header-text{margin:0 16px}.mat-card-avatar{height:40px;width:40px;border-radius:50%;flex-shrink:0;object-fit:cover}.mat-card-title-group{display:flex;justify-content:space-between}.mat-card-sm-image{width:80px;height:80px}.mat-card-md-image{width:112px;height:112px}.mat-card-lg-image{width:152px;height:152px}.mat-card-xl-image{width:240px;height:240px;margin:-8px}.mat-card-title-group>.mat-card-xl-image{margin:-8px 0 8px}@media (max-width:599px){.mat-card-title-group{margin:0}.mat-card-xl-image{margin-left:0;margin-right:0}}.mat-card-content>:first-child,.mat-card>:first-child{margin-top:0}.mat-card-content>:last-child:not(.mat-card-footer),.mat-card>:last-child:not(.mat-card-footer){margin-bottom:0}.mat-card-image:first-child{margin-top:-16px;border-top-left-radius:inherit;border-top-right-radius:inherit}.mat-card>.mat-card-actions:last-child{margin-bottom:-8px;padding-bottom:0}.mat-card-actions .mat-button:first-child,.mat-card-actions .mat-raised-button:first-child{margin-left:0;margin-right:0}.mat-card-subtitle:not(:first-child),.mat-card-title:not(:first-child){margin-top:-4px}.mat-card-header .mat-card-subtitle:not(:first-child){margin-top:-8px}.mat-card>.mat-card-xl-image:first-child{margin-top:-8px}.mat-card>.mat-card-xl-image:last-child{margin-bottom:-8px}"],data:{}}));function i(t){return l["\u0275vid"](2,[l["\u0275ncd"](null,0),l["\u0275ncd"](null,1)],null,null)}var r=l["\u0275crt"]({encapsulation:2,styles:[],data:{}});function a(t){return l["\u0275vid"](2,[l["\u0275ncd"](null,0),(t()(),l["\u0275eld"](1,0,null,null,1,"div",[["class","mat-card-header-text"]],null,null,null,null,null)),l["\u0275ncd"](null,1),l["\u0275ncd"](null,2)],null,null)}}}]);