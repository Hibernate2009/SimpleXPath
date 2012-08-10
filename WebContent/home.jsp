<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Hibernate projects</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">
<style>
body {
	padding-top: 60px;
	/* 60px to make the container go all the way to the bottom of the topbar */
}
</style>
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>

<body>

	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="#">Hibernate projects</a>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>

	<div class="container">

		<h1>XPath builder :</h1>
		<p>
		<h4>This is the easiest way to develop and debug your XPath
			expression!</h4>
		<p />

		<ul id="myTab" class="nav nav-tabs">
			<li class="active"><a href="#home" data-toggle="tab">XPathBilder</a></li>
			<li class=""><a href="#profile" data-toggle="tab">NameSpace</a></li>
		</ul>
		<div id="myTabContent" class="tab-content">
			<div class="tab-pane active" id="home">
				<form method="post" action="XPathServlet">
					<textarea class="span12" name="xml" id="textarea" rows="20"><c:out value="${model.xpathBO.xml}" /></textarea>
					<input class="span3" type="text" name="xpath"
						value="<c:out value="${model.xpathBO.xpath}"/>" /> <br />
					<button type="submit" class="btn">Submit</button>
				</form>
				<p />
				<c:forEach var="res" items="${model.xpathResult}">
					<pre><c:out value="${res}" /></pre>
				</c:forEach>
			</div>
			<div class="tab-pane" id="profile">
				<form class="form-inline" method="post" action="NameSpaceServlet">
					<input class="span2" type="text" name="prefix" placeholder="prefix"
						value="${model.nameSpaceBO.prefix}" /> <input class="span9"
						type="text" name="namespace" placeholder="namespace"
						value="${model.nameSpaceBO.namespace}" />
					<button type="submit" class="btn">Добавить</button>
				</form>

				<table class="well table table-striped">
					<thead>
						<tr>
							<th class="span2"><c:out value="prefix" /></th>
							<th class="span8"><c:out value="namespace" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="nsp" items="${model.namespaces}">
							<tr>
								<td><c:out value="${nsp.prefix}" /></td>
								<td><c:out value="${nsp.namespace}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</div>
	<!-- /container -->
	<script src="bootstrap/js/jquery-1.7.2.js"></script>
	<script src="bootstrap/js/bootstrap.js"></script>
	<script src="bootstrap/js/bootstrap-tab.js"></script>
</body>
</html>