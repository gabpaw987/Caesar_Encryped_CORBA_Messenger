package CaesarAlgorithm;
// **********************************************************************
//
// Generated by the ORBacus IDL to Java Translator
//
// Copyright(c) 2002 - 2010 Progress Software Corporation (PSC).  All
// rights reserved.  Use, reproduction, transfer, publication or
// disclosure is prohibited except as specifically provided for in
// your License Agreement with PSC.
//
// **********************************************************************

// Version: 4.3.4

//
// IDL:CaesarAlgorithm:1.0
//
public class _CaesarAlgorithmStub extends org.omg.CORBA.portable.ObjectImpl
                                  implements CaesarAlgorithm
{
    private static final String[] _ob_ids_ =
    {
        "IDL:CaesarAlgorithm:1.0",
    };

    public String[]
    _ids()
    {
        return _ob_ids_;
    }

    final public static java.lang.Class _ob_opsClass = CaesarAlgorithmOperations.class;

    //
    // IDL:CaesarAlgorithm/encrypt:1.0
    //
    public char[]
    encrypt(String _ob_a0,
            int _ob_a1,
            int _ob_a2)
    {
        while(true)
        {
            if(!this._is_local())
            {
                org.omg.CORBA.portable.OutputStream out = null;
                org.omg.CORBA.portable.InputStream in = null;
                try
                {
                    out = _request("encrypt", true);
                    out.write_string(_ob_a0);
                    out.write_ulong(_ob_a1);
                    out.write_ulong(_ob_a2);
                    in = _invoke(out);
                    char[] _ob_r = CaesarAlgorithmPackage.charsequenceHelper.read(in);
                    return _ob_r;
                }
                catch(org.omg.CORBA.portable.RemarshalException _ob_ex)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _ob_aex)
                {
                    final String _ob_id = _ob_aex.getId();
                    in = _ob_aex.getInputStream();

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _ob_id);
                }
                finally
                {
                    _releaseReply(in);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _ob_so = _servant_preinvoke("encrypt", _ob_opsClass);
                if(_ob_so == null)
                    continue;
                CaesarAlgorithmOperations _ob_self = (CaesarAlgorithmOperations)_ob_so.servant;
                try
                {
                    return _ob_self.encrypt(_ob_a0, _ob_a1, _ob_a2);
                }
                finally
                {
                    _servant_postinvoke(_ob_so);
                }
            }
        }
    }

    //
    // IDL:CaesarAlgorithm/decrypt:1.0
    //
    public String
    decrypt(char[] _ob_a0,
            int _ob_a1,
            int _ob_a2)
    {
        while(true)
        {
            if(!this._is_local())
            {
                org.omg.CORBA.portable.OutputStream out = null;
                org.omg.CORBA.portable.InputStream in = null;
                try
                {
                    out = _request("decrypt", true);
                    CaesarAlgorithmPackage.charsequenceHelper.write(out, _ob_a0);
                    out.write_ulong(_ob_a1);
                    out.write_ulong(_ob_a2);
                    in = _invoke(out);
                    String _ob_r = in.read_string();
                    return _ob_r;
                }
                catch(org.omg.CORBA.portable.RemarshalException _ob_ex)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _ob_aex)
                {
                    final String _ob_id = _ob_aex.getId();
                    in = _ob_aex.getInputStream();

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _ob_id);
                }
                finally
                {
                    _releaseReply(in);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _ob_so = _servant_preinvoke("decrypt", _ob_opsClass);
                if(_ob_so == null)
                    continue;
                CaesarAlgorithmOperations _ob_self = (CaesarAlgorithmOperations)_ob_so.servant;
                try
                {
                    return _ob_self.decrypt(_ob_a0, _ob_a1, _ob_a2);
                }
                finally
                {
                    _servant_postinvoke(_ob_so);
                }
            }
        }
    }

    //
    // IDL:CaesarAlgorithm/shutdown:1.0
    //
    public boolean
    shutdown()
    {
        while(true)
        {
            if(!this._is_local())
            {
                org.omg.CORBA.portable.OutputStream out = null;
                org.omg.CORBA.portable.InputStream in = null;
                try
                {
                    out = _request("shutdown", true);
                    in = _invoke(out);
                    boolean _ob_r = in.read_boolean();
                    return _ob_r;
                }
                catch(org.omg.CORBA.portable.RemarshalException _ob_ex)
                {
                    continue;
                }
                catch(org.omg.CORBA.portable.ApplicationException _ob_aex)
                {
                    final String _ob_id = _ob_aex.getId();
                    in = _ob_aex.getInputStream();

                    throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _ob_id);
                }
                finally
                {
                    _releaseReply(in);
                }
            }
            else
            {
                org.omg.CORBA.portable.ServantObject _ob_so = _servant_preinvoke("shutdown", _ob_opsClass);
                if(_ob_so == null)
                    continue;
                CaesarAlgorithmOperations _ob_self = (CaesarAlgorithmOperations)_ob_so.servant;
                try
                {
                    return _ob_self.shutdown();
                }
                finally
                {
                    _servant_postinvoke(_ob_so);
                }
            }
        }
    }
}
