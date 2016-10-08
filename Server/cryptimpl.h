// Codeproject: A simple C++ client/server application with CORBA
// Module: cryptimpl.h
// Description: Servant implementation

#include <iostream>
#include <string>
#include <conio.h>

#include "OB/CORBA.h"
#include "crypt_skel.h"
/**
 * This class should implement the functions for encryption and communicates with the ORB
**/
class CryptographicImpl : virtual public ::POA_CaesarAlgorithm,
								virtual public PortableServer::RefCountServantBase

{
	CORBA::ORB_var orb; // Reference to CORBA ORB

	public: 
		/**
		 * Constructor gets an ORB and saves him as his own
		 * @param orb the ORB will be saved
		**/
		CryptographicImpl(CORBA::ORB_var orb)
		{
			this->orb = orb;
		}
		/**
		 * Caesar text encryption algorithm
		 * @param info the text to encrypt
		 * @param k the encrytion-key
		 * @param shift how many characters should be moved
		**/
		// 
		virtual ::CaesarAlgorithm::charsequence* encrypt(const char* info,::CORBA::ULong k,::CORBA::ULong shift)
			throw(::CORBA::SystemException)
		{
			std::string msg = info;
			int len = msg.length();
			::CaesarAlgorithm::charsequence* outseq = new ::CaesarAlgorithm::charsequence;
			outseq->length(len + 1);
			std::string::iterator i = msg.begin();
			std::string::iterator end = msg.end();
			int j = 0;
			while (i != end)
			{
				 *i+= shift;
				 *i ^= k;
				 (*outseq)[j++] = *i++;
			}
			(*outseq)[len] = '\0';
			return outseq;
		}

		/**
		 * Caesar text decryption algorithm
		 * @param info the text to decrypt
		 * @param k the decrytion-key
		 * @param shift how many characters should be moved
		**/
		virtual char* decrypt(const ::CaesarAlgorithm::charsequence& info,::CORBA::ULong k,::CORBA::ULong shift)
			throw(::CORBA::SystemException)
		{
			char* r = CORBA::string_alloc(info.length());

			for (int i = 0;i < info.length() - 1;i++)
			{
				r[i]  = info[i];
				r[i] ^= k;
				r[i] -= shift;
			}
			r[info.length() - 1] = '\0';
			return r;
		}

		/**
		 * This function shuts the ORB down
		 * @throws an Corba SystemException
		**/
		virtual ::CORBA::Boolean shutdown() throw(::CORBA::SystemException)
		{
			orb->shutdown(false);
			return true;
		}
};