<div id="student_edit">
    <div>
        <input id="student_edit_id" hidden value="${student.id}" />
        <label for="email">姓名:</label>
        <input id="student_edit_name" class="easyui-textbox" value="${student.name}" />
        <br>
        <label for="email">年龄:</label>
        <input id="student_edit_age" type="text" class="easyui-numberbox" value="${student.age}" />
        <a id="student_edit_submit" href="#" class="easyui-linkbutton" >提交</a>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $('#student_edit_submit').linkbutton({
            onClick: function() {
                const name = $("#student_edit_name").val();
                const id = $("#student_edit_id").val();
                const age = $("#student_edit_age").val();
                if (name === "") {
                    $.messager.alert('警告','姓名不能为空');
                } if (name === "") {
                    $.messager.alert('警告','年龄不能为空');
                }
                $.ajax({
                    type: 'POST',
                    url: "/api/student/update",
                    contentType:'application/json', //需要加contentType
                    crossDomain: true,// 开启跨域支持
                    data: JSON.stringify({
                        name: name,
                        id: id,
                        age: age
                    }), //数据对象必须使用JSON.stringify转换成字符串，直接传对象会有问题
                    dataType: 'json', // 服务器响应的数据类型
                    async: false, // 关闭异步
                    success: function(rec) {
                        $.messager.show({
                            title:'提示',
                            msg:'修改学生成功',
                            timeout:2000,
                            showType:'slide'
                        });
                        $('#student_list_edit_dialog').dialog('close');
                    }
                });
            }

        });

    });
</script>