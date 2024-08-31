// document.addEventListener('DOMContentLoaded', function () {
// //     // Cargar encuestas en el dropdown al cargar la página

// // cargarSurveys();
// function cargarSurveys(){
//     fetch('/api/survey')
//             .then(response => response.json())
//             .then(data => {
//                 const allSurveysDiv = document.getElementById('todasEncuestas');
               
//                 tablaEncuesta = `   <table class="table">
//           <thead>
//             <tr>
//               <th scope="col">Id encuesta</th>
//               <th scope="col">Nombre Encuesta</th>       
//                <th scope="col">Descripcion Encuesta</th>            
//               <th scope="col">Acciones</th>
//             </tr>
//           </thead>
         
//                `;              
//                   data.forEach(survey => {
//                     tablaEncuesta += `
            
//                 <tbody>
//                     <tr>
//                        <th scope="row">${survey.id}</th>
//                        <td>${survey.name}</td>
//                         <td>${survey.description}</td>
//                        <td> <i class="bi bi-pencil-fill" title="editar"></i>
//                          <i class="bi bi-trash3-fill" title="Eliminar"></i>
//                          <i class="bi bi-plus-square-fill" title="agregar capitulo"></i>
         
//                        </td>
                       
//                      </tr>
//                  `;
//                 });
//                 allSurveysDiv.innerHTML += tablaEncuesta+`

//                 `
//             })
//             .catch((error) => {
//                 console.error('Error:', error);
//             });
// }
    // Manejar el envío de una nueva encuesta
   
    // Manejar el envío de un nuevo capitulo
//     document.getElementById('agregarCapitulo').addEventListener('submit', function (event) {
//         event.preventDefault(); // Previene que el formulario se envíe de forma convencional

//         const chapterNumber = document.getElementById("chapter_number").value;
//         const surveyId = parseInt(document.getElementById("todasLasEncuestasCap").value, 10); // Convierte a entero
//         const chapterTitle = document.getElementById("chapter_title").value;

//         // Crear el objeto JSON en el formato deseado
//         const chapter = {
//             survey: { id: surveyId },  // Asegúrate de que surveyId esté en formato numérico
//             chapter_number: chapterNumber,  // Utiliza chapterNumber en lugar de chapter_number
//             chapter_title: chapterTitle  // Utiliza chapterTitle en lugar de chapter_title
//         };

//         console.log(chapter);
//         fetch('/api/chapter', {
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'application/json'
//             },
//             body: JSON.stringify(chapter)
//         })
//             .then(response => response.json())
//             .then(data => {
//                 console.log('Success:', chapter);
//                 alert('capitulo Registrada Exitosamente');
//                 this.reset(); // Resetea el formulario después de la creación exitosa
//                 cargarSurveys(); // Recargar las encuestas para incluir la nueva
//             })
//             .catch((error) => {
//                 console.error('Error:', error);
//             });
//     });

//     // Ver todas las encuestas
//     document.getElementById('viewAllBtn').addEventListener('click', function () {
//         fetch('/api/survey')
//             .then(response => response.json())
//             .then(data => {
//                 const allSurveysDiv = document.getElementById('allUsers');
//                 allSurveysDiv.innerHTML = '<h2>Todas las encuestas:</h2>';
//                 data.forEach(survey => {
//                     allSurveysDiv.innerHTML += `
//                         <p>
//                             id: ${survey.id}<br>
//                             name: ${survey.name}<br>
//                             description: ${survey.description}<br>
//                         </p>
//                     `;
//                 });
//             })
//             .catch((error) => {
//                 console.error('Error:', error);
//             });
//     });

//     // Editar encuesta
//     document.getElementById('editarEncuesta').addEventListener('submit', function (event) {
//         event.preventDefault();

//         const selectedSurveyId = document.getElementById("todasLasEncuestas").value;
//         if (!selectedSurveyId) {
//             alert('Por favor selecciona una encuesta para editar.');
//             return;
//         }

//         const formData = new FormData(this);
//         const data = {};

//         for (let [key, value] of formData.entries()) {
//             data[key] = value;
//         }

//         fetch(`/api/survey/${selectedSurveyId}`, {
//             method: 'PUT',
//             headers: {
//                 'Content-Type': 'application/json'
//             },
//             body: JSON.stringify(data)
//         })
//             .then(response => response.json())
//             .then(data => {
//                 console.log('Success:', data);
//                 alert('Encuesta actualizada exitosamente');
//                 cargarSurveys(); // Recargar las encuestas para reflejar los cambios
//             })
//             .catch((error) => {
//                 console.error('Error:', error);
//             });
//     });
//        // Editar capitulo
//        document.getElementById('editarCapitulo').addEventListener('submit', function (event) {
//         event.preventDefault();

//         const selectedCapituloId = document.getElementById("TodosCapitulos").value;
//         if (!selectedCapituloId) {
//             alert('Por favor selecciona un capitulo para editar.');
//             return;
//         }

//         const formData = new FormData(this);
//         const data = {};

//         for (let [key, value] of formData.entries()) {
//             data[key] = value;
//         }

//         fetch(`/api/chapter/${selectedCapituloId}`, {
//             method: 'PUT',
//             headers: {
//                 'Content-Type': 'application/json'
//             },
//             body: JSON.stringify(data)
//         })
//             .then(response => response.json())
//             .then(data => {
//                 console.log('Success:', data);
//                 alert('capitulo actualizada exitosamente');
//                 cargarSurveys(); // Recargar las encuestas para reflejar los cambios
//             })
//             .catch((error) => {
//                 console.error('Error:', error);
//             });
//     });
// });

// function cargarSurveysSelect() {
//     fetch('/api/survey')
//         .then(response => response.json())
//         .then(data => {
//             const allSurveysSelect = document.getElementById('todasLasEncuestas');
//             allSurveysSelect.innerHTML = ''; // Limpiar opciones existentes
//             data.forEach(survey => {
//                 allSurveysSelect.innerHTML += `
//                 <option value="${survey.id}">${survey.name}</option>
//             `;
//             });
//         })
//         .catch((error) => {
//             console.error('Error:', error);
//         });
// }
// function cargarSurveysSelectDel() {
//     fetch('/api/survey')
//         .then(response => response.json())
//         .then(data => {
//             const allSurveysSelect = document.getElementById('todasLasEncuestasd');
//             allSurveysSelect.innerHTML = ''; // Limpiar opciones existentes
//             data.forEach(survey => {
//                 allSurveysSelect.innerHTML += `
//                 <option value="${survey.id}">${survey.name}</option>
//             `;
//             });
//         })
//         .catch((error) => {
//             console.error('Error:', error);
//         });
// }
// function cargarSurveysSelectCap() {
//     fetch('/api/survey')
//         .then(response => response.json())
//         .then(data => {
//             const allSurveysSelect = document.getElementById('todasLasEncuestasCap');
//             allSurveysSelect.innerHTML = ''; // Limpiar opciones existentes
//             data.forEach(survey => {
//                 allSurveysSelect.innerHTML += `
//                 <option value="${survey.id}">${survey.name}</option>
//             `;
//             });
//         })
//         .catch((error) => {
//             console.error('Error:', error);
//         });
// }
// // Eliminar encuesta
// document.getElementById('eliminarEncuesta').addEventListener('click', function () {
//     const selectedSurveyId = document.getElementById("todasLasEncuestasd").value;
//     if (!selectedSurveyId) {
//         alert('Por favor selecciona una encuesta para eliminar.');
//         return;
//     }

//     fetch(`/api/survey/${selectedSurveyId}`, {
//         method: 'DELETE',
//         headers: {
//             'Content-Type': 'application/json; charset=UTF-8'
//         }
//     })
//         .then(response => {
//             if (response.ok) {
//                 // Si la respuesta no tiene contenido (204 No Content), no intentamos analizar JSON.
//                 if (response.status === 204) {
//                     return null; // No hay cuerpo para analizar
//                 }
//                 return response.json(); // Para respuestas con cuerpo JSON
//             } else {
//                 return response.text().then(text => {
//                     throw new Error(`Error ${response.status}: ${text}`);
//                 });
//             }
//         })
//         .then(data => {
//             if (data) {
//                 console.log('Encuesta eliminada:', data);
//             } else {
//                 console.log('Encuesta eliminada sin datos de respuesta.');
//             }
//             alert('Encuesta eliminada exitosamente');
//             cargarSurveysSelect(); // Recargar las encuestas para reflejar los cambios
//             cargarSurveysSelectDel(); // Actualizar el dropdown de eliminación
//         })
//         .catch(err => {
//             console.error('Error:', err);
//             alert(`Ocurrió un error al eliminar la encuesta: ${err.message}`);
//         });
// });
// function cargarCapituloEditar() {
//     fetch('/api/chapter')
//         .then(response => response.json())
//         .then(data => {
//             const allCapitulosSelect = document.getElementById('TodosCapitulos');
//             allCapitulosSelect.innerHTML = ''; // Limpiar opciones existentes
//             data.forEach(capitulo => {
//                 allCapitulosSelect.innerHTML += `
//                 <option value="${capitulo.id}">${capitulo.chapter_title}</option>
//             `;
//             });
//         })
//         .catch((error) => {
//             console.error('Error:', error);
//         });
// }





document.getElementById('nuevaEncuesta').addEventListener('submit', function (event) {
    event.preventDefault(); // Previene que el formulario se envíe de forma convencional

    const formData = new FormData(this);
    const data = {};

    for (let [key, value] of formData.entries()) {
        data[key] = value;
    }

    fetch('/api/survey', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            alert('Encuesta Registrada Exitosamente');
            this.reset(); // Resetea el formulario después de la creación exitosa
            // cargarSurveys(); // Recargar las encuestas para incluir la nueva
            const modalElement = document.getElementById('exampleModal');
            const modal = bootstrap.Modal.getInstance(modalElement);
            window.location.href = '/home';
        })
        .catch((error) => {
            console.error('Error:', error);
        });
});



