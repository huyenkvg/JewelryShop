<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<base href="${pageContext.servletContext.contextPath}/">
<title>Send email</title>
<script src="ckeditor/ckeditor.js"></script>
</head>
<body>
	${message}
	<form action="mailer/send.htm" method="post">
		<p>
			<input name="from" placeholder="From">
		</p>
		<p>
			<input name="to" placeholder="To">
		</p>
		<p>
			<input name="subject" placeholder="Subject">
		</p>
		<p>
			<textarea name="body" placeholder="Body" rows="3" cols="30"></textarea>
		</p>
		<button>Send</button>
	</form>
	<script>
           CKEDITOR.replace( 'body' );
       </script>    
</body>
</html>