<div id="record_add">
    <div>
        <label for="email">考试id:</label>
        <input id="record_add_examid"  type="text" class="easyui-numberbox">
        <br>
        <label for="email">学生id:</label>
        <input id="record_add_studentid" class="easyui-textbox" />
        <br>
        <label for="email">成绩:</label>
        <input id="record_add_score" class="easyui-textbox" />
        <a id="record_add_submit" href="#" class="easyui-linkbutton" >提交</a>
    </div>
</div>
<script type="text/javascript">
    $(function(){
        $('#record_add_submit').linkbutton({
            onClick: function() {
                const examid = $("#record_add_examid").val();
                const studentid = $("#record_add_studentid").val();
                const score = $("#record_add_score").val();
                if (examid === "") {
                    $.messager.alert('警告','考试id不能为空');
                } else if (studentid === "") {
                    $.messager.alert('警告','学生id姓名不能为空');
                } else if(score === "") {
                    $.messager.alert('警告','分数不能为空')
                }
                $.ajax({
                    type: 'POST',
                    url: "/api/record/add",
                    contentType:'application/json', //需要加contentType
                    crossDomain: true,// 开启跨域支持
                    data: JSON.stringify({
                        examid: examid,
                        studentid: studentid,
                        score: score,
                    }), //数据对象必须使用JSON.stringify转换成字符串，直接传对象会有问题
                    dataType: 'json', // 服务器响应的数据类型
                    async: false, // 关闭异步
                    success: function(rec) {
                        console.log(rec);
                        if (rec.code === '0') {
                            $.messager.show({
                                title:'提示',
                                msg:'新增信息成功',
                                timeout:2000,
                                showType:'slide'
                            });
                        } else {
                            $.messager.alert({
                                title:'错误',
                                msg:rec.msg,
                                timeout:2000
                            });
                        }

                        $('#record_list_add_dialog').dialog('close');
                    }
                });
            }

        });

    });
</script>