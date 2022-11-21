<!DOCTYPE html>
<html>
	<head>
		<style>
			.red { color: red; }
		</style>
		<meta charset="UTF-8" />
		
		
	</head>
	<body>
		<h1 class="red">${t.titre}</h1>
		
		<h2>Blocs de compétences</h2>
		<dl>
			<#list blocs as b>
			    <dt>Titre : ${b.titre}</dt>
				<dd>Desc : ${b.description}</dd>
			</#list>
		</dl>
	</body>
</html>


