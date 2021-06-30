/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.net.URL;
/**
 *
 * @author phamv
 */
public class VerifyUtils {
    public static final String SITE_VERIFY_URL="https://www.google.com/recaptcha/api/siteverify";
    public static boolean verify(String gRecaptchaResponse){
        if(gRecaptchaResponse == null || gRecaptchaResponse.length() == 0){
            return false;
        }
        try{
            URL verifyUrl = new URL(SITE_VERIFY_URL);
            //mo ket noi connection toi URL
            HttpURLConnection conn = (HttpURLConnection) verifyUrl.openConnection();
            //them cac thong tin Header vao request chuan bi gui toi server
            conn.setRequestMethod("POST");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0");
            conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            //Du lieu se gui toi server
            String postParams = "secret=" +MyConstant.SECRET_KEY
                    +"&response="+ gRecaptchaResponse;
            //send Request
            conn.setDoOutput(true);
            //lay du lieu output stream cua knoi toi server
            //ghi du lieu output vao stream, co nghia gui thong tin toi server
            OutputStream outStream = conn.getOutputStream();
            outStream.write(postParams.getBytes());
            
            outStream.flush();
            outStream.close();
            //Ma tra loi dc tra ve tu server
            int responeCode = conn.getResponseCode();
            System.out.println("responseCode="+responeCode);
            //lay input stream cua connection 
            //de doc du lieu gui den tu Server
            InputStream is = conn.getInputStream();
            
            JsonReader jsonReader = Json.createReader(is);
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
            System.out.println("Respone: "+ jsonObject);
            
            boolean success =jsonObject.getBoolean("success");
            return success;
         
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
