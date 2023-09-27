package Prueba.Service.Models


import org.jetbrains.annotations.NotNull
import jakarta.persistence.*


@Entity
@Table(name = "pelicula")
data class Pelicula_Entity(
                    @Id
                    @GeneratedValue(strategy = GenerationType.AUTO)
                    var id : Int?=0,
                    @get:jakarta.validation.constraints.NotNull(message = "el nombre no debe ser nulo")
                    var nombre : String?=null,
                    @get:jakarta.validation.constraints.NotNull(message = "el director no debe ser nulo")
                    var director : String?=null,
                    @get:jakarta.validation.constraints.NotNull(message = "La duracion no debe ser nulo")
                    var duracion : Double?=null,
                    @get:jakarta.validation.constraints.NotNull(message = "Disponible no debe ser nulo")
                    var disponible : Boolean?=true) {
}