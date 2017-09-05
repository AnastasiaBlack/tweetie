package tweettie

import grails.plugin.springsecurity.annotation.Secured
import twee.Quote

class QuoteController {

    static scaffold = Quote
    static defaultAction = "home"
    def quoteService


    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def home() {
        def staticAuthor = "Me"
        def staticContent = "Practice makes Perfect:)"
        [author: staticAuthor, content: staticContent]
    }


    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def random() {
        Quote randomQuote = quoteService.getRandomQuote()
        [quote: randomQuote]
    }

    @Secured(['IS_AUTHENTICATED_REMEMBERED'])
    def ajaxRandom(){
        def randomQuote = quoteService.getRandomQuote()
        render{
            q(randomQuote.content)
            p(randomQuote.author)
        }
    }
}
