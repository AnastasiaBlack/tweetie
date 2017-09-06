package tweettie

import grails.plugin.springsecurity.SpringSecurityService
import grails.transaction.Transactional
import twee.User

@Transactional
class UserService {
    SpringSecurityService springSecurityService

    def followUser(User userToFollow) {
        User currentUser = springSecurityService.getCurrentUser()
        currentUser.followedUsers<<userToFollow
    }
}
