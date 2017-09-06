package tweettie

import grails.converters.JSON
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
        List myQuotes = Quote.all
        [myQuotes: myQuotes]
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
        [quote: freshQuote]
    }

    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def quoteEditor() {
    }

}
