<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
   	当前第<span id="page">${page.pageNum}</span>页
    <c:if test="${page.pageNum==1}">
        <input type="button" value="首页" disabled="disabled"/>
        <input type="button" value="上一页" disabled="disabled"/>
    </c:if>
    <c:if test="${page.pageNum!=1}">
        <input type="button" value="首页" onclick="goPage(1)"/>
        <input type="button" value="上一页" onclick="goPage(${page.pageNum-1})"/>
    </c:if>
    <c:if test="${page.pageNum == page.pages }">
        <input type="button" value="下一页" disabled="disabled"/>
        <input type="button" value="末页" disabled="disabled"/>
    </c:if>
    <c:if test="${page.pageNum != page.pages }">
        <input type="button" value="下一页" onclick="goPage(${page.pageNum+1})"/>
        <input type="button" value="末页" onclick="goPage(${page.pages})"/>
    </c:if>

    共${page.pages}页 ，${page.total}记录
</div>