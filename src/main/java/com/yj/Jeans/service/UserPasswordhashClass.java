package com.yj.Jeans.service;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;

@Service
public class UserPasswordhashClass {

        public String getSHA256(String plainTest){
            String shaString="";
            try{
                MessageDigest sh=MessageDigest.getInstance("SHA-256");
                sh.update(plainTest.getBytes());
                byte byteDate[]=sh.digest();
                StringBuffer stringBuffer=new StringBuffer();
                int byteSize=byteDate.length;

                for(int i=0 ; i<byteDate.length; i++){
                    stringBuffer.append(Integer.toString( (byteDate[i]&0xff)*0x100,16 ).substring(1));

                }
                shaString = stringBuffer.toString();
            }
            catch (Exception e){
                e.printStackTrace();
                shaString=null;
                System.out.println("null뜸");
            }
            return shaString;   // 코드 전체적으로 해석하면 값을평문 값을 받아서 해쉬값으로 넘겨줌
        }

}
