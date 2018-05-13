/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon;

/**
 *
 * @author nmayhem
 */
public class Sintactico {
    private String cadena = "a c d d d w c b ;";
    private String token;
    private int indice;
    private boolean correcto = false;
    private boolean error = false;
    
    public static void main(String[] args) {
        Sintactico app = new Sintactico();
        app.token = app.getToken();
        app.metodo_S();
        if(!app.error && app.correcto){
            System.out.println("Sintáxis correcta");
        }
        else{
            System.out.println("Sintáxis incorrecta");
        }
    }
    
    private void metodo_S(){
        if(token!=null && token.equals("a")){
            token = getToken();
            metodo_A();
            if(token!=null && token.equals("b")){
                token = getToken();
                if(token!=null && token.equals(";")){
                    correcto = true;
                }
                else{
                    error = true;
                }
            }
            else{
                error = true;
            }
        }
        else{
            error = true;
            }
    }

    private void metodo_A() {
        if(token!=null && token.equals("c")){
            token = getToken();
            metodo_B();
            if(token!=null && token.equals("c")){
                token = getToken();
            }
            else {
                error = true;
            }
        }
        else{
            error = true;
        }
    }
    
    private void metodo_B() {
        if(token!=null && token.equals("d")){
            token = getToken();
            metodo_B();
        }
        else if(token!=null && token.equals("w")){
            token = getToken();
        }
        else{
            error = true;
        }
    }

    private String getToken() {
        String token = null;
        if(indice <cadena.split(" ").length){
            token = cadena.split(" ")[indice];
            indice++;
        }
        return token;
    }
    
} 


