<div id="teacher_edit">
    <div>
        <input id="teacher_edit_id" hidden value="${teacher.id}" />
        <label for="email">教师姓名:</label>
        <input id="teacher_edit_teachername" class="easyui-textbox" value="${teacher.teachername}" />
        <br>
        <a id="teacher_edit_submit" href="#" class="easyui-linkbutton" >提交</a>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $('#teacher_edit_submit').linkbutton({
            onClick: function() {
                const id = $("#teacher_edit_id").val();
                const teachername = $("#teacher_edit_teachername").val();
                if (teachername === "") {
                    $.messager.alert('警告','姓名不能为空');
                }
                $.ajax({
                    type: 'POST',
                    url: "/api/teacher/update",
                    contentType:'application/json', //需要加contentType
                    crossDomain: true,// 开启跨域支持
                    data: JSON.stringify({
                        id: id,
                        teachername: teachername
                    }), //数据对象必须使用JSON.stringify转换成字符串，直接传对象会有问题
                    dataType: 'json', // 服务器响应的数据类型
                    async: false, // 关闭异步
                    success: function(rec) {
                        $.messager.show({
                            title:'提示',
                            msg:'修改教师成功',
                            timeout:2000,
                            showType:'slide'
                        });
                        $('#teacher_list_edit_dialog').dialog('close');
                    }
                });
            }

        });

    });
</script>