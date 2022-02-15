<div id="selection_add">
    <div>
        <label for="email">序号:</label>
        <input id="selection_add_id" class="easyui-textbox" />
        <br>
        <label for="email">学号:</label>
        <input id="selection_add_stuid" class="easyui-textbox" />
        <br>
        <label for="email">课程编号:</label>
        <input id="selection_add_lesid" class="easyui-textbox" />
        <br>
        <label for="email">考试得分:</label>
        <input id="selection_add_tescore" class="easyui-textbox" />
        <a id="selection_add_submit" href="#" class="easyui-linkbutton" >提交</a>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $('#selection_add_submit').linkbutton({
            onClick: function() {
                const id = $("#selection_add_id").val();
                const stuid = $("#selection_add_stuid").val();
                const lesid = $("#selection_add_lesid").val();
                const tescore = $("#selection_add_tescore").val();
                if (id === "") {
                    $.messager.alert('警告','序号不能为空');
                } else if (stuid === "") {
                    $.messager.alert('警告','学号不能为空');
                } else if(lesid === "") {
                    $.messager.alert('警告','课程编号不能为空')
                } else if(tescore === "") {
                    $.messager.alert('警告','考试得分不能为空')
                }
                $.ajax({
                    type: 'POST',
                    url: "/api/selection/add",
                    contentType:'application/json', //需要加contentType
                    crossDomain: true,// 开启跨域支持
                    data: JSON.stringify({
                        id: id,
                        stuid: stuid,
                        lesid: lesid,
                        tescore: tescore,
                    }), //数据对象必须使用JSON.stringify转换成字符串，直接传对象会有问题
                    dataType: 'json', // 服务器响应的数据类型
                    async: false, // 关闭异步
                    success: function(rec) {
                        $.messager.show({
                            title:'提示',
                            msg:'新增选课成功',
                            timeout:2000,
                            showType:'slide'
                        });
                        $('#selection_list_add_dialog').dialog('close');
                    }
                });
            }

        });

    });
</script>