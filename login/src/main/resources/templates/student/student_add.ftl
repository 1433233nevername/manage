<div id="student_add">
    <div>
        <label for="email">序号:</label>
        <input id="student_add_id" type="text" class="easyui-numberbox" />
        <br>
        <label for="email">姓名:</label>
        <input id="student_add_name" class="easyui-numberbox" />
        <br>
        <label for="email">学号:</label>
        <input id="student_add_number" type="text" class="easyui-numberbox" />
        <br>
        <label for="email">年龄:</label>
        <input id="student_add_age" type="text" class="easyui-numberbox" />
        <br>
        <label for="email">入学时间:</label>
        <input id="student_add_entime" class="easyui-textbox" />
        <a id="student_add_submit" href="#" class="easyui-linkbutton" >提交</a>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $('#student_add_submit').linkbutton({
            onClick: function() {
                const id = $("#student_add_id").val();
                const name = $("#student_add_name").val();
                const number = $("#student_add_number").val();
                const age = $("#student_add_age").val();
                const entime = $("#student_add_entime").val();
                if (id === "") {
                    $.messager.alert('警告','序号不能为空');
                } else if (name === "") {
                    $.messager.alert('警告','姓名不能为空');
                } else if(number === "") {
                    $.messager.alert('警告','学号不能为空')
                } else if(age === "") {
                    $.messager.alert('警告','年龄不能为空')
                } else if(entime === "") {
                    $.messager.alert('警告','入学时间不能为空')
                }
                $.ajax({
                    type: 'POST',
                    url: "/api/student/add",
                    contentType:'application/json', //需要加contentType
                    crossDomain: true,// 开启跨域支持
                    data: JSON.stringify({
                        id: id,
                        name: name,
                        number: number,
                        age: age,
                        entime: entime,
                    }), //数据对象必须使用JSON.stringify转换成字符串，直接传对象会有问题
                    dataType: 'json', // 服务器响应的数据类型
                    async: false, // 关闭异步
                    success: function(rec) {
                        $.messager.show({
                            title:'提示',
                            msg:'新增学生成功',
                            timeout:2000,
                            showType:'slide'
                        });
                        $('#student_list_add_dialog').dialog('close');
                    }
                });
            }

        });

    });
</script>