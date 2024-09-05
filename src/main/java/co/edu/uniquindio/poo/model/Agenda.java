package co.edu.uniquindio.poo.model;

import java.util.Arrays;
public class Agenda {

    private String nombre;
    private Contacto[] listaContactos = new Contacto[50];

    public Agenda(String nombre) {

        this.nombre = nombre;
        this.listaContactos = new Contacto[50];

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Contacto[] getListaContactos() {
        return listaContactos;
    }

    public void setListaContactos(Contacto[] listaContactos) {
        this.listaContactos = listaContactos;
    }

    @Override
    public String toString() {
        return "\nContactos [nombre=" + nombre + ", listaContactos=" + Arrays.toString(listaContactos) + "]";
    }

    /*
     * Este método almacena un nuevo contacto, solo si hay espacios disponibles y el
     * contacto aun no ha sido registrado.
     */
    public String crearContacto(Contacto nuevoContacto) {

        String mensaje = "";
        int posicionDisponible = 0;
        Contacto contactoEncontrado = null;

        posicionDisponible = buscarPosicionDisponible();

        if (posicionDisponible == -1) {
            mensaje = "\nNo hay espacio para un nuevo contacto.";
            return mensaje;
        } else {
            contactoEncontrado = buscarContacto(nuevoContacto.getNombre(), nuevoContacto.getTelefono());

            if (contactoEncontrado != null) {
                mensaje = "\nEl contacto ya se encuentra registrado.";
            } else {
                listaContactos[posicionDisponible] = nuevoContacto;
                mensaje = "\nEl contacto se a almacenado exitosamente.";
            }
        }

        return mensaje;
    }

    /*
     * Este método busca una posición disponible y la retorna, en caso de no haber,
     * retorna -1.
     */
    private int buscarPosicionDisponible() {
        int posicionDisponible = -1;

        for (int i = 0; i < listaContactos.length; i++) {
            Contacto contacto = listaContactos[i];
            if (contacto == null) {
                posicionDisponible = i;
                return posicionDisponible;
            }
        }

        return posicionDisponible;
    }

    /*
     * Este método busca un contacto un base a su nombre y número de teléfono.
     */
    public Contacto buscarContacto(String nombre, String telefono) {
        Contacto contactoEncontrado = null;

        for (int i = 0; i < listaContactos.length; i++) {
            Contacto contactoAux = listaContactos[i];
            if (contactoAux != null) {
                if (contactoAux.getNombre().equals(nombre) && contactoAux.getTelefono().equals(telefono)) {
                    contactoEncontrado = contactoAux;
                    return contactoEncontrado;
                }
            }
        }

        return contactoEncontrado;
    }

    /*
     * Este método elimina un contacto, si lo encuentra.
     */
    public String eliminarContacto(String nombre, String telefono) {
        String mensaje = "\nEl contacto no existe.";

        for (int i = 0; i < listaContactos.length; i++) {
            Contacto contactoAux = listaContactos[i];
            if (contactoAux != null) {
                if (contactoAux.getNombre().equals(nombre) && contactoAux.getTelefono().equals(telefono)) {
                    listaContactos[i] = null;
                    mensaje = "\nEl contacto ha sido eliminado correctamente.";
                    return mensaje;
                }                
            }           
        }
        return mensaje;
    }

    /*
     * Este método actualiza la información de un contacto, si lo encuentra.
     */
    public String actualizarContancto(String nombre, String alias, String direccion, String telefono, String email) {
        String mensaje = "\nEl contacto no se encuentra registrado.";
        Contacto contactoEncontrado = buscarContacto(nombre, telefono);
        if (contactoEncontrado != null) {
            contactoEncontrado.setNombre(nombre);
            contactoEncontrado.setAlias(alias);
            contactoEncontrado.setDireccion(direccion);
            contactoEncontrado.setTelefono(telefono);
            contactoEncontrado.setEmail(email);
            mensaje = "\nLa información del contacto ha sido actualizada de manera satisfactoria.";
            return mensaje;
        }

        return mensaje;
    }

//1.

public void imprimirContactosPosImpares(){
    for (int i = 0; i < listaContactos.length; i++) {
       if(!(i % 2 == 0)){
            System.out.println(listaContactos[i]);
       } 
    }
}

public double calcularPromedio(){
       
    int sumatoria = 0;
    int cont = 0;
    for (int i = 0; i < listaContactos.length; i++) {
        if(listaContactos[i] != null){
            sumatoria += listaContactos[i].getEdad();//18
            cont++;
         }
    }
    return sumatoria / cont;
}


public void eliminarContactosVocales(){

		
	for(int i = 0; i < listaContactos.length;i++){
		
		Contacto aux = listaContactos[i];
		if(aux != null){
		
			int contadorVocales = aux.cuantasVocalesTiene();
			if(contadorVocales >= 3){
				listaContactos[i] = null;
			}
		}
	
	}
}





public int obtenerEdadMasRepeticiones(){
    int edadMasRepetida = 0;
    int contadorMasRepetida = 0;
    int contador = 1;

    for (int i = 0; i < listaContactos.length; i++) {
        if(listaContactos[i] != null){
            int edadi = listaContactos[i].getEdad();//18
            contador = 0;
            contador = levanteLaManoLosDeEdad(edadi);
            if(contador > contadorMasRepetida){
                contadorMasRepetida = contador;
                edadMasRepetida = edadi;
            }
        }
    }
    return edadMasRepetida;
}

public int obtenerEdadMenosRepeticiones(){
    int edadmenosRepetida = 0;
    int contadormenosRepetida = listaContactos.length;
    int contador = 1;

    for (int i = 0; i < listaContactos.length; i++) {
        if(listaContactos[i] != null){
            int edadi = listaContactos[i].getEdad();//18
            contador = 0;
            contador = levanteLaManoLosDeEdad(edadi);
            if(contador < contadormenosRepetida){
                contadormenosRepetida = contador;
                edadmenosRepetida = edadi;
            }
        }
    }
    return edadmenosRepetida;
}



private int levanteLaManoLosDeEdad(int edadi) {
    int contador = 0;
    for (int j = 0; j < listaContactos.length; j++) {
        if(listaContactos[j] != null){
            int edadJ = listaContactos[j].getEdad();
            if(edadi == edadJ){
                contador++;
            }
        }
    }
    return contador;
}







}
