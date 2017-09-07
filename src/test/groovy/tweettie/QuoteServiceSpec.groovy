package tweettie

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import twee.Quote
import twee.User

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(QuoteService)
@Mock([User, Quote])
class QuoteServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "get static quote always returns alice insane quote"() {
        expect:
        service.getStaticQuote().content == "We are all insane here."
    }

    void "get a newly created quote when postQuote is executed"(){
        when:
        String content = "I am Alice"
        User user = new User(username: "Masha", password: "masha")
        Quote currentQuote = service.postQuote(content, user)

        then:
        currentQuote.content=="I am Alice"
    }
}
