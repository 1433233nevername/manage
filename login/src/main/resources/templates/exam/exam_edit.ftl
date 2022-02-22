<div id="exam_edit">
    <div>
        <input id="exam_edit_id" hidden value="${exam.id}" />
        <label for="email">考试id:</label>
        <input id="exam_edit_lessonid" type="text" class="easyui-numberbox" value="${exam.lessonid}" />
        <a id="exam_edit_submit" href="#" class="easyui-linkbutton" >提交</a>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $('#exam_edit_submit').linkbutton({
            onClick: function() {
                const lessonid = $("#exam_edit_lessonid").val();
                const id = $("#exam_edit_id").val();
                if (lessonid === "") {
                    $.messager.alert('警告','考试id不能为空');
                }
                $.ajax({
                    type: 'POST',
                    url: "/api/exam/update",
                    contentType:'application/json', //需要加contentType
                    crossDomain: true,// 开启跨域支持
                    data: JSON.stringify({
                        id: id,
                        lessonid: lessonid,
                    }), //数据对象必须使用JSON.stringify转换成字符串，直接传对象会有问题
                    dataType: 'json', // 服务器响应的数据类型
                    async: false, // 关闭异步
                    success: function(rec) {
                        $.messager.show({
                            title:'提示',
                            msg:'修改考试成功',
                            timeout:2000,
                            showType:'slide'
                        });
                        $('#exam_list_edit_dialog').dialog('close');
                    }
                });
            }

        });

    });
</script>