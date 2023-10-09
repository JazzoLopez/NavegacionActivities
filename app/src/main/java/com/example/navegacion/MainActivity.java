package com.example.navegacion;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle; //Importando los componentes que utilizaremos
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

//Nombres de clase PascalCase
public class MainActivity extends AppCompatActivity {
private EditText txtUsername;
private ImageView ivLogo;
private EditText txtPassword;
private Button btnLogin;
private Button btnTakePicture;
static final int REQUEST_IMAGE_CAPTURE=1; //Siempre en mayusculas
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsername=findViewById(R.id.txt_username); //Id esta en snake_case
        txtPassword=findViewById(R.id.txt_password);
        btnLogin=findViewById(R.id.btn_login);
        btnTakePicture=findViewById(R.id.btn_take_picture);
        ivLogo=findViewById(R.id.iv_logo);
        btnTakePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(takePictureIntent.resolveActivity(getPackageManager())!=null){
                    startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE); //Deprecado es que ya existe una nueva o mas actualizada
                }
            }
        });




        btnLogin.setOnClickListener(new View.OnClickListener() { //Declarando un escuchador.
            @Override
            public void onClick(View view) {
                Bundle parameters= new Bundle();  //Sirve para almacenar en pares, por llave y valor
                //un bundle puede tener varios valores
                parameters.putString("username",txtUsername.getText().toString());
                Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                intent.putExtras(parameters);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle parameters=data.getExtras();
            Bitmap image = (Bitmap) parameters.get("data");
            ivLogo.setImageBitmap(image);
        }
    }
}