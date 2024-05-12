/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.my.common.approval.workflow;

 
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;  
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class WorkFlowUtils<T> {
    
    private  static    WorkFlowUtils   workFlowUtils =  null;
    
    private  WorkFlowUtils(){ 
    }
    
    public static WorkFlowUtils getInstance()
    {
        if (workFlowUtils == null)
        {
            synchronized (WorkFlowUtils.class)
            {
                workFlowUtils = new WorkFlowUtils();
            } 
        } 
        return   workFlowUtils;
    }
    
    
   
     public  final  String  convertToJSONString(ArrayList<Object>    inArrayList){
        String  returnedJsonString =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            returnedJsonString  =   objectMapper.writeValueAsString(inArrayList);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            objectMapper = null;
        }
      return  returnedJsonString;
   }
 
    
     
     
     
      public  final static JSONObject  convertToJSON(ApprovalWType  approvalWType){
        JSONObject  returnedJson =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
             objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
           returnedJson =  new JSONObject(objectMapper.writeValueAsString(approvalWType));
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            objectMapper = null;
        }
      return  returnedJson;
    }
    
    
    public  final static String  convertToJSONString(ApprovalWType  approvalWType){
        String  returnedJsonString =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            returnedJsonString  =   objectMapper.writeValueAsString(approvalWType);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            objectMapper = null;
        }
      return  returnedJsonString;
    }
     
     
   public  final   ArrayList<ApprovalRequest>    retrApprovalRequests(Connection  cron, String inCompanyId, long  inCurrentApproverId){
              
           StringBuilder   sbQuery = new StringBuilder(150);
           Statement    stmntx =    null;
           ResultSet rsx = null; 
           ArrayList<ApprovalRequest>     approvalRequests = new  ArrayList<>();
           try {                  
               
               sbQuery.append("  SELECT  id, company_id, application_code, approval_workflow_id, item_type_id, item_group_id, "); 
               sbQuery.append("   item_group_name, approval_batch_id, batch_item_count, user_request_id, current_approver_id, "); 
               sbQuery.append("  current_approver_level,  request_user_id, request_user, request_initiation_date,  ");
               sbQuery.append("   request_initiation_time,  is_approved_final, approve_comment, reject_reason, approved_level_1_date, ");
               sbQuery.append("  approved_level_1_time,  approved_level_2_date, approved_level_2_time, approved_level_3_date, ");
               sbQuery.append("   approved_level_3_time    FROM  approval_requests  WHERE  (is_approved_final = false) "); 
               sbQuery.append("  AND   (company_id  =  '%s')  AND   (current_approver_id  =  %d) "); 
         
                stmntx =    cron.createStatement();
                rsx = stmntx.executeQuery(String.format(sbQuery.toString(), inCompanyId, inCurrentApproverId));
                
                // Parameters start with 1
                while (rsx.next()) { 
     
                    ApprovalRequest  approvalRequest 
                          =  new  ApprovalRequest(rsx.getLong("id"), rsx.getString("company_id"),  rsx.getString("application_code"), 
                                   rsx.getLong("approval_workflow_id"), rsx.getLong("item_type_id"), rsx.getLong("item_group_id"),
                                rsx.getString("item_group_name"),  rsx.getLong("approval_batch_id"),  rsx.getLong("approval_item_id"), 
                                    rsx.getLong("batch_item_count"), 
                             rsx.getLong("user_request_id"),  rsx.getLong("current_approver_id"),   rsx.getInt("current_approver_level"), 
                                rsx.getLong("request_user_id"),  rsx.getString("request_user"), rsx.getString("request_initiation_date"), 
                              rsx.getString("request_initiation_time"), rsx.getBoolean("is_approved_final"), rsx.getString("approve_comment"), 
                                  rsx.getString("reject_reason"), rsx.getString("approved_level_1_date"), rsx.getString("approved_level_1_time"), 
                           rsx.getString("approved_level_2_date"), rsx.getString("approved_level_2_time"), rsx.getString("approved_level_3_date"), 
                                  rsx.getString("approved_level_3_time"));
                                        
                    approvalRequests.add(approvalRequest);                
                } 
                 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{ 
               sbQuery = null;
                 try{ 
                     stmntx.close();
                    stmntx = null;
                    rsx.close();
                    rsx = null; 
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } 
     return  approvalRequests;
  } 
   
   
   
   
   
   
   
    public   ArrayList<RequestItemBatch>    retrRequestItemBatches(Connection  cron, String inCompanyId){
              
           StringBuilder   sbQuery = new StringBuilder(150);
           Statement    stmntx =    null;
           ResultSet rsx = null; 
           ArrayList<RequestItemBatch>     requestItemBatches = new  ArrayList<>();
           try {                  
               
               sbQuery.append("  SELECT  id, company_id, application_code, approval_workflow_id, item_type_id, "); 
               sbQuery.append("   total_item_count,  total_item_count_in_words, total_item_count_in_words_hash, is_approved_final, "); 
               sbQuery.append(" approve_comment,  reject_reason,  request_batch_date, request_batch_time, "); 
               sbQuery.append("  approved_level_1_date,  approved_level_1_time,  approved_level_2_date, approved_level_2_time, ");
               sbQuery.append("  approved_level_3_date,  approved_level_3_time    FROM  request_item_batches  "); 
               sbQuery.append("  WHERE    (company_id  =  '%s')  AND   (is_approved_final  =  false) "); 
         
                stmntx =    cron.createStatement();
                rsx = stmntx.executeQuery(String.format(sbQuery.toString(), inCompanyId));
                
                // Parameters start with 1
                while (rsx.next()) { 
      
                    RequestItemBatch  requestItemBatch 
                          =  new  RequestItemBatch(rsx.getLong("id"), rsx.getString("company_id"),  
                       rsx.getString("application_code"),  rsx.getLong("approval_workflow_id"), 
                                  rsx.getLong("item_type_id"),    rsx.getInt("total_item_count"),  
                        rsx.getString("total_item_count_in_words"),  rsx.getString("total_item_count_in_words_hash"),  
                    rsx.getBoolean("is_approved_final"),  rsx.getString("approve_comment"),   rsx.getString("reject_reason"), 
                                rsx.getString("request_batch_date"),  rsx.getString("request_batch_time"),  
                               rsx.getString("approved_level_1_date"),   rsx.getString("approved_level_1_time"),   
                             rsx.getString("approved_level_2_date"),  rsx.getString("approved_level_2_time"), 
                                rsx.getString("approved_level_3_date"),   rsx.getString("approved_level_3_time"));
                                        
                    requestItemBatches.add(requestItemBatch);                
                } 
                 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{ 
               sbQuery = null;
                 try{ 
                     stmntx.close();
                    stmntx = null;
                    rsx.close();
                    rsx = null; 
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } 
     return  requestItemBatches;
    }
    
    
    
    
     
    public    ArrayList<ApprovalItem>    retrApprovalItems(Connection  cron, String inCompanyId, long  inCurrentApproverId){
              
           StringBuilder   sbQuery = new StringBuilder(150);
           Statement    stmntx =    null;
           ResultSet rsx = null; 
           ArrayList<ApprovalItem>     approvalItems = new  ArrayList<>();
           try {                  
               
               sbQuery.append("  SELECT  id, company_id, application_code, approval_workflow_id, item_type_id, item_group_id, "); 
               sbQuery.append("   item_name, approval_batch_id,   user_request_id, current_approver_id, "); 
               sbQuery.append("  current_approver_level,  request_user_id, request_user, request_initiation_date,  ");
               sbQuery.append("   request_initiation_time,  is_approved_final, approve_comment, reject_reason,   ");
               sbQuery.append("     request_initiation_date, request_initiation_time ");
               sbQuery.append("      FROM  approval_items  WHERE  (is_approved_final = false) "); 
               sbQuery.append("  AND   (company_id  =  '%s'0  AND   (current_approver_id  =  %d) "); 
         
                stmntx =    cron.createStatement();
                rsx = stmntx.executeQuery(String.format(sbQuery.toString(), inCompanyId, inCurrentApproverId));
          
                // Parameters start with 1
                while (rsx.next()) { 
    
                    ApprovalItem  approvalItem 
                          =  new  ApprovalItem(rsx.getLong("id"), rsx.getString("company_id"),  rsx.getString("application_code"), 
                                         rsx.getLong("approval_workflow_id"), rsx.getLong("item_type_id"), rsx.getLong("item_group_id"),
                                      rsx.getString("item_name"),  rsx.getLong("approval_batch_id"),  
                                   rsx.getLong("user_request_id"),  rsx.getLong("current_approver_id"),
                      rsx.getInt("current_approver_level"),   rsx.getLong("request_user_id"),  rsx.getString("request_user"), 
                       rsx.getBoolean("is_approved_final"),  rsx.getString("approve_comment"),  rsx.getString("reject_reason"),
                                 rsx.getString("request_initiation_date"),  rsx.getString("request_initiation_time"));
                                        
                    approvalItems.add(approvalItem);                
                } 
                 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{ 
               sbQuery = null;
                 try{ 
                     stmntx.close();
                    stmntx = null;
                    rsx.close();
                    rsx = null; 
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } 
     return  approvalItems;
     }
     
     
     
   
     public   ArrayList<ApprovalRoute>    retrApprovalRoutes(Connection  cron, String inCompanyId){
              
           StringBuilder   sbQuery = new StringBuilder(150);
           Statement    stmntx =    null;
           ResultSet rsx = null; 
           ArrayList<ApprovalRoute>     approvalRoutes = new  ArrayList<>();
           
           try {   
 
               sbQuery.append("  SELECT  id, company_id, application_code,  item_group_id,"); 
                sbQuery.append("   item_type_id,  approval_workflow_id,  is_active_route,   "); 
               sbQuery.append("     approver_user_group_id,   approver_user_id,  approver_level,  "); 
               sbQuery.append("  approver_description, approver_name,  is_final_approver,  approver_route_create_date, ");
               sbQuery.append("  approver_route_create_time,  approver_route_modification_date,");
               sbQuery.append("     approver_route_modification_time   FROM   approval_routes   ");
                sbQuery.append("   WHERE   (company_id  =  '%s')   AND   (is_active_route  =  true) "); 
         
                stmntx =    cron.createStatement();
                rsx = stmntx.executeQuery(String.format(sbQuery.toString(), inCompanyId));
                
                // Parameters start with 1
                while (rsx.next()) { 
     
                    ApprovalRoute  approvalRoute 
                          =  new  ApprovalRoute(rsx.getLong("id"), rsx.getString("company_id"),  
                                  rsx.getString("application_code"),  rsx.getLong("item_group_id"), 
                                  rsx.getLong("item_type_id"), 
                                  rsx.getLong("approval_workflow_id"), rsx.getBoolean("is_active_route"), 
                                rsx.getLong("approver_user_group_id"), rsx.getLong("approver_user_id"),  
                                  rsx.getInt("approver_level"),  rsx.getString("approver_description"),  
                                  rsx.getString("approver_name"),  rsx.getBoolean("is_final_approver"),    
                      rsx.getString("approver_route_create_date"),  rsx.getString("approver_route_create_time"), 
                rsx.getString("approver_route_modification_date"),  rsx.getString("approver_route_modification_time"));
                                        
                    approvalRoutes.add(approvalRoute);                
                } 
                 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{ 
               sbQuery = null;
                 try{ 
                     stmntx.close();
                    stmntx = null;
                    rsx.close();
                    rsx = null; 
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } 
     return  approvalRoutes;
     }
     
     
     
     
     
     
   public   ArrayList<ApprovalItemType>    retrApprovalItemTypes(Connection  cron, String inCompanyId){
              
           StringBuilder   sbQuery = new StringBuilder(150);
           Statement    stmntx =    null;
           ResultSet rsx = null; 
           ArrayList<ApprovalItemType>     approvalItemTypes = new  ArrayList<>();
           
           try {                  
     

               sbQuery.append("  SELECT  id, company_id, application_code, approval_item_group_id, item_name,  "); 
               sbQuery.append("  description,  is_financial_related, is_physical_object_related,  "); 
               sbQuery.append("  is_relocation_related, approval_item_table, item_type_creator,  item_type_creation_date,  ");
               sbQuery.append("   item_type_creation_time   FROM  approval_item_types    "); 
               sbQuery.append("   WHERE   company_id =  '%s'   "); 
         
                stmntx =    cron.createStatement();
                rsx = stmntx.executeQuery(String.format(sbQuery.toString(), inCompanyId));
                
                // Parameters start with 1
                while (rsx.next()) { 
    
                    
                 ApprovalItemType  approvalItemType 
                          =  new  ApprovalItemType(rsx.getLong("id"), rsx.getString("company_id"),  
                                  rsx.getString("application_code"), rsx.getLong("approval_item_group_id"),
                                    rsx.getString("item_name"), rsx.getString("description"), 
                                   rsx.getBoolean("is_financial_related"), rsx.getBoolean("is_physical_object_related"), 
                              rsx.getBoolean("is_relocation_related"),  rsx.getString("approval_item_table"),   
                                  rsx.getString("item_type_creator"),   rsx.getString("item_type_creation_date"),
                                rsx.getString("item_type_creation_time"));
                                        
                    approvalItemTypes.add(approvalItemType);                
                } 
                 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{ 
               sbQuery = null;
                 try{ 
                     stmntx.close();
                    stmntx = null;
                    rsx.close();
                    rsx = null; 
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } 
     return  approvalItemTypes;
     }
     
     
      
     
     public   ArrayList<ApprovalItemGroup>    retrApprovalItemGroups(Connection  cron, String inCompanyId){
              
           StringBuilder   sbQuery = new StringBuilder(150);
           Statement    stmntx =    null;
           ResultSet rsx = null; 
           ArrayList<ApprovalItemGroup>     approvalItemGroups = new  ArrayList<>();
           try {                  
               
               sbQuery.append("  SELECT  id, company_id, application_code,   item_group_name, "); 
               sbQuery.append("  item_group_description,  item_group_creation_date,  item_group_creation_time, "); 
               sbQuery.append("  item_group_modification_date,  item_group_modification_time  "); 
               sbQuery.append("       FROM  approval_item_groups    WHERE   (company_id  =  '%s')   "); 
         
                stmntx =    cron.createStatement();
                rsx = stmntx.executeQuery(String.format(sbQuery.toString(), inCompanyId));
                 
                // Parameters start with 1
                while (rsx.next()) { 
    
                    
                    ApprovalItemGroup  approvalItemGroup 
                          =  new  ApprovalItemGroup(rsx.getLong("id"), rsx.getString("company_id"),  
                                  rsx.getString("application_code"),  rsx.getString("item_group_name"),
                                   rsx.getString("item_group_description"),  rsx.getString("item_group_creation_date"), 
                               rsx.getString("item_group_creation_time"),  rsx.getString("item_group_modification_date"),
                               rsx.getString("item_group_modification_time"));
                                        
                    approvalItemGroups.add(approvalItemGroup);                
                } 
                 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{ 
               sbQuery = null;
                 try{ 
                     stmntx.close();
                    stmntx = null;
                    rsx.close();
                    rsx = null; 
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } 
     return  approvalItemGroups;
     }
     
     
     
     
     
       
     public   ArrayList<ApprovalUserGroup>    retrApprovalUserGroups(Connection  cron, String inCompanyId){
              
           StringBuilder   sbQuery = new StringBuilder(150);
           Statement    stmntx =    null;
           ResultSet rsx = null; 
           ArrayList<ApprovalUserGroup>     approvalUserGroups = new  ArrayList<>();
           try {                  
               
               sbQuery.append("  SELECT  id, company_id, application_code,  user_group_name, user_group_description, "); 
               sbQuery.append("  user_group_approval_level,  user_group_creation_date,  user_group_creation_time, "); 
               sbQuery.append("  user_group_modification_date,  user_group_modification_time  "); 
               sbQuery.append("       FROM  approval_user_groups    WHERE   (company_id  =  '%s')   "); 
         
                stmntx =    cron.createStatement();
                rsx = stmntx.executeQuery(String.format(sbQuery.toString(), inCompanyId));
                 
                // Parameters start with 1
                while (rsx.next()) { 
    
                    
                    ApprovalUserGroup  approvalUserGroup 
                          =  new  ApprovalUserGroup(rsx.getLong("id"), rsx.getString("company_id"),  
                                  rsx.getString("application_code"),  rsx.getString("user_group_name"),
                                   rsx.getString("user_group_description"), 
                                  rsx.getInt("user_group_approval_level"),   rsx.getString("user_group_creation_date"), 
                               rsx.getString("user_group_creation_time"),  rsx.getString("user_group_modification_date"),
                               rsx.getString("user_group_modification_time"));
                                        
                    approvalUserGroups.add(approvalUserGroup);                
                } 
                 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{ 
               sbQuery = null;
                 try{ 
                     stmntx.close();
                    stmntx = null;
                    rsx.close();
                    rsx = null; 
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } 
     return  approvalUserGroups;
     }
     
     
     
     
     
     
       
     public   ArrayList<ApprovalWorkflow>    retrApprovalWorkFlows(Connection  cron, String inCompanyId){
              
           StringBuilder   sbQuery = new StringBuilder(150);
           Statement    stmntx =    null;
           ResultSet rsx = null; 
           ArrayList<ApprovalWorkflow>     approvalWorkflows = new  ArrayList<>();
           try {                  
               
               sbQuery.append("  SELECT  id, company_id, application_code, item_group_id,  item_type_id, "); 
               sbQuery.append("   total_approval_levels,  total_approval_levels_in_words,   total_approval_levels_in_words_hash, "); 
               sbQuery.append("  workflow_create_user_id,  workflow_create_user,  workflow_create_date,  "); 
               sbQuery.append("  workflow_create_time,  workflow_modification_user_id, workflow_modification_user, "); 
               sbQuery.append("  workflow_modification_date,  workflow_modification_time  "); 
               sbQuery.append("     FROM   approval_workflow    WHERE   (company_id  =  '%s')   "); 
         
                stmntx =    cron.createStatement();
                rsx = stmntx.executeQuery(String.format(sbQuery.toString(), inCompanyId));
                 
                // Parameters start with 1
                while (rsx.next()) { 
     
                    ApprovalWorkflow  approvalWorkflow 
                          =  new  ApprovalWorkflow(rsx.getLong("id"), rsx.getString("company_id"),  rsx.getString("application_code"),
                          rsx.getLong("item_group_id"),  rsx.getLong("item_type_id"),   rsx.getInt("total_approval_levels"),
                             rsx.getString("total_approval_levels_in_words"),  rsx.getString("total_approval_levels_in_words_hash"), 
                               rsx.getLong("workflow_create_user_id"),  rsx.getString("workflow_create_user"),
                                  rsx.getString("workflow_create_date"),  rsx.getString("workflow_create_time"),
                       rsx.getLong("workflow_modification_user_id"), rsx.getString("workflow_modification_user"), 
                       rsx.getString("workflow_modification_date"),  rsx.getString("workflow_modification_time"));
                                        
                    approvalWorkflows.add(approvalWorkflow);                
                } 
                 
            } catch (Exception e) {
                e.printStackTrace();
            }  finally{ 
               sbQuery = null;
                 try{ 
                     stmntx.close();
                    stmntx = null;
                    rsx.close();
                    rsx = null; 
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } 
     return  approvalWorkflows;
     }
     
     
     
     
     
    /***
    public   int   createApprovalItemBatch(Connection    con) {
         
         PreparedStatement ps  =    null; 
         int  countOfRecordsInserted  =  0; 
         
         StringBuilder  INSERT_APPROVAL_ITEM_SQL =  new StringBuilder(200);
            INSERT_APPROVAL_ITEM_SQL.append("INSERT  INTO  approval_items  (company_id, application_code, item_type_id,  ");
            INSERT_APPROVAL_ITEM_SQL.append(" item_group_id, item_name, approval_batch_id,   user_request_id, current_approver_id,  ");
            INSERT_APPROVAL_ITEM_SQL.append("   current_approver_level,  request_user_id, request_user,   is_approved_final, ");
            INSERT_APPROVAL_ITEM_SQL.append(" approve_comment, reject_reason, request_initiation_date, request_initiation_time) "); 
            INSERT_APPROVAL_ITEM_SQL.append("   VALUES (?,?,?,?,?,?,?,?,?, 0, '%s') ");
                   
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

                        countOfRecordsInserted  =   ps.executeUpdate();                      
                  
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                INSERT_APPROVAL_ITEM_SQL  = null;
                try{
                    ps.close();
                    ps = null;
                }catch(Exception er){
                    er.printStackTrace();
                }
            }
        return  countOfRecordsInserted;
    }
   ***/
     
     
     
     
     
      public  static  void main(String[] args){
        WorkFlowUtils   workFlowUtils = WorkFlowUtils.getInstance();
        String  apprUGStr = WorkFlowUtils.convertToJSONString(new ApprovalUserGroup());
         System.out.println(apprUGStr);
         ApprovalUserGroup   appUGroup =  ApprovalUserGroup.readFromJSON(apprUGStr);
        System.out.println(appUGroup.toString());
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
