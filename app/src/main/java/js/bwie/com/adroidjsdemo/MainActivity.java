package js.bwie.com.adroidjsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button but_js;
    private WebView contentWebView;
    private Button but_java;
    private Button but_baidu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but_js = (Button) findViewById(R.id.but_js);
        but_java = (Button) findViewById(R.id.but_java);
        contentWebView = (WebView) findViewById(R.id.webview);
        but_baidu = (Button) findViewById(R.id.but_baidu);
        contentWebView.getSettings().setJavaScriptEnabled(true);
        contentWebView.addJavascriptInterface(MainActivity.this, "android");
        contentWebView.loadUrl("file:///android_asset/web.html");

        but_js.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
               contentWebView.loadUrl("javascript:actionFromNative()");
                Toast.makeText(MainActivity.this, "java调用js弹窗", Toast.LENGTH_SHORT).show();
            }
        });
        but_java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actionFromJs();

            }
        });
        but_baidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,TwoActivity.class);
                startActivity(intent);
            }
        });

    }
    @JavascriptInterface
    public void actionFromJs(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "js调用了Android函数,我是石东亮", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
