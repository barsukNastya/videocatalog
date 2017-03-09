<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@  page isELIgnored="false" session="false" %>

<html>
<head>
  <title>videoData</title>
  <link rel="stylesheet" href="<c:url value="/assets/css/styles.css" />" type="text/css" media="screen" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
</head>
<body>
<a href="<c:url value='/videos'/>">Back to video list</a>
<a href="<c:url value='/logout'/>">Logout</a>
<br>
<br>
<b>Username: </b>${session.getAttribute("name")}
<br>
<br>

<h1>Video Details</h1>

<table class="tg">
  <tr>
    <th width="120">Title</th>
    <th width="120">Author</th>
  </tr>
  <tr>
    <td>${video.videoName}</td>
    <td>${video.videoAuthor}</td>
  </tr>
</table>
<h2>Video:</h2>
<iframe width="560" height="315" src="https://www.youtube.com/embed/${video.videoURL}" frameborder="0" allowfullscreen></iframe>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>

</html>