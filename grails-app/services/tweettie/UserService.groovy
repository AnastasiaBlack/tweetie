package tweettie

import grails.plugin.springsecurity.SpringSecurityService
import grails.transaction.Transactional
import twee.User

@Transactional
class UserService {
    SpringSecurityService springSecurityService

    def followUser(User userToFollow, User currentUser) {
        currentUser.followedUsers << userToFollow
    }

    def showFollowedByCurrentUser(User currentUser) {
        currentUser.followedUsers
    }

    def findFriends(User currentUser) {
        Long userId = currentUser.id
        User.findAllByIdNotEqual(userId)
    }
}
