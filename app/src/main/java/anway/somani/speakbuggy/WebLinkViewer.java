package anway.somani.speakbuggy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class WebLinkViewer extends AppCompatActivity {

    WebView weblink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_site);

        // Do nothing here. Please do not touch!
        weblink = (WebView) findViewById(R.id.website);
        weblink.loadUrl("file:///android_asset/carinfo.html");
    }
}
