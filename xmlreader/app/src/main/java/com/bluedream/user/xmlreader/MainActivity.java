package com.bluedream.user.xmlreader;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private TextView textView,textView2;
    private Context context;
    private ImageView imageView;
    String result_xml="";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context= this;

        findViews();
        new RunWork().start();
    }


    private void findViews(){
        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        imageView = (ImageView)findViewById(R.id.imageView);
    }

    /*上網抓資料，需要另外開執行緒做處理(Android機制)*/
    private class RunWork extends Thread
    {
        //宣告變數
        String path = "http://opendata.cwb.gov.tw/govdownload?dataid=E-A0015-001R&authorizationkey=rdec-key-123-45678-011121314";

        Runnable task = new Runnable(){
            @Override
            public void run() {
                parseXml(result_xml);
            }
        };

        //OkHttpClient官網範例使用
        OkHttpClient client = new OkHttpClient();
        String run(String url) throws IOException {
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            return response.body().string();
        }

        @Override
        public void run()
        {
            try{
                //1.抓資料
                result_xml = run(path);
                //2.改變畫面內容只能用主執行緒(Android機制)
                runOnUiThread(task);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

    }

    //DOM來解析XML格式資料
    private void parseXml(String Stringresult_xml){
        try {
            //取得XML根節點
            InputStream is = new ByteArrayInputStream(result_xml.getBytes(StandardCharsets.UTF_8));


            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();


            DocumentBuilder builder = factory.newDocumentBuilder();


            Document document = builder.parse(is);
            Element root = document.getDocumentElement();

            //取得 TagName 裡的內容
            String reportContent = root.getElementsByTagName("reportContent").item(0).getTextContent();


            String magnitudeValue = root.getElementsByTagName("magnitudeValue").item(0).getTextContent();


            String shakemapImageURI = root.getElementsByTagName("shakemapImageURI").item(0).getTextContent();
            StringBuilder sb = new StringBuilder();
            //取得 Node List
            NodeList shakingAreas = root.getElementsByTagName("shakingArea");


            //取得 Node
            for(int i=0;i<shakingAreas.getLength();i++){
                Element element = (Element) shakingAreas.item(i);
                String areaName = element.getElementsByTagName("areaName").item(0).getTextContent();
                String areaIntensity = element.getElementsByTagName("areaIntensity").item(0).getTextContent();
                //取得 Node內參數值
                String unit = element.getElementsByTagName("areaIntensity").item(0).getAttributes().getNamedItem("unit").getTextContent();
                sb.append(areaName).append("  ").append(areaIntensity).append(unit).append("\n");

            }

            //設定顯示畫面資料
             /*Picasso第三方套件:用來抓 url 圖片*/
            Picasso.with(context).load(shakemapImageURI).into(imageView);
            textView.setText(reportContent +"\n" + magnitudeValue);
            textView2.setText(sb);
        } catch(ParserConfigurationException e) {


            e.printStackTrace();
        } catch(SAXException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }

    }


}
