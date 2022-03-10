<div id="teacher_add">
    <div>
        <label for="email">序号:</label>
        <input id="teacher_add_id" type="text" class="easyui-numberbox" />
        <br>
        <label for="email">教师id:</label>
        <input id="teacher_add_teachid" type="text" class="easyui-numberbox" />
        <br>
        <label for="email">教师姓名:</label>
        <input id="teacher_add_teachername" class="easyui-textbox" />
        <a id="teacher_add_submit" href="#" class="easyui-linkbutton" >提交</a>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $('#teacher_add_submit').linkbutton({
            onClick: function() {
                const id = $("#teacher_add_id").val();
                const teachid = $("#teacher_add_teachid").val();
                const teachername = $("#teacher_add_teachername").val();
                if (id === "") {
                    $.messager.alert('警告','序号不能为空');
                } else if (teachid === "") {
                    $.messager.alert('警告','教师id不能为空');
                } else if(teachername === "") {
                    $.messager.alert('警告','姓名不能为空')
                }
                $.ajax({
                    type: 'POST',
                    url: "/api/teacher/add",
                    contentType:'application/json', //需要加contentType
                    crossDomain: true,// 开启跨域支持
                    data: JSON.stringify({
                        id: id,
                        teachid: teachid,
                        teachername: teachername,
                    }), //数据对象必须使用JSON.stringify转换成字符串，直接传对象会有问题
                    dataType: 'json', // 服务器响应的数据类型
                    async: false, // 关闭异步
                    success: function(rec) {
                        console.log(rec);
                        if(rec.code === '0') {
                            $.messager.show({
                                title: '提示',
                                msg: '新增教师成功',
                                timeout: 2000,
                                showType: 'slide'
                            });
                        } else {
                            $.messager.alert({
                               title:'提示',
                               msg:rec.msg,
                               timeout:2000,
                            });
                        }
                        $('#teacher_list_add_dialog').dialog('close');
                    }
                });
            }

        });

    });
</script>