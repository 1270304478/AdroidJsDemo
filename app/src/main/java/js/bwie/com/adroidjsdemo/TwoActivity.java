package js.bwie.com.adroidjsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class TwoActivity extends AppCompatActivity {
    private WebView contentWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        contentWebView = (WebView) findViewById(R.id.webview);
        contentWebView.loadUrl("http://www.baidu.com/");
        contentWebView.getSettings().setJavaScriptEnabled(true);

    }
}
