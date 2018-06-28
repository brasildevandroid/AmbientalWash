package lavanderia.ambientalwash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import fragments_comunicacao.FragmentContato;
import fragments_comunicacao.FragmentQuemSomos;
import fragments_comunicacao.FragmentServicos;
import fragments_comunicacao.FragmentSolucaoEmpresarial;

public class TelaPrincipal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

/*
       [isso quebra á aplicação]
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        Toast.makeText(this,user.getDisplayName(),Toast.LENGTH_SHORT).show();
*/

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                startActivity(new Intent(TelaPrincipal.this,TelaLogin.class));
                finish();

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tela_principal, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_minha_conta) {
            // Handle the camera action
        } else if (id == R.id.nav_meus_agendamentos) {

        } else if (id == R.id.nav_sair) {

            //[btn sair ]

                AuthUI.getInstance()
                        .signOut(this)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            public void onComplete(@NonNull Task<Void> task) {

                                if (task.isSuccessful()) {
                                    // user is now signed out
                                    startActivity(new Intent(TelaPrincipal.this, TelaLogin.class));
                                    finish();

                                }

                            }
                        });

        } else if (id == R.id.nav_configuracoes) {

        } else if (id == R.id.nav_contato) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_tela_principal,new FragmentContato())
                    .commit();


        } else if (id == R.id.nav_quem_somos) {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_tela_principal,new FragmentQuemSomos())
                    .commit();

        }else if (id == R.id.nav_solucao_empresarial){


            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_tela_principal,new FragmentSolucaoEmpresarial())
                    .commit();

        }else if (id == R.id.nav_servicos){

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_tela_principal,new FragmentServicos())
                    .commit();


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
