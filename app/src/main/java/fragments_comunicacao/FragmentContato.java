package fragments_comunicacao;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import lavanderia.ambientalwash.R;

public class FragmentContato extends Fragment {

    private ProgressBar progressBar;
    private WebView webView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.contato,container,false);

        progressBar = (ProgressBar)view.findViewById(R.id.progressBar);



        webView = (WebView) view.findViewById(R.id.webViewCcontato);
        webView.getSettings().setJavaScriptEnabled(true); //enable javascript
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);

                progressBar.setVisibility(View.VISIBLE);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                progressBar.setVisibility(View.GONE);

            }
        }); //important to open url in to project

        webView.loadUrl("http://www.ambientalwash.com.br/novo/solucoes.html#");


                return view;

    }


}
