package com.mycompany.pp2.clases;

import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class JuegoMarvelvsDC implements Serializable {
    private static final long serialVersionUID = 1L; // Versión de serialización

    // Atributos
    private String nombreJuego;
    private Collection<Usuario> usuarios;
    private Collection<Personaje> personajes;
    private Collection<Ciudad> ciudades;

    // Archivo donde se guardarán los datos
    private static final String ARCHIVO_DATOS = "juego_datos.dat";

    // Constructor
    public JuegoMarvelvsDC() {
        this.nombreJuego = "Marvel vs DC";
        this.usuarios = new ArrayList<>();
        this.personajes = new ArrayList<>();
        this.ciudades = new ArrayList<>();
        verificarYCrearDatos(); // Cargar o crear datos al iniciar la clase
    }

    // Función para verificar si hay datos, si no, crear los datos iniciales
    public void verificarYCrearDatos() {
        File archivo = new File(ARCHIVO_DATOS);
        if (!archivo.exists() || archivo.length() == 0) { // Si no existe o está vacío
            System.out.println("No hay datos guardados. Creando datos iniciales...");
            crearDatosIniciales();
        } else {
            cargarDatos();
        }
    }

    // Función para crear datos predefinidos
    public void crearDatosIniciales() {
        // Ciudades predefinidas
        agregarCiudad(new Ciudad("Estados Unidos", "New York", "New York", Ciudad.TipoEscenario.CIUDAD));
        agregarCiudad(new Ciudad("Latveria", "Reino de Latveria", "Doomstadt", Ciudad.TipoEscenario.MONTAÑA));
        agregarCiudad(new Ciudad("Genosha", "República de Genosha", "Hammer Bay", Ciudad.TipoEscenario.CIUDAD));

        // Personajes predefinidos
        registrarPersonaje(new Personaje("Peter Parker", null, "New York", "", Personaje.TipoPersonaje.HEROE, "Spider-Man", "",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.MARVEL, 90, 85, 85, 5));

        registrarPersonaje(new Personaje("Bruce Wayne", null, "Gotham", "", Personaje.TipoPersonaje.HEROE, "Batman", "",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.DC, 75, 60, 90, 100));

        registrarPersonaje(new Personaje("Tony Stark", null, "New York", "", Personaje.TipoPersonaje.HEROE, "Iron Man", "",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.MARVEL, 80, 90, 80, 100));

        registrarPersonaje(new Personaje("Clark Kent", null, "Metrópolis", "", Personaje.TipoPersonaje.HEROE, "Superman", "",
                Personaje.TipoOrigen.ALIENIGENA, Personaje.TipoFranquicia.DC, 100, 95, 65, 15));

        registrarPersonaje(new Personaje("Reed Richards", null, "New York", "", Personaje.TipoPersonaje.HEROE, "Mr. Fantastic", "",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.MARVEL, 50, 40, 100, 90));

        registrarPersonaje(new Personaje("Wanda Maximoff", null, "Sokovia", "", Personaje.TipoPersonaje.HEROE, "Scarlet Witch", "",
                Personaje.TipoOrigen.MUTANTE, Personaje.TipoFranquicia.MARVEL, 85, 35, 60, 40));

        // Usuarios predefinidos
        registrarUsuario(new Usuario("Gabriel", "Barrantes V", "GaboBaVi", "gabbarrantes@estudiantec.cr", "estoesprivado!!!"));

        guardarDatos();
        System.out.println("Datos iniciales creados y guardados.");
    }

    // Métodos para Usuarios
    public void registrarUsuario(Usuario usuario) {
        if (usuario != null && !usuarios.contains(usuario)) {
            usuarios.add(usuario);
            guardarDatos();
        }
    }

    public void eliminarUsuario(Usuario usuario) {
        if (usuarios.remove(usuario)) {
            guardarDatos();
        }
    }

    // Métodos para Personajes
    public void registrarPersonaje(Personaje personaje) {
        if (personaje != null && !personajes.contains(personaje)) {
            personajes.add(personaje);
            guardarDatos();
        }
    }

    public void eliminarPersonaje(Personaje personaje) {
        if (personajes.remove(personaje)) {
            guardarDatos();
        }
    }

    // Métodos para Ciudades
    public void agregarCiudad(Ciudad ciudad) {
        if (ciudad != null && !ciudades.contains(ciudad)) {
            ciudades.add(ciudad);
            guardarDatos();
        }
    }

    public void eliminarCiudad(Ciudad ciudad) {
        if (ciudades.remove(ciudad)) {
            guardarDatos();
        }
    }

    // Métodos para guardar y cargar datos desde archivo
    public void guardarDatos() {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ARCHIVO_DATOS))) {
            salida.writeObject(this);
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public void cargarDatos() {
        File archivo = new File(ARCHIVO_DATOS);
        if (archivo.exists()) {
            try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ARCHIVO_DATOS))) {
                JuegoMarvelvsDC datosCargados = (JuegoMarvelvsDC) entrada.readObject();
                this.usuarios = datosCargados.usuarios;
                this.personajes = datosCargados.personajes;
                this.ciudades = datosCargados.ciudades;
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al cargar los datos: " + e.getMessage());
            }
        }
    }

    // Método para mostrar el estado del juego
    @Override
    public String toString() {
        return "JuegoMarvelvsDC{" +
                "nombreJuego='" + nombreJuego + '\'' +
                ", usuarios=" + usuarios.size() +
                ", personajes=" + personajes.size() +
                ", ciudades=" + ciudades.size() +
                '}';
    }

    // Método principal de prueba
    public static void main(String[] args) {
        JuegoMarvelvsDC juego = new JuegoMarvelvsDC();
        System.out.println(juego);
    }
}

