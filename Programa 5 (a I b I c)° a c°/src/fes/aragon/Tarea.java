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
public class Tarea {
    
    private String cadena ="";
    private int aceptar = 1;
    private int error = 0;
    private int index=0;
    
    public static void main(String[] args) {
        Tarea yii = new Tarea();
        yii.cadena= JOptionPane.showInputDialog("Introduce una cadena");
        if (yii.aceptar == yii.estadoA()){
            JOptionPane.showMessageDialog(null, "Cadena Valida");         
        } else {
            JOptionPane.showMessageDialog(null, "Cadena Invalida");
        }
    }

    private char next(){
        char c = ' ';
        if (index<cadena.length()) {
            c = cadena.charAt(index);
            index++;
        }
        return c;
    }
    
    private int estadoA() {
        char c = next();
        switch(c){
            case 'a': return estadoB();
            case 'b': return estadoC();
            case 'c': return estadoD();
            default: return error;
        }
    }

    private int estadoB() {
        char c = next();
        switch(c){
            case 'a': return estadoB();
            case 'b': return estadoC();
            case 'c': return estadoE();
            case ' ': return aceptar;
            default: return error;
        }
    }

    private int estadoC() {
        char c = next();
        switch(c){
            case 'a': return estadoB();
            case 'b': return estadoC();
            case 'c': return estadoD();
            default: return error;
        }
    }

    private int estadoD() {
        char c = next();
        switch(c){
            case 'a': return estadoB();
            case 'b': return estadoC();
            case 'c': return estadoD();
            default: return error;
        }
    }

    private int estadoE() {
        char c = next();
        switch(c){
            case 'a': return estadoB();
            case 'b': return estadoC();
            case 'c': return estadoE();
            case ' ': return aceptar;
            default: return error;
        }
    }
    
}
