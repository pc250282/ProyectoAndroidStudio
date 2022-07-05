package com.example.proyectologin

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

   //Declaro variables
        //val intent=Intent(this,SegundaActivity::class.java)
        val txtUser=findViewById<EditText>(R.id.txtUser)
        val txtPass=findViewById<EditText>(R.id.txtPass)
        val btnLogin=findViewById<Button>(R.id.btnLogin)
        val lblNotificacion=findViewById<TextView>(R.id.lblNotificacion)
        val lblWelcome=findViewById<TextView>(R.id.lblWelcome)
        val imgLoginOk=findViewById<ImageView>(R.id.imgLogin)
        val imgPrincipal=findViewById<ImageView>(R.id.imgPrincipal)


    //Accion del boton

        btnLogin.setOnClickListener {
            var convertStringUser=txtUser.text.toString()
            var convertStringPass=txtPass.text.toString()
            val user1 =Users("pablo","1234")



            //Validaciones de login

            if(txtUser.text.isEmpty()||txtPass.text.isEmpty()){
                Toast.makeText(this,"Completa ambos datos para ingresar",Toast.LENGTH_SHORT).show()
            }else{

            if(convertStringUser.equals(user1.nameUser)){
                Toast.makeText(this,"USUARIO VALIDO",Toast.LENGTH_SHORT).show()
                if(convertStringPass.equals(user1.passUser)&&convertStringUser.equals(user1.nameUser)){
                    Toast.makeText(this,"LOGUEO COMPLETADO",Toast.LENGTH_SHORT).show()

                    btnLogin.setVisibility(View.INVISIBLE)
                    txtPass.setVisibility(View.INVISIBLE)
                    txtUser.setVisibility(View.INVISIBLE)
                    lblNotificacion.setGravity(Gravity.CENTER)
                    lblNotificacion.setText("Bievenido "+convertStringUser)
                    imgPrincipal.setVisibility(View.INVISIBLE)
                    lblWelcome.setVisibility(View.INVISIBLE)
                    imgLoginOk.setImageResource(R.drawable.ok)


                    //pasar datos a paso el usuario a la segunda actividad
                    //intent.putExtra("user",user1.nameUser)
                    //startActivity(intent)
                }
                else{
                    Toast.makeText(this,"CONTRASEÑA INCORRECTA",Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"USUARIO INCORRECTO",Toast.LENGTH_SHORT).show()
            }

        }


        }



}

}