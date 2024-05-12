/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.approval.workflow;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class ApprovalRequest  implements  ApprovalWType  {
        
    private long id = -1;
    private String  companyId = "";
    private String  appCode = "";
    private long approvalWorkflowId = -1;
    private long itemTypeId = -1;
    private long itemGroupId = -1;
    private String  itemGroupName = "";
    private long approvalBatchId = -1; 
    private long approvalItemId = -1;// approval_items
    private long batchItemCount = -1;
    
    private long  userRequestId = -1;
    private long  currentApproverId = -1;
    private int  currentApproverLevel = -1;
    private long  requestUserId = -1;
    private String  requestUser = "";
    
    private String  requestInitiationDate = "";
    private String  requestInitiationTime = "";
    
    private  boolean isApprovedFinal  =  false;
    private  String  approvedComment  =  "";
    private  String  rejectReason  =  "";
    
    private String  approvedLevel1Date  = "";
    private String  approvedLevel1Time = "";
    
    private String  approvedLevel2Date  = "";
    private String  approvedLevel2Time = "";
    
    private String  approvedLevel3Date  = "";
    private String  approvedLevel3Time = "";
	  
 
    
    
    public  ApprovalRequest(long  inId, String inCompanyId, String inAppCode, long inApprovalWorkflowId,  long inItemTypeId,
                      long inItemGroupId,  String inItemGroupName,  long inApprovalBatchId,   long inApprovalItemId,
                      long inBatchItemCount,  long  inUserRequestId,  long  inCurrentApproverId, 
                         int inCurrentApprovalLevel, long inRequestUserId,  String  inRequestUser,  
                               String  inRequestInitiationDate, String inRequestInitiationTime,  
                               boolean inIsApprovedFinal,  String  inApprovedComment,   String  inRejectReason,
                                 String inApprovedLevel1Date,   String inApprovedLevel1Time,  String inApprovedLevel2Date,  
                                   String inApprovedLevel2Time, String  inApprovedLevel3Date,  String  inApprovedLevel3Time){
        
        this.id = inId;
        this.companyId = inCompanyId;
        this.appCode =  inAppCode;
        this.approvalWorkflowId = inApprovalWorkflowId;
        this.itemTypeId = inItemTypeId;
        this.itemGroupId = inItemGroupId;
        this.itemGroupName = inItemGroupName;
        this.approvalBatchId =  inApprovalBatchId;
        this.approvalItemId =  inApprovalItemId;
        this.batchItemCount = inBatchItemCount;
        this.userRequestId = inUserRequestId;
        this.requestInitiationDate =  inRequestInitiationDate;
        this.requestInitiationTime = inRequestInitiationTime;
        this.isApprovedFinal = inIsApprovedFinal;
        this.approvedComment  =  inApprovedComment;
        this.rejectReason =  inRejectReason;
        this.approvedLevel1Date = inApprovedLevel1Date;
        this.approvedLevel1Time = inApprovedLevel1Time;
        this.approvedLevel2Date = inApprovedLevel2Date;
        this.approvedLevel2Time = inApprovedLevel2Time;
        this.approvedLevel3Date = inApprovedLevel3Date;
        this.approvedLevel3Time = inApprovedLevel3Time;
        
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
    

    
    
     public  static  ApprovalRequest  readFromJSON(String  inObjectJSON){ 
        ApprovalRequest  approvalRequest  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              approvalRequest = objectMapper.readValue(inObjectJSON, ApprovalRequest.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
                objectMapper = null;
            }
        return  approvalRequest;
    }
 
       
    public   boolean   createApprovalRequest(Connection    con) {
         
         PreparedStatement ps  =    null; 
         int  countOfRecordsInserted  =  0;
         boolean  isRecordInserted  = false; 
                   
         StringBuilder  INSERT_APPROVAL_REQUEST_SQL =  new StringBuilder(200);
            INSERT_APPROVAL_REQUEST_SQL.append("INSERT  INTO  approval_requests  (company_id, application_code, approval_workflow_id,");
            INSERT_APPROVAL_REQUEST_SQL.append(" item_type_id,  item_group_id, item_group_name, approval_batch_id, batch_item_count, ");
            INSERT_APPROVAL_REQUEST_SQL.append("  user_request_id, current_approver_id, current_approver_level,  request_user_id,");
            INSERT_APPROVAL_REQUEST_SQL.append("   request_user,   request_initiation_date, request_initiation_time,  is_approved_final,  ");
            INSERT_APPROVAL_REQUEST_SQL.append("  approve_comment, reject_reason, approved_level_1_date,  approved_level_1_time, ");
            INSERT_APPROVAL_REQUEST_SQL.append("     approved_level_2_date, approved_level_2_time, approved_level_3_date,   ");
            INSERT_APPROVAL_REQUEST_SQL.append("   approved_level_3_time)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ");
            INSERT_APPROVAL_REQUEST_SQL.append("   ?,?,?,?,?,?,?,?,) ");
                   
            try { 
                   
                        ps = con.prepareStatement(String.format(INSERT_APPROVAL_REQUEST_SQL.toString()));
                        
                        ps.setString(1, companyId);
                        ps.setString(2, appCode);
                        ps.setLong(3, approvalWorkflowId);
                        ps.setLong(4, itemTypeId);
                        ps.setLong(5, itemGroupId);
                        ps.setString(6, itemGroupName);
                        ps.setLong(7, approvalBatchId);
                        ps.setLong(8, batchItemCount);
                        ps.setLong(9, userRequestId);
                        ps.setLong(10, currentApproverId);
                        ps.setInt(11, currentApproverLevel);
                        ps.setLong(12, requestUserId);
                        ps.setString(13, requestUser);
                        ps.setString(14, requestInitiationDate);
                        ps.setString(15, requestInitiationTime);
                        ps.setBoolean(16, isApprovedFinal);
                        ps.setString(17, approvedComment);
                        ps.setString(18, rejectReason);    
                        ps.setString(19, approvedLevel1Date);
                        ps.setString(20, approvedLevel1Time);
                        ps.setString(21, approvedLevel2Date);
                        ps.setString(22, approvedLevel2Time);
                        ps.setString(23, approvedLevel3Date);
                        ps.setString(24, approvedLevel3Time);

                        isRecordInserted  =  (ps.executeUpdate() == 1);                      
                  
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                INSERT_APPROVAL_REQUEST_SQL  = null;
                try{
                    ps = null;
                }catch(Exception er){
                    er.printStackTrace();
                }
            }
        return  isRecordInserted;
    }

       
       
}
