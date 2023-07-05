<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css">
<script src="https://kit.fontawesome.com/e136359f35.js" crossorigin="anonymous"></script>
<title>Share Video</title>
<link rel="icon" href="https://tinyzonetv.to/images/group_2/theme_1/logo.png?v=0.1" type="image/x-icon">
</head>

<body>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!-- 	modal -->
	<main style="display: flex; min-height: 100vh;">
		<div class="container">
			<div class="columns is-centered mt-6">
				<div class="column is-4">
					<h1 class="block title has-text-centered">SHARE VIDEO</h1>
					<form action="ShareVideo" method="post" class="box">
						<input type="hidden" class="input" name="videoId" value="${videoId}">
						<div class="field">
							<label for="" class="label">Email</label>
							<div class="control">
								<input type="email" class="input" name="email" required="required">
							</div>
						</div>
						<hr>
						<div class="field">
							<div class="control">
								<button class="button is-fullwidth is-primary" type="submit">Send</button>
							</div>
						</div>
						<div class="field">
							<p>${message}</p>
						</div>
						<div class="field">
							<p>${error}</p>
						</div>
					</form>
				</div>
			</div>
		</div>
	</main>
</body>

</html>