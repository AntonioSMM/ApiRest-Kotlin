package Prueba.Service.Services

import Prueba.Service.Models.Pelicula_Entity
import Prueba.Service.Repository.PeliculasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import java.lang.Exception
import kotlin.jvm.optionals.getOrNull


@Service
class PeliculasServices(val peliculasRepository: PeliculasRepository) {


    //Obtener todas
    fun getAll() : List<Pelicula_Entity> {

       return peliculasRepository.findAll().toList();
    }


    //Obtener por Id
    fun getById(id : Int) : Pelicula_Entity? {

        return peliculasRepository.findById(id).getOrNull()
    }


    //Crear nueva pelicula
    fun postPelicula(pelicula : Pelicula_Entity):Pelicula_Entity{

        peliculasRepository.save(pelicula)
        return pelicula
    }


    //Borrar pelicula por Id
    fun delPelicula (id:Int):String {

        if(peliculasRepository.findById(id).isPresent){
            peliculasRepository.deleteById(id)
            return "la pelicula con id: $id fue eliminada"
        }else {
            return "la pelicula con id: $id no se puedo eliminar o no existe"
        }
    }


    //Actualizar pelicula dependiendo de cuantos campos se ingresen
    fun updatePelicula (pelicula : Pelicula_Entity):Pelicula_Entity {

        var peliculaAux : Pelicula_Entity = peliculasRepository.findById(pelicula.id as Int).get()

        if(pelicula.nombre != null) {
            peliculaAux.nombre = pelicula.nombre
        }

        if(pelicula.disponible != null) {
            peliculaAux.disponible = pelicula.disponible
        }

        if(pelicula.director != null) {
            peliculaAux.director = pelicula.director
        }

        if(pelicula.duracion != null) {
            peliculaAux.duracion = pelicula.duracion
        }

        peliculasRepository.save(peliculaAux)

        return peliculaAux

    }


}