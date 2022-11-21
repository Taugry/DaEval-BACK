<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <style>
      h2 {
        color: red;
      }
      table{
          border: 1px solid black;
          margin-left: auto;
          margin-right: auto;
          width: 80%;          
          
      }
      td,th{
          border: 1px solid black;
      }
    </style>
  </head>

  <body>
    <h1>Titre professionnel : ${t.titre}</h1>
    <h2>Prénom : ${e.firstName}</h2>
    <h2>Nom : ${e.lastName}</h2>
    <h2>Promotion : ${p.dateDebut} - ${p.dateFin}</h2>
	<h2>Filière : Informatique </h2>
	
    <table>
        <thead>
            <tr>
                <th style="width:60%">Bloc</td>
                <th style="width:20%" >Moyenne de l'étudiant</td>
                <th style="width:20%" >Moyenne de la promotion</td>
            </tr>
        </thead>
		<#list evalList as evalByBloc>
			<tr>
				<td>${evalByBloc.blocCompetencesDto.titre}
					<ul>
	      				<#list competences as c >
                          	<#if c.blocCompetencesId == evalByBloc.blocCompetencesDto.id>
                				<li>${c.titre}</li>
                          	</#if>
                      	</#list>
                     </ul>
				</td>
				<td style="text-align: center">${evalByBloc.moyenne}</td>
				<td style="text-align: center">${evalByBloc.moyennePromo}</td>
			</tr>
		</#list>
    </table>
  </body>

  <h3>Moyenne générale de l'étudiant : ${moygenetu}</h3>
  <h3>Moyenne générale de la promotion : ${moygenprom}</h3>


</html>
