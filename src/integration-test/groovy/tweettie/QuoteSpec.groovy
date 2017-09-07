package tweettie

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*
import twee.Quote
import twee.User

@Integration
@Rollback
@TestFor(QuoteService)
@Mock([User, Quote])
class QuoteSpec extends Specification {
    @Shared
    int initCount

    def setup() {

    }

    def cleanup() {
    }

    void "test Quote is saved"() {
        when:
        initCount = Quote.count()
        def user = new User(username: "Keith", password: "keith").save(false)
        new Quote(author: user, content: "It is pretty cold in Canada, eh?").save(false)
        then: "count increased by one"
        Quote.count() == initCount + 1
    }

    void "test Random quote is generated"() {
        given:
        String randomQuote = service.getRandomQuote()
        String staticQuote = service.staticQuote

        if (Quote.count() != null) {
            expect: "Random quote is generated"
            randomQuote != staticQuote
        } else {
            expect: "Static quote is returned"
            service.getStaticQuote().content == "We are all insane here."
        }
    }
}
