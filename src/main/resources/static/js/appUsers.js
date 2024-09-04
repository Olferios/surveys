// ESTE ES PARA LA LISTAS DEJE SELECCIONADO EL CARACTE
document.querySelectorAll('.dropdown-item').forEach(item => {
  item.addEventListener('click', function (event) {
    event.preventDefault(); // Previene el comportamiento por defecto del enlace

    // Obtener el botón del dropdown
    const button = this.closest('.btn-group').querySelector('.dropdown-toggle');

    // Actualizar el texto del botón con el valor del ítem seleccionado
    button.textContent = this.textContent;
  });
});

document.querySelectorAll('[data-bs-toggle="collapse"]').forEach(button => {
  button.addEventListener('click', event => {
    const targetId = event.target.getAttribute('data-bs-target');
    const collapseElements = document.querySelectorAll('.collapse');
    collapseElements.forEach(collapse => {
      if (collapse.id !== targetId.substring(1)) {
        collapse.classList.remove('show');
      }
    });
  });
});
document.addEventListener('DOMContentLoaded', function () {
  var collapseElement = document.getElementById('collapseExample');
  if (collapseElement) {
    var bootstrapCollapse = new bootstrap.Collapse(collapseElement, {
      toggle: false
    });
    bootstrapCollapse.show();

  }


  cargarSurveys();
  function cargarSurveys() {
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
console.log(survey);
          if (survey.enable == true) {
            tablaEncuesta += `
            
                <tbody>
                    <tr>
                       <th scope="row">${survey.id}</th>
                       <td>${survey.name}</td>
                        <td>${survey.description}</td>
                     <td>
                  

              </td>
                       </td>
                       
                     </tr>
                 `;
          } 
        });
        allSurveysDiv.innerHTML += tablaEncuesta + `

                `;

      })
      .catch((error) => {
        console.error('Error:', error);
      });
  }

});

function habilitar(){
  var id = event.target.dataset.id;
  const data = {enable: true};


  fetch(`/api/survey/enable/${id}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  })
  
   .then(response => response.json())
   .then(data => {
      console.log('Encuesta habilitada:', data);
      alert('Encuesta habilitada exitosamente');
      location.reload();
    })
   .catch((error) => {
      console.error('Error:', error);
    });
}

function deshabilitar(){
  var id = event.target.dataset.id;

  const data = {enable: false};
  fetch(`/api/survey/enable/${id}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  })
   .then(response => response.json())
   .then(data => {
      console.log('Encuesta deshabilitada:', data);
      alert('Encuesta deshabilitada exitosamente');
      location.reload();
    })
   .catch((error) => {
      console.error('Error:', error);
    });
}


// Asegúrate de que el DOM esté completamente cargado
//agregar id de encuesta al Modal
document.addEventListener('DOMContentLoaded', function () {
  // Usa el evento de clic en el contenedor de la tabla
  const allSurveysDiv = document.getElementById('todasEncuestas');
  allSurveysDiv.addEventListener('click', function (event) {
    // Verifica si el clic fue en un ícono de editar
    if (event.target.classList.contains('bi-pencil-fill')) {
      // Obtén el ID del atributo data-id
      surveyIdEditar = event.target.getAttribute('data-id');
      console.log('ID de la encuesta para editar:', surveyIdEditar);
      document.getElementById("encuestaNumero").innerText = surveyIdEditar;


    }
  });

});
//actualizar encuesta
document.getElementById('editarEncuesta').addEventListener('submit', function (event) {


  const selectedSurveyId = document.getElementById("encuestaNumero").textContent;
  if (!selectedSurveyId) {
    alert('Por favor selecciona una encuesta para editar.');
    return;
  }

  const formData = new FormData(this);
  const data = {};

  for (let [key, value] of formData.entries()) {
    data[key] = value;
  }

  fetch(`/api/survey/${selectedSurveyId}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  })
    .then(response => response.json())
    .then(data => {
      console.log('Success:', data);
      alert('Encuesta actualizada exitosamente');

    })
    .catch((error) => {
      console.error('Error:', error);
    });
});

//eliminar encuesta
document.addEventListener('DOMContentLoaded', function () {
  // Usa el evento de clic en el contenedor de la tabla
  const allSurveysDiv = document.getElementById('todasEncuestas');
  allSurveysDiv.addEventListener('click', function (event) {
    // Verifica si el clic fue en un ícono de editar
    if (event.target.classList.contains('bi-trash3-fill')) {
      // Obtén el ID del atributo data-id
      surveyIdDelete = event.target.getAttribute('data-id');
      console.log('ID de la encuesta para editar:', surveyIdDelete);

      fetch(`/api/survey/${surveyIdDelete}`, {
        method: 'DELETE',
        headers: {
          'Content-Type': 'application/json; charset=UTF-8'
        }
      })
        .then(response => {
          if (response.ok) {
            // Si la respuesta no tiene contenido (204 No Content), no intentamos analizar JSON.
            if (response.status === 204) {
              return null; // No hay cuerpo para analizar
            }
            return response.json(); // Para respuestas con cuerpo JSON
          } else {
            return response.text().then(text => {
              throw new Error(`Error ${response.status}: ${text}`);
            });
          }
        })
        .then(data => {
          if (data) {
            console.log('Encuesta eliminada:', data);
          } else {
            console.log('Encuesta eliminada sin datos de respuesta.');
          }
          alert('Encuesta eliminada exitosamente');
          window.location.href = '/gestion';
        })
        .catch(err => {
          console.error('Error:', err);
          alert(`Ocurrió un error al eliminar la encuesta: ${err.message}`);
        });
    }

  });
});

//agregar capitulo a encuesta

document.addEventListener('DOMContentLoaded', function () {
  // Usa el evento de clic en el contenedor de la tabla
  const allSurveysDiv = document.getElementById('todasEncuestas');
  allSurveysDiv.addEventListener('click', function (event) {
    // Verifica si el clic fue en un ícono de editar
    if (event.target.classList.contains('bi-plus-square-fill')) {
      // Obtén el ID del atributo data-id
      agregarCapitulo = event.target.getAttribute('data-id');
      document.getElementById("encuestaNumeroCap").innerText = agregarCapitulo;
      console.log('ID de la encuesta para editar:', agregarCapitulo);
    }
  });

});


document.getElementById('agregarCapitulo').addEventListener('submit', function (event) {
  event.preventDefault(); // Previene que el formulario se envíe de forma convencional

  const chapterNumber = document.getElementById("chapter_number").value;
  const surveyId = parseInt(document.getElementById("encuestaNumeroCap").textContent); // Convierte a entero
  const chapterTitle = document.getElementById("chapter_title").value;

  // Crear el objeto JSON en el formato deseado
  const chapter = {
    survey: { id: surveyId },  // Asegúrate de que surveyId esté en formato numérico
    chapter_number: chapterNumber,  // Utiliza chapterNumber en lugar de chapter_number
    chapter_title: chapterTitle  // Utiliza chapterTitle en lugar de chapter_title
  };

  console.log(chapter);
  fetch('/api/chapter', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(chapter)
  })
    .then(response => response.json())
    .then(data => {
      console.log('Success:', chapter);
      alert('capitulo Registrada Exitosamente');
      this.reset(); // Resetea el formulario después de la creación exitosa
      window.location.href = '/gestion';
    })
    .catch((error) => {
      console.error('Error:', error);
    });
});


//agregarencuestas en edicion de capitulos

document.addEventListener('DOMContentLoaded', function () {
  var collapseElement = document.getElementById('gestionCapitulos');
  if (collapseElement) {
    cargarSurveyscap();
    cargarSurveyscap();
    cargarSurveyscapPregunta();
    console.log('Actualiz');
  };

});



//agregar capitulo a encuesta

document.addEventListener('DOMContentLoaded', function () {
  // Usa el evento de clic en el contenedor de la tabla
  const editarCapituloContenedor = document.getElementById('encuestasCapitulos');

  editarCapituloContenedor.addEventListener('click', function (event) {
    // Verifica si el clic fue en un ícono de editar
    if (event.target.classList.contains('bi-pencil-fill')) {
      // Obtén el ID de la encuesta del atributo data-id del ícono
      const encuestaId = event.target.getAttribute('data-id');

      // Encuentra el <select> asociado a esta encuesta
      const selectElement = document.getElementById(`todasLasEncuestas${encuestaId}`);

      // Obtén el capítulo seleccionado del <select>
      document.getElementById("encuestaNumeroCapEditar").innerText = selectElement.value;
      // Actualiza el texto o realiza cualquier acción con el capítulo seleccionado

      console.log('ID del capítulo seleccionado para editar:', selectElement.value);
    }
  });
});
//  Editar capitulo



document.getElementById('editarCapitulo').addEventListener('submit', function (event) {
  event.preventDefault();

  const selectedCapituloId = document.getElementById("encuestaNumeroCapEditar").textContent;

  if (!selectedCapituloId) {
    alert('Por favor selecciona un capítulo para editar.');
    return;
  }

  const formData = new FormData(this);
  const data = {};

  for (let [key, value] of formData.entries()) {
    data[key] = value;
  }

  fetch(`/api/chapter/${selectedCapituloId}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  })
    .then(response => response.json())
    .then(data => {
      console.log('Success:', data);
      alert('Capítulo actualizado exitosamente');
      cargarSurveyscap();
      this.reset();
      // Cerrar el modal después de la actualización exitosa
      const modalElement = document.getElementById('exampleModal3');
      const modal = bootstrap.Modal.getInstance(modalElement);
      modal.hide();

      // Recargar la lista de capítulos

    })
    .catch(error => {
      console.error('Error:', error);
    });
});

//eliminar capitulo
document.addEventListener('DOMContentLoaded', function () {
  // Usa el evento de clic en el contenedor de la tabla
  const allSurveysDiv = document.getElementById('encuestasCapitulos');
  allSurveysDiv.addEventListener('click', function (event) {


    // Verifica si el clic fue en un ícono de editar
    if (event.target.classList.contains('bi-trash3-fill')) {
      // Obtén el ID del atributo data-id
      console.log('eliminado');
      agregarCapitulo = event.target.getAttribute('data-id');
      console.log(agregarCapitulo);

      const seleccionarCapitulo = document.getElementById(`todasLasEncuestas${agregarCapitulo}`).value;
      if (!seleccionarCapitulo) {
        alert('Por favor selecciona una capitulo para eliminar.');
        return;
      }
      console.log('Obtén el ID del atributo' + seleccionarCapitulo);

      fetch(`/api/chapter/${seleccionarCapitulo}`, {
        method: 'DELETE',
        headers: {
          'Content-Type': 'application/json; charset=UTF-8'
        }
      })
        .then(response => {
          if (response.ok) {
            // Si la respuesta no tiene contenido (204 No Content), no intentamos analizar JSON.
            if (response.status === 204) {
              return null; // No hay cuerpo para analizar
            }
            return response.json(); // Para respuestas con cuerpo JSON
          } else {
            return response.text().then(text => {
              throw new Error(`Error ${response.status}: ${text}`);
            });
          }
        })
        .then(data => {
          if (data) {
            console.log('capitulo eliminada:', data);
          } else {
            console.log('capitulo eliminada sin datos de respuesta.');
          }
          alert('capitulo eliminada exitosamente');
          cargarSurveyscap();

        })
        .catch(err => {
          console.error('Error:', err);
          alert(`Ocurrió un error al eliminar el capitulo: ${err.message}`);
        });
    }



  });
});



function cargarSurveyscap() {
  fetch('/api/survey')
    .then(response => response.json())
    .then(data => {
      const allSurveysDiv = document.getElementById('encuestasCapitulos');
      allSurveysDiv.innerHTML = "";
      tablaEncuesta = `   <table class="table">
        <thead>
          <tr>
             <th scope="col">Id encuesta</th>
            <th scope="col">Nombre Encuesta</th>
            <th scope="col">Capitulo</th>
            <th scope="col">Acciones</th>
          </tr>
        </thead>
       
             `;
      data.forEach(survey => {
         if (survey.enable == true) {
            tablaEncuesta += `
          
              <tbody>
                  <tr>
                     <th scope="row">${survey.id}</th>
                     <td>${survey.name}</td>
                   <td>
              <div class="btn-group">            
                    <select   name="todasLasEncuestas" id="todasLasEncuestas${survey.id}">
              <option value="">Seleccione un capitulo</option>
          </select>
             
              </div>
            </td>
                   <td>
             
            </td>
                     </td>
                     
                   </tr>
               `;}
        cargarSurveysSelect(survey.id, "todasLasEncuestas");
        cargarSurveyscapPregunta();
      });

      allSurveysDiv.innerHTML += tablaEncuesta + `

              `

    })
    .catch((error) => {
      console.error('Error:', error);
    });
}



function cargarSurveysSelect(id, elemento) {
  fetch('/api/chapter')
    .then(response => response.json())
    .then(data => {
      const allSurveysSelect = document.getElementById(`${elemento}${id}`);
      allSurveysSelect.innerHTML = '<option value="">Seleccione una capitulo</option>'; // Limpiar opciones existentes
      data.forEach(chapter => {
        if (chapter.survey.id === id) {
          allSurveysSelect.innerHTML += `
            <option value="${chapter.id}">${chapter.chapter_number} ${chapter.chapter_title}</option>
          `;
        }
      });
    })
    .catch(error => {
      console.error('Error:', error);
    });
}
//agregar capitulo anombre agregar pagina


document.addEventListener('DOMContentLoaded', function () {
  // Usa el evento de clic en el contenedor de la tabla
  const editarCapituloContenedor = document.getElementById('encuestasCapitulos');

  editarCapituloContenedor.addEventListener('click', function (event) {
    // Verifica si el clic fue en un ícono de editar
    if (event.target.classList.contains('bi-plus-square-fill')) {
      // Obtén el ID de la encuesta del atributo data-id del ícono
      const encuestaId = event.target.getAttribute('data-id');
      console.log(encuestaId);
      // Encuentra el <select> asociado a esta encuesta
      const selectElement = document.getElementById(`todasLasEncuestas${encuestaId}`);

      // Obtén el capítulo seleccionado del <select>
      document.getElementById("numeroCapitulo").innerText = selectElement.value;
      // Actualiza el texto o realiza cualquier acción con el capítulo seleccionado

      console.log('ID del capítulo seleccionado para editar:', selectElement.value);
    }
  });
});
//agregar pagina a capitulo
document.getElementById('agregarPagina').addEventListener('submit', function (event) {
  event.preventDefault();
  const numeroCapitulo = document.getElementById("question_numberCrear").value;
  const tipoRespuesta = document.getElementById("response_typeCrear").value;
  const comentarioPregunta = document.getElementById("comment_questionCrear").value;
  const textoPregunta = document.getElementById("question_textCrear").value;
  const capituloId = parseInt(document.getElementById("numeroCapitulo").textContent); // Convierte a entero


  // Crear el objeto JSON en el formato deseado
  const chapter = {
    "question_number": numeroCapitulo,
    chapter: { id: capituloId },

    "response_type": tipoRespuesta,
    "comment_question": comentarioPregunta,

    "question_text": textoPregunta
  };
  //   const chapter = {
  //     survey: { id: surveyId },  // Asegúrate de que surveyId esté en formato numérico
  //     chapter_number: chapterNumber,  // Utiliza chapterNumber en lugar de chapter_number
  //     chapter_title: chapterTitle  // Utiliza chapterTitle en lugar de chapter_title
  // };

  console.log(chapter);
  fetch('/api/question', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(chapter)
  })
    .then(response => response.json())
    .then(data => {
      console.log('Success:', chapter);
      alert('Pregunta Registrada Exitosamente');
      this.reset(); // Resetea el formulario después de la creación exitosa
      window.location.href = '/gestion';
    })
    .catch((error) => {
      console.error('Error:', error);
    });
});



function cargarSurveyscapPregunta() {
  fetch('/api/survey')
    .then(response => response.json())
    .then(data => {
      const gestionPreguntas = document.getElementById('capitulosecPreguntas');
      gestionPreguntas.innerHTML = "";
      tablaPregunta = `
              <table class="table">
                  <thead>
                      <tr>
                          <th scope="col">Id encuesta</th>
                          <th scope="col">Nombre Encuesta</th>
                          <th scope="col">Capitulo</th>
                          <th scope="col">Preguntas</th>
                          <th scope="col">Acciones</th>
                      </tr>
                  </thead>
                  <tbody> `;
      data.forEach(survey => {
        console.log(survey.enable);
        if (survey.enable == true) {
        tablaPregunta += `
                          <tr>
                              <th scope="row">${survey.id}</th>
                              <td>${survey.name}</td>
                              <td>
                                  <div class="btn-group">
                                      <select onchange="cargarQuestionSelect(${survey.id}, this)" name="todasLasEncuestas" id="encuestaCapituloSec${survey.id}">
                                          <option value="">Seleccione un capítulo</option>
                                      </select>
                                  </div>
                              </td>
                              <td>
                                  <div class="btn-group">
                                      <select onchange="habilitarIcono(${survey.id}, this)" name="todasLasEncuestas" id="capituloPreguntas${survey.id}">
                                          <option value="">Seleccione una pregunta</option>
                                      </select>
                                  </div>
                              </td>
                              <td>
              
                       </td>
                          </tr>
                      `};
        cargarSurveysSelect(survey.id, "encuestaCapituloSec");
      });

      gestionPreguntas.innerHTML += tablaPregunta + `
              
                            `

    })
    .catch((error) => {
      console.error('Error:', error);
    });
}

function habilitarIcono(id,data){
  console.log(id);
  console.log(data);
  preguntaSelect= document.getElementById(`capituloPreguntas${id}`).value;
  fetch(`/api/question/${preguntaSelect}`)
  .then(response => response.json())
  .then(data => {

if(data.response_type=="texto"){
  alert(data.response_type);
  document.getElementById(`agregarRespuestaMultiple${id}`).className ="";
}else{
  alert(data.response_type);
  document.getElementById(`agregarRespuestaMultiple${id}`).className ="bi bi-plus-square-fill";
}

  })
  .catch(error => {
    console.error('Error:', error);
  });
  

};
function cargarQuestionSelect(surveyId, selectElement) {
  const capituloSeleccionado = selectElement.value;
  console.log('Seleccionado ' + capituloSeleccionado);
  fetch('/api/question')
    .then(response => response.json())
    .then(data => {

      const preguntaSelect = document.getElementById(`capituloPreguntas${surveyId}`);
      preguntaSelect.innerHTML = '<option value="">Seleccione una pregunta</option>'; // Limpiar opciones existentes
      data.forEach(question => {
        if (question.chapter.id == capituloSeleccionado) {
          console.log('Pregunta encontrada');
          preguntaSelect.innerHTML += `
                      <option value="${question.id}">${question.question_text}</option>
                  `;
                  
                  // if (question.response_type=="texto"){
                  //   document.getElementById("agregarRespuestaMultiple").title="no puede agregar";
                  // }
        }
      

      });
    })
    .catch(error => {
      console.error('Error:', error);
    });
}



//agregar capitulo anombre agregar pagina


document.addEventListener('DOMContentLoaded', function () {
  // Usa el evento de clic en el contenedor de la tabla
  const editarCapituloContenedor = document.getElementById('capitulosecPreguntas');

  editarCapituloContenedor.addEventListener('click', function (event) {
    // Verifica si el clic fue en un ícono de editar
    if (event.target.classList.contains('bi-pencil-fill')) {
      // Obtén el ID de la encuesta del atributo data-id del ícono
      const encuestaId = event.target.getAttribute('data-id');
      console.log("editar pregunta" + encuestaId);
      // Encuentra el <select> asociado a esta encuesta
      const selectElement = document.getElementById(`capituloPreguntas${encuestaId}`);

      // Obtén el capítulo seleccionado del <select>
      document.getElementById("numeroPregunta").innerText = selectElement.value;
      // Actualiza el texto o realiza cualquier acción con el capítulo seleccionado

      console.log('ID del capítulo seleccionado para editar:', selectElement.value);
    }
    if (event.target.classList.contains('bi-trash3-fill')) {
      // Obtén el ID de la encuesta del atributo data-id del ícono
      const encuestaId = event.target.getAttribute('data-id');
      console.log("editar pregunta" + encuestaId);
      // Encuentra el <select> asociado a esta encuesta
      const selectElement = document.getElementById(`capituloPreguntas${encuestaId}`);

      // Obtén el capítulo seleccionado del <select>
      document.getElementById("seleccionarPregunta").innerText = selectElement.value;
      // Actualiza el texto o realiza cualquier acción con el capítulo seleccionado

      console.log('ID del capítulo seleccionado para editar:', selectElement.value);
      cargarOption();




    }
    if (event.target.classList.contains('bi-plus-square-fill')) {
      // Obtén el ID de la encuesta del atributo data-id del ícono
      const encuestaId = event.target.getAttribute('data-id');
      console.log("editar pregunta" + encuestaId);
      // Encuentra el <select> asociado a esta encuesta
      const selectElement = document.getElementById(`capituloPreguntas${encuestaId}`);

      // Obtén el capítulo seleccionado del <select>
      document.getElementById("seleccionarPregunta").innerText = selectElement.value;
      // Actualiza el texto o realiza cualquier acción con el capítulo seleccionado

      console.log('ID del capítulo seleccionado para editar:', selectElement.value);
      cargarOption();

    }
  });
});


//agragar opcion de repuesta

function cargarOption() {
  fetch('/api/options')
    .then(response => response.json())
    .then(data => {
      const gestionPreguntas = document.getElementById('seleccionOpcion');
      gestionPreguntas.innerHTML = "";
      console.log(data);
      data.forEach(option => {

        gestionPreguntas.innerHTML += `
          <option value="${option.id}">${option.optiontext}</option>
                         
                      `;

      });



    })
    .catch((error) => {
      console.error('Error:', error);
    });
}



function cargarOptionEditar() {
  fetch('/api/options')
    .then(response => response.json())
    .then(data => {
      const gestionPreguntas = document.getElementById('seleccionOpcionEditar');
      gestionPreguntas.innerHTML = "";
      console.log(data);
      data.forEach(option => {

        gestionPreguntas.innerHTML += `
          <option value="${option.id}">${option.optiontext}</option>
                         
                      `;

      });



    })
    .catch((error) => {
      console.error('Error:', error);
    });
}
//agregar opcion respuesta 


function agregarOption() {

  const selectPregunta = document.getElementById("seleccionarPregunta").textContent;
  if (!selectPregunta) {
    alert('Por favor selecciona una encuesta para agregar una opción.');
    return;
  }


  const opcionSeleccionada = document.getElementById("seleccionOpcion").value;
  console.log(opcionSeleccionada);
  const data = {
    "subresponse_number": 1,
    "question": { "id": parseInt(selectPregunta) },
    "options": { "id": parseInt(opcionSeleccionada) }
  };

  fetch('/api/OptionQuestion', {
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

      // cargarSurveys(); // Recargar las encuestas para incluir la nueva
      const modalElement = document.getElementById('exampleModal6');
      const modal = bootstrap.Modal.getInstance(modalElement);
      modal.hide();
    })
    .catch((error) => {
      console.error('Error:', error);
    });

  // {
  //   "subresponse_number":1,
  //       "question": {"id":1},
  //   "options":{"id":1}
  //   }
}



// agregar numoro optionrespuesta a editar



// actualizar opcion respuesta




function ActualizarOption() {

  const selectPregunta = document.getElementById("numeroRespuesta").textContent;
  console.log(selectPregunta)
  if (!selectPregunta) {
    alert('Por favor selecciona una encuesta para agregar una opción.');
    return;
  }


  const opcionSeleccionada = document.getElementById("seleccionOpcionEditar").value;
  console.log(opcionSeleccionada);
  const data = {

    "options": { "id": parseInt(opcionSeleccionada) }
  };

  fetch(`/api/OptionQuestion/${selectPregunta}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  })
    .then(response => response.json())
    .then(data => {
      console.log('Success:', data);
      alert('Encuesta actualizada exitosamente');

      // Cerrar el modal después de la actualización exitosa
      const modalElement = document.getElementById('exampleModal8');
      const modal = bootstrap.Modal.getInstance(modalElement);
      modal.hide();
    })
    .catch((error) => {
      console.error('Error:', error);
    });
};


// actualizar pregunta



document.getElementById('editarPregunta').addEventListener('submit', function (event) {
  event.preventDefault();

  const selectPregunta = document.getElementById("numeroPregunta").textContent;
  if (!selectPregunta) {
    alert('Por favor selecciona una encuesta para editar.');
    return;
  }

  const formData = new FormData(this);
  const data = {};

  for (let [key, value] of formData.entries()) {
    data[key] = value;
  }
  console.log(data);
  fetch(`/api/question/${selectPregunta}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  })
    .then(response => response.json())
    .then(data => {
      console.log('Success:', data);
      alert('Encuesta actualizada exitosamente');
      this.reset();
      // Cerrar el modal después de la actualización exitosa
      const modalElement = document.getElementById('exampleModal5');
      const modal = bootstrap.Modal.getInstance(modalElement);
      modal.hide();
      cargarSurveyscapPregunta();
    })
    .catch((error) => {
      console.error('Error:', error);
    });
});



// pregunta
document.addEventListener('DOMContentLoaded', function () {
  // Usa el evento de clic en el contenedor de la tabla

  const allSurveysDiv = document.getElementById('capitulosecPreguntas');
  allSurveysDiv.addEventListener('click', function (event) {


    // Verifica si el clic fue en un ícono de editar
    if (event.target.classList.contains('bi-trash3-fill')) {
      // Obtén el ID del atributo data-id
      console.log('eliminado');
      agregarCapitulo = event.target.getAttribute('data-id');
      console.log(agregarCapitulo);

      const seleccionarCapitulo = document.getElementById(`capituloPreguntas${agregarCapitulo}`).value;
      if (!seleccionarCapitulo) {
        alert('Por favor selecciona una capitulo para eliminar.');
        return;
      }
      console.log('Obtén el ID del atributo' + seleccionarCapitulo);

      fetch(`/api/question/${seleccionarCapitulo}`, {
        method: 'DELETE',
        headers: {
          'Content-Type': 'application/json; charset=UTF-8'
        }
      })
        .then(response => {
          if (response.ok) {
            // Si la respuesta no tiene contenido (204 No Content), no intentamos analizar JSON.
            if (response.status === 204) {
              return null; // No hay cuerpo para analizar
            }
            return response.json(); // Para respuestas con cuerpo JSON
          } else {
            return response.text().then(text => {
              throw new Error(`Error ${response.status}: ${text}`);
            });
          }
        })
        .then(data => {
          if (data) {
            console.log('capitulo eliminada:', data);
          } else {
            console.log('capitulo eliminada sin datos de respuesta.');
          }
          alert('capitulo eliminada exitosamente');
          cargarSurveyscap();

        })
        .catch(err => {
          console.error('Error:', err);
          alert(`Ocurrió un error al eliminar el capitulo: ${err.message}`);
        });
    }



  });
});



document.addEventListener('DOMContentLoaded', function () {
  var collapseElement = document.getElementById('collapseExample4');
  if (collapseElement) {
    cargarOpcionRespuesta()
  }
});




function cargarOpcionRespuesta() {
  fetch('/api/survey')
    .then(response => response.json())
    .then(data => {
      const gestionPreguntas = document.getElementById('PreguntasRespuesta');
      gestionPreguntas.innerHTML = "";
      tablaPregunta = `
              <table class="table">
                  <thead>
                      <tr>
                          <th scope="col">Id encuesta</th>
              <th scope="col">Nombre Encuesta</th>
              <th scope="col">Capitulo</th>
              <th scope="col">Preguntas</th>
              <th scope="col">Respuestas</th>              
              <th scope="col">Acciones</th>
                      </tr>
                  </thead>
                  <tbody> `;
      data.forEach(survey => {
        console.log(survey.enable);
if (survey.enable==true) {
        tablaPregunta += `
                          <tr>
                              <th scope="row">${survey.id}</th>
                              <td>${survey.name}</td>
                              <td>
                                  <div class="btn-group">
                                      <select onchange="cargarQuestionSelectRes(${survey.id}, this)" name="PreguntasRespuesta" id="todoCapituloRes${survey.id}">
                                          <option value="">Seleccione un capítulo</option>
                                      </select>
                                  </div>
                              </td>
                              <td>
                                  <div class="btn-group">
                                    <select onchange="cargarRespuestSelectRes(${survey.id}, this)" name="todasLasEncuestas" id="todasPreguntas${survey.id}">
                                          <option value="">Seleccione una pregunta</option>
                                      </select>
                                  </div>
                              </td>
                                <td>
                                  <div class="btn-group">
                                      <select name="todasLasEncuestas" id="TodasRespuesta${survey.id}">
                                          <option value="">Seleccione una respuesta</option>
                                      </select>
                                  </div>
                              </td>
                             
                          </tr>
                      `};
        cargarSurveysSelect(survey.id, "todoCapituloRes");

      });

      gestionPreguntas.innerHTML += tablaPregunta + `
              
                            `

    })
    .catch((error) => {
      console.error('Error:', error);
    });
}


function cargarQuestionSelectRes(surveyId, selectElement) {
  const capituloSeleccionado = selectElement.value;
  console.log('Seleccionado ' + capituloSeleccionado);
  fetch('/api/question')
    .then(response => response.json())
    .then(data => {

      const preguntaSelect = document.getElementById(`todasPreguntas${surveyId}`);
      preguntaSelect.innerHTML = '<option value="">Seleccione una pregunta</option>'; // Limpiar opciones existentes
      data.forEach(question => {
        if (question.chapter.id == capituloSeleccionado) {
          console.log('Pregunta encontrada');
          preguntaSelect.innerHTML += `
                                    <option value="${question.id}">${question.question_text}</option>
                                `;
        }

      });
    })
    .catch(error => {
      console.error('Error:', error);
    });
};


function cargarRespuestSelectRes(surveyId, selectElement) {
  const capituloSeleccionado = selectElement.value;
  
  console.log('Seleccionado ' + capituloSeleccionado);
  fetch(`/api/question/${capituloSeleccionado}`)
  .then(response => response.json())
  .then(data => {

if(data.response_type=="texto"){
  document.getElementById(`TodasRespuesta${surveyId}`).disabled=true;
alert("texto");
}else{
  alert("seleccion multiple");
  document.getElementById(`TodasRespuesta${surveyId}`).disabled=false;
  fetch('/api/OptionQuestion')
  .then(response => response.json())
  .then(data => {
    console.log(data);
    const preguntaSelect = document.getElementById(`TodasRespuesta${surveyId}`);
    preguntaSelect.innerHTML = '<option value="">Seleccione una respuesta</option>'; // Limpiar opciones existentes
    data.forEach(OptionRespuesta => {
      if (OptionRespuesta.question.id == capituloSeleccionado) {
        console.log('Pregunta encontrada' + OptionRespuesta.options.optiontext);
        console.log('Pregunta id :' + OptionRespuesta.options.id);

        preguntaSelect.innerHTML += `
                                        <option value="${OptionRespuesta.id}">${OptionRespuesta.options.optiontext}</option>
                                    `;
                                    
      }
     

    });
  })
  .catch(error => {
    console.error('Error:', error);
  });  
}

  })
  .catch(error => {
    console.error('Error:', error);
  });
 
};


//Gestion opcion respuesta

document.addEventListener('DOMContentLoaded', function () {
  // Usa el evento de clic en el contenedor de la tabla
  const editarCapituloContenedor = document.getElementById('PreguntasRespuesta');

  editarCapituloContenedor.addEventListener('click', function (event) {
    // Verifica si el clic fue en un ícono de editar
    if (event.target.classList.contains('bi-pencil-fill')) {
      // Obtén el ID de la encuesta del atributo data-id del ícono
      const encuestaId = event.target.getAttribute('data-id');
      console.log("editar pregunta" + encuestaId);
      // Encuentra el <select> asociado a esta encuesta
      const selectElement = document.getElementById(`TodasRespuesta${encuestaId}`);

      // Obtén el capítulo seleccionado del <select>
      document.getElementById("numeroRespuesta").innerText = selectElement.value;
      // Actualiza el texto o realiza cualquier acción con el capítulo seleccionado
      cargarOptionEditar();
      console.log('ID del capítulo seleccionado para editar:', selectElement.value);
    }
    if (event.target.classList.contains('bi-trash3-fill')) {
      console.log('eliminado');
      agregarCapitulo = event.target.getAttribute('data-id');
      console.log(agregarCapitulo);
      console.log(document.getElementById(`TodasRespuesta${agregarCapitulo}`).value);

      const seleccionarCapitulo = document.getElementById(`TodasRespuesta${agregarCapitulo}`).value;
      if (!seleccionarCapitulo) {
        alert('Por favor selecciona una capitulo para eliminar.');
        return;
      }
      console.log('Obtén el ID del atributo' + seleccionarCapitulo);

      fetch(`/api/OptionQuestion/${seleccionarCapitulo}`, {
        method: 'DELETE',
        headers: {
          'Content-Type': 'application/json; charset=UTF-8'
        }
      })
        .then(response => {
          if (response.ok) {
            // Si la respuesta no tiene contenido (204 No Content), no intentamos analizar JSON.
            if (response.status === 204) {
              return null; // No hay cuerpo para analizar
            }
            return response.json(); // Para respuestas con cuerpo JSON
          } else {
            return response.text().then(text => {
              throw new Error(`Error ${response.status}: ${text}`);
            });
          }
        })
        .then(data => {
          if (data) {
            console.log('Encuesta eliminada:', data);
          } else {
            console.log('Encuesta eliminada sin datos de respuesta.');
          }
          alert('Encuesta eliminada exitosamente');
          window.location.href = '/gestion';
        })
        .catch(err => {
          console.error('Error:', err);
          alert(`Ocurrió un error al eliminar la encuesta: ${err.message}`);
        });



    }
    if (event.target.classList.contains('bi-plus-square-fill')) {
      // Obtén el ID de la encuesta del atributo data-id del ícono
      const encuestaId = event.target.getAttribute('data-id');
      console.log("editar pregunta" + encuestaId);
      // Encuentra el <select> asociado a esta encuesta
      const selectElement = document.getElementById(`todasPreguntas${encuestaId}`);

      // Obtén el capítulo seleccionado del <select>
      document.getElementById("seleccionarPregunta").innerText = selectElement.value;
      // Actualiza el texto o realiza cualquier acción con el capítulo seleccionado

      console.log('ID del capítulo seleccionado para editar:', selectElement.value);
      cargarOption();

    }
  });
});


