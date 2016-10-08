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
final public class CaesarAlgorithmHelper
{
    public static void
    insert(org.omg.CORBA.Any any, CaesarAlgorithm val)
    {
        any.insert_Object(val, type());
    }

    public static CaesarAlgorithm
    extract(org.omg.CORBA.Any any)
    {
        if(any.type().equivalent(type()))
            return narrow(any.extract_Object());

        throw new org.omg.CORBA.BAD_OPERATION();
    }

    private static org.omg.CORBA.TypeCode typeCode_;

    public static org.omg.CORBA.TypeCode
    type()
    {
        if(typeCode_ == null)
        {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            typeCode_ = orb.create_interface_tc(id(), "CaesarAlgorithm");
        }

        return typeCode_;
    }

    public static String
    id()
    {
        return "IDL:CaesarAlgorithm:1.0";
    }

    public static CaesarAlgorithm
    read(org.omg.CORBA.portable.InputStream in)
    {
        org.omg.CORBA.Object _ob_v = in.read_Object();

        if(_ob_v != null)
        {
            if(_ob_v instanceof CaesarAlgorithm)
                return (CaesarAlgorithm)_ob_v;

            org.omg.CORBA.portable.ObjectImpl _ob_impl;
            _ob_impl = (org.omg.CORBA.portable.ObjectImpl)_ob_v;
            _CaesarAlgorithmStub _ob_stub = new _CaesarAlgorithmStub();
            _ob_stub._set_delegate(_ob_impl._get_delegate());
            return _ob_stub;
        }

        return null;
    }

    public static void
    write(org.omg.CORBA.portable.OutputStream out, CaesarAlgorithm val)
    {
        out.write_Object(val);
    }

    public static CaesarAlgorithm
    narrow(org.omg.CORBA.Object val)
    {
        if(val != null)
        {
            if(val instanceof CaesarAlgorithm)
                return (CaesarAlgorithm)val;

            if(val._is_a(id()))
            {
                org.omg.CORBA.portable.ObjectImpl _ob_impl;
                _CaesarAlgorithmStub _ob_stub = new _CaesarAlgorithmStub();
                _ob_impl = (org.omg.CORBA.portable.ObjectImpl)val;
                _ob_stub._set_delegate(_ob_impl._get_delegate());
                return _ob_stub;
            }

            throw new org.omg.CORBA.BAD_PARAM();
        }

        return null;
    }

    public static CaesarAlgorithm
    unchecked_narrow(org.omg.CORBA.Object val)
    {
        if(val != null)
        {
            if(val instanceof CaesarAlgorithm)
                return (CaesarAlgorithm)val;

            org.omg.CORBA.portable.ObjectImpl _ob_impl;
            _CaesarAlgorithmStub _ob_stub = new _CaesarAlgorithmStub();
            _ob_impl = (org.omg.CORBA.portable.ObjectImpl)val;
            _ob_stub._set_delegate(_ob_impl._get_delegate());
            return _ob_stub;
        }

        return null;
    }
}