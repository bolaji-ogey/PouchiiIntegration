/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.testgroup;
 

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public  class  GenericCaller   extends    TestAuthourizationInterface {
    
   
   public   JSONObject   testAuthenticateCall(final  JSONObject    testData){
        return    callAuthenticate(testData);
   } 
      
   public   JSONObject   callAuthenticate(final  JSONObject    testData){
        JSONObject   respJson =  new JSONObject();
        HttpClient client = null;
        HttpRequest request = null;
        HttpResponse response = null;
        String  url  =  "";
        JSONObject[]   data =  new JSONObject[1];
        data[0] = new JSONObject();
        System.out.println("Calling authenticate().... . . . .  .  .");
         if(!StringUtils.isEmpty(BASE_URL)){
            url  =  String.format("%s%s", BASE_URL, AuthourizationTestData.LOGIN);
         }else{
           url  =  String.format("%s%s", ALTERNATIVE_BASE_URL, AuthourizationTestData.LOGIN); 
        }
            try{
               client = HttpClient.newHttpClient(); 
                URI uri = new URI(url); 
                 request = HttpRequest.newBuilder(uri)
                            .POST(HttpRequest.BodyPublishers.ofString(testData.toString())) 
                            .header("Content-type", "application/json")
                            .build();
                 response = client.send(request, HttpResponse.BodyHandlers.ofString());                 
                 System.out.println("HTTP Response code := "+response.statusCode());
                 //System.out.println(response.body().toString());
                 if ((response.statusCode() == 200) &&  (response.body() != null)) {
                     String  reqResp = response.body().toString();
                     if(!StringUtils.isEmpty(reqResp) && reqResp.startsWith("{") && reqResp.endsWith("}")){
                            try{  
                                  JSONObject reqRespJson =  new JSONObject(reqResp);
                                   if(!StringUtils.isEmpty(reqRespJson.getString("token"))){
                                      BEARER_TOKEN =  reqRespJson.getString("token");  // Login successfull
                                      System.out.println("Login is successfull");
                                      respJson = new JSONObject();
                                      data[0]  = new JSONObject().put("user", reqRespJson.getJSONObject("user"));
                                      respJson.put("code", "00").put("message", reqRespJson.getString("message"))
                                              .put("data", data);
                                   }else{
                                       respJson = new JSONObject();
                                       respJson.put("code", "99").put("message", reqRespJson.getString("message"))
                                               .put("data", data);
                                   }
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                     }
                 }else{ 
                   String  errStr =  "Resource not available / Network connection error. Status Code: 400"; 
                   respJson = new JSONObject();
                   respJson.put("code", "99").put("data", data);
                   if(response.body() != null){
                       String reqResp = response.body().toString();
                       if(!StringUtils.isEmpty(reqResp) && reqResp.startsWith("{") && reqResp.endsWith("}")){
                            JSONObject  reqRespJson =  new JSONObject(reqResp);
                             respJson.put("message", reqRespJson.getString("message"));
                       }else{   respJson.put("message", errStr).put("data", data);  }
                   }else{   respJson.put("message", errStr).put("data", data);  }
                }
            }catch(Exception ex){
                ex.printStackTrace();
                 String  errStr =  "Resource not available / Network connection error. Status Code: 400"; 
                   respJson = new JSONObject();
                   respJson.put("code", "11").put("message", errStr)
                           .put("data", data);
            }
            System.out.println(respJson.getString("message")); 
        return     respJson;    
   }
    
    
    
  public  JSONObject   postRequest(final String  postURL,  final  JSONObject    testData){
        JSONObject   respJson  =  null;
        HttpClient client = null;
        HttpRequest request = null;
        HttpResponse response = null;
        String  url  =  "";
        JSONObject[]   data =  new JSONObject[1];
        data[0]  = new JSONObject();
         System.out.println(testData.toString());
        System.out.println("Calling  postRequest().... . . . .  .  ."+postURL); 
        System.out.println("postRequest() ::  BEARER_TOKEN :: "+BEARER_TOKEN);
        if(!StringUtils.isEmpty(BASE_URL)){
            url  =  String.format("%s%s", BASE_URL, postURL);
         }else{
           url  =  String.format("%s%s", ALTERNATIVE_BASE_URL, postURL); 
        }
            try{
               client = HttpClient.newHttpClient(); 
                URI uri = new URI(url); 
                 request = HttpRequest.newBuilder(uri)
                            .POST(HttpRequest.BodyPublishers.ofString(testData.toString()))  
                           .header("Authorization",  String.format("%s%s", "Bearer ",BEARER_TOKEN)) 
                          .header("Accept", "application/json")
                          .header("Content-Type", "application/json")
                          .build();
                 response = client.send(request, HttpResponse.BodyHandlers.ofString());
                 System.out.println("HTTP Response code := "+response.statusCode()); 
                 // System.out.println("res.toString(): "+response.body().toString());
            
                if ((response.statusCode() == 200) &&  (response.body() != null)) {
                         try{ 
                              String  responseStr = response.body().toString();
                               if(responseStr.startsWith("{") && responseStr.endsWith("}")){
                                    respJson =  new JSONObject(responseStr);
                                    if(respJson != null){
                                        // Response from RPSL
                                        if(!StringUtils.isEmpty(respJson.getString("code"))){
                                            String  respCode = respJson.getString("code"); 
                                            respCode = respCode.trim();
                                            if(respCode.equals("00")  || respCode.equals("success")){
                                                // OK It is successfull.
                                                // DO other meaningful things.
                                                 System.out.println(respJson.getString("message"));
                                                    if(respCode.contains("suc")){
                                                        respJson.remove("code");
                                                        respJson.put("code", "00");
                                                    } 
                                                   
                                              }else{
                                                 if(respCode.contains("fail")){
                                                        respJson.remove("code");
                                                        respJson.put("code", "99");
                                                  } 
                                            }
                                               try{
                                                    if(respJson.toString().contains("data")){   
                                                        JSONArray   dataStr =   (org.json.JSONArray)respJson.getJSONArray("data");
                                                         if((dataStr != null) && (!dataStr.isEmpty())){ 
                                                             respJson.put("data",  dataStr);
                                                         }
                                                    }                                                         
                                                    }catch(Exception exi){
                                                        exi.printStackTrace();
                                                    } 
                                            
                                            if(respJson.toString().contains("msg")){
                                                respJson.put("message",  respJson.getString("msg"));
                                            } 
                                        }
                                    }
                                }else{
                                    System.out.println(responseStr);
                                   String respStr   =    new String(Base64.getDecoder().decode(responseStr));
                                   System.out.println(respStr);
                                   respJson =  new JSONObject(respStr);
                                    if(respJson != null){
                                        String  respCode = respJson.getString("responseCode");
                                        respCode = respCode.trim();
                                        if(respCode.equals("00")  || respCode.equals("success")){
                                            // OK It is successfull.
                                            // DO other meaningful things.
                                             System.out.println(respJson.getString("msg"));
                                             respJson.put("code",  "00"); 
                                          }else{
                                            respJson.put("code",  "99"); 
                                        }
                                      respJson.put("message",  respJson.getString("msg"));
                                      respJson.put("data",  respJson.getString("data"));
                                    }
                                }   
                            }catch(Exception ex){
                                ex.printStackTrace();
                            } 
                }else{
                     String  errStr =  "Resource not available / Network connection error. Status Code: 400";
                   System.out.println(errStr); 
                   respJson = new JSONObject();
                   respJson.put("code", "99").put("data", data);
                   if(response.body() != null){
                       String reqResp = response.body().toString();
                       if(!StringUtils.isEmpty(reqResp) && reqResp.startsWith("{") && reqResp.endsWith("}")){
                            JSONObject  reqRespJson =  new JSONObject(reqResp);
                             respJson.put("message", reqRespJson.getString("message"));
                       }else{   respJson.put("message", errStr).put("data", data);  }
                   }else{   respJson.put("message", errStr).put("data", data);  }
                }
            }catch(Exception ex){
                ex.printStackTrace();
                 String  errStr =  "Resource not available / Network connection error. Status Code: 400";
                   System.out.println(errStr); 
                   respJson = new JSONObject();
                   respJson.put("code", "11").put("message", errStr)
                           .put("data", data);
            }
            System.out.println(respJson.toString());
        return   respJson;
     }           
             
  
  
  
   public  JSONObject   getRequest(final  String  getURL){
        JSONObject   respJson  =  new JSONObject();
        HttpClient client = null;
        HttpRequest request = null;
        HttpResponse response = null;
        String  url  =  "";
        JSONObject[]   data =  new JSONObject[1];
        data[0]  = new JSONObject(); 
        if(!StringUtils.isEmpty(BASE_URL)){
            url  =  String.format("%s%s", BASE_URL, getURL);
         }else{
           url  =  String.format("%s%s", ALTERNATIVE_BASE_URL, getURL); 
        }
         System.out.println("Calling getRequest().... . . . .  .  ."+url); 
        System.out.println("getRequest() ::  BEARER_TOKEN :: "+BEARER_TOKEN);
            try{
               client = HttpClient.newHttpClient(); 
                URI uri = new URI(url); 
                 request = HttpRequest.newBuilder(uri)
                            .GET()  
                         .header("Authorization",  String.format("%s%s", "Bearer ",BEARER_TOKEN)) 
                          .build();
                 response = client.send(request, HttpResponse.BodyHandlers.ofString());
                 System.out.println("HTTP Response code := "+response.statusCode()); 
                 // System.out.println("res.toString(): "+response.body().toString());
            
                if ((response.statusCode() == 200) &&  (response.body() != null)) {
                         try{ 
                                String  responseStr = response.body().toString();
                                // System.out.println(response.body().toString()); 
                                try{
                                       JSONArray  jsonArr =  new JSONArray(responseStr); 
                                         for (int i = 0; i < jsonArr.length(); i++)
                                         {
                                             JSONObject jsonObj = jsonArr.getJSONObject(i);
                                             System.out.println(jsonObj);
                                         }
                                         if(jsonArr.length() > 0){
                                             respJson.put("code", "00").put("message", "Data Found")
                                                     .put("data", jsonArr);
                                         }else{
                                             respJson.put("code", "11").put("message", "Data NOT Found")
                                                     .put("data", jsonArr);
                                         }
                                }catch(Exception ext){
                                   ;// ext.printStackTrace();
                                }
                               if(!StringUtils.isEmpty(responseStr) && responseStr.startsWith("{") && responseStr.endsWith("}")){
                                    respJson =  new JSONObject(responseStr);
                                    if(respJson != null){
                                        // Response from RPSL
                                        if(!StringUtils.isEmpty(respJson.getString("code"))){
                                            String  respCode = respJson.getString("code");
                                            respCode = respCode.trim();
                                            if(respCode.equals("00") || respCode.equals("success")){
                                                // OK It is successfull.
                                                // DO other meaningful things.
                                                   System.out.println(respJson.getString("message"));
                                                   if(respCode.contains("suc")){
                                                        respJson.remove("code");
                                                        respJson.put("code", "00");
                                                    }                                                 
                                              }else{
                                                 if(respCode.contains("fail")){
                                                        respJson.remove("code");
                                                        respJson.put("code", "99");
                                                  }  
                                              }
                                             try{
                                                    if(respJson.toString().contains("data")){   
                                                        JSONArray   dataStr =   (org.json.JSONArray)respJson.getJSONArray("data");
                                                         if((dataStr != null) && (!dataStr.isEmpty())){ 
                                                             respJson.put("data",  dataStr);
                                                         }
                                                    }                                                         
                                                    }catch(Exception exi){
                                                        exi.printStackTrace();
                                                    } 
                                            
                                            if(respJson.toString().contains("msg")){
                                                respJson.put("message",  respJson.getString("msg"));
                                            }  
                                        }
                                    }else{
                                        
                                           JSONArray jsonArr = null;
                                           try{
                                                    jsonArr =  new JSONArray(responseStr); 
                                                    for (int i = 0; i < jsonArr.length(); i++)
                                                    {
                                                        JSONObject jsonObj = jsonArr.getJSONObject(i);
                                                        System.out.println(jsonObj);
                                                    }
                                                    if(jsonArr.length() > 0){
                                                        respJson.put("code", "00").put("message", "Data Found")
                                                                .put("data", jsonArr);
                                                    }else{
                                                        respJson.put("code", "11").put("message", "Data NOT Found")
                                                                .put("data", jsonArr);
                                                    }
                                           }catch(Exception ext){
                                              ;// ext.printStackTrace();
                                           }
                                    }
                                }else{
                                    System.out.println(responseStr);
                                   String respStr   =    new String(Base64.getDecoder().decode(responseStr));
                                   System.out.println(respStr);
                                  JSONObject respReqJson =  new JSONObject(respStr);
                                    if(respReqJson != null){
                                        String  respCode = respReqJson.getString("responseCode");
                                        respCode = respCode.trim();
                                        if(respCode.equals("00")  || respCode.equals("success")){
                                            // OK It is successfull.
                                            // DO other meaningful things.
                                             System.out.println(respReqJson.getString("msg"));
                                          }
                                    }
                                    respJson =  new JSONObject();
                                    data[0] = new JSONObject();
                                    respJson.put("code",  respReqJson.getString("responseCode"));
                                   respJson.put("message",  respReqJson.getString("msg"));
                                   respJson.put("data",  data);
                                } 
                                //     System.out.println(res.bodyAsJsonObject().toString());
                                // sendOTP();
                            }catch(Exception ex){
                               ;// ex.printStackTrace();
                            }

                }else{
                    String  errStr =  "Resource not available / Network connection error. Status Code: 400";
                   System.out.println(errStr); 
                   respJson = new JSONObject();
                   respJson.put("code", "99").put("data", data);
                   if(response.body() != null){
                       String reqResp = response.body().toString();
                       if(!StringUtils.isEmpty(reqResp) && reqResp.startsWith("{")  && reqResp.endsWith("}")){
                            JSONObject  reqRespJson =  new JSONObject(reqResp);
                             respJson.put("message", reqRespJson.getString("message"));
                       }else{   respJson.put("message", errStr).put("data", data);  }
                   }else{   respJson.put("message", errStr).put("data", data);  }
                } 
            }catch(Exception ex){
                ex.printStackTrace();
                  String  errStr =  "Resource not available / Network connection error. Status Code: 400";
                   System.out.println(errStr); 
                   respJson = new JSONObject();
                   respJson.put("code", "11").put("message", errStr)
                           .put("data", data);
            }
          System.out.println(respJson.toString());
       return    respJson;   
   }
             
   
    
   public  HttpResponse   shortPostRequest(final String  postURL,  final  JSONObject    testData){
        JSONObject   respJson  =  null;
        HttpClient client = null;
        HttpRequest request = null;
        HttpResponse response = null;
        String  url  =  "";
        JSONObject[]   data =  new JSONObject[1];
        data[0]  = new JSONObject();
        System.out.println("Calling shortPostRequest().... . . . .  .  ."+postURL); 
        System.out.println("shortPostRequest() ::  BEARER_TOKEN :: "+BEARER_TOKEN);
        if(!StringUtils.isEmpty(BASE_URL)){
            url  =  String.format("%s%s", BASE_URL, postURL);
         }else{
           url  =  String.format("%s%s", ALTERNATIVE_BASE_URL, postURL); 
        }
            try{
               client = HttpClient.newHttpClient(); 
                URI uri = new URI(url); 
                 request = HttpRequest.newBuilder(uri)
                            .POST(HttpRequest.BodyPublishers.ofString(testData.toString()))  
                         .header("Authorization",  BEARER_TOKEN) 
                          .build();
                 response = client.send(request, HttpResponse.BodyHandlers.ofString());
                 System.out.println("HTTP Response code := "+response.statusCode()); 
                 System.out.println("res.toString():\n "+response.body().toString());
             
            }catch(Exception ex){
                ex.printStackTrace();
                  String  errStr =  "Resource not available / Network connection error. Status Code: 400";
                   System.out.println(errStr); 
                   respJson = new JSONObject();
                   respJson.put("code", "11").put("message", errStr)
                           .put("data", data);
            }
         return   response;
     }           
    
   
   
   
   public  JSONObject   putRequest(final String  postURL,  final  JSONObject    testData){
        JSONObject   respJson  =  null;
        HttpClient client = null;
        HttpRequest request = null;
        HttpResponse response = null;
        String  url  =  "";
        JSONObject[]   data =  new JSONObject[1];
        data[0]  = new JSONObject();
        System.out.println("Calling  postRequest().... . . . .  .  ."+postURL); 
        System.out.println("postRequest() ::  BEARER_TOKEN :: "+BEARER_TOKEN);
        if(!StringUtils.isEmpty(BASE_URL)){
            url  =  String.format("%s%s", BASE_URL, postURL);
         }else{
           url  =  String.format("%s%s", ALTERNATIVE_BASE_URL, postURL); 
        }
            try{
               client = HttpClient.newHttpClient(); 
                URI uri = new URI(url); 
                 request = HttpRequest.newBuilder(uri)
                            .PUT(HttpRequest.BodyPublishers.ofString(testData.toString()))  
                         .header("Authorization",  BEARER_TOKEN) 
                          .build();
                 response = client.send(request, HttpResponse.BodyHandlers.ofString());
                 System.out.println("HTTP Response code := "+response.statusCode()); 
                 // System.out.println("res.toString(): "+response.body().toString());
            
                if ((response.statusCode() == 200) &&  (response.body() != null)) {
                         try{ 
                              String  responseStr = response.body().toString();
                               if(!StringUtils.isEmpty(responseStr) && responseStr.startsWith("{") && responseStr.endsWith("}")){
                                    respJson =  new JSONObject(responseStr);
                                    if(respJson != null){
                                        // Response from RPSL
                                        if(!StringUtils.isEmpty(respJson.getString("code"))){
                                            String  respCode = respJson.getString("code");
                                            respCode = respCode.trim();
                                            if(respCode.equals("00")){
                                                // OK It is successfull.
                                                // DO other meaningful things.
                                                 System.out.println(respJson.getString("message"));
                                              }
                                        }
                                    }
                                }else{
                                    System.out.println(responseStr);
                                   String respStr   =    new String(Base64.getDecoder().decode(responseStr));
                                   System.out.println(respStr);
                                   respJson =  new JSONObject(respStr);
                                    if(respJson != null){
                                        String  respCode = respJson.getString("responseCode");
                                        respCode = respCode.trim();
                                        if(respCode.equals("00")  || respCode.equals("success")){
                                            // OK It is successfull.
                                            // DO other meaningful things.
                                             System.out.println(respJson.getString("msg"));
                                          }
                                    }
                                }   
                            }catch(Exception ex){
                                ex.printStackTrace();
                            } 
                }else{
                    String  errStr =  "Resource not available / Network connection error. Status Code: 400";
                   System.out.println(errStr); 
                   respJson = new JSONObject();
                   respJson.put("code", "11").put("message", errStr);
                }
            }catch(Exception ex){
                ex.printStackTrace();
                  String  errStr =  "Resource not available / Network connection error. Status Code: 400";
                   System.out.println(errStr); 
                   respJson = new JSONObject();
                   respJson.put("code", "11").put("message", errStr)
                           .put("data", data);
            }
        return   respJson;
     }           
     
     
   public  JSONObject   deleteRequest(final String  postURL,  final  String    testData){
        JSONObject   respJson  =  null;
        HttpClient client = null;
        HttpRequest request = null;
        HttpResponse response = null;
        String  url  =  "";
        JSONObject[]   data =  new JSONObject[1];
        data[0]  = new JSONObject();
        System.out.println("Calling  postRequest().... . . . .  .  ."+postURL); 
        System.out.println("postRequest() ::  BEARER_TOKEN :: "+BEARER_TOKEN);
        if(!StringUtils.isEmpty(BASE_URL)){
            url  =  String.format("%s%s", BASE_URL, postURL);
         }else{
           url  =  String.format("%s%s", ALTERNATIVE_BASE_URL, postURL); 
        }        
            try{
               client = HttpClient.newHttpClient(); 
                URI uri = new URI(url); 
                 request = HttpRequest.newBuilder(uri)
                            .DELETE()  
                         .header("Authorization",  BEARER_TOKEN) 
                          .build();
                 response = client.send(request, HttpResponse.BodyHandlers.ofString());
                 System.out.println("HTTP Response code := "+response.statusCode()); 
                 // System.out.println("res.toString(): "+response.body().toString());
            
                if ((response.statusCode() == 200) && (response.body() != null)) {
                         try{ 
                              String  responseStr = response.body().toString();
                               if(!StringUtils.isEmpty(responseStr) && responseStr.startsWith("{") && responseStr.endsWith("}")){
                                    respJson =  new JSONObject(responseStr);
                                    if(respJson != null){
                                        // Response from RPSL
                                        if(!StringUtils.isEmpty(respJson.getString("code"))){
                                            String  respCode = respJson.getString("code");
                                            if(respCode.equals("00")){
                                                // OK It is successfull.
                                                // DO other meaningful things.
                                                 System.out.println(respJson.getString("message"));
                                              }
                                        }
                                    }
                                }else{
                                    System.out.println(responseStr);
                                   String respStr   =    new String(Base64.getDecoder().decode(responseStr));
                                   System.out.println(respStr);
                                   respJson =  new JSONObject(respStr);
                                    if(respJson != null){
                                        String  respCode = respJson.getString("responseCode");
                                        if(respCode.equals("00")){
                                            // OK It is successfull.
                                            // DO other meaningful things.
                                             System.out.println(respJson.getString("msg"));
                                          }
                                    }
                                }   
                            }catch(Exception ex){
                                ex.printStackTrace();
                            } 
                }else{
                    String  errStr =  "Resource not available / Network connection error. Status Code: 400";
                   System.out.println(errStr); 
                   respJson = new JSONObject();
                   respJson.put("code", "11").put("message", errStr);
                }
            }catch(Exception ex){
                ex.printStackTrace();
                  String  errStr =  "Resource not available / Network connection error. Status Code: 400";
                   System.out.println(errStr); 
                   respJson = new JSONObject();
                   respJson.put("code", "11").put("message", errStr)
                           .put("data", data);
            }
        return   respJson;
     }           
     
      
   
   
   public  HttpResponse    shortGetRequest(final  String  getURL){
 
        HttpClient client = null;
        HttpRequest request = null;
        HttpResponse response = null;
        String  url  =  "";
        System.out.println("Calling shortGetRequest().... . . . .  .  ."+getURL); 
        System.out.println("shortGetRequest() ::  BEARER_TOKEN :: "+BEARER_TOKEN);
        if(!StringUtils.isEmpty(BASE_URL)){
            url  =  String.format("%s%s", BASE_URL, getURL);
         }else{
           url  =  String.format("%s%s", ALTERNATIVE_BASE_URL, getURL); 
        }
            try{
               client = HttpClient.newHttpClient(); 
                URI uri = new URI(url); 
                 request = HttpRequest.newBuilder(uri)
                            .GET()  
                         .header("Authorization",  BEARER_TOKEN) 
                          .build();
                 response = client.send(request, HttpResponse.BodyHandlers.ofString());
                 System.out.println("HTTP Response code := "+response.statusCode()); 
                 System.out.println("res.toString():\n "+response.body().toString());
             
            }catch(Exception ex){
                ex.printStackTrace();
            }
         // System.out.println(response.body().toString());
       return   response;    
   }
   
    
   public  HttpResponse   shortPutRequest(final String  postURL,  final  JSONObject    testData){
 
        HttpClient client = null;
        HttpRequest request = null;
        HttpResponse response = null;
        String  url  =  "";
        System.out.println("Calling shortPostRequest().... . . . .  .  ."+postURL); 
        System.out.println("shortPostRequest() ::  BEARER_TOKEN :: "+BEARER_TOKEN);
        if(!StringUtils.isEmpty(BASE_URL)){
            url  =  String.format("%s%s", BASE_URL, postURL);
         }else{
           url  =  String.format("%s%s", ALTERNATIVE_BASE_URL, postURL); 
        }
            try{
               client = HttpClient.newHttpClient(); 
                URI uri = new URI(url); 
                 request = HttpRequest.newBuilder(uri)
                            .PUT(HttpRequest.BodyPublishers.ofString(testData.toString()))  
                         .header("Authorization",  BEARER_TOKEN) 
                          .build();
                 response = client.send(request, HttpResponse.BodyHandlers.ofString());
                 System.out.println("HTTP Response code := "+response.statusCode()); 
                 System.out.println("res.toString():\n "+response.body().toString());
             
            }catch(Exception ex){
                ex.printStackTrace();
            }
         return   response;
     }  
    
    
   public  HttpResponse    shortDeleteRequest(final  String  getURL){
 
        HttpClient client = null;
        HttpRequest request = null;
        HttpResponse response = null;
        String  url  =  "";
        System.out.println("Calling shortGetRequest().... . . . .  .  ."+getURL); 
        System.out.println("shortGetRequest() ::  BEARER_TOKEN :: "+BEARER_TOKEN);
        if(!StringUtils.isEmpty(BASE_URL)){
            url  =  String.format("%s%s", BASE_URL, getURL);
         }else{
           url  =  String.format("%s%s", ALTERNATIVE_BASE_URL, getURL); 
        }
            try{
               client = HttpClient.newHttpClient(); 
                URI uri = new URI(url); 
                 request = HttpRequest.newBuilder(uri)
                            .DELETE()  
                         .header("Authorization",  BEARER_TOKEN) 
                          .build();
                 response = client.send(request, HttpResponse.BodyHandlers.ofString());
                 System.out.println("HTTP Response code := "+response.statusCode()); 
                 System.out.println("res.toString():\n "+response.body().toString());
             
            }catch(Exception ex){
                ex.printStackTrace();
            }
         // System.out.println(response.body().toString());
       return   response;    
   }
     
   
   
   
   
   
   public  JSONObject   postCreateWalletExt(final String  postURL,  final  JSONObject    testData){
        JSONObject   respJson  =  null;
        HttpClient client = null;
        HttpRequest request = null;
        HttpResponse response = null;
        String  url  =  "";
        JSONObject[]   data =  new JSONObject[1];
        data[0]  = new JSONObject();
         System.out.println(testData.toString());
        System.out.println("Calling  postRequest().... . . . .  .  ."+postURL); 
        System.out.println("postRequest() ::  BEARER_TOKEN :: "+BEARER_TOKEN);
        if(!StringUtils.isEmpty(BASE_URL)){
            url  =  String.format("%s%s", BASE_URL, postURL);
         }else{
           url  =  String.format("%s%s", ALTERNATIVE_BASE_URL, postURL); 
        }
            try{
               client = HttpClient.newHttpClient(); 
                URI uri = new URI(url); 
                 request = HttpRequest.newBuilder(uri)
                            .POST(HttpRequest.BodyPublishers.ofString(testData.toString()))  
                           .header("Authorization",  String.format("%s%s", "Bearer ",BEARER_TOKEN)) 
                          .header("Accept", "application/json")
                          .header("Content-Type", "application/json")
                          .build();
                 response = client.send(request, HttpResponse.BodyHandlers.ofString());
                 System.out.println("HTTP Response code := "+response.statusCode()); 
                 // System.out.println("res.toString(): "+response.body().toString());
            
                if ((response.statusCode() == 200) &&  (response.body() != null)) {
                         try{ 
                              String  responseStr = response.body().toString();
                               if(responseStr.startsWith("{") && responseStr.endsWith("}")){
                                    respJson =  new JSONObject(responseStr);
                                    if(respJson != null){
                                        // Response from RPSL
                                        if(!StringUtils.isEmpty(respJson.getString("code"))){
                                            String  respCode = respJson.getString("code"); 
                                            respCode = respCode.trim();
                                            if(respCode.equals("00")  || respCode.equals("success")){
                                                // OK It is successfull.
                                                // DO other meaningful things.
                                                 System.out.println(respJson.getString("message"));
                                                    if(respCode.contains("suc")){
                                                        respJson.remove("code");
                                                        respJson.put("code", "00");
                                                    } 
                                                   
                                              }else{
                                                 if(respCode.contains("fail")){
                                                        respJson.remove("code");
                                                        respJson.put("code", "99");
                                                  } 
                                            }
                                               try{
                                                    if(respJson.toString().contains("data")){   
                                                        JSONArray   dataStr =   (org.json.JSONArray)respJson.getJSONArray("data");
                                                         if((dataStr != null) && (!dataStr.isEmpty())){ 
                                                             respJson.put("data",  dataStr);
                                                         }
                                                    }                                                         
                                                    }catch(Exception exi){
                                                        exi.printStackTrace();
                                                    } 
                                            
                                            if(respJson.toString().contains("msg")){
                                                respJson.put("message",  respJson.getString("msg"));
                                            } 
                                        }
                                    }
                                }else{
                                    System.out.println(responseStr);
                                   String respStr   =    new String(Base64.getDecoder().decode(responseStr));
                                   System.out.println(respStr);
                                   respJson =  new JSONObject(respStr);
                                    if(respJson != null){
                                        String  respCode = respJson.getString("responseCode");
                                        respCode = respCode.trim();
                                        if(respCode.equals("00")  || respCode.equals("success")){
                                            // OK It is successfull.
                                            // DO other meaningful things.
                                             System.out.println(respJson.getString("msg"));
                                             respJson.put("code",  "00"); 
                                          }else{
                                            respJson.put("code",  "99"); 
                                        }
                                      respJson.put("message",  respJson.getString("msg"));
                                      respJson.put("data",  respJson.getString("data"));
                                    }
                                }   
                            }catch(Exception ex){
                                ex.printStackTrace();
                            } 
                }else{
                     String  errStr =  "Resource not available / Network connection error. Status Code: 400";
                   System.out.println(errStr); 
                   respJson = new JSONObject();
                   respJson.put("code", "99").put("data", data);
                   if(response.body() != null){
                       String reqResp = response.body().toString();
                       if(!StringUtils.isEmpty(reqResp) && reqResp.startsWith("{") && reqResp.endsWith("}")){
                            JSONObject  reqRespJson =  new JSONObject(reqResp);
                             respJson.put("message", reqRespJson.getString("message"));
                       }else{   respJson.put("message", errStr).put("data", data);  }
                   }else{   respJson.put("message", errStr).put("data", data);  }
                }
            }catch(Exception ex){
                ex.printStackTrace();
                 String  errStr =  "Resource not available / Network connection error. Status Code: 400";
                   System.out.println(errStr); 
                   respJson = new JSONObject();
                   respJson.put("code", "11").put("message", errStr)
                           .put("data", data);
            }
            System.out.println(respJson.toString());
        return   respJson;
     }           
             
             
    
    
     
}
