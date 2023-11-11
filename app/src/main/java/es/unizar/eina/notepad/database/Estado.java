package es.unizar.eina.notepad.database.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Estado")
public class Estado {
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "Nombre")
    @NonNull
    private String nombre;

    public void Estado(String nombre){this.nombre = nombre;}

    public String getNombre(){return this.nombre;}

    public void setNombre(String nombre){this.nombre = nombre;}
}
