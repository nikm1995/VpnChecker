package com.nikhil.vpndetector.DA;


import android.text.format.Formatter;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class VpnDetector {
    private final String address="https://www.ipqualityscore.com/free-ip-lookup-proxy-vpn-test/lookup/";
    private String TAG="";
    private RequestData rd = new RequestData(new StringBuilder());

   public VpnDetector() {

        rd.MyConnection(address + GetIpAdd());
        rd.MyDigit("Proxy/VPN Detection", "/>", "Proxy");
        rd.MyDigit("IP Address", "</", "IP Address");
        rd.MyDigit("Organization", "</", "Org");
        rd.MyDigit("Region", "</", "Region");
        rd.MyDigit("City", "</", "City");
        rd.MyDigit("Country", "<", "Country");
        rd.MyDigit("Time Zone", "</", "TimeZone");
    }


	 private String GetIpAdd(){
         try{
             for(Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();){
                 NetworkInterface intf=en.nextElement();
                 for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();){
                     InetAddress inetAddress=enumIpAddr.nextElement();
                     if(!inetAddress.isLoopbackAddress()){
                         String ip= Formatter.formatIpAddress(inetAddress.hashCode());
                         Log.i(TAG, "***** IP="+ ip);
                         return ip;

                     }
                 }
             }

         } catch (SocketException e) {
             e.printStackTrace();
         }
         return null;

     }

     public VpnResponse getResponse(){
       VpnResponse vpnResponse=new VpnResponse();
       JSONObject js=rd.getObjuser();
       try {
           vpnResponse.City = js.getString("City");
           vpnResponse.Country = js.getString("Country");
           vpnResponse.IpAddress=js.getString("IP Address");
           vpnResponse.Org=js.getString("Org");
           vpnResponse.Region=js.getString("Region");
           vpnResponse.Timezone=js.getString("TimeZone");
           vpnResponse.Vpn=js.getBoolean("Proxy");

       } catch (JSONException e) {
           e.printStackTrace();
       }
        return vpnResponse;

     }
}


