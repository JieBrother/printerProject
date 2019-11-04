<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/1
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>主页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
<div class="layui-layout layui-layout-admin">


    <div class="layui-header header header-demo" autumn>
        <div class="layui-main layui-bg-green">
            <div class="layui-form component" lay-filter="LAY-site-header-component"></div>

            <div class="layui-logo" style="font-size: 20px">快印中心后台管理系统</div>

            <ul class="layui-nav layui-layout-right">

                <li class="layui-nav-item" lay-unselect="" lay-filter="me">
                    <a href="javascript:;"><img src="${pageContext.request.contextPath}/static/头像.jpg"
                                                class="layui-nav-img" id="userName">管理员-${sessionScope.user.name}</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">修改信息</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/logoutAction">安全退出</a></li>
            </ul>
        </div>
    </div>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">

            <ul class="layui-nav layui-nav-tree site-demo-nav">

                <li class="layui-nav-item layui-nav-itemed">
                    <a class="javascript:;" href="${pageContext.request.contextPath}/adminHomePage">订单列表</a>
                    <dl class="layui-nav-item">
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="javascript:;" href="${pageContext.request.contextPath}/adminHistoryPage">历史订单</a>
                    <dl class="layui-nav-item">
                    </dl>
                </li>

            </ul>
        </div>
    </div>

    <div class="layui-body">

        <table class="layui-table" id="tableData"
               lay-data="{height: 'full-200', cellMinWidth: 80,url:'${pageContext.request.contextPath}/printInfo', id:'test', limit: 10}"
               lay-filter="printerData">
            <thead>
            <tr>
                <th lay-data="{field:'number', width:80, sort: true}">序号</th>
                <th lay-data="{field:'id', width:300}">用户名</th>
                <th lay-data="{field:'name', width:200}">姓名</th>
                <th lay-data="{field:'fileName', width:300}">文件名</th>
                <th lay-data="{field:'status', width:120}">状态</th>
                <th lay-data="{field:'notes', width:200}">备注</th>
                <th lay-data="{fixed: 'right', title:'操作', align:'center', toolbar: '#operation', width:200}">操作
                </th>
            </tr>
            </thead>
        </table>

    </div>

    <div class="layui-footer">
        © 2019 lwh.kim - 打印店排队系统
    </div>


    <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>


    <script type="text/html" id="operation">

        <a class='layui-btn layui-btn-normal layui-btn-xs' style="background: #01AAED" lay-event='finish'>下载</a>
        <a class='layui-btn layui-btn-normal layui-btn-xs' style="background: #FF5722" lay-event='noda'>拒打</a>

    </script>

    <script>

        layui.use(['element', 'layer', 'form', 'table'], function () {
            var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
            var layer = layui.layer;
            var table = layui.table;

            var $ = layui.jquery;


            table.on('tool(printerData)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
                var data = obj.data; //获得当前行数据
                var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
                var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

                if (layEvent === 'finish') { //完成打印
                    layer.confirm('是否下载文档', function (index) {
                        obj.del();
                        layer.close(index);
                        //向服务端发送删除指令
                        $.ajax({
                            url: '${pageContext.request.contextPath}/finishPrint',
                            data: {
                                fileName: obj.data.fileName
                            },
                            success(res) {
                                console.log(res);
                            }
                        })
                    });

                } else if (layEvent == 'noda') {
                    layer.confirm('嚣张拒打', function (index) {
                        obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                        layer.close(index);
                        //向服务端发送删除指令
                        $.ajax({
                            url: '${pageContext.request.contextPath}/delHistoryData',
                            data: {
                                fileName: obj.data.fileName
                            },
                            success(res) {
                                console.log(res);
                            }
                        })

                    });
                }
            });

        });
    </script>

</body>
</html>
