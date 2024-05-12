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
public class ApprovalItemType  implements  ApprovalWType {
    
    private  long  id = -1;
    private String  companyId = "";
    private String  appCode =  "";
    private  long    approvalItemGroupId = -1;
    private String   itemName = "";
    private String  description = "";
    private  boolean isFinancialRelated = false;
    private  boolean isPhysicalObjectRelated = false;
    private  boolean isRelocationRelated = false;
    
    private  String  approvalItemTable  = "";
    private  String  itemTypeCreator  = "";
    private  String  itemTypeCreateDate  = "";
    private  String  itemTypeCreateTime  = "";
     
        
       
    public  ApprovalItemType(long  inId,  String  inCompanyId,  String inAppCode, long  inApprovalItemGroupId,
                                     String  inItemName,  String  inDescription, boolean inIsFinancialRelated,
                    boolean inIsPhysicalObjectRelated,  boolean  inIsRelocationRelated,  String  inApprovalItemTable,
                        String  inItemTypeCreator,  String inItemTypeCreateDate,  String  inItemTypeCreateTime){
        
        this.id = inId;
        this.companyId = inCompanyId;
        this.appCode = inAppCode;
        this.approvalItemGroupId = inApprovalItemGroupId;
        this.itemName = inItemName;
        this.description = inDescription;
        this.isFinancialRelated = inIsFinancialRelated;
        this.isPhysicalObjectRelated =  inIsPhysicalObjectRelated;
        this.isRelocationRelated  =  inIsRelocationRelated;
        this.approvalItemTable  = inApprovalItemTable;
        this.itemTypeCreator =  inItemTypeCreator;
        this.itemTypeCreateDate  =  inItemTypeCreateDate;
        this.itemTypeCreateTime  =  inItemTypeCreateTime;
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
    
    
    
    
      public  static  ApprovalItemType  readFromJSON(String  inObjectJSON){ 
        ApprovalItemType  approvalItemType  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
               objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              approvalItemType = objectMapper.readValue(inObjectJSON, ApprovalItemType.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
                objectMapper = null;
            }
        return  approvalItemType;
    }
      
      
    
    public   boolean   createApprovalItemType(Connection    con) {
         
         PreparedStatement ps  =    null; 
         int  countOfRecordsInserted  =  0;
         boolean  isRecordInserted  = false; 
                   
         StringBuilder  INSERT_APPROVAL_ITEM_TYPE_SQL =  new StringBuilder(200);
            INSERT_APPROVAL_ITEM_TYPE_SQL.append("INSERT  INTO  approval_item_types  (company_id, application_code, ");
            INSERT_APPROVAL_ITEM_TYPE_SQL.append(" approval_item_group_id, item_name,   description,  is_financial_related, ");
            INSERT_APPROVAL_ITEM_TYPE_SQL.append("  is_physical_object_related, is_relocation_related, approval_item_table,   ");
            INSERT_APPROVAL_ITEM_TYPE_SQL.append(" item_type_creator,  item_type_creation_date, item_type_creation_time)  "); 
            INSERT_APPROVAL_ITEM_TYPE_SQL.append("   VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
                   
            try { 
                   
                        ps = con.prepareStatement(String.format(INSERT_APPROVAL_ITEM_TYPE_SQL.toString()));
                        
                        ps.setString(1, companyId);
                        ps.setString(2, appCode);
                        ps.setLong(3, approvalItemGroupId);
                        ps.setString(4, itemName);
                        ps.setString(5, description);
                        ps.setBoolean(6, isFinancialRelated);
                        ps.setBoolean(7, isPhysicalObjectRelated);
                        ps.setBoolean(8, isRelocationRelated);
                        ps.setString(9, approvalItemTable);
                        ps.setString(10, itemTypeCreator);
                        ps.setString(11, itemTypeCreateDate);
                        ps.setString(12, itemTypeCreateTime);                          

                        isRecordInserted  =  (ps.executeUpdate() == 1);                      
                  
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                INSERT_APPROVAL_ITEM_TYPE_SQL  = null;
                try{
                    ps = null;
                }catch(Exception er){
                    er.printStackTrace();
                }
            }
        return  isRecordInserted;
    }

    
}
