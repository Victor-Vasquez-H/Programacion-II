/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresa;
public class Direccion {
    private String ciudad;
    private String direccion;
    private int numero;

    public Direccion(String ciudad, String direccion, int numero) {
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", numero=" + numero +
                '}';
    }
    
}

