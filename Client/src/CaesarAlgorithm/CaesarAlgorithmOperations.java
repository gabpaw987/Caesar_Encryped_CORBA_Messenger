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
/***/

public interface CaesarAlgorithmOperations
{
    //
    // IDL:CaesarAlgorithm/encrypt:1.0
    //
    /***/

    char[]
    encrypt(String info,
            int k,
            int shift);

    //
    // IDL:CaesarAlgorithm/decrypt:1.0
    //
    /***/

    String
    decrypt(char[] info,
            int k,
            int shift);

    //
    // IDL:CaesarAlgorithm/shutdown:1.0
    //
    /***/

    boolean
    shutdown();
}