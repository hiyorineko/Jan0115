package com.example.hiyoriaya.jan0115;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends Activity implements View.OnClickListener{
    private Thread th;
    private Bitmap oBmp;
    private ImageView iv;
    private String[] wsurl;
    private String[] vgurl;
    private String[] bfurl;
    private int vgc;
    private int wsc;
    private int bfc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView)findViewById(R.id.imageView);
        seturl();
        Button vg = (Button)findViewById(R.id.vg);
        vg.setOnClickListener(this);
        Button ws = (Button)findViewById(R.id.ws);
        ws.setOnClickListener(this);
        Button bf = (Button)findViewById(R.id.bf);
        bf.setOnClickListener(this);
      }

    public void seturl(){
        wsurl = new String[25];
        vgurl = new String[4];
        bfurl = new String[4];
        vgc =0;
        wsc =0;
        bfc =0;
        wsurl[0] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today.png";
        wsurl[1] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today1.png";
        wsurl[2] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today2.png";
        wsurl[3] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today3.png";
        wsurl[4] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today4.png";
        wsurl[5] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today5.png";
        wsurl[6] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today6.png";
        wsurl[7] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today7.png";
        wsurl[8] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today8.png";
        wsurl[9] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today9.png";
        wsurl[10] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today10.png";
        wsurl[11] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today11.png";
        wsurl[12] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today12.png";
        wsurl[13] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today13.png";
        wsurl[14] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today14.png";
        wsurl[15] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today15.png";
        wsurl[16] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today16.png";
        wsurl[17] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today17.png";
        wsurl[18] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today18.png";
        wsurl[19] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today19.png";
        wsurl[20] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today1.gif";
        wsurl[21] ="http://ws-tcg.com/wp/wp-content/uploads/ws_today2.gif";
        wsurl[22]= "http://ws-tcg.com/wp/wp-content/uploads/ws_today3.gif";
        wsurl[23]="http://ws-tcg.com/wp/wp-content/uploads/ws_today4.gif";
        wsurl[24]="http://ws-tcg.com/wp/wp-content/uploads/ws_today5.gif";

        vgurl[0]="http://cf-vanguard.com/wp/wp-content/uploads/vgd_today.png";
        vgurl[1]="http://cf-vanguard.com/wp/wp-content/uploads/vgd_today01.png";
        vgurl[2]="http://cf-vanguard.com/wp/wp-content/uploads/vgd_today02.png";
        vgurl[3]="http://cf-vanguard.com/wp/wp-content/uploads/vgd_today03.png";

        bfurl[0]="http://fc-buddyfight.com/wp/wp-content/uploads/bf_today.png";
        bfurl[1]="http://fc-buddyfight.com/wp/wp-content/uploads/bf_today1.png";
        bfurl[2]="http://fc-buddyfight.com/wp/wp-content/uploads/bf_today2.png";
        bfurl[3]="http://fc-buddyfight.com/wp/wp-content/uploads/bf_today3.png";
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.vg:
                try{
                    //androidはスレッド処理じゃないとhttp接続できないため
                    th = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                //画像のURLを直うち
                                URL url = new URL(vgurl[vgc]);
                                //インプットストリームで画像を読み込む
                                InputStream istream = url.openStream();
                                //読み込んだファイルをビットマップに変換
                                oBmp = BitmapFactory.decodeStream(istream);
                                //インプットストリームを閉じる
                                istream.close();
                            } catch (IOException e) {
                                Resources r = getResources();
                                oBmp = BitmapFactory.decodeResource(r,R.drawable.error);
                            }
                        }
                    });
                    th.start();
                    th.join();
                }catch (InterruptedException ie){}
                //ビットマップをImageViewに設定
                iv.setImageBitmap(oBmp);
                if(vgc!=3) {
                    vgc++;
                }else{
                    vgc=0;
                }
                break;

            //ヴァイスシュバルツの今日のカード取得
            case R.id.ws:

                try{
                    //androidはスレッド処理じゃないとhttp接続できないため
                    th = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                //画像のURLを直うち
                                URL url = new URL(wsurl[wsc]);
                                //インプットストリームで画像を読み込む
                                InputStream istream = url.openStream();
                                //読み込んだファイルをビットマップに変換
                                oBmp = BitmapFactory.decodeStream(istream);
                                //インプットストリームを閉じる
                                istream.close();

                            } catch (IOException e) {
                                Resources r = getResources();
                                oBmp = BitmapFactory.decodeResource(r,R.drawable.error);
                            }
                        }
                    });
                    th.start();
                    th.join();
                }catch (InterruptedException ie){}
                //ビットマップをImageViewに設定
                iv.setImageBitmap(oBmp);
                if(wsc!=24){
                    wsc++;
                }else{
                    wsc=0;
                }
                break;
            case R.id.bf:

                try{
                    //androidはスレッド処理じゃないとhttp接続できないため
                    th = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                //画像のURLを直うち
                                URL url = new URL(bfurl[bfc]);
                                //インプットストリームで画像を読み込む
                                InputStream istream = url.openStream();
                                //読み込んだファイルをビットマップに変換
                                oBmp = BitmapFactory.decodeStream(istream);
                                //インプットストリームを閉じる
                                istream.close();

                            } catch (IOException e) {
                                Resources r = getResources();
                                oBmp = BitmapFactory.decodeResource(r,R.drawable.error);
                            }
                        }
                    });
                    th.start();
                    th.join();
                }catch (InterruptedException ie){}
                //ビットマップをImageViewに設定
                iv.setImageBitmap(oBmp);
                if(bfc!=3) {
                    bfc++;
                }else{
                    bfc=0;
                }
                break;
        }
    }

    private void datas(){

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
