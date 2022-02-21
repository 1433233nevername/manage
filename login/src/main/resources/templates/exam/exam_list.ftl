<div id="exam_list_center_content"></div>
<div id="exam_list_add_dialog"></div>
<div id="exam_list_edit_dialog"></div>
<script type="text/javascript">
    $(function(){
        $('#exam_list_center_content').datagrid({
            singleSelect: true,
            url:'/api/exam/list',
            toolbar: [{
                iconCls: 'icon-add',
                handler: function(){
                    $('#exam_list_add_dialog').dialog({
                        title: '新增考试',
                        width: 400,
                        height: 200,
                        href: '/exam/add',
                        modal: true,
                        onClose: function () {
                            $('#exam_list_center_content').datagrid('reload');
                        }
                    });
                }
            },'-',{
                iconCls: 'icon-edit',
                handler: function(){
                    const selectedRow = $('#exam_list_center_content').datagrid('getSelected');
                    if (selectedRow === undefined || selectedRow === null) {
                        $.messager.alert('警告','请先选中一行数据');
                        return;
                    }
                    const id = selectedRow.id;
                    $('#exam_list_edit_dialog').dialog({
                        title: '编辑考试',
                        width: 400,
                        height: 200,
                        href: '/exam/edit?id=' + id,
                        modal: true,
                        onClose: function () {
                            $('#exam_list_center_content').datagrid('reload');
                        }
                    });
                }
            },'-',{
                iconCls: 'icon-remove',
                handler: function(){
                    const selectedRow = $('#exam_list_center_content').datagrid('getSelected');
                    if (selectedRow === undefined || selectedRow === null) {
                        $.messager.alert('警告','请先选中一行数据');
                        return;
                    }
                    const id = selectedRow.id;
                    $.ajax({
                        type: 'POST',
                        url: "/api/exam/delete",
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
                                msg:'删除考试成功',
                                timeout:2000,
                                showType:'slide'
                            });
                            $('#exam_list_center_content').datagrid('reload');
                        }
                    });
                }
            }],
            columns:[[
                {field:'id',title:'序号',width:100},
                {field:'lessonid',title:'课程id',width:100},
                {field:'creattime',title:'创建时间',width:100}
            ]]
        });
    })
</script>