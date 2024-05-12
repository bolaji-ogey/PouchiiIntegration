/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.approval.workflow;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class ApprovalUserGroup  implements  ApprovalWType {
    
     private  long  id = -1;
    private  String companyId = "";
    private  String  appCode = "";      
    private  String  userGroupName = "";
    private  String  userGroupDescription = "";
    
    private  int  userGroupApprovalLevel =  -1;
    private  String  userGroupCreateDate = "";
    private  String  userGroupCreateTime = "";
    private  String  userGroupModificationDate = "";
    private  String  userGroupModificationTime = "";
     
 
    public ApprovalUserGroup(){
        
    }
     
    public  ApprovalUserGroup(long inId, String  inCompanyId,  String inAppCode,  String  inUserGroupName,    
                        String inUserGroupDescription,  int inUserGroupApprovalLevel,  String inUserGroupCreateDate, 
                                   String  inUserGroupCreateTime,  String  inUserGroupModificationDate,    
                                                 String  inUserGroupModificationTime){
        
        this.id = inId;
        this.companyId = inCompanyId;
        this.appCode =  inAppCode; 
        this.userGroupName  =  inUserGroupName;
        this.userGroupDescription = inUserGroupDescription;
        this.userGroupApprovalLevel =  inUserGroupApprovalLevel;
        this.userGroupCreateDate = inUserGroupCreateDate;
        this.userGroupCreateTime = inUserGroupCreateTime;
        this.userGroupModificationDate =  inUserGroupModificationDate;
        this.userGroupModificationTime = inUserGroupModificationTime;
	 
}
    

    
    
     public  final  JSONObject  convertToJSON(){
        JSONObject  returnedJson =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
             objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
           returnedJson =  new JSONObject(objectMapper.writeValueAsString(this));
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            objectMapper = null;
        }
      return  returnedJson;
    }
     
     

 public  final  String  convertToJSONString(){
        String  returnedJsonString =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
            returnedJsonString  =   objectMapper.writeValueAsString(this);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            objectMapper = null;
        }
      return  returnedJsonString;
   }


 
 
     public  static  ApprovalUserGroup  readFromJSON(String  inObjectJSON){ 
        ApprovalUserGroup  approvalUserGroup  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
              approvalUserGroup =   objectMapper.readValue(inObjectJSON, ApprovalUserGroup.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
                objectMapper = null;
            }
        return  approvalUserGroup;
    }
     
     
    
    public   boolean   createApprovalUserGroup(Connection    con) {
         
         PreparedStatement ps  =    null; 
         int  countOfRecordsInserted  =  0;
         boolean  isRecordInserted  = false; 
                   
       StringBuilder  INSERT_APPROVAL_USER_GROUP_SQL =  new StringBuilder(200);
        INSERT_APPROVAL_USER_GROUP_SQL.append("INSERT  INTO  approval_item_groups  (company_id, application_code,");
        INSERT_APPROVAL_USER_GROUP_SQL.append("   user_group_name, user_group_description,  user_group_approval_level, ");
        INSERT_APPROVAL_USER_GROUP_SQL.append("  item_group_creation_date,  user_group_creation_time,  user_group_modification_date, "); 
        INSERT_APPROVAL_USER_GROUP_SQL.append(" user_group_modification_time)  VALUES (?,?,?,?,?,?,?,?) ");
                   
            try { 
                   
                        ps = con.prepareStatement(String.format(INSERT_APPROVAL_USER_GROUP_SQL.toString()));
                        
                        ps.setString(1, companyId);
                        ps.setString(2, appCode);
                        ps.setString(3, userGroupName);
                        ps.setString(4, userGroupDescription);   
                        ps.setLong(5, userGroupApprovalLevel); 
                        ps.setString(6, userGroupCreateDate);      
                        ps.setString(7, userGroupCreateTime);
                        ps.setString(8, userGroupModificationDate);  
                        ps.setString(9, userGroupModificationTime); 

                        isRecordInserted  =  (ps.executeUpdate() == 1);                      
                  
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                INSERT_APPROVAL_USER_GROUP_SQL  = null;
                try{
                    ps = null;
                }catch(Exception er){
                    er.printStackTrace();
                }
            }
        return  isRecordInserted;
    }
      
      
      
      
      
   /****       
   private void writeJSON(Student student) throws JsonGenerationException, JsonMappingException, IOException{
      ObjectMapper mapper = new ObjectMapper();	
      mapper.writeValue(new File("student.json"), student);
   }

   private Student readJSON() throws JsonParseException, JsonMappingException, IOException{
      ObjectMapper mapper = new ObjectMapper();
      Student student = mapper.readValue(new File("student.json"), Student.class);
      return student;
   }
    ***/ 

    public  static  void main(String[] args){
        ApprovalUserGroup   approvalUserGroup = new ApprovalUserGroup();
        System.out.println(approvalUserGroup.convertToJSONString());
        
        System.out.println("Hash Value of Bearer Token = "+"eyJhbGciOiJIUzUxMiJ9.eyJBVVRIRU5USUNBVElPTl9QQVJUTkVSX0lEIjo2LCJBVVRIRU5USUNBVElPTl9SRVFVRVNUX0NIQU5ORUxfSUQiOiJCQU5JQ09PUCIsIkFVVEhFTlRJQ0FUSU9OX1JFTUVNQkVSX01FIjp0cnVlLCJBVVRIRU5USUNBVElPTl9BUFBMSUNBVElPTl9DT0RFIjoiUE9VQ0hJSSIsIlNFQ1VSSVRZX0FVVEhPUklUWV9VU0VSSUQiOjE4MCwiQVVUSEVOVElDQVRJT05fUEFSVE5FUl9DT0RFIjoiQkFOSUNPT1AiLCJBVVRIRU5USUNBVElPTl9SRVFVRVNUX0NIQU5ORUxfVFlQRSI6IkludGVncmF0b3IiLCJTRUNVUklUWV9BVVRIT1JJVFkiOiJNZXJjaGFudCIsIkFQUExJQ0FUSU9OX01PRFVMRSI6IklOVEVHUkFUT1IiLCJJU19GSVJTVF9MT0dJTiI6ZmFsc2UsIkFVVEhFTlRJQ0FUSU9OX0FQUF9JRCI6MSwiQVVUSEVOVElDQVRJT05fUkVRVUVTVF9DSEFOTkVMIjoiQXBpIiwic3ViIjoiMzVlYWIwZDQtYTQ2OC00MjFiLTk1ZjctM2EzODYxNmZmMDU2IiwiaXNzIjoiMzVlYWIwZDQtYTQ2OC00MjFiLTk1ZjctM2EzODYxNmZmMDU2IiwiaWF0IjoxNzAyMzg4NDQ0LCJleHAiOjE3MDI0MTM2NDQsImp0aSI6IlRVdHlkRFJOTVhOeVdFeFdRVWRMY2xkM1JDc3hiR2RJYTNkdWJFNXRjalJGWlhsTkwzUnZNSEV5T0QwPSIsImF1ZCI6WyJQb3N0bWFuUnVudGltZS83LjM1LjAiXX0.Q4NSgfNNrHAFrT7sAAod0eXpalDtpEEuPR7usAfAaI84U4OeqkZgM8gHWKzaC7Yuh3uGjoa00shm2SZsuQUrCQ".hashCode());
        /***
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        try{
           System.out.println(objectMapper.writeValueAsString(approvalUserGroup));
        }catch(Exception ex){
            ex.printStackTrace();
        }
        * **/
    }
   
    
}
