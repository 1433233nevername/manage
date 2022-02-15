<div id="teacher_list_center_content"></div>
<div id="teacher_list_add_dialog"></div>
<div id="teacher_list_edit_dialog"></div>
<script type="text/javascript">
    $(function(){
        $('#teacher_list_center_content').datagrid({
            singleSelect: true,
            url:'/api/teacher/list',
            toolbar: [{
                iconCls: 'icon-add',
                handler: function(){
                    $('#teacher_list_add_dialog').dialog({
                        title: '新增教师',
                        width: 400,
                        height: 200,
                        href: '/teacher/add',
                        modal: true,
                        onClose: function () {
                            $('#teacher_list_center_content').datagrid('reload');
                        }
                    });
                }
            },'-',{
                iconCls: 'icon-edit',
                handler: function(){
                    const selectedRow = $('#teacher_list_center_content').datagrid('getSelected');
                    if (selectedRow === undefined || selectedRow === null) {
                        $.messager.alert('警告','请先选中一行数据');
                        return;
                    }
                    const id = selectedRow.id;
                    $('#teacher_list_edit_dialog').dialog({
                        title: '编辑教师',
                        width: 400,
                        height: 200,
                        href: '/teacher/edit?id=' + id,
                        modal: true,
                        onClose: function () {
                            $('#teacher_list_center_content').datagrid('reload');
                        }
                    });
                }
            },'-',{
                iconCls: 'icon-remove',
                handler: function(){
                    const selectedRow = $('#teacher_list_center_content').datagrid('getSelected');
                    if (selectedRow === undefined || selectedRow === null) {
                        $.messager.alert('警告','请先选中一行数据');
                        return;
                    }
                    const id = selectedRow.id;
                    $.ajax({
                        type: 'POST',
                        url: "/api/teacher/delete",
                        contentType:'application/json', //需要加contentType
                        crossDomain: true,// 开启跨域支持
                        data: JSON.stringify({
                            id: id
                        }), //数据对象必须使用JSON.stringify转换成字符串，直接传对象会有问题
                        dataType: 'json', // 服务器响应的数据类型
                        async: false, // 关闭异步
                        success: function(rec) {
                            $.messager.show({
                                title:'提示',
                                msg:'删除老师成功',
                                timeout:2000,
                                showType:'slide'
                            });
                            $('#teacher_list_center_content').datagrid('reload');
                        }
                    });
                }
            }],
            columns:[[
                {field:'id',title:'编号',width:100},
                {field:'teachername',title:'姓名',width:100},
                {field:'time',title:'创建时间',width:200}
            ]]
        });
    })
</script>