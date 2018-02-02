<%--
  Created by IntelliJ IDEA.
  User: caiminjie
  Date: 18/2/1
  Time: 上午12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
</head>
<body>
    <div>
        <input type="text" id="name">
        <input type="button" value="查找" id="search">
    </div>
    <script type="text/javascript">
        $(function(){
            $("#search").on("click", function(){
                var name = $("#name").val();
                $.ajax({
                    url: "findOne",
                    type: "get",
                    dataType: "json",
                    data: {
                        name: name
                    },
                    success: function(resp){
                        if(resp.status == 200){
                            console.log(resp.data);
                        }
                    }
                })

            })

        })
    </script>
</body>
</html>
