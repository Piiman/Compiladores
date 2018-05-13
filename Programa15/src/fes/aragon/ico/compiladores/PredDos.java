/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.ico.compiladores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author Benjiman
 */
public class PredDos {

    private final ArrayList<String> noterminales = new ArrayList<>(Arrays.asList("S", "A", "B", "C"));
    private final ArrayList<String> terminales = new ArrayList<>(Arrays.asList("a", "b", "c", "d", ";"));
    private final String[] predictivos = {"CBA", "CBA", "CBA", "CBA", "E", "°", "b", "c", "°", "E", "Cba", "E", "E", "°", "E", "E", "E", "E", "d", "E"};
    private Stack<String> pila;
    private int error = 0;

    public static void main(String[] args) {
        PredDos app = new PredDos();
        ArrayList<String> cadenaar = new ArrayList<>(Arrays.asList(JOptionPane.showInputDialog("Palabra a analizar").split("")));
        ArrayList<String> agregar;
        app.pila = new Stack<>();
        app.pila.push(";");
        app.pila.push("S");
        while (!app.pila.isEmpty() && !cadenaar.isEmpty() && app.error == 0) {
            if (app.noterminales.contains(app.pila.peek()) && app.terminales.contains(cadenaar.get(0))) {
                agregar = new ArrayList<>(Arrays.asList(app.predictivos[(app.noterminales.indexOf(app.pila.peek()) * 5) + (app.terminales.indexOf(cadenaar.get(0)))].split("")));
                app.pila.pop();
                if (!agregar.get(0).equals("°")) {
                    for (String string : agregar) {
                        app.pila.push(string);
                    }
                }
            } else {
                if (app.terminales.contains(app.pila.peek()) && app.terminales.contains(cadenaar.get(0))) {
                    if (app.pila.peek().equals(cadenaar.get(0))) {
                        app.pila.pop();
                        cadenaar.remove(0);
                    } else {
                        app.error = 1;
                    }
                } else {
                    app.error = 1;
                }
            }
        }
        if (app.error == 0 && app.pila.empty() && cadenaar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Correcto");
        } else {
            JOptionPane.showMessageDialog(null, "Incorrecto");
        }
    }
}
