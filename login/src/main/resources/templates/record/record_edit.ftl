<div id="record_edit">
    <div>
        <input id="record_edit_id" hidden value="${record.id}" />
        <label for="email">考试id:</label>
        <input id="record_edit_exam_id" class="easyui-textbox" value="${record.exam_id}" />
        <br>
        <label for="email">学生id:</label>
        <input id="record_edit_student_id" class="easyui-textbox" value="${record.student_id}" />
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
                const exam_id = $("#record_edit_exam_id").val();
                const student_id = $("#record_edit_student_id").val();
                const score = $("#record_edit_score").val();
                if (exam_id === "") {
                    $.messager.alert('警告','考试id不能为空');
                } if (student_id === "") {
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
                        exam_id: exam_id,
                        student_id: student_id,
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