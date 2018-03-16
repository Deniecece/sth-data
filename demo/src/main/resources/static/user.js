 $(function(){
       $('#dg').datagrid({  
		    url:'/users',
		    columns:[[
			    	{field:'id',hidden:true},
			    	{field:'username',title:'姓名',width:100},
			    	{field:'sex',title:'性别',width:100},
			    	{field:'password',title:'密码',width:100}
		    	]],    
		    //添加一个工具栏
		    toolbar: [{
				iconCls: 'icon-add',
				text:'新增',
				handler: function(){
					//调用函数打开保存页面
					saveUser();
				}
			},'-',{
				iconCls: 'icon-remove',
				text:'删除',
				handler: function(){
					//获取选择的行信息
					var rows = $('#dg').datagrid('getSelections');
					if(rows==0){
						//信息提示框
						$.messager.alert('信息','请选择需要删除的行!');
						return;
					}else{
						$.messager.confirm('信息','是否删除?',function(r){  
						    if (r){  
						    	//执行功能
								deleteUser(rows[0].id);
						    }  
						});
						
				    }
				}
			},'-',{
				iconCls: 'icon-edit',
				text:'更新',
				handler: function(){
					//获取选择的行信息
					var rows = $('#dg').datagrid('getSelections');
					if(rows==0){
						//信息提示框
						$.messager.alert('信息','请选择需要更新的行!');
						return;
					}
					//调用函数打开更新页面
					updateUser(rows[0].id);
				}
			}]
		}); 
   });
//---------------------------删除用户的函数----------------------------------------------------------------------------
   function deleteUser(par){
	   var url='user/'+par;
	   var params={id:par}
	  $.post(url,params,function(data){
		  $.messager.show({//提示滑动窗体
				title:'信息',
				msg:'删除成功',
				timeout:2000,
				showType:'slide'
			});
		  //我们需要重新加载数据
		  $('#dg').datagrid('reload');
	  });
   }
//---------------------------保存用户的函数----------------------------------------------------------------------------
function saveUser(){
	//使用dialog形式打开页面
	$('#dd').dialog({  
	    title: '添加用户',  
	    width: 400,  
	    height: 200,  
	    closed: false,  
	    cache: false,  
	    href: 'savePage',  
	    modal: true ,
	    buttons:[{
			text:'保存',
			iconCls: 'icon-save',
			handler:function(){
				//保存的功能--提交form
				$('#userSaveForm').form({  
				    url:'/saveUser',  
				    onSubmit: function(){  
				    },  
				    success:function(data){  
				    	//我们需要重新加载数据
						 $('#dg').datagrid('reload');
				    	 $.messager.show({//提示滑动窗体
								title:'信息',
								msg:'保存成功',
								timeout:2000,
								showType:'slide'
						});
				    }  
				});
				$('#userSaveForm').submit();
			}
		},{
			text:'取消',
			iconCls: 'icon-cancel',
			handler:function(){
				$('#dd').window('close');
			}
		}]
	});
}
//---------------------------更新用户的函数----------------------------------------------------------------------------
function updateUser(par){
	$('#dd').dialog({  
	    title: '修改用户',  
	    width: 400,  
	    height: 200,  
	    closed: false,  
	    cache: false,  
	    href: 'updatePage',  
	    modal: true,
	    buttons:[{
			text:'更新',
			iconCls: 'icon-edit',
			handler:function(){
				//保存的功能--提交form
				$('#updateUserForm').form({  
				    url:'updateUser',  
				    onSubmit: function(){  
				    },  
				    success:function(data){  
				    	//我们需要重新加载数据
						 $('#dg').datagrid('reload');
				    	 $.messager.show({//提示滑动窗体
								title:'信息',
								msg:'更新成功',
								timeout:2000,
								showType:'slide'
						});
				    }  
				});
				$('#updateUserForm').submit();
			}
		},{
			text:'取消',
			iconCls: 'icon-cancel',
			handler:function(){
				$('#dd').window('close');
			}
		}],
		onLoad:function(){
			//完成数据的加载
			var url='data/'+par;
			var params={id:par};
			$.post(url,params,function(json){
				//使用循环完成一个赋值的过程{key:value,key:value}
				//$('#key').attr('value',value);
				for(var key in json){
					var p = '#'+key;
					$(p).attr('value',json[key]);
				}				
			},'json');
			
		}
	});
	$('#dd').dialog('refresh');
}
