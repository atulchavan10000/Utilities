package atulsprograms;
import com.tibco.as.space.ASException;
import com.tibco.as.space.FieldDef;
import com.tibco.as.space.KeyDef;
import com.tibco.as.space.MemberDef;
import com.tibco.as.space.Metaspace;
import com.tibco.as.space.Space;
import com.tibco.as.space.SpaceDef;
import com.tibco.as.space.Tuple;
import com.tibco.as.space.FieldDef.FieldType;
import com.tibco.as.space.Member.DistributionRole;
import com.tibco.as.space.browser.Browser;
import com.tibco.as.space.browser.BrowserDef;
import com.tibco.as.space.browser.BrowserDef.BrowserType;


public class ActiveSpacesConnection {
    public static void main(String args[])
    {
 /*An instance of a cluster of application processes. 
 The processes are usually deployed on multiple hosts interconnected                 by a network where ActiveSpaces is installed (ActiveSpaces applications             can also be installed on a standalone host). The metaspace represents the         cluster of hosts and processes that share the same metaspace name and           set of discovery transport attributes. The hosts and processes in a                     metaspace work together by joining the same tuple spaces.*/
 Metaspace ms = null;
  
 /*The Space shared resource allows users to define tuple fields, key                   definitions, and index definitions. Space can also be called as Database             Table.*/
        Space space = null;
 String tuple1_value = "", tuple2_value = "", tuple3_value = "";
 try
 {
            // define Metaspace membership characteristics
     MemberDef memberDef = MemberDef.create();

     /*Specify the URL of a metaspace used by an intended member                         to connect to the metaspace. */
     memberDef.setDiscovery("DiscoveryURL");

     /*Specify a unique name to identify each member connecting to the                   metaspace. */
     memberDef.setMemberName("MemberName");

     /*Establishes connection to metaspace using the metaspace name and               MemberDef specified.*/
     ms = Metaspace.connect("metaSpaceName", memberDef);

     /*After a space has been defined in the metaspace, applications can                   join the space— and as-agents started in the network automatically join             the space if the space is distributed. DestributionRole Specifies the role             for the application. Can be SEEDER or LEECH*/
            space = ms.getSpace("spaceName", DistributionRole.LEECH);
            Tuple tuple = Tuple.create();

            /*A Browser is used to retrieve and perform operations on multiple                   entries in a Space */
     Browser browser;

     /*space.browse() method Creates a browser over multiple entries in the             Space
     Parameters
     browserType - Indicates the type of Browser object to be created. 
            The browserType can be one of GET, TAKE or LOCK as defined in                       BrowserDef.BrowserType.
     browserDef - Used to specify custom timeout values and distribution or             time scopes.
     filter - A String that can be used to create a Filter, the filter can be                     called as a database query */
     browser = space.browse(BrowserDef.BrowserType.GET,                                   BrowserDef.create().setTimeScope(BrowserDef.TimeScope.SNAPSHOT)
            .setPrefetch((BrowserDef.PREFETCH_ALL), "UniqueId"));
     if(browser.size()!=0){ 
         tuple = browser.next();
         if(!tuple.isNull("tuple1")){
             tuple1_value = tuple.getString("tuple1");
          }
                 else
                tuple1_value = "Null";
                       if(!tuple.isNull("tuple1")){
                tuple2_value = tuple.getInt("tuple2");
           }
           else
                tuple2_value = "Null"; 
                       if(!tuple.isNull("tuple3")){
         tuple3_value = tuple.getDateTime("tuple3");
            }
           else
                tuple3_value = "Null";  
              }
       else
       {
      tuple1_value = "Null";
      tuple2_value = "Null";
      tuple3_value = "Null";
       }
   }
  catch (Exception e)
  {
   e.printStackTrace();
  }finally{
   // leave the space
   if (space != null)
    space.close();
   // disconnect from the metaspace
   if (ms != null)
    ms.close();
  }
 }
}
