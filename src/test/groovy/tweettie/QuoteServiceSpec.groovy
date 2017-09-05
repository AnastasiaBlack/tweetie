package tweettie

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(QuoteService)
class QuoteServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "get static quote always returns alice insane quote"() {
        expect:
        service.getStaticQuote().content == "We are all insane here."
    }
}
