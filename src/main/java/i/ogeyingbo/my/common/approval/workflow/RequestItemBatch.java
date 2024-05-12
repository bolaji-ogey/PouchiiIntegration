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
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class RequestItemBatch  implements  ApprovalWType {
    
    private  long  id = -1;
    private  String companyId = "";
    private  String  appCode = "";
    private  long  approvalWorkflowId = -1;
    
    private  long  itemTypeId  = -1;
    private  int  totalItemCount  = 0;
    private  String  totalItemCountInWords = "";
    private  String  totalItemCountInWordsHash = "";
    
    private  boolean isApprovedFinal  =  false;
    private  String  approvedComment  =  "";
    private  String  rejectReason  =  "";
    
    private  String  requestBatchDate = "";
    private  String  requestBatchTime = "";
    private  String  approvedLevel1Date = "";
    private  String  approvedLevel1Time = "";
    
    private  String  approvedLevel2Date = "";
    private  String  approvedLevel2Time = "";
    private  String  approvedLevel3Date = "";
    private  String  approvedLevel3Time = "";
 
     
	 
    public  RequestItemBatch(long inId, String  inCompanyId,  String inAppCode,  long  inApprovalWorkflowId,  
                         long  inItemTypeId, int inTotalItemCount,   String  inTotalItemCountInWords, 
                           String inTotalItemCountInWordsHash,    boolean inIsApprovedFinal,
                          String  inApprovedComment,   String  inRejectReason,  String inRequestBatchDate, 
                             String  inRequestBatchTime,  String  inApprovedLevel1Date,   String  inApprovedLevel1Time,
                                String  inApprovedLevel2Date,   String  inApprovedLevel2Time,
                                     String  inApprovedLevel3Date,   String  inApprovedLevel3Time){
        
        this.id = inId;
        this.companyId = inCompanyId;
        this.appCode =  inAppCode;
        this.itemTypeId = inItemTypeId;
        this.approvalWorkflowId = inApprovalWorkflowId;
        this.totalItemCount = inTotalItemCount;
        this.totalItemCountInWords = inTotalItemCountInWords;
        this.totalItemCountInWordsHash =  inTotalItemCountInWordsHash;
        this.isApprovedFinal = inIsApprovedFinal;
        this.approvedComment  =  inApprovedComment;
        this.rejectReason =  inRejectReason;
        this.requestBatchDate = inRequestBatchDate;
        this.requestBatchTime = inRequestBatchTime;
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
     
     
     
      public  static  RequestItemBatch  readFromJSON(String  inObjectJSON){ 
        RequestItemBatch  requestItemBatch  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              requestItemBatch = objectMapper.readValue(inObjectJSON, RequestItemBatch.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
                objectMapper = null;
            }
        return  requestItemBatch;
    }
      
      
     
    public   boolean   createRequestItemBatch(Connection    con) {
         
         PreparedStatement ps  =    null; 
         int  countOfRecordsInserted  =  0; 
         boolean isRecordInserted = false;
         
         StringBuilder  INSERT_REQUEST_ITEM_BATCH_SQL =  new StringBuilder(200);
            INSERT_REQUEST_ITEM_BATCH_SQL.append("  INSERT  INTO  request_item_batches (company_id, application_code, approval_workflow_id, ");
            INSERT_REQUEST_ITEM_BATCH_SQL.append("  item_type_id,  total_item_count, total_item_count_in_words, total_item_count_in_words_hash ");
            INSERT_REQUEST_ITEM_BATCH_SQL.append("   is_approved_final,  approve_comment,  reject_reason,  request_batch_date, ");
            INSERT_REQUEST_ITEM_BATCH_SQL.append("  request_batch_time,  approved_level_1_date,  approved_level_1_time,  approved_level_2_date, ");
            INSERT_REQUEST_ITEM_BATCH_SQL.append("  approved_level_2_time, approved_level_3_date,  approved_level_3_time)  ");
            INSERT_REQUEST_ITEM_BATCH_SQL.append("   VALUES (?,?,?,?,?,?,?,?,?, 0, '%s') ");
                   
            try { 
                   
                        ps = con.prepareStatement(String.format(INSERT_REQUEST_ITEM_BATCH_SQL.toString()));
                        
                        ps.setString(1, companyId);
                        ps.setString(2, appCode);
                        ps.setLong(3, approvalWorkflowId);
                        ps.setLong(4, itemTypeId);
                        ps.setInt(5, totalItemCount);
                        ps.setString(6, totalItemCountInWords);
                        ps.setString(7, totalItemCountInWordsHash);
                        ps.setBoolean(8, isApprovedFinal);
                        ps.setString(9, approvedComment);
                        ps.setString(10, rejectReason);
                        ps.setString(11, requestBatchDate);
                        ps.setString(12, requestBatchTime);
                        ps.setString(13, approvedLevel1Date);
                        ps.setString(14, approvedLevel1Time);
                        ps.setString(15, approvedLevel2Date);
                        ps.setString(16, approvedLevel2Time);
                        ps.setString(17, approvedLevel3Date);
                        ps.setString(18, approvedLevel3Time);

                        isRecordInserted  =  (ps.executeUpdate() == 1);                      
                  
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                INSERT_REQUEST_ITEM_BATCH_SQL  = null;
                try{
                    ps.close();
                    ps = null;
                }catch(Exception er){
                    er.printStackTrace();
                }
            }
        return  isRecordInserted;
    }

    
}

