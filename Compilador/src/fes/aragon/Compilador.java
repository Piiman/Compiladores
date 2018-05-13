/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon;

import javax.swing.JOptionPane;

/**
 *
 * @author Miguel
 */
public class Compilador {
    private String cadena="";
    private int aceptar=1;
    private int error=0;
    private int indice=0;
    public static void main (String[]args){
        Compilador obj =new Compilador();
        obj.cadena=JOptionPane.showInputDialog("Dame la cadena");
        if(obj.aceptar==obj.estado_A()){
            JOptionPane.showMessageDialog(null, "Valida");
        }else{
            JOptionPane.showMessageDialog(null, "invalida");
        }
    }
    private char siguienteCaracter(){
        char c=' ';
        if(indice<cadena.length()) {
        c=cadena.charAt(indice);
        indice++;
        }
        return c;
    }
    private int estado_A(){
        char c = siguienteCaracter();
        switch(c){
            case'a':return estado_B();
            case'b':return estado_C();
            default:return error;
        }
    }

    private int estado_B() {
        char c = siguienteCaracter();
        switch(c){
            case'a':return estado_B();
            case'b':return estado_D();
            default:return error;
        }
    }

    private int estado_C() {
        char c = siguienteCaracter();
        switch(c){
            case'a':return estado_B();
            case'b':return estado_B();
            default:return error;
        }
    }

    private int estado_D() {
        char c = siguienteCaracter();
        switch(c){
            case'a':return estado_B();
            case'b':return estado_E();
            default:return error;
        }
    }

    private int estado_E() {
        char c = siguienteCaracter();
        switch(c){
            case'a':return estado_B();
            case'b':return estado_D();
            case' ':return aceptar;
            default:return error;
        }
    }
}
