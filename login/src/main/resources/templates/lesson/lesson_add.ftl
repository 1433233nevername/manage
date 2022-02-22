<div id="lesson_add">
    <div>
        <label for="email">课程名称:</label>
        <input id="lesson_add_lename" class="easyui-textbox" />
        <br>
        <label for="email">课程id:</label>
        <input id="lesson_add_lenumber" type="text" class="easyui-numberbox" />
        <br>
        <label for="email">教师编号:</label>
        <input id="lesson_add_teachid" type="text" class="easyui-numberbox" />
        <br>
        <label for="email">课时:</label>
        <input id="lesson_add_letime" type="text" class="easyui-numberbox" />
        <a id="lesson_add_submit" href="#" class="easyui-linkbutton" >提交</a>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $('#lesson_add_submit').linkbutton({
            onClick: function() {
                const lename = $("#lesson_add_lename").val();
                const lenumber = $("#lesson_add_lenumber").val();
                const teachid = $("#lesson_add_teachid").val();
                const letime = $("#lesson_add_letime").val();
                if (lename === "") {
                    $.messager.alert('警告','课程名称不能为空');
                } else if(lenumber === "") {
                    $.messager.alert('警告','课程编号不能为空')
                } else if(teachid === "") {
                    $.messager.alert('警告','教师id不能为空')
                } else if(letime === "") {
                    $.messager.alert('警告','课时不能为空')
                }
                $.ajax({
                    type: 'POST',
                    url: "/api/lesson/add",
                    contentType:'application/json', //需要加contentType
                    crossDomain: true,// 开启跨域支持
                    data: JSON.stringify({
                        lename: lename,
                        lenumber: lenumber,
                        teachid: teachid,
                        letime: letime
                    }), //数据对象必须使用JSON.stringify转换成字符串，直接传对象会有问题
                    dataType: 'json', // 服务器响应的数据类型
                    async: false, // 关闭异步
                    success: function(rec) {
                        $.messager.show({
                            title:'提示',
                            msg:'新增课程成功',
                            timeout:2000,
                            showType:'slide'
                        });
                        $('#lesson_list_add_dialog').dialog('close');
                    }
                });
            }

        });

    });
</script>