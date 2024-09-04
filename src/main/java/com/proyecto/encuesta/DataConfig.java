// package com.proyecto.encuesta;


// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import com.proyecto.encuesta.domain.entities.CategoryCatalog;
// import com.proyecto.encuesta.domain.entities.Chapter;
// import com.proyecto.encuesta.domain.entities.Question;
// import com.proyecto.encuesta.domain.entities.ResponseOption;
// import com.proyecto.encuesta.domain.entities.Survey;
// import com.proyecto.encuesta.infrastructure.repository.categoriesCatalog.CategoryCatalogRepository;
// import com.proyecto.encuesta.infrastructure.repository.chapter.ChapterRepository;
// import com.proyecto.encuesta.infrastructure.repository.question.QuestionRepository;
// import com.proyecto.encuesta.infrastructure.repository.responseOption.ResponseOptionRepository;
// import com.proyecto.encuesta.infrastructure.repository.survey.SurveyRepository;

// @Configuration
// public class DataConfig {

//     @Autowired
//     private CategoryCatalogRepository categoriesCatalogRepository;
//     @Autowired
//     private SurveyRepository surveyRepository;
//     @Autowired
//     private ChapterRepository chapterRepository;
//     @Autowired
//     private QuestionRepository questionRepository;
//     @Autowired
//     private ResponseOptionRepository responseOptionRepository;
//     @Bean
//     public CommandLineRunner initData() {
//         return args -> {
  
//        CategoryCatalog generalCategory = new CategoryCatalog();
//         generalCategory.setName("General");
//         categoriesCatalogRepository.save(generalCategory);

//         CategoryCatalog productFeedbackCategory = new CategoryCatalog();
//         productFeedbackCategory.setName("Product Feedback");
//         categoriesCatalogRepository.save(productFeedbackCategory);
//     // Otros repositorios...

 
//          Survey survey = new Survey();
//             survey.setName("Encuesta de Satisfacción");
//             survey.setDescription("Encuesta para medir la satisfacción de los clientes.");
//             surveyRepository.save(survey);


//              Chapter chapter = new Chapter();
//             chapter.setSurvey(survey);
//             chapter.setChapter_number("Capítulo 1");
//             chapter.setChapter_title("Introducción");
//             chapterRepository.save(chapter);

//             // // Crear y guardar una instancia de CategoryCatalog
//             // CategoryCatalog categoryCatalog = new CategoryCatalog();
//             // categoryCatalog.setName("Categoría 1");
//             // categoriesCatalogRepository.save(categoryCatalog);

//             // Crear y guardar una instancia de Question
//             Question question = new Question();
//             question.setChapter(chapter);
//             question.setQuestion_number("Q1");
//             question.setResponse_type("text");
//             question.setComment_question("¿Cuál es tu nombre?");
//             question.setQuestion_text("Por favor, ingrese su nombre completo.");
//             questionRepository.save(question);
//             // question = new Question();
//             // question.setChapter(chapter);
//             // question.setQuestion_number("Q2");
//             // question.setResponse_type("text");
//             // question.setComment_question("¿tipo documento?");
//             // question.setQuestion_text("Por favor, ingrese seleccione tipo de documento.");
//             // questionRepository.save(question);

            
//             // // Crear y guardar una instancia de ResponseOption
//             // ResponseOption responseOption = new ResponseOption();
//             // responseOption.setOption_value("opt1");
//             // responseOption.setCategoryCatalog(categoryCatalog);
//             // responseOption.setQuestion(question);
//             // responseOption.setTypecomponenthtml("select");
//             // responseOption.setComment_response("Opción de respuesta");
//             // responseOption.setOption_text("Respuesta 1");
//             // responseOptionRepository.save(responseOption);


//         };

        
//     }
// }



