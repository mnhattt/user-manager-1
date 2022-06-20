package nhat.nha.usermanager1.Controller

import nhat.nha.usermanager1.Model.User
import nhat.nha.usermanager1.Repo.UserRepo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

data class DemoData(val id: Int, val name: String)

@RestController
class Demo(private val repository: UserRepo) {
    @GetMapping("/demo")
    fun demo(): DemoData {
        return DemoData(1111, "23223")
    }

    @GetMapping("/users")
    fun getUser(@RequestParam(value = "name") name: String?): Iterable<User> {
        if (name != null) {
            return repository.findByName(name)
        }
        return repository.findAll()
    }

    @PostMapping("/users")
    fun createUser(@RequestBody user: User): User {
        return repository.save(user)
    }

    @GetMapping("/users/{userId}")
    fun getUserbyId(@PathVariable userId: Int) = repository.getById(userId)
}