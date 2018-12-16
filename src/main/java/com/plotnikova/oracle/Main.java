package com.plotnikova.oracle;

//import sun.odbc.JdbcOdbcDriver;
import com.plotnikova.oracle.entities.GuestsEntity;
import org.hibernate.cfg.Configuration;

import java.util.List;



class Main {

    private static Configuration dbConfiguration;


    public static void main(String[] args) {

        DatabaseManager manager = new DatabaseManager();

        printGuests(manager);

        // Заселяем нового гостя
        GuestsEntity guest = new GuestsEntity();
        guest.setFirstName("Petr");
        guest.setLastName("Ivanov");
        guest.setGender("Male");
        guest.setDateBirth( TimeUtil.time("04-02-1980") );

        manager.saveEntity(guest);

        // Меняем фамилию у гостя
        guest.setLastName("Voronov");
        manager.updateEntity(guest);

        //Выселяем гостя
        manager.deleteEntity(guest);

        printGuests(manager);
    }

    private static void printGuests(DatabaseManager manager) {
        System.out.println("Guests: ");
        List<GuestsEntity> guests = manager.loadEntities(GuestsEntity.class);
        for (GuestsEntity guest : guests) {
            System.out.println(guest.getFirstName() + " " + guest.getLastName());
        }
        System.out.println("=================");
    }
}