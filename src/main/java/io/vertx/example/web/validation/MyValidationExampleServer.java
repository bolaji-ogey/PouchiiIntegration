/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.vertx.example.web.validation;

import io.vertx.core.AbstractVerticle; 
import io.vertx.core.Launcher;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.validation.BodyProcessorException;
import io.vertx.ext.web.validation.ParameterProcessorException;
import io.vertx.ext.web.validation.RequestPredicateException;
import io.vertx.json.schema.Draft;
import io.vertx.json.schema.JsonSchemaOptions;
import io.vertx.json.schema.SchemaParser;
import io.vertx.json.schema.SchemaRouter;
import io.vertx.json.schema.common.dsl.ObjectSchemaBuilder;
import static io.vertx.json.schema.common.dsl.Schemas.arraySchema;
import static io.vertx.json.schema.common.dsl.Schemas.objectSchema;
import static io.vertx.json.schema.common.dsl.Schemas.stringSchema;
import io.vertx.ext.web.validation.RequestParameters;
import io.vertx.ext.web.validation.ValidationHandler;
import io.vertx.ext.web.validation.builder.Bodies;
import io.vertx.ext.web.validation.builder.Parameters;
import io.vertx.ext.web.validation.builder.ValidationHandlerBuilder;
import io.vertx.json.schema.SchemaRepository;
import io.vertx.json.schema.SchemaRouterOptions;
import javax.ws.rs.BadRequestException;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class MyValidationExampleServer extends AbstractVerticle {
    
    
    
    
    
  @Override
  public void start() throws Exception {
   
    ObjectSchemaBuilder    objbodySchemaBuilder =  objectSchema()
                 .property("username", stringSchema())
                 .property("password", stringSchema());
    
    SchemaRepository  schemaRepo = SchemaRepository.create(new JsonSchemaOptions().setDraft(Draft.DRAFT7));
    SchemaParser  schemeParser = SchemaParser.createDraft7SchemaParser(SchemaRouter.create(vertx, new SchemaRouterOptions()));
      
    Router router = Router.router(vertx);
    router.route().handler(BodyHandler.create());
    
        router
         .get("/user")
         .handler(
           ValidationHandlerBuilder 
               .create(schemeParser)
              //.create(schemaRepo)
             .queryParameter(Parameters.explodedParam(
               "myArray",
               arraySchema().items(stringSchema())
             ))
             .body(Bodies.json(objbodySchemaBuilder))
             .body(Bodies.formUrlEncoded(objbodySchemaBuilder))
             .build()
         ).handler(routingContext -> {
           RequestParameters parameters = routingContext.get(ValidationHandler.REQUEST_CONTEXT_KEY);
           JsonArray myArray = parameters.queryParameter("myArray").getJsonArray();
           JsonObject body = parameters.body().getJsonObject();
         });


         router.errorHandler(400, routingContext -> {
             String errorMessage =  "";
         if (routingContext.failure() instanceof BadRequestException) {
           if (routingContext.failure() instanceof ParameterProcessorException) {
             // Something went wrong while parsing/validating a parameter 
                // Something went wrong during validation!
                errorMessage = routingContext.failure().getMessage(); 
                // routingContext.response().setStatusCode(400).end();
           } else if (routingContext.failure() instanceof BodyProcessorException) {
             // Something went wrong while parsing/validating the body
             errorMessage = routingContext.failure().getMessage(); 
           } else if (routingContext.failure() instanceof RequestPredicateException) {
             // A request predicate is unsatisfied
             errorMessage = routingContext.failure().getMessage(); 
           }
           routingContext.response().setStatusCode(400).send(errorMessage);
         }
        });
 
        
         
         vertx.createHttpServer().requestHandler(router).listen();
         
         
  }
 
 
 
  
   public static void main(String[] args) {
    Launcher.executeCommand("run", ValidationExampleServer.class.getName());
  }
   
   
   
    
}
