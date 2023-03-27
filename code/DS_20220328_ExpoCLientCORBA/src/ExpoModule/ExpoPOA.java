package ExpoModule;


/**
* ExpoModule/ExpoPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Expo.idl
* Friday, April 1, 2022 5:08:18 PM ICT
*/

public abstract class ExpoPOA extends org.omg.PortableServer.Servant
 implements ExpoModule.ExpoOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("expo", new java.lang.Integer (0));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // ExpoModule/Expo/expo
       {
         int a = in.read_long ();
         int b = in.read_long ();
         int $result = (int)0;
         $result = this.expo (a, b);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:ExpoModule/Expo:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Expo _this() 
  {
    return ExpoHelper.narrow(
    super._this_object());
  }

  public Expo _this(org.omg.CORBA.ORB orb) 
  {
    return ExpoHelper.narrow(
    super._this_object(orb));
  }


} // class ExpoPOA