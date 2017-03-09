<%@ page import="com.melenteva.model.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false"  contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="<c:url value="/assets/css/styles.css" />" type="text/css" media="screen" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <title>Videos Page</title>

</head>
<body>

<a href="<c:url value='/logout'/>">Logout</a>
<br>
<br>
<b>Username: </b>${session.getAttribute("name")}


<br>
<br>
<h1>Video List</h1>
<c:set var="isAdmin" scope="session" value="${sessionScope.isAdmin}"/>

<c:if test="${!empty listVideo}">
    <table class="tg list">
        <thead>
            <tr>
                <th width="120">Title</th>
                <th width="120">Author</th>
                <th width="120">Link</th>
               <c:if test="${isAdmin}">
                <th width="60">Edit</th>
                <th width="60">Delete</th>
               </c:if>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${listVideo}" var="video">
            <tr class="video" data-name="${video.videoName}" data-author="${video.videoAuthor}" data-url="${video.videoURL}">
                <td><a href="/videodata/${video.id}" target="_blank">${video.videoName}</a></td>
                <td>${video.videoAuthor}</td>
                <td><a href="https://youtu.be/${video.videoURL}">https://youtu.be/${video.videoURL}</a></td>
                <c:if test="${isAdmin}">
                <td><a class="edit-btn" data-toggle="modal" data-target="#addVideoModal" data-id="${video.id}">Edit</a></td>
                <td><a href="<c:url value='/remove/${video.id}'/>" class="delete-video" data-id="${video.id}">Delete</a></td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>

    </table>

    <ul class="pagination"></ul>
</c:if>
<c:if test="${empty listVideo}">
    <h2>Ничего не найдено. ;-)</h2>
</c:if>
<div class="buttons">
<button data-toggle="modal" data-target="#searchVideoModal" type="button" class="btn btn-primary btn-add">Search video</button>
<a  href="/videos"  class="btn btn-primary btn-add">Reset search video</a>
<c:if test="${isAdmin}">
<a data-toggle="modal" data-target="#addVideoModal" class="btn btn-primary btn-add">Add video</a>
<c:url var="addAction" value="/videos/add"/>
</div>

<div class="modal fade" id="addVideoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel"></h4>
            </div>
            <form:form action="${addAction}" commandName="video">
                <div class="modal-body">
                        <form:hidden path="Id"/>

                        <div class="form-group">
                            <form:label cssClass="control-label" path="videoName">
                                <spring:message text="Title"/>
                            </form:label>
                            <form:input cssClass="form-control"  path="videoName"/>
                        </div>

                        <div class="form-group">
                            <form:label cssClass="control-label" path="videoAuthor">
                                <spring:message text="Author"/>
                            </form:label>
                            <form:input cssClass="form-control" path="videoAuthor"/>
                        </div>

                        <div class="form-group">
                            <form:label cssClass="control-label" path="videoURL">
                                <spring:message text="URL"/>
                            </form:label>
                            <form:input cssClass="form-control" path="videoURL"/>
                        </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary"></button>
                </div>
            </form:form>
        </div>
    </div>
</div>

</c:if>

<c:url var="searchAction" value="/videos"/>

<div class="modal fade" id="searchVideoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="exampleModalLabel2">Search video</h4>
            </div>
            <form:form action="/videos" commandName="video" method="get">
                <div class="modal-body">

                    <div class="form-group">
                        <form:label cssClass="control-label" path="videoName">
                            <spring:message text="Title"/>
                        </form:label>
                        <form:input cssClass="form-control" id="sVideoName" path="videoName"/>
                    </div>

                    <div class="form-group">
                        <form:label cssClass="control-label" path="videoAuthor">
                            <spring:message text="Author"/>
                        </form:label>
                        <form:input cssClass="form-control" id="sVideoAuthor" path="videoAuthor"/>
                    </div>

                    <div class="form-group">
                        <form:label cssClass="control-label" path="videoURL">
                            <spring:message text="URL"/>
                        </form:label>
                        <form:input cssClass="form-control" id="sVideoURL"  path="videoURL"/>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Search</button>
                </div>
            </form:form>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="/assets/js/jquery.simplePagination.js"></script>
<script src="/assets/js/script.js">
</script>
</body>
</html>
