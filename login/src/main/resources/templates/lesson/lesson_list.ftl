<div id="lesson_list_center_content"></div>
<div id="lesson_list_add_dialog"></div>
<div id="lesson_list_edit_dialog"></div>
<script type="text/javascript">
    $(function(){
        $('#lesson_list_center_content').datagrid({
            singleSelect: true,
            url:'/api/lesson/list',
            toolbar: [{
                iconCls: 'icon-add',
                handler: function(){
                    $('#lesson_list_add_dialog').dialog({
                        title: '新增课程',
                        width: 400,
                        height: 200,
                        href: '/web/lesson/add',
                        modal: true,
                        onClose: function () {
                            $('#lesson_list_center_content').datagrid('reload');
                        }
                    });
                }
            },'-',{
                iconCls: 'icon-edit',
                handler: function(){
                    const selectedRow = $('#lesson_list_center_content').datagrid('getSelected');
                    if (selectedRow === undefined || selectedRow === null) {
                        $.messager.alert('警告','请先选中一行数据');
                        return;
                    }
                    const id = selectedRow.id;
                    $('#lesson_list_edit_dialog').dialog({
                        title: '编辑学生',
                        width: 400,
                        height: 200,
                        href: '/web/lesson/edit?id=' + id,
                        modal: true,
                        onClose: function () {
                            $('#lesson_list_center_content').datagrid('reload');
                        }
                    });
                }
            },'-',{
                iconCls: 'icon-remove',
                handler: function(){
                    const selectedRow = $('#lesson_list_center_content').datagrid('getSelected');
                    if (selectedRow === undefined || selectedRow === null) {
                        $.messager.alert('警告','请先选中一行数据');
                        return;
                    }
                    const id = selectedRow.id;
                    $.ajax({
                        type: 'POST',
                        url: "/api/lesson/delete",
                        contentType:'application/json', //需要加contentType
                        crossDomain: true,// 开启跨域支持
                        data: JSON.stringify({
                            id: id
                        }), //数据对象必须使用JSON.stringify转换成字符串，直接传对象会有问题
                        dataType: 'json', // 服务器响应的数据类型
                        async: false, // 关闭异步
                        success: function(rec) {
                            console.log(rec);
                            if(rec.code === '0') {
                                $.messager.show({
                                    title: '提示',
                                    msg: '删除课程成功',
                                    timeout: 2000,
                                    showType: 'slide'
                                });
                            } else {
                                $.messager.alert({
                                    title: '警告',
                                    msg: rec.msg,
                                    timeout: 2000,
                                })
                            }
                            $('#lesson_list_center_content').datagrid('reload');
                        }
                    });
                }
            }],
            columns:[[
                {field:'id',title:'序号',width:100},
                {field:'lename',title:'课程名字',width:100},
                {field:'lenumber',title:'课程id',width:100},
                {field:'teachid',title:'教师编号',width:100},
                {field:'letime',title:'课时',width:100},
                {field:'cretime',title:'创建时间',width:200}
            ]]
        });
    })
</script>