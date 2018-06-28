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

public class FragmentSolucaoEmpresarial extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.solucao_empresarial,container,false);


        WebView webView = (WebView) view.findViewById(R.id.webEmpresarial);
        webView.getSettings().setJavaScriptEnabled(true); //enable javascript
        webView.setWebViewClient(new WebViewClient()); //important to open url in to project
        webView.loadUrl("http://www.ambientalwash.com.br/novo/solucoes.html");

        return view;
    }
}
