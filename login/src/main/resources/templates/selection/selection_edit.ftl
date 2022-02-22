<div id="selection_edit">
    <div>
        <input id="selection_edit_id" hidden value="${selection.id}" />
        <label for="email">测试分数:</label>
        <input id="selection_edit_tescore" type="text" class="easyui-numberbox" value="${selection.tescore}" />
        <br>
        <label for="email">学生id:</label>
        <input id="selection_edit_stuid" type="text" class="easyui-numberbox" value="${selection.stuid}" />
        <a id="selection_edit_submit" href="#" class="easyui-linkbutton" >提交</a>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $('#selection_edit_submit').linkbutton({
            onClick: function() {
                const id = $("#selection_edit_id").val();
                const tescore = $("#selection_edit_tescore").val();
                const stuid = $("#selection_edit_stuid").val();
                if (tescore === "") {
                    $.messager.alert('警告','成绩不能为空');
                }
                $.ajax({
                    type: 'POST',
                    url: "/api/selection/update",
                    contentType:'application/json', //需要加contentType
                    crossDomain: true,// 开启跨域支持
                    data: JSON.stringify({
                        id: id,
                        tescore: tescore,
                        stuid: stuid
                    }), //数据对象必须使用JSON.stringify转换成字符串，直接传对象会有问题
                    dataType: 'json', // 服务器响应的数据类型
                    async: false, // 关闭异步
                    success: function(rec) {
                        $.messager.show({
                            title:'提示',
                            msg:'修改选课信息成功',
                            timeout:2000,
                            showType:'slide'
                        });
                        $('#selection_list_edit_dialog').dialog('close');
                    }
                });
            }

        });

    });
</script>