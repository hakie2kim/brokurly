<%--
  Created by IntelliJ IDEA.
  User: sookyung
  Date: 2024/02/07
  Time: 9:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ui-view name="category">
    <div class="form-section" >
        <div class="title-line" server-field-errors="product.category.*" server-global-errors="windowCategory.windowChannelLimit" role="button" ncp-click-except-target=".fn-help1" ncp-click="vm.isMenuOpen = !vm.isMenuOpen">
            <label class="col-lg-2 col-sm-3 col-xs-5 control-label">카테고리 </label>
            <div class="col-lg-10 col-sm-9 col-xs-7 input-content">
                <div class="set-option no-set" ></div>
            </div>
        </div><!---->

        <div class="inner-content input-content">
            <div class="form-section-sub">
                <div class="form-sub-wrap">
                    <div class="input-content"><!---->

                            <!-- 3섹션 폼 -->
                            <div class="seller-data-list category-list" ng-if="vm.showPcDepthSearch()" style="">
                                <div><!---->
                                    <ul class="data-group"><!---->
                                        <li ng-repeat="category1 in vm.categories1 track by $index" ng-class="{on: category1.id == vm.category1.id}" class="on">
                                            <a role="button" href="" ng-click="vm.clickCategoryDepth(category1)">${CategoryDto.codeId}</a>
                                        </li><!---->
                                    </ul>
                                </div>
                            </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</ui-view>


</body>
</html>
