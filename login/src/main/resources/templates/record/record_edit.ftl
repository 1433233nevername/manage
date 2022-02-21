<div id="record_edit">
    <div>
        <input id="record_edit_id" hidden value="${record.id}" />
        <label for="email">考试id:</label>
        <input id="record_edit_examid" class="easyui-textbox" value="${record.examid}" />
        <br>
        <label for="email">学生id:</label>
        <input id="record_edit_studentid" class="easyui-textbox" value="${record.studentid}" />
        <br>
        <label for="email">分数:</label>
        <input id="record_edit_score" class="easyui-textbox" value="${record.score}" />
        <a id="record_edit_submit" href="#" class="easyui-linkbutton" >提交</a>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $('#record_edit_submit').linkbutton({
            onClick: function() {
                const id = $("#record_edit_id").val();
                const examid = $("#record_edit_examid").val();
                const studentid = $("#record_edit_studentid").val();
                const score = $("#record_edit_score").val();
                if (examid === "") {
                    $.messager.alert('警告','考试id不能为空');
                } if (studentid === "") {
                    $.messager.alert('警告','学生id不能为空');
                }  if (score === "") {
                    $.messager.alert('警告','分数不能为空');
                }
                $.ajax({
                    type: 'POST',
                    url: "/api/record/update",
                    contentType:'application/json', //需要加contentType
                    crossDomain: true,// 开启跨域支持
                    data: JSON.stringify({
                        id: id,
                        examid: examid,
                        studentid: studentid,
                        score: score
                    }), //数据对象必须使用JSON.stringify转换成字符串，直接传对象会有问题
                    dataType: 'json', // 服务器响应的数据类型
                    async: false, // 关闭异步
                    success: function(rec) {
                        $.messager.show({
                            title:'提示',
                            msg:'修改信息成功',
                            timeout:2000,
                            showType:'slide'
                        });
                        $('#record_list_edit_dialog').dialog('close');
                    }
                });
            }

        });

    });
</script>