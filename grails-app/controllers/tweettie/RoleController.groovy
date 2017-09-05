package tweettie

import grails.plugin.springsecurity.annotation.Secured
import twee.Role

class RoleController {
    static scaffold = Role

    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def index() { }
}
