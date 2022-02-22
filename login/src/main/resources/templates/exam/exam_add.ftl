<div id="exam_add">
    <div>
        <label for="email">考试id:</label>
        <input id="exam_add_lessonid" type="text" class="easyui-numberbox" />
        <a id="exam_add_submit" href="#" class="easyui-linkbutton" >提交</a>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $('#exam_add_submit').linkbutton({
            onClick: function() {
                const lessonid = $("#exam_add_lessonid").val();
                if (lessonid === "") {
                    $.messager.alert('警告','课程id不能为空');
                }
                $.ajax({
                    type: 'POST',
                    url: "/api/exam/add",
                    contentType:'application/json', //需要加contentType
                    crossDomain: true,// 开启跨域支持
                    data: JSON.stringify({
                       lessonid: lessonid,
                    }), //数据对象必须使用JSON.stringify转换成字符串，直接传对象会有问题
                    dataType: 'json', // 服务器响应的数据类型
                    async: false, // 关闭异步
                    success: function(rec) {
                        $.messager.show({
                            title:'提示',
                            msg:'新增考试成功',
                            timeout:2000,
                            showType:'slide'
                        });
                        $('#exam_list_add_dialog').dialog('close');
                    }
                });
            }

        });

    });
</script>