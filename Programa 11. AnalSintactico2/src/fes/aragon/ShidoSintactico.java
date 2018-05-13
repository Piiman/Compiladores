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
public class ShidoSintactico {
    private String cadena = "a c d d d w c b ; a w b; a c w c b ; a c a w;";
    private String token;
    private int indice;
    private boolean correcto = false;
    private boolean error = false;
    
    public static void main(String[] args) {
        ShidoSintactico app = new ShidoSintactico();
        app.token = app.getToken();
        app.metodo_S();
    }
    
    
    
    private void metodo_Z(){
        if(token!=null && token.equals("a")){
            token = getToken();
            metodo_A();
            if(token!=null && token.equals("b")){
                token = getToken();
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
        if(indice < cadena.split(" ").length){
            token = cadena.split(" ")[indice];
            indice++;
        }
        else{
            token = "EOF";
        }
        return token;
    }

    private void metodo_S() {
        int linea=1;
        do{
            metodo_Z();
            if(token!=null && token.equals(";")){
                correcto = true;
                linea++;
            }
            else{
                error = true;
            }
            if(!error && correcto){
                System.out.println("Sintáxis correcta");
            }
            else{
                System.out.println("Sintáxis incorrecta en la línea "+linea);
            }
            token = getToken();
            error = false;
            correcto = false;
            
        } while (!token.equals("EOF"));
    }
}
