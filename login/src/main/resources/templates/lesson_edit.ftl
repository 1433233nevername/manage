<div id="lesson_edit">
    <div>
        <input id="lesson_edit_id" hidden value="${lesson.id}" />
        <label for="email">课程名字:</label>
        <input id="lesson_edit_lename" class="easyui-textbox" value="${lesson.lename}" />
        <br>
        <label for="email">教师编号:</label>
        <input id="lesson_edit_teachid" class="easyui-textbox" value="${lesson.teachid}" />
        <br>
        <label for="email">课时:</label>
        <input id="lesson_edit_letime" class="easyui-textbox" value="${lesson.letime}" />
        <a id="lesson_edit_submit" href="#" class="easyui-linkbutton" >提交</a>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $('#lesson_edit_submit').linkbutton({
            onClick: function() {
                const lename = $("#lesson_edit_lename").val();
                const id = $("#lesson_edit_id").val();
                const teachid = $("#lesson_edit_teachid").val();
                const letime = $("#lesson_edit_letime").val();
                if (lename === "") {
                    $.messager.alert('警告','姓名不能为空');
                } if (teachid === "") {
                    $.messager.alert('警告','教师编号不能为空');
                } if (letime === "") {
                    $.messager.alert('警告','课时不能为空');
                }
                $.ajax({
                    type: 'POST',
                    url: "/api/lesson/update",
                    contentType:'application/json', //需要加contentType
                    crossDomain: true,// 开启跨域支持
                    data: JSON.stringify({
                        lename: lename,
                        id: id,
                        teachid: teachid,
                        letime: letime
                    }), //数据对象必须使用JSON.stringify转换成字符串，直接传对象会有问题
                    dataType: 'json', // 服务器响应的数据类型
                    async: false, // 关闭异步
                    success: function(rec) {
                        $.messager.show({
                            title:'提示',
                            msg:'修改课程成功',
                            timeout:2000,
                            showType:'slide'
                        });
                        $('#lesson_list_edit_dialog').dialog('close');
                    }
                });
            }

        });

    });
</script>