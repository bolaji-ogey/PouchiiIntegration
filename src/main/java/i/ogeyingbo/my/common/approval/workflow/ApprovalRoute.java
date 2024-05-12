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
import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.json.stream.JsonGeneratorFactory;
import org.json.JSONObject;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class ApprovalRoute implements  ApprovalWType  {
    
    private  long  id =  -1;
    private  String  companyId  = "";
    private  String  appCode  = "";
    private  long   itemGroupId =  -1;
    private  long   itemTypeId =  -1;
    private  long   approvalWorkflowId =  -1;
    
    private  boolean   isActiveRoute  = false;
    private  long  approverUserGroupId =  -1;
    private  long  approverUserId =  -1;
    private  int   approverLevel =  0;
    private  String  approverDescription  = "";
    private  String  approverName  = "";
    
    private  boolean   isFinalApprover  = false;
    
    
    private  String  approverRouteCreateDate  = "";
    private  String  approverRouteCreateTime  = "";
    
    private  String  approverRouteModifyDate  = "";
    private  String  approverRouteModifyTime  = "";
	 
	   
 
    public  ApprovalRoute(long  inId, String inCompanyId,  String inAppCode, long inItemGroupId, 
                            long inItemTypeId,    long  inApprovalWorkflowId, boolean  inIsActiveRoute,
                               long  inApproverUserGroupId, long  inApproverUserId,  int inApproverLevel,  
                                 String  inApproverDescription,  String  inApproverName,  boolean  inIsFinalApprover, 
                             String  inApproverRouteCreateDate,   String  inApproverRouteCreateTime, 
                                      String  inApproverRouteModifyDate, String inApproverRouteModifyTime){
        
        this.id  =  inId;
        this.companyId = inCompanyId;
        this.appCode = inAppCode;
        this.itemGroupId = inItemGroupId;
        this.itemTypeId =  inItemTypeId;
        this.approvalWorkflowId =  inApprovalWorkflowId;
        this.isActiveRoute = inIsActiveRoute;
        this.approverUserGroupId =  inApproverUserGroupId;
        this.approverUserId =  inApproverUserId;
        this.approverLevel = inApproverLevel;
        this.approverDescription = inApproverDescription;
        this.approverName = inApproverName;
        this.isFinalApprover = inIsFinalApprover;
        this.approverRouteCreateDate = inApproverRouteCreateDate;
        this.approverRouteCreateTime = inApproverRouteCreateTime;
        this.approverRouteModifyDate = inApproverRouteModifyDate;
        this.approverRouteModifyTime = inApproverRouteModifyTime;       
        
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
     
     
    
    public  static  ApprovalRoute  readFromJSON(String  inObjectJSON){ 
        ApprovalRoute  approvalRoute  =  null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
              objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
              approvalRoute = objectMapper.readValue(inObjectJSON, ApprovalRoute.class);
            }catch(Exception ex){
                  ex.printStackTrace();
            }finally{
                objectMapper = null;
            }
        return  approvalRoute;
    }
 
    
    
     
    public    boolean   createApprovalRoute(Connection    con) {
         
         PreparedStatement ps  =    null; 
         int  countOfRecordsInserted  =  0;
         boolean  isRecordInserted  = false; 
                   
         StringBuilder  INSERT_APPROVAL_ROUTE_SQL =  new StringBuilder(200);
            INSERT_APPROVAL_ROUTE_SQL.append("INSERT  INTO  approval_routes  (company_id, application_code, ");
            INSERT_APPROVAL_ROUTE_SQL.append(" item_group_id,  item_type_id, approval_workflow_id, is_active_route, ");
            INSERT_APPROVAL_ROUTE_SQL.append("  approver_user_group_id,   approver_user_id,  approver_level,  ");
            INSERT_APPROVAL_ROUTE_SQL.append("   approver_description, approver_name,  is_final_approver,  ");
            INSERT_APPROVAL_ROUTE_SQL.append("  approver_route_create_date, approver_route_modification_time )  ");
            INSERT_APPROVAL_ROUTE_SQL.append("   VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
                   
            try { 
                   
                        ps = con.prepareStatement(String.format(INSERT_APPROVAL_ROUTE_SQL.toString()));
                        
                        ps.setString(1, companyId);
                        ps.setString(2, appCode);
                        ps.setLong(3, itemGroupId);
                        ps.setLong(4, itemTypeId);
                        ps.setLong(5, approvalWorkflowId);
                        ps.setBoolean(6, isActiveRoute);
                        ps.setLong(7, approverUserGroupId);
                        ps.setLong(8, approverUserId);
                        ps.setInt(9, approverLevel);
                        ps.setString(10, approverDescription);
                        ps.setString(11, approverName);
                        ps.setBoolean(12, isFinalApprover);
                        ps.setString(13, approverRouteCreateDate);
                        ps.setString(14, approverRouteCreateTime);                          

                        isRecordInserted  =  (ps.executeUpdate() == 1);                      
                  
            } catch (Exception e) {
                e.printStackTrace();
            }finally{
                INSERT_APPROVAL_ROUTE_SQL  = null;
                try{
                    ps = null;
                }catch(Exception er){
                    er.printStackTrace();
                }
            }
        return  isRecordInserted;
    }

    
    
    
}
