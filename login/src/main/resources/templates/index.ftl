<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>教学管理系统</title>
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="easyui/demo/demo.css">
    <script type="text/javascript" src="jquery.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>

</head>
<body class="easyui-layout">
    <div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">当前登录用户：管理员</div>
    <div data-options="region:'west',split:true,title:'菜单'" style="width:200px;padding:10px;">
        <div id="index_side_menu" style="width:300px"></div>
    </div>
    <div data-options="region:'center'" style="width: 100%">
        <div id="index_tabs" class="easyui-tabs"></div>
    </div>



    <script type="text/javascript">
        $(function(){
            const data = [{
                text: '基础资料',
                state: 'open',
                children: [{
                    id: 'student_list',
                    text: '学生列表'
                }, {
                    id: 'teacher_list',
                    text: '教师列表'
                }, {
                    id: 'lesson_list',
                    text: '课程列表'
                }, {
                        id: 'selection_list',
                        text: '选课列表'
                }, {
                        id: 'exam_list',
                        text: '考试列表'
                }, {
                        id: 'record_list',
                        text: '考试信息列表'
                    }]
            }];
            $('#index_side_menu').sidemenu({
                data: data
            });
            $('#index_side_menu').sidemenu({
                onSelect:function(item){
                    if (item.id === "student_list") {
                        $('#index_tabs').tabs('add',{
                            title:'学生列表',
                            href:'/student/list',
                            closable:true,
                            tools:[{
                                iconCls:'icon-mini-refresh',
                                handler:function(){
                                    alert('refresh');
                                }
                            }]
                        });
                    }
                    if (item.id === "teacher_list") {
                        $('#index_tabs').tabs('add',{
                            title:'教师列表',
                            href:'/teacher/list',
                            closable:true,
                            tools:[{
                                iconCls:'icon-mini-refresh',
                                handler:function(){
                                    alert('refresh');
                                }
                            }]
                        });
                    }
                    if (item.id === "lesson_list") {
                        $('#index_tabs').tabs('add',{
                            title:'课程列表',
                            href:'/lesson/list',
                            closable:true,
                            tools:[{
                                iconCls:'icon-mini-refresh',
                                handler:function(){
                                    alert('refresh');
                                }
                            }]
                        });
                    }
                    if (item.id === "selection_list") {
                        $('#index_tabs').tabs('add',{
                            title:'选课列表',
                            href:'/selection/list',
                            closable:true,
                            tools:[{
                                iconCls:'icon-mini-refresh',
                                handler:function(){
                                    alert('refresh');
                                }
                            }]
                        });
                    }
                    if (item.id === "exam_list") {
                        $('#index_tabs').tabs('add',{
                            title:'考试列表',
                            href:'/exam/list',
                            closable:true,
                            tools:[{
                                iconCls:'icon-mini-refresh',
                                handler:function(){
                                    alert('refresh');
                                }
                            }]
                        });
                    }
                    if (item.id === "record_list") {
                        $('#index_tabs').tabs('add',{
                            title:'考试信息列表',
                            href:'/record/list',
                            closable:true,
                            tools:[{
                                iconCls:'icon-mini-refresh',
                                handler:function(){
                                    alert('refresh');
                                }
                            }]
                        });
                    }
                }
            });
        })
    </script>
</body>
</html>