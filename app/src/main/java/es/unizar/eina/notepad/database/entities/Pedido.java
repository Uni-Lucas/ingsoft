package es.unizar.eina.notepad.database.entities;

import static androidx.room.ForeignKey.CASCADE;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;
@Entity(tableName = "Pedido",
        foreignKeys = @ForeignKey(entity = Estado.class,
                parentColumns = "Nombre",
                childColumns = "Estado",
                onDelete = CASCADE),
        indices ={@Index("Estado")}
)
public class Pedido {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    private int id;
    @NonNull
    @ColumnInfo(name = "FechaHora")
    private String fechaHora;
    @NonNull
    @ColumnInfo(name = "Precio")
    private Double precio;
    @NonNull
    @ColumnInfo(name = "NombreCliente")
    private String nombreCliente;
    @NonNull
    @ColumnInfo(name = "MovilCliente")
    private String movilCliente;
    @ColumnInfo(name = "Estado")
    private String estado;

    public Pedido(int id, @NonNull String fechaHora, @NonNull Double precio, @NonNull String nombreCliente, @NonNull String movilCliente, String estado) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.precio = precio;
        this.nombreCliente = nombreCliente;
        this.movilCliente = movilCliente;
        this.estado = estado;
    }

    public void setId(int id){this.id = id;}

    public void setFechaHora(@NonNull String fechaHora){this.fechaHora = fechaHora;}

    public void setPrecio(@NonNull Double precio){this.precio = precio;}

    public void setNombreCliente(@NonNull String nombreCliente){this.nombreCliente = nombreCliente;}

    public void setMovilCliente(@NonNull String movilCliente){this.movilCliente = movilCliente;}

    public void setEstado(String estado){this.estado = estado;}

    public int getId(){return this.id;}
    @NonNull
    public String getFechaHora(){return this.fechaHora;}

    @NonNull
    public Double getPrecio(){return this.precio;}

    @NonNull
    public String getNombreCliente(){return this.nombreCliente;}

    @NonNull
    public String getMovilCliente(){return this.movilCliente;}

    public String getEstado(){return this.estado;}


}
