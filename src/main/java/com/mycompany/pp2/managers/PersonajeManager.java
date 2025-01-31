/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pp2.managers;

import com.mycompany.pp2.clases.Personaje;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gabob
 */

public class PersonajeManager {
    private static final String ARCHIVO_PERSONAJES = "personajes.dat";
    private static final List<Personaje> listaPersonajes = new ArrayList<>();

    public static void agregarPersonaje(Personaje personaje) {
        listaPersonajes.add(personaje);
        guardarPersonajes();
    }

    public static List<Personaje> getListaPersonajes() {
        return listaPersonajes;
    }

    public static void eliminarPersonaje(int indice) {
        if (indice >= 0 && indice < listaPersonajes.size()) {
            listaPersonajes.remove(indice);
            guardarPersonajes();
        }
    }

    public static void editarPersonaje(int indice, Personaje personaje) {
        if (indice >= 0 && indice < listaPersonajes.size()) {
            listaPersonajes.set(indice, personaje);
            guardarPersonajes();
        }
    }

    private static void guardarPersonajes() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARCHIVO_PERSONAJES))) {
            out.writeObject(listaPersonajes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void cargarPersonajes() {
        File archivo = new File(ARCHIVO_PERSONAJES);
        if (archivo.exists() && archivo.length() > 0) { 
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARCHIVO_PERSONAJES))) {
                List<Personaje> personajesCargados = (List<Personaje>) in.readObject();
                listaPersonajes.clear(); // Evita duplicados
                listaPersonajes.addAll(personajesCargados);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private static Date calcularFechaNacimiento(int año, int mes, int dia) {
        Calendar calendario = Calendar.getInstance();
        calendario.set(año, mes - 1, dia);
        return calendario.getTime();
    }

    public static void inicializarPersonajes() {
        cargarPersonajes();
        if (listaPersonajes.isEmpty()) { // Solo inicializa si la lista está vacía
            listaPersonajes.add(new Personaje(
                "Peter Parker", calcularFechaNacimiento(2004, 8, 27), "Estados Unidos", "/images/spiderman.png",
                Personaje.TipoPersonaje.HEROE, "Spider-Man", "/images/spiderman.png",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.MARVEL,
                90, 85, 85, 5
            ));

            listaPersonajes.add(new Personaje(
                "Bruce Wayne", calcularFechaNacimiento(1988, 2, 19), "Estados Unidos", "/images/batman.png",
                Personaje.TipoPersonaje.HEROE, "Batman", "/images/batman.png",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.DC,
                75, 60, 90, 100
            ));

            listaPersonajes.add(new Personaje(
                "Tony Stark", calcularFechaNacimiento(1974, 5, 29), "Estados Unidos", "/images/ironman.png",
                Personaje.TipoPersonaje.HEROE, "Iron Man", "/images/ironman.png",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.MARVEL,
                80, 90, 80, 100
            ));

            listaPersonajes.add(new Personaje(
                "Clark Kent", calcularFechaNacimiento(1990, 2, 29), "Estados Unidos", "/images/superman.png",
                Personaje.TipoPersonaje.HEROE, "Superman", "/images/superman.png",
                Personaje.TipoOrigen.ALIENIGENA, Personaje.TipoFranquicia.DC,
                100, 95, 65, 15
            ));

            listaPersonajes.add(new Personaje(
                "Reed Richards", calcularFechaNacimiento(1972, 10, 19), "Estados Unidos", "/images/mrfantastic.png",
                Personaje.TipoPersonaje.HEROE, "Mr. Fantastic", "/images/mrfantastic.png",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.MARVEL,
                50, 40, 100, 90
            ));

            listaPersonajes.add(new Personaje(
                "Wanda Maximoff", calcularFechaNacimiento(1989, 2, 10), "Sokovia", "/images/scarletwitch.png",
                Personaje.TipoPersonaje.HEROE, "Scarlet Witch", "/images/scarletwitch.png",
                Personaje.TipoOrigen.MUTANTE, Personaje.TipoFranquicia.MARVEL,
                85, 35, 60, 40
            ));
                    listaPersonajes.add(new Personaje(
                "Joker", calcularFechaNacimiento(1975, 4, 1), "Estados Unidos", "/images/joker.png",
                Personaje.TipoPersonaje.VILLANO, "El Guasón", "/images/joker.png",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.DC,
                40, 75, 90, 60
            ));

            listaPersonajes.add(new Personaje(
                "Victor Von Doom", calcularFechaNacimiento(1961, 7, 5), "Latveria", "/images/drdoom.png",
                Personaje.TipoPersonaje.VILLANO, "Dr. Doom", "/images/drdoom.png",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.MARVEL,
                90, 50, 95, 100
            ));

            listaPersonajes.add(new Personaje(
                "Logan", calcularFechaNacimiento(1882, 5, 12), "Canadá", "/images/wolverine.png",
                Personaje.TipoPersonaje.HEROE, "Wolverine", "/images/wolverine.png",
                Personaje.TipoOrigen.MUTANTE, Personaje.TipoFranquicia.MARVEL,
                85, 90, 40, 25
            ));

            listaPersonajes.add(new Personaje(
                "Steve Rogers", calcularFechaNacimiento(1920, 7, 4), "Estados Unidos", "/images/captainamerica.png",
                Personaje.TipoPersonaje.HEROE, "Capitán América", "/images/captainamerica.png",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.MARVEL,
                75, 80, 70, 50
            ));

            listaPersonajes.add(new Personaje(
                "Thor Odinson", calcularFechaNacimiento(965, 8, 13), "Asgard", "/images/thor.png",
                Personaje.TipoPersonaje.HEROE, "Thor", "/images/thor.png",
                Personaje.TipoOrigen.ALIENIGENA, Personaje.TipoFranquicia.MARVEL,
                90, 65, 65, 40
            ));

            listaPersonajes.add(new Personaje(
                "Harleen Quinzel", calcularFechaNacimiento(1990, 7, 20), "Estados Unidos", "/images/harleyquinn.png",
                Personaje.TipoPersonaje.ANTIHEROE, "Harley Quinn", "/images/harleyquinn.png",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.DC,
                30, 60, 85, 50
            ));

            listaPersonajes.add(new Personaje(
                "Diana Prince", calcularFechaNacimiento(3000, 3, 22), "Themyscira", "/images/wonderwoman.png",
                Personaje.TipoPersonaje.HEROE, "Mujer Maravilla", "/images/wonderwoman.png",
                Personaje.TipoOrigen.ALIENIGENA, Personaje.TipoFranquicia.DC,
                80, 80, 70, 70
            ));

            listaPersonajes.add(new Personaje(
                "Jaime Reyes", calcularFechaNacimiento(2002, 6, 29), "Estados Unidos", "/images/bluebeetle.png",
                Personaje.TipoPersonaje.HEROE, "Blue Beetle", "/images/bluebeetle.png",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.DC,
                60, 70, 75, 20
            ));

            listaPersonajes.add(new Personaje(
                "Barry Allen", calcularFechaNacimiento(1990, 3, 14), "Estados Unidos", "/images/flash.png",
                Personaje.TipoPersonaje.HEROE, "Flash", "/images/flash.png",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.DC,
                60, 100, 85, 80
            ));

            listaPersonajes.add(new Personaje(
                "Stephen Strange", calcularFechaNacimiento(1930, 11, 18), "Estados Unidos", "/images/drstrange.png",
                Personaje.TipoPersonaje.HEROE, "Dr. Strange", "/images/drstrange.png",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.MARVEL,
                60, 60, 85, 90
            ));

            listaPersonajes.add(new Personaje(
                "Johnny Storm", calcularFechaNacimiento(1986, 5, 19), "Estados Unidos", "/images/humantorch.png",
                Personaje.TipoPersonaje.HEROE, "Antorcha Humana", "/images/humantorch.png",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.MARVEL,
                80, 90, 35, 85
            ));

            listaPersonajes.add(new Personaje(
                "Bruce Banner", calcularFechaNacimiento(1969, 12, 18), "Estados Unidos", "/images/hulk.png",
                Personaje.TipoPersonaje.HEROE, "Hulk", "/images/hulk.png",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.MARVEL,
                100, 15, 60, 40
            ));

            listaPersonajes.add(new Personaje(
                "Erik Lehnsherr", calcularFechaNacimiento(1930, 5, 9), "Genosha", "/images/magneto.png",
                Personaje.TipoPersonaje.VILLANO, "Magneto", "/images/magneto.png",
                Personaje.TipoOrigen.MUTANTE, Personaje.TipoFranquicia.MARVEL,
                95, 30, 85, 90
            ));

            listaPersonajes.add(new Personaje(
                "Doomsday", calcularFechaNacimiento(2000, 1, 1), "Desconocida", "/images/doomsday.png",
                Personaje.TipoPersonaje.VILLANO, "Doomsday", "/images/doomsday.png",
                Personaje.TipoOrigen.ALIENIGENA, Personaje.TipoFranquicia.DC,
                95, 20, 30, 10
            ));
            listaPersonajes.add(new Personaje(
                "Edward Nigma", calcularFechaNacimiento(1975, 4, 1), "Estados Unidos", "/images/riddler.png",
                Personaje.TipoPersonaje.VILLANO, "El Acertijo", "/images/riddler.png",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.DC,
                2, 20, 95, 45
                ));

            listaPersonajes.add(new Personaje(
                "Peter Quill", calcularFechaNacimiento(1980, 2, 4), "Estados Unidos", "/images/starlord.png",
                Personaje.TipoPersonaje.HEROE, "Starlord", "/images/starlord.png",
                Personaje.TipoOrigen.ALIENIGENA, Personaje.TipoFranquicia.MARVEL,
                60, 80, 75, 60
            ));

            listaPersonajes.add(new Personaje(
                "Adam Warlock", calcularFechaNacimiento(2000, 1, 1), "Desconocido", "/images/adamwarlock.png",
                Personaje.TipoPersonaje.HEROE, "Adam Warlock", "/images/adamwarlock.png",
                Personaje.TipoOrigen.ALIENIGENA, Personaje.TipoFranquicia.MARVEL,
                90, 70, 90, 60
            ));

            listaPersonajes.add(new Personaje(
                "Jennifer Walters", calcularFechaNacimiento(1987, 12, 10), "Estados Unidos", "/images/shehulk.png",
                Personaje.TipoPersonaje.HEROE, "She-Hulk", "/images/shehulk.png",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.MARVEL,
                95, 40, 80, 70
            ));

            listaPersonajes.add(new Personaje(
                "Oswald Cobblepot", calcularFechaNacimiento(1970, 9, 15), "Estados Unidos", "/images/penguin.png",
                Personaje.TipoPersonaje.VILLANO, "El Pingüino", "/images/penguin.png",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.DC,
                25, 2, 70, 95
            ));

            listaPersonajes.add(new Personaje(
                "Jean Grey", calcularFechaNacimiento(1985, 11, 4), "Estados Unidos", "/images/jeangrey.png",
                Personaje.TipoPersonaje.HEROE, "Jean Grey", "/images/jeangrey.png",
                Personaje.TipoOrigen.MUTANTE, Personaje.TipoFranquicia.MARVEL,
                80, 60, 85, 60
            ));

            listaPersonajes.add(new Personaje(
                "Scott Summers", calcularFechaNacimiento(1986, 9, 15), "Estados Unidos", "/images/cyclops.png",
                Personaje.TipoPersonaje.HEROE, "Cyclops", "/images/cyclops.png",
                Personaje.TipoOrigen.MUTANTE, Personaje.TipoFranquicia.MARVEL,
                70, 60, 70, 60
            ));

            listaPersonajes.add(new Personaje(
                "Kara Zor-El", calcularFechaNacimiento(1995, 5, 15), "Estados Unidos", "/images/supergirl.png",
                Personaje.TipoPersonaje.HEROE, "SuperGirl", "/images/supergirl.png",
                Personaje.TipoOrigen.ALIENIGENA, Personaje.TipoFranquicia.DC,
                95, 90, 75, 60
            ));

            listaPersonajes.add(new Personaje(
                "Miles Morales", calcularFechaNacimiento(2002, 8, 13), "Estados Unidos", "/images/milesmorales.png",
                Personaje.TipoPersonaje.HEROE, "Spider-Man (Miles Morales)", "/images/milesmorales.png",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.MARVEL,
                90, 85, 75, 20
            ));

            listaPersonajes.add(new Personaje(
                "Susan Storm", calcularFechaNacimiento(1985, 7, 14), "Estados Unidos", "/images/invisiblewoman.png",
                Personaje.TipoPersonaje.HEROE, "La Mujer Invisible", "/images/invisiblewoman.png",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.MARVEL,
                60, 60, 80, 90
            ));

            listaPersonajes.add(new Personaje(
                "Eddie Brock", calcularFechaNacimiento(1973, 6, 18), "Estados Unidos", "/images/venom.png",
                Personaje.TipoPersonaje.VILLANO, "Venom", "/images/venom.png",
                Personaje.TipoOrigen.ALIENIGENA, Personaje.TipoFranquicia.MARVEL,
                90, 65, 60, 25
            ));

            listaPersonajes.add(new Personaje(
                "Anna Marie", calcularFechaNacimiento(1982, 4, 5), "Estados Unidos", "/images/rogue.png",
                Personaje.TipoPersonaje.HEROE, "Rogue", "/images/rogue.png",
                Personaje.TipoOrigen.MUTANTE, Personaje.TipoFranquicia.MARVEL,
                85, 60, 75, 60
            ));

            listaPersonajes.add(new Personaje(
                "Remy LeBeau", calcularFechaNacimiento(1980, 8, 20), "Estados Unidos", "/images/gambit.png",
                Personaje.TipoPersonaje.HEROE, "Gambit", "/images/gambit.png",
                Personaje.TipoOrigen.MUTANTE, Personaje.TipoFranquicia.MARVEL,
                70, 65, 80, 60
            ));

            listaPersonajes.add(new Personaje(
                "Norman Osborn", calcularFechaNacimiento(1965, 10, 10), "Estados Unidos", "/images/greengoblin.png",
                Personaje.TipoPersonaje.VILLANO, "El Duende Verde", "/images/greengoblin.png",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.MARVEL,
                88, 70, 85, 100
            ));

            listaPersonajes.add(new Personaje(
                "Ultron", calcularFechaNacimiento(2000, 1, 1), "Desconocido", "/images/ultron.png",
                Personaje.TipoPersonaje.VILLANO, "Ultron", "/images/ultron.png",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.MARVEL,
                80, 60, 100, 90
            ));

            listaPersonajes.add(new Personaje(
                "Kent Nelson", calcularFechaNacimiento(1928, 3, 21), "Estados Unidos", "/images/drfate.png",
                Personaje.TipoPersonaje.HEROE, "Dr. Fate", "/images/drfate.png",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.DC,
                85, 65, 95, 65
            ));

            listaPersonajes.add(new Personaje(
                "Natasha Romanoff", calcularFechaNacimiento(1984, 11, 22), "Rusia", "/images/blackwidow.png",
                Personaje.TipoPersonaje.HEROE, "Black Widow", "/images/blackwidow.png",
                Personaje.TipoOrigen.META_HUMANO, Personaje.TipoFranquicia.MARVEL,
                65, 80, 85, 70
            ));
            guardarPersonajes();
        }
    }
}