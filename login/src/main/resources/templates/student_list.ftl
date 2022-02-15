<div id="student_list_center_content"></div>
<div id="student_list_add_dialog"></div>
<div id="student_list_edit_dialog"></div>
<script type="text/javascript">
    $(function(){
        $('#student_list_center_content').datagrid({
            singleSelect: true,
            url:'/api/student/list',
            toolbar: [{
                iconCls: 'icon-add',
                handler: function(){
                    $('#student_list_add_dialog').dialog({
                        title: '新增学生',
                        width: 400,
                        height: 200,
                        href: '/student/add',
                        modal: true,
                        onClose: function () {
                            $('#student_list_center_content').datagrid('reload');
                        }
                    });
                }
            },'-',{
                iconCls: 'icon-edit',
                handler: function(){
                    const selectedRow = $('#student_list_center_content').datagrid('getSelected');
                    if (selectedRow === undefined || selectedRow === null) {
                        $.messager.alert('警告','请先选中一行数据');
                        return;
                    }
                    const id = selectedRow.id;
                    $('#student_list_edit_dialog').dialog({
                        title: '编辑学生',
                        width: 400,
                        height: 200,
                        href: '/student/edit?id=' + id,
                        modal: true,
                        onClose: function () {
                            $('#student_list_center_content').datagrid('reload');
                        }
                    });
                }
            },'-',{
                iconCls: 'icon-remove',
                handler: function(){
                    const selectedRow = $('#student_list_center_content').datagrid('getSelected');
                    if (selectedRow === undefined || selectedRow === null) {
                        $.messager.alert('警告','请先选中一行数据');
                        return;
                    }
                    const id = selectedRow.id;
                    $.ajax({
                        type: 'POST',
                        url: "/api/student/delete",
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
                                msg:'删除学生成功',
                                timeout:2000,
                                showType:'slide'
                            });
                            $('#student_list_center_content').datagrid('reload');
                        }
                    });
                }
            }],
            columns:[[
                {field:'name',title:'姓名',width:100},
                {field:'number',title:'学号',width:100},
                {field:'age',title:'年龄',width:100},
                {field:'entime',title:'入学时间',width:100},
                {field:'retime',title:'注册时间',width:200}
            ]]
        });
    })
</script>