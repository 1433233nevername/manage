<div id="center_content"></div>
<script type="text/javascript">
    $(function(){
        $('#center_content').datagrid({
            url:'/api/user/list',
            columns:[[
                {field:'username',title:'姓名',width:100}
            ]]
        });
    })
</script>