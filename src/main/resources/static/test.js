function cargarSurveys(){
    fetch('/api/survey')
            .then(response => response.json())
            .then(data => {
                const allSurveysDiv = document.getElementById('todasEncuestas');
               
                tablaEncuesta = `   <table class="table">
          <thead>
            <tr>
              <th scope="col">Id encuesta</th>
              <th scope="col">Nombre Encuesta</th>       
               <th scope="col">Descripcion Encuesta</th>            
              <th scope="col">Acciones</th>
            </tr>
          </thead>
         
               `;              
                  data.forEach(survey => {
                    tablaEncuesta += `
            
                <tbody>
                    <tr>
                       <th scope="row">${survey.id}</th>
                       <td>${survey.name}</td>
                        <td>${survey.description}</td>
                       <td> <i class="bi bi-pencil-fill" title="editar"></i>
                         <i class="bi bi-trash3-fill" title="Eliminar"></i>
                         <i class="bi bi-plus-square-fill" title="agregar capitulo"></i>
         
                       </td>
                       
                     </tr>
                 `;
                });
                allSurveysDiv.innerHTML += tablaEncuesta+`

                `
            })
            .catch((error) => {
                console.error('Error:', error);
            });
}

function cargarSurveys() {
    fetch('/api/survey')
        .then(response => response.json())
        .then(data => {
            const allSurveysSelect = document.getElementById('todasLasEncuestas');
            allSurveysSelect.innerHTML = ''; // Limpiar opciones existentes
            data.forEach(survey => {
                allSurveysSelect.innerHTML += `
                    <option value="${survey.id}">${survey.name}</option>
                `;
            });
        })
        .catch((error) => {
            console.error('Error:', error);
        });
}