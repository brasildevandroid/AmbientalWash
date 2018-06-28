package fragments_comunicacao;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import lavanderia.ambientalwash.R;

public class FragmentServicos extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.servico,container,false);


        WebView webView = (WebView) view.findViewById(R.id.webServicos);
        webView.getSettings().setJavaScriptEnabled(true); //enable javascript
        webView.setWebViewClient(new WebViewClient()); //important to open url in to project
        webView.loadUrl("http://www.ambientalwash.com.br/novo/index.html#services");

        return view;
    }
}
