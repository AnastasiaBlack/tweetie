package tweettie

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import grails.plugin.springsecurity.annotation.Secured
import groovy.json.*
import twee.User


class UserController {
    static scaffold = User


    def index() {}

    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def allUsers() {
        def users = User.findAll()

        GsonBuilder builder = new GsonBuilder()
        builder.excludeFieldsWithoutExposeAnnotation()
        Gson gson = builder.create()
        String jsonString = gson.toJson(users)

        render jsonString
    }
}
