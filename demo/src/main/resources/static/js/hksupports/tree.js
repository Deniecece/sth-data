$(function() {
	$('#tt').tree({
		onClick: function(node){
		        if($('#tt').tree('isLeaf',node.target)){//判断是否是叶子节点
				     if(node.text=='用户信息')
				        addTab(node.text,'user.html');
				     if(node.text=='家庭信息')
					        addTab(node.text,'family.html');
                }
	     },
		data: [{
					text: '基本信息',
					state: 'open',
					children: [
								{text: '用户信息'},
								{text: '家庭信息'}
							 ]
				},{
					text: '招聘信息',
					state: 'closed',
					children: [
								{
									text: 'XXX信息'
								},
								{
									text: 'XXX信息'
								},
								{
									text: 'XXX信息'
								},
								{
									text: 'XXX信息'
								}
							 ]
				}
		     ]
	});
});

function addTab(title,url){				
		if ($('#tab').tabs('exists', title)){
		    $('#tab').tabs('select', title);//如果选择的标题已经存在，那么就切换到这个tabPanel
		} else {			
			$('#tab').tabs('add',{//如果选择的标题没有，那么就创建
				title:title ,
				iconCls:'icon-save',
				closable:true,//激活
				tools:[{
					iconCls:'icon-mini-refresh',
					handler:function(){
						 $('#dg').datagrid('reload');
					}
				}],
				content: '<iframe src="' + url + '" frameborder=0 height=100% width=100% scrolling=no></iframe>'
			})
		};
}