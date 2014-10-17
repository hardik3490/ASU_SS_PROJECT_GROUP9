package com.ss.group9.OTP;


import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class OTP {

	public OTP() {
		
	}
    private static final int[] DIGITS_POWER= {1,10,100,1000,10000,100000,1000000,10000000,100000000 };
    
	private static byte[] hmacSHA(String Algotype,byte[] keyBytes,byte[] text)
	{
		try
		{
			Mac mac;
			byte[] hmac;
			mac=Mac.getInstance(Algotype);
			SecretKeySpec key=new SecretKeySpec(keyBytes,"RAW");
			mac.init(key);
			hmac=mac.doFinal(text);
			
			return hmac;
			
		}
		catch(GeneralSecurityException e)
		{
			System.out.println(e.getMessage());
			//include logger if needed
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			//include logger if needed
		}
		
		return null;
	}
	
	private static byte[] convertToBytes(String input)
	{
		byte[] byteArray=new BigInteger("0"+input,16).toByteArray();
		byte[] output = new byte[byteArray.length - 1];
	    for (int i = 0; i < output.length ; i++)
	         output[i] = byteArray[i+1];
	    return output;
	
	}
	
	private static String generateOTP(byte[] key,String digits,String time,String algoType)
	{
		int noOfDigits= Integer.decode(digits).intValue();
		String OTP=null;
		byte[] hValue;
		while(time.length() < 16 )
	         time = "0" + time;
		

        // Get the HEX in a Byte[]
        byte[] msg = convertToBytes(time);

        // Adding one byte to get the right conversion
       // byte[] k = convertToBytes(key);

        hValue = hmacSHA(algoType, key, msg);

        // put selected bytes into result int
        int offset = hValue[hValue.length - 1] & 0xf;

        int binary =
            ((hValue[offset] & 0x7f) << 24) |
            ((hValue[offset + 1] & 0xff) << 16) |
            ((hValue[offset + 2] & 0xff) << 8) |
            (hValue[offset + 3] & 0xff);

        int otpVal = binary % DIGITS_POWER[noOfDigits];

        OTP = Integer.toString(otpVal);
        while (OTP.length() < noOfDigits) {
        	OTP = "0" + OTP;
        }
  
		
		return OTP;
	}
	
	public static void main(String[] args)
	{

		 SecureRandom sec=new SecureRandom();
		 byte[] seed=sec.generateSeed(30);
		 long time=System.currentTimeMillis();
		 long T0 = 0;
         long X = 30;
         long T = (time - T0)/X;
		 String steps = "0";
         steps = Long.toHexString(T).toUpperCase();
		
		try
		{
		 System.out.println("OTP:"+generateOTP(seed, "6",steps,
                    "HmacSHA512") + " using SHA512 ");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

}
