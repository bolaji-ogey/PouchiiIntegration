/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.approval.workflow;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class ApprovalItemGroup  implements  ApprovalWType {
    
     private  long  id = -1;
    private  String companyId = "";
    private  String  appCode = "";      
    private  String  itemGroupName = "";
    private  String  itemGroupDescription = "";
    
    private  String  itemGroupCreateDate = "";
    private  String  itemGroupCreateTime = "";
    private  String  itemGroupModificationDate = "";
    private  String  itemGroupModificationTime = "";
     
 
     
    public  ApprovalItemGroup(long inId, String  inCompanyId,  String inAppCode,     
                          String  inItemGroupName,  String inItemGroupDescription,  String inItemGroupCreateDate, 
                                   String  inItemGroupCreateTime,  String  inItemGroupModificationDate,    
                                                 String  inItemGroupModificationTime){
        
        this.id = inId;
        this.companyId = inCompanyId;
        this.appCode =  inAppCode; 
        this.itemGroupName  =  inItemGroupName;
        this.itemGroupDescription = inItemGroupDescription;
        this.itemGroupCreateDate = inItemGroupCreateDate;
        this.itemGroupCreateTime = inItemGroupCreateTime;
        this.itemGroupModificationDate =  inItemGroupModificationDate;
        this.itemGroupModificationTime = inItemGroupModificationTime;
	 
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
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            returnedJsonString  =   objectMapper.writeValueAsString(this);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            objectMapper = null;
        }
      return  returnedJsonString;
   }



      public  static  ApprovalItemGroup  readFromJSON(String  inObjectJSON){ 
        ApprovalItemGroup  approvalItemGroup  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
             objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              approvalItemGroup = objectMapper.readValue(inObjectJSON, ApprovalItemGroup.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
                objectMapper = null;
            }
        return  approvalItemGroup;
    }
      
      

    public   boolean   createApprovalItemGroup(Connection    con) {
         
         PreparedStatement ps  =    null; 
         int  countOfRecordsInserted  =  0;
         boolean  isRecordInserted  = false;  
         
         StringBuilder  INSERT_APPROVAL_ITEM_GROUP_SQL =  new StringBuilder(200);
        INSERT_APPROVAL_ITEM_GROUP_SQL.append("INSERT  INTO  approval_item_groups  (company_id, application_code, item_group_name,  ");
        INSERT_APPROVAL_ITEM_GROUP_SQL.append("  item_group_description,  item_group_creation_date,  item_group_creation_time,  ");
        INSERT_APPROVAL_ITEM_GROUP_SQL.append("    item_group_modification_date,  item_group_modification_time)  "); 
        INSERT_APPROVAL_ITEM_GROUP_SQL.append("   VALUES (?,?,?,?,?,?,?,?) ");
                   
            try { 
                   
                        ps = con.prepareStatement(String.format(INSERT_APPROVAL_ITEM_GROUP_SQL.toString()));
                        
                        ps.setString(1, companyId);
                        ps.setString(2, appCode);
                        ps.setString(3, itemGroupName);
                        ps.setString(4, itemGroupDescription);   
                        ps.setString(5, itemGroupCreateDate);      
                        ps.setString(6, itemGroupCreateTime);
                        ps.setString(7, itemGroupModificationDate);  
                        ps.setString(8, itemGroupModificationTime); 

                        isRecordInserted  =  (ps.executeUpdate() == 1);                      
                  
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                INSERT_APPROVAL_ITEM_GROUP_SQL  = null;
                try{
                    ps = null;
                }catch(Exception er){
                    er.printStackTrace();
                }
            }
        return  isRecordInserted;
    }
      
      
      

}
