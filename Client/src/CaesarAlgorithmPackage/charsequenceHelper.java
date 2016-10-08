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

package CaesarAlgorithmPackage;

//
// IDL:CaesarAlgorithm/charsequence:1.0
//
final public class charsequenceHelper
{
    public static void
    insert(org.omg.CORBA.Any any, char[] val)
    {
        org.omg.CORBA.portable.OutputStream out = any.create_output_stream();
        write(out, val);
        any.read_value(out.create_input_stream(), type());
    }

    public static char[]
    extract(org.omg.CORBA.Any any)
    {
        if(any.type().equivalent(type()))
            return read(any.create_input_stream());
        else
            throw new org.omg.CORBA.BAD_OPERATION();
    }

    private static org.omg.CORBA.TypeCode typeCode_;

    public static org.omg.CORBA.TypeCode
    type()
    {
        if(typeCode_ == null)
        {
            org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init();
            typeCode_ = orb.create_alias_tc(id(), "charsequence", orb.create_sequence_tc(0, orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_char)));
        }

        return typeCode_;
    }

    public static String
    id()
    {
        return "IDL:CaesarAlgorithm/charsequence:1.0";
    }

    public static char[]
    read(org.omg.CORBA.portable.InputStream in)
    {
        char[] _ob_v;
        int len0 = in.read_ulong();
        _ob_v = new char[len0];
        in.read_char_array(_ob_v, 0, len0);
        return _ob_v;
    }

    public static void
    write(org.omg.CORBA.portable.OutputStream out, char[] val)
    {
        int len0 = val.length;
        out.write_ulong(len0);
        out.write_char_array(val, 0, len0);
    }
}