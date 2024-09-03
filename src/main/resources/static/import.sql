INSERT INTO survey (description, name,enable) VALUES('Encuesta de Satisfacción del Cliente', 'Encuesta 1', true),
('Encuesta de Compromiso de Empleados', 'Encuesta 2', true),
('Encuesta de Investigación de Mercado', 'Encuesta 3', true),
('Encuesta de Retroalimentación de Productos', 'Encuesta 4', true),
('Encuesta de Usabilidad del Sitio Web', 'Encuesta 5', true),
('Encuesta de Puntuación del Promotor Neto', 'Encuesta 6', true),
('Encuesta de Retroalimentación de Eventos', 'Encuesta 7', true),
('Encuesta de Conciencia de Marca', 'Encuesta 8', true),
('Encuesta de Lealtad del Cliente', 'Encuesta 9', true),
('Encuesta de Satisfacción de Empleados', 'Encuesta 10', true);





INSERT INTO chapter (survey_id, chapter_number, chapter_title) VALUES
(1, '1', 'Introducción'),
(1, '2', 'Visión General'),
(1, '3', 'Preguntas Iniciales'),
(1, '4', 'Experiencia con el Producto'),
(1, '5', 'Navegación en el Sitio Web'),
(2, '1', 'Introducción'),
(2, '2', 'Visión General'),
(2, '3', 'Compromiso del Empleado'),
(2, '4', 'Ambiente de Trabajo'),
(2, '5', 'Satisfacción General'),
(1, '6', 'Experiencia del Cliente'),
(1, '7', 'Satisfacción con el Soporte'),
(1, '8', 'Recomendaciones'),
(1, '9', 'Aspectos Negativos'),
(1, '10', 'Comentarios Finales'),
(2, '6', 'Satisfacción con el Ambiente'),
(2, '7', 'Relaciones con Compañeros'),
(2, '8', 'Compensación'),
(2, '9', 'Desarrollo Profesional'),
(2, '10', 'Opiniones Finales'),
(3, '6', 'Tendencias del Mercado'),
(3, '7', 'Opinión sobre Competencia'),
(3, '8', 'Recomendaciones de Producto'),
(3, '9', 'Factores de Compra'),
(3, '10', 'Comentarios sobre la Encuesta');



INSERT INTO question (chapter_id, question_number, response_type, comment_question, question_text) VALUES(1, '1', 'texto', 'Proporcione comentarios adicionales', '¿Qué tan satisfecho está con nuestro servicio?'),
(2, '1', 'opcion_multiple', '¿Qué producto compró?', 'Seleccione el producto que compró.'),
(3, '1', 'calificacion', 'Califique su satisfacción general.', '¿Qué tan satisfecho está con el producto?'),
(4, '1', 'texto', 'Proporcione razones para su calificación', '¿Recomendaría nuestro producto?'),
(5, '1', 'si_no', '¿Fue fácil de navegar el sitio web?', '¿Fue fácil de navegar el sitio web?'),
(6, '1', 'texto', 'Explique su elección', '¿El evento cumplió con sus expectativas?'),
(7, '1', 'opcion_multiple', '¿Cómo se enteró de nosotros?', '¿Cómo se enteró de nuestro producto o servicio?'),
(8, '1', 'calificacion', 'Califique su lealtad a nuestra marca.', '¿Qué tan leal se siente a nuestra marca?'),
(9, '1', 'texto', 'Agregue comentarios adicionales', '¿Qué mejoras sugeriría?'),
(10, '1', 'si_no', '¿Volvería a tomar esta encuesta?', '¿Tomaría esta encuesta nuevamente?'),
(1, '2', 'opcion_multiple', '¿Qué es lo que más le gustó del producto?', 'Seleccione lo que más le gustó del producto.'),
(6, '1', 'texto', '¿Cómo calificaría su experiencia general con nuestro servicio?', '¿Cómo calificaría su experiencia general con nuestro servicio?'),
(6, '2', 'calificacion', 'Califique su satisfacción con la atención recibida.', 'Califique su satisfacción con la atención recibida.'),
(7, '1', 'opcion_multiple', '¿Qué aspectos del soporte le resultaron más útiles?', '¿Qué aspectos del soporte le resultaron más útiles?'),
(8, '1', 'texto', '¿Qué recomendaría para mejorar nuestros servicios?', '¿Qué recomendaría para mejorar nuestros servicios?'),
(9, '1', 'texto', '¿Qué aspectos negativos encontró en nuestro producto?', '¿Qué aspectos negativos encontró en nuestro producto?'),
(10, '1', 'texto', 'Comentarios adicionales sobre la encuesta.', 'Comentarios adicionales sobre la encuesta.'),
(6, '1', 'texto', '¿Cómo calificaría el ambiente de trabajo en general?', '¿Cómo calificaría el ambiente de trabajo en general?'),
(7, '1', 'opcion_multiple', '¿Cómo describiría su relación con sus compañeros?', '¿Cómo describiría su relación con sus compañeros?'),
(8, '1', 'calificacion', 'Califique su satisfacción con su compensación actual.', 'Califique su satisfacción con su compensación actual.'),
(9, '1', 'texto', '¿Qué oportunidades de desarrollo profesional le gustaría tener?', '¿Qué oportunidades de desarrollo profesional le gustaría tener?'),
(10, '1', 'texto', 'Comentarios finales sobre su experiencia laboral.', 'Comentarios finales sobre su experiencia laboral.'),
(6, '1', 'opcion_multiple', '¿Qué tendencias del mercado le parecen más relevantes?', '¿Qué tendencias del mercado le parecen más relevantes?'),
(7, '1', 'texto', '¿Qué opinión tiene sobre nuestros competidores?', '¿Qué opinión tiene sobre nuestros competidores?'),
(8, '1', 'texto', '¿Qué mejoras sugeriría para nuestro producto?', '¿Qué mejoras sugeriría para nuestro producto?'),
(9, '1', 'opcion_multiple', '¿Qué factores influyen más en su decisión de compra?', '¿Qué factores influyen más en su decisión de compra?'),
(10, '1', 'texto', 'Comentarios finales sobre el proceso de encuesta.', 'Comentarios finales sobre el proceso de encuesta.');

INSERT INTO options (optiontext) 
VALUES
("no"),
("si");


