package controllers
class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller:"user", action: "home")//view:"/index")

        "400"(controller: "error", action: "invalid")
        "500"(controller: "error", action: "denied")
        "403"(controller: "error", action: "denied")
        "404"(controller: "error", action: "notFound")

        "/login/auth"(controller: "user", action:"register")
        "/login/$action?"(controller: "login")
        "/logout/$action?"(controller: "logout")
    }
}
