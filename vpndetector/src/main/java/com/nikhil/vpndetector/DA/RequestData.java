package com.nikhil.vpndetector.DA;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

public class RequestData {
    private StringBuilder sb1,sb;
    private int srch;
    private URL Connection;
    private URLConnection con;
    private InputStreamReader isr;
    private BufferedReader br;
    private String browser="Mozilla-Firefox";
    private JSONObject objuser = new JSONObject();










    public RequestData(StringBuilder sb) {
        super();
        this.sb = sb;

    }




    public JSONObject getObjuser() {
        return objuser;
    }




    public void setObjuser(JSONObject objuser) {
        this.objuser = objuser;
    }




    public JSONObject MyDigit(String start,String end,String save){
        int k=0;
        sb1=null;
        sb1=new StringBuilder();



        srch=sb.indexOf("<td>"+start+"</td>");

        if(sb.indexOf("<td>"+start+"</td>")<0)
        {

        }else{

            for(int i=srch;i<srch+200;i++){

                sb1.append(sb.charAt(i));
            }

            System.out.println("get Organization with word");
            System.out.println(sb1.toString());

            srch+=sb1.indexOf("</td>");
            sb1=null;
            sb1=new StringBuilder();
            for(int i=srch;i<srch+200;i++){

                sb1.append(sb.charAt(i));
            }



            System.out.println("get all Organization with Detail and </td>");
            System.out.println(sb1.toString());

            srch+=sb1.indexOf("<td>");
            srch+=4;

            sb1=null;
            sb1=new StringBuilder();
            for(int i=srch;i<srch+200;i++){

                sb1.append(sb.charAt(i));
            }

            System.out.println("get all Organization with detail with </td>");
            System.out.println(sb1.toString());
            //k has been reinsintaliizied
            k=0;

            k=srch;
            srch+=sb1.indexOf(end);

            sb1=null;
            sb1=new StringBuilder();
            for(;k<srch;k++){

                sb1.append(sb.charAt(k));
            }

            System.out.println("get Name with Organization");
            System.out.println(sb1.toString());

            //code another for Organization


        }//else end

        if(save.equals("Proxy")){
            try{
                if(sb1.toString().contains("Clean")){
                    objuser.put("Proxy",false);
                }
                else if(sb1.toString().contains("Proxy")){
                    objuser.put("Proxy",true);
                }


            }catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();

            }
        }
        else{

            try {
                objuser.put(save,sb1.toString());
            } catch (JSONException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }


        return objuser;


    }


    public void MyConnection(String add){
        try {
            Connection=new URL(add);

            con=(HttpURLConnection) Connection.openConnection();
            con.setRequestProperty("User-Agent",browser);
            con.setConnectTimeout(2000);

            isr=new InputStreamReader(con.getInputStream(),Charset.forName("UTF-8"));
            br=new BufferedReader(isr);
            int ki;
            while((ki=br.read())!=-1){
                sb.append(br.readLine());
            }
            System.out.println(sb.toString());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
