package com.eps.mailsendermodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    EditText enviar_a;
    EditText asunto;
    EditText text_mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = findViewById(R.id.enviar);

        enviar_a = findViewById(R.id.envaiar_a);
        asunto =  findViewById(R.id.asunto_field);
        text_mail = findViewById(R.id.text_mail);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  ENVIAR_A=enviar_a.getText().toString();

                /////////////////////////////////////////////////
                String mydate = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
                /////////////////////////////////////////////////
                String  ASUNTO="LOG -"+mydate;
                String  TEXTO="Alias juguador i demes coses";


                if (enviar_a  != null) {

                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:"));
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{ENVIAR_A});
                    intent.putExtra(Intent.EXTRA_SUBJECT, ASUNTO);
                    intent.putExtra(Intent.EXTRA_TEXT, TEXTO);

                    try {
                        //Enviamos el Correo iniciando una nueva Activity con el emailIntent.
                        startActivity(Intent.createChooser(intent, "Enviar Correo..."));
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(MainActivity.this, "No hay ningun cliente de correo instalado.", Toast.LENGTH_SHORT).show();
                     }




                    /*Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("message/rfc822");
                    i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"skapis1@outlook.com"});
                    i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                    i.putExtra(Intent.EXTRA_TEXT   , "body of email");
                    try {
                        startActivity(Intent.createChooser(i, "Send mail..."));
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(MainActivity.this, "No hay ningun cliente de correo instalado.", Toast.LENGTH_SHORT).show();

                    }*/





                    //Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","androdfast@gmail.com", null));

                    //Instanciamos un Intent del tipo ACTION_SEND
                   /////////////// Intent emailIntent = new Intent(android.content.Intent.ACTION_SENDTO);
                    ///////////////emailIntent.setData(Uri.parse("mailto: pererollon@gmail.com"));
                    //Aqui definimos la tipologia de datos del contenido dle Email en este caso text/html
                    //emailIntent.setType("text/html");
                    // Indicamos con un Array de tipo String las direcciones de correo a las cuales enviar
                   //emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"androdfast@gmail.com"});
                    // Aqui definimos un titulo para el Email
                    ///////////////emailIntent.putExtra(android.content.Intent.EXTRA_TITLE, "El Titulo");
                    // Aqui definimos un Asunto para el Email
                    ///////////////emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, new String[]{"lol"});
                    // Aqui obtenemos la referencia al texto y lo pasamos al Email Intent
                    ///////////////emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,TEXTO);
                    ///////////////try {
                        //Enviamos el Correo iniciando una nueva Activity con el emailIntent.
                    ///////////////    startActivity(Intent.createChooser(emailIntent, "Enviar Correo..."));
                    ///////////////} catch (android.content.ActivityNotFoundException ex) {
                    ///////////////    Toast.makeText(MainActivity.this, "No hay ningun cliente de correo instalado.", Toast.LENGTH_SHORT).show();
                    ///////////////  }
                }

                }






            });
        }



    }

