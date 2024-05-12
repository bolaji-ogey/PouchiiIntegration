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
public class ApprovalWorkflow  implements  ApprovalWType {
    
    private  long  id = -1;
    private  String companyId = "";
    private  String  appCode = "";
    
    private  long  itemGroupId =  -1;
    private  long  itemTypeId =  -1;
    private  int  totalApprovalLevels =  -1;
    private  String  totalApprovalLevelsInWords =  "";
    private  String  totalApprovalLevelsInWordsHash =  "";
    
    private  long  workFlowCreateUserId = -1;
    private  String  workFlowCreateUser  = "";
    private  String  workFlowCreateDate  = "";
    private  String  workFlowCreateTime  = "";
	  
    private  long  workFlowModificationUserId =  -1;
    private  String  workFlowModificationUser =  "";
    private  String  workFlowModificationDate  = "";
    private  String  workFlowModificationTime  = "";
     
     
    public   ApprovalWorkflow(long inId,  String  inCompanyId,  String inAppCode,  long  inItemGroupId,
                        long  inItemTypeId,   int  inTotalApprovalLevels,  String  inTotalApprovalLevelsInWords,   
                     String  inTotalApprovalLevelsInWordsHash,    long  inWorkFlowCreateUserId,  String  inWorkFlowCreateUser,
                      String  inWorkFlowCreateDate,   String  inWorkFlowCreateTime,    long  inWorkFlowModificationUserId,
                  String  inWorkFlowModificationUser,  String inWorkFlowModificationDate,  String inWorkFlowModificationTime){
        
        this.id = inId;
        this.companyId = inCompanyId;
        this.appCode = inAppCode;
        this.itemGroupId = inItemGroupId;
        this.itemTypeId = inItemTypeId;
        this.totalApprovalLevels =  inTotalApprovalLevels;
        this.totalApprovalLevelsInWords  = inTotalApprovalLevelsInWords;
        this.totalApprovalLevelsInWordsHash  = inTotalApprovalLevelsInWordsHash;
        this.workFlowCreateUserId  = inWorkFlowCreateUserId;
        this.workFlowCreateUser = inWorkFlowCreateUser;
        this.workFlowCreateDate  = inWorkFlowCreateDate;
        this.workFlowCreateTime  = inWorkFlowCreateTime;
        this.workFlowModificationUserId = inWorkFlowModificationUserId;
        this.workFlowModificationUser  = inWorkFlowModificationUser;
        this.workFlowModificationDate  =  inWorkFlowModificationDate;
        this.workFlowModificationTime  =  inWorkFlowModificationTime;
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
     
     
     
     public  static  ApprovalWorkflow  readFromJSON(String  inObjectJSON){ 
        ApprovalWorkflow  approvalWorkflow  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
             objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              approvalWorkflow = objectMapper.readValue(inObjectJSON, ApprovalWorkflow.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
                objectMapper = null;
            }
        return  approvalWorkflow;
    }
     
    
   public   boolean   createApprovalWorkflow(Connection    con) {
         
         PreparedStatement ps  =    null; 
         int  countOfRecordsInserted  =  0;
         boolean  isRecordInserted  = false; 
         
         StringBuilder  INSERT_APPROVAL_WORKFLOW_SQL =  new StringBuilder(200);
            INSERT_APPROVAL_WORKFLOW_SQL.append("INSERT  INTO  approval_workflow  (company_id, application_code, ");
            INSERT_APPROVAL_WORKFLOW_SQL.append(" item_group_id,  item_type_id, total_approval_levels,  total_approval_levels_in_words, ");
            INSERT_APPROVAL_WORKFLOW_SQL.append("  total_approval_levels_in_words_hash, workflow_create_user_id,  workflow_create_user, ");
            INSERT_APPROVAL_WORKFLOW_SQL.append("  workflow_create_date,  workflow_create_time,  workflow_modification_user_id,  ");
            INSERT_APPROVAL_WORKFLOW_SQL.append("  workflow_modification_user,  workflow_modification_date,  workflow_modification_time)  ");
            INSERT_APPROVAL_WORKFLOW_SQL.append("   VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
                   
            try { 
                   
                        ps = con.prepareStatement(String.format(INSERT_APPROVAL_WORKFLOW_SQL.toString()));
                        
                        ps.setString(1, companyId);
                        ps.setString(2, appCode);
                        ps.setLong(3, itemGroupId);
                        ps.setLong(4, itemTypeId);
                        ps.setInt(5, totalApprovalLevels);
                        ps.setString(6, totalApprovalLevelsInWords);
                        ps.setString(7, totalApprovalLevelsInWordsHash);
                        ps.setLong(8, workFlowCreateUserId);
                        ps.setString(9, workFlowCreateUser);
                        ps.setString(10, workFlowCreateDate);
                        ps.setString(11, workFlowCreateTime);
                        ps.setLong(12, workFlowModificationUserId);
                        ps.setString(13, workFlowModificationUser);
                        ps.setString(14, workFlowModificationDate);
                        ps.setString(15, workFlowModificationTime);                         

                        isRecordInserted  =  (ps.executeUpdate() == 1);                      
                  
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                INSERT_APPROVAL_WORKFLOW_SQL  = null;
                try{
                    ps = null;
                }catch(Exception er){
                    er.printStackTrace();
                }
            }
        return  isRecordInserted;
    }




}
