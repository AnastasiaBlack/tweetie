package tweettie

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Shared
import spock.lang.Specification
import twee.Quote
import twee.User

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(QuoteController)
@Mock([Quote, QuoteService])
class QuoteControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test random quote"() {
        given:
        controller.quoteService = Mock(QuoteService)

        when:
        controller.random()

        then:
        1 * controller.quoteService.getRandomQuote()
    }
}
