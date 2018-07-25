package tweettie

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import twee.Quote
import twee.User

class QuoteController {

    static scaffold = Quote
    static defaultAction = "home"
    def quoteService
    SpringSecurityService springSecurityService


    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def home() {
        User user = springSecurityService.currentUser;
        List quotes = user.followedUsers.collect { followedUser -> Quote.findAllWhere(author: followedUser) }.flatten()
                .sort { a, b -> (a as Quote).created == (b as Quote).created ? 0 : (a as Quote).created > (b as Quote).created ? 1 : -1 }
        [quotes: quotes]
    }


    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def random() {
        Quote randomQuote = quoteService.getRandomQuote()
        [quote: randomQuote]
    }

    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def ajaxRandom() {
        def randomQuote = quoteService.getRandomQuote()
        render {
            q(randomQuote.content)
            p(randomQuote.author)
        }
    }

    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def postMessage() {
        def author = springSecurityService.getCurrentUser()
        String content = params.content
        Quote freshQuote = quoteService.postQuote(content, author)
        freshQuote.save()
        redirect(action: "quoteEditor")
        // [quote: freshQuote]
    }

    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def quoteEditor() {
        User user = springSecurityService.currentUser
        List<?> myQuotes = Quote.findAllWhere(author: user)
        List quotes = user.followedUsers.collect { followedUser -> Quote.findAllWhere(author: followedUser) }.flatten()
        List overAll = (myQuotes + quotes).sort { a, b ->
            (a as Quote).created == (b as Quote).created ? 0 : (a as Quote).created > (b as Quote).created ? 1 : -1
        }.reverse()
        [quotes: overAll]
    }

}
