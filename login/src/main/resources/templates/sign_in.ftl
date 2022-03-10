<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="/easyui/demo/demo.css">
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
</head>
<body>
<div class="easyui-panel" title="用户登录" style="width:100%;max-width:400px;padding:30px 60px">
    <div style="margin-bottom:20px">
        <input class="easyui-textbox" id="sign_in_username" style="width:100%" data-options="label:'账号:',required:true">
    </div>
    <div style="margin-bottom:20px">
        <input class="easyui-textbox" id="sign_in_password" style="width:100%" data-options="label:'密码:',required:true">
    </div>
    <div style="text-align:center;padding:5px 0">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">清除</a>
    </div>
</div>
<script>
    function submitForm(){
        let isAccountValid = $('#sign_in_username').textbox('isValid');
        let isPasswordValid = $('#sign_in_password').textbox('isValid');
        if (isAccountValid && isPasswordValid) {
            // 登录并跳转
            $.ajax({
                type: 'POST',
                url: "/api/user/sign_in",
                contentType:'application/json', //需要加contentType
                crossDomain: true,// 开启跨域支持
                data: JSON.stringify({
                    username: $('#sign_in_username').val(),
                    password: $('#sign_in_password').val(),
                }), //数据对象必须使用JSON.stringify转换成字符串，直接传对象会有问题
                dataType: 'json', // 服务器响应的数据类型
                async: false, // 关闭异步
                success: function(rec) {
                    if (rec.code === '0') {
                        window.location = '/';
                    } else {
                        $.messager.alert({
                            title:'提示',
                            msg:rec.msg,
                            timeout:2000,
                        });
                    }
                }
            });
        }
    }
    function clearForm(){
        $('#sign_in_username').textbox('setValue','');
        $('#sign_in_password').textbox('setValue','');
    }
</script>
</body>
</html>