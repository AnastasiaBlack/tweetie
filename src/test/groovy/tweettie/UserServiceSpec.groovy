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

        then:
        service.followUser(userToFollow, currentUser).size() - startFollowedUsersCount == 1

        where:
        a | _
        0 | _
    }

    void "Show users followed by the current user"() {
        given:
        User followedUser1 = new User(username: "user1", password: "33")
        User followedUser2 = new User(username: "user2", password: "344")
        User followedUser3 = new User(username: "user3", password: "2155")

        def followee = [followedUser1, followedUser2, followedUser3]

        User currentUser = new User(username: "Me", password: "me123534gf", followedUsers: followee)

        expect:
        service.showFollowedByCurrentUser(currentUser).size() == followee.size()
    }

    void "test that all users are returned except for the loggedIn user"() {
        setup:
        User currentUser = new User(username: "me", password: "gejghe").save(false)
        User user1 = new User(username: "he", password: "reee").save(false)
        def users = [user1]

        when:
        def result = service.findFriends(currentUser)

        then:
        result == users
    }
}
