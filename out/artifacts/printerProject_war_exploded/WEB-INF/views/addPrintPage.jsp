<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/1
  Time: 13:21
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

            <div class="layui-logo" style="font-size: 20px">快印中心排队系统</div>
            <ul class="layui-nav layui-layout-right">

                <li class="layui-nav-item" lay-unselect="" lay-filter="me">
                    <a href="javascript:;"><img src="${pageContext.request.contextPath}/static/头像.jpg" class="layui-nav-img" id="userName">${sessionScope.user.id}|${sessionScope.user.name}</a>
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
                    <a class="javascript:;" href="${pageContext.request.contextPath}/welcome">当前队列</a>
                    <dl class="layui-nav-item">
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed" lay-filter="yuyue">
                    <a class="javascript:;" href="${pageContext.request.contextPath}/addPrintPage">预约打印</a>
                    <dl class="layui-nav-item">
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="javascript:;" href="${pageContext.request.contextPath}/historyPage">历史信息</a>
                    <dl class="layui-nav-item">
                    </dl>
                </li>

            </ul>
        </div>
    </div>

    <div class="layui-body">
        <div class="layui-main mainBox">
            <form class="layui-form" action="${pageContext.request.contextPath}/addPrint">
                <div>&nbsp;</div>
                <div class="layui-form-item">
                    <label class="layui-form-label">纸张大小</label>
                    <div class="layui-input-inline">
                        <select name="paperSize" lay-verify="required">
                            <option value=""></option>
                            <option value="A4">A4</option>
                            <option value="A8">A8</option>
                            <option value="16开">16开</option>
                            <option value="明信片">明信片</option>
                            <option value="奖状">奖状</option>
                        </select>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">打印方式</label>
                    <div class="layui-input-block">
                        <input type="radio" name="way" value="单面打印" title="单面打印" checked>
                        <input type="radio" name="way" value="双面打印" title="双面打印">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">打印选项</label>
                    <div class="layui-input-block">
                        <input type="radio" name="option" value="黑白" title="黑白" checked>
                        <input type="radio" name="option" value="彩印" title="彩印">
                    </div>
                </div>

                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">选择文件</label>
                    <!--                    <button type="button" class="layui-btn" id="test3" style="background: #01AAED">-->
                    <!--                        <i class="layui-icon">&#xe67c;</i>上传文件-->
                    <!--                    </button>-->
                    <div class="layui-input-inline">
                        <input type="text" name="fileName" required lay-verify="required" placeholder="文件名"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>


                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">备注信息</label>
                    <div class="layui-input-inline">
                        <input type="text" name="notes" placeholder="请输入备注内容"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;提交&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>

    </div>

    <div class="layui-footer">
        © 2019 lwh.kim - 打印店排队系统
    </div>


    <script src="${pageContext.request.contextPath}/layui/layui.js" charset="utf-8"></script>

    <script>


        layui.use(['element', 'layer', 'form', 'upload'], function () {
            var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
            var layer = layui.layer;
            var form = layui.form;
            var upload = layui.upload;

            var $ = layui.jquery;

            var uploadInst = upload.render({
                elem: '#test3'
                , url: '/printerProject/fileUpload'
                , accept: 'file' //普通文件
                , done: function (res) {
                    console.log(res)
                }
            });


            // $.post('../test', {}, function(str){
            //     layer.open({
            //         type: 1,
            //         content: str //注意，如果str是object，那么需要字符拼接。
            //     });
            // });


            //监听导航点击
            element.on('nav(demo)', function (elem) {
                console.log(elem)
            });

            element.on('nav(yuyue)', function (data) {
                layer.open({
                    type: 1,
                    content: $('#addPrint'),
                    title: '添加信息',
                    area: '370px',
                });
            });

        });
    </script>

</body>
</html>
