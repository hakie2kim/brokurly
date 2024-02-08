<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/seller/productcreate.css'/>" />

    <title>Title</title>

</head>
<body>

<!-- 카테고리 -->

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
                                    <li ng-repeat="category1 in vm.categories1 track by $index" ng-class="{on: category1.id == vm.category1.id}" class="on"><a role="button" href="" ng-click="vm.clickCategoryDepth(category1)">가구/인테리어</a></li><!---->
                                    <li ng-repeat="category1 in vm.categories1 track by $index" ng-class="{on: category1.id == vm.category1.id}"><a role="button" href="" ng-click="vm.clickCategoryDepth(category1)">도서</a></li><!---->
                                    <li ng-repeat="category1 in vm.categories1 track by $index" ng-class="{on: category1.id == vm.category1.id}"><a role="button" href="" ng-click="vm.clickCategoryDepth(category1)">디지털/가전</a></li><!---->
                                    <li ng-repeat="category1 in vm.categories1 track by $index" ng-class="{on: category1.id == vm.category1.id}"><a role="button" href="" ng-click="vm.clickCategoryDepth(category1)">생활/건강</a></li><!---->
                                    <li ng-repeat="category1 in vm.categories1 track by $index" ng-class="{on: category1.id == vm.category1.id}"><a role="button" href="" ng-click="vm.clickCategoryDepth(category1)">스포츠/레저</a></li><!---->
                                    <li ng-repeat="category1 in vm.categories1 track by $index" ng-class="{on: category1.id == vm.category1.id}"><a role="button" href="" ng-click="vm.clickCategoryDepth(category1)">식품</a></li><!---->
                                    <li ng-repeat="category1 in vm.categories1 track by $index" ng-class="{on: category1.id == vm.category1.id}"><a role="button" href="" ng-click="vm.clickCategoryDepth(category1)">여가/생활편의</a></li><!---->
                                    <li ng-repeat="category1 in vm.categories1 track by $index" ng-class="{on: category1.id == vm.category1.id}"><a role="button" href="" ng-click="vm.clickCategoryDepth(category1)">출산/육아</a></li><!---->
                                    <li ng-repeat="category1 in vm.categories1 track by $index" ng-class="{on: category1.id == vm.category1.id}"><a role="button" href="" ng-click="vm.clickCategoryDepth(category1)">패션의류</a></li><!---->
                                    <li ng-repeat="category1 in vm.categories1 track by $index" ng-class="{on: category1.id == vm.category1.id}"><a role="button" href="" ng-click="vm.clickCategoryDepth(category1)">패션잡화</a></li><!---->
                                    <li ng-repeat="category1 in vm.categories1 track by $index" ng-class="{on: category1.id == vm.category1.id}"><a role="button" href="" ng-click="vm.clickCategoryDepth(category1)">화장품/미용</a></li><!---->
                                </ul>
                            </div>
                            <div ng-show="vm.showLevel >= 2" class=""><!---->
                                <ul class="data-group"><!---->
                                    <c:forEach var="item" items="${selectaa}">

                                        <li ng-repeat="category2 in vm.categories2 track by $index" ng-class="{on: category2.id == vm.category2.id}" class="on">
                                            <a role="button" href="">${item}</a>
                                        </li><!---->
                                    </c:forEach>
                                </ul>
<%--                                <li ng-repeat="category2 in vm.categories2 track by $index" ng-class="{'on': category2.id == vm.category2.id, 'no-depth': category2.lastLevel}"><a role="button" href="" ng-click="vm.clickCategoryDepth(category2)">홈데코</a></li><!---->&ndash;%&gt;--%>

                            </div>

                        </div><!---->
                        <div ng-show="vm.categoryBulkSelect &amp;&amp; !vm.showSearchTap1 &amp;&amp; !vm.showSearchTap2" class="form-group ng-hide"><div class="input-content">
                            <input type="text" class="form-control ng-pristine ng-untouched ng-valid ng-empty" ng-model="vm.bulkCategoryIds" style="width: 100%; height: 1px;" ng-change="vm.setBulkCategoryIds()" disabled>

                            </input>

                        </div>
                        </div><!---->
                        <div class="form-group"><input type="hidden" id="rentalNotAllowedCategory" class="form-control ng-pristine ng-untouched ng-empty ng-valid ng-valid-required" ng-model="vm.empty" ng-required="vm.isSelectNotAllowedRentalCategory" ng-required-err-type="required.not.allowed.rental.category" ncp-message-container="#error-rentalNotAllowedCategory" autocomplete="off"><div id="error-rentalNotAllowedCategory"></div></div><!----><!----><!----><!----><!---->
                        <p class="info-result text-info" ng-if="vm.product.category &amp;&amp; vm.product.category.wholeCategoryName &amp;&amp; vm.product.category.lastLevel &amp;&amp; !vm.product.category.deleted" style="">선택한 카테고리 : <strong>가구/인테리어&gt;DIY자재/용품</strong></p>

                        <p class="sub-text text-primary" ng-if="!vm.hasModel">상품과 맞지 않는 카테고리에 등록할 경우 강제 이동되거나 판매중지, 판매금지 될 수 있습니다.</p><br><!----><!----><!----><!----><!----><!----></div></div><!----></div></div><!----></div>
</ui-view>


</body>
</html>
