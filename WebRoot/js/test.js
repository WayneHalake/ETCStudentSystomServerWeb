/* 
 弹出窗口定位到浏览器中间 
 1. show(options{ 
 height:高度 
 width:宽度 
 speed:渐显时间 默认0 
 container:包含的html内容的jquery对象 
 model:是否是模态窗口，默认true，模态对话框就是在弹层下面在覆盖遮罩层，参考上篇文章Overlay实现 
 }) 
 2. close(speed:淡出时间 默认0) 
 */
Q.Panel = function() {
	var self = this;
	self._resetPosition = function() {
		self._container.css("top", self._getTop());
		self._container.css("left", self._getLeft());
	};
	self._getTop = function() {
		return Q.bom.scrollY() + (Q.bom.windowHeight() - self._options.height)
				/ 2;
	};
	self._getLeft = function() {
		return (Q.dom.pageWidth() - self._options.width) / 2;
	};
	self.show = function(options) {
		self._options = $.extend( {
			width : 350,
			height : 200,
			opacity : 0.5,
			model : true,
			speed : 0
		}, options || {});
		self._container = self._options.container;
		var css = {
			'width' : self._options.width,
			'height' : self._options.height,
			'z-index' : Q.Overlay.zindex,
			'position' : 'absolute',
			'left' : self._getLeft(),
			'top' : self._getTop(),
			'display' : 'none'
		};
		self._container.css(css);
		if (self._options.model) {
			self._overlay = new Q.Overlay(self._options.opacity);
			self._overlay.show();
		}
		$(window).scroll(self._resetPosition);
		$(window).resize(self._resetPosition);
		$(document.body).append(self._container);
		self._container.fadeIn(self._options.speed);
		Q.Overlay.zindex++; //没弹出一次就递增，防止多个弹层重叠 
	};
	self.close = function(speed) {
		$(window).unbind('resize', self._resetPosition);
		$(window).unbind('scroll', self._resetPosition);
		self._container.fadeOut(speed || 0, function() {
			self._container.remove();
			if (self._options.model) {
				self._overlay.close();
			}
		});
	};
};