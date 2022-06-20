package nhat.nha.usermanager1.Repo

import nhat.nha.usermanager1.Model.User
import org.springframework.data.repository.CrudRepository


interface UserRepo : CrudRepository<User, Int> {
    fun findByName(name: String?): Iterable<User>
    fun getById(id: Int): User?
}