package tweettie

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Shared
import spock.lang.Specification
import twee.Quote
import twee.User

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(QuoteService)
@Mock([User, Quote])
class QuoteServiceSpec extends Specification {
    @Shared
    User user

    def setup() {
        user = new User(username: "Masha", password: "masha")
    }

    def cleanup() {
    }

    void "get static quote always returns alice insane quote"() {
        expect:
        service.getStaticQuote().content == "We are all insane here."
    }

    void "get a newly created quote when postQuote is executed"() {
        when:
        String content = "I am Alice"

        Quote currentQuote = service.postQuote(content, user)

        then:
        currentQuote.content == "I am Alice"
    }

    void "get static quote if db is empty when we try to get a random quote"() {
        when:
        Quote.count() == 0

        then:
        service.getRandomQuote().content == service.staticQuote.content
    }

    void "get random quote which is not equal to static if db is not empty"() {
        when:
        new Quote(author: user, content: "Some content of the quote").save(false)

        then:
        service.getRandomQuote().content != service.staticQuote.content
    }

}
