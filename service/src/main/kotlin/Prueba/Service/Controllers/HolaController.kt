package Prueba.Service.Controllers


import Prueba.Service.Exceptions.NoPeliculaException
import Prueba.Service.Models.Pelicula_Entity
import Prueba.Service.Repository.PeliculasRepository
import Prueba.Service.Services.PeliculasServices
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/peliculas")
class HolaController(val peliculasServices: PeliculasServices) {


    //obtener todas las pelicuas
    @GetMapping("/todas")
    fun getAll() : List<Pelicula_Entity> {

        return peliculasServices.getAll()
    }


    //Obtener pelicula por Id
    @GetMapping("/{id}")
    fun getById(@PathVariable id : Int) : ResponseEntity<*>{


        var pelicula = peliculasServices.getById(id)

        if(pelicula == null) {
            throw NoPeliculaException("No se encontró el id de la pelicula")
        }else {

            return ResponseEntity(pelicula,HttpStatus.OK)
        }


    }


    //Crear nueva pelicula
    @PostMapping("/nueva")
    fun postPelicula(@Valid @RequestBody pelicula : Pelicula_Entity):Pelicula_Entity{

        return peliculasServices.postPelicula(pelicula)
    }


    //Borrar pelicula por Id
    @DeleteMapping("/{id}")
    fun delPelicula (@PathVariable id:Int):String {
        return peliculasServices.delPelicula(id)
    }



    //Actualizar pelicula
    @PutMapping("/update")
    fun putPelicula (@RequestBody pelicula:Pelicula_Entity) : Pelicula_Entity? {

        try {
            return peliculasServices.updatePelicula(pelicula)

        } catch (e:Exception) {
            throw NoPeliculaException("No se encontró el id de la pelicula")
        }

    }

}


