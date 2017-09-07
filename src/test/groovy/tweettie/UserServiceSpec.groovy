package tweettie

import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Shared
import spock.lang.Specification
import twee.User

import javax.rmi.CORBA.Stub

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(UserService)
@Mock([User, SpringSecurityService])
class UserServiceSpec extends Specification {
    @Shared
    User currentUser


    def setup() {
        List followee = new ArrayList()
        currentUser = new User(username: "Harry", password: "harry123", followedUsers: followee)
    }

    def cleanup() {
    }

    void "followed users count increases when a user follows another user"() {
        when:
        int startFollowedUsersCount = a
        User userToFollow = new User(username: "alice", password: "ssleh3n3lq")
//        service.followUser(userToFollow, currentUser)

        then:
        service.followUser(userToFollow, currentUser).size() - startFollowedUsersCount == 1

        where:
        a | _
        0 | _
    }
}
