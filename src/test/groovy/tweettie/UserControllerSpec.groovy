package tweettie

import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import twee.User

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UserController)
@Mock([User, SpringSecurityService])
class UserControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test follow user action redirects to home"() {
        setup:
        controller.params.id = 1
        User user = new User(username: "me", password: "gejghe").save(false)

        when:
        def result = controller.singleUser()

        then:
        result.user == user
    }

}
