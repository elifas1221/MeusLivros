package com.example.elifas1.meuslivros;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.elifas1.meuslivros.Models.Usuario;
import com.example.elifas1.meuslivros.Services.UserService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button btCadastrar, btLogin;
    private EditText edtNome, edtLogin, edtSenha;

    Usuario resposta = new Usuario();
    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome  = (EditText) findViewById(R.id.edtNome);
        edtLogin = (EditText) findViewById(R.id.edtLogin);
        edtSenha = (EditText) findViewById(R.id.edtSenha);

        btCadastrar = (Button) findViewById(R.id.btCadastrar);
        btLogin = (Button) findViewById(R.id.btLogin);
        listenersButtons();
    }


    /**
     * Chama os listeners para os botões
     */
    public void listenersButtons() {

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progress = new ProgressDialog(MainActivity.this);
                progress.setTitle("Cadastrando Usuário...");
                progress.show();


                String nomeUser = edtNome.getText().toString();
                String loginUser = edtLogin.getText().toString();
                String senhaUser = edtSenha.getText().toString();

                cadastrarUsuario(nomeUser, loginUser, senhaUser);

            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Login.class);

                startActivity(intent);

            }
        });
    }

public void cadastrarUsuario(final String nomeUser, String loginUser, String senhaUser) {

    RetrofitUser service = UserService.createService(RetrofitUser.class);

    Call<Usuario> call = service.cadastrarUsuario(nomeUser, loginUser, senhaUser);

    call.enqueue(new Callback<Usuario>() {
        @Override
        public void onResponse(Call<Usuario> call, Response<Usuario> response) {

            if (response.isSuccessful()) {

                Usuario respostaServidor = response.body();

                if (respostaServidor != null) {

                    if(respostaServidor.isValid()) {

                        resposta.setNome(respostaServidor.getNome());
                        resposta.setResult(respostaServidor.getResult());
                        resposta.setValid(respostaServidor.isValid());

                        progress.dismiss();
                        Toast.makeText(getApplicationContext(),"Usuario: " , Toast.LENGTH_SHORT).show();


                    } else{

                        Toast.makeText(getApplicationContext(),"Insira unidade e valores válidos", Toast.LENGTH_SHORT).show();
                    }

                } else {

                    Toast.makeText(getApplicationContext(),"Resposta nula do servidor", Toast.LENGTH_SHORT).show();
                }

            } else {

                Toast.makeText(getApplicationContext(),"Resposta não foi sucesso", Toast.LENGTH_SHORT).show();
                ResponseBody errorBody = response.errorBody();
            }

            progress.dismiss();
        }


        @Override
        public void onFailure(Call<Usuario> call, Throwable t) {

            Toast.makeText(getApplicationContext(),"Erro na chamada ao servidor", Toast.LENGTH_SHORT).show();
        }
    });

}

}


