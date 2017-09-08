package tweettie

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
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

    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def allUsers() {
        User currentUser = springSecurityService.getCurrentUser()
        def users = userService.findFriends(currentUser)
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
        User currentUser = springSecurityService.getCurrentUser()
        User userToFollow = User.get(params.id)
        userService.followUser(userToFollow, currentUser)
        redirect(action: "home")
//        render(currentUser as JSON)
    }

    def register() {
        if (request.method == "POST") {
            def user = new User(params)
            if (user.validate()) {
                user.save()
                flash.message = "Successfully Created User"
                springSecurityService.reauthenticate(user.username, user.password)
                redirect(uri: '/')
            } else {
                flash.message = "Error Registering User"
                return [user: user]
            }
        }
    }


}
