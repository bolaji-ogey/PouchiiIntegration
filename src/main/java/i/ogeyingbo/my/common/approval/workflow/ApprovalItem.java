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
public class ApprovalItem  implements  ApprovalWType {
    
    private  long  id = -1;
    private  String companyId = "";
    private  String  appCode = "";
    private  long  approvalWorkflowId = -1;
    private  long itemTypeId =   -1;
    private  long itemGroupId =   -1;
    private  String  itemName = "";
    private  long  approvalBatchId =   -1;
    private  long  userRequestId =   -1;
    
    private  long  currentApproverId =   -1;
    private  long  currentApproverLevel =   -1;
    private  long  requestUserId =   -1;
    private  String  requestUser  =   "";
    
    private  boolean isApprovedFinal  =  false;
    private  String  approvedComment  =  "";
    private  String  rejectReason  =  "";
    
    private  String  requestInitiationDate  =   "";
    private  String  requestInitiationTime  =   "";
       
 
    public   ApprovalItem(long inId, String  inCompanyId,  String inAppCode,  long  inApprovalWorkflowId,
                           long  inItemTypeId,  long  inItemGroupId, String  inItemName, long  inApprovalBatchId, 
                              long  inUserRequestId,   long  inCurrentApproverId,  
                   long  inCurrentApproverLevel,  long inRequestUserId,  String  inRequestUser, 
                   boolean inIsApprovedFinal,  String  inApprovedComment,   String  inRejectReason,
                          String  inRequestInitiationDate,   String  inRequestInitiationTime){
        
       this.id = inId; 
       this.companyId = inCompanyId;
       this.appCode = inAppCode;
       this.approvalWorkflowId =  inApprovalWorkflowId;
       this.itemTypeId = inItemTypeId;
       this.itemGroupId = inItemGroupId;
       this.itemName = inItemName;
       this.approvalBatchId = inApprovalBatchId;
       this.userRequestId = inUserRequestId;
       this.currentApproverId = inCurrentApproverId;
       this.currentApproverLevel =  inCurrentApproverLevel;
       this.requestUserId  =  inRequestUserId;
       this.requestUser = inRequestUser;
       this.isApprovedFinal = inIsApprovedFinal;
       this.approvedComment  =  inApprovedComment;
        this.rejectReason =  inRejectReason;
       this.requestInitiationDate =  inRequestInitiationDate;
       this.requestInitiationTime =  inRequestInitiationTime;
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
   
    
    
     public  static  ApprovalItem  readFromJSON(String  inObjectJSON){ 
        ApprovalItem  approvalItem  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              approvalItem = objectMapper.readValue(inObjectJSON, ApprovalItem.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
                objectMapper = null;
            }
        return  approvalItem;
    }
     
     
    
    public   boolean   createApprovalItem(Connection    con) {
         
         PreparedStatement ps  =    null; 
         int  countOfRecordsInserted  =  0;
         boolean  isRecordInserted  = false; 
         
         StringBuilder  INSERT_APPROVAL_ITEM_SQL =  new StringBuilder(200);
            INSERT_APPROVAL_ITEM_SQL.append("INSERT  INTO  approval_items  (company_id, application_code, item_type_id,  ");
            INSERT_APPROVAL_ITEM_SQL.append(" item_group_id, item_name, approval_batch_id,   user_request_id, current_approver_id,  ");
            INSERT_APPROVAL_ITEM_SQL.append("   current_approver_level,  request_user_id, request_user,   is_approved_final, ");
            INSERT_APPROVAL_ITEM_SQL.append(" approve_comment, reject_reason, request_initiation_date, request_initiation_time) "); 
            INSERT_APPROVAL_ITEM_SQL.append("   VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
                   
            try { 
                   
                        ps = con.prepareStatement(String.format(INSERT_APPROVAL_ITEM_SQL.toString()));
                        
                        ps.setString(1, companyId);
                        ps.setString(2, appCode);
                        ps.setLong(3, itemTypeId);
                        ps.setLong(4, itemGroupId);  
                        ps.setString(5, itemName);
                        ps.setLong(6, approvalBatchId);
                        ps.setLong(7, userRequestId);
                        ps.setLong(8, currentApproverId);
                        ps.setLong(9, currentApproverLevel);
                        ps.setLong(10, requestUserId);
                        ps.setString(11, requestUser);                   
                        ps.setBoolean(12, isApprovedFinal);
                        ps.setString(13, approvedComment);
                        ps.setString(14, rejectReason);  
                        ps.setString(15, requestInitiationDate);
                        ps.setString(16, requestInitiationTime);

                        isRecordInserted  =  (ps.executeUpdate() == 1);                      
                  
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                INSERT_APPROVAL_ITEM_SQL  = null;
                try{
                    ps = null;
                }catch(Exception er){
                    er.printStackTrace();
                }
            }
        return  isRecordInserted;
    }
       
       
       

    
}
