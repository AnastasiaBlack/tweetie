package tweettie

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import grails.converters.JSON
import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import groovy.json.*
import twee.Quote
import twee.User


class UserController {
    static scaffold = User
    def userService
    SpringSecurityService springSecurityService


    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def home() {
        List quotes = Quote.all
        [quotes: quotes]
    }

//    def index() {}

    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def allUsers() {
        long currentUserId = springSecurityService.getCurrentUserId()
        def users = User.findAllByIdNotEqual(currentUserId)

//        GsonBuilder builder = new GsonBuilder()
//        builder.excludeFieldsWithoutExposeAnnotation()
//        Gson gson = builder.create()
//        String jsonString = gson.toJson(users)
        [users: users]
    }

    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def singleUser() {
        def user = User.findById(params.id)
        [user: user]
    }

    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def follow() {
        User userToFollow = User.get(params.id)
        userService.followUser(userToFollow)
        User currentUser = springSecurityService.getCurrentUser()
        redirect(action: "home")
//        render(currentUser as JSON)
    }

    def register() {
        if (request.method == "POST") {
            def user = new User(params)
            if (user.validate()) {
                user.save()
                flash.message = "Successfully Created User"
                redirect(uri: '/')
            } else {
                flash.message = "Error Registering User"
                return [user: user]
            }
        }
    }


}
