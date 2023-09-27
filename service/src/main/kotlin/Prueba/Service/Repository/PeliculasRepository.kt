package Prueba.Service.Repository

import Prueba.Service.Models.Pelicula_Entity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface PeliculasRepository : CrudRepository<Pelicula_Entity,Int> {



}