/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.single.node.wallet.core;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class NodeInSession {
    
    private  long  id = -1;
    private  int  nodeIndex = -1;
    private  String  nodeName  =  "";
    private  long  startInSessionId = -1;
    private  long  endInSessionId = -1;
    
    private  String  startInSessionDate =  "";
    private  String  startInSessionTime =  "";
    
    private  String  endInSessionDate =  "";
    private  String  endInSessionTime =  "";
    
    
    
    public  String  getNodeName(){
        return  this.nodeName;
    }
    
    public   NodeInSession(long inId, int  inNodeIndex,  String  inNodeName, long  inStartInSessionId, long  inEndInSessionId,
                       String  inStartInSessionDate,  String   inStartInSessionTime, String inEndInSessionDate,   String inEndInSessionTime){
        this.id = inId;
        this.nodeIndex  =  inNodeIndex;
        this.nodeName = inNodeName;
        this.startInSessionId = inStartInSessionId;
        this.endInSessionId  =  inEndInSessionId;
        this.startInSessionDate = inStartInSessionDate;
        this.startInSessionTime = inStartInSessionTime;
        this.endInSessionDate  =  inEndInSessionDate;
        this.endInSessionTime = inEndInSessionTime;
        
        
    }
    
}
