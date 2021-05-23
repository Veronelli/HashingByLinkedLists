/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hahing;

import javax.swing.JOptionPane;

/**
 *
 * @author facu
 */
public class Hahing {

    static int array = 5;

    Users[] users = new Users[array];

    public static void main(String[] args) {
        char op = 'Y';
        Users user;

        Hahing Hashing = new Hahing();

        while (op == 'Y') {
            user = insertarDatos();

            int user_num_sector = numSector(user.sector);
            int user_hash = getHashing(user_num_sector);

            Hashing.insertar(user, user_hash);

            op = JOptionPane.showInputDialog("Desea se continuar?(Y/N)").toUpperCase().charAt(0);
            System.out.println("Opcion: " + op);

        }
        Hashing.imprimir();

    }

    //-----------------------Funciones-----------------------
    //Colocar a todas las posiciones en null
    public void setNull() {
        for (int i = 0; i < users.length; i++) {
            users[i] = null;

        }

    }

    //Obtener un Hash
    static int getHashing(int num_sector) {
        int hash = num_sector % array;
        System.out.println("hash: " + hash);

        return hash;

    }

    //Obtener la suma de las letras del sector
    static int numSector(String sector) {
        int num_sector = 0;
        int long_sector = sector.length();

        System.out.println(" ------------------------------------------------\n"
                            + "Letras:");

        for (int i = 0; i < long_sector; i++) {
            char temp_char = sector.charAt(i);
            int valor_char = (int) temp_char;

            System.out.println(temp_char + ": " + valor_char);

            num_sector += temp_char;

        }
        return num_sector;

    }

    //Insertar datos dentro de un objeto "USER"
    static Users insertarDatos() {

        /*
        Users: user
                .nombre = "Facundo"
                .edad = 21
                .sector = "Programación"
        
         */
        Users user = new Users();

        user.nombre = JOptionPane.showInputDialog(null, "Ingrese un nombre");
        System.out.println("user.nombre: " + user.nombre);

        user.edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad del empleado "));
        System.out.println("user.edad: " + user.edad);

        user.sector = JOptionPane.showInputDialog(null, "Ingrese sector donde trabaja");
        System.out.println("user.sector: " + user.sector);

        return user;

    }

    //Insertar datos dentro de un array de "USERS"
    public void insertar(Users user, int user_hash) {
        Users nuevo = user;

        if (users[user_hash] == null) {
            nuevo.sig = null;
            users[user_hash] = nuevo;

        } else {
            nuevo.sig = users[user_hash];
            users[user_hash] = nuevo;

        }

    }

    //Imprimir todos los array 
    public void imprimir() {

        /*
        imprimir:
            [0] -> user -> user -> user
            [1] -> user
            [3] -> user -> user
        
         */
        for (int i = 0; i < array; i++) {
            Users reco = users[i];
            System.out.print(i + ":");

            while (reco != null) {
                System.out.println("Empleado: " + reco.nombre + " // " + reco.edad + " // " + reco.sector + "// ==>>");
                reco = reco.sig;

            }

        }

    }

}

class Users {

    int edad;
    String nombre;
    String sector;

    Users sig;
};
