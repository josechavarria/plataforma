/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
  import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
/**
 * encoder e decoder para base 64
 * @author josechavarria
 */
public class StrinUtils {
  
 //latex=latex.replace("%", "\\%").replace("&", "\\&");
public static String decode(String s) {
    return StringUtils.newStringUtf8(Base64.decodeBase64(s)).replace("$","\\$").replace("%", "\\%").replace("&", "\\&");
}
public static String decode1(String s) {
    return StringUtils.newStringUtf8(Base64.decodeBase64(s));
}
public static String encode(String s) {
    return Base64.encodeBase64String(StringUtils.getBytesUtf8(s));
}
public static String pointTosmicolon(Float s){

    return (s+"").replace(".", ",");

}

 
   


}
