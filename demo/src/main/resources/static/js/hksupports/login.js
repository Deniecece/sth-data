var loginAndRegDialog;
$(function() {
	loginAndRegDialog = $("#loginAndRegDialog");	
	loginAndRegDialog.dialog({
		closable : false,
		modal : true,
		buttons : [ 
			{
				text : '注册',
				iconCls:'icon-edit',
				handler : function() {
					 alert('注册');
				}
			}, {
				text : '登陆',
				iconCls:'icon-ok',
				handler : function() {	
					window.location='show.html';
				}
			}
		]
	});
});